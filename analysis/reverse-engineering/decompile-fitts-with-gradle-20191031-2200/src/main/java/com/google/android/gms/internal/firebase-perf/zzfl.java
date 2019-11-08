package com.google.android.gms.internal.firebase-perf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfl extends zzdk<Long> implements zzey<Long>, zzgk, RandomAccess {
    private int size;
    private long[] zzsm;

    zzfl() {
        this(new long[10], 0);
    }

    private zzfl(long[] jArr, int i) {
        this.zzsm = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzgg();
        if (i2 >= i) {
            long[] jArr = this.zzsm;
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
        if (!(obj instanceof zzfl)) {
            return super.equals(obj);
        }
        zzfl zzfl = (zzfl) obj;
        if (this.size != zzfl.size) {
            return false;
        }
        long[] jArr = zzfl.zzsm;
        for (int i = 0; i < this.size; i++) {
            if (this.zzsm[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzes.zzav(this.zzsm[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzam(i);
        return this.zzsm[i];
    }

    public final int size() {
        return this.size;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzgg();
        zzes.checkNotNull(collection);
        if (!(collection instanceof zzfl)) {
            return super.addAll(collection);
        }
        zzfl zzfl = (zzfl) collection;
        int i = zzfl.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzsm;
            if (i3 > jArr.length) {
                this.zzsm = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzfl.zzsm, 0, this.zzsm, this.size, zzfl.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzgg();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzsm[i]))) {
                long[] jArr = this.zzsm;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzam(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzan(i));
        }
    }

    private final String zzan(int i) {
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
        zzgg();
        zzam(i);
        long[] jArr = this.zzsm;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzgg();
        zzam(i);
        long[] jArr = this.zzsm;
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
        long longValue = ((Long) obj).longValue();
        zzgg();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                long[] jArr = this.zzsm;
                if (i2 < jArr.length) {
                    System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
                } else {
                    long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(jArr, 0, jArr2, 0, i);
                    System.arraycopy(this.zzsm, i, jArr2, i + 1, this.size - i);
                    this.zzsm = jArr2;
                }
                this.zzsm[i] = longValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzan(i));
    }

    public final /* synthetic */ zzey zzao(int i) {
        if (i >= this.size) {
            return new zzfl(Arrays.copyOf(this.zzsm, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        new zzfl(new long[0], 0).zzgf();
    }
}
