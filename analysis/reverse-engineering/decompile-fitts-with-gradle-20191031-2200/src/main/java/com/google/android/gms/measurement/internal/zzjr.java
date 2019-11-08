package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class zzjr extends SSLSocketFactory {
    private final SSLSocketFactory zztv;

    zzjr() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    private zzjr(SSLSocketFactory sSLSocketFactory) {
        this.zztv = sSLSocketFactory;
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return zza((SSLSocket) this.zztv.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.zztv.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zztv.getSupportedCipherSuites();
    }

    public final Socket createSocket(String str, int i) throws IOException {
        return zza((SSLSocket) this.zztv.createSocket(str, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return zza((SSLSocket) this.zztv.createSocket(inetAddress, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return zza((SSLSocket) this.zztv.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return zza((SSLSocket) this.zztv.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket() throws IOException {
        return zza((SSLSocket) this.zztv.createSocket());
    }

    private final SSLSocket zza(SSLSocket sSLSocket) {
        return new zzjt(this, sSLSocket);
    }
}
