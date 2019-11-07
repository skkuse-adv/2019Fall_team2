package com.google.firebase.perf.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase-perf.zzb;
import com.google.android.gms.internal.firebase-perf.zzbb;
import com.google.android.gms.internal.firebase-perf.zzh;
import com.google.android.gms.internal.firebase-perf.zzk;
import com.google.android.gms.internal.firebase-perf.zzr;
import com.google.android.gms.internal.firebase-perf.zzu;
import com.google.android.gms.internal.firebase-perf.zzv;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
public class RemoteConfigManager {
    private static final RemoteConfigManager zzfb = new RemoteConfigManager();
    private static final long zzfc = TimeUnit.HOURS.toMillis(12);
    private final Executor executor;
    @Nullable
    private FirebaseApp zzcp;
    private boolean zzfd;
    private long zzfe;
    private zzh<zzv<String, Long>> zzff;
    private zzv<String, Long> zzfg;
    @Nullable
    private FirebaseRemoteConfig zzfh;

    private RemoteConfigManager() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this(threadPoolExecutor, null, null);
    }

    private RemoteConfigManager(Executor executor2, FirebaseRemoteConfig firebaseRemoteConfig, FirebaseApp firebaseApp) {
        this.zzfd = false;
        this.zzfe = 0;
        this.zzff = zzk.zza(new zzw(this));
        this.zzfg = zzv.zzj();
        this.executor = executor2;
        this.zzfh = null;
        this.zzcp = null;
    }

    public static RemoteConfigManager zzbz() {
        return zzfb;
    }

    public final void zza(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.zzfh = firebaseRemoteConfig;
    }

    public final void zza(FirebaseApp firebaseApp) {
        this.zzcp = firebaseApp;
    }

    public final long zzc(String str, long j) {
        String str2 = " for key: ";
        zzca();
        long longValue = ((Long) this.zzfg.getOrDefault(zzbb.zzk(str), Long.valueOf(j))).longValue();
        if (!zzcc()) {
            return longValue;
        }
        String string = this.zzfh.getString(zzbb.zzl(str));
        try {
            longValue = (long) (((float) Long.parseLong(string)) * 100.0f);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
            sb.append("Fetched value: ");
            sb.append(longValue);
            sb.append(str2);
            sb.append(str);
            sb.append(" from firebase remote config.");
            sb.toString();
            return longValue;
        } catch (NumberFormatException unused) {
            if (string.isEmpty()) {
                return longValue;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 45 + String.valueOf(str).length());
            sb2.append("Could not parse value: ");
            sb2.append(string);
            sb2.append(str2);
            sb2.append(str);
            sb2.append(" into a long");
            sb2.toString();
            return longValue;
        }
    }

    public final float zza(String str, float f) {
        zzca();
        Long l = (Long) this.zzfg.get(zzbb.zzk(str));
        if (l != null) {
            f = (float) l.longValue();
        }
        if (!zzcc()) {
            return f;
        }
        String string = this.zzfh.getString(zzbb.zzl(str));
        try {
            return 100.0f * Float.parseFloat(string);
        } catch (NumberFormatException unused) {
            if (string.isEmpty()) {
                return f;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 46 + String.valueOf(str).length());
            sb.append("Could not parse value: ");
            sb.append(string);
            sb.append(" for key: ");
            sb.append(str);
            sb.append(" into a float");
            sb.toString();
            return f;
        }
    }

    private final void zzca() {
        if (this.zzfd) {
            zzcb();
        } else {
            this.executor.execute(new zzy(this));
        }
    }

    private final void zzcb() {
        if (zzcc()) {
            if (System.currentTimeMillis() - this.zzfe > zzfc) {
                this.zzfe = System.currentTimeMillis();
                this.zzfh.fetchAndActivate().addOnFailureListener(this.executor, (OnFailureListener) new zzx(this));
            }
        }
    }

    private final boolean zzcc() {
        return this.zzfh != null && ((Long) this.zzfg.getOrDefault(zzbb.zzk("firebase_remote_config_enabled"), Long.valueOf(1))).longValue() == 1;
    }

    private static zzr<String> zza(Context context, String str) {
        zzu zzh = zzr.zzh();
        int zzf = zzf(context);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append(":");
        sb.append(zzf);
        String[] strArr = {sb.toString(), str, "1.0.0.252929170"};
        for (int i = 0; i < 3; i++) {
            String str2 = "_fireperf1:";
            String valueOf = String.valueOf(strArr[i]);
            String zzh2 = zzh(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzh2).length() + 16);
            sb2.append("fireperf:");
            sb2.append(zzh2);
            sb2.append("_limits");
            String str3 = null;
            try {
                str3 = zzb.zza(context.getContentResolver(), sb2.toString(), (String) null);
            } catch (SecurityException e) {
                String str4 = "Failed to fetch Gservices flag. SecurityException: ";
                String valueOf2 = String.valueOf(e.getMessage());
                if (valueOf2.length() != 0) {
                    str4.concat(valueOf2);
                } else {
                    new String(str4);
                }
            }
            if (str3 != null) {
                zzh.zzb(str3);
            }
        }
        return zzh.zzi();
    }

    @Nullable
    private static String zzh(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance(CommonUtils.SHA1_INSTANCE).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte valueOf : digest) {
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(valueOf)}));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static zzv<String, Long> zzc(List<String> list) {
        if (list == null) {
            return zzv.zzj();
        }
        HashMap hashMap = new HashMap();
        for (String split : list) {
            for (String split2 : split.split(",")) {
                String[] split3 = split2.split(":");
                if (split3.length >= 2) {
                    String trim = split3[0].trim();
                    if (!trim.isEmpty() && !hashMap.containsKey(trim)) {
                        try {
                            long parseLong = Long.parseLong(split3[1].trim());
                            if (parseLong >= 0) {
                                hashMap.put(trim, Long.valueOf(parseLong));
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            }
        }
        return zzv.zza(hashMap);
    }

    private static int zzf(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Exception exc) {
        this.zzfe = 0;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzcd() {
        if (this.zzcp != null) {
            this.zzfg = (zzv) this.zzff.get();
            this.zzfd = true;
        } else {
            zzv.zzj();
        }
        zzcb();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzv zzce() {
        return zzc(zza(this.zzcp.getApplicationContext(), this.zzcp.getOptions().getApplicationId()));
    }
}
