package com.google.android.gms.internal.firebase_remote_config;

import java.util.List;
import java.util.Map;

public final class zzdf extends zzax {
    @zzcc
    private String appName;
    @zzcc
    private Map<String, String> entries;
    @zzcc
    private List<zzdd> experimentDescriptions;
    @zzcc
    private String state;

    public final Map<String, String> getEntries() {
        return this.entries;
    }

    public final List<zzdd> zzcf() {
        return this.experimentDescriptions;
    }

    public final String getState() {
        return this.state;
    }

    public final /* synthetic */ zzax zza(String str, Object obj) {
        return (zzdf) zzb(str, obj);
    }

    public final /* synthetic */ zzax zza() {
        return (zzdf) clone();
    }

    public final /* synthetic */ zzby zzb() {
        return (zzdf) clone();
    }

    public final /* synthetic */ zzby zzb(String str, Object obj) {
        return (zzdf) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzdf) super.clone();
    }
}
