package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.io.IOException;

final class zzas implements Runnable {
    private final long zza;
    private final WakeLock zzb = ((PowerManager) zza().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId zzc;
    private final zzau zzd;

    zzas(FirebaseInstanceId firebaseInstanceId, zzaf zzaf, zzau zzau, long j) {
        this.zzc = firebaseInstanceId;
        this.zzd = zzau;
        this.zza = j;
        this.zzb.setReferenceCounted(false);
    }

    @SuppressLint({"Wakelock"})
    public final void run() {
        if (zzan.zza().zza(zza())) {
            this.zzb.acquire();
        }
        try {
            this.zzc.zza(true);
            if (!this.zzc.zzf()) {
                this.zzc.zza(false);
                if (zzan.zza().zza(zza())) {
                    this.zzb.release();
                }
            } else if (!zzan.zza().zzb(zza()) || zzb()) {
                if (!zzc() || !this.zzd.zza(this.zzc)) {
                    this.zzc.zza(this.zza);
                } else {
                    this.zzc.zza(false);
                }
                if (zzan.zza().zza(zza())) {
                    this.zzb.release();
                }
            } else {
                new zzar(this).zza();
                if (zzan.zza().zza(zza())) {
                    this.zzb.release();
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            sb.toString();
            this.zzc.zza(false);
            if (zzan.zza().zza(zza())) {
                this.zzb.release();
            }
        } catch (Throwable th) {
            if (zzan.zza().zza(zza())) {
                this.zzb.release();
            }
            throw th;
        }
    }

    private final boolean zzc() throws IOException {
        String str = "FirebaseInstanceId";
        zzap zzb2 = this.zzc.zzb();
        if (!this.zzc.zza(zzb2)) {
            return true;
        }
        try {
            String zzc2 = this.zzc.zzc();
            if (zzc2 == null) {
                return false;
            }
            boolean isLoggable = Log.isLoggable(str, 3);
            if ((zzb2 == null || (zzb2 != null && !zzc2.equals(zzb2.zza))) && FirebaseApp.DEFAULT_APP_NAME.equals(this.zzc.zza().getName())) {
                if (Log.isLoggable(str, 3)) {
                    String str2 = "Invoking onNewToken for app: ";
                    String valueOf = String.valueOf(this.zzc.zza().getName());
                    if (valueOf.length() != 0) {
                        str2.concat(valueOf);
                    } else {
                        new String(str2);
                    }
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", zzc2);
                Context zza2 = zza();
                Intent intent2 = new Intent(zza2, FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                zza2.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException e) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e.getMessage())) {
                if (!"INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                    if (e.getMessage() == null) {
                        String message = e.getMessage();
                        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                        sb.append("Token retrieval failed: ");
                        sb.append(message);
                        sb.append(". Will retry token retrieval");
                        sb.toString();
                        return false;
                    }
                    throw e;
                }
            }
            return false;
        } catch (SecurityException unused) {
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final Context zza() {
        return this.zzc.zza().getApplicationContext();
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzb() {
        ConnectivityManager connectivityManager = (ConnectivityManager) zza().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
