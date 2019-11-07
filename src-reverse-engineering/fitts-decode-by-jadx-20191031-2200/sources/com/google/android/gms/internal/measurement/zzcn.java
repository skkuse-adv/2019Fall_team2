package com.google.android.gms.internal.measurement;

import android.net.Uri;

public final class zzcn {
    public static Uri zzdh(String str) {
        String valueOf = String.valueOf(Uri.encode(str));
        String str2 = "content://com.google.android.gms.phenotype/";
        return Uri.parse(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
