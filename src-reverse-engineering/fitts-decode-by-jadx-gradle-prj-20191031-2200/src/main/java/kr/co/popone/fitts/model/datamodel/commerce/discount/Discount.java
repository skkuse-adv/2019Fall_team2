package kr.co.popone.fitts.model.datamodel.commerce.discount;

import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Discount {
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final CouponInfo coupon;
    @Nullable
    private final Membership membership;
    @Nullable
    private final Integer pointValue;
    @Nullable
    private final Type type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public static /* synthetic */ Discount new$default(Companion companion, Type type, Integer num, CouponInfo couponInfo, Membership membership, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                couponInfo = null;
            }
            return companion.m146new(type, num, couponInfo, membership);
        }

        @NotNull
        /* renamed from: new reason: not valid java name */
        public final Discount m146new(@Nullable Type type, @Nullable Integer num, @Nullable CouponInfo couponInfo, @Nullable Membership membership) {
            return new Discount(type, num, couponInfo, membership);
        }

        @NotNull
        public final Discount empty() {
            return new Discount(null, null, null, null);
        }
    }

    public enum Type {
        POINT,
        COUPON,
        MEMBERSHIP
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.POINT.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.COUPON.ordinal()] = 2;
            $EnumSwitchMapping$0[Type.MEMBERSHIP.ordinal()] = 3;
        }
    }

    public Discount() {
        this(null, null, null, null, 15, null);
    }

    @NotNull
    public static /* synthetic */ Discount copy$default(Discount discount, Type type2, Integer num, CouponInfo couponInfo, Membership membership2, int i, Object obj) {
        if ((i & 1) != 0) {
            type2 = discount.type;
        }
        if ((i & 2) != 0) {
            num = discount.pointValue;
        }
        if ((i & 4) != 0) {
            couponInfo = discount.coupon;
        }
        if ((i & 8) != 0) {
            membership2 = discount.membership;
        }
        return discount.copy(type2, num, couponInfo, membership2);
    }

    @Nullable
    public final Type component1() {
        return this.type;
    }

    @Nullable
    public final Integer component2() {
        return this.pointValue;
    }

    @Nullable
    public final CouponInfo component3() {
        return this.coupon;
    }

    @Nullable
    public final Membership component4() {
        return this.membership;
    }

    @NotNull
    public final Discount copy(@Nullable Type type2, @Nullable Integer num, @Nullable CouponInfo couponInfo, @Nullable Membership membership2) {
        return new Discount(type2, num, couponInfo, membership2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.membership, (java.lang.Object) r3.membership) != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0033
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.commerce.discount.Discount
            if (r0 == 0) goto L_0x0031
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r3 = (kr.co.popone.fitts.model.datamodel.commerce.discount.Discount) r3
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount$Type r0 = r2.type
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount$Type r1 = r3.type
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.Integer r0 = r2.pointValue
            java.lang.Integer r1 = r3.pointValue
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            kr.co.popone.fitts.model.coupon.CouponAPI$CouponInfo r0 = r2.coupon
            kr.co.popone.fitts.model.coupon.CouponAPI$CouponInfo r1 = r3.coupon
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            kr.co.popone.fitts.model.datamodel.social.membership.Membership r0 = r2.membership
            kr.co.popone.fitts.model.datamodel.social.membership.Membership r3 = r3.membership
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Type type2 = this.type;
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Integer num = this.pointValue;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        CouponInfo couponInfo = this.coupon;
        int hashCode3 = (hashCode2 + (couponInfo != null ? couponInfo.hashCode() : 0)) * 31;
        Membership membership2 = this.membership;
        if (membership2 != null) {
            i = membership2.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Discount(type=");
        sb.append(this.type);
        sb.append(", pointValue=");
        sb.append(this.pointValue);
        sb.append(", coupon=");
        sb.append(this.coupon);
        sb.append(", membership=");
        sb.append(this.membership);
        sb.append(")");
        return sb.toString();
    }

    public Discount(@Nullable Type type2, @Nullable Integer num, @Nullable CouponInfo couponInfo, @Nullable Membership membership2) {
        this.type = type2;
        this.pointValue = num;
        this.coupon = couponInfo;
        this.membership = membership2;
    }

    @Nullable
    public final Type getType() {
        return this.type;
    }

    @Nullable
    public final Integer getPointValue() {
        return this.pointValue;
    }

    @Nullable
    public final CouponInfo getCoupon() {
        return this.coupon;
    }

    public /* synthetic */ Discount(Type type2, Integer num, CouponInfo couponInfo, Membership membership2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            type2 = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            couponInfo = null;
        }
        if ((i & 8) != 0) {
            membership2 = null;
        }
        this(type2, num, couponInfo, membership2);
    }

    @Nullable
    public final Membership getMembership() {
        return this.membership;
    }

    @Nullable
    public final String getTypeParameter() {
        Type type2 = this.type;
        if (type2 == null) {
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3 && this.membership != null) {
                    return "membership";
                }
                return null;
            } else if (this.coupon == null) {
                return null;
            } else {
                return "coupon";
            }
        } else if (this.pointValue == null) {
            return null;
        } else {
            return "point";
        }
    }
}
