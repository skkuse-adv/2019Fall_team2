package com.google.android.gms.internal.firebase-perf;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase-perf.zzci.zza;
import com.google.android.gms.internal.firebase-perf.zzci.zzd;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.internal.zzb;
import com.google.firebase.perf.internal.zzc;
import com.google.firebase.perf.internal.zzq;
import com.google.firebase.perf.internal.zzz;
import com.gun0912.tedpermission.TedPermissionBase;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;

public final class zzau extends zzb implements zzz {
    private final List<zzq> zzbk;
    private final GaugeManager zzbl;
    private zzc zzbm;
    private final zza zzbn;
    private boolean zzbo;
    private boolean zzbp;
    private final WeakReference<zzz> zzbq;

    public final void zza(zzq zzq) {
        if (this.zzbn.zzek() && !this.zzbn.zzeq()) {
            this.zzbk.add(zzq);
        }
    }

    public static zzau zza(@Nullable zzc zzc) {
        return new zzau(zzc);
    }

    private zzau(@Nullable zzc zzc) {
        this(zzc, com.google.firebase.perf.internal.zza.zzaj(), GaugeManager.zzbf());
    }

    private zzau(@Nullable zzc zzc, com.google.firebase.perf.internal.zza zza, GaugeManager gaugeManager) {
        super(zza);
        this.zzbn = zzci.zzeu();
        this.zzbq = new WeakReference<>(this);
        this.zzbm = zzc;
        this.zzbl = gaugeManager;
        this.zzbk = new ArrayList();
        zzay();
    }

    public final void zzae() {
        this.zzbp = true;
    }

    public final zzau zza(@Nullable String str) {
        if (str != null) {
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                Builder newBuilder = parse.newBuilder();
                String str2 = "";
                str = newBuilder.username(str2).password(str2).query(null).fragment(null).toString();
            }
            zza zza = this.zzbn;
            if (str.length() > 2000) {
                if (str.charAt(TedPermissionBase.REQ_CODE_REQUEST_SETTING) != '/') {
                    HttpUrl parse2 = HttpUrl.parse(str);
                    if (parse2 != null && parse2.encodedPath().lastIndexOf(47) >= 0) {
                        int lastIndexOf = str.lastIndexOf(47, 1999);
                        if (lastIndexOf >= 0) {
                            str = str.substring(0, lastIndexOf);
                        }
                    }
                }
                str = str.substring(0, TedPermissionBase.REQ_CODE_REQUEST_SETTING);
            }
            zza.zzaa(str);
        }
        return this;
    }

    public final zzau zzb(@Nullable String str) {
        zzci.zzb zzb;
        if (str != null) {
            String upperCase = str.toUpperCase();
            char c = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals(HttpRequest.METHOD_OPTIONS)) {
                        c = 6;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals(HttpRequest.METHOD_GET)) {
                        c = 0;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals(HttpRequest.METHOD_PUT)) {
                        c = 1;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals(HttpRequest.METHOD_HEAD)) {
                        c = 4;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals(HttpRequest.METHOD_POST)) {
                        c = 2;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals("PATCH")) {
                        c = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals(HttpRequest.METHOD_TRACE)) {
                        c = 7;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals("CONNECT")) {
                        c = 8;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals(HttpRequest.METHOD_DELETE)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    zzb = zzci.zzb.GET;
                    break;
                case 1:
                    zzb = zzci.zzb.PUT;
                    break;
                case 2:
                    zzb = zzci.zzb.POST;
                    break;
                case 3:
                    zzb = zzci.zzb.DELETE;
                    break;
                case 4:
                    zzb = zzci.zzb.HEAD;
                    break;
                case 5:
                    zzb = zzci.zzb.PATCH;
                    break;
                case 6:
                    zzb = zzci.zzb.OPTIONS;
                    break;
                case 7:
                    zzb = zzci.zzb.TRACE;
                    break;
                case 8:
                    zzb = zzci.zzb.CONNECT;
                    break;
                default:
                    zzb = zzci.zzb.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.zzbn.zzb(zzb);
        }
        return this;
    }

    public final zzau zzb(int i) {
        this.zzbn.zzl(i);
        return this;
    }

    public final boolean zzaf() {
        return this.zzbn.zzaf();
    }

    public final zzau zzf(long j) {
        this.zzbn.zzad(j);
        return this;
    }

    public final zzau zzb(Map<String, String> map) {
        this.zzbn.zzey().zzd(map);
        return this;
    }

    public final zzau zzg(long j) {
        zzq zzcg = SessionManager.zzcf().zzcg();
        SessionManager.zzcf().zzc(this.zzbq);
        this.zzbn.zzaf(j);
        this.zzbk.add(zzcg);
        if (zzcg.zzbo()) {
            this.zzbl.zzbh();
        }
        return this;
    }

    public final zzau zzh(long j) {
        this.zzbn.zzag(j);
        return this;
    }

    public final zzau zzi(long j) {
        this.zzbn.zzah(j);
        return this;
    }

    public final long zzag() {
        return this.zzbn.zzep();
    }

    public final zzau zzj(long j) {
        this.zzbn.zzai(j);
        if (SessionManager.zzcf().zzcg().zzbo()) {
            this.zzbl.zzbh();
        }
        return this;
    }

    public final zzau zzk(long j) {
        this.zzbn.zzae(j);
        return this;
    }

    public final zzau zzc(@Nullable String str) {
        if (str == null) {
            this.zzbn.zzex();
            return this;
        }
        boolean z = false;
        if (str.length() <= 128) {
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt > 127) {
                    break;
                }
                i++;
            }
        }
        if (z) {
            this.zzbn.zzab(str);
        } else {
            String str2 = "The content type of the response is not a valid content-type:";
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                new String(str2);
            }
        }
        return this;
    }

    public final zzau zzah() {
        this.zzbn.zzb(zzd.GENERIC_CLIENT_ERROR);
        return this;
    }

    public final zzci zzai() {
        SessionManager.zzcf().zzd(this.zzbq);
        zzaz();
        zzcr[] zza = zzq.zza(this.zzbk);
        if (zza != null) {
            this.zzbn.zzc(Arrays.asList(zza));
        }
        zzci zzci = (zzci) this.zzbn.zzhi();
        if (!this.zzbo) {
            zzc zzc = this.zzbm;
            if (zzc != null) {
                zzc.zza(zzci, zzal());
            }
            this.zzbo = true;
        } else {
            boolean z = this.zzbp;
        }
        return zzci;
    }
}
