package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.annotation.XmlRes;
import com.google.android.gms.internal.firebase_remote_config.zzag;
import com.google.android.gms.internal.firebase_remote_config.zzei;
import com.google.android.gms.internal.firebase_remote_config.zzen;
import com.google.android.gms.internal.firebase_remote_config.zzes;
import com.google.android.gms.internal.firebase_remote_config.zzet;
import com.google.android.gms.internal.firebase_remote_config.zzev;
import com.google.android.gms.internal.firebase_remote_config.zzew;
import com.google.android.gms.internal.firebase_remote_config.zzfa;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC = 0;
    private final Executor executor;
    private final Context zzja;
    @Nullable
    private final FirebaseABTesting zzjc;
    private final zzei zzjd;
    private final zzei zzje;
    private final zzei zzjf;
    private final zzes zzjg;
    private final zzew zzjh;
    private final zzev zzji;

    public static FirebaseRemoteConfig getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static FirebaseRemoteConfig getInstance(FirebaseApp firebaseApp) {
        return ((RemoteConfigComponent) firebaseApp.get(RemoteConfigComponent.class)).get("firebase");
    }

    FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp, @Nullable FirebaseABTesting firebaseABTesting, Executor executor2, zzei zzei, zzei zzei2, zzei zzei3, zzes zzes, zzew zzew, zzev zzev) {
        this.zzja = context;
        this.zzjc = firebaseABTesting;
        this.executor = executor2;
        this.zzjd = zzei;
        this.zzje = zzei2;
        this.zzjf = zzei3;
        this.zzjg = zzes;
        this.zzjh = zzew;
        this.zzji = zzev;
    }

    public Task<FirebaseRemoteConfigInfo> ensureInitialized() {
        Task zzcp = this.zzje.zzcp();
        Task zzcp2 = this.zzjf.zzcp();
        Task zzcp3 = this.zzjd.zzcp();
        Task call = Tasks.call(this.executor, new zza(this));
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{zzcp, zzcp2, zzcp3, call}).continueWith(this.executor, new zzc(call));
    }

    public Task<Boolean> fetchAndActivate() {
        return fetch().onSuccessTask(this.executor, new zzg(this));
    }

    @WorkerThread
    @Deprecated
    public boolean activateFetched() {
        zzen zzco = this.zzjd.zzco();
        if (zzco == null || !zza(zzco, this.zzje.zzco())) {
            return false;
        }
        this.zzje.zzb(zzco).addOnSuccessListener(this.executor, (OnSuccessListener<? super TResult>) new zzf<Object>(this));
        return true;
    }

    public Task<Boolean> activate() {
        Task zzcp = this.zzjd.zzcp();
        Task zzcp2 = this.zzje.zzcp();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{zzcp, zzcp2}).continueWithTask(this.executor, new zzi(this, zzcp, zzcp2));
    }

    public Task<Void> fetch() {
        Task zza = this.zzjg.zza(this.zzji.isDeveloperModeEnabled());
        zza.addOnCompleteListener(this.executor, (OnCompleteListener<TResult>) new zzh<TResult>(this));
        return zza.onSuccessTask(zzk.zzjk);
    }

    public Task<Void> fetch(long j) {
        Task zza = this.zzjg.zza(this.zzji.isDeveloperModeEnabled(), j);
        zza.addOnCompleteListener(this.executor, (OnCompleteListener<TResult>) new zzj<TResult>(this));
        return zza.onSuccessTask(zzm.zzjk);
    }

    public String getString(String str) {
        return this.zzjh.getString(str);
    }

    public boolean getBoolean(String str) {
        return this.zzjh.getBoolean(str);
    }

    @Deprecated
    public byte[] getByteArray(String str) {
        return this.zzjh.getByteArray(str);
    }

    public double getDouble(String str) {
        return this.zzjh.getDouble(str);
    }

    public long getLong(String str) {
        return this.zzjh.getLong(str);
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        return this.zzjh.getValue(str);
    }

    public Set<String> getKeysByPrefix(String str) {
        return this.zzjh.getKeysByPrefix(str);
    }

    public Map<String, FirebaseRemoteConfigValue> getAll() {
        return this.zzjh.getAll();
    }

    public FirebaseRemoteConfigInfo getInfo() {
        return this.zzji.getInfo();
    }

    @Deprecated
    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.zzji.zzb(firebaseRemoteConfigSettings);
        if (firebaseRemoteConfigSettings.isDeveloperModeEnabled()) {
            Logger.getLogger(zzag.class.getName()).setLevel(Level.CONFIG);
        }
    }

    public Task<Void> setConfigSettingsAsync(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return Tasks.call(this.executor, new zzl(this, firebaseRemoteConfigSettings));
    }

    public void setDefaults(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), entry.getValue().toString());
        }
        zzb((Map<String, String>) hashMap);
    }

    public Task<Void> setDefaultsAsync(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), entry.getValue().toString());
        }
        return zzc((Map<String, String>) hashMap);
    }

    public void setDefaults(@XmlRes int i) {
        zzb(zzfa.zza(this.zzja, i));
    }

    public Task<Void> setDefaultsAsync(@XmlRes int i) {
        return zzc(zzfa.zza(this.zzja, i));
    }

    public Task<Void> reset() {
        return Tasks.call(this.executor, new zzb(this));
    }

    /* access modifiers changed from: 0000 */
    public final void zzcm() {
        this.zzje.zzcp();
        this.zzjf.zzcp();
        this.zzjd.zzcp();
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final boolean zzc(Task<zzen> task) {
        if (!task.isSuccessful()) {
            return false;
        }
        this.zzjd.clear();
        if (task.getResult() != null) {
            zza(((zzen) task.getResult()).zzcs());
        }
        return true;
    }

    private final void zzb(Map<String, String> map) {
        try {
            this.zzjf.zzb(zzen.zzct().zzd(map).zzcv());
        } catch (JSONException unused) {
        }
    }

    private final Task<Void> zzc(Map<String, String> map) {
        try {
            return this.zzjf.zza(zzen.zzct().zzd(map).zzcv(), true).onSuccessTask(zze.zzjk);
        } catch (JSONException unused) {
            return Tasks.forResult(null);
        }
    }

    @VisibleForTesting
    private final void zza(@NonNull JSONArray jSONArray) {
        if (this.zzjc != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    HashMap hashMap = new HashMap();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        hashMap.put(str, jSONObject.getString(str));
                    }
                    arrayList.add(hashMap);
                }
                this.zzjc.replaceAllExperiments(arrayList);
            } catch (AbtException | JSONException unused) {
            }
        }
    }

    private static boolean zza(zzen zzen, @Nullable zzen zzen2) {
        return zzen2 == null || !zzen.zzcr().equals(zzen2.zzcr());
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Void zzcn() throws Exception {
        this.zzje.clear();
        this.zzjd.clear();
        this.zzjf.clear();
        this.zzji.clear();
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Void zza(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) throws Exception {
        this.zzji.setConfigSettings(firebaseRemoteConfigSettings);
        if (firebaseRemoteConfigSettings.isDeveloperModeEnabled()) {
            Logger.getLogger(zzag.class.getName()).setLevel(Level.CONFIG);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Task zza(Task task, Task task2, Task task3) throws Exception {
        boolean isSuccessful = task.isSuccessful();
        Boolean valueOf = Boolean.valueOf(false);
        if (!isSuccessful || task.getResult() == null) {
            return Tasks.forResult(valueOf);
        }
        zzen zzen = (zzen) task.getResult();
        if (!task2.isSuccessful() || zza(zzen, (zzen) task2.getResult())) {
            return this.zzje.zza(zzen, true).continueWith(this.executor, new zzd(this));
        }
        return Tasks.forResult(valueOf);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzen zzen) {
        this.zzjd.clear();
        zza(zzen.zzcs());
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(Task task) {
        if (task.isSuccessful()) {
            this.zzji.zzm(-1);
            zzen zzcx = ((zzet) task.getResult()).zzcx();
            if (zzcx != null) {
                this.zzji.zzf(zzcx.zzcr());
            }
            return;
        }
        Exception exception = task.getException();
        if (exception != null) {
            if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
                this.zzji.zzm(2);
            } else {
                this.zzji.zzm(1);
            }
        }
    }
}
