package com.google.android.gms.internal.firebase_remote_config;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgt extends zzfr<Double> implements zzhn<Double>, zzjc, RandomAccess {
    private int size;
    private double[] zzpy;

    zzgt() {
        this(new double[10], 0);
    }

    private zzgt(double[] dArr, int i) {
        this.zzpy = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzet();
        if (i2 >= i) {
            double[] dArr = this.zzpy;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
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
        if (!(obj instanceof zzgt)) {
            return super.equals(obj);
        }
        zzgt zzgt = (zzgt) obj;
        if (this.size != zzgt.size) {
            return false;
        }
        double[] dArr = zzgt.zzpy;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzpy[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzhm.zzo(Double.doubleToLongBits(this.zzpy[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zze(double d) {
        zzc(this.size, d);
    }

    private final void zzc(int i, double d) {
        zzet();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                double[] dArr = this.zzpy;
                if (i2 < dArr.length) {
                    System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
                } else {
                    double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(dArr, 0, dArr2, 0, i);
                    System.arraycopy(this.zzpy, i, dArr2, i + 1, this.size - i);
                    this.zzpy = dArr2;
                }
                this.zzpy[i] = d;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzt(i));
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzet();
        zzhm.checkNotNull(collection);
        if (!(collection instanceof zzgt)) {
            return super.addAll(collection);
        }
        zzgt zzgt = (zzgt) collection;
        int i = zzgt.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzpy;
            if (i3 > dArr.length) {
                this.zzpy = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzgt.zzpy, 0, this.zzpy, this.size, zzgt.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzet();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzpy[i]))) {
                double[] dArr = this.zzpy;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzet();
        zzs(i);
        double[] dArr = this.zzpy;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        zzet();
        zzs(i);
        double[] dArr = this.zzpy;
        double d = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Double) obj).doubleValue());
    }

    public final /* synthetic */ zzhn zzu(int i) {
        if (i >= this.size) {
            return new zzgt(Arrays.copyOf(this.zzpy, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzs(i);
        return Double.valueOf(this.zzpy[i]);
    }

    static {
        new zzgt(new double[0], 0).zzes();
    }
}
