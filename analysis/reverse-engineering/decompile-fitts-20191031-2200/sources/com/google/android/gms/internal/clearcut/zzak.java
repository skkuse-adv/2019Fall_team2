package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;

final class zzak extends zzae<String> {
    zzak(zzao zzao, String str, String str2) {
        super(zzao, str, str2, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zza(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.zzds, null);
        } catch (ClassCastException unused) {
            String str = "Invalid string value in SharedPreferences for ";
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
        return str;
    }
}
