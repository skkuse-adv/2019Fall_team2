package com.google.android.gms.internal.firebase_remote_config;

import io.fabric.sdk.android.services.network.HttpRequest;

public final class zzdc extends zzdb<zzdf> {
    @zzcc
    private String namespace;
    @zzcc
    private String project;

    protected zzdc(zzcz zzcz, String str, String str2, zzdg zzdg) {
        super(zzcz.zzgt.zzgu, HttpRequest.METHOD_POST, "v1/projects/{project}/namespaces/{namespace}:fetch", zzdg, zzdf.class);
        this.project = (String) zzch.checkNotNull(str, "Required parameter project must be specified.");
        this.namespace = (String) zzch.checkNotNull(str2, "Required parameter namespace must be specified.");
    }

    public final /* synthetic */ zzdb zzg(String str, Object obj) {
        return (zzdc) zzb(str, obj);
    }

    public final /* synthetic */ zzn zzd(String str, Object obj) {
        return (zzdc) zzb(str, obj);
    }

    public final /* synthetic */ zzf zzc(String str, Object obj) {
        return (zzdc) zzb(str, obj);
    }

    public final /* synthetic */ zzby zzb(String str, Object obj) {
        return (zzdc) super.zzb(str, obj);
    }
}
