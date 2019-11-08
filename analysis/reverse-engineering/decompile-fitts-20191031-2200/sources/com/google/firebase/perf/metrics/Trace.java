package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase-perf.zzax;
import com.google.android.gms.internal.firebase-perf.zzaz;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.internal.zza;
import com.google.firebase.perf.internal.zzb;
import com.google.firebase.perf.internal.zzc;
import com.google.firebase.perf.internal.zzq;
import com.google.firebase.perf.internal.zzr;
import com.google.firebase.perf.internal.zzz;
import java.lang.ref.WeakReference;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Trace extends zzb implements Parcelable, zzz {
    @Keep
    public static final Creator<Trace> CREATOR = new zzc();
    private final String name;
    private final List<zzq> zzbk;
    private final GaugeManager zzbl;
    private final WeakReference<zzz> zzbq;
    private final zzc zzcn;
    private final Trace zzgc;
    private final List<Trace> zzgd;
    private final Map<String, zza> zzge;
    private final Map<String, String> zzgg;
    private zzbg zzgh;
    private zzbg zzgi;

    @Keep
    public int describeContents() {
        return 0;
    }

    public final void zza(zzq zzq) {
        if (hasStarted() && !isStopped()) {
            this.zzbk.add(zzq);
        }
    }

    @NonNull
    public static Trace zzi(@NonNull String str) {
        return new Trace(str);
    }

    private Trace(@NonNull String str) {
        this(str, zzc.zzba(), new zzax(), zza.zzaj(), GaugeManager.zzbf());
    }

    public Trace(@NonNull String str, @NonNull zzc zzc, @NonNull zzax zzax, @NonNull zza zza) {
        this(str, zzc, zzax, zza, GaugeManager.zzbf());
    }

    private Trace(@NonNull String str, @NonNull zzc zzc, @NonNull zzax zzax, @NonNull zza zza, @NonNull GaugeManager gaugeManager) {
        super(zza);
        this.zzbq = new WeakReference<>(this);
        this.zzgc = null;
        this.name = str.trim();
        this.zzgd = new ArrayList();
        this.zzge = new ConcurrentHashMap();
        this.zzgg = new ConcurrentHashMap();
        this.zzcn = zzc;
        this.zzbk = new ArrayList();
        this.zzbl = gaugeManager;
    }

    @Keep
    public void start() {
        String str;
        String str2 = this.name;
        if (str2 == null) {
            str = "Trace name must not be null";
        } else if (str2.length() > 100) {
            str = String.format(Locale.US, "Trace name must not exceed %d characters", new Object[]{Integer.valueOf(100)});
        } else {
            if (str2.startsWith("_")) {
                zzaz[] values = zzaz.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (values[i].toString().equals(str2)) {
                            break;
                        }
                        i++;
                    } else if (!str2.startsWith("_st_")) {
                        str = "Trace name must not start with '_'";
                    }
                }
            }
            str = null;
        }
        if (str != null) {
            String.format("Cannot start trace %s. Trace name is invalid.(%s)", new Object[]{this.name, str});
        } else if (this.zzgh != null) {
            String.format("Trace '%s' has already started, should not start again!", new Object[]{this.name});
        } else {
            zzay();
            zzq zzcg = SessionManager.zzcf().zzcg();
            SessionManager.zzcf().zzc(this.zzbq);
            this.zzbk.add(zzcg);
            this.zzgh = new zzbg();
            String.format("Session ID - %s", new Object[]{zzcg.zzbn()});
            if (zzcg.zzbo()) {
                this.zzbl.zzbh();
            }
        }
    }

    @Keep
    public void stop() {
        if (!hasStarted()) {
            String.format("Trace '%s' has not been started so unable to stop!", new Object[]{this.name});
        } else if (isStopped()) {
            String.format("Trace '%s' has already stopped, should not stop again!", new Object[]{this.name});
        } else {
            SessionManager.zzcf().zzd(this.zzbq);
            zzaz();
            this.zzgi = new zzbg();
            if (this.zzgc == null) {
                zzbg zzbg = this.zzgi;
                if (!this.zzgd.isEmpty()) {
                    Trace trace = (Trace) this.zzgd.get(this.zzgd.size() - 1);
                    if (trace.zzgi == null) {
                        trace.zzgi = zzbg;
                    }
                }
                if (!this.name.isEmpty()) {
                    zzc zzc = this.zzcn;
                    if (zzc != null) {
                        zzc.zza(new zzd(this).zzco(), zzal());
                        if (SessionManager.zzcf().zzcg().zzbo()) {
                            this.zzbl.zzbh();
                        }
                    }
                }
            }
        }
    }

    @NonNull
    private final zza zzj(@NonNull String str) {
        zza zza = (zza) this.zzge.get(str);
        if (zza != null) {
            return zza;
        }
        zza zza2 = new zza(str);
        this.zzge.put(str, zza2);
        return zza2;
    }

    @Keep
    public void incrementMetric(@NonNull String str, long j) {
        String zzf = zzr.zzf(str);
        if (zzf != null) {
            String.format("Cannot increment metric %s. Metric name is invalid.(%s)", new Object[]{str, zzf});
        } else if (!hasStarted()) {
            String.format("Cannot increment metric '%s' for trace '%s' because it's not started", new Object[]{str, this.name});
        } else if (isStopped()) {
            String.format("Cannot increment metric '%s' for trace '%s' because it's been stopped", new Object[]{str, this.name});
        } else {
            zzj(str.trim()).zzn(j);
        }
    }

    @Keep
    public long getLongMetric(@NonNull String str) {
        zza zza = str != null ? (zza) this.zzge.get(str.trim()) : null;
        if (zza == null) {
            return 0;
        }
        return zza.getCount();
    }

    @Keep
    public void putMetric(@NonNull String str, long j) {
        String zzf = zzr.zzf(str);
        if (zzf != null) {
            String.format("Cannot set value for metric %s. Metric name is invalid.(%s)", new Object[]{str, zzf});
        } else if (!hasStarted()) {
            String.format("Cannot set value for metric '%s' for trace '%s' because it's not started", new Object[]{str, this.name});
        } else if (isStopped()) {
            String.format("Cannot set value for metric '%s' for trace '%s' because it's been stopped", new Object[]{str, this.name});
        } else {
            zzj(str.trim()).zzo(j);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (hasStarted() && !isStopped()) {
                String.format("Trace '%s' is started but not stopped when it is destructed!", new Object[]{this.name});
                zzc(1);
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public final String getName() {
        return this.name;
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public final Map<String, zza> zzck() {
        return this.zzge;
    }

    /* access modifiers changed from: 0000 */
    public final zzbg zzcl() {
        return this.zzgh;
    }

    /* access modifiers changed from: 0000 */
    public final zzbg zzcm() {
        return this.zzgi;
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public final List<Trace> zzcn() {
        return this.zzgd;
    }

    private final boolean isStopped() {
        return this.zzgi != null;
    }

    private final boolean hasStarted() {
        return this.zzgh != null;
    }

    @Keep
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.zzgc, 0);
        parcel.writeString(this.name);
        parcel.writeList(this.zzgd);
        parcel.writeMap(this.zzge);
        parcel.writeParcelable(this.zzgh, 0);
        parcel.writeParcelable(this.zzgi, 0);
        parcel.writeList(this.zzbk);
    }

    private Trace(@NonNull Parcel parcel, boolean z) {
        super(z ? null : zza.zzaj());
        this.zzbq = new WeakReference<>(this);
        this.zzgc = (Trace) parcel.readParcelable(Trace.class.getClassLoader());
        this.name = parcel.readString();
        this.zzgd = new ArrayList();
        parcel.readList(this.zzgd, Trace.class.getClassLoader());
        this.zzge = new ConcurrentHashMap();
        this.zzgg = new ConcurrentHashMap();
        parcel.readMap(this.zzge, zza.class.getClassLoader());
        this.zzgh = (zzbg) parcel.readParcelable(zzbg.class.getClassLoader());
        this.zzgi = (zzbg) parcel.readParcelable(zzbg.class.getClassLoader());
        this.zzbk = new ArrayList();
        parcel.readList(this.zzbk, zzq.class.getClassLoader());
        if (z) {
            this.zzcn = null;
            this.zzbl = null;
            return;
        }
        this.zzcn = zzc.zzba();
        new zzax();
        this.zzbl = GaugeManager.zzbf();
    }

    @Keep
    public void putAttribute(@NonNull String str, @NonNull String str2) {
        boolean z = false;
        try {
            str = str.trim();
            str2 = str2.trim();
            if (!isStopped()) {
                if (!this.zzgg.containsKey(str)) {
                    if (this.zzgg.size() >= 5) {
                        throw new IllegalArgumentException(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", new Object[]{Integer.valueOf(5)}));
                    }
                }
                String zza = zzr.zza(new SimpleEntry(str, str2));
                if (zza == null) {
                    z = true;
                    if (z) {
                        this.zzgg.put(str, str2);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(zza);
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Trace %s has been stopped", new Object[]{this.name}));
        } catch (Exception e) {
            String.format("Can not set attribute %s with value %s (%s)", new Object[]{str, str2, e.getMessage()});
        }
    }

    @Keep
    public void removeAttribute(@NonNull String str) {
        if (!isStopped()) {
            this.zzgg.remove(str);
        }
    }

    @Keep
    @Nullable
    public String getAttribute(@NonNull String str) {
        return (String) this.zzgg.get(str);
    }

    @NonNull
    @Keep
    public Map<String, String> getAttributes() {
        return new HashMap(this.zzgg);
    }

    /* access modifiers changed from: 0000 */
    public final List<zzq> getSessions() {
        return this.zzbk;
    }

    /* synthetic */ Trace(Parcel parcel, boolean z, zzc zzc) {
        this(parcel, z);
    }

    static {
        new ConcurrentHashMap();
        new zze();
    }
}
