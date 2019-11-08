package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_remote_config.zzab;
import com.google.android.gms.internal.firebase_remote_config.zzas;
import com.google.android.gms.internal.firebase_remote_config.zzbf;
import com.google.android.gms.internal.firebase_remote_config.zzcx;
import com.google.android.gms.internal.firebase_remote_config.zzcy;
import com.google.android.gms.internal.firebase_remote_config.zzde;
import com.google.android.gms.internal.firebase_remote_config.zzei;
import com.google.android.gms.internal.firebase_remote_config.zzes;
import com.google.android.gms.internal.firebase_remote_config.zzev;
import com.google.android.gms.internal.firebase_remote_config.zzew;
import com.google.android.gms.internal.firebase_remote_config.zzex;
import com.google.android.gms.internal.firebase_remote_config.zzfd;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RemoteConfigComponent {
    private static final ExecutorService zzju = Executors.newCachedThreadPool();
    private static final Clock zzjv = DefaultClock.getInstance();
    private static final Random zzjw = new Random();
    private final String appId;
    @GuardedBy("this")
    private String zzg;
    private final Context zzja;
    private final FirebaseApp zzjb;
    private final FirebaseABTesting zzjc;
    @GuardedBy("this")
    private final Map<String, FirebaseRemoteConfig> zzjx;
    private final FirebaseInstanceId zzjy;
    @Nullable
    private final AnalyticsConnector zzjz;
    @GuardedBy("this")
    private Map<String, String> zzka;

    RemoteConfigComponent(Context context, FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, FirebaseABTesting firebaseABTesting, @Nullable AnalyticsConnector analyticsConnector) {
        this(context, zzju, firebaseApp, firebaseInstanceId, firebaseABTesting, analyticsConnector, new zzfd(context, firebaseApp.getOptions().getApplicationId()));
    }

    @VisibleForTesting
    private RemoteConfigComponent(Context context, Executor executor, FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, FirebaseABTesting firebaseABTesting, @Nullable AnalyticsConnector analyticsConnector, zzfd zzfd) {
        this.zzjx = new HashMap();
        this.zzka = new HashMap();
        this.zzg = "https://firebaseremoteconfig.googleapis.com/";
        this.zzja = context;
        this.zzjb = firebaseApp;
        this.zzjy = firebaseInstanceId;
        this.zzjc = firebaseABTesting;
        this.zzjz = analyticsConnector;
        this.appId = firebaseApp.getOptions().getApplicationId();
        Tasks.call(executor, new zzo(this));
        zzfd.getClass();
        Tasks.call(executor, zzq.zza(zzfd));
    }

    public synchronized FirebaseRemoteConfig get(String str) {
        FirebaseRemoteConfig zza;
        String str2 = str;
        synchronized (this) {
            zzei zzd = zzd(str2, "fetch");
            zzei zzd2 = zzd(str2, "activate");
            zzei zzd3 = zzd(str2, "defaults");
            zzev zzev = new zzev(this.zzja.getSharedPreferences(String.format("%s_%s_%s_%s", new Object[]{"frc", this.appId, str2, "settings"}), 0));
            FirebaseApp firebaseApp = this.zzjb;
            FirebaseABTesting firebaseABTesting = this.zzjc;
            ExecutorService executorService = zzju;
            Context context = this.zzja;
            String applicationId = this.zzjb.getOptions().getApplicationId();
            FirebaseInstanceId firebaseInstanceId = this.zzjy;
            zzes zzes = new zzes(context, applicationId, firebaseInstanceId, this.zzjz, str, zzju, zzjv, zzjw, zzd, zza(this.zzjb.getOptions().getApiKey(), zzev), zzev);
            zza = zza(firebaseApp, str, firebaseABTesting, executorService, zzd, zzd2, zzd3, zzes, new zzew(zzd2, zzd3), zzev);
        }
        return zza;
    }

    @VisibleForTesting
    private final synchronized FirebaseRemoteConfig zza(FirebaseApp firebaseApp, String str, FirebaseABTesting firebaseABTesting, Executor executor, zzei zzei, zzei zzei2, zzei zzei3, zzes zzes, zzew zzew, zzev zzev) {
        FirebaseRemoteConfig firebaseRemoteConfig;
        String str2 = str;
        synchronized (this) {
            if (!this.zzjx.containsKey(str2)) {
                FirebaseRemoteConfig firebaseRemoteConfig2 = new FirebaseRemoteConfig(this.zzja, firebaseApp, str2.equals("firebase") ? firebaseABTesting : null, executor, zzei, zzei2, zzei3, zzes, zzew, zzev);
                firebaseRemoteConfig2.zzcm();
                this.zzjx.put(str2, firebaseRemoteConfig2);
            }
            firebaseRemoteConfig = (FirebaseRemoteConfig) this.zzjx.get(str2);
        }
        return firebaseRemoteConfig;
    }

    private final zzei zzd(String str, String str2) {
        return zza(this.zzja, this.appId, str, str2);
    }

    public static zzei zza(Context context, String str, String str2, String str3) {
        return zzei.zza(zzju, zzex.zzb(context, String.format("%s_%s_%s_%s.json", new Object[]{"frc", str, str2, str3})));
    }

    @VisibleForTesting
    private final zzcy zza(String str, zzev zzev) {
        zzcy zzce;
        zzde zzde = new zzde(str);
        synchronized (this) {
            zzce = ((zzcx) new zzcx(new zzas(), zzbf.zzbq(), new zzp(this, zzev)).zzc(this.zzg)).zza(zzde).zzce();
        }
        return zzce;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzev zzev, zzab zzab) throws IOException {
        zzab.zza((int) TimeUnit.SECONDS.toMillis(zzev.getFetchTimeoutInSeconds()));
        zzab.zzb((int) TimeUnit.SECONDS.toMillis(5));
        synchronized (this) {
            for (Entry entry : this.zzka.entrySet()) {
                zzab.zzx().zzb((String) entry.getKey(), entry.getValue());
            }
        }
    }
}
