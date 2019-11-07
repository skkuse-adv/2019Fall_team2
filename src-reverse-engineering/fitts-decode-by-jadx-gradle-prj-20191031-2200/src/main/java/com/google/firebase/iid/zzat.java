package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;

public final class zzat extends Binder {
    private final zzav zza;

    public zzat(zzav zzav) {
        this.zza = zzav;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzax zzax) {
        if (Binder.getCallingUid() == Process.myUid()) {
            boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
            this.zza.zza(zzax.zza).addOnCompleteListener(zzc.zza(), (OnCompleteListener<TResult>) new zzaw<TResult>(zzax));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
