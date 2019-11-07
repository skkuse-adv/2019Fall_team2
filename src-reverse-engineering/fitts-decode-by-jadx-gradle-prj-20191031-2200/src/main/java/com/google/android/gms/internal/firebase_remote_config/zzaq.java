package com.google.android.gms.internal.firebase_remote_config;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

final class zzaq extends zzai {
    private final int responseCode;
    private final String responseMessage;
    private final HttpURLConnection zzct;
    private final ArrayList<String> zzcu = new ArrayList<>();
    private final ArrayList<String> zzcv = new ArrayList<>();

    zzaq(HttpURLConnection httpURLConnection) throws IOException {
        this.zzct = httpURLConnection;
        int responseCode2 = httpURLConnection.getResponseCode();
        if (responseCode2 == -1) {
            responseCode2 = 0;
        }
        this.responseCode = responseCode2;
        this.responseMessage = httpURLConnection.getResponseMessage();
        ArrayList<String> arrayList = this.zzcu;
        ArrayList<String> arrayList2 = this.zzcv;
        for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                for (String str2 : (List) entry.getValue()) {
                    if (str2 != null) {
                        arrayList.add(str);
                        arrayList2.add(str2);
                    }
                }
            }
        }
    }

    public final int getStatusCode() {
        return this.responseCode;
    }

    public final InputStream getContent() throws IOException {
        InputStream inputStream;
        try {
            inputStream = this.zzct.getInputStream();
        } catch (IOException unused) {
            inputStream = this.zzct.getErrorStream();
        }
        if (inputStream == null) {
            return null;
        }
        return new zzat(this, inputStream);
    }

    public final String getContentEncoding() {
        return this.zzct.getContentEncoding();
    }

    public final long getContentLength() {
        String headerField = this.zzct.getHeaderField(HttpRequest.HEADER_CONTENT_LENGTH);
        if (headerField == null) {
            return -1;
        }
        return Long.parseLong(headerField);
    }

    public final String getContentType() {
        return this.zzct.getHeaderField(HttpRequest.HEADER_CONTENT_TYPE);
    }

    public final String getReasonPhrase() {
        return this.responseMessage;
    }

    public final String zzag() {
        String headerField = this.zzct.getHeaderField(0);
        if (headerField == null || !headerField.startsWith("HTTP/1.")) {
            return null;
        }
        return headerField;
    }

    public final int zzah() {
        return this.zzcu.size();
    }

    public final String zzc(int i) {
        return (String) this.zzcu.get(i);
    }

    public final String zzd(int i) {
        return (String) this.zzcv.get(i);
    }

    public final void disconnect() {
        this.zzct.disconnect();
    }
}
