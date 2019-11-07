package kotlin.ranges;

import java.lang.Comparable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange.DefaultImpls;
import org.jetbrains.annotations.NotNull;

class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {
    @NotNull
    private final T endInclusive;
    @NotNull
    private final T start;

    public ComparableRange(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkParameterIsNotNull(t, "start");
        Intrinsics.checkParameterIsNotNull(t2, "endInclusive");
        this.start = t;
        this.endInclusive = t2;
    }

    public boolean contains(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "value");
        return DefaultImpls.contains(this, t);
    }

    public boolean isEmpty() {
        return DefaultImpls.isEmpty(this);
    }

    @NotNull
    public T getStart() {
        return this.start;
    }

    @NotNull
    public T getEndInclusive() {
        return this.endInclusive;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) getEndInclusive(), (java.lang.Object) r3.getEndInclusive()) != false) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof kotlin.ranges.ComparableRange
            if (r0 == 0) goto L_0x0033
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0013
            r0 = r3
            kotlin.ranges.ComparableRange r0 = (kotlin.ranges.ComparableRange) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0031
        L_0x0013:
            java.lang.Comparable r0 = r2.getStart()
            kotlin.ranges.ComparableRange r3 = (kotlin.ranges.ComparableRange) r3
            java.lang.Comparable r1 = r3.getStart()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0033
            java.lang.Comparable r0 = r2.getEndInclusive()
            java.lang.Comparable r3 = r3.getEndInclusive()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0033
        L_0x0031:
            r3 = 1
            goto L_0x0034
        L_0x0033:
            r3 = 0
        L_0x0034:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.ComparableRange.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getStart());
        sb.append("..");
        sb.append(getEndInclusive());
        return sb.toString();
    }
}
