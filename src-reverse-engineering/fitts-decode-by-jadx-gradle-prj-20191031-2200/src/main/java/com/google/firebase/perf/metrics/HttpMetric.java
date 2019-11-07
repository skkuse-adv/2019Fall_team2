package com.google.firebase.perf.metrics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase-perf.zzau;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.firebase.perf.internal.zzc;
import com.google.firebase.perf.internal.zzr;
import java.net.URL;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpMetric {
    private zzau zzfx;
    private zzbg zzfy;
    private final Map<String, String> zzfz;
    private boolean zzga = false;

    public HttpMetric(String str, String str2, zzc zzc, zzbg zzbg) {
        this.zzfx = zzau.zza(zzc);
        this.zzfx.zza(str);
        this.zzfx.zzb(str2);
        this.zzfy = zzbg;
        this.zzfx.zzae();
        this.zzfz = new ConcurrentHashMap();
    }

    public HttpMetric(URL url, String str, zzc zzc, zzbg zzbg) {
        this.zzfx = zzau.zza(zzc);
        this.zzfx.zza(url.toString());
        this.zzfx.zzb(str);
        this.zzfy = zzbg;
        this.zzfx.zzae();
        this.zzfz = new ConcurrentHashMap();
    }

    public void setHttpResponseCode(int i) {
        this.zzfx.zzb(i);
    }

    public void setRequestPayloadSize(long j) {
        this.zzfx.zzf(j);
    }

    public void setResponsePayloadSize(long j) {
        this.zzfx.zzk(j);
    }

    public void setResponseContentType(@Nullable String str) {
        this.zzfx.zzc(str);
    }

    public void start() {
        this.zzfy.reset();
        this.zzfx.zzg(this.zzfy.zzcr());
    }

    public void stop() {
        this.zzfx.zzj(this.zzfy.zzcs());
        this.zzfx.zzb(this.zzfz);
        this.zzfx.zzai();
        this.zzga = true;
    }

    public void putAttribute(@NonNull String str, @NonNull String str2) {
        boolean z = false;
        try {
            str = str.trim();
            str2 = str2.trim();
            if (this.zzga) {
                throw new IllegalArgumentException("HttpMetric has been logged already so unable to modify attributes");
            } else if (str == null || str2 == null) {
                throw new IllegalArgumentException("Attribute must not have null key or value.");
            } else {
                if (!this.zzfz.containsKey(str)) {
                    if (this.zzfz.size() >= 5) {
                        throw new IllegalArgumentException(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", new Object[]{Integer.valueOf(5)}));
                    }
                }
                String zza = zzr.zza(new SimpleEntry(str, str2));
                if (zza == null) {
                    z = true;
                    if (z) {
                        this.zzfz.put(str, str2);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(zza);
            }
        } catch (Exception e) {
            String.format("Can not set attribute %s with value %s (%s)", new Object[]{str, str2, e.getMessage()});
        }
    }

    public void removeAttribute(@NonNull String str) {
        if (!this.zzga) {
            this.zzfz.remove(str);
        }
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        return (String) this.zzfz.get(str);
    }

    @NonNull
    public Map<String, String> getAttributes() {
        return new HashMap(this.zzfz);
    }
}
