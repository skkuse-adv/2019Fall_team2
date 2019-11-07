package com.google.firebase.perf.network;

import com.google.android.gms.internal.firebase-perf.zzau;
import com.google.android.gms.internal.firebase-perf.zzbg;
import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

public final class zzg<T> implements ResponseHandler<T> {
    private final zzbg zzfy;
    private final zzau zzgm;
    private final ResponseHandler<? extends T> zzgy;

    public zzg(ResponseHandler<? extends T> responseHandler, zzbg zzbg, zzau zzau) {
        this.zzgy = responseHandler;
        this.zzfy = zzbg;
        this.zzgm = zzau;
    }

    public final T handleResponse(HttpResponse httpResponse) throws IOException {
        this.zzgm.zzj(this.zzfy.zzcs());
        this.zzgm.zzb(httpResponse.getStatusLine().getStatusCode());
        Long zza = zzh.zza((HttpMessage) httpResponse);
        if (zza != null) {
            this.zzgm.zzk(zza.longValue());
        }
        String zza2 = zzh.zza(httpResponse);
        if (zza2 != null) {
            this.zzgm.zzc(zza2);
        }
        this.zzgm.zzai();
        return this.zzgy.handleResponse(httpResponse);
    }
}
