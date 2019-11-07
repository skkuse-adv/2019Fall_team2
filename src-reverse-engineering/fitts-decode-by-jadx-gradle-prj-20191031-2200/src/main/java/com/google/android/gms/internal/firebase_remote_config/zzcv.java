package com.google.android.gms.internal.firebase_remote_config;

public abstract class zzcv extends zzcr {
    /* access modifiers changed from: protected */
    public abstract int zza(CharSequence charSequence, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract char[] zzj(int i);

    /* access modifiers changed from: protected */
    public final String zza(String str, int i) {
        int i2;
        int length = str.length();
        char[] zzcd = zzct.zzcd();
        int i3 = 0;
        int i4 = 0;
        while (i < length) {
            if (i < length) {
                int i5 = i + 1;
                char charAt = str.charAt(i);
                int i6 = 1;
                if (charAt >= 55296 && charAt <= 57343) {
                    String str2 = " at index ";
                    String str3 = "' with value ";
                    if (charAt > 56319) {
                        int i7 = i5 - 1;
                        StringBuilder sb = new StringBuilder(82);
                        sb.append("Unexpected low surrogate character '");
                        sb.append(charAt);
                        sb.append(str3);
                        sb.append(charAt);
                        sb.append(str2);
                        sb.append(i7);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (i5 == length) {
                        charAt = -charAt;
                    } else {
                        char charAt2 = str.charAt(i5);
                        if (Character.isLowSurrogate(charAt2)) {
                            charAt = Character.toCodePoint(charAt, charAt2);
                        } else {
                            StringBuilder sb2 = new StringBuilder(83);
                            sb2.append("Expected low surrogate but got char '");
                            sb2.append(charAt2);
                            sb2.append(str3);
                            sb2.append(charAt2);
                            sb2.append(str2);
                            sb2.append(i5);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    }
                }
                if (charAt >= 0) {
                    char[] zzj = zzj(charAt);
                    if (Character.isSupplementaryCodePoint(charAt)) {
                        i6 = 2;
                    }
                    int i8 = i6 + i;
                    if (zzj != null) {
                        int i9 = i - i3;
                        int i10 = i4 + i9;
                        int length2 = zzj.length + i10;
                        if (zzcd.length < length2) {
                            zzcd = zza(zzcd, i4, ((length2 + length) - i) + 32);
                        }
                        if (i9 > 0) {
                            str.getChars(i3, i, zzcd, i4);
                            i4 = i10;
                        }
                        if (zzj.length > 0) {
                            System.arraycopy(zzj, 0, zzcd, i4, zzj.length);
                            i4 += zzj.length;
                        }
                        i3 = i8;
                    }
                    i = zza((CharSequence) str, i8, length);
                } else {
                    throw new IllegalArgumentException("Trailing high surrogate at end of input");
                }
            } else {
                throw new IndexOutOfBoundsException("Index exceeds specified range");
            }
        }
        int i11 = length - i3;
        if (i11 > 0) {
            i2 = i11 + i4;
            if (zzcd.length < i2) {
                zzcd = zza(zzcd, i4, i2);
            }
            str.getChars(i3, length, zzcd, i4);
        } else {
            i2 = i4;
        }
        return new String(zzcd, 0, i2);
    }

    private static char[] zza(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }
}
