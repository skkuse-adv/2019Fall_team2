package kotlin.ranges;

import org.jetbrains.annotations.NotNull;

public final class LongRange extends LongProgression implements ClosedRange<Long> {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    @NotNull
    public static final LongRange EMPTY = new LongRange(1, 0);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LongRange getEMPTY() {
            return LongRange.EMPTY;
        }
    }

    public LongRange(long j, long j2) {
        super(j, j2, 1);
    }

    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).longValue());
    }

    @NotNull
    public Long getStart() {
        return Long.valueOf(getFirst());
    }

    @NotNull
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    public boolean contains(long j) {
        return getFirst() <= j && j <= getLast();
    }

    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (getLast() == r6.getLast()) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlin.ranges.LongRange
            if (r0 == 0) goto L_0x002f
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlin.ranges.LongRange r0 = (kotlin.ranges.LongRange) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x002d
        L_0x0013:
            long r0 = r5.getFirst()
            kotlin.ranges.LongRange r6 = (kotlin.ranges.LongRange) r6
            long r2 = r6.getFirst()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x002f
            long r0 = r5.getLast()
            long r2 = r6.getLast()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x002f
        L_0x002d:
            r6 = 1
            goto L_0x0030
        L_0x002f:
            r6 = 0
        L_0x0030:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.LongRange.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFirst());
        sb.append("..");
        sb.append(getLast());
        return sb.toString();
    }
}
