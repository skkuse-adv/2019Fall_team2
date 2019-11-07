package com.google.android.gms.internal.firebase_remote_config;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzhk extends zzfr<Integer> implements zzhn<Integer>, zzjc, RandomAccess {
    private int size;
    private int[] zztl;

    zzhk() {
        this(new int[10], 0);
    }

    private zzhk(int[] iArr, int i) {
        this.zztl = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzet();
        if (i2 >= i) {
            int[] iArr = this.zztl;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
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
        if (!(obj instanceof zzhk)) {
            return super.equals(obj);
        }
        zzhk zzhk = (zzhk) obj;
        if (this.size != zzhk.size) {
            return false;
        }
        int[] iArr = zzhk.zztl;
        for (int i = 0; i < this.size; i++) {
            if (this.zztl[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zztl[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzs(i);
        return this.zztl[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzbb(int i) {
        zzp(this.size, i);
    }

    private final void zzp(int i, int i2) {
        zzet();
        if (i >= 0) {
            int i3 = this.size;
            if (i <= i3) {
                int[] iArr = this.zztl;
                if (i3 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
                } else {
                    int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    System.arraycopy(this.zztl, i, iArr2, i + 1, this.size - i);
                    this.zztl = iArr2;
                }
                this.zztl[i] = i2;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzt(i));
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzet();
        zzhm.checkNotNull(collection);
        if (!(collection instanceof zzhk)) {
            return super.addAll(collection);
        }
        zzhk zzhk = (zzhk) collection;
        int i = zzhk.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zztl;
            if (i3 > iArr.length) {
                this.zztl = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzhk.zztl, 0, this.zztl, this.size, zzhk.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzet();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zztl[i]))) {
                int[] iArr = this.zztl;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
        int intValue = ((Integer) obj).intValue();
        zzet();
        zzs(i);
        int[] iArr = this.zztl;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzet();
        zzs(i);
        int[] iArr = this.zztl;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzp(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ zzhn zzu(int i) {
        if (i >= this.size) {
            return new zzhk(Arrays.copyOf(this.zztl, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        new zzhk(new int[0], 0).zzes();
    }
}
