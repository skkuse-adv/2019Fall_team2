package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public class Code93Writer extends OneDimensionalCodeWriter {
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        StringBuilder sb = new StringBuilder("Can only encode CODE_93, but got ");
        sb.append(barcodeFormat);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[(((str.length() + 2 + 2) * 9) + 1)];
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
            int i = 0;
            int appendPattern = appendPattern(zArr, 0, iArr, true);
            while (true) {
                String str2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
                if (i < length) {
                    toIntArray(Code93Reader.CHARACTER_ENCODINGS[str2.indexOf(str.charAt(i))], iArr);
                    appendPattern += appendPattern(zArr, appendPattern, iArr, true);
                    i++;
                } else {
                    int computeChecksumIndex = computeChecksumIndex(str, 20);
                    toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex], iArr);
                    int appendPattern2 = appendPattern + appendPattern(zArr, appendPattern, iArr, true);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(str2.charAt(computeChecksumIndex));
                    toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(sb.toString(), 15)], iArr);
                    int appendPattern3 = appendPattern2 + appendPattern(zArr, appendPattern2, iArr, true);
                    toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
                    zArr[appendPattern3 + appendPattern(zArr, appendPattern3, iArr, true)] = true;
                    return zArr;
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder("Requested contents should be less than 80 digits long, but got ");
            sb2.append(length);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private static void toIntArray(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    protected static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = i;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            zArr[i2] = iArr[i3] != 0;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    private static int computeChecksumIndex(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }
}
