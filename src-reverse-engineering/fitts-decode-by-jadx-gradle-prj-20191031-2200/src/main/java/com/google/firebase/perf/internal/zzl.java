package com.google.firebase.perf.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase-perf.zzbi;
import com.google.android.gms.internal.firebase-perf.zzci;
import com.google.android.gms.internal.firebase-perf.zzci.zzb;
import java.net.URI;

final class zzl extends zzr {
    private final Context zzcs;
    private final zzci zzdj;

    zzl(@NonNull zzci zzci, Context context) {
        this.zzcs = context;
        this.zzdj = zzci;
    }

    private static boolean zzl(long j) {
        return j >= 0;
    }

    private static boolean zzm(long j) {
        return j >= 0;
    }

    public final boolean zzbe() {
        boolean z;
        if (zze(this.zzdj.getUrl())) {
            String str = "URL is missing:";
            String valueOf = String.valueOf(this.zzdj.getUrl());
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                new String(str);
            }
            return false;
        }
        URI zzd = zzd(this.zzdj.getUrl());
        if (zzd == null) {
            return false;
        }
        Context context = this.zzcs;
        if (zzd == null) {
            z = false;
        } else {
            z = zzbi.zza(zzd, context);
        }
        if (!z) {
            String valueOf2 = String.valueOf(zzd);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 26);
            sb.append("URL fails whitelist rule: ");
            sb.append(valueOf2);
            sb.toString();
            return false;
        }
        String host = zzd.getHost();
        if (!(host != null && !zze(host) && host.length() <= 255)) {
            return false;
        }
        String scheme = zzd.getScheme();
        if (!(scheme != null && ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)))) {
            return false;
        }
        if (!(zzd.getUserInfo() == null)) {
            return false;
        }
        int port = zzd.getPort();
        if (!(port == -1 || port > 0)) {
            return false;
        }
        zzb zzed = this.zzdj.zzec() ? this.zzdj.zzed() : null;
        if (!((zzed == null || zzed == zzb.HTTP_METHOD_UNKNOWN) ? false : true)) {
            String valueOf3 = String.valueOf(this.zzdj.zzed());
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 32);
            sb2.append("HTTP Method is null or invalid: ");
            sb2.append(valueOf3);
            sb2.toString();
            return false;
        }
        if (this.zzdj.zzaf()) {
            if (!(this.zzdj.zzei() > 0)) {
                int zzei = this.zzdj.zzei();
                StringBuilder sb3 = new StringBuilder(49);
                sb3.append("HTTP ResponseCode is a negative value:");
                sb3.append(zzei);
                sb3.toString();
                return false;
            }
        }
        if (this.zzdj.zzee() && !zzm(this.zzdj.zzef())) {
            long zzef = this.zzdj.zzef();
            StringBuilder sb4 = new StringBuilder(56);
            sb4.append("Request Payload is a negative value:");
            sb4.append(zzef);
            sb4.toString();
            return false;
        } else if (this.zzdj.zzeg() && !zzm(this.zzdj.zzeh())) {
            long zzeh = this.zzdj.zzeh();
            StringBuilder sb5 = new StringBuilder(57);
            sb5.append("Response Payload is a negative value:");
            sb5.append(zzeh);
            sb5.toString();
            return false;
        } else if (!this.zzdj.zzek() || this.zzdj.zzel() <= 0) {
            long zzel = this.zzdj.zzel();
            StringBuilder sb6 = new StringBuilder(84);
            sb6.append("Start time of the request is null, or zero, or a negative value:");
            sb6.append(zzel);
            sb6.toString();
            return false;
        } else if (this.zzdj.zzem() && !zzl(this.zzdj.zzen())) {
            long zzen = this.zzdj.zzen();
            StringBuilder sb7 = new StringBuilder(69);
            sb7.append("Time to complete the request is a negative value:");
            sb7.append(zzen);
            sb7.toString();
            return false;
        } else if (this.zzdj.zzeo() && !zzl(this.zzdj.zzep())) {
            long zzep = this.zzdj.zzep();
            StringBuilder sb8 = new StringBuilder(112);
            sb8.append("Time from the start of the request to the start of the response is null or a negative value:");
            sb8.append(zzep);
            sb8.toString();
            return false;
        } else if (!this.zzdj.zzeq() || this.zzdj.zzer() <= 0) {
            long zzer = this.zzdj.zzer();
            StringBuilder sb9 = new StringBuilder(108);
            sb9.append("Time from the start of the request to the end of the response is null, negative or zero:");
            sb9.append(zzer);
            sb9.toString();
            return false;
        } else if (!this.zzdj.zzaf()) {
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    private static URI zzd(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException unused) {
            return null;
        }
    }

    private static boolean zze(@Nullable String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }
}
