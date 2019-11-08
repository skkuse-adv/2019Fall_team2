package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.nio.charset.Charset;

public abstract class zzp implements zzs {
    private zzy zzag;
    private long zzah;

    protected zzp(String str) {
        this(str == null ? null : new zzy(str));
    }

    public final boolean zzn() {
        return true;
    }

    private zzp(zzy zzy) {
        this.zzah = -1;
        this.zzag = zzy;
    }

    public final long getLength() throws IOException {
        if (this.zzah == -1) {
            this.zzah = zzca.zzb(this);
        }
        return this.zzah;
    }

    /* access modifiers changed from: protected */
    public final Charset zzo() {
        zzy zzy = this.zzag;
        return (zzy == null || zzy.zzr() == null) ? zzbo.UTF_8 : this.zzag.zzr();
    }

    public final String getType() {
        zzy zzy = this.zzag;
        if (zzy == null) {
            return null;
        }
        return zzy.zzp();
    }
}
