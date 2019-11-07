package com.google.android.gms.internal.firebase_remote_config;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;

public class zzf<T> extends zzby {
    private final zzd zzo;
    private final String zzp;
    private final String zzq;
    private final zzs zzr;
    private zzw zzs = new zzw();
    private zzw zzt;
    private Class<T> zzw;

    protected zzf(zzd zzd, String str, String str2, zzs zzs2, Class<T> cls) {
        this.zzw = (Class) zzdt.checkNotNull(cls);
        this.zzo = (zzd) zzdt.checkNotNull(zzd);
        this.zzp = (String) zzdt.checkNotNull(str);
        this.zzq = (String) zzdt.checkNotNull(str2);
        this.zzr = zzs2;
        this.zzs.zzu("Google-API-Java-Client");
        this.zzs.zzb("X-Goog-Api-Client", zzg.zzj().zzf(zzd.getClass().getSimpleName()));
    }

    public zzd zzf() {
        return this.zzo;
    }

    public final zzw zzg() {
        return this.zzs;
    }

    public final zzw zzh() {
        return this.zzt;
    }

    /* access modifiers changed from: protected */
    public IOException zza(zzac zzac) {
        return new zzaf(zzac);
    }

    public final T zzi() throws IOException {
        zzab zza = zzf().zzd().zza(this.zzp, new zzt(zzal.zza(this.zzo.zzc(), this.zzq, (Object) this, true)), this.zzr);
        new zza().zzb(zza);
        zza.zza(zzf().zze());
        if (this.zzr == null && (this.zzp.equals(HttpRequest.METHOD_POST) || this.zzp.equals(HttpRequest.METHOD_PUT) || this.zzp.equals("PATCH"))) {
            zza.zza((zzs) new zzo());
        }
        zza.zzx().putAll(this.zzs);
        zza.zza((zzv) new zzr());
        zza.zza((zzah) new zzh(this, zza.zzz(), zza));
        zzac zzac = zza.zzac();
        this.zzt = zzac.zzx();
        zzac.getStatusCode();
        zzac.getStatusMessage();
        return zzac.zza(this.zzw);
    }

    /* renamed from: zzc */
    public zzf<T> zzb(String str, Object obj) {
        return (zzf) super.zzb(str, obj);
    }
}
