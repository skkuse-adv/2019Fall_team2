package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.firebase_messaging.zze;
import java.util.ArrayDeque;
import java.util.Queue;

final class zzv implements ServiceConnection {
    int zza;
    final Messenger zzb;
    zzac zzc;
    final Queue<zzae<?>> zzd;
    final SparseArray<zzae<?>> zze;
    final /* synthetic */ zzu zzf;

    private zzv(zzu zzu) {
        this.zzf = zzu;
        this.zza = 0;
        this.zzb = new Messenger(new zze(Looper.getMainLooper(), new zzy(this)));
        this.zzd = new ArrayDeque();
        this.zze = new SparseArray<>();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008d, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zza(com.google.firebase.iid.zzae<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.zza     // Catch:{ all -> 0x008e }
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0041
            if (r0 == r3) goto L_0x003a
            if (r0 == r1) goto L_0x0030
            r6 = 3
            if (r0 == r6) goto L_0x002e
            r6 = 4
            if (r0 != r6) goto L_0x0013
            goto L_0x002e
        L_0x0013:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008e }
            int r0 = r5.zza     // Catch:{ all -> 0x008e }
            r1 = 26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r2.<init>(r1)     // Catch:{ all -> 0x008e }
            java.lang.String r1 = "Unknown state: "
            r2.append(r1)     // Catch:{ all -> 0x008e }
            r2.append(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x008e }
            r6.<init>(r0)     // Catch:{ all -> 0x008e }
            throw r6     // Catch:{ all -> 0x008e }
        L_0x002e:
            monitor-exit(r5)
            return r2
        L_0x0030:
            java.util.Queue<com.google.firebase.iid.zzae<?>> r0 = r5.zzd     // Catch:{ all -> 0x008e }
            r0.add(r6)     // Catch:{ all -> 0x008e }
            r5.zzc()     // Catch:{ all -> 0x008e }
            monitor-exit(r5)
            return r3
        L_0x003a:
            java.util.Queue<com.google.firebase.iid.zzae<?>> r0 = r5.zzd     // Catch:{ all -> 0x008e }
            r0.add(r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r5)
            return r3
        L_0x0041:
            java.util.Queue<com.google.firebase.iid.zzae<?>> r0 = r5.zzd     // Catch:{ all -> 0x008e }
            r0.add(r6)     // Catch:{ all -> 0x008e }
            int r6 = r5.zza     // Catch:{ all -> 0x008e }
            if (r6 != 0) goto L_0x004c
            r6 = 1
            goto L_0x004d
        L_0x004c:
            r6 = 0
        L_0x004d:
            com.google.android.gms.common.internal.Preconditions.checkState(r6)     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "MessengerIpcClient"
            boolean r6 = android.util.Log.isLoggable(r6, r1)     // Catch:{ all -> 0x008e }
            r5.zza = r3     // Catch:{ all -> 0x008e }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x008e }
            java.lang.String r0 = "com.google.android.c2dm.intent.REGISTER"
            r6.<init>(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = "com.google.android.gms"
            r6.setPackage(r0)     // Catch:{ all -> 0x008e }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ all -> 0x008e }
            com.google.firebase.iid.zzu r1 = r5.zzf     // Catch:{ all -> 0x008e }
            android.content.Context r1 = r1.zzb     // Catch:{ all -> 0x008e }
            boolean r6 = r0.bindService(r1, r6, r5, r3)     // Catch:{ all -> 0x008e }
            if (r6 != 0) goto L_0x007a
            java.lang.String r6 = "Unable to bind to service"
            r5.zza(r2, r6)     // Catch:{ all -> 0x008e }
            goto L_0x008c
        L_0x007a:
            com.google.firebase.iid.zzu r6 = r5.zzf     // Catch:{ all -> 0x008e }
            java.util.concurrent.ScheduledExecutorService r6 = r6.zzc     // Catch:{ all -> 0x008e }
            com.google.firebase.iid.zzx r0 = new com.google.firebase.iid.zzx     // Catch:{ all -> 0x008e }
            r0.<init>(r5)     // Catch:{ all -> 0x008e }
            r1 = 30
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x008e }
            r6.schedule(r0, r1, r4)     // Catch:{ all -> 0x008e }
        L_0x008c:
            monitor-exit(r5)
            return r3
        L_0x008e:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzv.zza(com.google.firebase.iid.zzae):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        r1.zza(new com.google.firebase.iid.zzad(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
        r1.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0062, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(android.os.Message r5) {
        /*
            r4 = this;
            int r0 = r5.arg1
            java.lang.String r1 = "MessengerIpcClient"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)
            if (r1 == 0) goto L_0x001d
            r1 = 41
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Received response to request: "
            r2.append(r1)
            r2.append(r0)
            r2.toString()
        L_0x001d:
            monitor-enter(r4)
            android.util.SparseArray<com.google.firebase.iid.zzae<?>> r1 = r4.zze     // Catch:{ all -> 0x0063 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0063 }
            com.google.firebase.iid.zzae r1 = (com.google.firebase.iid.zzae) r1     // Catch:{ all -> 0x0063 }
            r2 = 1
            if (r1 != 0) goto L_0x003d
            r5 = 50
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r1.<init>(r5)     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "Received response for unknown request: "
            r1.append(r5)     // Catch:{ all -> 0x0063 }
            r1.append(r0)     // Catch:{ all -> 0x0063 }
            r1.toString()     // Catch:{ all -> 0x0063 }
            monitor-exit(r4)     // Catch:{ all -> 0x0063 }
            return r2
        L_0x003d:
            android.util.SparseArray<com.google.firebase.iid.zzae<?>> r3 = r4.zze     // Catch:{ all -> 0x0063 }
            r3.remove(r0)     // Catch:{ all -> 0x0063 }
            r4.zza()     // Catch:{ all -> 0x0063 }
            monitor-exit(r4)     // Catch:{ all -> 0x0063 }
            android.os.Bundle r5 = r5.getData()
            r0 = 0
            java.lang.String r3 = "unsupported"
            boolean r0 = r5.getBoolean(r3, r0)
            if (r0 == 0) goto L_0x005f
            com.google.firebase.iid.zzad r5 = new com.google.firebase.iid.zzad
            r0 = 4
            java.lang.String r3 = "Not supported by GmsCore"
            r5.<init>(r0, r3)
            r1.zza(r5)
            goto L_0x0062
        L_0x005f:
            r1.zza(r5)
        L_0x0062:
            return r2
        L_0x0063:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0063 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzv.zza(android.os.Message):boolean");
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
        if (iBinder == null) {
            zza(0, "Null service connection");
            return;
        }
        try {
            this.zzc = new zzac(iBinder);
            this.zza = 2;
            zzc();
        } catch (RemoteException e) {
            zza(0, e.getMessage());
        }
    }

    private final void zzc() {
        this.zzf.zzc.execute(new zzaa(this));
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
        zza(2, "Service disconnected");
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void zza(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String str2 = "Disconnected: ";
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                new String(str2);
            }
        }
        int i2 = this.zza;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
            this.zza = 4;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
            zzad zzad = new zzad(i, str);
            for (zzae zza2 : this.zzd) {
                zza2.zza(zzad);
            }
            this.zzd.clear();
            for (int i3 = 0; i3 < this.zze.size(); i3++) {
                ((zzae) this.zze.valueAt(i3)).zza(zzad);
            }
            this.zze.clear();
        } else if (i2 == 3) {
            this.zza = 4;
        } else if (i2 != 4) {
            int i4 = this.zza;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i4);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void zza() {
        if (this.zza == 2 && this.zzd.isEmpty() && this.zze.size() == 0) {
            boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
            this.zza = 3;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
        }
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void zzb() {
        if (this.zza == 1) {
            zza(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void zza(int i) {
        zzae zzae = (zzae) this.zze.get(i);
        if (zzae != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            sb.toString();
            this.zze.remove(i);
            zzae.zza(new zzad(3, "Timed out waiting for response"));
            zza();
        }
    }
}
