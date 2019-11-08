package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class zzay implements ServiceConnection {
    private final Context zza;
    private final Intent zzb;
    private final ScheduledExecutorService zzc;
    private final Queue<zzax> zzd;
    @Nullable
    private zzat zze;
    @GuardedBy("this")
    private boolean zzf;

    public zzay(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    @VisibleForTesting
    private zzay(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zzd = new ArrayDeque();
        this.zzf = false;
        this.zza = context.getApplicationContext();
        this.zzb = new Intent(str).setPackage(this.zza.getPackageName());
        this.zzc = scheduledExecutorService;
    }

    public final synchronized void zza(Intent intent, PendingResult pendingResult) {
        boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
        this.zzd.add(new zzax(intent, pendingResult, this.zzc));
        zza();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:20|21|22|(2:24|25)|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0071 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zza() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "FirebaseInstanceId"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x007a }
        L_0x0008:
            java.util.Queue<com.google.firebase.iid.zzax> r0 = r5.zzd     // Catch:{ all -> 0x007a }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0078
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x007a }
            com.google.firebase.iid.zzat r0 = r5.zze     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0036
            com.google.firebase.iid.zzat r0 = r5.zze     // Catch:{ all -> 0x007a }
            boolean r0 = r0.isBinderAlive()     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x007a }
            java.util.Queue<com.google.firebase.iid.zzax> r0 = r5.zzd     // Catch:{ all -> 0x007a }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x007a }
            com.google.firebase.iid.zzax r0 = (com.google.firebase.iid.zzax) r0     // Catch:{ all -> 0x007a }
            com.google.firebase.iid.zzat r2 = r5.zze     // Catch:{ all -> 0x007a }
            r2.zza(r0)     // Catch:{ all -> 0x007a }
            goto L_0x0008
        L_0x0036:
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x007a }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0059
            boolean r0 = r5.zzf     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            r3 = 39
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            r4.<init>(r3)     // Catch:{ all -> 0x007a }
            java.lang.String r3 = "binder is dead. start connection? "
            r4.append(r3)     // Catch:{ all -> 0x007a }
            r4.append(r0)     // Catch:{ all -> 0x007a }
            r4.toString()     // Catch:{ all -> 0x007a }
        L_0x0059:
            boolean r0 = r5.zzf     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0076
            r5.zzf = r2     // Catch:{ all -> 0x007a }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ SecurityException -> 0x0071 }
            android.content.Context r2 = r5.zza     // Catch:{ SecurityException -> 0x0071 }
            android.content.Intent r3 = r5.zzb     // Catch:{ SecurityException -> 0x0071 }
            r4 = 65
            boolean r0 = r0.bindService(r2, r3, r5, r4)     // Catch:{ SecurityException -> 0x0071 }
            if (r0 == 0) goto L_0x0071
            monitor-exit(r5)
            return
        L_0x0071:
            r5.zzf = r1     // Catch:{ all -> 0x007a }
            r5.zzb()     // Catch:{ all -> 0x007a }
        L_0x0076:
            monitor-exit(r5)
            return
        L_0x0078:
            monitor-exit(r5)
            return
        L_0x007a:
            r0 = move-exception
            monitor-exit(r5)
            goto L_0x007e
        L_0x007d:
            throw r0
        L_0x007e:
            goto L_0x007d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzay.zza():void");
    }

    @GuardedBy("this")
    private final void zzb() {
        while (!this.zzd.isEmpty()) {
            ((zzax) this.zzd.poll()).zza();
        }
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            sb.toString();
        }
        this.zzf = false;
        if (!(iBinder instanceof zzat)) {
            String valueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(valueOf2);
            sb2.toString();
            zzb();
            return;
        }
        this.zze = (zzat) iBinder;
        zza();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            sb.toString();
        }
        zza();
    }
}
