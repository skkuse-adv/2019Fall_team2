package com.google.android.gms.internal.firebase-perf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzff extends zzdk<String> implements zzfi, RandomAccess {
    private static final zzff zzsc;
    private final List<Object> zzse;

    public zzff() {
        this(10);
    }

    public zzff(int i) {
        this(new ArrayList<>(i));
    }

    private zzff(ArrayList<Object> arrayList) {
        this.zzse = arrayList;
    }

    public final int size() {
        return this.zzse.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzgg();
        if (collection instanceof zzfi) {
            collection = ((zzfi) collection).zzhv();
        }
        boolean addAll = this.zzse.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzgg();
        this.zzse.clear();
        this.modCount++;
    }

    public final void zzc(zzdl zzdl) {
        zzgg();
        this.zzse.add(zzdl);
        this.modCount++;
    }

    public final Object getRaw(int i) {
        return this.zzse.get(i);
    }

    private static String zzg(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdl) {
            return ((zzdl) obj).zzgh();
        }
        return zzes.zze((byte[]) obj);
    }

    public final List<?> zzhv() {
        return Collections.unmodifiableList(this.zzse);
    }

    public final zzfi zzhw() {
        return zzge() ? new zzhh(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        String str = (String) obj;
        zzgg();
        return zzg(this.zzse.set(i, str));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        zzgg();
        Object remove = this.zzse.remove(i);
        this.modCount++;
        return zzg(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzge() {
        return super.zzge();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        String str = (String) obj;
        zzgg();
        this.zzse.add(i, str);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzey zzao(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzse);
            return new zzff(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzse.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdl) {
            zzdl zzdl = (zzdl) obj;
            String zzgh = zzdl.zzgh();
            if (zzdl.zzgi()) {
                this.zzse.set(i, zzgh);
            }
            return zzgh;
        }
        byte[] bArr = (byte[]) obj;
        String zze = zzes.zze(bArr);
        if (zzes.zzd(bArr)) {
            this.zzse.set(i, zze);
        }
        return zze;
    }

    static {
        zzff zzff = new zzff();
        zzsc = zzff;
        zzff.zzgf();
    }
}
