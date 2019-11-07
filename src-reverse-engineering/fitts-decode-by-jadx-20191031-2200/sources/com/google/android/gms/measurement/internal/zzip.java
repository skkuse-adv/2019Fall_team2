package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class zzip implements Runnable {
    private final /* synthetic */ ComponentName val$name;
    private final /* synthetic */ zzin zzrs;

    zzip(zzin zzin, ComponentName componentName) {
        this.zzrs = zzin;
        this.val$name = componentName;
    }

    public final void run() {
        this.zzrs.zzrd.onServiceDisconnected(this.val$name);
    }
}
