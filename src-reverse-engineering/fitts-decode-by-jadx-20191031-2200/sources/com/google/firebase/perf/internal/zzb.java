package com.google.firebase.perf.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.firebase-perf.zzbt;
import com.google.firebase.perf.internal.zza.C0000zza;
import java.lang.ref.WeakReference;

public class zzb implements C0000zza {
    private zza zzcj;
    private zzbt zzck;
    private boolean zzcl;
    private WeakReference<C0000zza> zzcm;

    protected zzb() {
        this(zza.zzaj());
    }

    protected zzb(@NonNull zza zza) {
        this.zzck = zzbt.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.zzcl = false;
        this.zzcj = zza;
        this.zzcm = new WeakReference<>(this);
    }

    /* access modifiers changed from: protected */
    public final void zzay() {
        if (!this.zzcl) {
            this.zzck = this.zzcj.zzal();
            this.zzcj.zza(this.zzcm);
            this.zzcl = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaz() {
        if (this.zzcl) {
            this.zzcj.zzb(this.zzcm);
            this.zzcl = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(int i) {
        this.zzcj.zzc(1);
    }

    public void zza(zzbt zzbt) {
        zzbt zzbt2 = this.zzck;
        zzbt zzbt3 = zzbt.APPLICATION_PROCESS_STATE_UNKNOWN;
        if (zzbt2 == zzbt3) {
            this.zzck = zzbt;
            return;
        }
        if (!(zzbt2 == zzbt || zzbt == zzbt3)) {
            this.zzck = zzbt.FOREGROUND_BACKGROUND;
        }
    }

    public final zzbt zzal() {
        return this.zzck;
    }
}
