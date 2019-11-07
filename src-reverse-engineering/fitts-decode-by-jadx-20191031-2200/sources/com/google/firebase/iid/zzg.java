package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzg implements Continuation {
    private final FirebaseInstanceId zza;
    private final String zzb;
    private final String zzc;

    zzg(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.zza = firebaseInstanceId;
        this.zzb = str;
        this.zzc = str2;
    }

    public final Object then(Task task) {
        return this.zza.zza(this.zzb, this.zzc, task);
    }
}
