package com.google.android.gms.internal.firebase_remote_config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;

public final class zzbf extends zzaw {
    public static zzbf zzbq() {
        return zzbi.zzdw;
    }

    public final zzba zza(InputStream inputStream) {
        return zza((Reader) new InputStreamReader(inputStream, zzbo.UTF_8));
    }

    public final zzba zza(InputStream inputStream, Charset charset) {
        if (charset == null) {
            return zza(inputStream);
        }
        return zza((Reader) new InputStreamReader(inputStream, charset));
    }

    public final zzba zzac(String str) {
        return zza((Reader) new StringReader(str));
    }

    private final zzba zza(Reader reader) {
        return new zzbk(this, new zzfj(reader));
    }

    public final zzaz zza(OutputStream outputStream, Charset charset) {
        return new zzbh(this, new zzfo(new OutputStreamWriter(outputStream, charset)));
    }
}
