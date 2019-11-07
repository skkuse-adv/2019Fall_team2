package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;

public final class zzu {
    private static zzu zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    private zzv zzd = new zzv(this);
    private int zze = 1;

    public static synchronized zzu zza(Context context) {
        zzu zzu;
        synchronized (zzu.class) {
            if (zza == null) {
                zza = new zzu(context, zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zza));
            }
            zzu = zza;
        }
        return zzu;
    }

    @VisibleForTesting
    private zzu(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public final Task<Void> zza(int i, Bundle bundle) {
        return zza((zzae<T>) new zzab<T>(zza(), 2, bundle));
    }

    public final Task<Bundle> zzb(int i, Bundle bundle) {
        return zza((zzae<T>) new zzag<T>(zza(), 1, bundle));
    }

    private final synchronized <T> Task<T> zza(zzae<T> zzae) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzae);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            sb.toString();
        }
        if (!this.zzd.zza(zzae)) {
            this.zzd = new zzv(this);
            this.zzd.zza(zzae);
        }
        return zzae.zzb.getTask();
    }

    private final synchronized int zza() {
        int i;
        i = this.zze;
        this.zze = i + 1;
        return i;
    }
}
