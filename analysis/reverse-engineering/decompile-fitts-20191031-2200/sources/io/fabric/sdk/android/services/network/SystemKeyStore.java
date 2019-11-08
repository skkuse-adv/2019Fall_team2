package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

class SystemKeyStore {
    private final HashMap<Principal, X509Certificate> trustRoots;
    final KeyStore trustStore;

    public SystemKeyStore(InputStream inputStream, String str) {
        KeyStore trustStore2 = getTrustStore(inputStream, str);
        this.trustRoots = initializeTrustedRoots(trustStore2);
        this.trustStore = trustStore2;
    }

    public boolean isTrustRoot(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate) this.trustRoots.get(x509Certificate.getSubjectX500Principal());
        return x509Certificate2 != null && x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey());
    }

    public X509Certificate getTrustRootFor(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate) this.trustRoots.get(x509Certificate.getIssuerX500Principal());
        if (x509Certificate2 == null || x509Certificate2.getSubjectX500Principal().equals(x509Certificate.getSubjectX500Principal())) {
            return null;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return x509Certificate2;
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private HashMap<Principal, X509Certificate> initializeTrustedRoots(KeyStore keyStore) {
        try {
            HashMap<Principal, X509Certificate> hashMap = new HashMap<>();
            Enumeration aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate((String) aliases.nextElement());
                if (x509Certificate != null) {
                    hashMap.put(x509Certificate.getSubjectX500Principal(), x509Certificate);
                }
            }
            return hashMap;
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        }
    }

    private KeyStore getTrustStore(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        try {
            KeyStore instance = KeyStore.getInstance("BKS");
            bufferedInputStream = new BufferedInputStream(inputStream);
            instance.load(bufferedInputStream, str.toCharArray());
            bufferedInputStream.close();
            return instance;
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        } catch (CertificateException e3) {
            throw new AssertionError(e3);
        } catch (IOException e4) {
            throw new AssertionError(e4);
        } catch (Throwable th) {
            bufferedInputStream.close();
            throw th;
        }
    }
}
