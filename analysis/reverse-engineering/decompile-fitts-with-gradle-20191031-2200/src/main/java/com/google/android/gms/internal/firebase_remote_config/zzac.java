package com.google.android.gms.internal.firebase_remote_config;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

public final class zzac {
    private final int statusCode;
    private final zzy zzag;
    private int zzbf;
    private boolean zzbg;
    private InputStream zzbr;
    private final String zzbs;
    private final String zzbt;
    private zzai zzbu;
    private final String zzbv;
    private final zzab zzbw;
    private boolean zzbx;

    zzac(zzab zzab, zzai zzai) throws IOException {
        StringBuilder sb;
        this.zzbw = zzab;
        this.zzbf = zzab.zzv();
        this.zzbg = zzab.zzw();
        this.zzbu = zzai;
        this.zzbs = zzai.getContentEncoding();
        int statusCode2 = zzai.getStatusCode();
        boolean z = false;
        if (statusCode2 < 0) {
            statusCode2 = 0;
        }
        this.statusCode = statusCode2;
        String reasonPhrase = zzai.getReasonPhrase();
        this.zzbv = reasonPhrase;
        Logger logger = zzag.zzbz;
        if (this.zzbg && logger.isLoggable(Level.CONFIG)) {
            z = true;
        }
        zzy zzy = null;
        if (z) {
            sb = new StringBuilder();
            sb.append("-------------- RESPONSE --------------");
            sb.append(zzcl.zzgg);
            String zzag2 = zzai.zzag();
            if (zzag2 != null) {
                sb.append(zzag2);
            } else {
                sb.append(this.statusCode);
                if (reasonPhrase != null) {
                    sb.append(' ');
                    sb.append(reasonPhrase);
                }
            }
            sb.append(zzcl.zzgg);
        } else {
            sb = null;
        }
        zzab.zzy().zza(zzai, z ? sb : null);
        String contentType = zzai.getContentType();
        if (contentType == null) {
            contentType = zzab.zzy().getContentType();
        }
        this.zzbt = contentType;
        if (contentType != null) {
            zzy = new zzy(contentType);
        }
        this.zzag = zzy;
        if (z) {
            logger.logp(Level.CONFIG, "com.google.api.client.http.HttpResponse", "<init>", sb.toString());
        }
    }

    public final String getContentType() {
        return this.zzbt;
    }

    public final zzw zzx() {
        return this.zzbw.zzy();
    }

    public final boolean zzad() {
        int i = this.statusCode;
        return i >= 200 && i < 300;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.zzbv;
    }

    public final InputStream getContent() throws IOException {
        if (!this.zzbx) {
            InputStream content = this.zzbu.getContent();
            if (content != null) {
                try {
                    String str = this.zzbs;
                    if (str != null && str.contains(HttpRequest.ENCODING_GZIP)) {
                        content = new GZIPInputStream(content);
                    }
                    Logger logger = zzag.zzbz;
                    if (this.zzbg && logger.isLoggable(Level.CONFIG)) {
                        content = new zzce(content, logger, Level.CONFIG, this.zzbf);
                    }
                    this.zzbr = content;
                } catch (EOFException unused) {
                    content.close();
                } catch (Throwable th) {
                    content.close();
                    throw th;
                }
            }
            this.zzbx = true;
        }
        return this.zzbr;
    }

    public final void ignore() throws IOException {
        InputStream content = getContent();
        if (content != null) {
            content.close();
        }
    }

    public final void disconnect() throws IOException {
        ignore();
        this.zzbu.disconnect();
    }

    public final <T> T zza(Class<T> cls) throws IOException {
        int i = this.statusCode;
        boolean z = true;
        if (this.zzbw.getRequestMethod().equals(HttpRequest.METHOD_HEAD) || i / 100 == 1 || i == 204 || i == 304) {
            ignore();
            z = false;
        }
        if (!z) {
            return null;
        }
        return this.zzbw.zzaa().zza(getContent(), zzaf(), cls);
    }

    /* JADX INFO: finally extract failed */
    public final String zzae() throws IOException {
        InputStream content = getContent();
        if (content == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzdt.checkNotNull(content);
            zzdt.checkNotNull(byteArrayOutputStream);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    content.close();
                    return byteArrayOutputStream.toString(zzaf().name());
                }
            }
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    private final Charset zzaf() {
        zzy zzy = this.zzag;
        return (zzy == null || zzy.zzr() == null) ? zzbo.ISO_8859_1 : this.zzag.zzr();
    }
}
