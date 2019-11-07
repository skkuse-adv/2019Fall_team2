package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzeu extends zzdj<Float> implements zzff<Float>, zzgu, RandomAccess {
    private int size;
    private float[] zzahn;

    zzeu() {
        this(new float[10], 0);
    }

    private zzeu(float[] fArr, int i) {
        this.zzahn = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzrz();
        if (i2 >= i) {
            float[] fArr = this.zzahn;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
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
        if (!(obj instanceof zzeu)) {
            return super.equals(obj);
        }
        zzeu zzeu = (zzeu) obj;
        if (this.size != zzeu.size) {
            return false;
        }
        float[] fArr = zzeu.zzahn;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzahn[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzahn[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }

    private final void zzc(int i, float f) {
        zzrz();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                float[] fArr = this.zzahn;
                if (i2 < fArr.length) {
                    System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
                } else {
                    float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(fArr, 0, fArr2, 0, i);
                    System.arraycopy(this.zzahn, i, fArr2, i + 1, this.size - i);
                    this.zzahn = fArr2;
                }
                this.zzahn[i] = f;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzao(i));
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzrz();
        zzez.checkNotNull(collection);
        if (!(collection instanceof zzeu)) {
            return super.addAll(collection);
        }
        zzeu zzeu = (zzeu) collection;
        int i = zzeu.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzahn;
            if (i3 > fArr.length) {
                this.zzahn = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzeu.zzahn, 0, this.zzahn, this.size, zzeu.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzrz();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzahn[i]))) {
                float[] fArr = this.zzahn;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
        float floatValue = ((Float) obj).floatValue();
        zzrz();
        zzan(i);
        float[] fArr = this.zzahn;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzrz();
        zzan(i);
        float[] fArr = this.zzahn;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    public final /* synthetic */ zzff zzap(int i) {
        if (i >= this.size) {
            return new zzeu(Arrays.copyOf(this.zzahn, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzan(i);
        return Float.valueOf(this.zzahn[i]);
    }

    static {
        new zzeu(new float[0], 0).zzry();
    }
}
