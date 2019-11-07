package com.google.zxing.oned;

public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS = {'T', 'N', '*', 'E'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = {'/', ':', '+', '.'};
    private static final char DEFAULT_GUARD = START_END_CHARS[0];
    private static final char[] START_END_CHARS = {'A', 'B', 'C', 'D'};

    public boolean[] encode(String str) {
        int i;
        if (str.length() < 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(DEFAULT_GUARD);
            sb.append(str);
            sb.append(DEFAULT_GUARD);
            str = sb.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean arrayContains = CodaBarReader.arrayContains(START_END_CHARS, upperCase);
            boolean arrayContains2 = CodaBarReader.arrayContains(START_END_CHARS, upperCase2);
            boolean arrayContains3 = CodaBarReader.arrayContains(ALT_START_END_CHARS, upperCase);
            boolean arrayContains4 = CodaBarReader.arrayContains(ALT_START_END_CHARS, upperCase2);
            String str2 = "Invalid start/end guards: ";
            if (arrayContains) {
                if (!arrayContains2) {
                    StringBuilder sb2 = new StringBuilder(str2);
                    sb2.append(str);
                    throw new IllegalArgumentException(sb2.toString());
                }
            } else if (arrayContains3) {
                if (!arrayContains4) {
                    StringBuilder sb3 = new StringBuilder(str2);
                    sb3.append(str);
                    throw new IllegalArgumentException(sb3.toString());
                }
            } else if (arrayContains2 || arrayContains4) {
                StringBuilder sb4 = new StringBuilder(str2);
                sb4.append(str);
                throw new IllegalArgumentException(sb4.toString());
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(DEFAULT_GUARD);
                sb5.append(str);
                sb5.append(DEFAULT_GUARD);
                str = sb5.toString();
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else if (CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i3))) {
                i2 += 10;
            } else {
                StringBuilder sb6 = new StringBuilder("Cannot encode : '");
                sb6.append(str.charAt(i3));
                sb6.append('\'');
                throw new IllegalArgumentException(sb6.toString());
            }
        }
        boolean[] zArr = new boolean[(i2 + (str.length() - 1))];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i6 = 0;
            while (true) {
                char[] cArr = CodaBarReader.ALPHABET;
                if (i6 >= cArr.length) {
                    i = 0;
                    break;
                } else if (upperCase3 == cArr[i6]) {
                    i = CodaBarReader.CHARACTER_ENCODINGS[i6];
                    break;
                } else {
                    i6++;
                }
            }
            int i7 = i4;
            int i8 = 0;
            boolean z = true;
            while (true) {
                int i9 = 0;
                while (i8 < 7) {
                    zArr[i7] = z;
                    i7++;
                    if (((i >> (6 - i8)) & 1) == 0 || i9 == 1) {
                        z = !z;
                        i8++;
                    } else {
                        i9++;
                    }
                }
                break;
            }
            if (i5 < str.length() - 1) {
                zArr[i7] = false;
                i7++;
            }
            i4 = i7;
        }
        return zArr;
    }
}
