package com.google.android.gms.internal.firebase_remote_config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzhy extends zzfr<String> implements zzhx, RandomAccess {
    private static final zzhy zzux;
    private final List<Object> zzuz;

    public zzhy() {
        this(10);
    }

    public zzhy(int i) {
        this(new ArrayList<>(i));
    }

    private zzhy(ArrayList<Object> arrayList) {
        this.zzuz = arrayList;
    }

    public final int size() {
        return this.zzuz.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzet();
        if (collection instanceof zzhx) {
            collection = ((zzhx) collection).zzhq();
        }
        boolean addAll = this.zzuz.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzet();
        this.zzuz.clear();
        this.modCount++;
    }

    public final void zzd(zzfx zzfx) {
        zzet();
        this.zzuz.add(zzfx);
        this.modCount++;
    }

    public final Object zzbd(int i) {
        return this.zzuz.get(i);
    }

    private static String zzo(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfx) {
            return ((zzfx) obj).zzb(zzhm.UTF_8);
        }
        return zzhm.zzf((byte[]) obj);
    }

    public final List<?> zzhq() {
        return Collections.unmodifiableList(this.zzuz);
    }

    public final zzhx zzhr() {
        return zzer() ? new zzkc(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        String str = (String) obj;
        zzet();
        return zzo(this.zzuz.set(i, str));
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
        zzet();
        Object remove = this.zzuz.remove(i);
        this.modCount++;
        return zzo(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzer() {
        return super.zzer();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        String str = (String) obj;
        zzet();
        this.zzuz.add(i, str);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzhn zzu(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzuz);
            return new zzhy(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzuz.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfx) {
            zzfx zzfx = (zzfx) obj;
            String zzb = zzfx.zzb(zzhm.UTF_8);
            if (zzfx.zzew()) {
                this.zzuz.set(i, zzb);
            }
            return zzb;
        }
        byte[] bArr = (byte[]) obj;
        String zzf = zzhm.zzf(bArr);
        if (zzhm.zze(bArr)) {
            this.zzuz.set(i, zzf);
        }
        return zzf;
    }

    static {
        zzhy zzhy = new zzhy();
        zzux = zzhy;
        zzhy.zzes();
    }
}
