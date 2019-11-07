package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfw extends zzdj<Long> implements zzfg, zzgu, RandomAccess {
    private static final zzfw zzajy;
    private int size;
    private long[] zzajz;

    public static zzfw zzvk() {
        return zzajy;
    }

    zzfw() {
        this(new long[10], 0);
    }

    private zzfw(long[] jArr, int i) {
        this.zzajz = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzrz();
        if (i2 >= i) {
            long[] jArr = this.zzajz;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return super.equals(obj);
        }
        zzfw zzfw = (zzfw) obj;
        if (this.size != zzfw.size) {
            return false;
        }
        long[] jArr = zzfw.zzajz;
        for (int i = 0; i < this.size; i++) {
            if (this.zzajz[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzez.zzbx(this.zzajz[i2]);
        }
        return i;
    }

    /* renamed from: zzbv */
    public final zzfg zzap(int i) {
        if (i >= this.size) {
            return new zzfw(Arrays.copyOf(this.zzajz, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final long getLong(int i) {
        zzan(i);
        return this.zzajz[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzby(long j) {
        zzk(this.size, j);
    }

    private final void zzk(int i, long j) {
        zzrz();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                long[] jArr = this.zzajz;
                if (i2 < jArr.length) {
                    System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
                } else {
                    long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(jArr, 0, jArr2, 0, i);
                    System.arraycopy(this.zzajz, i, jArr2, i + 1, this.size - i);
                    this.zzajz = jArr2;
                }
                this.zzajz[i] = j;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzao(i));
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzrz();
        zzez.checkNotNull(collection);
        if (!(collection instanceof zzfw)) {
            return super.addAll(collection);
        }
        zzfw zzfw = (zzfw) collection;
        int i = zzfw.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzajz;
            if (i3 > jArr.length) {
                this.zzajz = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzfw.zzajz, 0, this.zzajz, this.size, zzfw.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzrz();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzajz[i]))) {
                long[] jArr = this.zzajz;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzan(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzao(i));
        }
    }

    private final String zzao(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzrz();
        zzan(i);
        long[] jArr = this.zzajz;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzrz();
        zzan(i);
        long[] jArr = this.zzajz;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzk(i, ((Long) obj).longValue());
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzfw zzfw = new zzfw(new long[0], 0);
        zzajy = zzfw;
        zzfw.zzry();
    }
}
