package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.UByte;

public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    @ColorInt
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";
    @ColorInt
    private int[] act;
    @NonNull
    private Config bitmapConfig;
    private final BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    @Nullable
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    @ColorInt
    private int[] mainScratch;
    private GifHeaderParser parser;
    @ColorInt
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(@NonNull BitmapProvider bitmapProvider2, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider2, gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull BitmapProvider bitmapProvider2, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider2);
        setData(gifHeader, byteBuffer, i);
    }

    public StandardGifDecoder(@NonNull BitmapProvider bitmapProvider2) {
        this.pct = new int[256];
        this.bitmapConfig = Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider2;
        this.header = new GifHeader();
    }

    public int getWidth() {
        return this.header.width;
    }

    public int getHeight() {
        return this.header.height;
    }

    @NonNull
    public ByteBuffer getData() {
        return this.rawData;
    }

    public int getStatus() {
        return this.status;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public int getDelay(int i) {
        if (i >= 0) {
            GifHeader gifHeader = this.header;
            if (i < gifHeader.frameCount) {
                return ((GifFrame) gifHeader.frames.get(i)).delay;
            }
        }
        return -1;
    }

    public int getNextDelay() {
        if (this.header.frameCount > 0) {
            int i = this.framePointer;
            if (i >= 0) {
                return getDelay(i);
            }
        }
        return 0;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Deprecated
    public int getLoopCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getTotalIterationCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    public int getByteSize() {
        return this.rawData.limit() + this.mainPixels.length + (this.mainScratch.length * 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d7, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap getNextFrame() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.bumptech.glide.gifdecoder.GifHeader r0 = r7.header     // Catch:{ all -> 0x00d8 }
            int r0 = r0.frameCount     // Catch:{ all -> 0x00d8 }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r7.framePointer     // Catch:{ all -> 0x00d8 }
            if (r0 >= 0) goto L_0x0035
        L_0x000d:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00d8 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x0033
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r0.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = "Unable to decode frame, frameCount="
            r0.append(r3)     // Catch:{ all -> 0x00d8 }
            com.bumptech.glide.gifdecoder.GifHeader r3 = r7.header     // Catch:{ all -> 0x00d8 }
            int r3 = r3.frameCount     // Catch:{ all -> 0x00d8 }
            r0.append(r3)     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = ", framePointer="
            r0.append(r3)     // Catch:{ all -> 0x00d8 }
            int r3 = r7.framePointer     // Catch:{ all -> 0x00d8 }
            r0.append(r3)     // Catch:{ all -> 0x00d8 }
            r0.toString()     // Catch:{ all -> 0x00d8 }
        L_0x0033:
            r7.status = r2     // Catch:{ all -> 0x00d8 }
        L_0x0035:
            int r0 = r7.status     // Catch:{ all -> 0x00d8 }
            r3 = 0
            if (r0 == r2) goto L_0x00bc
            int r0 = r7.status     // Catch:{ all -> 0x00d8 }
            r4 = 2
            if (r0 != r4) goto L_0x0041
            goto L_0x00bc
        L_0x0041:
            r0 = 0
            r7.status = r0     // Catch:{ all -> 0x00d8 }
            byte[] r4 = r7.block     // Catch:{ all -> 0x00d8 }
            if (r4 != 0) goto L_0x0052
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r4 = r7.bitmapProvider     // Catch:{ all -> 0x00d8 }
            r5 = 255(0xff, float:3.57E-43)
            byte[] r4 = r4.obtainByteArray(r5)     // Catch:{ all -> 0x00d8 }
            r7.block = r4     // Catch:{ all -> 0x00d8 }
        L_0x0052:
            com.bumptech.glide.gifdecoder.GifHeader r4 = r7.header     // Catch:{ all -> 0x00d8 }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r4 = r4.frames     // Catch:{ all -> 0x00d8 }
            int r5 = r7.framePointer     // Catch:{ all -> 0x00d8 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00d8 }
            com.bumptech.glide.gifdecoder.GifFrame r4 = (com.bumptech.glide.gifdecoder.GifFrame) r4     // Catch:{ all -> 0x00d8 }
            int r5 = r7.framePointer     // Catch:{ all -> 0x00d8 }
            int r5 = r5 - r2
            if (r5 < 0) goto L_0x006e
            com.bumptech.glide.gifdecoder.GifHeader r6 = r7.header     // Catch:{ all -> 0x00d8 }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r6 = r6.frames     // Catch:{ all -> 0x00d8 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x00d8 }
            com.bumptech.glide.gifdecoder.GifFrame r5 = (com.bumptech.glide.gifdecoder.GifFrame) r5     // Catch:{ all -> 0x00d8 }
            goto L_0x006f
        L_0x006e:
            r5 = r3
        L_0x006f:
            int[] r6 = r4.lct     // Catch:{ all -> 0x00d8 }
            if (r6 == 0) goto L_0x0076
            int[] r6 = r4.lct     // Catch:{ all -> 0x00d8 }
            goto L_0x007a
        L_0x0076:
            com.bumptech.glide.gifdecoder.GifHeader r6 = r7.header     // Catch:{ all -> 0x00d8 }
            int[] r6 = r6.gct     // Catch:{ all -> 0x00d8 }
        L_0x007a:
            r7.act = r6     // Catch:{ all -> 0x00d8 }
            int[] r6 = r7.act     // Catch:{ all -> 0x00d8 }
            if (r6 != 0) goto L_0x009e
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00d8 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x009a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r0.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = "No valid color table found for frame #"
            r0.append(r1)     // Catch:{ all -> 0x00d8 }
            int r1 = r7.framePointer     // Catch:{ all -> 0x00d8 }
            r0.append(r1)     // Catch:{ all -> 0x00d8 }
            r0.toString()     // Catch:{ all -> 0x00d8 }
        L_0x009a:
            r7.status = r2     // Catch:{ all -> 0x00d8 }
            monitor-exit(r7)
            return r3
        L_0x009e:
            boolean r1 = r4.transparency     // Catch:{ all -> 0x00d8 }
            if (r1 == 0) goto L_0x00b6
            int[] r1 = r7.act     // Catch:{ all -> 0x00d8 }
            int[] r2 = r7.pct     // Catch:{ all -> 0x00d8 }
            int[] r3 = r7.act     // Catch:{ all -> 0x00d8 }
            int r3 = r3.length     // Catch:{ all -> 0x00d8 }
            java.lang.System.arraycopy(r1, r0, r2, r0, r3)     // Catch:{ all -> 0x00d8 }
            int[] r1 = r7.pct     // Catch:{ all -> 0x00d8 }
            r7.act = r1     // Catch:{ all -> 0x00d8 }
            int[] r1 = r7.act     // Catch:{ all -> 0x00d8 }
            int r2 = r4.transIndex     // Catch:{ all -> 0x00d8 }
            r1[r2] = r0     // Catch:{ all -> 0x00d8 }
        L_0x00b6:
            android.graphics.Bitmap r0 = r7.setPixels(r4, r5)     // Catch:{ all -> 0x00d8 }
            monitor-exit(r7)
            return r0
        L_0x00bc:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00d8 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x00d6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r0.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = "Unable to decode frame, status="
            r0.append(r1)     // Catch:{ all -> 0x00d8 }
            int r1 = r7.status     // Catch:{ all -> 0x00d8 }
            r0.append(r1)     // Catch:{ all -> 0x00d8 }
            r0.toString()     // Catch:{ all -> 0x00d8 }
        L_0x00d6:
            monitor-exit(r7)
            return r3
        L_0x00d8:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.getNextFrame():android.graphics.Bitmap");
    }

    public int read(@Nullable InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        return this.status;
    }

    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i) {
        if (i > 0) {
            int highestOneBit = Integer.highestOneBit(i);
            this.status = 0;
            this.header = gifHeader;
            this.framePointer = -1;
            this.rawData = byteBuffer.asReadOnlyBuffer();
            this.rawData.position(0);
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.savePrevious = false;
            Iterator it = gifHeader.frames.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((GifFrame) it.next()).dispose == 3) {
                        this.savePrevious = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.sampleSize = highestOneBit;
            this.downsampledWidth = gifHeader.width / highestOneBit;
            this.downsampledHeight = gifHeader.height / highestOneBit;
            this.mainPixels = this.bitmapProvider.obtainByteArray(gifHeader.width * gifHeader.height);
            this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Sample size must be >=0, not: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @NonNull
    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    public synchronized int read(@Nullable byte[] bArr) {
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            setData(this.header, bArr);
        }
        return this.status;
    }

    public void setDefaultBitmapConfig(@NonNull Config config) {
        if (config == Config.ARGB_8888 || config == Config.RGB_565) {
            this.bitmapConfig = config;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported format: ");
        sb.append(config);
        sb.append(", must be one of ");
        sb.append(Config.ARGB_8888);
        sb.append(" or ");
        sb.append(Config.RGB_565);
        throw new IllegalArgumentException(sb.toString());
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int[] iArr = this.mainScratch;
        int i = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap = this.previousImage;
            if (bitmap != null) {
                this.bitmapProvider.release(bitmap);
            }
            this.previousImage = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null) {
            int i2 = gifFrame2.dispose;
            if (i2 > 0) {
                if (i2 == 2) {
                    if (!gifFrame.transparency) {
                        GifHeader gifHeader = this.header;
                        int i3 = gifHeader.bgColor;
                        if (gifFrame.lct == null || gifHeader.bgIndex != gifFrame.transIndex) {
                            i = i3;
                        }
                    } else if (this.framePointer == 0) {
                        this.isFirstFrameTransparent = Boolean.valueOf(true);
                    }
                    int i4 = gifFrame2.ih;
                    int i5 = this.sampleSize;
                    int i6 = i4 / i5;
                    int i7 = gifFrame2.iy / i5;
                    int i8 = gifFrame2.iw / i5;
                    int i9 = gifFrame2.ix / i5;
                    int i10 = this.downsampledWidth;
                    int i11 = (i7 * i10) + i9;
                    int i12 = (i6 * i10) + i11;
                    while (i11 < i12) {
                        int i13 = i11 + i8;
                        for (int i14 = i11; i14 < i13; i14++) {
                            iArr[i14] = i;
                        }
                        i11 += this.downsampledWidth;
                    }
                } else if (i2 == 3) {
                    Bitmap bitmap2 = this.previousImage;
                    if (bitmap2 != null) {
                        int i15 = this.downsampledWidth;
                        bitmap2.getPixels(iArr, 0, i15, 0, 0, i15, this.downsampledHeight);
                    }
                }
            }
        }
        decodeBitmapData(gifFrame);
        if (gifFrame.interlace || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(gifFrame);
        } else {
            copyIntoScratchFast(gifFrame);
        }
        if (this.savePrevious) {
            int i16 = gifFrame.dispose;
            if (i16 == 0 || i16 == 1) {
                if (this.previousImage == null) {
                    this.previousImage = getNextBitmap();
                }
                Bitmap bitmap3 = this.previousImage;
                int i17 = this.downsampledWidth;
                bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.downsampledHeight);
            }
        }
        Bitmap nextBitmap = getNextBitmap();
        int i18 = this.downsampledWidth;
        nextBitmap.setPixels(iArr, 0, i18, 0, 0, i18, this.downsampledHeight);
        return nextBitmap;
    }

    private void copyIntoScratchFast(GifFrame gifFrame) {
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i = gifFrame2.ih;
        int i2 = gifFrame2.iy;
        int i3 = gifFrame2.iw;
        int i4 = gifFrame2.ix;
        boolean z = this.framePointer == 0;
        int i5 = this.downsampledWidth;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = gifFrame2.iw * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                byte b3 = b2 & UByte.MAX_VALUE;
                if (b3 != b) {
                    int i13 = iArr2[b3];
                    if (i13 != 0) {
                        iArr[i12] = i13;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                GifFrame gifFrame3 = gifFrame;
            }
            i6++;
            gifFrame2 = gifFrame;
        }
        this.isFirstFrameTransparent = Boolean.valueOf(this.isFirstFrameTransparent == null && z && b != -1);
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i6 = gifFrame2.ih;
        int i7 = this.sampleSize;
        int i8 = i6 / i7;
        int i9 = gifFrame2.iy / i7;
        int i10 = gifFrame2.iw / i7;
        int i11 = gifFrame2.ix / i7;
        int i12 = this.framePointer;
        Boolean valueOf = Boolean.valueOf(true);
        boolean z2 = i12 == 0;
        int i13 = this.sampleSize;
        int i14 = this.downsampledWidth;
        int i15 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        Boolean bool = this.isFirstFrameTransparent;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        int i19 = 8;
        while (i16 < i8) {
            Boolean bool2 = valueOf;
            if (gifFrame2.interlace) {
                if (i17 >= i8) {
                    i = i8;
                    i5 = i18 + 1;
                    if (i5 == 2) {
                        i17 = 4;
                    } else if (i5 == 3) {
                        i17 = 2;
                        i19 = 4;
                    } else if (i5 == 4) {
                        i17 = 1;
                        i19 = 2;
                    }
                } else {
                    i = i8;
                    i5 = i18;
                }
                i2 = i17 + i19;
                i18 = i5;
            } else {
                i = i8;
                i2 = i17;
                i17 = i16;
            }
            int i20 = i17 + i9;
            boolean z3 = i13 == 1;
            if (i20 < i15) {
                int i21 = i20 * i14;
                int i22 = i21 + i11;
                int i23 = i22 + i10;
                int i24 = i21 + i14;
                if (i24 < i23) {
                    i23 = i24;
                }
                i3 = i9;
                int i25 = i16 * i13 * gifFrame2.iw;
                if (z3) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i10;
                        int i28 = iArr2[bArr[i25] & UByte.MAX_VALUE];
                        if (i28 != 0) {
                            iArr[i26] = i28;
                        } else if (z2 && bool == null) {
                            bool = bool2;
                        }
                        i25 += i13;
                        i26++;
                        i10 = i27;
                    }
                } else {
                    i4 = i10;
                    int i29 = ((i23 - i22) * i13) + i25;
                    int i30 = i22;
                    while (i30 < i23) {
                        int i31 = i23;
                        int averageColorsNear = averageColorsNear(i25, i29, gifFrame2.iw);
                        if (averageColorsNear != 0) {
                            iArr[i30] = averageColorsNear;
                        } else if (z2 && bool == null) {
                            bool = bool2;
                        }
                        i25 += i13;
                        i30++;
                        i23 = i31;
                    }
                    i16++;
                    i17 = i2;
                    i10 = i4;
                    valueOf = bool2;
                    i8 = i;
                    i9 = i3;
                }
            } else {
                i3 = i9;
            }
            i4 = i10;
            i16++;
            i17 = i2;
            i10 = i4;
            valueOf = bool2;
            i8 = i;
            i9 = i3;
        }
        if (this.isFirstFrameTransparent == null) {
            if (bool == null) {
                z = false;
            } else {
                z = bool.booleanValue();
            }
            this.isFirstFrameTransparent = Boolean.valueOf(z);
        }
    }

    @ColorInt
    private int averageColorsNear(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.sampleSize + i; i9++) {
            byte[] bArr = this.mainPixels;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.act[bArr[i9] & UByte.MAX_VALUE];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.sampleSize + i11; i12++) {
            byte[] bArr2 = this.mainPixels;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.act[bArr2[i12] & UByte.MAX_VALUE];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [short[]] */
    /* JADX WARNING: type inference failed for: r26v0 */
    /* JADX WARNING: type inference failed for: r26v1 */
    /* JADX WARNING: type inference failed for: r28v0 */
    /* JADX WARNING: type inference failed for: r28v1 */
    /* JADX WARNING: type inference failed for: r15v1 */
    /* JADX WARNING: type inference failed for: r26v2 */
    /* JADX WARNING: type inference failed for: r26v3 */
    /* JADX WARNING: type inference failed for: r18v4 */
    /* JADX WARNING: type inference failed for: r28v2 */
    /* JADX WARNING: type inference failed for: r26v4 */
    /* JADX WARNING: type inference failed for: r4v16, types: [short] */
    /* JADX WARNING: type inference failed for: r4v18, types: [int] */
    /* JADX WARNING: type inference failed for: r28v5 */
    /* JADX WARNING: type inference failed for: r26v7 */
    /* JADX WARNING: type inference failed for: r28v6 */
    /* JADX WARNING: type inference failed for: r26v8 */
    /* JADX WARNING: type inference failed for: r18v6 */
    /* JADX WARNING: type inference failed for: r28v7 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r28v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r4v16, types: [short] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short[], code=null, for r3v1, types: [short[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r26v3
  assigns: []
  uses: []
  mth insns count: 170
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame r30) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.rawData
            int r3 = r1.bufferFrameStart
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0016
            com.bumptech.glide.gifdecoder.GifHeader r1 = r0.header
            int r2 = r1.width
            int r1 = r1.height
            goto L_0x001a
        L_0x0016:
            int r2 = r1.iw
            int r1 = r1.ih
        L_0x001a:
            int r2 = r2 * r1
            byte[] r1 = r0.mainPixels
            if (r1 == 0) goto L_0x0023
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002b
        L_0x0023:
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r1 = r0.bitmapProvider
            byte[] r1 = r1.obtainByteArray(r2)
            r0.mainPixels = r1
        L_0x002b:
            byte[] r1 = r0.mainPixels
            short[] r3 = r0.prefix
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0037
            short[] r3 = new short[r4]
            r0.prefix = r3
        L_0x0037:
            short[] r3 = r0.prefix
            byte[] r5 = r0.suffix
            if (r5 != 0) goto L_0x0041
            byte[] r5 = new byte[r4]
            r0.suffix = r5
        L_0x0041:
            byte[] r5 = r0.suffix
            byte[] r6 = r0.pixelStack
            if (r6 != 0) goto L_0x004d
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.pixelStack = r6
        L_0x004d:
            byte[] r6 = r0.pixelStack
            int r7 = r29.readByte()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = 0
        L_0x0060:
            if (r14 >= r9) goto L_0x006a
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x0060
        L_0x006a:
            byte[] r14 = r0.block
            r15 = -1
            r23 = r7
            r21 = r11
            r24 = r12
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = -1
            r25 = 0
            r26 = 0
        L_0x0083:
            if (r13 >= r2) goto L_0x0159
            if (r16 != 0) goto L_0x0094
            int r16 = r29.readBlock()
            if (r16 > 0) goto L_0x0092
            r3 = 3
            r0.status = r3
            goto L_0x0159
        L_0x0092:
            r17 = 0
        L_0x0094:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r27 = r21
            r8 = r22
            r28 = r26
            r21 = r20
            r20 = r13
            r13 = r23
        L_0x00b0:
            if (r4 < r13) goto L_0x013d
            r15 = r19 & r24
            int r19 = r19 >> r13
            int r4 = r4 - r13
            if (r15 != r9) goto L_0x00c1
            r13 = r7
            r27 = r11
            r24 = r12
            r8 = -1
        L_0x00bf:
            r15 = -1
            goto L_0x00b0
        L_0x00c1:
            if (r15 != r10) goto L_0x00d6
            r18 = r4
            r22 = r8
            r23 = r13
            r13 = r20
            r20 = r21
            r21 = r27
            r26 = r28
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r15 = -1
            goto L_0x0083
        L_0x00d6:
            r0 = -1
            if (r8 != r0) goto L_0x00e7
            byte r8 = r5[r15]
            r1[r21] = r8
            int r21 = r21 + 1
            int r20 = r20 + 1
            r0 = r29
            r8 = r15
            r28 = r8
            goto L_0x00bf
        L_0x00e7:
            r0 = r27
            r23 = r4
            if (r15 < r0) goto L_0x00f6
            r4 = r28
            byte r4 = (byte) r4
            r6[r25] = r4
            int r25 = r25 + 1
            r4 = r8
            goto L_0x00f7
        L_0x00f6:
            r4 = r15
        L_0x00f7:
            if (r4 < r9) goto L_0x0102
            byte r26 = r5[r4]
            r6[r25] = r26
            int r25 = r25 + 1
            short r4 = r3[r4]
            goto L_0x00f7
        L_0x0102:
            byte r4 = r5[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r26 = r7
            byte r7 = (byte) r4
            r1[r21] = r7
        L_0x010b:
            int r21 = r21 + 1
            int r20 = r20 + 1
            if (r25 <= 0) goto L_0x0118
            int r25 = r25 + -1
            byte r27 = r6[r25]
            r1[r21] = r27
            goto L_0x010b
        L_0x0118:
            r27 = r4
            r4 = 4096(0x1000, float:5.74E-42)
            if (r0 >= r4) goto L_0x012f
            short r8 = (short) r8
            r3[r0] = r8
            r5[r0] = r7
            int r0 = r0 + 1
            r7 = r0 & r24
            if (r7 != 0) goto L_0x012f
            if (r0 >= r4) goto L_0x012f
            int r13 = r13 + 1
            int r24 = r24 + r0
        L_0x012f:
            r8 = r15
            r4 = r23
            r7 = r26
            r28 = r27
            r15 = -1
            r27 = r0
            r0 = r29
            goto L_0x00b0
        L_0x013d:
            r23 = r4
            r0 = r27
            r15 = r28
            r22 = r8
            r26 = r15
            r18 = r23
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r15 = -1
            r23 = r13
            r13 = r20
            r20 = r21
            r21 = r0
            r0 = r29
            goto L_0x0083
        L_0x0159:
            r13 = r20
            r0 = 0
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame):void");
    }

    private int readByte() {
        return this.rawData.get() & UByte.MAX_VALUE;
    }

    private int readBlock() {
        int readByte = readByte();
        if (readByte <= 0) {
            return readByte;
        }
        ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, Math.min(readByte, byteBuffer.remaining()));
        return readByte;
    }

    private Bitmap getNextBitmap() {
        Boolean bool = this.isFirstFrameTransparent;
        Bitmap obtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (bool == null || bool.booleanValue()) ? Config.ARGB_8888 : this.bitmapConfig);
        obtain.setHasAlpha(true);
        return obtain;
    }
}
