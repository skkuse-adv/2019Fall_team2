package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzae<T> {
    final int zza;
    final TaskCompletionSource<T> zzb = new TaskCompletionSource<>();
    final int zzc;
    final Bundle zzd;

    zzae(int i, int i2, Bundle bundle) {
        this.zza = i;
        this.zzc = i2;
        this.zzd = bundle;
    }

    /* access modifiers changed from: 0000 */
    public abstract void zza(Bundle bundle);

    /* access modifiers changed from: 0000 */
    public abstract boolean zza();

    /* access modifiers changed from: 0000 */
    public final void zza(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            sb.toString();
        }
        this.zzb.setResult(t);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzad zzad) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzad);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            sb.toString();
        }
        this.zzb.setException(zzad);
    }

    public String toString() {
        int i = this.zzc;
        int i2 = this.zza;
        boolean zza2 = zza();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(zza2);
        sb.append("}");
        return sb.toString();
    }
}
