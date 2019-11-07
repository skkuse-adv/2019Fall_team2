package com.google.android.gms.internal.firebase_remote_config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class zzfg extends ThreadLocal<DateFormat> {
    zzfg() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
    }
}
