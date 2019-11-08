package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.List;

public final class zzaf {
    private final Context zza;
    private String zzb;
    private String zzc;
    private int zzd;
    private int zze = 0;

    public zzaf(Context context) {
        this.zza = context;
    }

    public final synchronized int zza() {
        if (this.zze != 0) {
            return this.zze;
        }
        PackageManager packageManager = this.zza.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.zze = 1;
                return this.zze;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            if (PlatformVersion.isAtLeastO()) {
                this.zze = 2;
            } else {
                this.zze = 1;
            }
            return this.zze;
        }
        this.zze = 2;
        return this.zze;
    }

    public static String zza(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] split = applicationId.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String zza(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public final synchronized String zzb() {
        if (this.zzb == null) {
            zze();
        }
        return this.zzb;
    }

    public final synchronized String zzc() {
        if (this.zzc == null) {
            zze();
        }
        return this.zzc;
    }

    public final synchronized int zzd() {
        if (this.zzd == 0) {
            PackageInfo zza2 = zza("com.google.android.gms");
            if (zza2 != null) {
                this.zzd = zza2.versionCode;
            }
        }
        return this.zzd;
    }

    private final synchronized void zze() {
        PackageInfo zza2 = zza(this.zza.getPackageName());
        if (zza2 != null) {
            this.zzb = Integer.toString(zza2.versionCode);
            this.zzc = zza2.versionName;
        }
    }

    private final PackageInfo zza(String str) {
        try {
            return this.zza.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            sb.toString();
            return null;
        }
    }
}
