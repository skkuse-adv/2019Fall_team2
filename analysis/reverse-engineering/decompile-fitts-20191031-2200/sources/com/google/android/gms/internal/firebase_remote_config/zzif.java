package com.google.android.gms.internal.firebase_remote_config;

final class zzif implements zzin {
    private zzin[] zzvh;

    zzif(zzin... zzinArr) {
        this.zzvh = zzinArr;
    }

    public final boolean zzh(Class<?> cls) {
        for (zzin zzh : this.zzvh) {
            if (zzh.zzh(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzio zzi(Class<?> cls) {
        zzin[] zzinArr;
        for (zzin zzin : this.zzvh) {
            if (zzin.zzh(cls)) {
                return zzin.zzi(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
