package kr.co.popone.fitts.model.datamodel.commerce.order;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.Mappable;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData.Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderDiscountInfo implements Mappable<String, Object> {
    public static final Companion Companion = new Companion(null);
    private final Long couponId;
    private final Integer fittsPoint;
    private final boolean fromCart;
    private final Long membershipId;
    private final Long specialDiscountId;
    private final String specialDiscountType;
    private final String variantJson;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: new reason: not valid java name */
        public final OrderDiscountInfo m151new(@NotNull OrderInitialData orderInitialData) {
            Intrinsics.checkParameterIsNotNull(orderInitialData, "orderInitialData");
            String variantsJson = orderInitialData.getOrderInfo().getVariantsJson();
            Long l = null;
            String str = orderInitialData.getEventId() != -1 ? "special_discount" : null;
            if (orderInitialData.getEventId() != -1) {
                l = Long.valueOf(orderInitialData.getEventId());
            }
            OrderDiscountInfo orderDiscountInfo = new OrderDiscountInfo(variantsJson, str, l, null, null, null, orderInitialData.getType() == Type.CART);
            return orderDiscountInfo;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
        @org.jetbrains.annotations.NotNull
        /* renamed from: new reason: not valid java name */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kr.co.popone.fitts.model.datamodel.commerce.order.OrderDiscountInfo m152new(@org.jetbrains.annotations.NotNull kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData r10, @org.jetbrains.annotations.NotNull kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r11) {
            /*
                r9 = this;
                java.lang.String r0 = "orderInitialData"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
                java.lang.String r0 = "discount"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
                kr.co.popone.fitts.model.datamodel.commerce.order.OrderDiscountInfo r0 = new kr.co.popone.fitts.model.datamodel.commerce.order.OrderDiscountInfo
                kr.co.popone.fitts.model.order.OrderInfoViewData r1 = r10.getOrderInfo()
                java.lang.String r2 = r1.getVariantsJson()
                kr.co.popone.fitts.model.datamodel.commerce.discount.Discount$Type r1 = r11.getType()
                kr.co.popone.fitts.model.datamodel.commerce.discount.Discount$Type r3 = kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.Type.POINT
                r4 = 0
                if (r1 != r3) goto L_0x0023
                java.lang.Integer r1 = r11.getPointValue()
                r5 = r1
                goto L_0x0024
            L_0x0023:
                r5 = r4
            L_0x0024:
                kr.co.popone.fitts.model.datamodel.commerce.discount.Discount$Type r1 = r11.getType()
                kr.co.popone.fitts.model.datamodel.commerce.discount.Discount$Type r3 = kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.Type.COUPON
                if (r1 != r3) goto L_0x003c
                kr.co.popone.fitts.model.coupon.CouponAPI$CouponInfo r1 = r11.getCoupon()
                if (r1 == 0) goto L_0x003c
                long r6 = r1.getId()
                java.lang.Long r1 = java.lang.Long.valueOf(r6)
                r6 = r1
                goto L_0x003d
            L_0x003c:
                r6 = r4
            L_0x003d:
                kr.co.popone.fitts.model.datamodel.commerce.discount.Discount$Type r1 = r11.getType()
                kr.co.popone.fitts.model.datamodel.commerce.discount.Discount$Type r3 = kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.Type.MEMBERSHIP
                if (r1 != r3) goto L_0x0055
                kr.co.popone.fitts.model.datamodel.social.membership.Membership r11 = r11.getMembership()
                if (r11 == 0) goto L_0x0055
                long r3 = r11.getId()
                java.lang.Long r11 = java.lang.Long.valueOf(r3)
                r7 = r11
                goto L_0x0056
            L_0x0055:
                r7 = r4
            L_0x0056:
                kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData$Type r10 = r10.getType()
                kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData$Type r11 = kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData.Type.CART
                if (r10 != r11) goto L_0x0061
                r10 = 1
                r8 = 1
                goto L_0x0063
            L_0x0061:
                r10 = 0
                r8 = 0
            L_0x0063:
                r3 = 0
                r4 = 0
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.commerce.order.OrderDiscountInfo.Companion.m152new(kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData, kr.co.popone.fitts.model.datamodel.commerce.discount.Discount):kr.co.popone.fitts.model.datamodel.commerce.order.OrderDiscountInfo");
        }
    }

    @NotNull
    public static /* synthetic */ OrderDiscountInfo copy$default(OrderDiscountInfo orderDiscountInfo, String str, String str2, Long l, Integer num, Long l2, Long l3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderDiscountInfo.variantJson;
        }
        if ((i & 2) != 0) {
            str2 = orderDiscountInfo.specialDiscountType;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            l = orderDiscountInfo.specialDiscountId;
        }
        Long l4 = l;
        if ((i & 8) != 0) {
            num = orderDiscountInfo.fittsPoint;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            l2 = orderDiscountInfo.couponId;
        }
        Long l5 = l2;
        if ((i & 32) != 0) {
            l3 = orderDiscountInfo.membershipId;
        }
        Long l6 = l3;
        if ((i & 64) != 0) {
            z = orderDiscountInfo.fromCart;
        }
        return orderDiscountInfo.copy(str, str3, l4, num2, l5, l6, z);
    }

    @NotNull
    public final OrderDiscountInfo copy(@Nullable String str, @Nullable String str2, @Nullable Long l, @Nullable Integer num, @Nullable Long l2, @Nullable Long l3, boolean z) {
        OrderDiscountInfo orderDiscountInfo = new OrderDiscountInfo(str, str2, l, num, l2, l3, z);
        return orderDiscountInfo;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderDiscountInfo) {
                OrderDiscountInfo orderDiscountInfo = (OrderDiscountInfo) obj;
                if (Intrinsics.areEqual((Object) this.variantJson, (Object) orderDiscountInfo.variantJson) && Intrinsics.areEqual((Object) this.specialDiscountType, (Object) orderDiscountInfo.specialDiscountType) && Intrinsics.areEqual((Object) this.specialDiscountId, (Object) orderDiscountInfo.specialDiscountId) && Intrinsics.areEqual((Object) this.fittsPoint, (Object) orderDiscountInfo.fittsPoint) && Intrinsics.areEqual((Object) this.couponId, (Object) orderDiscountInfo.couponId) && Intrinsics.areEqual((Object) this.membershipId, (Object) orderDiscountInfo.membershipId)) {
                    if (this.fromCart == orderDiscountInfo.fromCart) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.variantJson;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.specialDiscountType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.specialDiscountId;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.fittsPoint;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Long l2 = this.couponId;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.membershipId;
        if (l3 != null) {
            i = l3.hashCode();
        }
        int i2 = (hashCode5 + i) * 31;
        boolean z = this.fromCart;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderDiscountInfo(variantJson=");
        sb.append(this.variantJson);
        sb.append(", specialDiscountType=");
        sb.append(this.specialDiscountType);
        sb.append(", specialDiscountId=");
        sb.append(this.specialDiscountId);
        sb.append(", fittsPoint=");
        sb.append(this.fittsPoint);
        sb.append(", couponId=");
        sb.append(this.couponId);
        sb.append(", membershipId=");
        sb.append(this.membershipId);
        sb.append(", fromCart=");
        sb.append(this.fromCart);
        sb.append(")");
        return sb.toString();
    }

    public OrderDiscountInfo(@Nullable String str, @Nullable String str2, @Nullable Long l, @Nullable Integer num, @Nullable Long l2, @Nullable Long l3, boolean z) {
        this.variantJson = str;
        this.specialDiscountType = str2;
        this.specialDiscountId = l;
        this.fittsPoint = num;
        this.couponId = l2;
        this.membershipId = l3;
        this.fromCart = z;
    }

    @Nullable
    public final String getVariantJson() {
        return this.variantJson;
    }

    @NotNull
    public final String getSpecialDiscountType() {
        Long l = this.specialDiscountId;
        return ((l != null && l.longValue() == -1) || this.specialDiscountId == null) ? "normal" : "special_discount";
    }

    @Nullable
    public final Long getSpecialDiscountId() {
        return this.specialDiscountId;
    }

    @Nullable
    public final Integer getFittsPoint() {
        return this.fittsPoint;
    }

    @Nullable
    public final Long getCouponId() {
        return this.couponId;
    }

    @Nullable
    public final Long getMembershipId() {
        return this.membershipId;
    }

    public final boolean isFromCart() {
        return this.fromCart;
    }

    @NotNull
    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        String str = this.variantJson;
        if (str != null) {
            hashMap.put("variants", str);
        }
        String str2 = this.specialDiscountType;
        if (str2 != null) {
            hashMap.put("type", str2);
        }
        Long l = this.specialDiscountId;
        if (l != null) {
            hashMap.put("type_id", String.valueOf(l.longValue()));
        }
        Integer num = this.fittsPoint;
        if (num != null) {
            hashMap.put("fitts_point", String.valueOf(num.intValue()));
        }
        Long l2 = this.couponId;
        if (l2 != null) {
            hashMap.put("coupon_id", String.valueOf(l2.longValue()));
        }
        Long l3 = this.membershipId;
        if (l3 != null) {
            hashMap.put("membership_id", String.valueOf(l3.longValue()));
        }
        return hashMap;
    }
}
