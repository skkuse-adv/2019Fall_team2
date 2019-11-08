package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.android.gms.internal.firebase-perf.zzau;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.firebase.perf.internal.zzc;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class FirebasePerfOkHttpClient {
    private FirebasePerfOkHttpClient() {
    }

    @Keep
    public static Response execute(Call call) throws IOException {
        zzau zza = zzau.zza(zzc.zzba());
        zzbg zzbg = new zzbg();
        long zzcr = zzbg.zzcr();
        try {
            Response execute = call.execute();
            zza(execute, zza, zzcr, zzbg.zzcs());
            return execute;
        } catch (IOException e) {
            Request request = call.request();
            if (request != null) {
                HttpUrl url = request.url();
                if (url != null) {
                    zza.zza(url.url().toString());
                }
                if (request.method() != null) {
                    zza.zzb(request.method());
                }
            }
            zza.zzg(zzcr);
            zza.zzj(zzbg.zzcs());
            zzh.zza(zza);
            throw e;
        }
    }

    @Keep
    public static void enqueue(Call call, Callback callback) {
        zzbg zzbg = new zzbg();
        Callback callback2 = callback;
        zzf zzf = new zzf(callback2, zzc.zzba(), zzbg, zzbg.zzcr());
        call.enqueue(zzf);
    }

    static void zza(Response response, zzau zzau, long j, long j2) throws IOException {
        Request request = response.request();
        if (request != null) {
            zzau.zza(request.url().url().toString());
            zzau.zzb(request.method());
            if (request.body() != null) {
                long contentLength = request.body().contentLength();
                if (contentLength != -1) {
                    zzau.zzf(contentLength);
                }
            }
            ResponseBody body = response.body();
            if (body != null) {
                long contentLength2 = body.contentLength();
                if (contentLength2 != -1) {
                    zzau.zzk(contentLength2);
                }
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    zzau.zzc(contentType.toString());
                }
            }
            zzau.zzb(response.code());
            zzau.zzg(j);
            zzau.zzj(j2);
            zzau.zzai();
        }
    }
}
