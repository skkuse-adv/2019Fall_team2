package kr.co.popone.fitts.model.datamodel.social.point;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ExpectedReceivablePoint {
    public static final Companion Companion = new Companion(null);
    @SerializedName("predict_post_income")
    @NotNull
    private final String expectedNCommercePoint;
    @SerializedName("predict_post_points")
    @NotNull
    private final String expectedPostingPoint;
    @SerializedName("predict_fitts_points")
    @NotNull
    private final String expectedReceivablePoint;
    @SerializedName("predict_mileage")
    @NotNull
    private final String expectedShoppingPoint;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExpectedReceivablePoint newEmpty() {
            String str = "0";
            return new ExpectedReceivablePoint(str, str, str, str);
        }
    }

    @NotNull
    public static /* synthetic */ ExpectedReceivablePoint copy$default(ExpectedReceivablePoint expectedReceivablePoint2, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = expectedReceivablePoint2.expectedReceivablePoint;
        }
        if ((i & 2) != 0) {
            str2 = expectedReceivablePoint2.expectedShoppingPoint;
        }
        if ((i & 4) != 0) {
            str3 = expectedReceivablePoint2.expectedPostingPoint;
        }
        if ((i & 8) != 0) {
            str4 = expectedReceivablePoint2.expectedNCommercePoint;
        }
        return expectedReceivablePoint2.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.expectedReceivablePoint;
    }

    @NotNull
    public final String component2() {
        return this.expectedShoppingPoint;
    }

    @NotNull
    public final String component3() {
        return this.expectedPostingPoint;
    }

    @NotNull
    public final String component4() {
        return this.expectedNCommercePoint;
    }

    @NotNull
    public final ExpectedReceivablePoint copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "expectedReceivablePoint");
        Intrinsics.checkParameterIsNotNull(str2, "expectedShoppingPoint");
        Intrinsics.checkParameterIsNotNull(str3, "expectedPostingPoint");
        Intrinsics.checkParameterIsNotNull(str4, "expectedNCommercePoint");
        return new ExpectedReceivablePoint(str, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.expectedNCommercePoint, (java.lang.Object) r3.expectedNCommercePoint) != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0033
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint
            if (r0 == 0) goto L_0x0031
            kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint r3 = (kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint) r3
            java.lang.String r0 = r2.expectedReceivablePoint
            java.lang.String r1 = r3.expectedReceivablePoint
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.expectedShoppingPoint
            java.lang.String r1 = r3.expectedShoppingPoint
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.expectedPostingPoint
            java.lang.String r1 = r3.expectedPostingPoint
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.expectedNCommercePoint
            java.lang.String r3 = r3.expectedNCommercePoint
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            return r3
        L_0x0033:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.expectedReceivablePoint;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.expectedShoppingPoint;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expectedPostingPoint;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.expectedNCommercePoint;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExpectedReceivablePoint(expectedReceivablePoint=");
        sb.append(this.expectedReceivablePoint);
        sb.append(", expectedShoppingPoint=");
        sb.append(this.expectedShoppingPoint);
        sb.append(", expectedPostingPoint=");
        sb.append(this.expectedPostingPoint);
        sb.append(", expectedNCommercePoint=");
        sb.append(this.expectedNCommercePoint);
        sb.append(")");
        return sb.toString();
    }

    public ExpectedReceivablePoint(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "expectedReceivablePoint");
        Intrinsics.checkParameterIsNotNull(str2, "expectedShoppingPoint");
        Intrinsics.checkParameterIsNotNull(str3, "expectedPostingPoint");
        Intrinsics.checkParameterIsNotNull(str4, "expectedNCommercePoint");
        this.expectedReceivablePoint = str;
        this.expectedShoppingPoint = str2;
        this.expectedPostingPoint = str3;
        this.expectedNCommercePoint = str4;
    }

    @NotNull
    public final String getExpectedReceivablePoint() {
        return this.expectedReceivablePoint;
    }

    @NotNull
    public final String getExpectedShoppingPoint() {
        return this.expectedShoppingPoint;
    }

    @NotNull
    public final String getExpectedPostingPoint() {
        return this.expectedPostingPoint;
    }

    @NotNull
    public final String getExpectedNCommercePoint() {
        return this.expectedNCommercePoint;
    }
}
