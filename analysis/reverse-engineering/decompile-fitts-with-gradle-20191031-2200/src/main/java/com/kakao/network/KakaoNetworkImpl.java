package com.kakao.network;

import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.kakao.network.multipart.MultipartRequestEntity;
import com.kakao.network.multipart.Part;
import com.kakao.util.helper.log.Logger;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class KakaoNetworkImpl implements INetwork {
    private static final int DEFAULT_CONNECTION_TO_IN_MS = 5000;
    private static final int DEFAULT_REQUEST_TO_IN_MS = 30000;
    private static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };
    private static final String ISO_CHARSET = "ISO-8859-1";
    private String charset = ISO_CHARSET;
    private final Map<String, String> header = new HashMap();
    private final Map<String, String> params = new HashMap();
    private final List<Part> parts = new ArrayList();
    private int statusCode = -1;
    private HttpURLConnection urlConnection = null;

    public void create(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("++ url: ");
        sb.append(str);
        Logger.d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("++ method: ");
        sb2.append(str2);
        Logger.d(sb2.toString());
        this.charset = str3;
        this.urlConnection = (HttpURLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection(Proxy.NO_PROXY));
        if (str.startsWith("https")) {
            ((HttpsURLConnection) this.urlConnection).setHostnameVerifier(DO_NOT_VERIFY);
        }
        this.urlConnection.setRequestMethod(str2);
    }

    public void configure() throws IOException {
        MultipartRequestEntity multipartRequestEntity;
        this.urlConnection.setDoInput(true);
        this.urlConnection.setConnectTimeout(DEFAULT_CONNECTION_TO_IN_MS);
        this.urlConnection.setReadTimeout(DEFAULT_REQUEST_TO_IN_MS);
        int i = 0;
        this.urlConnection.setInstanceFollowRedirects(false);
        this.urlConnection.setRequestProperty("Connection", "keep-alive");
        if (!this.header.isEmpty()) {
            for (String str : this.header.keySet()) {
                this.urlConnection.setRequestProperty(str, (String) this.header.get(str));
            }
        }
        String requestMethod = this.urlConnection.getRequestMethod();
        if (HttpRequest.METHOD_POST.equals(requestMethod) || HttpRequest.METHOD_PUT.equals(requestMethod)) {
            HttpURLConnection httpURLConnection = this.urlConnection;
            String str2 = HttpRequest.HEADER_CONTENT_LENGTH;
            httpURLConnection.setRequestProperty(str2, "0");
            this.urlConnection.setDoOutput(true);
            String str3 = null;
            if (!this.params.isEmpty()) {
                String postDataString = getPostDataString(this.params);
                i = 0 + postDataString.length();
                str3 = postDataString;
                multipartRequestEntity = null;
            } else if (!this.parts.isEmpty()) {
                multipartRequestEntity = new MultipartRequestEntity(this.parts);
                i = (int) (((long) 0) + multipartRequestEntity.getContentLength());
                this.urlConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, multipartRequestEntity.getContentType());
            } else {
                multipartRequestEntity = null;
            }
            if (i > 0) {
                this.urlConnection.setFixedLengthStreamingMode(i);
                this.urlConnection.setRequestProperty(str2, String.valueOf(i));
            }
            if (str3 != null && !str3.isEmpty()) {
                this.urlConnection.getOutputStream().write(str3.getBytes(this.charset));
            }
            if (multipartRequestEntity != null) {
                multipartRequestEntity.writeRequest(this.urlConnection.getOutputStream());
            }
        }
    }

    public void connect() throws IOException {
        try {
            this.statusCode = this.urlConnection.getResponseCode();
        } catch (IOException unused) {
            this.statusCode = this.urlConnection.getResponseCode();
        }
    }

    public void disconnect() {
        this.params.clear();
        this.header.clear();
        this.parts.clear();
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.statusCode = Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void addHeader(String str, String str2) {
        this.header.put(str, str2);
    }

    public void addParam(String str, String str2) {
        this.params.put(str, str2);
    }

    public byte[] readFully() throws IOException {
        InputStream inputStream = getInputStream(this.urlConnection);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return byteArray;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
    }

    public void addPart(Part part) {
        this.parts.add(part);
    }

    private String getPostDataString(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode((String) entry.getKey(), this.charset));
            sb.append("=");
            sb.append(URLEncoder.encode((String) entry.getValue(), this.charset));
        }
        return sb.toString();
    }

    private InputStream getInputStream(HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getResponseCode() < 400) {
            return httpURLConnection.getInputStream();
        }
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            errorStream = new ByteArrayInputStream(new byte[0]);
        }
        return errorStream;
    }
}
