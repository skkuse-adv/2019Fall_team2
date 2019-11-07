package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

final /* synthetic */ class zzeu implements SuccessContinuation {
    static final SuccessContinuation zzjk = new zzeu();

    private zzeu() {
    }

    public final Task then(Object obj) {
        return Tasks.forResult(zzet.zzg((zzen) obj));
    }
}
