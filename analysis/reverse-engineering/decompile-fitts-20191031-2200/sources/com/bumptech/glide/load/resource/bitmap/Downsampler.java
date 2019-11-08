package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
    private static final DecodeCallbacks EMPTY_CALLBACKS = new DecodeCallbacks() {
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        public void onObtainBounds() {
        }
    };
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final int MARK_POSITION = 10485760;
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{WBMP_MIME_TYPE, ICO_MIME_TYPE})));
    private static final Queue<Options> OPTIONS_QUEUE = Util.createQueue(0);
    static final String TAG = "Downsampler";
    private static final Set<ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageType.JPEG, ImageType.PNG_A, ImageType.PNG));
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    static {
        Boolean valueOf = Boolean.valueOf(false);
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", valueOf);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", valueOf);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics2, BitmapPool bitmapPool2, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics2);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, com.bumptech.glide.load.Options options) throws IOException {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, com.bumptech.glide.load.Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        com.bumptech.glide.load.Options options2 = options;
        Preconditions.checkArgument(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(inputStream, defaultOptions, (DownsampleStrategy) options2.get(DownsampleStrategy.OPTION), (DecodeFormat) options2.get(DECODE_FORMAT), options2.get(ALLOW_HARDWARE_CONFIG) != null && ((Boolean) options2.get(ALLOW_HARDWARE_CONFIG)).booleanValue(), i, i2, ((Boolean) options2.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue(), decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
        }
    }

    private Bitmap decodeFromWrappedStreams(InputStream inputStream, Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, DecodeCallbacks decodeCallbacks) throws IOException {
        Downsampler downsampler;
        int i3;
        int i4;
        int i5;
        InputStream inputStream2 = inputStream;
        Options options2 = options;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(inputStream2, options2, decodeCallbacks2, this.bitmapPool);
        boolean z3 = false;
        int i6 = dimensions[0];
        int i7 = dimensions[1];
        String str = options2.outMimeType;
        boolean z4 = (i6 == -1 || i7 == -1) ? false : z;
        int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream2, this.byteArrayPool);
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(orientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(orientation);
        int i8 = i;
        int i9 = i2;
        int i10 = i8 == Integer.MIN_VALUE ? i6 : i8;
        int i11 = i9 == Integer.MIN_VALUE ? i7 : i9;
        ImageType type = ImageHeaderParserUtils.getType(this.parsers, inputStream2, this.byteArrayPool);
        BitmapPool bitmapPool2 = this.bitmapPool;
        ImageType imageType = type;
        calculateScaling(type, inputStream, decodeCallbacks, bitmapPool2, downsampleStrategy, exifOrientationDegrees, i6, i7, i10, i11, options);
        int i12 = orientation;
        String str2 = str;
        int i13 = i7;
        int i14 = i6;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        Options options3 = options2;
        calculateConfig(inputStream, decodeFormat, z4, isExifOrientationRequired, options, i10, i11);
        if (VERSION.SDK_INT >= 19) {
            z3 = true;
        }
        int i15 = options3.inSampleSize;
        String str3 = TAG;
        if (i15 == 1 || z3) {
            downsampler = this;
            if (downsampler.shouldUsePool(imageType)) {
                if (i14 < 0 || i13 < 0 || !z2 || !z3) {
                    float f = isScaling(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int i16 = options3.inSampleSize;
                    float f2 = (float) i16;
                    int ceil = (int) Math.ceil((double) (((float) i14) / f2));
                    int ceil2 = (int) Math.ceil((double) (((float) i13) / f2));
                    i5 = Math.round(((float) ceil) * f);
                    i4 = Math.round(((float) ceil2) * f);
                    if (Log.isLoggable(str3, 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Calculated target [");
                        sb.append(i5);
                        String str4 = "x";
                        sb.append(str4);
                        sb.append(i4);
                        sb.append("] for source [");
                        sb.append(i14);
                        sb.append(str4);
                        sb.append(i13);
                        sb.append("], sampleSize: ");
                        sb.append(i16);
                        sb.append(", targetDensity: ");
                        sb.append(options3.inTargetDensity);
                        sb.append(", density: ");
                        sb.append(options3.inDensity);
                        sb.append(", density multiplier: ");
                        sb.append(f);
                        sb.toString();
                    }
                } else {
                    i5 = i10;
                    i4 = i11;
                }
                if (i5 > 0 && i4 > 0) {
                    setInBitmap(options3, downsampler.bitmapPool, i5, i4);
                }
            }
        } else {
            downsampler = this;
        }
        Bitmap decodeStream = decodeStream(inputStream, options3, decodeCallbacks3, downsampler.bitmapPool);
        decodeCallbacks3.onDecodeComplete(downsampler.bitmapPool, decodeStream);
        if (Log.isLoggable(str3, 2)) {
            i3 = i12;
            logDecode(i14, i13, str2, options, decodeStream, i, i2, logTime);
        } else {
            i3 = i12;
        }
        Bitmap bitmap = null;
        if (decodeStream != null) {
            decodeStream.setDensity(downsampler.displayMetrics.densityDpi);
            bitmap = TransformationUtils.rotateImageExif(downsampler.bitmapPool, decodeStream, i3);
            if (!decodeStream.equals(bitmap)) {
                downsampler.bitmapPool.put(decodeStream);
            }
        }
        return bitmap;
    }

    private static void calculateScaling(ImageType imageType, InputStream inputStream, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, Options options) throws IOException {
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        double d;
        ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        Options options2 = options;
        String str = "]";
        String str2 = TAG;
        String str3 = "x";
        if (i11 <= 0 || i12 <= 0) {
            String str4 = str3;
            if (Log.isLoggable(str2, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to determine dimensions for: ");
                sb.append(imageType2);
                sb.append(" with target [");
                sb.append(i13);
                sb.append(str4);
                sb.append(i14);
                sb.append(str);
                sb.toString();
            }
            return;
        }
        if (i10 == 90 || i10 == 270) {
            f = downsampleStrategy2.getScaleFactor(i12, i11, i13, i14);
        } else {
            f = downsampleStrategy2.getScaleFactor(i11, i12, i13, i14);
        }
        String str5 = "], target: [";
        if (f > 0.0f) {
            SampleSizeRounding sampleSizeRounding = downsampleStrategy2.getSampleSizeRounding(i11, i12, i13, i14);
            if (sampleSizeRounding != null) {
                float f2 = (float) i11;
                float f3 = (float) i12;
                String str6 = str2;
                String str7 = str3;
                int round = i11 / round((double) (f * f2));
                int round2 = i12 / round((double) (f * f3));
                if (sampleSizeRounding == SampleSizeRounding.MEMORY) {
                    i6 = Math.max(round, round2);
                } else {
                    i6 = Math.min(round, round2);
                }
                if (VERSION.SDK_INT > 23 || !NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options2.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(i6));
                    i7 = (sampleSizeRounding != SampleSizeRounding.MEMORY || ((float) max) >= 1.0f / f) ? max : max << 1;
                } else {
                    i7 = 1;
                }
                options2.inSampleSize = i7;
                if (imageType2 == ImageType.JPEG) {
                    float min = (float) Math.min(i7, 8);
                    i8 = (int) Math.ceil((double) (f2 / min));
                    i9 = (int) Math.ceil((double) (f3 / min));
                    int i15 = i7 / 8;
                    if (i15 > 0) {
                        i8 /= i15;
                        i9 /= i15;
                    }
                } else {
                    if (imageType2 == ImageType.PNG || imageType2 == ImageType.PNG_A) {
                        float f4 = (float) i7;
                        i8 = (int) Math.floor((double) (f2 / f4));
                        d = Math.floor((double) (f3 / f4));
                    } else if (imageType2 == ImageType.WEBP || imageType2 == ImageType.WEBP_A) {
                        if (VERSION.SDK_INT >= 24) {
                            float f5 = (float) i7;
                            i8 = Math.round(f2 / f5);
                            i9 = Math.round(f3 / f5);
                        } else {
                            float f6 = (float) i7;
                            i8 = (int) Math.floor((double) (f2 / f6));
                            d = Math.floor((double) (f3 / f6));
                        }
                    } else if (i11 % i7 == 0 && i12 % i7 == 0) {
                        i8 = i11 / i7;
                        i9 = i12 / i7;
                    } else {
                        int[] dimensions = getDimensions(inputStream, options2, decodeCallbacks, bitmapPool2);
                        int i16 = dimensions[0];
                        i9 = dimensions[1];
                        i8 = i16;
                    }
                    i9 = (int) d;
                }
                double scaleFactor = (double) downsampleStrategy2.getScaleFactor(i8, i9, i13, i14);
                if (VERSION.SDK_INT >= 19) {
                    options2.inTargetDensity = adjustTargetDensityForError(scaleFactor);
                    options2.inDensity = getDensityMultiplier(scaleFactor);
                }
                if (isScaling(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                if (Log.isLoggable(str6, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calculate scaling, source: [");
                    sb2.append(i11);
                    String str8 = str7;
                    sb2.append(str8);
                    sb2.append(i12);
                    sb2.append(str5);
                    sb2.append(i13);
                    sb2.append(str8);
                    sb2.append(i14);
                    sb2.append("], power of two scaled: [");
                    sb2.append(i8);
                    sb2.append(str8);
                    sb2.append(i9);
                    sb2.append("], exact scale factor: ");
                    sb2.append(f);
                    sb2.append(", power of 2 sample size: ");
                    sb2.append(i7);
                    sb2.append(", adjusted scale factor: ");
                    sb2.append(scaleFactor);
                    sb2.append(", target density: ");
                    sb2.append(options2.inTargetDensity);
                    sb2.append(", density: ");
                    sb2.append(options2.inDensity);
                    sb2.toString();
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        String str9 = str3;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Cannot scale with factor: ");
        sb3.append(f);
        sb3.append(" from: ");
        sb3.append(downsampleStrategy2);
        sb3.append(", source: [");
        sb3.append(i11);
        sb3.append(str9);
        sb3.append(i12);
        sb3.append(str5);
        sb3.append(i13);
        sb3.append(str9);
        sb3.append(i14);
        sb3.append(str);
        throw new IllegalArgumentException(sb3.toString());
    }

    private static int adjustTargetDensityForError(double d) {
        int densityMultiplier = getDensityMultiplier(d);
        double d2 = (double) densityMultiplier;
        Double.isNaN(d2);
        int round = round(d2 * d);
        double d3 = (double) (((float) round) / ((float) densityMultiplier));
        Double.isNaN(d3);
        double d4 = d / d3;
        double d5 = (double) round;
        Double.isNaN(d5);
        return round(d4 * d5);
    }

    private static int getDensityMultiplier(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private boolean shouldUsePool(ImageType imageType) {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return TYPES_THAT_USE_POOL_PRE_KITKAT.contains(imageType);
    }

    private void calculateConfig(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, Options options, int i, int i2) {
        if (!this.hardwareConfigState.setHardwareConfigIfAllowed(i, i2, options, decodeFormat, z, z2)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool).hasAlpha();
            } catch (IOException unused) {
                if (Log.isLoggable(TAG, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot determine whether the image has alpha or not from header, format ");
                    sb.append(decodeFormat);
                    sb.toString();
                }
            }
            options.inPreferredConfig = z3 ? Config.ARGB_8888 : Config.RGB_565;
            if (options.inPreferredConfig == Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    private static int[] getDimensions(InputStream inputStream, Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(inputStream, options, decodeCallbacks, bitmapPool2);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeStream(java.io.InputStream r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            boolean r0 = r6.inJustDecodeBounds
            if (r0 == 0) goto L_0x000a
            r0 = 10485760(0xa00000, float:1.469368E-38)
            r5.mark(r0)
            goto L_0x000d
        L_0x000a:
            r7.onObtainBounds()
        L_0x000d:
            int r0 = r6.outWidth
            int r1 = r6.outHeight
            java.lang.String r2 = r6.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r3.lock()
            r3 = 0
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r5, r3, r6)     // Catch:{ IllegalArgumentException -> 0x0030 }
            java.util.concurrent.locks.Lock r8 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r8.unlock()
            boolean r6 = r6.inJustDecodeBounds
            if (r6 == 0) goto L_0x002d
            r5.reset()
        L_0x002d:
            return r7
        L_0x002e:
            r5 = move-exception
            goto L_0x0058
        L_0x0030:
            r4 = move-exception
            java.io.IOException r0 = newIoExceptionForInBitmapAssertion(r4, r0, r1, r2, r6)     // Catch:{ all -> 0x002e }
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x002e }
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0057
            r5.reset()     // Catch:{ IOException -> 0x0056 }
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch:{ IOException -> 0x0056 }
            r8.put(r1)     // Catch:{ IOException -> 0x0056 }
            r6.inBitmap = r3     // Catch:{ IOException -> 0x0056 }
            android.graphics.Bitmap r5 = decodeStream(r5, r6, r7, r8)     // Catch:{ IOException -> 0x0056 }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            return r5
        L_0x0056:
            throw r0     // Catch:{ all -> 0x002e }
        L_0x0057:
            throw r0     // Catch:{ all -> 0x002e }
        L_0x0058:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    private static boolean isScaling(Options options) {
        int i = options.inTargetDensity;
        if (i > 0) {
            int i2 = options.inDensity;
            if (i2 > 0 && i != i2) {
                return true;
            }
        }
        return false;
    }

    private static void logDecode(int i, int i2, String str, Options options, Bitmap bitmap, int i3, int i4, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("Decoded ");
        sb.append(getBitmapString(bitmap));
        sb.append(" from [");
        sb.append(i);
        String str2 = "x";
        sb.append(str2);
        sb.append(i2);
        sb.append("] ");
        sb.append(str);
        sb.append(" with inBitmap ");
        sb.append(getInBitmapString(options));
        sb.append(" for [");
        sb.append(i3);
        sb.append(str2);
        sb.append(i4);
        sb.append("], sample size: ");
        sb.append(options.inSampleSize);
        sb.append(", density: ");
        sb.append(options.inDensity);
        sb.append(", target density: ");
        sb.append(options.inTargetDensity);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.append(", duration: ");
        sb.append(LogTime.getElapsedMillis(j));
        sb.toString();
    }

    private static String getInBitmapString(Options options) {
        return getBitmapString(options.inBitmap);
    }

    @TargetApi(19)
    @Nullable
    private static String getBitmapString(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 19) {
            StringBuilder sb = new StringBuilder();
            sb.append(" (");
            sb.append(bitmap.getAllocationByteCount());
            sb.append(")");
            str = sb.toString();
        } else {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(bitmap.getWidth());
        sb2.append("x");
        sb2.append(bitmap.getHeight());
        sb2.append("] ");
        sb2.append(bitmap.getConfig());
        sb2.append(str);
        return sb2.toString();
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i, int i2, String str, Options options) {
        StringBuilder sb = new StringBuilder();
        sb.append("Exception decoding bitmap, outWidth: ");
        sb.append(i);
        sb.append(", outHeight: ");
        sb.append(i2);
        sb.append(", outMimeType: ");
        sb.append(str);
        sb.append(", inBitmap: ");
        sb.append(getInBitmapString(options));
        return new IOException(sb.toString(), illegalArgumentException);
    }

    @TargetApi(26)
    private static void setInBitmap(Options options, BitmapPool bitmapPool2, int i, int i2) {
        Config config;
        if (VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool2.getDirty(i, i2, config);
    }

    private static synchronized Options getDefaultOptions() {
        Options options;
        synchronized (Downsampler.class) {
            synchronized (OPTIONS_QUEUE) {
                options = (Options) OPTIONS_QUEUE.poll();
            }
            if (options == null) {
                options = new Options();
                resetOptions(options);
            }
        }
        return options;
    }

    private static void releaseOptions(Options options) {
        resetOptions(options);
        synchronized (OPTIONS_QUEUE) {
            OPTIONS_QUEUE.offer(options);
        }
    }

    private static void resetOptions(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
