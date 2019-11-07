package com.google.android.gms.internal.measurement;

final class zzcr extends zzcm<Double> {
    zzcr(zzct zzct, String str, Double d) {
        super(zzct, str, d, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zze */
    public final Double zzc(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzrm = super.zzrm();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzrm).length() + 27 + String.valueOf(valueOf).length());
        sb.append("Invalid double value for ");
        sb.append(zzrm);
        sb.append(": ");
        sb.append(valueOf);
        sb.toString();
        return null;
    }
}
