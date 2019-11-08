package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    private static final GifDecoderFactory GIF_DECODER_FACTORY = new GifDecoderFactory();
    private static final GifHeaderParserPool PARSER_POOL = new GifHeaderParserPool();
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final GifDecoderFactory gifDecoderFactory;
    private final GifHeaderParserPool parserPool;
    private final List<ImageHeaderParser> parsers;
    private final GifBitmapProvider provider;

    @VisibleForTesting
    static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        /* access modifiers changed from: 0000 */
        public GifDecoder build(BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i);
        }
    }

    @VisibleForTesting
    static class GifHeaderParserPool {
        private final Queue<GifHeaderParser> pool = Util.createQueue(0);

        GifHeaderParserPool() {
        }

        /* access modifiers changed from: 0000 */
        public synchronized GifHeaderParser obtain(ByteBuffer byteBuffer) {
            GifHeaderParser gifHeaderParser;
            gifHeaderParser = (GifHeaderParser) this.pool.poll();
            if (gifHeaderParser == null) {
                gifHeaderParser = new GifHeaderParser();
            }
            return gifHeaderParser.setData(byteBuffer);
        }

        /* access modifiers changed from: 0000 */
        public synchronized void release(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context2) {
        this(context2, Glide.get(context2).getRegistry().getImageHeaderParsers(), Glide.get(context2).getBitmapPool(), Glide.get(context2).getArrayPool());
    }

    public ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context2, list, bitmapPool, arrayPool, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    @VisibleForTesting
    ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory2) {
        this.context = context2.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = gifDecoderFactory2;
        this.provider = new GifBitmapProvider(bitmapPool, arrayPool);
        this.parserPool = gifHeaderParserPool;
    }

    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        return !((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.parsers, byteBuffer) == ImageType.GIF;
    }

    public GifDrawableResource decode(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Options options) {
        GifHeaderParser obtain = this.parserPool.obtain(byteBuffer);
        try {
            GifDrawableResource decode = decode(byteBuffer, i, i2, obtain, options);
            return decode;
        } finally {
            this.parserPool.release(obtain);
        }
    }

    @Nullable
    private GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        String str = "Decoded GIF from stream in ";
        String str2 = TAG;
        long logTime = LogTime.getLogTime();
        try {
            GifHeader parseHeader = gifHeaderParser.parseHeader();
            if (parseHeader.getNumFrames() > 0) {
                if (parseHeader.getStatus() == 0) {
                    Config config = options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565 ? Config.RGB_565 : Config.ARGB_8888;
                    GifDecoder build = this.gifDecoderFactory.build(this.provider, parseHeader, byteBuffer, getSampleSize(parseHeader, i, i2));
                    build.setDefaultBitmapConfig(config);
                    build.advance();
                    Bitmap nextFrame = build.getNextFrame();
                    if (nextFrame == null) {
                        if (Log.isLoggable(str2, 2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(LogTime.getElapsedMillis(logTime));
                            sb.toString();
                        }
                        return null;
                    }
                    GifDrawable gifDrawable = new GifDrawable(this.context, build, UnitTransformation.get(), i, i2, nextFrame);
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(gifDrawable);
                    if (Log.isLoggable(str2, 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(LogTime.getElapsedMillis(logTime));
                        sb2.toString();
                    }
                    return gifDrawableResource;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable(str2, 2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(LogTime.getElapsedMillis(logTime));
                sb3.toString();
            }
        }
    }

    private static int getSampleSize(GifHeader gifHeader, int i, int i2) {
        int i3;
        int min = Math.min(gifHeader.getHeight() / i2, gifHeader.getWidth() / i);
        if (min == 0) {
            i3 = 0;
        } else {
            i3 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i3);
        if (Log.isLoggable(TAG, 2) && max > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Downsampling GIF, sampleSize: ");
            sb.append(max);
            sb.append(", target dimens: [");
            sb.append(i);
            String str = "x";
            sb.append(str);
            sb.append(i2);
            sb.append("], actual dimens: [");
            sb.append(gifHeader.getWidth());
            sb.append(str);
            sb.append(gifHeader.getHeight());
            sb.append("]");
            sb.toString();
        }
        return max;
    }
}
