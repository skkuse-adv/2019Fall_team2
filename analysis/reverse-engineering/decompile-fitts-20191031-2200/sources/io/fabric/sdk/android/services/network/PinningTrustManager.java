package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class PinningTrustManager implements X509TrustManager {
    private static final X509Certificate[] NO_ISSUERS = new X509Certificate[0];
    private final Set<X509Certificate> cache = Collections.synchronizedSet(new HashSet());
    private final long pinCreationTimeMillis;
    private final List<byte[]> pins = new LinkedList();
    private final SystemKeyStore systemKeyStore;
    private final TrustManager[] systemTrustManagers;

    public PinningTrustManager(SystemKeyStore systemKeyStore2, PinningInfoProvider pinningInfoProvider) {
        this.systemTrustManagers = initializeSystemTrustManagers(systemKeyStore2);
        this.systemKeyStore = systemKeyStore2;
        this.pinCreationTimeMillis = pinningInfoProvider.getPinCreationTimeInMillis();
        for (String hexStringToByteArray : pinningInfoProvider.getPins()) {
            this.pins.add(hexStringToByteArray(hexStringToByteArray));
        }
    }

    private TrustManager[] initializeSystemTrustManagers(SystemKeyStore systemKeyStore2) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(systemKeyStore2.trustStore);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean isValidPin(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.pins) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }

    private void checkSystemTrust(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        for (TrustManager trustManager : this.systemTrustManagers) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void checkPinTrust(X509Certificate[] x509CertificateArr) throws CertificateException {
        if (this.pinCreationTimeMillis == -1 || System.currentTimeMillis() - this.pinCreationTimeMillis <= 15552000000L) {
            X509Certificate[] cleanChain = CertificateChainCleaner.getCleanChain(x509CertificateArr, this.systemKeyStore);
            int length = cleanChain.length;
            int i = 0;
            while (i < length) {
                if (!isValidPin(cleanChain[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        Logger logger = Fabric.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pins are stale, (");
        sb.append(System.currentTimeMillis() - this.pinCreationTimeMillis);
        sb.append(" millis vs ");
        sb.append(15552000000L);
        sb.append(" millis) falling back to system trust.");
        logger.w(Fabric.TAG, sb.toString());
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.cache.contains(x509CertificateArr[0])) {
            checkSystemTrust(x509CertificateArr, str);
            checkPinTrust(x509CertificateArr);
            this.cache.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return NO_ISSUERS;
    }

    private byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
