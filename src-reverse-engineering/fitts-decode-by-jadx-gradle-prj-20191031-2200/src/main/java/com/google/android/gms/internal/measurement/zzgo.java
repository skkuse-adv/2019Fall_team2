package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzb;
import com.google.android.gms.internal.measurement.zzey.zze;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzgo<T> implements zzgx<T> {
    private final zzgi zzakn;
    private final boolean zzako;
    private final zzhp<?, ?> zzakx;
    private final zzen<?> zzaky;

    private zzgo(zzhp<?, ?> zzhp, zzen<?> zzen, zzgi zzgi) {
        this.zzakx = zzhp;
        this.zzako = zzen.zze(zzgi);
        this.zzaky = zzen;
        this.zzakn = zzgi;
    }

    static <T> zzgo<T> zza(zzhp<?, ?> zzhp, zzen<?> zzen, zzgi zzgi) {
        return new zzgo<>(zzhp, zzen, zzgi);
    }

    public final T newInstance() {
        return this.zzakn.zzup().zzuf();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzakx.zzx(t).equals(this.zzakx.zzx(t2))) {
            return false;
        }
        if (this.zzako) {
            return this.zzaky.zzh(t).equals(this.zzaky.zzh(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzakx.zzx(t).hashCode();
        return this.zzako ? (hashCode * 53) + this.zzaky.zzh(t).hashCode() : hashCode;
    }

    public final void zzc(T t, T t2) {
        zzgz.zza(this.zzakx, t, t2);
        if (this.zzako) {
            zzgz.zza(this.zzaky, t, t2);
        }
    }

    public final void zza(T t, zzim zzim) throws IOException {
        Iterator it = this.zzaky.zzh(t).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzeq zzeq = (zzeq) entry.getKey();
            if (zzeq.zztx() != zzij.MESSAGE || zzeq.zzty() || zzeq.zztz()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzfl) {
                zzim.zza(zzeq.zzlg(), (Object) ((zzfl) entry).zzve().zzrs());
            } else {
                zzim.zza(zzeq.zzlg(), entry.getValue());
            }
        }
        zzhp<?, ?> zzhp = this.zzakx;
        zzhp.zzc(zzhp.zzx(t), zzim);
    }

    public final void zza(T t, byte[] bArr, int i, int i2, zzdk zzdk) throws IOException {
        zzey zzey = (zzey) t;
        zzhs zzhs = zzey.zzahz;
        if (zzhs == zzhs.zzwq()) {
            zzhs = zzhs.zzwr();
            zzey.zzahz = zzhs;
        }
        ((zzb) t).zzuq();
        zze zze = null;
        while (i < i2) {
            int zza = zzdl.zza(bArr, i, zzdk);
            int i3 = zzdk.zzada;
            if (i3 == 11) {
                int i4 = 0;
                Object obj = null;
                while (zza < i2) {
                    zza = zzdl.zza(bArr, zza, zzdk);
                    int i5 = zzdk.zzada;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zze != null) {
                                zzgt.zzvy();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza = zzdl.zze(bArr, zza, zzdk);
                                obj = (zzdp) zzdk.zzadc;
                            }
                        }
                    } else if (i7 == 0) {
                        zza = zzdl.zza(bArr, zza, zzdk);
                        i4 = zzdk.zzada;
                        zze = (zze) this.zzaky.zza(zzdk.zzadd, this.zzakn, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza = zzdl.zza(i5, bArr, zza, i2, zzdk);
                }
                if (obj != null) {
                    zzhs.zzb((i4 << 3) | 2, obj);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                zze = (zze) this.zzaky.zza(zzdk.zzadd, this.zzakn, i3 >>> 3);
                if (zze == null) {
                    i = zzdl.zza(i3, bArr, zza, i2, zzhs, zzdk);
                } else {
                    zzgt.zzvy();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zzdl.zza(i3, bArr, zza, i2, zzdk);
            }
        }
        if (i != i2) {
            throw zzfi.zzva();
        }
    }

    public final void zza(T t, zzgy zzgy, zzel zzel) throws IOException {
        boolean z;
        zzhp<?, ?> zzhp = this.zzakx;
        zzen<?> zzen = this.zzaky;
        Object zzy = zzhp.zzy(t);
        zzeo zzi = zzen.zzi(t);
        do {
            try {
                if (zzgy.zzsy() == Integer.MAX_VALUE) {
                    zzhp.zzf(t, zzy);
                    return;
                }
                int tag = zzgy.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzdp zzdp = null;
                    int i = 0;
                    while (zzgy.zzsy() != Integer.MAX_VALUE) {
                        int tag2 = zzgy.getTag();
                        if (tag2 == 16) {
                            i = zzgy.zzsp();
                            obj = zzen.zza(zzel, this.zzakn, i);
                        } else if (tag2 == 26) {
                            if (obj == null) {
                                zzdp = zzgy.zzso();
                            } else {
                                zzen.zza(zzgy, obj, zzel, zzi);
                                throw null;
                            }
                        } else if (!zzgy.zzsz()) {
                            break;
                        }
                    }
                    if (zzgy.getTag() == 12) {
                        if (zzdp != null) {
                            if (obj == null) {
                                zzhp.zza(zzy, i, zzdp);
                            } else {
                                zzen.zza(zzdp, obj, zzel, zzi);
                                throw null;
                            }
                        }
                        z = true;
                        continue;
                    } else {
                        throw zzfi.zzux();
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzen.zza(zzel, this.zzakn, tag >>> 3);
                    if (zza == null) {
                        z = zzhp.zza(zzy, zzgy);
                        continue;
                    } else {
                        zzen.zza(zzgy, zza, zzel, zzi);
                        throw null;
                    }
                } else {
                    z = zzgy.zzsz();
                    continue;
                }
            } finally {
                zzhp.zzf(t, zzy);
            }
        } while (z);
    }

    public final void zzj(T t) {
        this.zzakx.zzj(t);
        this.zzaky.zzj(t);
    }

    public final boolean zzv(T t) {
        return this.zzaky.zzh(t).isInitialized();
    }

    public final int zzt(T t) {
        zzhp<?, ?> zzhp = this.zzakx;
        int zzz = zzhp.zzz(zzhp.zzx(t)) + 0;
        return this.zzako ? zzz + this.zzaky.zzh(t).zzts() : zzz;
    }
}
