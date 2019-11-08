package com.google.android.gms.internal.firebase_remote_config;

public final class zzdd extends zzax {
    @zzcc
    private String experimentId;
    @zzcc
    private String experimentStartTime;
    @zzbe
    @zzcc
    private Long timeToLiveMillis;
    @zzcc
    private String triggerEvent;
    @zzbe
    @zzcc
    private Long triggerTimeoutMillis;
    @zzcc
    private String variantId;

    public final zzdd zzan(String str) {
        this.experimentId = str;
        return this;
    }

    public final zzdd zzao(String str) {
        this.experimentStartTime = str;
        return this;
    }

    public final zzdd zza(Long l) {
        this.timeToLiveMillis = l;
        return this;
    }

    public final zzdd zzap(String str) {
        this.triggerEvent = str;
        return this;
    }

    public final zzdd zzb(Long l) {
        this.triggerTimeoutMillis = l;
        return this;
    }

    public final zzdd zzaq(String str) {
        this.variantId = str;
        return this;
    }

    public final /* synthetic */ zzax zza(String str, Object obj) {
        return (zzdd) zzb(str, obj);
    }

    public final /* synthetic */ zzax zza() {
        return (zzdd) clone();
    }

    public final /* synthetic */ zzby zzb() {
        return (zzdd) clone();
    }

    public final /* synthetic */ zzby zzb(String str, Object obj) {
        return (zzdd) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzdd) super.clone();
    }
}
