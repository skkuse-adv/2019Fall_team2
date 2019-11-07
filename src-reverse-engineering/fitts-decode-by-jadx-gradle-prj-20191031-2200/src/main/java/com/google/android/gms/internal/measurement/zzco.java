package com.google.android.gms.internal.measurement;

final class zzco extends zzcm<Boolean> {
    zzco(zzct zzct, String str, Boolean bool) {
        super(zzct, str, bool, null);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzc(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzbz.zzzw.matcher(str).matches()) {
                return Boolean.valueOf(true);
            }
            if (zzbz.zzzx.matcher(str).matches()) {
                return Boolean.valueOf(false);
            }
        }
        String zzrm = super.zzrm();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzrm).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(zzrm);
        sb.append(": ");
        sb.append(valueOf);
        sb.toString();
        return null;
    }
}
