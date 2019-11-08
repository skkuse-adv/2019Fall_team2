package com.google.android.gms.internal.firebase_remote_config;

import java.util.concurrent.Executor;

final /* synthetic */ class zzem implements Executor {
    static final Executor zzko = new zzem();

    private zzem() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
