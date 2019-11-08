package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzg implements Runnable {
    private final zze zza;
    private final Intent zzb;
    private final TaskCompletionSource zzc;

    zzg(zze zze, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.zza = zze;
        this.zzb = intent;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        zze zze = this.zza;
        Intent intent = this.zzb;
        TaskCompletionSource taskCompletionSource = this.zzc;
        try {
            zze.zzc(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }
}
