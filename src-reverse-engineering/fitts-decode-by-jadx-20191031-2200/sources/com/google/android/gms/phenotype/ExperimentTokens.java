package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExperimentTokens extends AbstractSafeParcelable {
    public static final Creator<ExperimentTokens> CREATOR = new zzh();
    private static final byte[][] zzn = new byte[0][];
    private final String zzp;
    private final byte[] zzq;
    private final byte[][] zzr;
    private final byte[][] zzs;
    private final byte[][] zzt;
    private final byte[][] zzu;
    private final int[] zzv;
    private final byte[][] zzw;

    private interface zza {
    }

    static {
        byte[][] bArr = zzn;
        new ExperimentTokens("", null, bArr, bArr, bArr, bArr, null, null);
        new zzd();
        new zze();
        new zzf();
        new zzg();
    }

    public ExperimentTokens(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.zzp = str;
        this.zzq = bArr;
        this.zzr = bArr2;
        this.zzs = bArr3;
        this.zzt = bArr4;
        this.zzu = bArr5;
        this.zzv = iArr;
        this.zzw = bArr6;
    }

    private static List<Integer> zza(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static List<String> zza(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] encodeToString : bArr) {
            arrayList.add(Base64.encodeToString(encodeToString, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void zza(StringBuilder sb, String str, byte[][] bArr) {
        String str2;
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            str2 = "null";
        } else {
            sb.append("(");
            int length = bArr.length;
            int i = 0;
            boolean z = true;
            while (i < length) {
                byte[] bArr2 = bArr[i];
                if (!z) {
                    sb.append(", ");
                }
                String str3 = "'";
                sb.append(str3);
                sb.append(Base64.encodeToString(bArr2, 3));
                sb.append(str3);
                i++;
                z = false;
            }
            str2 = ")";
        }
        sb.append(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExperimentTokens) {
            ExperimentTokens experimentTokens = (ExperimentTokens) obj;
            if (zzn.equals(this.zzp, experimentTokens.zzp) && Arrays.equals(this.zzq, experimentTokens.zzq) && zzn.equals(zza(this.zzr), zza(experimentTokens.zzr)) && zzn.equals(zza(this.zzs), zza(experimentTokens.zzs)) && zzn.equals(zza(this.zzt), zza(experimentTokens.zzt)) && zzn.equals(zza(this.zzu), zza(experimentTokens.zzu)) && zzn.equals(zza(this.zzv), zza(experimentTokens.zzv)) && zzn.equals(zza(this.zzw), zza(experimentTokens.zzw))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ExperimentTokens");
        String str2 = "(";
        sb.append(str2);
        String str3 = this.zzp;
        String str4 = "null";
        String str5 = "'";
        if (str3 == null) {
            str = str4;
        } else {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 2);
            sb2.append(str5);
            sb2.append(str3);
            sb2.append(str5);
            str = sb2.toString();
        }
        sb.append(str);
        String str6 = ", ";
        sb.append(str6);
        byte[] bArr = this.zzq;
        sb.append("direct");
        String str7 = "=";
        sb.append(str7);
        if (bArr == null) {
            sb.append(str4);
        } else {
            sb.append(str5);
            sb.append(Base64.encodeToString(bArr, 3));
            sb.append(str5);
        }
        sb.append(str6);
        zza(sb, "GAIA", this.zzr);
        sb.append(str6);
        zza(sb, "PSEUDO", this.zzs);
        sb.append(str6);
        zza(sb, "ALWAYS", this.zzt);
        sb.append(str6);
        zza(sb, "OTHER", this.zzu);
        sb.append(str6);
        int[] iArr = this.zzv;
        sb.append("weak");
        sb.append(str7);
        String str8 = ")";
        if (iArr == null) {
            sb.append(str4);
        } else {
            sb.append(str2);
            int length = iArr.length;
            int i = 0;
            boolean z = true;
            while (i < length) {
                int i2 = iArr[i];
                if (!z) {
                    sb.append(str6);
                }
                sb.append(i2);
                i++;
                z = false;
            }
            sb.append(str8);
        }
        sb.append(str6);
        zza(sb, "directs", this.zzw);
        sb.append(str8);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzp, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzq, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 4, this.zzr, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 5, this.zzs, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 6, this.zzt, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 7, this.zzu, false);
        SafeParcelWriter.writeIntArray(parcel, 8, this.zzv, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 9, this.zzw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
