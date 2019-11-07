package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.android.gms.internal.firebase-perf.zzau;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.firebase.perf.internal.zzc;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public class FirebasePerfHttpClient {
    private FirebasePerfHttpClient() {
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        return zza(httpClient, httpUriRequest, new zzbg(), zzc.zzba());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return zza(httpClient, httpUriRequest, httpContext, new zzbg(), zzc.zzba());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        return zza(httpClient, httpUriRequest, responseHandler, new zzbg(), zzc.zzba());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        return zza(httpClient, httpUriRequest, responseHandler, httpContext, new zzbg(), zzc.zzba());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return zza(httpClient, httpHost, httpRequest, new zzbg(), zzc.zzba());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return zza(httpClient, httpHost, httpRequest, httpContext, new zzbg(), zzc.zzba());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return zza(httpClient, httpHost, httpRequest, responseHandler, new zzbg(), zzc.zzba());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return zza(httpClient, httpHost, httpRequest, responseHandler, httpContext, new zzbg(), zzc.zzba());
    }

    private static HttpResponse zza(HttpClient httpClient, HttpUriRequest httpUriRequest, zzbg zzbg, zzc zzc) throws IOException {
        zzau zza = zzau.zza(zzc);
        try {
            zza.zza(httpUriRequest.getURI().toString()).zzb(httpUriRequest.getMethod());
            Long zza2 = zzh.zza((HttpMessage) httpUriRequest);
            if (zza2 != null) {
                zza.zzf(zza2.longValue());
            }
            zzbg.reset();
            zza.zzg(zzbg.zzcr());
            HttpResponse execute = httpClient.execute(httpUriRequest);
            zza.zzj(zzbg.zzcs());
            zza.zzb(execute.getStatusLine().getStatusCode());
            Long zza3 = zzh.zza((HttpMessage) execute);
            if (zza3 != null) {
                zza.zzk(zza3.longValue());
            }
            String zza4 = zzh.zza(execute);
            if (zza4 != null) {
                zza.zzc(zza4);
            }
            zza.zzai();
            return execute;
        } catch (IOException e) {
            zza.zzj(zzbg.zzcs());
            zzh.zza(zza);
            throw e;
        }
    }

    private static HttpResponse zza(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, zzbg zzbg, zzc zzc) throws IOException {
        zzau zza = zzau.zza(zzc);
        try {
            zza.zza(httpUriRequest.getURI().toString()).zzb(httpUriRequest.getMethod());
            Long zza2 = zzh.zza((HttpMessage) httpUriRequest);
            if (zza2 != null) {
                zza.zzf(zza2.longValue());
            }
            zzbg.reset();
            zza.zzg(zzbg.zzcr());
            HttpResponse execute = httpClient.execute(httpUriRequest, httpContext);
            zza.zzj(zzbg.zzcs());
            zza.zzb(execute.getStatusLine().getStatusCode());
            Long zza3 = zzh.zza((HttpMessage) execute);
            if (zza3 != null) {
                zza.zzk(zza3.longValue());
            }
            String zza4 = zzh.zza(execute);
            if (zza4 != null) {
                zza.zzc(zza4);
            }
            zza.zzai();
            return execute;
        } catch (IOException e) {
            zza.zzj(zzbg.zzcs());
            zzh.zza(zza);
            throw e;
        }
    }

    private static <T> T zza(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, zzbg zzbg, zzc zzc) throws IOException {
        zzau zza = zzau.zza(zzc);
        try {
            zza.zza(httpUriRequest.getURI().toString()).zzb(httpUriRequest.getMethod());
            Long zza2 = zzh.zza((HttpMessage) httpUriRequest);
            if (zza2 != null) {
                zza.zzf(zza2.longValue());
            }
            zzbg.reset();
            zza.zzg(zzbg.zzcr());
            return httpClient.execute(httpUriRequest, new zzg(responseHandler, zzbg, zza));
        } catch (IOException e) {
            zza.zzj(zzbg.zzcs());
            zzh.zza(zza);
            throw e;
        }
    }

    private static <T> T zza(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext, zzbg zzbg, zzc zzc) throws IOException {
        zzau zza = zzau.zza(zzc);
        try {
            zza.zza(httpUriRequest.getURI().toString()).zzb(httpUriRequest.getMethod());
            Long zza2 = zzh.zza((HttpMessage) httpUriRequest);
            if (zza2 != null) {
                zza.zzf(zza2.longValue());
            }
            zzbg.reset();
            zza.zzg(zzbg.zzcr());
            return httpClient.execute(httpUriRequest, new zzg(responseHandler, zzbg, zza), httpContext);
        } catch (IOException e) {
            zza.zzj(zzbg.zzcs());
            zzh.zza(zza);
            throw e;
        }
    }

    private static HttpResponse zza(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, zzbg zzbg, zzc zzc) throws IOException {
        zzau zza = zzau.zza(zzc);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zza.zza(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).zzb(httpRequest.getRequestLine().getMethod());
            Long zza2 = zzh.zza((HttpMessage) httpRequest);
            if (zza2 != null) {
                zza.zzf(zza2.longValue());
            }
            zzbg.reset();
            zza.zzg(zzbg.zzcr());
            HttpResponse execute = httpClient.execute(httpHost, httpRequest);
            zza.zzj(zzbg.zzcs());
            zza.zzb(execute.getStatusLine().getStatusCode());
            Long zza3 = zzh.zza((HttpMessage) execute);
            if (zza3 != null) {
                zza.zzk(zza3.longValue());
            }
            String zza4 = zzh.zza(execute);
            if (zza4 != null) {
                zza.zzc(zza4);
            }
            zza.zzai();
            return execute;
        } catch (IOException e) {
            zza.zzj(zzbg.zzcs());
            zzh.zza(zza);
            throw e;
        }
    }

    private static HttpResponse zza(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, zzbg zzbg, zzc zzc) throws IOException {
        zzau zza = zzau.zza(zzc);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zza.zza(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).zzb(httpRequest.getRequestLine().getMethod());
            Long zza2 = zzh.zza((HttpMessage) httpRequest);
            if (zza2 != null) {
                zza.zzf(zza2.longValue());
            }
            zzbg.reset();
            zza.zzg(zzbg.zzcr());
            HttpResponse execute = httpClient.execute(httpHost, httpRequest, httpContext);
            zza.zzj(zzbg.zzcs());
            zza.zzb(execute.getStatusLine().getStatusCode());
            Long zza3 = zzh.zza((HttpMessage) execute);
            if (zza3 != null) {
                zza.zzk(zza3.longValue());
            }
            String zza4 = zzh.zza(execute);
            if (zza4 != null) {
                zza.zzc(zza4);
            }
            zza.zzai();
            return execute;
        } catch (IOException e) {
            zza.zzj(zzbg.zzcs());
            zzh.zza(zza);
            throw e;
        }
    }

    private static <T> T zza(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, zzbg zzbg, zzc zzc) throws IOException {
        zzau zza = zzau.zza(zzc);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zza.zza(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).zzb(httpRequest.getRequestLine().getMethod());
            Long zza2 = zzh.zza((HttpMessage) httpRequest);
            if (zza2 != null) {
                zza.zzf(zza2.longValue());
            }
            zzbg.reset();
            zza.zzg(zzbg.zzcr());
            return httpClient.execute(httpHost, httpRequest, new zzg(responseHandler, zzbg, zza));
        } catch (IOException e) {
            zza.zzj(zzbg.zzcs());
            zzh.zza(zza);
            throw e;
        }
    }

    private static <T> T zza(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext, zzbg zzbg, zzc zzc) throws IOException {
        zzau zza = zzau.zza(zzc);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zza.zza(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).zzb(httpRequest.getRequestLine().getMethod());
            Long zza2 = zzh.zza((HttpMessage) httpRequest);
            if (zza2 != null) {
                zza.zzf(zza2.longValue());
            }
            zzbg.reset();
            zza.zzg(zzbg.zzcr());
            return httpClient.execute(httpHost, httpRequest, new zzg(responseHandler, zzbg, zza), httpContext);
        } catch (IOException e) {
            zza.zzj(zzbg.zzcs());
            zzh.zza(zza);
            throw e;
        }
    }
}
