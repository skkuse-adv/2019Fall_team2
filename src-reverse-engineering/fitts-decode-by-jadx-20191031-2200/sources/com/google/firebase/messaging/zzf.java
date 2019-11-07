package com.google.firebase.messaging;

import java.util.concurrent.Executor;

final /* synthetic */ class zzf implements Executor {
    static final Executor zza = new zzf();

    private zzf() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
