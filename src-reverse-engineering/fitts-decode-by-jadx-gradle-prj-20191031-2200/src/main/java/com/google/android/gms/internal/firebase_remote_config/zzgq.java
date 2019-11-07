package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.util.List;

final class zzgq implements zzjg {
    private int tag;
    private final zzgj zzps;
    private int zzpt;
    private int zzpu = 0;

    public static zzgq zza(zzgj zzgj) {
        zzgq zzgq = zzgj.zzpg;
        if (zzgq != null) {
            return zzgq;
        }
        return new zzgq(zzgj);
    }

    private zzgq(zzgj zzgj) {
        zzhm.zza(zzgj, "input");
        this.zzps = zzgj;
        this.zzps.zzpg = this;
    }

    public final int zzfz() throws IOException {
        int i = this.zzpu;
        if (i != 0) {
            this.tag = i;
            this.zzpu = 0;
        } else {
            this.tag = this.zzps.zzfb();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzpt) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzga() throws IOException {
        if (!this.zzps.zzfr()) {
            int i = this.tag;
            if (i != this.zzpt) {
                return this.zzps.zzz(i);
            }
        }
        return false;
    }

    private final void zzai(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhq.zzhj();
        }
    }

    public final double readDouble() throws IOException {
        zzai(1);
        return this.zzps.readDouble();
    }

    public final float readFloat() throws IOException {
        zzai(5);
        return this.zzps.readFloat();
    }

    public final long zzfc() throws IOException {
        zzai(0);
        return this.zzps.zzfc();
    }

    public final long zzfd() throws IOException {
        zzai(0);
        return this.zzps.zzfd();
    }

    public final int zzfe() throws IOException {
        zzai(0);
        return this.zzps.zzfe();
    }

    public final long zzff() throws IOException {
        zzai(1);
        return this.zzps.zzff();
    }

    public final int zzfg() throws IOException {
        zzai(5);
        return this.zzps.zzfg();
    }

    public final boolean zzfh() throws IOException {
        zzai(0);
        return this.zzps.zzfh();
    }

    public final String readString() throws IOException {
        zzai(2);
        return this.zzps.readString();
    }

    public final String zzfi() throws IOException {
        zzai(2);
        return this.zzps.zzfi();
    }

    public final <T> T zza(zzjf<T> zzjf, zzgx zzgx) throws IOException {
        zzai(2);
        return zzc(zzjf, zzgx);
    }

    public final <T> T zzb(zzjf<T> zzjf, zzgx zzgx) throws IOException {
        zzai(3);
        return zzd(zzjf, zzgx);
    }

    private final <T> T zzc(zzjf<T> zzjf, zzgx zzgx) throws IOException {
        int zzfk = this.zzps.zzfk();
        zzgj zzgj = this.zzps;
        if (zzgj.zzpd < zzgj.zzpe) {
            int zzaa = zzgj.zzaa(zzfk);
            T newInstance = zzjf.newInstance();
            this.zzps.zzpd++;
            zzjf.zza(newInstance, this, zzgx);
            zzjf.zzm(newInstance);
            this.zzps.zzy(0);
            zzgj zzgj2 = this.zzps;
            zzgj2.zzpd--;
            zzgj2.zzab(zzaa);
            return newInstance;
        }
        throw new zzhq("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzjf<T> zzjf, zzgx zzgx) throws IOException {
        int i = this.zzpt;
        this.zzpt = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzjf.newInstance();
            zzjf.zza(newInstance, this, zzgx);
            zzjf.zzm(newInstance);
            if (this.tag == this.zzpt) {
                return newInstance;
            }
            throw zzhq.zzhl();
        } finally {
            this.zzpt = i;
        }
    }

    public final zzfx zzfj() throws IOException {
        zzai(2);
        return this.zzps.zzfj();
    }

    public final int zzfk() throws IOException {
        zzai(0);
        return this.zzps.zzfk();
    }

    public final int zzfl() throws IOException {
        zzai(0);
        return this.zzps.zzfl();
    }

    public final int zzfm() throws IOException {
        zzai(5);
        return this.zzps.zzfm();
    }

    public final long zzfn() throws IOException {
        zzai(1);
        return this.zzps.zzfn();
    }

    public final int zzfo() throws IOException {
        zzai(0);
        return this.zzps.zzfo();
    }

    public final long zzfp() throws IOException {
        zzai(0);
        return this.zzps.zzfp();
    }

    public final void zzc(List<Double> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzgt.zze(this.zzps.readDouble());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfk = this.zzps.zzfk();
                zzaj(zzfk);
                int zzfs = this.zzps.zzfs() + zzfk;
                do {
                    zzgt.zze(this.zzps.readDouble());
                } while (this.zzps.zzfs() < zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzps.readDouble()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfk2 = this.zzps.zzfk();
                zzaj(zzfk2);
                int zzfs2 = this.zzps.zzfs() + zzfk2;
                do {
                    list.add(Double.valueOf(this.zzps.readDouble()));
                } while (this.zzps.zzfs() < zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzd(List<Float> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzhg) {
            zzhg zzhg = (zzhg) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzfk = this.zzps.zzfk();
                zzak(zzfk);
                int zzfs = this.zzps.zzfs() + zzfk;
                do {
                    zzhg.zzd(this.zzps.readFloat());
                } while (this.zzps.zzfs() < zzfs);
            } else if (i == 5) {
                do {
                    zzhg.zzd(this.zzps.readFloat());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzfk2 = this.zzps.zzfk();
                zzak(zzfk2);
                int zzfs2 = this.zzps.zzfs() + zzfk2;
                do {
                    list.add(Float.valueOf(this.zzps.readFloat()));
                } while (this.zzps.zzfs() < zzfs2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzps.readFloat()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zze(List<Long> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzie.zzp(this.zzps.zzfc());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfs = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    zzie.zzp(this.zzps.zzfc());
                } while (this.zzps.zzfs() < zzfs);
                zzal(zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzps.zzfc()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfs2 = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    list.add(Long.valueOf(this.zzps.zzfc()));
                } while (this.zzps.zzfs() < zzfs2);
                zzal(zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzie.zzp(this.zzps.zzfd());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfs = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    zzie.zzp(this.zzps.zzfd());
                } while (this.zzps.zzfs() < zzfs);
                zzal(zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzps.zzfd()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfs2 = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    list.add(Long.valueOf(this.zzps.zzfd()));
                } while (this.zzps.zzfs() < zzfs2);
                zzal(zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzg(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhk.zzbb(this.zzps.zzfe());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfs = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    zzhk.zzbb(this.zzps.zzfe());
                } while (this.zzps.zzfs() < zzfs);
                zzal(zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzps.zzfe()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfs2 = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    list.add(Integer.valueOf(this.zzps.zzfe()));
                } while (this.zzps.zzfs() < zzfs2);
                zzal(zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzh(List<Long> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzie.zzp(this.zzps.zzff());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfk = this.zzps.zzfk();
                zzaj(zzfk);
                int zzfs = this.zzps.zzfs() + zzfk;
                do {
                    zzie.zzp(this.zzps.zzff());
                } while (this.zzps.zzfs() < zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzps.zzff()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfk2 = this.zzps.zzfk();
                zzaj(zzfk2);
                int zzfs2 = this.zzps.zzfs() + zzfk2;
                do {
                    list.add(Long.valueOf(this.zzps.zzff()));
                } while (this.zzps.zzfs() < zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzi(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzfk = this.zzps.zzfk();
                zzak(zzfk);
                int zzfs = this.zzps.zzfs() + zzfk;
                do {
                    zzhk.zzbb(this.zzps.zzfg());
                } while (this.zzps.zzfs() < zzfs);
            } else if (i == 5) {
                do {
                    zzhk.zzbb(this.zzps.zzfg());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzfk2 = this.zzps.zzfk();
                zzak(zzfk2);
                int zzfs2 = this.zzps.zzfs() + zzfk2;
                do {
                    list.add(Integer.valueOf(this.zzps.zzfg()));
                } while (this.zzps.zzfs() < zzfs2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzps.zzfg()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzj(List<Boolean> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzfv) {
            zzfv zzfv = (zzfv) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfv.addBoolean(this.zzps.zzfh());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfs = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    zzfv.addBoolean(this.zzps.zzfh());
                } while (this.zzps.zzfs() < zzfs);
                zzal(zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzps.zzfh()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfs2 = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    list.add(Boolean.valueOf(this.zzps.zzfh()));
                } while (this.zzps.zzfs() < zzfs2);
                zzal(zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzk(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzfb;
        int zzfb2;
        if ((this.tag & 7) != 2) {
            throw zzhq.zzhj();
        } else if (!(list instanceof zzhx) || z) {
            do {
                list.add(z ? zzfi() : readString());
                if (!this.zzps.zzfr()) {
                    zzfb = this.zzps.zzfb();
                } else {
                    return;
                }
            } while (zzfb == this.tag);
            this.zzpu = zzfb;
        } else {
            zzhx zzhx = (zzhx) list;
            do {
                zzhx.zzd(zzfj());
                if (!this.zzps.zzfr()) {
                    zzfb2 = this.zzps.zzfb();
                } else {
                    return;
                }
            } while (zzfb2 == this.tag);
            this.zzpu = zzfb2;
        }
    }

    public final <T> void zza(List<T> list, zzjf<T> zzjf, zzgx zzgx) throws IOException {
        int zzfb;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzjf, zzgx));
                if (!this.zzps.zzfr() && this.zzpu == 0) {
                    zzfb = this.zzps.zzfb();
                } else {
                    return;
                }
            } while (zzfb == i);
            this.zzpu = zzfb;
            return;
        }
        throw zzhq.zzhj();
    }

    public final <T> void zzb(List<T> list, zzjf<T> zzjf, zzgx zzgx) throws IOException {
        int zzfb;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzjf, zzgx));
                if (!this.zzps.zzfr() && this.zzpu == 0) {
                    zzfb = this.zzps.zzfb();
                } else {
                    return;
                }
            } while (zzfb == i);
            this.zzpu = zzfb;
            return;
        }
        throw zzhq.zzhj();
    }

    public final void zzl(List<zzfx> list) throws IOException {
        int zzfb;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzfj());
                if (!this.zzps.zzfr()) {
                    zzfb = this.zzps.zzfb();
                } else {
                    return;
                }
            } while (zzfb == this.tag);
            this.zzpu = zzfb;
            return;
        }
        throw zzhq.zzhj();
    }

    public final void zzm(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhk.zzbb(this.zzps.zzfk());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfs = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    zzhk.zzbb(this.zzps.zzfk());
                } while (this.zzps.zzfs() < zzfs);
                zzal(zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzps.zzfk()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfs2 = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    list.add(Integer.valueOf(this.zzps.zzfk()));
                } while (this.zzps.zzfs() < zzfs2);
                zzal(zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzn(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhk.zzbb(this.zzps.zzfl());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfs = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    zzhk.zzbb(this.zzps.zzfl());
                } while (this.zzps.zzfs() < zzfs);
                zzal(zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzps.zzfl()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfs2 = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    list.add(Integer.valueOf(this.zzps.zzfl()));
                } while (this.zzps.zzfs() < zzfs2);
                zzal(zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzo(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzfk = this.zzps.zzfk();
                zzak(zzfk);
                int zzfs = this.zzps.zzfs() + zzfk;
                do {
                    zzhk.zzbb(this.zzps.zzfm());
                } while (this.zzps.zzfs() < zzfs);
            } else if (i == 5) {
                do {
                    zzhk.zzbb(this.zzps.zzfm());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzfk2 = this.zzps.zzfk();
                zzak(zzfk2);
                int zzfs2 = this.zzps.zzfs() + zzfk2;
                do {
                    list.add(Integer.valueOf(this.zzps.zzfm()));
                } while (this.zzps.zzfs() < zzfs2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzps.zzfm()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzp(List<Long> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzie.zzp(this.zzps.zzfn());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfk = this.zzps.zzfk();
                zzaj(zzfk);
                int zzfs = this.zzps.zzfs() + zzfk;
                do {
                    zzie.zzp(this.zzps.zzfn());
                } while (this.zzps.zzfs() < zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzps.zzfn()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfk2 = this.zzps.zzfk();
                zzaj(zzfk2);
                int zzfs2 = this.zzps.zzfs() + zzfk2;
                do {
                    list.add(Long.valueOf(this.zzps.zzfn()));
                } while (this.zzps.zzfs() < zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzq(List<Integer> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhk.zzbb(this.zzps.zzfo());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfs = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    zzhk.zzbb(this.zzps.zzfo());
                } while (this.zzps.zzfs() < zzfs);
                zzal(zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzps.zzfo()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfs2 = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    list.add(Integer.valueOf(this.zzps.zzfo()));
                } while (this.zzps.zzfs() < zzfs2);
                zzal(zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    public final void zzr(List<Long> list) throws IOException {
        int zzfb;
        int zzfb2;
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzie.zzp(this.zzps.zzfp());
                    if (!this.zzps.zzfr()) {
                        zzfb2 = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb2 == this.tag);
                this.zzpu = zzfb2;
            } else if (i == 2) {
                int zzfs = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    zzie.zzp(this.zzps.zzfp());
                } while (this.zzps.zzfs() < zzfs);
                zzal(zzfs);
            } else {
                throw zzhq.zzhj();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzps.zzfp()));
                    if (!this.zzps.zzfr()) {
                        zzfb = this.zzps.zzfb();
                    } else {
                        return;
                    }
                } while (zzfb == this.tag);
                this.zzpu = zzfb;
            } else if (i2 == 2) {
                int zzfs2 = this.zzps.zzfs() + this.zzps.zzfk();
                do {
                    list.add(Long.valueOf(this.zzps.zzfp()));
                } while (this.zzps.zzfs() < zzfs2);
                zzal(zzfs2);
            } else {
                throw zzhq.zzhj();
            }
        }
    }

    private static void zzaj(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzhq.zzhl();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzga() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.firebase_remote_config.zzhq(r6);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.firebase_remote_config.zzih<K, V> r9, com.google.android.gms.internal.firebase_remote_config.zzgx r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzai(r0)
            com.google.android.gms.internal.firebase_remote_config.zzgj r1 = r7.zzps
            int r1 = r1.zzfk()
            com.google.android.gms.internal.firebase_remote_config.zzgj r2 = r7.zzps
            int r1 = r2.zzaa(r1)
            K r2 = r9.zzvj
            V r3 = r9.zzvl
        L_0x0014:
            int r4 = r7.zzfz()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.firebase_remote_config.zzgj r5 = r7.zzps     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzfr()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzga()     // Catch:{ zzhp -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.firebase_remote_config.zzhq r4 = new com.google.android.gms.internal.firebase_remote_config.zzhq     // Catch:{ zzhp -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzhp -> 0x004e }
            throw r4     // Catch:{ zzhp -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.firebase_remote_config.zzko r4 = r9.zzvk     // Catch:{ zzhp -> 0x004e }
            V r5 = r9.zzvl     // Catch:{ zzhp -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzhp -> 0x004e }
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch:{ zzhp -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.firebase_remote_config.zzko r4 = r9.zzvi     // Catch:{ zzhp -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch:{ zzhp -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzga()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.firebase_remote_config.zzhq r8 = new com.google.android.gms.internal.firebase_remote_config.zzhq     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.firebase_remote_config.zzgj r8 = r7.zzps
            r8.zzab(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.firebase_remote_config.zzgj r9 = r7.zzps
            r9.zzab(r1)
            goto L_0x006c
        L_0x006b:
            throw r8
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzgq.zza(java.util.Map, com.google.android.gms.internal.firebase_remote_config.zzih, com.google.android.gms.internal.firebase_remote_config.zzgx):void");
    }

    private final Object zza(zzko zzko, Class<?> cls, zzgx zzgx) throws IOException {
        switch (zzgp.zzpr[zzko.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzfh());
            case 2:
                return zzfj();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzfl());
            case 5:
                return Integer.valueOf(zzfg());
            case 6:
                return Long.valueOf(zzff());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzfe());
            case 9:
                return Long.valueOf(zzfd());
            case 10:
                zzai(2);
                return zzc(zzjb.zzii().zzk(cls), zzgx);
            case 11:
                return Integer.valueOf(zzfm());
            case 12:
                return Long.valueOf(zzfn());
            case 13:
                return Integer.valueOf(zzfo());
            case 14:
                return Long.valueOf(zzfp());
            case 15:
                return zzfi();
            case 16:
                return Integer.valueOf(zzfk());
            case 17:
                return Long.valueOf(zzfc());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzak(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzhq.zzhl();
        }
    }

    private final void zzal(int i) throws IOException {
        if (this.zzps.zzfs() != i) {
            throw zzhq.zzhe();
        }
    }
}
