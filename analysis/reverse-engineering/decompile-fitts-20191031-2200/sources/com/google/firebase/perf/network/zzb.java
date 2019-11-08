package com.google.firebase.perf.network;

import com.google.android.gms.internal.firebase-perf.zzau;
import com.google.android.gms.internal.firebase-perf.zzbg;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public final class zzb extends HttpURLConnection {
    private final zzd zzgq;

    zzb(HttpURLConnection httpURLConnection, zzbg zzbg, zzau zzau) {
        super(httpURLConnection.getURL());
        this.zzgq = new zzd(httpURLConnection, zzbg, zzau);
    }

    public final void connect() throws IOException {
        this.zzgq.connect();
    }

    public final void disconnect() {
        this.zzgq.disconnect();
    }

    public final Object getContent() throws IOException {
        return this.zzgq.getContent();
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        return this.zzgq.getContent(clsArr);
    }

    public final InputStream getInputStream() throws IOException {
        return this.zzgq.getInputStream();
    }

    public final long getLastModified() {
        return this.zzgq.getLastModified();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.zzgq.getOutputStream();
    }

    public final Permission getPermission() throws IOException {
        return this.zzgq.getPermission();
    }

    public final int getResponseCode() throws IOException {
        return this.zzgq.getResponseCode();
    }

    public final String getResponseMessage() throws IOException {
        return this.zzgq.getResponseMessage();
    }

    public final long getExpiration() {
        return this.zzgq.getExpiration();
    }

    public final String getHeaderField(int i) {
        return this.zzgq.getHeaderField(i);
    }

    public final String getHeaderField(String str) {
        return this.zzgq.getHeaderField(str);
    }

    public final long getHeaderFieldDate(String str, long j) {
        return this.zzgq.getHeaderFieldDate(str, j);
    }

    public final int getHeaderFieldInt(String str, int i) {
        return this.zzgq.getHeaderFieldInt(str, i);
    }

    public final long getHeaderFieldLong(String str, long j) {
        return this.zzgq.getHeaderFieldLong(str, j);
    }

    public final String getHeaderFieldKey(int i) {
        return this.zzgq.getHeaderFieldKey(i);
    }

    public final Map<String, List<String>> getHeaderFields() {
        return this.zzgq.getHeaderFields();
    }

    public final String getContentEncoding() {
        return this.zzgq.getContentEncoding();
    }

    public final int getContentLength() {
        return this.zzgq.getContentLength();
    }

    public final long getContentLengthLong() {
        return this.zzgq.getContentLengthLong();
    }

    public final String getContentType() {
        return this.zzgq.getContentType();
    }

    public final long getDate() {
        return this.zzgq.getDate();
    }

    public final void addRequestProperty(String str, String str2) {
        this.zzgq.addRequestProperty(str, str2);
    }

    public final boolean equals(Object obj) {
        return this.zzgq.equals(obj);
    }

    public final boolean getAllowUserInteraction() {
        return this.zzgq.getAllowUserInteraction();
    }

    public final int getConnectTimeout() {
        return this.zzgq.getConnectTimeout();
    }

    public final boolean getDefaultUseCaches() {
        return this.zzgq.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.zzgq.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.zzgq.getDoOutput();
    }

    public final InputStream getErrorStream() {
        return this.zzgq.getErrorStream();
    }

    public final long getIfModifiedSince() {
        return this.zzgq.getIfModifiedSince();
    }

    public final boolean getInstanceFollowRedirects() {
        return this.zzgq.getInstanceFollowRedirects();
    }

    public final int getReadTimeout() {
        return this.zzgq.getReadTimeout();
    }

    public final String getRequestMethod() {
        return this.zzgq.getRequestMethod();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.zzgq.getRequestProperties();
    }

    public final String getRequestProperty(String str) {
        return this.zzgq.getRequestProperty(str);
    }

    public final URL getURL() {
        return this.zzgq.getURL();
    }

    public final boolean getUseCaches() {
        return this.zzgq.getUseCaches();
    }

    public final int hashCode() {
        return this.zzgq.hashCode();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.zzgq.setAllowUserInteraction(z);
    }

    public final void setChunkedStreamingMode(int i) {
        this.zzgq.setChunkedStreamingMode(i);
    }

    public final void setConnectTimeout(int i) {
        this.zzgq.setConnectTimeout(i);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.zzgq.setDefaultUseCaches(z);
    }

    public final void setDoInput(boolean z) {
        this.zzgq.setDoInput(z);
    }

    public final void setDoOutput(boolean z) {
        this.zzgq.setDoOutput(z);
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.zzgq.setFixedLengthStreamingMode(i);
    }

    public final void setFixedLengthStreamingMode(long j) {
        this.zzgq.setFixedLengthStreamingMode(j);
    }

    public final void setIfModifiedSince(long j) {
        this.zzgq.setIfModifiedSince(j);
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.zzgq.setInstanceFollowRedirects(z);
    }

    public final void setReadTimeout(int i) {
        this.zzgq.setReadTimeout(i);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        this.zzgq.setRequestMethod(str);
    }

    public final void setRequestProperty(String str, String str2) {
        this.zzgq.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.zzgq.setUseCaches(z);
    }

    public final String toString() {
        return this.zzgq.toString();
    }

    public final boolean usingProxy() {
        return this.zzgq.usingProxy();
    }
}
