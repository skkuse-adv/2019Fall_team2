package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi.zzc;
import com.google.android.gms.internal.firebase_remote_config.zzhi.zzd;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zziw<T> implements zzjf<T> {
    private final zziq zzvv;
    private final boolean zzvw;
    private final zzjx<?, ?> zzwf;
    private final zzgz<?> zzwg;

    private zziw(zzjx<?, ?> zzjx, zzgz<?> zzgz, zziq zziq) {
        this.zzwf = zzjx;
        this.zzvw = zzgz.zze(zziq);
        this.zzwg = zzgz;
        this.zzvv = zziq;
    }

    static <T> zziw<T> zza(zzjx<?, ?> zzjx, zzgz<?> zzgz, zziq zziq) {
        return new zziw<>(zzjx, zzgz, zziq);
    }

    public final T newInstance() {
        return this.zzvv.zzgv().zzha();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzwf.zzaa(t).equals(this.zzwf.zzaa(t2))) {
            return false;
        }
        if (this.zzvw) {
            return this.zzwg.zzk(t).equals(this.zzwg.zzk(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzwf.zzaa(t).hashCode();
        return this.zzvw ? (hashCode * 53) + this.zzwg.zzk(t).hashCode() : hashCode;
    }

    public final void zze(T t, T t2) {
        zzjh.zza(this.zzwf, t, t2);
        if (this.zzvw) {
            zzjh.zza(this.zzwg, t, t2);
        }
    }

    public final void zza(T t, zzku zzku) throws IOException {
        Iterator it = this.zzwg.zzk(t).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzhc zzhc = (zzhc) entry.getKey();
            if (zzhc.zzgp() != zzkr.MESSAGE || zzhc.zzgq() || zzhc.zzgr()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzht) {
                zzku.zza(zzhc.zzgn(), (Object) ((zzht) entry).zzhp().zzep());
            } else {
                zzku.zza(zzhc.zzgn(), entry.getValue());
            }
        }
        zzjx<?, ?> zzjx = this.zzwf;
        zzjx.zzc(zzjx.zzaa(t), zzku);
    }

    public final void zza(T t, byte[] bArr, int i, int i2, zzfw zzfw) throws IOException {
        zzhi zzhi = (zzhi) t;
        zzka zzka = zzhi.zztc;
        if (zzka == zzka.zzja()) {
            zzka = zzka.zzjb();
            zzhi.zztc = zzka;
        }
        ((zzd) t).zzhc();
        zzc zzc = null;
        while (i < i2) {
            int zza = zzft.zza(bArr, i, zzfw);
            int i3 = zzfw.zzor;
            if (i3 == 11) {
                int i4 = 0;
                Object obj = null;
                while (zza < i2) {
                    zza = zzft.zza(bArr, zza, zzfw);
                    int i5 = zzfw.zzor;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzc != null) {
                                zzjb.zzii();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza = zzft.zze(bArr, zza, zzfw);
                                obj = (zzfx) zzfw.zzot;
                            }
                        }
                    } else if (i7 == 0) {
                        zza = zzft.zza(bArr, zza, zzfw);
                        i4 = zzfw.zzor;
                        zzc = (zzc) this.zzwg.zza(zzfw.zzou, this.zzvv, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza = zzft.zza(i5, bArr, zza, i2, zzfw);
                }
                if (obj != null) {
                    zzka.zzb((i4 << 3) | 2, obj);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                zzc = (zzc) this.zzwg.zza(zzfw.zzou, this.zzvv, i3 >>> 3);
                if (zzc == null) {
                    i = zzft.zza(i3, bArr, zza, i2, zzka, zzfw);
                } else {
                    zzjb.zzii();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zzft.zza(i3, bArr, zza, i2, zzfw);
            }
        }
        if (i != i2) {
            throw zzhq.zzhl();
        }
    }

    public final void zza(T t, zzjg zzjg, zzgx zzgx) throws IOException {
        boolean z;
        zzjx<?, ?> zzjx = this.zzwf;
        zzgz<?> zzgz = this.zzwg;
        Object zzab = zzjx.zzab(t);
        zzha zzl = zzgz.zzl(t);
        do {
            try {
                if (zzjg.zzfz() == Integer.MAX_VALUE) {
                    zzjx.zzh(t, zzab);
                    return;
                }
                int tag = zzjg.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzfx zzfx = null;
                    int i = 0;
                    while (zzjg.zzfz() != Integer.MAX_VALUE) {
                        int tag2 = zzjg.getTag();
                        if (tag2 == 16) {
                            i = zzjg.zzfk();
                            obj = zzgz.zza(zzgx, this.zzvv, i);
                        } else if (tag2 == 26) {
                            if (obj == null) {
                                zzfx = zzjg.zzfj();
                            } else {
                                zzgz.zza(zzjg, obj, zzgx, zzl);
                                throw null;
                            }
                        } else if (!zzjg.zzga()) {
                            break;
                        }
                    }
                    if (zzjg.getTag() == 12) {
                        if (zzfx != null) {
                            if (obj == null) {
                                zzjx.zza(zzab, i, zzfx);
                            } else {
                                zzgz.zza(zzfx, obj, zzgx, zzl);
                                throw null;
                            }
                        }
                        z = true;
                        continue;
                    } else {
                        throw zzhq.zzhi();
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzgz.zza(zzgx, this.zzvv, tag >>> 3);
                    if (zza == null) {
                        z = zzjx.zza(zzab, zzjg);
                        continue;
                    } else {
                        zzgz.zza(zzjg, zza, zzgx, zzl);
                        throw null;
                    }
                } else {
                    z = zzjg.zzga();
                    continue;
                }
            } finally {
                zzjx.zzh(t, zzab);
            }
        } while (z);
    }

    public final void zzm(T t) {
        this.zzwf.zzm(t);
        this.zzwg.zzm(t);
    }

    public final boolean zzy(T t) {
        return this.zzwg.zzk(t).isInitialized();
    }

    public final int zzw(T t) {
        zzjx<?, ?> zzjx = this.zzwf;
        int zzac = zzjx.zzac(zzjx.zzaa(t)) + 0;
        return this.zzvw ? zzac + this.zzwg.zzk(t).zzgj() : zzac;
    }
}
