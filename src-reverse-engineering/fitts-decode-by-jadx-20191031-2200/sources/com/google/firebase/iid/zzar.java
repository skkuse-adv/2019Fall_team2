package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

final class zzar extends BroadcastReceiver {
    private zzas zza;

    public zzar(zzas zzas) {
        this.zza = zzas;
    }

    public final void zza() {
        boolean zzd = FirebaseInstanceId.zzd();
        this.zza.zza().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        zzas zzas = this.zza;
        if (zzas != null && zzas.zzb()) {
            boolean zzd = FirebaseInstanceId.zzd();
            FirebaseInstanceId.zza((Runnable) this.zza, 0);
            this.zza.zza().unregisterReceiver(this);
            this.zza = null;
        }
    }
}
