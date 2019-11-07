package com.google.android.gms.internal.measurement;

final class zzcp extends zzcm<Long> {
    zzcp(zzct zzct, String str, Long l) {
        super(zzct, str, l, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final Long zzc(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzrm = super.zzrm();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzrm).length() + 25 + String.valueOf(valueOf).length());
        sb.append("Invalid long value for ");
        sb.append(zzrm);
        sb.append(": ");
        sb.append(valueOf);
        sb.toString();
        return null;
    }
}
