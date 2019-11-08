package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzcc extends ContentObserver {
    private final /* synthetic */ zzca zzaaq;

    zzcc(zzca zzca, Handler handler) {
        this.zzaaq = zzca;
        super(null);
    }

    public final void onChange(boolean z) {
        this.zzaaq.zzrf();
    }
}
