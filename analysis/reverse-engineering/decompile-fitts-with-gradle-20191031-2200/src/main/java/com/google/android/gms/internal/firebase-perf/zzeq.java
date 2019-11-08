package com.google.android.gms.internal.firebase-perf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzeq extends zzdk<Integer> implements zzew, zzgk, RandomAccess {
    private static final zzeq zzqt;
    private int size;
    private int[] zzqu;

    public static zzeq zzhq() {
        return zzqt;
    }

    zzeq() {
        this(new int[10], 0);
    }

    private zzeq(int[] iArr, int i) {
        this.zzqu = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzgg();
        if (i2 >= i) {
            int[] iArr = this.zzqu;
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
        if (!(obj instanceof zzeq)) {
            return super.equals(obj);
        }
        zzeq zzeq = (zzeq) obj;
        if (this.size != zzeq.size) {
            return false;
        }
        int[] iArr = zzeq.zzqu;
        for (int i = 0; i < this.size; i++) {
            if (this.zzqu[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzqu[i2];
        }
        return i;
    }

    /* renamed from: zzak */
    public final zzew zzao(int i) {
        if (i >= this.size) {
            return new zzeq(Arrays.copyOf(this.zzqu, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final int getInt(int i) {
        zzam(i);
        return this.zzqu[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzal(int i) {
        zzs(this.size, i);
    }

    private final void zzs(int i, int i2) {
        zzgg();
        if (i >= 0) {
            int i3 = this.size;
            if (i <= i3) {
                int[] iArr = this.zzqu;
                if (i3 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
                } else {
                    int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    System.arraycopy(this.zzqu, i, iArr2, i + 1, this.size - i);
                    this.zzqu = iArr2;
                }
                this.zzqu[i] = i2;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzan(i));
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzgg();
        zzes.checkNotNull(collection);
        if (!(collection instanceof zzeq)) {
            return super.addAll(collection);
        }
        zzeq zzeq = (zzeq) collection;
        int i = zzeq.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzqu;
            if (i3 > iArr.length) {
                this.zzqu = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzeq.zzqu, 0, this.zzqu, this.size, zzeq.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzgg();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzqu[i]))) {
                int[] iArr = this.zzqu;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
        int intValue = ((Integer) obj).intValue();
        zzgg();
        zzam(i);
        int[] iArr = this.zzqu;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzgg();
        zzam(i);
        int[] iArr = this.zzqu;
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
        zzs(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzeq zzeq = new zzeq(new int[0], 0);
        zzqt = zzeq;
        zzeq.zzgf();
    }
}
