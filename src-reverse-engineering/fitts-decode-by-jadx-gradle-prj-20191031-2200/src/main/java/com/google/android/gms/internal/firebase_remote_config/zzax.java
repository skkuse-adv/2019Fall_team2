package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

public class zzax extends zzby implements Cloneable {
    private zzaw zzda;

    public final void zza(zzaw zzaw) {
        this.zzda = zzaw;
    }

    public String toString() {
        zzaw zzaw = this.zzda;
        if (zzaw == null) {
            return super.toString();
        }
        try {
            return zzaw.toString(this);
        } catch (IOException e) {
            throw zzeb.zzb(e);
        }
    }

    public final String zzaq() throws IOException {
        zzaw zzaw = this.zzda;
        if (zzaw != null) {
            return zzaw.zzc(this);
        }
        return super.toString();
    }

    /* renamed from: zza */
    public zzax clone() {
        return (zzax) super.clone();
    }

    /* renamed from: zza */
    public zzax zzb(String str, Object obj) {
        return (zzax) super.zzb(str, obj);
    }

    public /* synthetic */ zzby zzb() {
        return (zzax) clone();
    }
}
