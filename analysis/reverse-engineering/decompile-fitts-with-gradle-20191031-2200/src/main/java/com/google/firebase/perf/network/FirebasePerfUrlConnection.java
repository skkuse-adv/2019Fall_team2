package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.android.gms.internal.firebase-perf.zzau;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.android.gms.internal.firebase-perf.zzbl;
import com.google.firebase.perf.internal.zzc;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class FirebasePerfUrlConnection {
    private FirebasePerfUrlConnection() {
    }

    @Keep
    public static InputStream openStream(URL url) throws IOException {
        return zza(new zzbl(url), zzc.zzba(), new zzbg());
    }

    @Keep
    public static Object getContent(URL url) throws IOException {
        return zzb(new zzbl(url), zzc.zzba(), new zzbg());
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        return zza(new zzbl(url), clsArr, zzc.zzba(), new zzbg());
    }

    @Keep
    public static Object instrument(Object obj) throws IOException {
        if (obj instanceof HttpsURLConnection) {
            return new zze((HttpsURLConnection) obj, new zzbg(), zzau.zza(zzc.zzba()));
        }
        return obj instanceof HttpURLConnection ? new zzb((HttpURLConnection) obj, new zzbg(), zzau.zza(zzc.zzba())) : obj;
    }

    private static InputStream zza(zzbl zzbl, zzc zzc, zzbg zzbg) throws IOException {
        zzbg.reset();
        long zzcr = zzbg.zzcr();
        zzau zza = zzau.zza(zzc);
        try {
            URLConnection openConnection = zzbl.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new zze((HttpsURLConnection) openConnection, zzbg, zza).getInputStream();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new zzb((HttpURLConnection) openConnection, zzbg, zza).getInputStream();
            }
            return openConnection.getInputStream();
        } catch (IOException e) {
            zza.zzg(zzcr);
            zza.zzj(zzbg.zzcs());
            zza.zza(zzbl.toString());
            zzh.zza(zza);
            throw e;
        }
    }

    private static Object zzb(zzbl zzbl, zzc zzc, zzbg zzbg) throws IOException {
        zzbg.reset();
        long zzcr = zzbg.zzcr();
        zzau zza = zzau.zza(zzc);
        try {
            URLConnection openConnection = zzbl.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new zze((HttpsURLConnection) openConnection, zzbg, zza).getContent();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new zzb((HttpURLConnection) openConnection, zzbg, zza).getContent();
            }
            return openConnection.getContent();
        } catch (IOException e) {
            zza.zzg(zzcr);
            zza.zzj(zzbg.zzcs());
            zza.zza(zzbl.toString());
            zzh.zza(zza);
            throw e;
        }
    }

    private static Object zza(zzbl zzbl, Class[] clsArr, zzc zzc, zzbg zzbg) throws IOException {
        zzbg.reset();
        long zzcr = zzbg.zzcr();
        zzau zza = zzau.zza(zzc);
        try {
            URLConnection openConnection = zzbl.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new zze((HttpsURLConnection) openConnection, zzbg, zza).getContent(clsArr);
            }
            if (openConnection instanceof HttpURLConnection) {
                return new zzb((HttpURLConnection) openConnection, zzbg, zza).getContent(clsArr);
            }
            return openConnection.getContent(clsArr);
        } catch (IOException e) {
            zza.zzg(zzcr);
            zza.zzj(zzbg.zzcs());
            zza.zza(zzbl.toString());
            zzh.zza(zza);
            throw e;
        }
    }
}
