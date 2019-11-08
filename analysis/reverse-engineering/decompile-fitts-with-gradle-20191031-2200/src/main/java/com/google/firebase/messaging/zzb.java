package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.Builder;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class zzb {
    private final Executor zza;
    private final Context zzb;
    private final zza zzc;
    private final Bundle zzd;

    public zzb(Context context, Bundle bundle, Executor executor) {
        this.zza = executor;
        this.zzb = context;
        this.zzd = bundle;
        this.zzc = new zza(context, context.getPackageName());
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza() {
        boolean z;
        if ("1".equals(zza.zza(this.zzd, "gcm.n.noui"))) {
            return true;
        }
        if (!((KeyguardManager) this.zzb.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!PlatformVersion.isAtLeastLollipop()) {
                SystemClock.sleep(10);
            }
            int myPid = Process.myPid();
            List runningAppProcesses = ((ActivityManager) this.zzb.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                    if (runningAppProcessInfo.pid == myPid) {
                        if (runningAppProcessInfo.importance == 100) {
                            z = true;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        zzi zza2 = zzi.zza(zza.zza(this.zzd, "gcm.n.image"));
        if (zza2 != null) {
            zza2.zza(this.zza);
        }
        zzc zza3 = this.zzc.zza(this.zzd);
        Builder builder = zza3.zza;
        if (zza2 != null) {
            try {
                Bitmap bitmap = (Bitmap) Tasks.await(zza2.zza(), 5, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));
            } catch (ExecutionException unused) {
            } catch (InterruptedException unused2) {
                zza2.close();
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused3) {
                zza2.close();
            }
        }
        boolean isLoggable = Log.isLoggable("FirebaseMessaging", 3);
        ((NotificationManager) this.zzb.getSystemService("notification")).notify(zza3.zzb, 0, zza3.zza.build());
        return true;
    }
}
