package com.kakao.auth.helper;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Base64 {
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, PAD_DEFAULT, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final int EOF = -1;
    private static final int MASK_6BITS = 63;
    private static final int MIME_CHUNK_SIZE = 76;
    private static final byte PAD_DEFAULT = 61;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final byte PAD;
    private final int chunkSeparatorLength;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final int encodedBlockSize;
    private final int lineLength;
    private final byte[] lineSeparator;
    private final int unencodedBlockSize;

    static class Context {
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        Context() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[]{Context.class.getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos)});
        }
    }

    /* access modifiers changed from: 0000 */
    public int getDefaultBufferSize() {
        return 8192;
    }

    private Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    private Base64(int i, byte[] bArr, boolean z) {
        int i2;
        int i3;
        this.PAD = PAD_DEFAULT;
        this.decodeTable = DECODE_TABLE;
        this.unencodedBlockSize = 3;
        this.encodedBlockSize = 4;
        if (bArr == null) {
            i2 = 0;
        } else {
            i2 = bArr.length;
        }
        this.chunkSeparatorLength = i2;
        if (i > 0 && this.chunkSeparatorLength > 0) {
            int i4 = this.encodedBlockSize;
            i3 = i4 * (i / i4);
        } else {
            i3 = 0;
        }
        this.lineLength = i3;
        if (bArr == null) {
            this.encodeSize = 4;
            this.lineSeparator = null;
        } else if (containsAlphabetOrPad(bArr)) {
            String newStringUtf8 = newStringUtf8(bArr);
            StringBuilder sb = new StringBuilder();
            sb.append("lineSeparator must not contain base64 characters: [");
            sb.append(newStringUtf8);
            sb.append("]");
            throw new IllegalArgumentException(sb.toString());
        } else if (i > 0) {
            this.encodeSize = bArr.length + 4;
            this.lineSeparator = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.lineSeparator, 0, bArr.length);
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }

    /* access modifiers changed from: 0000 */
    public boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (61 == b || isInAlphabet(b)) {
                return true;
            }
        }
        return false;
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return newStringUtf8(encodeBase64(bArr, false, true));
    }

    private static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    private static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= ((long) i)) {
            return base64.encode(bArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Input array too big, the output array would be bigger (");
        sb.append(encodedLength);
        sb.append(") than the specified maximum size of ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public byte[] encode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        encode(bArr, 0, bArr.length, context);
        encode(bArr, 0, -1, context);
        byte[] bArr2 = new byte[(context.pos - context.readPos)];
        readResults(bArr2, 0, bArr2.length, context);
        return bArr2;
    }

    /* JADX WARNING: type inference failed for: r2v17 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v2, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r9, int r10, int r11, com.kakao.auth.helper.Base64.Context r12) {
        /*
            r8 = this;
            boolean r0 = r12.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r11 >= 0) goto L_0x00cc
            r12.eof = r1
            int r9 = r12.modulus
            if (r9 != 0) goto L_0x0014
            int r9 = r8.lineLength
            if (r9 != 0) goto L_0x0014
            return
        L_0x0014:
            int r9 = r8.encodeSize
            byte[] r9 = r8.ensureBufferSize(r9, r12)
            int r10 = r12.pos
            int r11 = r12.modulus
            if (r11 == 0) goto L_0x00ab
            r2 = 61
            if (r11 == r1) goto L_0x0079
            r1 = 2
            if (r11 != r1) goto L_0x0060
            int r11 = r10 + 1
            r12.pos = r11
            byte[] r11 = r8.encodeTable
            int r3 = r12.ibitWorkArea
            int r4 = r3 >> 10
            r4 = r4 & 63
            byte r4 = r11[r4]
            r9[r10] = r4
            int r4 = r12.pos
            int r5 = r4 + 1
            r12.pos = r5
            int r5 = r3 >> 4
            r5 = r5 & 63
            byte r5 = r11[r5]
            r9[r4] = r5
            int r4 = r12.pos
            int r5 = r4 + 1
            r12.pos = r5
            int r1 = r3 << 2
            r1 = r1 & 63
            byte r1 = r11[r1]
            r9[r4] = r1
            byte[] r1 = STANDARD_ENCODE_TABLE
            if (r11 != r1) goto L_0x00ab
            int r11 = r12.pos
            int r1 = r11 + 1
            r12.pos = r1
            r9[r11] = r2
            goto L_0x00ab
        L_0x0060:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Impossible modulus "
            r10.append(r11)
            int r11 = r12.modulus
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0079:
            int r11 = r10 + 1
            r12.pos = r11
            byte[] r11 = r8.encodeTable
            int r1 = r12.ibitWorkArea
            int r3 = r1 >> 2
            r3 = r3 & 63
            byte r3 = r11[r3]
            r9[r10] = r3
            int r3 = r12.pos
            int r4 = r3 + 1
            r12.pos = r4
            int r1 = r1 << 4
            r1 = r1 & 63
            byte r1 = r11[r1]
            r9[r3] = r1
            byte[] r1 = STANDARD_ENCODE_TABLE
            if (r11 != r1) goto L_0x00ab
            int r11 = r12.pos
            int r1 = r11 + 1
            r12.pos = r1
            r9[r11] = r2
            int r11 = r12.pos
            int r1 = r11 + 1
            r12.pos = r1
            r9[r11] = r2
        L_0x00ab:
            int r11 = r12.currentLinePos
            int r1 = r12.pos
            int r10 = r1 - r10
            int r11 = r11 + r10
            r12.currentLinePos = r11
            int r10 = r8.lineLength
            if (r10 <= 0) goto L_0x014e
            int r10 = r12.currentLinePos
            if (r10 <= 0) goto L_0x014e
            byte[] r10 = r8.lineSeparator
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r0, r9, r1, r11)
            int r9 = r12.pos
            byte[] r10 = r8.lineSeparator
            int r10 = r10.length
            int r9 = r9 + r10
            r12.pos = r9
            goto L_0x014e
        L_0x00cc:
            r2 = r10
            r10 = 0
        L_0x00ce:
            if (r10 >= r11) goto L_0x014e
            int r3 = r8.encodeSize
            byte[] r3 = r8.ensureBufferSize(r3, r12)
            int r4 = r12.modulus
            int r4 = r4 + r1
            int r4 = r4 % 3
            r12.modulus = r4
            int r4 = r2 + 1
            byte r2 = r9[r2]
            if (r2 >= 0) goto L_0x00e5
            int r2 = r2 + 256
        L_0x00e5:
            int r5 = r12.ibitWorkArea
            int r5 = r5 << 8
            int r5 = r5 + r2
            r12.ibitWorkArea = r5
            int r2 = r12.modulus
            if (r2 != 0) goto L_0x014a
            int r2 = r12.pos
            int r5 = r2 + 1
            r12.pos = r5
            byte[] r5 = r8.encodeTable
            int r6 = r12.ibitWorkArea
            int r7 = r6 >> 18
            r7 = r7 & 63
            byte r7 = r5[r7]
            r3[r2] = r7
            int r2 = r12.pos
            int r7 = r2 + 1
            r12.pos = r7
            int r7 = r6 >> 12
            r7 = r7 & 63
            byte r7 = r5[r7]
            r3[r2] = r7
            int r2 = r12.pos
            int r7 = r2 + 1
            r12.pos = r7
            int r7 = r6 >> 6
            r7 = r7 & 63
            byte r7 = r5[r7]
            r3[r2] = r7
            int r2 = r12.pos
            int r7 = r2 + 1
            r12.pos = r7
            r6 = r6 & 63
            byte r5 = r5[r6]
            r3[r2] = r5
            int r2 = r12.currentLinePos
            int r2 = r2 + 4
            r12.currentLinePos = r2
            int r2 = r8.lineLength
            if (r2 <= 0) goto L_0x014a
            int r5 = r12.currentLinePos
            if (r2 > r5) goto L_0x014a
            byte[] r2 = r8.lineSeparator
            int r5 = r12.pos
            int r6 = r2.length
            java.lang.System.arraycopy(r2, r0, r3, r5, r6)
            int r2 = r12.pos
            byte[] r3 = r8.lineSeparator
            int r3 = r3.length
            int r2 = r2 + r3
            r12.pos = r2
            r12.currentLinePos = r0
        L_0x014a:
            int r10 = r10 + 1
            r2 = r4
            goto L_0x00ce
        L_0x014e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.auth.helper.Base64.encode(byte[], int, int, com.kakao.auth.helper.Base64$Context):void");
    }

    /* access modifiers changed from: 0000 */
    public byte[] ensureBufferSize(int i, Context context) {
        byte[] bArr = context.buffer;
        if (bArr == null || bArr.length < context.pos + i) {
            return resizeBuffer(context);
        }
        return bArr;
    }

    /* access modifiers changed from: 0000 */
    public int readResults(byte[] bArr, int i, int i2, Context context) {
        if (context.buffer != null) {
            int min = Math.min(available(context), i2);
            System.arraycopy(context.buffer, context.readPos, bArr, i, min);
            context.readPos += min;
            if (context.readPos >= context.pos) {
                context.buffer = null;
            }
            return min;
        }
        return context.eof ? -1 : 0;
    }

    /* access modifiers changed from: 0000 */
    public int available(Context context) {
        if (context.buffer != null) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    private byte[] resizeBuffer(Context context) {
        byte[] bArr = context.buffer;
        if (bArr == null) {
            context.buffer = new byte[getDefaultBufferSize()];
            context.pos = 0;
            context.readPos = 0;
        } else {
            byte[] bArr2 = new byte[(bArr.length * 2)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            context.buffer = bArr2;
        }
        return context.buffer;
    }

    /* access modifiers changed from: 0000 */
    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i = this.unencodedBlockSize;
        long j = ((long) (((length + i) - 1) / i)) * ((long) this.encodedBlockSize);
        int i2 = this.lineLength;
        return i2 > 0 ? j + ((((((long) i2) + j) - 1) / ((long) i2)) * ((long) this.chunkSeparatorLength)) : j;
    }

    private static String newStringUtf8(byte[] bArr) {
        return newString(bArr, UTF_8);
    }

    private static String newString(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, charset.name());
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }
}
