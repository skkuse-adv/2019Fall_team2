package com.google.firebase.perf.network;

import com.google.android.gms.internal.firebase-perf.zzau;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.firebase.perf.internal.zzc;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public final class zzf implements Callback {
    private final zzbg zzfy;
    private final zzau zzgm;
    private final Callback zzgw;
    private final long zzgx;

    public zzf(Callback callback, zzc zzc, zzbg zzbg, long j) {
        this.zzgw = callback;
        this.zzgm = zzau.zza(zzc);
        this.zzgx = j;
        this.zzfy = zzbg;
    }

    public final void onFailure(Call call, IOException iOException) {
        Request request = call.request();
        if (request != null) {
            HttpUrl url = request.url();
            if (url != null) {
                this.zzgm.zza(url.url().toString());
            }
            if (request.method() != null) {
                this.zzgm.zzb(request.method());
            }
        }
        this.zzgm.zzg(this.zzgx);
        this.zzgm.zzj(this.zzfy.zzcs());
        zzh.zza(this.zzgm);
        this.zzgw.onFailure(call, iOException);
    }

    public final void onResponse(Call call, Response response) throws IOException {
        Response response2 = response;
        FirebasePerfOkHttpClient.zza(response2, this.zzgm, this.zzgx, this.zzfy.zzcs());
        this.zzgw.onResponse(call, response);
    }
}
