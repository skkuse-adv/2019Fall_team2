package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;

final class zzaj extends zzae<Boolean> {
    zzaj(zzao zzao, String str, Boolean bool) {
        super(zzao, str, bool, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Boolean zza(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.zzds, false));
        } catch (ClassCastException unused) {
            String str = "Invalid boolean value in SharedPreferences for ";
            String valueOf = String.valueOf(this.zzds);
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                new String(str);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzb(String str) {
        if (zzy.zzcr.matcher(str).matches()) {
            return Boolean.valueOf(true);
        }
        if (zzy.zzcs.matcher(str).matches()) {
            return Boolean.valueOf(false);
        }
        String str2 = this.zzds;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb.append("Invalid boolean value for ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str);
        sb.toString();
        return null;
    }
}
