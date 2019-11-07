package kotlin.text;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

public final class MatchGroup {
    @NotNull
    private final IntRange range;
    @NotNull
    private final String value;

    @NotNull
    public static /* synthetic */ MatchGroup copy$default(MatchGroup matchGroup, String str, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            str = matchGroup.value;
        }
        if ((i & 2) != 0) {
            intRange = matchGroup.range;
        }
        return matchGroup.copy(str, intRange);
    }

    @NotNull
    public final String component1() {
        return this.value;
    }

    @NotNull
    public final IntRange component2() {
        return this.range;
    }

    @NotNull
    public final MatchGroup copy(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        return new MatchGroup(str, intRange);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.range, (java.lang.Object) r3.range) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kotlin.text.MatchGroup
            if (r0 == 0) goto L_0x001d
            kotlin.text.MatchGroup r3 = (kotlin.text.MatchGroup) r3
            java.lang.String r0 = r2.value
            java.lang.String r1 = r3.value
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            kotlin.ranges.IntRange r0 = r2.range
            kotlin.ranges.IntRange r3 = r3.range
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.MatchGroup.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.value;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        IntRange intRange = this.range;
        if (intRange != null) {
            i = intRange.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MatchGroup(value=");
        sb.append(this.value);
        sb.append(", range=");
        sb.append(this.range);
        sb.append(")");
        return sb.toString();
    }

    public MatchGroup(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        this.value = str;
        this.range = intRange;
    }

    @NotNull
    public final IntRange getRange() {
        return this.range;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
