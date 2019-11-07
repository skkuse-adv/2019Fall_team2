package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzer implements Continuation {
    private final boolean zzkm;
    private final zzes zzky;
    private final long zzkz;

    zzer(zzes zzes, boolean z, long j) {
        this.zzky = zzes;
        this.zzkm = z;
        this.zzkz = j;
    }

    public final Object then(Task task) {
        return this.zzky.zza(this.zzkm, this.zzkz, task);
    }
}
