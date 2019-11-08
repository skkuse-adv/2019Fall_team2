package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.UByte;

public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int DESCRIPTOR_MASK_INTERLACE_FLAG = 64;
    private static final int DESCRIPTOR_MASK_LCT_FLAG = 128;
    private static final int DESCRIPTOR_MASK_LCT_SIZE = 7;
    private static final int EXTENSION_INTRODUCER = 33;
    private static final int GCE_DISPOSAL_METHOD_SHIFT = 2;
    private static final int GCE_MASK_DISPOSAL_METHOD = 28;
    private static final int GCE_MASK_TRANSPARENT_COLOR_FLAG = 1;
    private static final int IMAGE_SEPARATOR = 44;
    private static final int LABEL_APPLICATION_EXTENSION = 255;
    private static final int LABEL_COMMENT_EXTENSION = 254;
    private static final int LABEL_GRAPHIC_CONTROL_EXTENSION = 249;
    private static final int LABEL_PLAIN_TEXT_EXTENSION = 1;
    private static final int LSD_MASK_GCT_FLAG = 128;
    private static final int LSD_MASK_GCT_SIZE = 7;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 2;
    private static final String TAG = "GifHeaderParser";
    private static final int TRAILER = 59;
    private final byte[] block = new byte[256];
    private int blockSize = 0;
    private GifHeader header;
    private ByteBuffer rawData;

    public GifHeaderParser setData(@NonNull ByteBuffer byteBuffer) {
        reset();
        this.rawData = byteBuffer.asReadOnlyBuffer();
        this.rawData.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public GifHeaderParser setData(@Nullable byte[] bArr) {
        if (bArr != null) {
            setData(ByteBuffer.wrap(bArr));
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    @NonNull
    public GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (err()) {
            return this.header;
        } else {
            readHeader();
            if (!err()) {
                readContents();
                GifHeader gifHeader = this.header;
                if (gifHeader.frameCount < 0) {
                    gifHeader.status = 1;
                }
            }
            return this.header;
        }
    }

    public boolean isAnimated() {
        readHeader();
        if (!err()) {
            readContents(2);
        }
        return this.header.frameCount > 1;
    }

    private void readContents() {
        readContents(Integer.MAX_VALUE);
    }

    private void readContents(int i) {
        boolean z = false;
        while (!z && !err() && this.header.frameCount <= i) {
            int read = read();
            if (read == 33) {
                int read2 = read();
                if (read2 == 1) {
                    skip();
                } else if (read2 == LABEL_GRAPHIC_CONTROL_EXTENSION) {
                    this.header.currentFrame = new GifFrame();
                    readGraphicControlExt();
                } else if (read2 == LABEL_COMMENT_EXTENSION) {
                    skip();
                } else if (read2 != 255) {
                    skip();
                } else {
                    readBlock();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.block[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        readNetscapeExt();
                    } else {
                        skip();
                    }
                }
            } else if (read == 44) {
                GifHeader gifHeader = this.header;
                if (gifHeader.currentFrame == null) {
                    gifHeader.currentFrame = new GifFrame();
                }
                readBitmap();
            } else if (read != 59) {
                this.header.status = 1;
            } else {
                z = true;
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        GifFrame gifFrame = this.header.currentFrame;
        gifFrame.dispose = (read & 28) >> 2;
        boolean z = true;
        if (gifFrame.dispose == 0) {
            gifFrame.dispose = 1;
        }
        GifFrame gifFrame2 = this.header.currentFrame;
        if ((read & 1) == 0) {
            z = false;
        }
        gifFrame2.transparency = z;
        int readShort = readShort();
        if (readShort < 2) {
            readShort = 10;
        }
        GifFrame gifFrame3 = this.header.currentFrame;
        gifFrame3.delay = readShort * 10;
        gifFrame3.transIndex = read();
        read();
    }

    private void readBitmap() {
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int read = read();
        boolean z = false;
        boolean z2 = (read & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((read & 7) + 1));
        GifFrame gifFrame = this.header.currentFrame;
        if ((read & 64) != 0) {
            z = true;
        }
        gifFrame.interlace = z;
        if (z2) {
            this.header.currentFrame.lct = readColorTable(pow);
        } else {
            this.header.currentFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (!err()) {
            GifHeader gifHeader = this.header;
            gifHeader.frameCount++;
            gifHeader.frames.add(gifHeader.currentFrame);
        }
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.header.loopCount = ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[1] & UByte.MAX_VALUE);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    private void readHeader() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) read());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (this.header.gctFlag && !err()) {
            GifHeader gifHeader = this.header;
            gifHeader.gct = readColorTable(gifHeader.gctSize);
            GifHeader gifHeader2 = this.header;
            gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
        }
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int read = read();
        this.header.gctFlag = (read & 128) != 0;
        this.header.gctSize = (int) Math.pow(2.0d, (double) ((read & 7) + 1));
        this.header.bgIndex = read();
        this.header.pixelAspect = read();
    }

    @Nullable
    private int[] readColorTable(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & UByte.MAX_VALUE) << 16) | UByte.MIN_VALUE | ((bArr[i4] & UByte.MAX_VALUE) << 8) | (bArr[i5] & UByte.MAX_VALUE);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException unused) {
            boolean isLoggable = Log.isLoggable(TAG, 3);
            this.header.status = 1;
        }
        return iArr;
    }

    private void skipImageData() {
        read();
        skip();
    }

    private void skip() {
        int read;
        do {
            read = read();
            this.rawData.position(Math.min(this.rawData.position() + read, this.rawData.limit()));
        } while (read > 0);
    }

    private void readBlock() {
        this.blockSize = read();
        if (this.blockSize > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.blockSize) {
                try {
                    i2 = this.blockSize - i;
                    this.rawData.get(this.block, i, i2);
                    i += i2;
                } catch (Exception unused) {
                    if (Log.isLoggable(TAG, 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error Reading Block n: ");
                        sb.append(i);
                        sb.append(" count: ");
                        sb.append(i2);
                        sb.append(" blockSize: ");
                        sb.append(this.blockSize);
                        sb.toString();
                    }
                    this.header.status = 1;
                    return;
                }
            }
        }
    }

    private int read() {
        try {
            return this.rawData.get() & UByte.MAX_VALUE;
        } catch (Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private boolean err() {
        return this.header.status != 0;
    }
}
