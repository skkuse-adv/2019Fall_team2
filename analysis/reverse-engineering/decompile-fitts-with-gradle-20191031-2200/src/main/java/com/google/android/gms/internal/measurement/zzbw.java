package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzbw extends zziq<zzbw> {
    public String zzcg = null;
    public Long zzzk = null;
    private Integer zzzl = null;
    public zzbq$zza[] zzzm = new zzbq$zza[0];
    public zzbx[] zzzn = zzbx.zzrc();
    public zzbv[] zzzo = zzbv.zzqx();
    private String zzzp = null;
    public Boolean zzzq = null;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbw)) {
            return false;
        }
        zzbw zzbw = (zzbw) obj;
        Long l = this.zzzk;
        if (l == null) {
            if (zzbw.zzzk != null) {
                return false;
            }
        } else if (!l.equals(zzbw.zzzk)) {
            return false;
        }
        String str = this.zzcg;
        if (str == null) {
            if (zzbw.zzcg != null) {
                return false;
            }
        } else if (!str.equals(zzbw.zzcg)) {
            return false;
        }
        Integer num = this.zzzl;
        if (num == null) {
            if (zzbw.zzzl != null) {
                return false;
            }
        } else if (!num.equals(zzbw.zzzl)) {
            return false;
        }
        if (!zziu.equals(this.zzzm, zzbw.zzzm) || !zziu.equals(this.zzzn, zzbw.zzzn) || !zziu.equals(this.zzzo, zzbw.zzzo)) {
            return false;
        }
        String str2 = this.zzzp;
        if (str2 == null) {
            if (zzbw.zzzp != null) {
                return false;
            }
        } else if (!str2.equals(zzbw.zzzp)) {
            return false;
        }
        Boolean bool = this.zzzq;
        if (bool == null) {
            if (zzbw.zzzq != null) {
                return false;
            }
        } else if (!bool.equals(zzbw.zzzq)) {
            return false;
        }
        zzis zzis = this.zzaoo;
        if (zzis != null && !zzis.isEmpty()) {
            return this.zzaoo.equals(zzbw.zzaoo);
        }
        zzis zzis2 = zzbw.zzaoo;
        return zzis2 == null || zzis2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzbw.class.getName().hashCode() + 527) * 31;
        Long l = this.zzzk;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.zzcg;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.zzzl;
        int hashCode4 = (((((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + zziu.hashCode(this.zzzm)) * 31) + zziu.hashCode(this.zzzn)) * 31) + zziu.hashCode(this.zzzo)) * 31;
        String str2 = this.zzzp;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.zzzq;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        zzis zzis = this.zzaoo;
        if (zzis != null && !zzis.isEmpty()) {
            i = this.zzaoo.hashCode();
        }
        return hashCode6 + i;
    }

    public final void zza(zzio zzio) throws IOException {
        Long l = this.zzzk;
        int i = 0;
        if (l != null) {
            long longValue = l.longValue();
            zzio.zzb(1, 0);
            zzio.zzbz(longValue);
        }
        String str = this.zzcg;
        if (str != null) {
            zzio.zzb(2, str);
        }
        Integer num = this.zzzl;
        if (num != null) {
            zzio.zzc(3, num.intValue());
        }
        zzbq$zza[] zzbq_zzaArr = this.zzzm;
        if (zzbq_zzaArr != null && zzbq_zzaArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzbq$zza[] zzbq_zzaArr2 = this.zzzm;
                if (i2 >= zzbq_zzaArr2.length) {
                    break;
                }
                zzbq$zza zzbq_zza = zzbq_zzaArr2[i2];
                if (zzbq_zza != null) {
                    zzio.zze(4, zzbq_zza);
                }
                i2++;
            }
        }
        zzbx[] zzbxArr = this.zzzn;
        if (zzbxArr != null && zzbxArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzbx[] zzbxArr2 = this.zzzn;
                if (i3 >= zzbxArr2.length) {
                    break;
                }
                zzbx zzbx = zzbxArr2[i3];
                if (zzbx != null) {
                    zzio.zza(5, zzbx);
                }
                i3++;
            }
        }
        zzbv[] zzbvArr = this.zzzo;
        if (zzbvArr != null && zzbvArr.length > 0) {
            while (true) {
                zzbv[] zzbvArr2 = this.zzzo;
                if (i >= zzbvArr2.length) {
                    break;
                }
                zzbv zzbv = zzbvArr2[i];
                if (zzbv != null) {
                    zzio.zza(6, zzbv);
                }
                i++;
            }
        }
        String str2 = this.zzzp;
        if (str2 != null) {
            zzio.zzb(7, str2);
        }
        Boolean bool = this.zzzq;
        if (bool != null) {
            zzio.zzb(8, bool.booleanValue());
        }
        super.zza(zzio);
    }

    /* access modifiers changed from: protected */
    public final int zzqy() {
        int zzqy = super.zzqy();
        Long l = this.zzzk;
        if (l != null) {
            long longValue = l.longValue();
            int zzbi = zzio.zzbi(1);
            int i = (-128 & longValue) == 0 ? 1 : (-16384 & longValue) == 0 ? 2 : (-2097152 & longValue) == 0 ? 3 : (-268435456 & longValue) == 0 ? 4 : (-34359738368L & longValue) == 0 ? 5 : (-4398046511104L & longValue) == 0 ? 6 : (-562949953421312L & longValue) == 0 ? 7 : (-72057594037927936L & longValue) == 0 ? 8 : (longValue & Long.MIN_VALUE) == 0 ? 9 : 10;
            zzqy += zzbi + i;
        }
        String str = this.zzcg;
        if (str != null) {
            zzqy += zzio.zzc(2, str);
        }
        Integer num = this.zzzl;
        if (num != null) {
            zzqy += zzio.zzg(3, num.intValue());
        }
        zzbq$zza[] zzbq_zzaArr = this.zzzm;
        int i2 = 0;
        if (zzbq_zzaArr != null && zzbq_zzaArr.length > 0) {
            int i3 = zzqy;
            int i4 = 0;
            while (true) {
                zzbq$zza[] zzbq_zzaArr2 = this.zzzm;
                if (i4 >= zzbq_zzaArr2.length) {
                    break;
                }
                zzbq$zza zzbq_zza = zzbq_zzaArr2[i4];
                if (zzbq_zza != null) {
                    i3 += zzee.zzc(4, (zzgi) zzbq_zza);
                }
                i4++;
            }
            zzqy = i3;
        }
        zzbx[] zzbxArr = this.zzzn;
        if (zzbxArr != null && zzbxArr.length > 0) {
            int i5 = zzqy;
            int i6 = 0;
            while (true) {
                zzbx[] zzbxArr2 = this.zzzn;
                if (i6 >= zzbxArr2.length) {
                    break;
                }
                zzbx zzbx = zzbxArr2[i6];
                if (zzbx != null) {
                    i5 += zzio.zzb(5, (zziw) zzbx);
                }
                i6++;
            }
            zzqy = i5;
        }
        zzbv[] zzbvArr = this.zzzo;
        if (zzbvArr != null && zzbvArr.length > 0) {
            while (true) {
                zzbv[] zzbvArr2 = this.zzzo;
                if (i2 >= zzbvArr2.length) {
                    break;
                }
                zzbv zzbv = zzbvArr2[i2];
                if (zzbv != null) {
                    zzqy += zzio.zzb(6, (zziw) zzbv);
                }
                i2++;
            }
        }
        String str2 = this.zzzp;
        if (str2 != null) {
            zzqy += zzio.zzc(7, str2);
        }
        Boolean bool = this.zzzq;
        if (bool == null) {
            return zzqy;
        }
        bool.booleanValue();
        return zzqy + zzio.zzbi(8) + 1;
    }

    public final /* synthetic */ zziw zza(zzil zzil) throws IOException {
        while (true) {
            int zzsg = zzil.zzsg();
            if (zzsg == 0) {
                return this;
            }
            if (zzsg == 8) {
                this.zzzk = Long.valueOf(zzil.zztb());
            } else if (zzsg == 18) {
                this.zzcg = zzil.readString();
            } else if (zzsg == 24) {
                this.zzzl = Integer.valueOf(zzil.zzta());
            } else if (zzsg == 34) {
                int zzb = zzix.zzb(zzil, 34);
                zzbq$zza[] zzbq_zzaArr = this.zzzm;
                int length = zzbq_zzaArr == null ? 0 : zzbq_zzaArr.length;
                zzbq$zza[] zzbq_zzaArr2 = new zzbq$zza[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzzm, 0, zzbq_zzaArr2, 0, length);
                }
                while (length < zzbq_zzaArr2.length - 1) {
                    zzbq_zzaArr2[length] = (zzbq$zza) zzil.zza(zzbq$zza.zzkj());
                    zzil.zzsg();
                    length++;
                }
                zzbq_zzaArr2[length] = (zzbq$zza) zzil.zza(zzbq$zza.zzkj());
                this.zzzm = zzbq_zzaArr2;
            } else if (zzsg == 42) {
                int zzb2 = zzix.zzb(zzil, 42);
                zzbx[] zzbxArr = this.zzzn;
                int length2 = zzbxArr == null ? 0 : zzbxArr.length;
                zzbx[] zzbxArr2 = new zzbx[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzzn, 0, zzbxArr2, 0, length2);
                }
                while (length2 < zzbxArr2.length - 1) {
                    zzbxArr2[length2] = new zzbx();
                    zzil.zza((zziw) zzbxArr2[length2]);
                    zzil.zzsg();
                    length2++;
                }
                zzbxArr2[length2] = new zzbx();
                zzil.zza((zziw) zzbxArr2[length2]);
                this.zzzn = zzbxArr2;
            } else if (zzsg == 50) {
                int zzb3 = zzix.zzb(zzil, 50);
                zzbv[] zzbvArr = this.zzzo;
                int length3 = zzbvArr == null ? 0 : zzbvArr.length;
                zzbv[] zzbvArr2 = new zzbv[(zzb3 + length3)];
                if (length3 != 0) {
                    System.arraycopy(this.zzzo, 0, zzbvArr2, 0, length3);
                }
                while (length3 < zzbvArr2.length - 1) {
                    zzbvArr2[length3] = new zzbv();
                    zzil.zza((zziw) zzbvArr2[length3]);
                    zzil.zzsg();
                    length3++;
                }
                zzbvArr2[length3] = new zzbv();
                zzil.zza((zziw) zzbvArr2[length3]);
                this.zzzo = zzbvArr2;
            } else if (zzsg == 58) {
                this.zzzp = zzil.readString();
            } else if (zzsg == 64) {
                this.zzzq = Boolean.valueOf(zzil.zzsm());
            } else if (!super.zza(zzil, zzsg)) {
                return this;
            }
        }
    }
}
