package com.google.android.gms.internal.firebase_remote_config;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public abstract class zzag {
    static final Logger zzbz = Logger.getLogger(zzag.class.getName());
    private static final String[] zzca;

    /* access modifiers changed from: protected */
    public abstract zzaj zzc(String str, String str2) throws IOException;

    public final zzaa zza(zzad zzad) {
        return new zzaa(this, zzad);
    }

    public boolean zzz(String str) throws IOException {
        return Arrays.binarySearch(zzca, str) >= 0;
    }

    static {
        String[] strArr = {HttpRequest.METHOD_DELETE, HttpRequest.METHOD_GET, HttpRequest.METHOD_POST, HttpRequest.METHOD_PUT};
        zzca = strArr;
        Arrays.sort(strArr);
    }
}
