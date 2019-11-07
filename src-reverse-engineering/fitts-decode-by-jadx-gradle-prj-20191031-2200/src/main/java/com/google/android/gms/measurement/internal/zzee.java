package com.google.android.gms.measurement.internal;

import androidx.exifinterface.media.ExifInterface;

final class zzee implements Runnable {
    private final /* synthetic */ int zzka;
    private final /* synthetic */ String zzkb;
    private final /* synthetic */ Object zzkc;
    private final /* synthetic */ Object zzkd;
    private final /* synthetic */ Object zzke;
    private final /* synthetic */ zzef zzkf;

    zzee(zzef zzef, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzkf = zzef;
        this.zzka = i;
        this.zzkb = str;
        this.zzkc = obj;
        this.zzkd = obj2;
        this.zzke = obj3;
    }

    public final void run() {
        zzeo zzac = this.zzkf.zzj.zzac();
        if (zzac.isInitialized()) {
            if (this.zzkf.zzkg == 0) {
                if (this.zzkf.zzad().zzbn()) {
                    zzef zzef = this.zzkf;
                    zzef.zzae();
                    zzef.zzkg = 'C';
                } else {
                    zzef zzef2 = this.zzkf;
                    zzef2.zzae();
                    zzef2.zzkg = 'c';
                }
            }
            if (this.zzkf.zzr < 0) {
                zzef zzef3 = this.zzkf;
                zzef3.zzr = zzef3.zzad().zzao();
            }
            char charAt = "01VDIWEA?".charAt(this.zzka);
            char zza = this.zzkf.zzkg;
            long zzb = this.zzkf.zzr;
            String zza2 = zzef.zza(true, this.zzkb, this.zzkc, this.zzkd, this.zzke);
            StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 24);
            sb.append(ExifInterface.GPS_MEASUREMENT_2D);
            sb.append(charAt);
            sb.append(zza);
            sb.append(zzb);
            sb.append(":");
            sb.append(zza2);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.zzkb.substring(0, 1024);
            }
            zzac.zzli.zzc(sb2, 1);
            return;
        }
        this.zzkf.zza(6, "Persisted config not initialized. Not logging error/warn");
    }
}
