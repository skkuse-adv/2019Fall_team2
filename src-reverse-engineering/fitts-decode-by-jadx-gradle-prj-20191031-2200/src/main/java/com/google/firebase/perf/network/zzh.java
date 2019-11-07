package com.google.firebase.perf.network;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.firebase-perf.zzau;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

public final class zzh {
    public static Long zza(@NonNull HttpMessage httpMessage) {
        try {
            Header firstHeader = httpMessage.getFirstHeader("content-length");
            if (firstHeader != null) {
                return Long.valueOf(Long.parseLong(firstHeader.getValue()));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    public static String zza(@NonNull HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("content-type");
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    public static void zza(zzau zzau) {
        if (!zzau.zzaf()) {
            zzau.zzah();
        }
        zzau.zzai();
    }
}
