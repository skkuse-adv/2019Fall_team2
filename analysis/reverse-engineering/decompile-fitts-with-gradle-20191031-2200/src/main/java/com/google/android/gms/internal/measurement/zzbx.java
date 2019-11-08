package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzbx extends zziq<zzbx> {
    private static volatile zzbx[] zzzr;
    public String name = null;
    public Boolean zzzs = null;
    public Boolean zzzt = null;
    public Integer zzzu = null;

    public static zzbx[] zzrc() {
        if (zzzr == null) {
            synchronized (zziu.zzaov) {
                if (zzzr == null) {
                    zzzr = new zzbx[0];
                }
            }
        }
        return zzzr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbx)) {
            return false;
        }
        zzbx zzbx = (zzbx) obj;
        String str = this.name;
        if (str == null) {
            if (zzbx.name != null) {
                return false;
            }
        } else if (!str.equals(zzbx.name)) {
            return false;
        }
        Boolean bool = this.zzzs;
        if (bool == null) {
            if (zzbx.zzzs != null) {
                return false;
            }
        } else if (!bool.equals(zzbx.zzzs)) {
            return false;
        }
        Boolean bool2 = this.zzzt;
        if (bool2 == null) {
            if (zzbx.zzzt != null) {
                return false;
            }
        } else if (!bool2.equals(zzbx.zzzt)) {
            return false;
        }
        Integer num = this.zzzu;
        if (num == null) {
            if (zzbx.zzzu != null) {
                return false;
            }
        } else if (!num.equals(zzbx.zzzu)) {
            return false;
        }
        zzis zzis = this.zzaoo;
        if (zzis != null && !zzis.isEmpty()) {
            return this.zzaoo.equals(zzbx.zzaoo);
        }
        zzis zzis2 = zzbx.zzaoo;
        return zzis2 == null || zzis2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzbx.class.getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.zzzs;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzzt;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.zzzu;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        zzis zzis = this.zzaoo;
        if (zzis != null && !zzis.isEmpty()) {
            i = this.zzaoo.hashCode();
        }
        return hashCode5 + i;
    }

    public final void zza(zzio zzio) throws IOException {
        String str = this.name;
        if (str != null) {
            zzio.zzb(1, str);
        }
        Boolean bool = this.zzzs;
        if (bool != null) {
            zzio.zzb(2, bool.booleanValue());
        }
        Boolean bool2 = this.zzzt;
        if (bool2 != null) {
            zzio.zzb(3, bool2.booleanValue());
        }
        Integer num = this.zzzu;
        if (num != null) {
            zzio.zzc(4, num.intValue());
        }
        super.zza(zzio);
    }

    /* access modifiers changed from: protected */
    public final int zzqy() {
        int zzqy = super.zzqy();
        String str = this.name;
        if (str != null) {
            zzqy += zzio.zzc(1, str);
        }
        Boolean bool = this.zzzs;
        if (bool != null) {
            bool.booleanValue();
            zzqy += zzio.zzbi(2) + 1;
        }
        Boolean bool2 = this.zzzt;
        if (bool2 != null) {
            bool2.booleanValue();
            zzqy += zzio.zzbi(3) + 1;
        }
        Integer num = this.zzzu;
        return num != null ? zzqy + zzio.zzg(4, num.intValue()) : zzqy;
    }

    public final /* synthetic */ zziw zza(zzil zzil) throws IOException {
        while (true) {
            int zzsg = zzil.zzsg();
            if (zzsg == 0) {
                return this;
            }
            if (zzsg == 10) {
                this.name = zzil.readString();
            } else if (zzsg == 16) {
                this.zzzs = Boolean.valueOf(zzil.zzsm());
            } else if (zzsg == 24) {
                this.zzzt = Boolean.valueOf(zzil.zzsm());
            } else if (zzsg == 32) {
                this.zzzu = Integer.valueOf(zzil.zzta());
            } else if (!super.zza(zzil, zzsg)) {
                return this;
            }
        }
    }
}
