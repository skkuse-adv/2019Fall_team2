package com.google.android.gms.internal.firebase-perf;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public final class zzbl {
    private final URL zzic;

    public zzbl(URL url) {
        this.zzic = url;
    }

    public final URLConnection openConnection() throws IOException {
        return this.zzic.openConnection();
    }

    public final String toString() {
        return this.zzic.toString();
    }
}
