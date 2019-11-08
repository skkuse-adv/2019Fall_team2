package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzbv extends zziq<zzbv> {
    private static volatile zzbv[] zzze;
    public Integer zzzf = null;
    public zzbk$zzd[] zzzg = new zzbk$zzd[0];
    public zzbk$zza[] zzzh = new zzbk$zza[0];
    private Boolean zzzi = null;
    private Boolean zzzj = null;

    public static zzbv[] zzqx() {
        if (zzze == null) {
            synchronized (zziu.zzaov) {
                if (zzze == null) {
                    zzze = new zzbv[0];
                }
            }
        }
        return zzze;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbv)) {
            return false;
        }
        zzbv zzbv = (zzbv) obj;
        Integer num = this.zzzf;
        if (num == null) {
            if (zzbv.zzzf != null) {
                return false;
            }
        } else if (!num.equals(zzbv.zzzf)) {
            return false;
        }
        if (!zziu.equals(this.zzzg, zzbv.zzzg) || !zziu.equals(this.zzzh, zzbv.zzzh)) {
            return false;
        }
        Boolean bool = this.zzzi;
        if (bool == null) {
            if (zzbv.zzzi != null) {
                return false;
            }
        } else if (!bool.equals(zzbv.zzzi)) {
            return false;
        }
        Boolean bool2 = this.zzzj;
        if (bool2 == null) {
            if (zzbv.zzzj != null) {
                return false;
            }
        } else if (!bool2.equals(zzbv.zzzj)) {
            return false;
        }
        zzis zzis = this.zzaoo;
        if (zzis != null && !zzis.isEmpty()) {
            return this.zzaoo.equals(zzbv.zzaoo);
        }
        zzis zzis2 = zzbv.zzaoo;
        return zzis2 == null || zzis2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzbv.class.getName().hashCode() + 527) * 31;
        Integer num = this.zzzf;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zziu.hashCode(this.zzzg)) * 31) + zziu.hashCode(this.zzzh)) * 31;
        Boolean bool = this.zzzi;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzzj;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        zzis zzis = this.zzaoo;
        if (zzis != null && !zzis.isEmpty()) {
            i = this.zzaoo.hashCode();
        }
        return hashCode4 + i;
    }

    public final void zza(zzio zzio) throws IOException {
        Integer num = this.zzzf;
        if (num != null) {
            zzio.zzc(1, num.intValue());
        }
        zzbk$zzd[] zzbk_zzdArr = this.zzzg;
        int i = 0;
        if (zzbk_zzdArr != null && zzbk_zzdArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzbk$zzd[] zzbk_zzdArr2 = this.zzzg;
                if (i2 >= zzbk_zzdArr2.length) {
                    break;
                }
                zzbk$zzd zzbk_zzd = zzbk_zzdArr2[i2];
                if (zzbk_zzd != null) {
                    zzio.zze(2, zzbk_zzd);
                }
                i2++;
            }
        }
        zzbk$zza[] zzbk_zzaArr = this.zzzh;
        if (zzbk_zzaArr != null && zzbk_zzaArr.length > 0) {
            while (true) {
                zzbk$zza[] zzbk_zzaArr2 = this.zzzh;
                if (i >= zzbk_zzaArr2.length) {
                    break;
                }
                zzbk$zza zzbk_zza = zzbk_zzaArr2[i];
                if (zzbk_zza != null) {
                    zzio.zze(3, zzbk_zza);
                }
                i++;
            }
        }
        Boolean bool = this.zzzi;
        if (bool != null) {
            zzio.zzb(4, bool.booleanValue());
        }
        Boolean bool2 = this.zzzj;
        if (bool2 != null) {
            zzio.zzb(5, bool2.booleanValue());
        }
        super.zza(zzio);
    }

    /* access modifiers changed from: protected */
    public final int zzqy() {
        int zzqy = super.zzqy();
        Integer num = this.zzzf;
        if (num != null) {
            zzqy += zzio.zzg(1, num.intValue());
        }
        zzbk$zzd[] zzbk_zzdArr = this.zzzg;
        int i = 0;
        if (zzbk_zzdArr != null && zzbk_zzdArr.length > 0) {
            int i2 = zzqy;
            int i3 = 0;
            while (true) {
                zzbk$zzd[] zzbk_zzdArr2 = this.zzzg;
                if (i3 >= zzbk_zzdArr2.length) {
                    break;
                }
                zzbk$zzd zzbk_zzd = zzbk_zzdArr2[i3];
                if (zzbk_zzd != null) {
                    i2 += zzee.zzc(2, (zzgi) zzbk_zzd);
                }
                i3++;
            }
            zzqy = i2;
        }
        zzbk$zza[] zzbk_zzaArr = this.zzzh;
        if (zzbk_zzaArr != null && zzbk_zzaArr.length > 0) {
            while (true) {
                zzbk$zza[] zzbk_zzaArr2 = this.zzzh;
                if (i >= zzbk_zzaArr2.length) {
                    break;
                }
                zzbk$zza zzbk_zza = zzbk_zzaArr2[i];
                if (zzbk_zza != null) {
                    zzqy += zzee.zzc(3, (zzgi) zzbk_zza);
                }
                i++;
            }
        }
        Boolean bool = this.zzzi;
        if (bool != null) {
            bool.booleanValue();
            zzqy += zzio.zzbi(4) + 1;
        }
        Boolean bool2 = this.zzzj;
        if (bool2 == null) {
            return zzqy;
        }
        bool2.booleanValue();
        return zzqy + zzio.zzbi(5) + 1;
    }

    public final /* synthetic */ zziw zza(zzil zzil) throws IOException {
        while (true) {
            int zzsg = zzil.zzsg();
            if (zzsg == 0) {
                return this;
            }
            if (zzsg == 8) {
                this.zzzf = Integer.valueOf(zzil.zzta());
            } else if (zzsg == 18) {
                int zzb = zzix.zzb(zzil, 18);
                zzbk$zzd[] zzbk_zzdArr = this.zzzg;
                int length = zzbk_zzdArr == null ? 0 : zzbk_zzdArr.length;
                zzbk$zzd[] zzbk_zzdArr2 = new zzbk$zzd[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzzg, 0, zzbk_zzdArr2, 0, length);
                }
                while (length < zzbk_zzdArr2.length - 1) {
                    zzbk_zzdArr2[length] = (zzbk$zzd) zzil.zza(zzbk$zzd.zzkj());
                    zzil.zzsg();
                    length++;
                }
                zzbk_zzdArr2[length] = (zzbk$zzd) zzil.zza(zzbk$zzd.zzkj());
                this.zzzg = zzbk_zzdArr2;
            } else if (zzsg == 26) {
                int zzb2 = zzix.zzb(zzil, 26);
                zzbk$zza[] zzbk_zzaArr = this.zzzh;
                int length2 = zzbk_zzaArr == null ? 0 : zzbk_zzaArr.length;
                zzbk$zza[] zzbk_zzaArr2 = new zzbk$zza[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzzh, 0, zzbk_zzaArr2, 0, length2);
                }
                while (length2 < zzbk_zzaArr2.length - 1) {
                    zzbk_zzaArr2[length2] = (zzbk$zza) zzil.zza(zzbk$zza.zzkj());
                    zzil.zzsg();
                    length2++;
                }
                zzbk_zzaArr2[length2] = (zzbk$zza) zzil.zza(zzbk$zza.zzkj());
                this.zzzh = zzbk_zzaArr2;
            } else if (zzsg == 32) {
                this.zzzi = Boolean.valueOf(zzil.zzsm());
            } else if (zzsg == 40) {
                this.zzzj = Boolean.valueOf(zzil.zzsm());
            } else if (!super.zza(zzil, zzsg)) {
                return this;
            }
        }
    }
}
