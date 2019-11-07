package com.google.firebase.perf.internal;

import android.content.Context;
import android.provider.Settings.Secure;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.firebase-perf.zzax;
import com.google.android.gms.internal.firebase-perf.zzaz;
import com.google.android.gms.internal.firebase-perf.zzbk;
import com.google.android.gms.internal.firebase-perf.zzcn;
import com.google.android.gms.internal.firebase-perf.zzcr;
import com.google.android.gms.internal.firebase-perf.zzcv;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public final class zzs {
    private final RemoteConfigManager zzcg;
    private final long zzef;
    private boolean zzeg;
    private zzu zzeh;
    private zzu zzei;

    public zzs(@NonNull Context context, long j, long j2) {
        this(100, 500, new zzax(), zzg(Secure.getString(context.getContentResolver(), "android_id")), RemoteConfigManager.zzbz());
        this.zzeg = zzbk.zzg(context);
    }

    private zzs(long j, long j2, zzax zzax, long j3, RemoteConfigManager remoteConfigManager) {
        this.zzeg = false;
        this.zzeh = null;
        this.zzei = null;
        this.zzef = j3;
        this.zzcg = remoteConfigManager;
        zzax zzax2 = zzax;
        RemoteConfigManager remoteConfigManager2 = remoteConfigManager;
        zzu zzu = new zzu(100, 500, zzax2, remoteConfigManager2, zzv.TRACE, this.zzeg);
        this.zzeh = zzu;
        zzu zzu2 = new zzu(100, 500, zzax2, remoteConfigManager2, zzv.NETWORK, this.zzeg);
        this.zzei = zzu2;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzb(zzcn zzcn) {
        if (zzcn.zzfc()) {
            if (!(this.zzef <= ((long) (this.zzcg.zza("trace_sampling_rate", 100.0f) * 1000000.0f))) && !zzb(zzcn.zzfd().zzes())) {
                return false;
            }
        }
        if (zzcn.zzfe()) {
            if (!(this.zzef <= ((long) (this.zzcg.zza("network_sampling_rate", 100.0f) * 1000000.0f))) && !zzb(zzcn.zzff().zzes())) {
                return false;
            }
        }
        if (!((!zzcn.zzfc() || ((!zzcn.zzfd().getName().equals(zzaz.FOREGROUND_TRACE_NAME.toString()) && !zzcn.zzfd().getName().equals(zzaz.BACKGROUND_TRACE_NAME.toString())) || zzcn.zzfd().zzfn() <= 0)) && !zzcn.zzfg())) {
            return true;
        }
        if (zzcn.zzfe()) {
            return this.zzei.zzb(zzcn);
        }
        if (zzcn.zzfc()) {
            return this.zzeh.zzb(zzcn);
        }
        return false;
    }

    private static boolean zzb(List<zzcr> list) {
        if (list.size() <= 0 || ((zzcr) list.get(0)).zzfk() <= 0 || ((zzcr) list.get(0)).zzn(0) != zzcv.GAUGES_AND_SYSTEM_EVENTS) {
            return false;
        }
        return true;
    }

    private static long zzg(String str) {
        int i;
        try {
            i = zzbk.zza(MessageDigest.getInstance(CommonUtils.SHA1_INSTANCE).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            i = zzbk.zza(str.getBytes());
        }
        return (((((long) i) % 100000000) + 100000000) % 100000000) + 1;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(boolean z) {
        this.zzeh.zzb(z);
        this.zzei.zzb(z);
    }
}
