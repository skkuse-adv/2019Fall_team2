package com.google.android.gms.internal.firebase_remote_config;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzas extends zzag {
    private static final String[] zzca;
    private final zzap zzcw;

    public zzas() {
        this(null, null, null);
    }

    private zzas(zzap zzap, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        zzao zzao;
        if (System.getProperty("com.google.api.client.should_use_proxy") != null) {
            zzao = new zzao(new Proxy(Type.HTTP, new InetSocketAddress(System.getProperty("https.proxyHost"), Integer.parseInt(System.getProperty("https.proxyPort")))));
        } else {
            zzao = new zzao();
        }
        this.zzcw = zzao;
    }

    public final boolean zzz(String str) {
        return Arrays.binarySearch(zzca, str) >= 0;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzaj zzc(String str, String str2) throws IOException {
        Object[] objArr = {str};
        if (zzz(str)) {
            HttpURLConnection zza = this.zzcw.zza(new URL(str2));
            zza.setRequestMethod(str);
            boolean z = zza instanceof HttpsURLConnection;
            return new zzar(zza);
        }
        throw new IllegalArgumentException(zzdy.zza("HTTP method %s not supported", objArr));
    }

    static {
        String[] strArr = {HttpRequest.METHOD_DELETE, HttpRequest.METHOD_GET, HttpRequest.METHOD_HEAD, HttpRequest.METHOD_OPTIONS, HttpRequest.METHOD_POST, HttpRequest.METHOD_PUT, HttpRequest.METHOD_TRACE};
        zzca = strArr;
        Arrays.sort(strArr);
    }
}
