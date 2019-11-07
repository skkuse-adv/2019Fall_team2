package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzz;
import com.google.android.gms.measurement.internal.zzfj;
import com.google.android.gms.measurement.internal.zzhi;
import com.google.android.gms.measurement.internal.zzr;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.FirebaseInstanceId;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zzabt;
    /* access modifiers changed from: private */
    public final zzz zzabu;
    private String zzabv;
    private long zzabw;
    private final Object zzabx;
    private ExecutorService zzad;
    /* access modifiers changed from: private */
    public final zzfj zzj;
    /* access modifiers changed from: private */
    public final boolean zzl;

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @NonNull
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (zzabt == null) {
            synchronized (FirebaseAnalytics.class) {
                if (zzabt == null) {
                    if (zzz.zzf(context)) {
                        zzabt = new FirebaseAnalytics(zzz.zza(context));
                    } else {
                        zzabt = new FirebaseAnalytics(zzfj.zza(context, (zzx) null));
                    }
                }
            }
        }
        return zzabt;
    }

    public final void logEvent(@Size(max = 40, min = 1) @NonNull String str, @Nullable Bundle bundle) {
        if (this.zzl) {
            this.zzabu.logEvent(str, bundle);
        } else {
            this.zzj.zzq().zza(SettingsJsonConstants.APP_KEY, str, bundle, true);
        }
    }

    public final void setUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Size(max = 36) @Nullable String str2) {
        if (this.zzl) {
            this.zzabu.setUserProperty(str, str2);
        } else {
            this.zzj.zzq().zzb(SettingsJsonConstants.APP_KEY, str, (Object) str2, false);
        }
    }

    @MainThread
    @Keep
    public final void setCurrentScreen(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        if (this.zzl) {
            this.zzabu.setCurrentScreen(activity, str, str2);
        } else if (!zzr.isMainThread()) {
            this.zzj.zzab().zzgn().zzao("setCurrentScreen must be called from the main thread");
        } else {
            this.zzj.zzt().setCurrentScreen(activity, str, str2);
        }
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        if (this.zzl) {
            this.zzabu.setMeasurementEnabled(z);
        } else {
            this.zzj.zzq().setMeasurementEnabled(z);
        }
    }

    public final void setUserId(@Nullable String str) {
        if (this.zzl) {
            this.zzabu.setUserId(str);
        } else {
            this.zzj.zzq().zzb(SettingsJsonConstants.APP_KEY, "_id", (Object) str, true);
        }
    }

    @Deprecated
    public final void setMinimumSessionDuration(long j) {
        if (this.zzl) {
            this.zzabu.setMinimumSessionDuration(j);
        } else {
            this.zzj.zzq().setMinimumSessionDuration(j);
        }
    }

    public final void setSessionTimeoutDuration(long j) {
        if (this.zzl) {
            this.zzabu.setSessionTimeoutDuration(j);
        } else {
            this.zzj.zzq().setSessionTimeoutDuration(j);
        }
    }

    private final ExecutorService zzrq() {
        ExecutorService executorService;
        synchronized (FirebaseAnalytics.class) {
            if (this.zzad == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
                this.zzad = threadPoolExecutor;
            }
            executorService = this.zzad;
        }
        return executorService;
    }

    @NonNull
    public final Task<String> getAppInstanceId() {
        try {
            String zzi = zzi();
            if (zzi != null) {
                return Tasks.forResult(zzi);
            }
            return Tasks.call(zzrq(), new zzb(this));
        } catch (Exception e) {
            if (this.zzl) {
                this.zzabu.zza(5, "Failed to schedule task for getAppInstanceId", (Object) null, (Object) null, (Object) null);
            } else {
                this.zzj.zzab().zzgn().zzao("Failed to schedule task for getAppInstanceId");
            }
            return Tasks.forException(e);
        }
    }

    private FirebaseAnalytics(zzfj zzfj) {
        Preconditions.checkNotNull(zzfj);
        this.zzj = zzfj;
        this.zzabu = null;
        this.zzl = false;
        this.zzabx = new Object();
    }

    private FirebaseAnalytics(zzz zzz) {
        Preconditions.checkNotNull(zzz);
        this.zzj = null;
        this.zzabu = zzz;
        this.zzl = true;
        this.zzabx = new Object();
    }

    public final void resetAnalyticsData() {
        zzbg(null);
        if (this.zzl) {
            this.zzabu.resetAnalyticsData();
        } else {
            this.zzj.zzq().resetAnalyticsData(this.zzj.zzx().currentTimeMillis());
        }
    }

    @Keep
    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.getInstance().getId();
    }

    /* access modifiers changed from: private */
    public final void zzbg(String str) {
        synchronized (this.zzabx) {
            this.zzabv = str;
            if (this.zzl) {
                this.zzabw = DefaultClock.getInstance().elapsedRealtime();
            } else {
                this.zzabw = this.zzj.zzx().elapsedRealtime();
            }
        }
    }

    /* access modifiers changed from: private */
    public final String zzi() {
        long j;
        synchronized (this.zzabx) {
            if (this.zzl) {
                j = DefaultClock.getInstance().elapsedRealtime();
            } else {
                j = this.zzj.zzx().elapsedRealtime();
            }
            if (Math.abs(j - this.zzabw) >= 1000) {
                return null;
            }
            String str = this.zzabv;
            return str;
        }
    }

    @Keep
    public static zzhi getScionFrontendApiImplementation(Context context, Bundle bundle) {
        if (!zzz.zzf(context)) {
            return null;
        }
        zzz zza = zzz.zza(context, (String) null, (String) null, (String) null, bundle);
        if (zza == null) {
            return null;
        }
        return new zza(zza);
    }
}
