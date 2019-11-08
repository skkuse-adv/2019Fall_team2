package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.net.Uri;

public final class zzck {
    private static volatile zzcw<Boolean> zzaav = zzcw.zzrp();
    private static final Object zzaaw = new Object();

    private static boolean zzq(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                return true;
            }
        } catch (NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean zza(Context context, Uri uri) {
        boolean z;
        String authority = uri.getAuthority();
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            throw new IllegalArgumentException(sb.toString());
        } else if (zzaav.isPresent()) {
            return ((Boolean) zzaav.get()).booleanValue();
        } else {
            synchronized (zzaaw) {
                if (zzaav.isPresent()) {
                    boolean booleanValue = ((Boolean) zzaav.get()).booleanValue();
                    return booleanValue;
                }
                boolean z2 = false;
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
                    if (resolveContentProvider == null || !"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        z = false;
                        if (z && zzq(context)) {
                            z2 = true;
                        }
                        zzaav = zzcw.zzf(Boolean.valueOf(z2));
                        return ((Boolean) zzaav.get()).booleanValue();
                    }
                }
                z = true;
                z2 = true;
                zzaav = zzcw.zzf(Boolean.valueOf(z2));
                return ((Boolean) zzaav.get()).booleanValue();
            }
        }
    }
}
