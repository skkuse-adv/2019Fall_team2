package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseInstanceId {
    private static final long zza = TimeUnit.HOURS.toSeconds(8);
    private static zzaq zzb;
    private static ScheduledExecutorService zzc;
    private final Executor zzd;
    /* access modifiers changed from: private */
    public final FirebaseApp zze;
    private final zzaf zzf;
    private final zzk zzg;
    private final zzak zzh;
    private final zzau zzi;
    private boolean zzj;
    private final zza zzk;

    private class zza {
        private final boolean zzb = zzc();
        private final Subscriber zzc;
        @Nullable
        private EventHandler<DataCollectionDefaultChange> zzd;
        @Nullable
        private Boolean zze = zzb();

        zza(Subscriber subscriber) {
            this.zzc = subscriber;
            if (this.zze == null && this.zzb) {
                this.zzd = new zzj(this);
                subscriber.subscribe(DataCollectionDefaultChange.class, this.zzd);
            }
        }

        /* access modifiers changed from: 0000 */
        public final synchronized boolean zza() {
            if (this.zze == null) {
                return this.zzb && FirebaseInstanceId.this.zze.isDataCollectionDefaultEnabled();
            }
            return this.zze.booleanValue();
        }

        /* access modifiers changed from: 0000 */
        public final synchronized void zza(boolean z) {
            if (this.zzd != null) {
                this.zzc.unsubscribe(DataCollectionDefaultChange.class, this.zzd);
                this.zzd = null;
            }
            Editor edit = FirebaseInstanceId.this.zze.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseInstanceId.this.zzi();
            }
            this.zze = Boolean.valueOf(z);
        }

        @Nullable
        private final Boolean zzb() {
            String str = "firebase_messaging_auto_init_enabled";
            Context applicationContext = FirebaseInstanceId.this.zze.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            String str2 = "auto_init";
            if (sharedPreferences.contains(str2)) {
                return Boolean.valueOf(sharedPreferences.getBoolean(str2, false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager != null) {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
                    if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str))) {
                        return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                    }
                }
            } catch (NameNotFoundException unused) {
            }
            return null;
        }

        private final boolean zzc() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException unused) {
                Context applicationContext = FirebaseInstanceId.this.zze.getApplicationContext();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(applicationContext.getPackageName());
                ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
                if (resolveService == null || resolveService.serviceInfo == null) {
                    return false;
                }
                return true;
            }
        }
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
    }

    FirebaseInstanceId(FirebaseApp firebaseApp, Subscriber subscriber, UserAgentPublisher userAgentPublisher) {
        this(firebaseApp, new zzaf(firebaseApp.getApplicationContext()), zzc.zzb(), zzc.zzb(), subscriber, userAgentPublisher);
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzaf zzaf, Executor executor, Executor executor2, Subscriber subscriber, UserAgentPublisher userAgentPublisher) {
        this.zzj = false;
        if (zzaf.zza(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (zzb == null) {
                    zzb = new zzaq(firebaseApp.getApplicationContext());
                }
            }
            this.zze = firebaseApp;
            this.zzf = zzaf;
            this.zzg = new zzk(firebaseApp, zzaf, executor, userAgentPublisher);
            this.zzd = executor2;
            this.zzi = new zzau(zzb);
            this.zzk = new zza(subscriber);
            this.zzh = new zzak(executor);
            if (this.zzk.zza()) {
                zzi();
                return;
            }
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* access modifiers changed from: private */
    public final void zzi() {
        if (zza(zzb()) || this.zzi.zza()) {
            zzj();
        }
    }

    /* access modifiers changed from: 0000 */
    public final FirebaseApp zza() {
        return this.zze;
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void zza(boolean z) {
        this.zzj = z;
    }

    private final synchronized void zzj() {
        if (!this.zzj) {
            zza(0);
        }
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void zza(long j) {
        zzas zzas = new zzas(this, this.zzf, this.zzi, Math.min(Math.max(30, j << 1), zza));
        zza((Runnable) zzas, j);
        this.zzj = true;
    }

    static void zza(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (zzc == null) {
                zzc = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            zzc.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    @WorkerThread
    public String getId() {
        zzi();
        return zzk();
    }

    private static String zzk() {
        return zzb.zzb("").zza();
    }

    public long getCreationTime() {
        return zzb.zzb("").zzb();
    }

    @NonNull
    public Task<InstanceIdResult> getInstanceId() {
        return zza(zzaf.zza(this.zze), "*");
    }

    private final Task<InstanceIdResult> zza(String str, String str2) {
        return Tasks.forResult(null).continueWithTask(this.zzd, new zzg(this, str, zzd(str2)));
    }

    @WorkerThread
    public void deleteInstanceId() throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            zza(this.zzg.zza(zzk()));
            zze();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    @Deprecated
    @Nullable
    public String getToken() {
        zzap zzb2 = zzb();
        if (zza(zzb2)) {
            zzj();
        }
        return zzap.zza(zzb2);
    }

    @WorkerThread
    public String getToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) zza(zza(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public final zzap zzb() {
        return zzb(zzaf.zza(this.zze), "*");
    }

    @Nullable
    private static zzap zzb(String str, String str2) {
        return zzb.zza("", str, str2);
    }

    /* access modifiers changed from: 0000 */
    public final String zzc() throws IOException {
        return getToken(zzaf.zza(this.zze), "*");
    }

    private final <T> T zza(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    zze();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    @WorkerThread
    public void deleteToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String zzd2 = zzd(str2);
            zza(this.zzg.zzb(zzk(), str, zzd2));
            zzb.zzb("", str, zzd2);
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public final synchronized Task<Void> zza(String str) {
        Task<Void> zza2;
        zza2 = this.zzi.zza(str);
        zzj();
        return zza2;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(String str) throws IOException {
        zzap zzb2 = zzb();
        if (!zza(zzb2)) {
            zza(this.zzg.zzc(zzk(), zzb2.zza, str));
            return;
        }
        throw new IOException("token not available");
    }

    /* access modifiers changed from: 0000 */
    public final void zzc(String str) throws IOException {
        zzap zzb2 = zzb();
        if (!zza(zzb2)) {
            zza(this.zzg.zzd(zzk(), zzb2.zza, str));
            return;
        }
        throw new IOException("token not available");
    }

    static boolean zzd() {
        String str = "FirebaseInstanceId";
        return Log.isLoggable(str, 3) || (VERSION.SDK_INT == 23 && Log.isLoggable(str, 3));
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void zze() {
        zzb.zzb();
        if (this.zzk.zza()) {
            zzj();
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzf() {
        return this.zzf.zza() != 0;
    }

    /* access modifiers changed from: 0000 */
    public final void zzg() {
        zzb.zzc("");
        zzj();
    }

    public final boolean zzh() {
        return this.zzk.zza();
    }

    public final void zzb(boolean z) {
        this.zzk.zza(z);
    }

    private static String zzd(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(@Nullable zzap zzap) {
        return zzap == null || zzap.zzb(this.zzf.zzb());
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Task zza(String str, String str2, Task task) throws Exception {
        String zzk2 = zzk();
        zzap zzb2 = zzb(str, str2);
        if (!zza(zzb2)) {
            return Tasks.forResult(new zzt(zzk2, zzb2.zza));
        }
        return this.zzh.zza(str, str2, new zzi(this, zzk2, str, str2));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Task zza(String str, String str2, String str3) {
        return this.zzg.zza(str, str2, str3).onSuccessTask(this.zzd, new zzh(this, str2, str3, str));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Task zza(String str, String str2, String str3, String str4) throws Exception {
        zzb.zza("", str, str2, str4, this.zzf.zzb());
        return Tasks.forResult(new zzt(str3, str4));
    }
}
