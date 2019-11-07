package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class zzjt extends SSLSocket {
    private final SSLSocket zzuc;

    zzjt(zzjr zzjr, SSLSocket sSLSocket) {
        this.zzuc = sSLSocket;
    }

    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null) {
            String str = "SSLv3";
            if (Arrays.asList(strArr).contains(str)) {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.zzuc.getEnabledProtocols()));
                if (arrayList.size() > 1) {
                    arrayList.remove(str);
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
        this.zzuc.setEnabledProtocols(strArr);
    }

    public final String[] getSupportedCipherSuites() {
        return this.zzuc.getSupportedCipherSuites();
    }

    public final String[] getEnabledCipherSuites() {
        return this.zzuc.getEnabledCipherSuites();
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.zzuc.setEnabledCipherSuites(strArr);
    }

    public final String[] getSupportedProtocols() {
        return this.zzuc.getSupportedProtocols();
    }

    public final String[] getEnabledProtocols() {
        return this.zzuc.getEnabledProtocols();
    }

    public final SSLSession getSession() {
        return this.zzuc.getSession();
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zzuc.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zzuc.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void startHandshake() throws IOException {
        this.zzuc.startHandshake();
    }

    public final void setUseClientMode(boolean z) {
        this.zzuc.setUseClientMode(z);
    }

    public final boolean getUseClientMode() {
        return this.zzuc.getUseClientMode();
    }

    public final void setNeedClientAuth(boolean z) {
        this.zzuc.setNeedClientAuth(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.zzuc.setWantClientAuth(z);
    }

    public final boolean getNeedClientAuth() {
        return this.zzuc.getNeedClientAuth();
    }

    public final boolean getWantClientAuth() {
        return this.zzuc.getWantClientAuth();
    }

    public final void setEnableSessionCreation(boolean z) {
        this.zzuc.setEnableSessionCreation(z);
    }

    public final boolean getEnableSessionCreation() {
        return this.zzuc.getEnableSessionCreation();
    }

    public final void bind(SocketAddress socketAddress) throws IOException {
        this.zzuc.bind(socketAddress);
    }

    public final synchronized void close() throws IOException {
        this.zzuc.close();
    }

    public final void connect(SocketAddress socketAddress) throws IOException {
        this.zzuc.connect(socketAddress);
    }

    public final void connect(SocketAddress socketAddress, int i) throws IOException {
        this.zzuc.connect(socketAddress, i);
    }

    public final SocketChannel getChannel() {
        return this.zzuc.getChannel();
    }

    public final InetAddress getInetAddress() {
        return this.zzuc.getInetAddress();
    }

    public final InputStream getInputStream() throws IOException {
        return this.zzuc.getInputStream();
    }

    public final boolean getKeepAlive() throws SocketException {
        return this.zzuc.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.zzuc.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.zzuc.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.zzuc.getLocalSocketAddress();
    }

    public final boolean getOOBInline() throws SocketException {
        return this.zzuc.getOOBInline();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.zzuc.getOutputStream();
    }

    public final int getPort() {
        return this.zzuc.getPort();
    }

    public final synchronized int getReceiveBufferSize() throws SocketException {
        return this.zzuc.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.zzuc.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() throws SocketException {
        return this.zzuc.getReuseAddress();
    }

    public final synchronized int getSendBufferSize() throws SocketException {
        return this.zzuc.getSendBufferSize();
    }

    public final int getSoLinger() throws SocketException {
        return this.zzuc.getSoLinger();
    }

    public final synchronized int getSoTimeout() throws SocketException {
        return this.zzuc.getSoTimeout();
    }

    public final boolean getTcpNoDelay() throws SocketException {
        return this.zzuc.getTcpNoDelay();
    }

    public final int getTrafficClass() throws SocketException {
        return this.zzuc.getTrafficClass();
    }

    public final boolean isBound() {
        return this.zzuc.isBound();
    }

    public final boolean isClosed() {
        return this.zzuc.isClosed();
    }

    public final boolean isConnected() {
        return this.zzuc.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.zzuc.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.zzuc.isOutputShutdown();
    }

    public final void sendUrgentData(int i) throws IOException {
        this.zzuc.sendUrgentData(i);
    }

    public final void setKeepAlive(boolean z) throws SocketException {
        this.zzuc.setKeepAlive(z);
    }

    public final void setOOBInline(boolean z) throws SocketException {
        this.zzuc.setOOBInline(z);
    }

    public final void setPerformancePreferences(int i, int i2, int i3) {
        this.zzuc.setPerformancePreferences(i, i2, i3);
    }

    public final synchronized void setReceiveBufferSize(int i) throws SocketException {
        this.zzuc.setReceiveBufferSize(i);
    }

    public final void setReuseAddress(boolean z) throws SocketException {
        this.zzuc.setReuseAddress(z);
    }

    public final synchronized void setSendBufferSize(int i) throws SocketException {
        this.zzuc.setSendBufferSize(i);
    }

    public final void setSoLinger(boolean z, int i) throws SocketException {
        this.zzuc.setSoLinger(z, i);
    }

    public final synchronized void setSoTimeout(int i) throws SocketException {
        this.zzuc.setSoTimeout(i);
    }

    public final void setTcpNoDelay(boolean z) throws SocketException {
        this.zzuc.setTcpNoDelay(z);
    }

    public final void setTrafficClass(int i) throws SocketException {
        this.zzuc.setTrafficClass(i);
    }

    public final void shutdownInput() throws IOException {
        this.zzuc.shutdownInput();
    }

    public final void shutdownOutput() throws IOException {
        this.zzuc.shutdownOutput();
    }

    public final String toString() {
        return this.zzuc.toString();
    }

    public final boolean equals(Object obj) {
        return this.zzuc.equals(obj);
    }
}
