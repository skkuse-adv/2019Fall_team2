package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public final class zzao implements zzap {
    private final Proxy zzcs;

    public zzao() {
        this(null);
    }

    public zzao(Proxy proxy) {
        this.zzcs = proxy;
    }

    public final HttpURLConnection zza(URL url) throws IOException {
        Proxy proxy = this.zzcs;
        return (HttpURLConnection) (proxy == null ? url.openConnection() : url.openConnection(proxy));
    }
}
