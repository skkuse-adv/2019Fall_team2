package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzeq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzeo<FieldDescriptorType extends zzeq<FieldDescriptorType>> {
    private static final zzeo zzafa = new zzeo(true);
    final zzhc<FieldDescriptorType, Object> zzaex = zzhc.zzce(16);
    private boolean zzaey;
    private boolean zzaez = false;

    private zzeo() {
    }

    private zzeo(boolean z) {
        zzry();
    }

    public static <T extends zzeq<T>> zzeo<T> zztr() {
        return zzafa;
    }

    public final void zzry() {
        if (!this.zzaey) {
            this.zzaex.zzry();
            this.zzaey = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzaey;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeo)) {
            return false;
        }
        return this.zzaex.equals(((zzeo) obj).zzaex);
    }

    public final int hashCode() {
        return this.zzaex.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzaez) {
            return new zzfo(this.zzaex.entrySet().iterator());
        }
        return this.zzaex.entrySet().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final Iterator<Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzaez) {
            return new zzfo(this.zzaex.zzwj().iterator());
        }
        return this.zzaex.zzwj().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzaex.get(fielddescriptortype);
        return obj instanceof zzfj ? zzfj.zzvc() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzty()) {
            zza(fielddescriptortype.zztw(), obj);
            r6 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(fielddescriptortype.zztw(), obj2);
            }
            r6 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r6 instanceof zzfj) {
            this.zzaez = true;
        }
        this.zzaex.put(fielddescriptortype, r6);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfj) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfc) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzig r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzez.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzer.zzafd
            com.google.android.gms.internal.measurement.zzij r2 = r2.zzwz()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgi
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfj
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfc
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzdp
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeo.zza(com.google.android.gms.internal.measurement.zzig, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzaex.zzwh(); i++) {
            if (!zzb(this.zzaex.zzcf(i))) {
                return false;
            }
        }
        for (Entry zzb : this.zzaex.zzwi()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Entry<FieldDescriptorType, Object> entry) {
        zzeq zzeq = (zzeq) entry.getKey();
        if (zzeq.zztx() == zzij.MESSAGE) {
            if (zzeq.zzty()) {
                for (zzgi isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgi) {
                    if (!((zzgi) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzfj) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzeo<FieldDescriptorType> zzeo) {
        for (int i = 0; i < zzeo.zzaex.zzwh(); i++) {
            zzc(zzeo.zzaex.zzcf(i));
        }
        for (Entry zzc : zzeo.zzaex.zzwi()) {
            zzc(zzc);
        }
    }

    private static Object zzk(Object obj) {
        if (obj instanceof zzgn) {
            return ((zzgn) obj).zzvu();
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
        zzeq zzeq = (zzeq) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfj) {
            value = zzfj.zzvc();
        }
        if (zzeq.zzty()) {
            Object zza = zza((FieldDescriptorType) zzeq);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzk : (List) value) {
                ((List) zza).add(zzk(zzk));
            }
            this.zzaex.put(zzeq, zza);
        } else if (zzeq.zztx() == zzij.MESSAGE) {
            Object zza2 = zza((FieldDescriptorType) zzeq);
            if (zza2 == null) {
                this.zzaex.put(zzeq, zzk(value));
                return;
            }
            if (zza2 instanceof zzgn) {
                obj = zzeq.zza((zzgn) zza2, (zzgn) value);
            } else {
                obj = zzeq.zza(((zzgi) zza2).zzuo(), (zzgi) value).zzug();
            }
            this.zzaex.put(zzeq, obj);
        } else {
            this.zzaex.put(zzeq, zzk(value));
        }
    }

    static void zza(zzee zzee, zzig zzig, int i, Object obj) throws IOException {
        if (zzig == zzig.GROUP) {
            zzgi zzgi = (zzgi) obj;
            zzez.zzf(zzgi);
            zzee.zzb(i, 3);
            zzgi.zzb(zzee);
            zzee.zzb(i, 4);
            return;
        }
        zzee.zzb(i, zzig.zzxa());
        switch (zzer.zzaee[zzig.ordinal()]) {
            case 1:
                zzee.zzd(((Double) obj).doubleValue());
                break;
            case 2:
                zzee.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzee.zzbn(((Long) obj).longValue());
                return;
            case 4:
                zzee.zzbn(((Long) obj).longValue());
                return;
            case 5:
                zzee.zzbe(((Integer) obj).intValue());
                return;
            case 6:
                zzee.zzbp(((Long) obj).longValue());
                return;
            case 7:
                zzee.zzbh(((Integer) obj).intValue());
                return;
            case 8:
                zzee.zzq(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgi) obj).zzb(zzee);
                return;
            case 10:
                zzee.zzb((zzgi) obj);
                return;
            case 11:
                if (obj instanceof zzdp) {
                    zzee.zza((zzdp) obj);
                    return;
                } else {
                    zzee.zzdr((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdp) {
                    zzee.zza((zzdp) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzee.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zzee.zzbf(((Integer) obj).intValue());
                return;
            case 14:
                zzee.zzbh(((Integer) obj).intValue());
                return;
            case 15:
                zzee.zzbp(((Long) obj).longValue());
                return;
            case 16:
                zzee.zzbg(((Integer) obj).intValue());
                return;
            case 17:
                zzee.zzbo(((Long) obj).longValue());
                return;
            case 18:
                if (!(obj instanceof zzfc)) {
                    zzee.zzbe(((Integer) obj).intValue());
                    break;
                } else {
                    zzee.zzbe(((zzfc) obj).zzlg());
                    return;
                }
        }
    }

    public final int zzts() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzaex.zzwh(); i2++) {
            i += zzd(this.zzaex.zzcf(i2));
        }
        for (Entry zzd : this.zzaex.zzwi()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Entry<FieldDescriptorType, Object> entry) {
        zzeq zzeq = (zzeq) entry.getKey();
        Object value = entry.getValue();
        if (zzeq.zztx() != zzij.MESSAGE || zzeq.zzty() || zzeq.zztz()) {
            return zzb(zzeq, value);
        }
        if (value instanceof zzfj) {
            return zzee.zzb(((zzeq) entry.getKey()).zzlg(), (zzfn) (zzfj) value);
        }
        return zzee.zzd(((zzeq) entry.getKey()).zzlg(), (zzgi) value);
    }

    static int zza(zzig zzig, int i, Object obj) {
        int zzbi = zzee.zzbi(i);
        if (zzig == zzig.GROUP) {
            zzez.zzf((zzgi) obj);
            zzbi <<= 1;
        }
        return zzbi + zzb(zzig, obj);
    }

    private static int zzb(zzig zzig, Object obj) {
        switch (zzer.zzaee[zzig.ordinal()]) {
            case 1:
                return zzee.zze(((Double) obj).doubleValue());
            case 2:
                return zzee.zzb(((Float) obj).floatValue());
            case 3:
                return zzee.zzbq(((Long) obj).longValue());
            case 4:
                return zzee.zzbr(((Long) obj).longValue());
            case 5:
                return zzee.zzbj(((Integer) obj).intValue());
            case 6:
                return zzee.zzbt(((Long) obj).longValue());
            case 7:
                return zzee.zzbm(((Integer) obj).intValue());
            case 8:
                return zzee.zzr(((Boolean) obj).booleanValue());
            case 9:
                return zzee.zzd((zzgi) obj);
            case 10:
                if (obj instanceof zzfj) {
                    return zzee.zza((zzfn) (zzfj) obj);
                }
                return zzee.zzc((zzgi) obj);
            case 11:
                if (obj instanceof zzdp) {
                    return zzee.zzb((zzdp) obj);
                }
                return zzee.zzds((String) obj);
            case 12:
                if (obj instanceof zzdp) {
                    return zzee.zzb((zzdp) obj);
                }
                return zzee.zzg((byte[]) obj);
            case 13:
                return zzee.zzbk(((Integer) obj).intValue());
            case 14:
                return zzee.zzbn(((Integer) obj).intValue());
            case 15:
                return zzee.zzbu(((Long) obj).longValue());
            case 16:
                return zzee.zzbl(((Integer) obj).intValue());
            case 17:
                return zzee.zzbs(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfc) {
                    return zzee.zzbo(((zzfc) obj).zzlg());
                }
                return zzee.zzbo(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzeq<?> zzeq, Object obj) {
        zzig zztw = zzeq.zztw();
        int zzlg = zzeq.zzlg();
        if (!zzeq.zzty()) {
            return zza(zztw, zzlg, obj);
        }
        int i = 0;
        if (zzeq.zztz()) {
            for (Object zzb : (List) obj) {
                i += zzb(zztw, zzb);
            }
            return zzee.zzbi(zzlg) + i + zzee.zzbq(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zztw, zzlg, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzeo zzeo = new zzeo();
        for (int i = 0; i < this.zzaex.zzwh(); i++) {
            Entry zzcf = this.zzaex.zzcf(i);
            zzeo.zza((FieldDescriptorType) (zzeq) zzcf.getKey(), zzcf.getValue());
        }
        for (Entry entry : this.zzaex.zzwi()) {
            zzeo.zza((FieldDescriptorType) (zzeq) entry.getKey(), entry.getValue());
        }
        zzeo.zzaez = this.zzaez;
        return zzeo;
    }
}
