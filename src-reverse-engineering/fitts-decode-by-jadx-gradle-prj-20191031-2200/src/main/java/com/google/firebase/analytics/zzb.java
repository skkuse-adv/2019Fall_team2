package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zzb implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zzaca;

    zzb(FirebaseAnalytics firebaseAnalytics) {
        this.zzaca = firebaseAnalytics;
    }

    public final /* synthetic */ Object call() throws Exception {
        String str;
        String zza = this.zzaca.zzi();
        if (zza != null) {
            return zza;
        }
        if (this.zzaca.zzl) {
            str = this.zzaca.zzabu.getAppInstanceId();
        } else {
            str = this.zzaca.zzj.zzq().zzy(120000);
        }
        if (str != null) {
            this.zzaca.zzbg(str);
            return str;
        }
        throw new TimeoutException();
    }
}
