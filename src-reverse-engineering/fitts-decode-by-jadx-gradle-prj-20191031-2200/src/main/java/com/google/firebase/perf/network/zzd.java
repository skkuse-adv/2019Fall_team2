package com.google.firebase.perf.network;

import com.google.android.gms.internal.firebase-perf.zzau;
import com.google.android.gms.internal.firebase-perf.zzbg;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

final class zzd {
    private final zzbg zzfy;
    private final zzau zzgm;
    private long zzgo = -1;
    private final HttpURLConnection zzgt;
    private long zzgu = -1;

    public zzd(HttpURLConnection httpURLConnection, zzbg zzbg, zzau zzau) {
        this.zzgt = httpURLConnection;
        this.zzgm = zzau;
        this.zzfy = zzbg;
        this.zzgm.zza(this.zzgt.getURL().toString());
    }

    public final void connect() throws IOException {
        if (this.zzgu == -1) {
            this.zzfy.reset();
            this.zzgu = this.zzfy.zzcr();
            this.zzgm.zzg(this.zzgu);
        }
        try {
            this.zzgt.connect();
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final void disconnect() {
        this.zzgm.zzj(this.zzfy.zzcs());
        this.zzgm.zzai();
        this.zzgt.disconnect();
    }

    public final Object getContent() throws IOException {
        zzcp();
        this.zzgm.zzb(this.zzgt.getResponseCode());
        try {
            Object content = this.zzgt.getContent();
            if (content instanceof InputStream) {
                this.zzgm.zzc(this.zzgt.getContentType());
                return new zza((InputStream) content, this.zzgm, this.zzfy);
            }
            this.zzgm.zzc(this.zzgt.getContentType());
            this.zzgm.zzk((long) this.zzgt.getContentLength());
            this.zzgm.zzj(this.zzfy.zzcs());
            this.zzgm.zzai();
            return content;
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        zzcp();
        this.zzgm.zzb(this.zzgt.getResponseCode());
        try {
            Object content = this.zzgt.getContent(clsArr);
            if (content instanceof InputStream) {
                this.zzgm.zzc(this.zzgt.getContentType());
                return new zza((InputStream) content, this.zzgm, this.zzfy);
            }
            this.zzgm.zzc(this.zzgt.getContentType());
            this.zzgm.zzk((long) this.zzgt.getContentLength());
            this.zzgm.zzj(this.zzfy.zzcs());
            this.zzgm.zzai();
            return content;
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final InputStream getInputStream() throws IOException {
        zzcp();
        this.zzgm.zzb(this.zzgt.getResponseCode());
        this.zzgm.zzc(this.zzgt.getContentType());
        try {
            return new zza(this.zzgt.getInputStream(), this.zzgm, this.zzfy);
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final long getLastModified() {
        zzcp();
        return this.zzgt.getLastModified();
    }

    public final OutputStream getOutputStream() throws IOException {
        try {
            return new zzc(this.zzgt.getOutputStream(), this.zzgm, this.zzfy);
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final Permission getPermission() throws IOException {
        try {
            return this.zzgt.getPermission();
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final int getResponseCode() throws IOException {
        zzcp();
        if (this.zzgo == -1) {
            this.zzgo = this.zzfy.zzcs();
            this.zzgm.zzi(this.zzgo);
        }
        try {
            int responseCode = this.zzgt.getResponseCode();
            this.zzgm.zzb(responseCode);
            return responseCode;
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final String getResponseMessage() throws IOException {
        zzcp();
        if (this.zzgo == -1) {
            this.zzgo = this.zzfy.zzcs();
            this.zzgm.zzi(this.zzgo);
        }
        try {
            String responseMessage = this.zzgt.getResponseMessage();
            this.zzgm.zzb(this.zzgt.getResponseCode());
            return responseMessage;
        } catch (IOException e) {
            this.zzgm.zzj(this.zzfy.zzcs());
            zzh.zza(this.zzgm);
            throw e;
        }
    }

    public final long getExpiration() {
        zzcp();
        return this.zzgt.getExpiration();
    }

    public final String getHeaderField(int i) {
        zzcp();
        return this.zzgt.getHeaderField(i);
    }

    public final String getHeaderField(String str) {
        zzcp();
        return this.zzgt.getHeaderField(str);
    }

    public final long getHeaderFieldDate(String str, long j) {
        zzcp();
        return this.zzgt.getHeaderFieldDate(str, j);
    }

    public final int getHeaderFieldInt(String str, int i) {
        zzcp();
        return this.zzgt.getHeaderFieldInt(str, i);
    }

    public final long getHeaderFieldLong(String str, long j) {
        zzcp();
        return this.zzgt.getHeaderFieldLong(str, j);
    }

    public final String getHeaderFieldKey(int i) {
        zzcp();
        return this.zzgt.getHeaderFieldKey(i);
    }

    public final Map<String, List<String>> getHeaderFields() {
        zzcp();
        return this.zzgt.getHeaderFields();
    }

    public final String getContentEncoding() {
        zzcp();
        return this.zzgt.getContentEncoding();
    }

    public final int getContentLength() {
        zzcp();
        return this.zzgt.getContentLength();
    }

    public final long getContentLengthLong() {
        zzcp();
        return this.zzgt.getContentLengthLong();
    }

    public final String getContentType() {
        zzcp();
        return this.zzgt.getContentType();
    }

    public final long getDate() {
        zzcp();
        return this.zzgt.getDate();
    }

    public final void addRequestProperty(String str, String str2) {
        this.zzgt.addRequestProperty(str, str2);
    }

    public final boolean equals(Object obj) {
        return this.zzgt.equals(obj);
    }

    public final boolean getAllowUserInteraction() {
        return this.zzgt.getAllowUserInteraction();
    }

    public final int getConnectTimeout() {
        return this.zzgt.getConnectTimeout();
    }

    public final boolean getDefaultUseCaches() {
        return this.zzgt.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.zzgt.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.zzgt.getDoOutput();
    }

    public final InputStream getErrorStream() {
        zzcp();
        try {
            this.zzgm.zzb(this.zzgt.getResponseCode());
        } catch (IOException unused) {
        }
        InputStream errorStream = this.zzgt.getErrorStream();
        return errorStream != null ? new zza(errorStream, this.zzgm, this.zzfy) : errorStream;
    }

    public final long getIfModifiedSince() {
        return this.zzgt.getIfModifiedSince();
    }

    public final boolean getInstanceFollowRedirects() {
        return this.zzgt.getInstanceFollowRedirects();
    }

    public final int getReadTimeout() {
        return this.zzgt.getReadTimeout();
    }

    public final String getRequestMethod() {
        return this.zzgt.getRequestMethod();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.zzgt.getRequestProperties();
    }

    public final String getRequestProperty(String str) {
        return this.zzgt.getRequestProperty(str);
    }

    public final URL getURL() {
        return this.zzgt.getURL();
    }

    public final boolean getUseCaches() {
        return this.zzgt.getUseCaches();
    }

    public final int hashCode() {
        return this.zzgt.hashCode();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.zzgt.setAllowUserInteraction(z);
    }

    public final void setChunkedStreamingMode(int i) {
        this.zzgt.setChunkedStreamingMode(i);
    }

    public final void setConnectTimeout(int i) {
        this.zzgt.setConnectTimeout(i);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.zzgt.setDefaultUseCaches(z);
    }

    public final void setDoInput(boolean z) {
        this.zzgt.setDoInput(z);
    }

    public final void setDoOutput(boolean z) {
        this.zzgt.setDoOutput(z);
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.zzgt.setFixedLengthStreamingMode(i);
    }

    public final void setFixedLengthStreamingMode(long j) {
        this.zzgt.setFixedLengthStreamingMode(j);
    }

    public final void setIfModifiedSince(long j) {
        this.zzgt.setIfModifiedSince(j);
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.zzgt.setInstanceFollowRedirects(z);
    }

    public final void setReadTimeout(int i) {
        this.zzgt.setReadTimeout(i);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        this.zzgt.setRequestMethod(str);
    }

    public final void setRequestProperty(String str, String str2) {
        this.zzgt.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.zzgt.setUseCaches(z);
    }

    public final String toString() {
        return this.zzgt.toString();
    }

    public final boolean usingProxy() {
        return this.zzgt.usingProxy();
    }

    private final void zzcp() {
        if (this.zzgu == -1) {
            this.zzfy.reset();
            this.zzgu = this.zzfy.zzcr();
            this.zzgm.zzg(this.zzgu);
        }
        String requestMethod = this.zzgt.getRequestMethod();
        if (requestMethod != null) {
            this.zzgm.zzb(requestMethod);
        } else if (this.zzgt.getDoOutput()) {
            this.zzgm.zzb(HttpRequest.METHOD_POST);
        } else {
            this.zzgm.zzb(HttpRequest.METHOD_GET);
        }
    }
}
