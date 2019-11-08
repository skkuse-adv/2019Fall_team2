package com.google.firebase.perf.internal;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import com.google.android.gms.internal.firebase-perf.zzbt;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Keep
public class SessionManager extends zzb {
    @SuppressLint({"StaticFieldLeak"})
    private static final SessionManager zzfi = new SessionManager();
    private final GaugeManager zzbl;
    private final zza zzcx;
    private final Set<WeakReference<zzz>> zzfj;
    private zzq zzfk;

    public static SessionManager zzcf() {
        return zzfi;
    }

    public final zzq zzcg() {
        return this.zzfk;
    }

    private SessionManager() {
        this(GaugeManager.zzbf(), zzq.zzbm(), zza.zzaj());
    }

    private SessionManager(GaugeManager gaugeManager, zzq zzq, zza zza) {
        this.zzfj = new HashSet();
        this.zzbl = gaugeManager;
        this.zzfk = zzq;
        this.zzcx = zza;
        zzay();
    }

    public final void zza(zzbt zzbt) {
        super.zza(zzbt);
        if (!this.zzcx.zzak()) {
            if (zzbt == zzbt.FOREGROUND) {
                zzc(zzbt);
                return;
            }
            if (!zzch()) {
                zzd(zzbt);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzch() {
        if (!this.zzfk.isExpired()) {
            return false;
        }
        zzc(this.zzcx.zzal());
        return true;
    }

    public final void zzc(zzbt zzbt) {
        this.zzfk = zzq.zzbm();
        synchronized (this.zzfj) {
            Iterator it = this.zzfj.iterator();
            while (it.hasNext()) {
                zzz zzz = (zzz) ((WeakReference) it.next()).get();
                if (zzz != null) {
                    zzz.zza(this.zzfk);
                } else {
                    it.remove();
                }
            }
        }
        if (this.zzfk.zzbo()) {
            this.zzbl.zzc(this.zzfk.zzbn(), zzbt);
        }
        zzd(zzbt);
    }

    public final void zzc(WeakReference<zzz> weakReference) {
        synchronized (this.zzfj) {
            this.zzfj.add(weakReference);
        }
    }

    public final void zzd(WeakReference<zzz> weakReference) {
        synchronized (this.zzfj) {
            this.zzfj.remove(weakReference);
        }
    }

    private final void zzd(zzbt zzbt) {
        if (this.zzfk.zzbo()) {
            this.zzbl.zza(this.zzfk.zzbn(), zzbt);
        } else {
            this.zzbl.zzbg();
        }
    }
}
