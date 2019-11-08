package com.google.firebase.iid;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzh implements SuccessContinuation {
    private final FirebaseInstanceId zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    zzh(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.zza = firebaseInstanceId;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final Task then(Object obj) {
        return this.zza.zza(this.zzb, this.zzc, this.zzd, (String) obj);
    }
}
