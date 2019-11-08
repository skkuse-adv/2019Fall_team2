package com.google.android.gms.internal.firebase_remote_config;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzie extends zzfr<Long> implements zzhn<Long>, zzjc, RandomAccess {
    private int size;
    private long[] zzvg;

    zzie() {
        this(new long[10], 0);
    }

    private zzie(long[] jArr, int i) {
        this.zzvg = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzet();
        if (i2 >= i) {
            long[] jArr = this.zzvg;
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
        if (!(obj instanceof zzie)) {
            return super.equals(obj);
        }
        zzie zzie = (zzie) obj;
        if (this.size != zzie.size) {
            return false;
        }
        long[] jArr = zzie.zzvg;
        for (int i = 0; i < this.size; i++) {
            if (this.zzvg[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzhm.zzo(this.zzvg[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzs(i);
        return this.zzvg[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzp(long j) {
        zzk(this.size, j);
    }

    private final void zzk(int i, long j) {
        zzet();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                long[] jArr = this.zzvg;
                if (i2 < jArr.length) {
                    System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
                } else {
                    long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(jArr, 0, jArr2, 0, i);
                    System.arraycopy(this.zzvg, i, jArr2, i + 1, this.size - i);
                    this.zzvg = jArr2;
                }
                this.zzvg[i] = j;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzt(i));
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzet();
        zzhm.checkNotNull(collection);
        if (!(collection instanceof zzie)) {
            return super.addAll(collection);
        }
        zzie zzie = (zzie) collection;
        int i = zzie.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzvg;
            if (i3 > jArr.length) {
                this.zzvg = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzie.zzvg, 0, this.zzvg, this.size, zzie.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzet();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzvg[i]))) {
                long[] jArr = this.zzvg;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzs(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzt(i));
        }
    }

    private final String zzt(int i) {
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
        zzet();
        zzs(i);
        long[] jArr = this.zzvg;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzet();
        zzs(i);
        long[] jArr = this.zzvg;
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

    public final /* synthetic */ zzhn zzu(int i) {
        if (i >= this.size) {
            return new zzie(Arrays.copyOf(this.zzvg, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        new zzie(new long[0], 0).zzes();
    }
}
