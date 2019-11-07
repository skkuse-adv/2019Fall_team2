package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

class zzem extends BroadcastReceiver {
    /* access modifiers changed from: private */
    public final zzjg zzkz;
    private boolean zzla;
    private boolean zzlb;

    zzem(zzjg zzjg) {
        Preconditions.checkNotNull(zzjg);
        this.zzkz = zzjg;
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.zzkz.zzjj();
        String action = intent.getAction();
        this.zzkz.zzab().zzgs().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzgv = this.zzkz.zzjf().zzgv();
            if (this.zzlb != zzgv) {
                this.zzlb = zzgv;
                this.zzkz.zzaa().zza((Runnable) new zzep(this, zzgv));
            }
            return;
        }
        this.zzkz.zzab().zzgn().zza("NetworkBroadcastReceiver received unknown action", action);
    }

    @WorkerThread
    public final void zzha() {
        this.zzkz.zzjj();
        this.zzkz.zzaa().zzo();
        if (!this.zzla) {
            this.zzkz.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzlb = this.zzkz.zzjf().zzgv();
            this.zzkz.zzab().zzgs().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzlb));
            this.zzla = true;
        }
    }

    @WorkerThread
    public final void unregister() {
        this.zzkz.zzjj();
        this.zzkz.zzaa().zzo();
        this.zzkz.zzaa().zzo();
        if (this.zzla) {
            this.zzkz.zzab().zzgs().zzao("Unregistering connectivity change receiver");
            this.zzla = false;
            this.zzlb = false;
            try {
                this.zzkz.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzkz.zzab().zzgk().zza("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    static {
        Class<zzem> cls = zzem.class;
    }
}
