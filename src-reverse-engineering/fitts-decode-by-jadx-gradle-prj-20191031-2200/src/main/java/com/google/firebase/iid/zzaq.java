package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

final class zzaq {
    private final SharedPreferences zza;
    private final Context zzb;
    private final zzp zzc;
    @GuardedBy("this")
    private final Map<String, zzr> zzd;

    public zzaq(Context context) {
        this(context, new zzp());
    }

    private zzaq(Context context, zzp zzp) {
        this.zzd = new ArrayMap();
        this.zzb = context;
        this.zza = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzc = zzp;
        File file = new File(ContextCompat.getNoBackupFilesDir(this.zzb), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !zzc()) {
                    zzb();
                    FirebaseInstanceId.getInstance().zze();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String str = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    if (valueOf.length() != 0) {
                        str.concat(valueOf);
                    } else {
                        new String(str);
                    }
                }
            }
        }
    }

    public final synchronized String zza() {
        return this.zza.getString("topic_operation_queue", "");
    }

    public final synchronized void zza(String str) {
        this.zza.edit().putString("topic_operation_queue", str).apply();
    }

    private final synchronized boolean zzc() {
        return this.zza.getAll().isEmpty();
    }

    private static String zzc(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    static String zza(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized void zzb() {
        this.zzd.clear();
        zzp.zza(this.zzb);
        this.zza.edit().clear().commit();
    }

    public final synchronized zzap zza(String str, String str2, String str3) {
        return zzap.zza(this.zza.getString(zzc(str, str2, str3), null));
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zza2 = zzap.zza(str4, str5, System.currentTimeMillis());
        if (zza2 != null) {
            Editor edit = this.zza.edit();
            edit.putString(zzc(str, str2, str3), zza2);
            edit.commit();
        }
    }

    public final synchronized void zzb(String str, String str2, String str3) {
        String zzc2 = zzc(str, str2, str3);
        Editor edit = this.zza.edit();
        edit.remove(zzc2);
        edit.commit();
    }

    /* JADX INFO: used method not loaded: com.google.firebase.iid.zzp.zzb(android.content.Context, java.lang.String):null, types can be incorrect */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        com.google.firebase.iid.FirebaseInstanceId.getInstance().zze();
        r0 = r2.zzc.zzb(r2.zzb, r3);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.firebase.iid.zzr zzb(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, com.google.firebase.iid.zzr> r0 = r2.zzd     // Catch:{ all -> 0x002c }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x002c }
            com.google.firebase.iid.zzr r0 = (com.google.firebase.iid.zzr) r0     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r2)
            return r0
        L_0x000d:
            com.google.firebase.iid.zzp r0 = r2.zzc     // Catch:{ zzs -> 0x0016 }
            android.content.Context r1 = r2.zzb     // Catch:{ zzs -> 0x0016 }
            com.google.firebase.iid.zzr r0 = r0.zza(r1, r3)     // Catch:{ zzs -> 0x0016 }
            goto L_0x0025
        L_0x0016:
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance()     // Catch:{ all -> 0x002c }
            r0.zze()     // Catch:{ all -> 0x002c }
            com.google.firebase.iid.zzp r0 = r2.zzc     // Catch:{ all -> 0x002c }
            android.content.Context r1 = r2.zzb     // Catch:{ all -> 0x002c }
            com.google.firebase.iid.zzr r0 = r0.zzb(r1, r3)     // Catch:{ all -> 0x002c }
        L_0x0025:
            java.util.Map<java.lang.String, com.google.firebase.iid.zzr> r1 = r2.zzd     // Catch:{ all -> 0x002c }
            r1.put(r3, r0)     // Catch:{ all -> 0x002c }
            monitor-exit(r2)
            return r0
        L_0x002c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzaq.zzb(java.lang.String):com.google.firebase.iid.zzr");
    }

    public final synchronized void zzc(String str) {
        String concat = String.valueOf(str).concat("|T|");
        Editor edit = this.zza.edit();
        for (String str2 : this.zza.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
