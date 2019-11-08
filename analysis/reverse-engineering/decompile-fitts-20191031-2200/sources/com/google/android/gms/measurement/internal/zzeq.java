package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzeq {
    private boolean value;
    private final String zzjj;
    private final boolean zzmh;
    private boolean zzmi;
    private final /* synthetic */ zzeo zzmj;

    public zzeq(zzeo zzeo, String str, boolean z) {
        this.zzmj = zzeo;
        Preconditions.checkNotEmpty(str);
        this.zzjj = str;
        this.zzmh = z;
    }

    @WorkerThread
    public final boolean get() {
        if (!this.zzmi) {
            this.zzmi = true;
            this.value = this.zzmj.zzhb().getBoolean(this.zzjj, this.zzmh);
        }
        return this.value;
    }

    @WorkerThread
    public final void set(boolean z) {
        Editor edit = this.zzmj.zzhb().edit();
        edit.putBoolean(this.zzjj, z);
        edit.apply();
        this.value = z;
    }
}
