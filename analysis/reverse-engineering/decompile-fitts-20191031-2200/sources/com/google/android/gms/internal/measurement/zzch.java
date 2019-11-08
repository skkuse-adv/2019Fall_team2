package com.google.android.gms.internal.measurement;

import android.os.Binder;

public final /* synthetic */ class zzch {
    public static <V> V zza(zzcg<V> zzcg) {
        long clearCallingIdentity;
        try {
            return zzcg.zzrj();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzrj = zzcg.zzrj();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzrj;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
