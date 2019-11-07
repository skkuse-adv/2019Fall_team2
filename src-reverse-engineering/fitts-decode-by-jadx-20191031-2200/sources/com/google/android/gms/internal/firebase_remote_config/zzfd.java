package com.google.android.gms.internal.firebase_remote_config;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;

public final class zzfd {
    private static final Charset zzlz = Charset.forName("UTF-8");
    @VisibleForTesting
    private static final ThreadLocal<DateFormat> zzma = new zzfg();
    private final String appId;
    private final Context zzja;
    private final SharedPreferences zzmb;

    public zzfd(Context context, String str) {
        this.zzja = context;
        this.appId = str;
        this.zzmb = context.getSharedPreferences("com.google.firebase.remoteconfig_legacy_settings", 0);
    }

    @WorkerThread
    public final boolean zzdg() {
        String str = "save_legacy_configs";
        if (!this.zzmb.getBoolean(str, true)) {
            return false;
        }
        zzfi$zze zzdh = zzdh();
        HashMap hashMap = new HashMap();
        if (zzdh != null) {
            Map zza = zza(zzdh.zzdu());
            Map zza2 = zza(zzdh.zzdt());
            Map zza3 = zza(zzdh.zzdv());
            HashSet<String> hashSet = new HashSet<>();
            hashSet.addAll(zza.keySet());
            hashSet.addAll(zza2.keySet());
            hashSet.addAll(zza3.keySet());
            for (String str2 : hashSet) {
                zzff zzff = new zzff(null);
                if (zza.containsKey(str2)) {
                    zzff.zzj((zzen) zza.get(str2));
                }
                if (zza2.containsKey(str2)) {
                    zzff.zzi((zzen) zza2.get(str2));
                }
                if (zza3.containsKey(str2)) {
                    zzff.zzk((zzen) zza3.get(str2));
                }
                hashMap.put(str2, zzff);
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            String str3 = (String) entry.getKey();
            zzff zzff2 = (zzff) entry.getValue();
            zzei zzd = zzd(str3, "fetch");
            zzei zzd2 = zzd(str3, "activate");
            zzei zzd3 = zzd(str3, "defaults");
            if (zzff2.zzcx() != null) {
                zzd.zzc(zzff2.zzcx());
            }
            if (zzff2.zzdi() != null) {
                zzd2.zzc(zzff2.zzdi());
            }
            if (zzff2.zzdj() != null) {
                zzd3.zzc(zzff2.zzdj());
            }
        }
        this.zzmb.edit().putBoolean(str, false).commit();
        return true;
    }

    private final Map<String, zzen> zza(zzfi$zza zzfi_zza) {
        HashMap hashMap = new HashMap();
        Date date = new Date(zzfi_zza.getTimestamp());
        List<zzfx> zzdl = zzfi_zza.zzdl();
        ArrayList arrayList = new ArrayList();
        for (zzfx zza : zzdl) {
            zzkt$zzb zza2 = zza(zza);
            if (zza2 != null) {
                zzdd zzdd = new zzdd();
                zzdd.zzan(zza2.zzjm());
                zzdd.zzaq(zza2.zzjn());
                zzdd.zzao(((DateFormat) zzma.get()).format(new Date(zza2.zzjo())));
                zzdd.zzap(zza2.zzjp());
                zzdd.zzb(Long.valueOf(zza2.zzjq()));
                zzdd.zza(Long.valueOf(zza2.zzjr()));
                arrayList.add(zzdd);
            }
        }
        for (zzfi$zzd zzfi_zzd : zzfi_zza.zzdk()) {
            String namespace = zzfi_zzd.getNamespace();
            if (namespace.startsWith("configns:")) {
                namespace = namespace.substring(9);
            }
            zzep zzct = zzen.zzct();
            List<zzfi$zzb> zzdr = zzfi_zzd.zzdr();
            HashMap hashMap2 = new HashMap();
            for (zzfi$zzb zzfi_zzb : zzdr) {
                hashMap2.put(zzfi_zzb.getKey(), zzfi_zzb.zzdo().zzb(zzlz));
            }
            zzep zza3 = zzct.zzd(hashMap2).zza(date);
            if (namespace.equals("firebase")) {
                zza3.zzb(arrayList);
            }
            try {
                hashMap.put(namespace, zza3.zzcv());
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    @Nullable
    private static zzkt$zzb zza(zzfx zzfx) {
        try {
            zzgg zzgg = (zzgg) zzfx.iterator();
            byte[] bArr = new byte[zzfx.size()];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = ((Byte) zzgg.next()).byteValue();
            }
            return zzkt$zzb.zzg(bArr);
        } catch (zzhq unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x001e A[SYNTHETIC, Splitter:B:19:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x002c A[SYNTHETIC, Splitter:B:30:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0033 A[SYNTHETIC, Splitter:B:36:0x0033] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.firebase_remote_config.zzfi$zze zzdh() {
        /*
            r5 = this;
            android.content.Context r0 = r5.zzja
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r2 = "persisted_config"
            java.io.FileInputStream r0 = r0.openFileInput(r2)     // Catch:{ FileNotFoundException -> 0x0022, IOException -> 0x001b, all -> 0x0016 }
            com.google.android.gms.internal.firebase_remote_config.zzfi$zze r1 = com.google.android.gms.internal.firebase_remote_config.zzfi$zze.zzb(r0)     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x001c }
            if (r0 == 0) goto L_0x0015
            r0.close()     // Catch:{ IOException -> 0x0015 }
        L_0x0015:
            return r1
        L_0x0016:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0031
        L_0x001b:
            r0 = r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            return r1
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.lang.String r2 = "FirebaseRemoteConfig"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r1
        L_0x0030:
            r1 = move-exception
        L_0x0031:
            if (r0 == 0) goto L_0x0036
            r0.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzfd.zzdh():com.google.android.gms.internal.firebase_remote_config.zzfi$zze");
    }

    private final zzei zzd(String str, String str2) {
        return RemoteConfigComponent.zza(this.zzja, this.appId, str, str2);
    }
}
