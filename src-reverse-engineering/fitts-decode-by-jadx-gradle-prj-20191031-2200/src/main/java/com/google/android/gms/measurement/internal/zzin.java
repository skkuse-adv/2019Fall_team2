package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

public final class zzin implements ServiceConnection, BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    final /* synthetic */ zzhv zzrd;
    /* access modifiers changed from: private */
    public volatile boolean zzrt;
    private volatile zzec zzru;

    protected zzin(zzhv zzhv) {
        this.zzrd = zzhv;
    }

    @WorkerThread
    public final void zzb(Intent intent) {
        this.zzrd.zzo();
        Context context = this.zzrd.getContext();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzrt) {
                this.zzrd.zzab().zzgs().zzao("Connection attempt already in progress");
                return;
            }
            this.zzrd.zzab().zzgs().zzao("Using local app measurement service");
            this.zzrt = true;
            instance.bindService(context, intent, this.zzrd.zzre, 129);
        }
    }

    @WorkerThread
    public final void zziw() {
        if (this.zzru != null && (this.zzru.isConnected() || this.zzru.isConnecting())) {
            this.zzru.disconnect();
        }
        this.zzru = null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3.zzrd.zzab().zzgk().zzao("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0062 */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001f
            r3.zzrt = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzhv r4 = r3.zzrd     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "Service connected with null binder"
            r4.zzao(r5)     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r4 = move-exception
            goto L_0x0099
        L_0x001f:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0062 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0062 }
            if (r2 == 0) goto L_0x0052
            if (r5 != 0) goto L_0x002f
            goto L_0x0042
        L_0x002f:
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0062 }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.zzdx     // Catch:{ RemoteException -> 0x0062 }
            if (r2 == 0) goto L_0x003c
            com.google.android.gms.measurement.internal.zzdx r1 = (com.google.android.gms.measurement.internal.zzdx) r1     // Catch:{ RemoteException -> 0x0062 }
            goto L_0x0041
        L_0x003c:
            com.google.android.gms.measurement.internal.zzdz r1 = new com.google.android.gms.measurement.internal.zzdz     // Catch:{ RemoteException -> 0x0062 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0062 }
        L_0x0041:
            r0 = r1
        L_0x0042:
            com.google.android.gms.measurement.internal.zzhv r5 = r3.zzrd     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgs()     // Catch:{ RemoteException -> 0x0062 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.zzao(r1)     // Catch:{ RemoteException -> 0x0062 }
            goto L_0x0071
        L_0x0052:
            com.google.android.gms.measurement.internal.zzhv r5 = r3.zzrd     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ RemoteException -> 0x0062 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zza(r2, r1)     // Catch:{ RemoteException -> 0x0062 }
            goto L_0x0071
        L_0x0062:
            com.google.android.gms.measurement.internal.zzhv r5 = r3.zzrd     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.zzao(r1)     // Catch:{ all -> 0x001c }
        L_0x0071:
            if (r0 != 0) goto L_0x0089
            r3.zzrt = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzhv r5 = r3.zzrd     // Catch:{ IllegalArgumentException -> 0x0097 }
            android.content.Context r5 = r5.getContext()     // Catch:{ IllegalArgumentException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzhv r0 = r3.zzrd     // Catch:{ IllegalArgumentException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzin r0 = r0.zzre     // Catch:{ IllegalArgumentException -> 0x0097 }
            r4.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0097 }
            goto L_0x0097
        L_0x0089:
            com.google.android.gms.measurement.internal.zzhv r4 = r3.zzrd     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzfc r4 = r4.zzaa()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzim r5 = new com.google.android.gms.measurement.internal.zzim     // Catch:{ all -> 0x001c }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001c }
            r4.zza(r5)     // Catch:{ all -> 0x001c }
        L_0x0097:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x0099:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzin.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zzrd.zzab().zzgr().zzao("Service disconnected");
        this.zzrd.zzaa().zza((Runnable) new zzip(this, componentName));
    }

    @WorkerThread
    public final void zzix() {
        this.zzrd.zzo();
        Context context = this.zzrd.getContext();
        synchronized (this) {
            if (this.zzrt) {
                this.zzrd.zzab().zzgs().zzao("Connection attempt already in progress");
            } else if (this.zzru == null || (!this.zzru.isConnecting() && !this.zzru.isConnected())) {
                this.zzru = new zzec(context, Looper.getMainLooper(), this, this);
                this.zzrd.zzab().zzgs().zzao("Connecting to remote service");
                this.zzrt = true;
                this.zzru.checkAvailabilityAndConnect();
            } else {
                this.zzrd.zzab().zzgs().zzao("Already awaiting connection attempt");
            }
        }
    }

    @MainThread
    public final void onConnected(@Nullable Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.zzrd.zzaa().zza((Runnable) new zzio(this, (zzdx) this.zzru.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzru = null;
                this.zzrt = false;
            }
        }
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zzrd.zzab().zzgr().zzao("Service connection suspended");
        this.zzrd.zzaa().zza((Runnable) new zzir(this));
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzef zzhs = this.zzrd.zzj.zzhs();
        if (zzhs != null) {
            zzhs.zzgn().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzrt = false;
            this.zzru = null;
        }
        this.zzrd.zzaa().zza((Runnable) new zziq(this));
    }
}
