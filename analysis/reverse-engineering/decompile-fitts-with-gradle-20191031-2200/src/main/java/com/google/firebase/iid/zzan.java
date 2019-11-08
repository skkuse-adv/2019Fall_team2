package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import java.util.ArrayDeque;
import java.util.Queue;

public final class zzan {
    private static zzan zza;
    @Nullable
    private String zzb = null;
    private Boolean zzc = null;
    private Boolean zzd = null;
    private final Queue<Intent> zze = new ArrayDeque();

    public static synchronized zzan zza() {
        zzan zzan;
        synchronized (zzan.class) {
            if (zza == null) {
                zza = new zzan();
            }
            zzan = zza;
        }
        return zzan;
    }

    private zzan() {
    }

    @MainThread
    public final Intent zzb() {
        return (Intent) this.zze.poll();
    }

    @MainThread
    public final int zza(Context context, Intent intent) {
        boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
        this.zze.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return zzb(context, intent2);
    }

    private final int zzb(Context context, Intent intent) {
        ComponentName componentName;
        String zzc2 = zzc(context, intent);
        if (zzc2 != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String str = "Restricting intent to a specific service: ";
                String valueOf = String.valueOf(zzc2);
                if (valueOf.length() != 0) {
                    str.concat(valueOf);
                } else {
                    new String(str);
                }
            }
            intent.setClassName(context.getPackageName(), zzc2);
        }
        try {
            if (zza(context)) {
                componentName = WakefulBroadcastReceiver.startWakefulService(context, intent);
            } else {
                componentName = context.startService(intent);
            }
            return componentName == null ? 404 : -1;
        } catch (SecurityException unused) {
            return 401;
        } catch (IllegalStateException e) {
            String valueOf2 = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf2);
            sb.toString();
            return 402;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0094, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized java.lang.String zzc(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.zzb     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x0009
            java.lang.String r4 = r3.zzb     // Catch:{ all -> 0x0095 }
            monitor-exit(r3)
            return r4
        L_0x0009:
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch:{ all -> 0x0095 }
            r1 = 0
            android.content.pm.ResolveInfo r5 = r0.resolveService(r5, r1)     // Catch:{ all -> 0x0095 }
            r0 = 0
            if (r5 == 0) goto L_0x0093
            android.content.pm.ServiceInfo r1 = r5.serviceInfo     // Catch:{ all -> 0x0095 }
            if (r1 != 0) goto L_0x001b
            goto L_0x0093
        L_0x001b:
            android.content.pm.ServiceInfo r5 = r5.serviceInfo     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = r4.getPackageName()     // Catch:{ all -> 0x0095 }
            java.lang.String r2 = r5.packageName     // Catch:{ all -> 0x0095 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0095 }
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = r5.name     // Catch:{ all -> 0x0095 }
            if (r1 != 0) goto L_0x002e
            goto L_0x0062
        L_0x002e:
            java.lang.String r0 = r5.name     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = "."
            boolean r0 = r0.startsWith(r1)     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x005a
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x0095 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0095 }
            java.lang.String r5 = r5.name     // Catch:{ all -> 0x0095 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0095 }
            int r0 = r5.length()     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x0051
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0095 }
            goto L_0x0057
        L_0x0051:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0095 }
            r5.<init>(r4)     // Catch:{ all -> 0x0095 }
            r4 = r5
        L_0x0057:
            r3.zzb = r4     // Catch:{ all -> 0x0095 }
            goto L_0x005e
        L_0x005a:
            java.lang.String r4 = r5.name     // Catch:{ all -> 0x0095 }
            r3.zzb = r4     // Catch:{ all -> 0x0095 }
        L_0x005e:
            java.lang.String r4 = r3.zzb     // Catch:{ all -> 0x0095 }
            monitor-exit(r3)
            return r4
        L_0x0062:
            java.lang.String r4 = r5.packageName     // Catch:{ all -> 0x0095 }
            java.lang.String r5 = r5.name     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0095 }
            int r1 = r1.length()     // Catch:{ all -> 0x0095 }
            int r1 = r1 + 94
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0095 }
            int r2 = r2.length()     // Catch:{ all -> 0x0095 }
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0095 }
            r2.<init>(r1)     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = "Error resolving target intent service, skipping classname enforcement. Resolved service was: "
            r2.append(r1)     // Catch:{ all -> 0x0095 }
            r2.append(r4)     // Catch:{ all -> 0x0095 }
            java.lang.String r4 = "/"
            r2.append(r4)     // Catch:{ all -> 0x0095 }
            r2.append(r5)     // Catch:{ all -> 0x0095 }
            r2.toString()     // Catch:{ all -> 0x0095 }
            monitor-exit(r3)
            return r0
        L_0x0093:
            monitor-exit(r3)
            return r0
        L_0x0095:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzan.zzc(android.content.Context, android.content.Intent):java.lang.String");
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(Context context) {
        if (this.zzc == null) {
            this.zzc = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.zzc.booleanValue()) {
            boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.zzc.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzb(Context context) {
        if (this.zzd == null) {
            this.zzd = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.zzc.booleanValue()) {
            boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.zzd.booleanValue();
    }
}
