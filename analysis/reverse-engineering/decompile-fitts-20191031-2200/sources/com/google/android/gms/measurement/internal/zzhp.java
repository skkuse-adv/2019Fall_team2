package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbs$zzf;
import com.google.android.gms.internal.measurement.zzbs$zzg;
import com.google.android.gms.internal.measurement.zzbs$zzg.zza;

final class zzhp extends zzjh {
    public zzhp(zzjg zzjg) {
        super(zzjg);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    @WorkerThread
    public final byte[] zzb(@NonNull zzai zzai, @Size(min = 1) String str) {
        zzo();
        this.zzj.zzl();
        Preconditions.checkNotNull(zzai);
        Preconditions.checkNotEmpty(str);
        if (!zzad().zze(str, zzak.zzio)) {
            zzab().zzgr().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzai.name)) {
            if (!"_iapx".equals(zzai.name)) {
                zzab().zzgr().zza("Generating a payload for this event is not available. package_name, event_name", str, zzai.name);
                return null;
            }
        }
        zzbs$zzf.zznj();
        zzgy().beginTransaction();
        try {
            zzf zzab = zzgy().zzab(str);
            if (zzab == null) {
                zzab().zzgr().zza("Log and bundle not available. package_name", str);
                return new byte[0];
            } else if (!zzab.isMeasurementEnabled()) {
                zzab().zzgr().zza("Log and bundle disabled. package_name", str);
                byte[] bArr = new byte[0];
                zzgy().endTransaction();
                return bArr;
            } else {
                zza zzcc = zzbs$zzg.zzpr().zzp(1).zzcc("android");
                if (!TextUtils.isEmpty(zzab.zzag())) {
                    zzcc.zzch(zzab.zzag());
                }
                if (!TextUtils.isEmpty(zzab.zzan())) {
                    zzcc.zzcg(zzab.zzan());
                }
                if (!TextUtils.isEmpty(zzab.zzal())) {
                    zzcc.zzci(zzab.zzal());
                }
                if (zzab.zzam() != -2147483648L) {
                    zzcc.zzv((int) zzab.zzam());
                }
                zzcc.zzas(zzab.zzao()).zzax(zzab.zzaq());
                if (!TextUtils.isEmpty(zzab.getGmpAppId())) {
                    zzcc.zzcm(zzab.getGmpAppId());
                } else if (!TextUtils.isEmpty(zzab.zzah())) {
                    zzcc.zzcq(zzab.zzah());
                }
                zzcc.zzau(zzab.zzap());
                if (this.zzj.isEnabled() && zzs.zzbv() && zzad().zzl(zzcc.zzag())) {
                    zzcc.zzag();
                    if (!TextUtils.isEmpty(null)) {
                        zzcc.zzcp(null);
                    }
                }
                Pair zzap = zzac().zzap(zzab.zzag());
                if (!zzab.zzbe() || zzap == null || TextUtils.isEmpty((CharSequence) zzap.first)) {
                    zzw().zzbi();
                    zza zzce = zzcc.zzce(Build.MODEL);
                    zzw().zzbi();
                    zzce.zzcd(VERSION.RELEASE).zzt((int) zzw().zzcq()).zzcf(zzw().zzcr());
                    try {
                        zzo(zzab.getAppInstanceId(), Long.toString(zzai.zzfu));
                        throw null;
                    } catch (SecurityException e) {
                        zzab().zzgr().zza("app instance id encryption failed", e.getMessage());
                        byte[] bArr2 = new byte[0];
                        zzgy().endTransaction();
                        return bArr2;
                    }
                } else {
                    zzo((String) zzap.first, Long.toString(zzai.zzfu));
                    throw null;
                }
            }
        } catch (SecurityException e2) {
            zzab().zzgr().zza("Resettable device id encryption failed", e2.getMessage());
            return new byte[0];
        } finally {
            zzgy().endTransaction();
        }
    }

    private static String zzo(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
