package com.google.firebase.perf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.firebase-perf.zzay;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.internal.FeatureControl;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.internal.zzc;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FirebasePerformance {
    public static final int MAX_TRACE_NAME_LENGTH = 100;
    private static volatile FirebasePerformance zzap;
    private final Map<String, String> zzaq;
    private final zzay zzar;
    @Nullable
    private Boolean zzas;

    public static FirebasePerformance getInstance() {
        Class<FirebasePerformance> cls = FirebasePerformance.class;
        if (zzap == null) {
            synchronized (cls) {
                if (zzap == null) {
                    zzap = (FirebasePerformance) FirebaseApp.getInstance().get(cls);
                }
            }
        }
        return zzap;
    }

    FirebasePerformance(FirebaseApp firebaseApp, FirebaseRemoteConfig firebaseRemoteConfig) {
        this(firebaseApp, firebaseRemoteConfig, RemoteConfigManager.zzbz(), FeatureControl.zzao(), GaugeManager.zzbf());
    }

    @VisibleForTesting
    private FirebasePerformance(FirebaseApp firebaseApp, FirebaseRemoteConfig firebaseRemoteConfig, RemoteConfigManager remoteConfigManager, FeatureControl featureControl, GaugeManager gaugeManager) {
        this.zzaq = new ConcurrentHashMap();
        this.zzas = null;
        if (firebaseApp == null) {
            this.zzas = Boolean.valueOf(false);
            this.zzar = new zzay(new Bundle());
            return;
        }
        Context applicationContext = firebaseApp.getApplicationContext();
        this.zzar = zzb(applicationContext);
        this.zzas = zza(applicationContext);
        remoteConfigManager.zza(firebaseRemoteConfig);
        remoteConfigManager.zza(firebaseApp);
        featureControl.zza(this.zzar);
        gaugeManager.zze(applicationContext);
    }

    @NonNull
    public static Trace startTrace(@NonNull String str) {
        Trace zzi = Trace.zzi(str);
        zzi.start();
        return zzi;
    }

    public void setPerformanceCollectionEnabled(boolean z) {
        try {
            FirebaseApp.getInstance();
            SharedPreferences sharedPreferences = FirebaseApp.getInstance().getApplicationContext().getSharedPreferences("FirebasePerfSharedPrefs", 0);
            if (!zzr()) {
                sharedPreferences.edit().putBoolean("isEnabled", z).apply();
                this.zzas = Boolean.valueOf(z);
                if (z) {
                }
            }
        } catch (IllegalStateException unused) {
        }
    }

    public boolean isPerformanceCollectionEnabled() {
        Boolean bool = this.zzas;
        if (bool != null) {
            return bool.booleanValue();
        }
        return FirebaseApp.getInstance().isDataCollectionDefaultEnabled();
    }

    @NonNull
    public final Map<String, String> getAttributes() {
        return new HashMap(this.zzaq);
    }

    @Nullable
    private final Boolean zza(@NonNull Context context) {
        String str = "isEnabled";
        if (zzr()) {
            return Boolean.valueOf(false);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
        try {
            if (sharedPreferences.contains(str)) {
                return Boolean.valueOf(sharedPreferences.getBoolean(str, true));
            }
        } catch (ClassCastException e) {
            String str2 = "Unable to access enable value: ";
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                new String(str2);
            }
        }
        String str3 = "firebase_performance_collection_enabled";
        if (this.zzar.containsKey(str3)) {
            return Boolean.valueOf(this.zzar.getBoolean(str3, true));
        }
        return null;
    }

    @NonNull
    public Trace newTrace(@NonNull String str) {
        return Trace.zzi(str);
    }

    @NonNull
    public HttpMetric newHttpMetric(@NonNull String str, String str2) {
        return new HttpMetric(str, str2, zzc.zzba(), new zzbg());
    }

    @NonNull
    public HttpMetric newHttpMetric(@NonNull URL url, String str) {
        return new HttpMetric(url, str, zzc.zzba(), new zzbg());
    }

    private final boolean zzr() {
        return this.zzar.getBoolean("firebase_performance_collection_deactivated", false);
    }

    private static zzay zzb(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (NameNotFoundException | NullPointerException e) {
            String str = "No perf enable meta data found ";
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                new String(str);
            }
            bundle = null;
        }
        return bundle != null ? new zzay(bundle) : new zzay();
    }
}
