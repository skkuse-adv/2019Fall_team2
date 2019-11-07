package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzej;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzeh<FieldDescriptorType extends zzej<FieldDescriptorType>> {
    private static final zzeh zzns = new zzeh(true);
    final zzgp<FieldDescriptorType, Object> zznp = zzgp.zzat(16);
    private boolean zznq;
    private boolean zznr = false;

    private zzeh() {
    }

    private zzeh(boolean z) {
        zzgf();
    }

    public static <T extends zzej<T>> zzeh<T> zzgu() {
        return zzns;
    }

    public final void zzgf() {
        if (!this.zznq) {
            this.zznp.zzgf();
            this.zznq = true;
        }
    }

    public final boolean isImmutable() {
        return this.zznq;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeh)) {
            return false;
        }
        return this.zznp.equals(((zzeh) obj).zznp);
    }

    public final int hashCode() {
        return this.zznp.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zznr) {
            return new zzfd(this.zznp.entrySet().iterator());
        }
        return this.zznp.entrySet().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final Iterator<Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zznr) {
            return new zzfd(this.zznp.zziu().iterator());
        }
        return this.zznp.zziu().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zznp.get(fielddescriptortype);
        return obj instanceof zzfc ? zzfc.zzht() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzhb()) {
            zza(fielddescriptortype.zzgz(), obj);
            r6 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(fielddescriptortype.zzgz(), obj2);
            }
            r6 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r6 instanceof zzfc) {
            this.zznr = true;
        }
        this.zznp.put(fielddescriptortype, r6);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase-perf.zzfc) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase-perf.zzer) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.firebase-perf.zzhu r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.firebase-perf.zzes.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.firebase-perf.zzek.zznv
            com.google.android.gms.internal.firebase-perf.zzhx r2 = r2.zzjn()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase-perf.zzfx
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase-perf.zzfc
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase-perf.zzer
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase-perf.zzdl
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-perf.zzeh.zza(com.google.android.gms.internal.firebase-perf.zzhu, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zznp.zzis(); i++) {
            if (!zzc(this.zznp.zzau(i))) {
                return false;
            }
        }
        for (Entry zzc : this.zznp.zzit()) {
            if (!zzc(zzc)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzc(Entry<FieldDescriptorType, Object> entry) {
        zzej zzej = (zzej) entry.getKey();
        if (zzej.zzha() == zzhx.MESSAGE) {
            if (zzej.zzhb()) {
                for (zzfx isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzfx) {
                    if (!((zzfx) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzfc) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzeh<FieldDescriptorType> zzeh) {
        for (int i = 0; i < zzeh.zznp.zzis(); i++) {
            zzd(zzeh.zznp.zzau(i));
        }
        for (Entry zzd : zzeh.zznp.zzit()) {
            zzd(zzd);
        }
    }

    private static Object zzf(Object obj) {
        if (obj instanceof zzgd) {
            return ((zzgd) obj).zzik();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzd(Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzej zzej = (zzej) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfc) {
            value = zzfc.zzht();
        }
        if (zzej.zzhb()) {
            Object zza = zza((FieldDescriptorType) zzej);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzf : (List) value) {
                ((List) zza).add(zzf(zzf));
            }
            this.zznp.put(zzej, zza);
        } else if (zzej.zzha() == zzhx.MESSAGE) {
            Object zza2 = zza((FieldDescriptorType) zzej);
            if (zza2 == null) {
                this.zznp.put(zzej, zzf(value));
                return;
            }
            if (zza2 instanceof zzgd) {
                obj = zzej.zza((zzgd) zza2, (zzgd) value);
            } else {
                obj = zzej.zza(((zzfx) zza2).zzhp(), (zzfx) value).zzhi();
            }
            this.zznp.put(zzej, obj);
        } else {
            this.zznp.put(zzej, zzf(value));
        }
    }

    static void zza(zzec zzec, zzhu zzhu, int i, Object obj) throws IOException {
        if (zzhu == zzhu.GROUP) {
            zzfx zzfx = (zzfx) obj;
            zzes.zzf(zzfx);
            zzec.zzf(i, 3);
            zzfx.zzb(zzec);
            zzec.zzf(i, 4);
            return;
        }
        zzec.zzf(i, zzhu.zzjo());
        switch (zzek.zznw[zzhu.ordinal()]) {
            case 1:
                zzec.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzec.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzec.zzam(((Long) obj).longValue());
                return;
            case 4:
                zzec.zzam(((Long) obj).longValue());
                return;
            case 5:
                zzec.zzu(((Integer) obj).intValue());
                return;
            case 6:
                zzec.zzao(((Long) obj).longValue());
                return;
            case 7:
                zzec.zzx(((Integer) obj).intValue());
                return;
            case 8:
                zzec.zzd(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzfx) obj).zzb(zzec);
                return;
            case 10:
                zzec.zzb((zzfx) obj);
                return;
            case 11:
                if (obj instanceof zzdl) {
                    zzec.zza((zzdl) obj);
                    return;
                } else {
                    zzec.zzag((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdl) {
                    zzec.zza((zzdl) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzec.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzec.zzv(((Integer) obj).intValue());
                return;
            case 14:
                zzec.zzx(((Integer) obj).intValue());
                return;
            case 15:
                zzec.zzao(((Long) obj).longValue());
                return;
            case 16:
                zzec.zzw(((Integer) obj).intValue());
                return;
            case 17:
                zzec.zzan(((Long) obj).longValue());
                return;
            case 18:
                if (!(obj instanceof zzer)) {
                    zzec.zzu(((Integer) obj).intValue());
                    break;
                } else {
                    zzec.zzu(((zzer) obj).zzdj());
                    return;
                }
        }
    }

    public final int zzgv() {
        int i = 0;
        for (int i2 = 0; i2 < this.zznp.zzis(); i2++) {
            i += zze(this.zznp.zzau(i2));
        }
        for (Entry zze : this.zznp.zzit()) {
            i += zze(zze);
        }
        return i;
    }

    private static int zze(Entry<FieldDescriptorType, Object> entry) {
        zzej zzej = (zzej) entry.getKey();
        Object value = entry.getValue();
        if (zzej.zzha() != zzhx.MESSAGE || zzej.zzhb() || zzej.zzhc()) {
            return zzb(zzej, value);
        }
        if (value instanceof zzfc) {
            return zzec.zzb(((zzej) entry.getKey()).zzdj(), (zzfg) (zzfc) value);
        }
        return zzec.zzb(((zzej) entry.getKey()).zzdj(), (zzfx) value);
    }

    static int zza(zzhu zzhu, int i, Object obj) {
        int zzy = zzec.zzy(i);
        if (zzhu == zzhu.GROUP) {
            zzes.zzf((zzfx) obj);
            zzy <<= 1;
        }
        return zzy + zzb(zzhu, obj);
    }

    private static int zzb(zzhu zzhu, Object obj) {
        switch (zzek.zznw[zzhu.ordinal()]) {
            case 1:
                return zzec.zzb(((Double) obj).doubleValue());
            case 2:
                return zzec.zzb(((Float) obj).floatValue());
            case 3:
                return zzec.zzap(((Long) obj).longValue());
            case 4:
                return zzec.zzaq(((Long) obj).longValue());
            case 5:
                return zzec.zzz(((Integer) obj).intValue());
            case 6:
                return zzec.zzas(((Long) obj).longValue());
            case 7:
                return zzec.zzac(((Integer) obj).intValue());
            case 8:
                return zzec.zze(((Boolean) obj).booleanValue());
            case 9:
                return zzec.zzd((zzfx) obj);
            case 10:
                if (obj instanceof zzfc) {
                    return zzec.zza((zzfg) (zzfc) obj);
                }
                return zzec.zzc((zzfx) obj);
            case 11:
                if (obj instanceof zzdl) {
                    return zzec.zzb((zzdl) obj);
                }
                return zzec.zzah((String) obj);
            case 12:
                if (obj instanceof zzdl) {
                    return zzec.zzb((zzdl) obj);
                }
                return zzec.zzc((byte[]) obj);
            case 13:
                return zzec.zzaa(((Integer) obj).intValue());
            case 14:
                return zzec.zzad(((Integer) obj).intValue());
            case 15:
                return zzec.zzat(((Long) obj).longValue());
            case 16:
                return zzec.zzab(((Integer) obj).intValue());
            case 17:
                return zzec.zzar(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzer) {
                    return zzec.zzae(((zzer) obj).zzdj());
                }
                return zzec.zzae(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzej<?> zzej, Object obj) {
        zzhu zzgz = zzej.zzgz();
        int zzdj = zzej.zzdj();
        if (!zzej.zzhb()) {
            return zza(zzgz, zzdj, obj);
        }
        int i = 0;
        if (zzej.zzhc()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzgz, zzb);
            }
            return zzec.zzy(zzdj) + i + zzec.zzah(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzgz, zzdj, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzeh zzeh = new zzeh();
        for (int i = 0; i < this.zznp.zzis(); i++) {
            Entry zzau = this.zznp.zzau(i);
            zzeh.zza((FieldDescriptorType) (zzej) zzau.getKey(), zzau.getValue());
        }
        for (Entry entry : this.zznp.zzit()) {
            zzeh.zza((FieldDescriptorType) (zzej) entry.getKey(), entry.getValue());
        }
        zzeh.zznr = this.zznr;
        return zzeh;
    }
}
