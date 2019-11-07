package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzha<FieldDescriptorType extends zzhc<FieldDescriptorType>> {
    private static final zzha zzqi = new zzha(true);
    final zzjk<FieldDescriptorType, Object> zzqf = zzjk.zzbl(16);
    private boolean zzqg;
    private boolean zzqh = false;

    private zzha() {
    }

    private zzha(boolean z) {
        zzes();
    }

    public static <T extends zzhc<T>> zzha<T> zzgi() {
        return zzqi;
    }

    public final void zzes() {
        if (!this.zzqg) {
            this.zzqf.zzes();
            this.zzqg = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzqg;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzha)) {
            return false;
        }
        return this.zzqf.equals(((zzha) obj).zzqf);
    }

    public final int hashCode() {
        return this.zzqf.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzqh) {
            return new zzhw(this.zzqf.entrySet().iterator());
        }
        return this.zzqf.entrySet().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final Iterator<Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzqh) {
            return new zzhw(this.zzqf.zzit().iterator());
        }
        return this.zzqf.zzit().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzqf.get(fielddescriptortype);
        return obj instanceof zzhr ? zzhr.zzhn() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzgq()) {
            zza(fielddescriptortype.zzgo(), obj);
            r6 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(fielddescriptortype.zzgo(), obj2);
            }
            r6 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r6 instanceof zzhr) {
            this.zzqh = true;
        }
        this.zzqf.put(fielddescriptortype, r6);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase_remote_config.zzhr) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase_remote_config.zzhl) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.firebase_remote_config.zzko r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.firebase_remote_config.zzhm.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.firebase_remote_config.zzhd.zzql
            com.google.android.gms.internal.firebase_remote_config.zzkr r2 = r2.zzjj()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001e;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0043
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_remote_config.zziq
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_remote_config.zzhr
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_remote_config.zzhl
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_remote_config.zzfx
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            r1 = r0
        L_0x0043:
            if (r1 == 0) goto L_0x0046
            return
        L_0x0046:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L_0x004f
        L_0x004e:
            throw r2
        L_0x004f:
            goto L_0x004e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzha.zza(com.google.android.gms.internal.firebase_remote_config.zzko, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzqf.zzir(); i++) {
            if (!zzb(this.zzqf.zzbm(i))) {
                return false;
            }
        }
        for (Entry zzb : this.zzqf.zzis()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Entry<FieldDescriptorType, Object> entry) {
        zzhc zzhc = (zzhc) entry.getKey();
        if (zzhc.zzgp() == zzkr.MESSAGE) {
            if (zzhc.zzgq()) {
                for (zziq isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zziq) {
                    if (!((zziq) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzhr) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzha<FieldDescriptorType> zzha) {
        for (int i = 0; i < zzha.zzqf.zzir(); i++) {
            zzc(zzha.zzqf.zzbm(i));
        }
        for (Entry zzc : zzha.zzqf.zzis()) {
            zzc(zzc);
        }
    }

    private static Object zzn(Object obj) {
        if (obj instanceof zziv) {
            return ((zziv) obj).zzie();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzhc zzhc = (zzhc) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzhr) {
            value = zzhr.zzhn();
        }
        if (zzhc.zzgq()) {
            Object zza = zza((FieldDescriptorType) zzhc);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzn : (List) value) {
                ((List) zza).add(zzn(zzn));
            }
            this.zzqf.put(zzhc, zza);
        } else if (zzhc.zzgp() == zzkr.MESSAGE) {
            Object zza2 = zza((FieldDescriptorType) zzhc);
            if (zza2 == null) {
                this.zzqf.put(zzhc, zzn(value));
                return;
            }
            if (zza2 instanceof zziv) {
                obj = zzhc.zza((zziv) zza2, (zziv) value);
            } else {
                obj = zzhc.zza(((zziq) zza2).zzgu(), (zziq) value).zzhb();
            }
            this.zzqf.put(zzhc, obj);
        } else {
            this.zzqf.put(zzhc, zzn(value));
        }
    }

    static void zza(zzgs zzgs, zzko zzko, int i, Object obj) throws IOException {
        if (zzko == zzko.GROUP) {
            zziq zziq = (zziq) obj;
            zzhm.zzf(zziq);
            zzgs.zzc(i, 3);
            zziq.zzb(zzgs);
            zzgs.zzc(i, 4);
            return;
        }
        zzgs.zzc(i, zzko.zzjk());
        switch (zzhd.zzpr[zzko.ordinal()]) {
            case 1:
                zzgs.zzc(((Double) obj).doubleValue());
                break;
            case 2:
                zzgs.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzgs.zzf(((Long) obj).longValue());
                return;
            case 4:
                zzgs.zzf(((Long) obj).longValue());
                return;
            case 5:
                zzgs.zzam(((Integer) obj).intValue());
                return;
            case 6:
                zzgs.zzh(((Long) obj).longValue());
                return;
            case 7:
                zzgs.zzap(((Integer) obj).intValue());
                return;
            case 8:
                zzgs.zzd(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zziq) obj).zzb(zzgs);
                return;
            case 10:
                zzgs.zzb((zziq) obj);
                return;
            case 11:
                if (obj instanceof zzfx) {
                    zzgs.zzb((zzfx) obj);
                    return;
                } else {
                    zzgs.zzbk((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzfx) {
                    zzgs.zzb((zzfx) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzgs.zzd(bArr, 0, bArr.length);
                return;
            case 13:
                zzgs.zzan(((Integer) obj).intValue());
                return;
            case 14:
                zzgs.zzap(((Integer) obj).intValue());
                return;
            case 15:
                zzgs.zzh(((Long) obj).longValue());
                return;
            case 16:
                zzgs.zzao(((Integer) obj).intValue());
                return;
            case 17:
                zzgs.zzg(((Long) obj).longValue());
                return;
            case 18:
                if (!(obj instanceof zzhl)) {
                    zzgs.zzam(((Integer) obj).intValue());
                    break;
                } else {
                    zzgs.zzam(((zzhl) obj).zzgn());
                    return;
                }
        }
    }

    public final int zzgj() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzqf.zzir(); i2++) {
            i += zzd(this.zzqf.zzbm(i2));
        }
        for (Entry zzd : this.zzqf.zzis()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Entry<FieldDescriptorType, Object> entry) {
        zzhc zzhc = (zzhc) entry.getKey();
        Object value = entry.getValue();
        if (zzhc.zzgp() != zzkr.MESSAGE || zzhc.zzgq() || zzhc.zzgr()) {
            return zzb(zzhc, value);
        }
        if (value instanceof zzhr) {
            return zzgs.zzb(((zzhc) entry.getKey()).zzgn(), (zzhv) (zzhr) value);
        }
        return zzgs.zzb(((zzhc) entry.getKey()).zzgn(), (zziq) value);
    }

    static int zza(zzko zzko, int i, Object obj) {
        int zzaq = zzgs.zzaq(i);
        if (zzko == zzko.GROUP) {
            zzhm.zzf((zziq) obj);
            zzaq <<= 1;
        }
        return zzaq + zzb(zzko, obj);
    }

    private static int zzb(zzko zzko, Object obj) {
        switch (zzhd.zzpr[zzko.ordinal()]) {
            case 1:
                return zzgs.zzd(((Double) obj).doubleValue());
            case 2:
                return zzgs.zzc(((Float) obj).floatValue());
            case 3:
                return zzgs.zzi(((Long) obj).longValue());
            case 4:
                return zzgs.zzj(((Long) obj).longValue());
            case 5:
                return zzgs.zzar(((Integer) obj).intValue());
            case 6:
                return zzgs.zzl(((Long) obj).longValue());
            case 7:
                return zzgs.zzau(((Integer) obj).intValue());
            case 8:
                return zzgs.zze(((Boolean) obj).booleanValue());
            case 9:
                return zzgs.zzd((zziq) obj);
            case 10:
                if (obj instanceof zzhr) {
                    return zzgs.zza((zzhr) obj);
                }
                return zzgs.zzc((zziq) obj);
            case 11:
                if (obj instanceof zzfx) {
                    return zzgs.zzc((zzfx) obj);
                }
                return zzgs.zzbl((String) obj);
            case 12:
                if (obj instanceof zzfx) {
                    return zzgs.zzc((zzfx) obj);
                }
                return zzgs.zzd((byte[]) obj);
            case 13:
                return zzgs.zzas(((Integer) obj).intValue());
            case 14:
                return zzgs.zzav(((Integer) obj).intValue());
            case 15:
                return zzgs.zzm(((Long) obj).longValue());
            case 16:
                return zzgs.zzat(((Integer) obj).intValue());
            case 17:
                return zzgs.zzk(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzhl) {
                    return zzgs.zzaw(((zzhl) obj).zzgn());
                }
                return zzgs.zzaw(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzhc<?> zzhc, Object obj) {
        zzko zzgo = zzhc.zzgo();
        int zzgn = zzhc.zzgn();
        if (!zzhc.zzgq()) {
            return zza(zzgo, zzgn, obj);
        }
        int i = 0;
        if (zzhc.zzgr()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzgo, zzb);
            }
            return zzgs.zzaq(zzgn) + i + zzgs.zzay(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzgo, zzgn, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzha zzha = new zzha();
        for (int i = 0; i < this.zzqf.zzir(); i++) {
            Entry zzbm = this.zzqf.zzbm(i);
            zzha.zza((FieldDescriptorType) (zzhc) zzbm.getKey(), zzbm.getValue());
        }
        for (Entry entry : this.zzqf.zzis()) {
            zzha.zza((FieldDescriptorType) (zzhc) entry.getKey(), entry.getValue());
        }
        zzha.zzqh = this.zzqh;
        return zzha;
    }
}
