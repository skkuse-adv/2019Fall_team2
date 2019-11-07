package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzay implements zzci {
    private final zzaw zzda;
    private final Set<String> zzdc;

    protected zzay(zzbb zzbb) {
        this.zzda = zzbb.zzda;
        this.zzdc = new HashSet(zzbb.zzdf);
    }

    public final <T> T zza(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        zzba zza = this.zzda.zza(inputStream, charset);
        if (!this.zzdc.isEmpty()) {
            try {
                String str = "wrapper key(s) not found: %s";
                Object[] objArr = {this.zzdc};
                if (!((zza.zza(this.zzdc) == null || zza.zzba() == zzbg.zzdk) ? false : true)) {
                    throw new IllegalArgumentException(zzdy.zza(str, objArr));
                }
            } catch (Throwable th) {
                zza.close();
                throw th;
            }
        }
        return zza.zza(cls, true, null);
    }

    public final zzaw zzl() {
        return this.zzda;
    }

    public final Set<String> zzar() {
        return Collections.unmodifiableSet(this.zzdc);
    }
}
