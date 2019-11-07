package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzh implements OnCompleteListener {
    private final zze zza;
    private final Intent zzb;

    zzh(zze zze, Intent intent) {
        this.zza = zze;
        this.zzb = intent;
    }

    public final void onComplete(Task task) {
        this.zza.zza(this.zzb, task);
    }
}
