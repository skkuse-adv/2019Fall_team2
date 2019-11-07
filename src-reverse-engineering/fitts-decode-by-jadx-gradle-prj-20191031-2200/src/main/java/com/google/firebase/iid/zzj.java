package com.google.firebase.iid;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

final /* synthetic */ class zzj implements EventHandler {
    private final zza zza;

    zzj(zza zza2) {
        this.zza = zza2;
    }

    public final void handle(Event event) {
        zza zza2 = this.zza;
        synchronized (zza2) {
            if (zza2.zza()) {
                FirebaseInstanceId.this.zzi();
            }
        }
    }
}
