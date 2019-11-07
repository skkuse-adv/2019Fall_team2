package kr.co.popone.fitts.model.order;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostableOrderLineItemVariant {
    @SerializedName("maximum_add_points_for_now_post")
    private final int additionalMaxPoint;
    @SerializedName("maximum_points_for_now_post")
    private final int currentMaxPoint;
    @SerializedName("postable_olivs")
    @NotNull
    private final List<OrderListLineItemVariant> postableOlivs;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.order.OrderListLineItemVariant>, for r3v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.order.PostableOrderLineItemVariant copy$default(kr.co.popone.fitts.model.order.PostableOrderLineItemVariant r0, int r1, int r2, java.util.List<kr.co.popone.fitts.model.order.OrderListLineItemVariant> r3, int r4, java.lang.Object r5) {
        /*
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            int r1 = r0.currentMaxPoint
        L_0x0006:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000c
            int r2 = r0.additionalMaxPoint
        L_0x000c:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0012
            java.util.List<kr.co.popone.fitts.model.order.OrderListLineItemVariant> r3 = r0.postableOlivs
        L_0x0012:
            kr.co.popone.fitts.model.order.PostableOrderLineItemVariant r0 = r0.copy(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.order.PostableOrderLineItemVariant.copy$default(kr.co.popone.fitts.model.order.PostableOrderLineItemVariant, int, int, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.order.PostableOrderLineItemVariant");
    }

    public final int component1() {
        return this.currentMaxPoint;
    }

    public final int component2() {
        return this.additionalMaxPoint;
    }

    @NotNull
    public final List<OrderListLineItemVariant> component3() {
        return this.postableOlivs;
    }

    @NotNull
    public final PostableOrderLineItemVariant copy(int i, int i2, @NotNull List<OrderListLineItemVariant> list) {
        Intrinsics.checkParameterIsNotNull(list, "postableOlivs");
        return new PostableOrderLineItemVariant(i, i2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PostableOrderLineItemVariant) {
                PostableOrderLineItemVariant postableOrderLineItemVariant = (PostableOrderLineItemVariant) obj;
                if (this.currentMaxPoint == postableOrderLineItemVariant.currentMaxPoint) {
                    if (!(this.additionalMaxPoint == postableOrderLineItemVariant.additionalMaxPoint) || !Intrinsics.areEqual((Object) this.postableOlivs, (Object) postableOrderLineItemVariant.postableOlivs)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.currentMaxPoint * 31) + this.additionalMaxPoint) * 31;
        List<OrderListLineItemVariant> list = this.postableOlivs;
        return i + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostableOrderLineItemVariant(currentMaxPoint=");
        sb.append(this.currentMaxPoint);
        sb.append(", additionalMaxPoint=");
        sb.append(this.additionalMaxPoint);
        sb.append(", postableOlivs=");
        sb.append(this.postableOlivs);
        sb.append(")");
        return sb.toString();
    }

    public PostableOrderLineItemVariant(int i, int i2, @NotNull List<OrderListLineItemVariant> list) {
        Intrinsics.checkParameterIsNotNull(list, "postableOlivs");
        this.currentMaxPoint = i;
        this.additionalMaxPoint = i2;
        this.postableOlivs = list;
    }

    public final int getCurrentMaxPoint() {
        return this.currentMaxPoint;
    }

    public final int getAdditionalMaxPoint() {
        return this.additionalMaxPoint;
    }

    @NotNull
    public final List<OrderListLineItemVariant> getPostableOlivs() {
        return this.postableOlivs;
    }
}
