package kotlin.ranges;

import org.jetbrains.annotations.NotNull;

final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    private final float _endInclusive;
    private final float _start;

    public boolean lessThanOrEquals(float f, float f2) {
        return f <= f2;
    }

    public ClosedFloatRange(float f, float f2) {
        this._start = f;
        this._endInclusive = f2;
    }

    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).floatValue());
    }

    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        return lessThanOrEquals(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    @NotNull
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    @NotNull
    public Float getEndInclusive() {
        return Float.valueOf(this._endInclusive);
    }

    public boolean contains(float f) {
        return f >= this._start && f <= this._endInclusive;
    }

    public boolean isEmpty() {
        return this._start > this._endInclusive;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (r2._endInclusive == r3._endInclusive) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof kotlin.ranges.ClosedFloatRange
            if (r0 == 0) goto L_0x0027
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0013
            r0 = r3
            kotlin.ranges.ClosedFloatRange r0 = (kotlin.ranges.ClosedFloatRange) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0025
        L_0x0013:
            float r0 = r2._start
            kotlin.ranges.ClosedFloatRange r3 = (kotlin.ranges.ClosedFloatRange) r3
            float r1 = r3._start
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0027
            float r0 = r2._endInclusive
            float r3 = r3._endInclusive
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0027
        L_0x0025:
            r3 = 1
            goto L_0x0028
        L_0x0027:
            r3 = 0
        L_0x0028:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.ClosedFloatRange.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this._start).hashCode() * 31) + Float.valueOf(this._endInclusive).hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._start);
        sb.append("..");
        sb.append(this._endInclusive);
        return sb.toString();
    }
}
