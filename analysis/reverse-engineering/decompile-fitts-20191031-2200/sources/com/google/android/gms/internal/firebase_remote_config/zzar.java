package com.google.android.gms.internal.firebase_remote_config;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

final class zzar extends zzaj {
    private final HttpURLConnection zzct;

    zzar(HttpURLConnection httpURLConnection) {
        this.zzct = httpURLConnection;
        httpURLConnection.setInstanceFollowRedirects(false);
    }

    public final void addHeader(String str, String str2) {
        this.zzct.addRequestProperty(str, str2);
    }

    public final void zza(int i, int i2) {
        this.zzct.setReadTimeout(i2);
        this.zzct.setConnectTimeout(i);
    }

    public final zzai zzaj() throws IOException {
        HttpURLConnection httpURLConnection = this.zzct;
        if (zzai() != null) {
            String contentType = getContentType();
            if (contentType != null) {
                addHeader(HttpRequest.HEADER_CONTENT_TYPE, contentType);
            }
            String contentEncoding = getContentEncoding();
            if (contentEncoding != null) {
                addHeader(HttpRequest.HEADER_CONTENT_ENCODING, contentEncoding);
            }
            long contentLength = getContentLength();
            if (contentLength >= 0) {
                httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_LENGTH, Long.toString(contentLength));
            }
            String requestMethod = httpURLConnection.getRequestMethod();
            if (HttpRequest.METHOD_POST.equals(requestMethod) || HttpRequest.METHOD_PUT.equals(requestMethod)) {
                httpURLConnection.setDoOutput(true);
                if (contentLength < 0 || contentLength > 2147483647L) {
                    httpURLConnection.setChunkedStreamingMode(0);
                } else {
                    httpURLConnection.setFixedLengthStreamingMode((int) contentLength);
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    zzai().writeTo(outputStream);
                    try {
                    } catch (IOException e) {
                        throw e;
                    }
                } finally {
                    try {
                        outputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } else {
                Object[] objArr = {requestMethod};
                if (!(contentLength == 0)) {
                    throw new IllegalArgumentException(zzdy.zza("%s with non-zero content length is not supported", objArr));
                }
            }
        }
        try {
            httpURLConnection.connect();
            return new zzaq(httpURLConnection);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
