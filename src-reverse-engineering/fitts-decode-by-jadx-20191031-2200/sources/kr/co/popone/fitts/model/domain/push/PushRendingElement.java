package kr.co.popone.fitts.model.domain.push;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PushRendingElement implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @Nullable
    private final Long lineItemVariantId;
    @Nullable
    private final Long orderId;
    @NotNull
    private final PushRendingState pushRendingState;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            Long l = null;
            Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            if (parcel.readInt() != 0) {
                l = Long.valueOf(parcel.readLong());
            }
            return new PushRendingElement(valueOf, l, (PushRendingState) Enum.valueOf(PushRendingState.class, parcel.readString()));
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new PushRendingElement[i];
        }
    }

    @NotNull
    public static /* synthetic */ PushRendingElement copy$default(PushRendingElement pushRendingElement, Long l, Long l2, PushRendingState pushRendingState2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = pushRendingElement.orderId;
        }
        if ((i & 2) != 0) {
            l2 = pushRendingElement.lineItemVariantId;
        }
        if ((i & 4) != 0) {
            pushRendingState2 = pushRendingElement.pushRendingState;
        }
        return pushRendingElement.copy(l, l2, pushRendingState2);
    }

    @Nullable
    public final Long component1() {
        return this.orderId;
    }

    @Nullable
    public final Long component2() {
        return this.lineItemVariantId;
    }

    @NotNull
    public final PushRendingState component3() {
        return this.pushRendingState;
    }

    @NotNull
    public final PushRendingElement copy(@Nullable Long l, @Nullable Long l2, @NotNull PushRendingState pushRendingState2) {
        Intrinsics.checkParameterIsNotNull(pushRendingState2, "pushRendingState");
        return new PushRendingElement(l, l2, pushRendingState2);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.pushRendingState, (java.lang.Object) r3.pushRendingState) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.domain.push.PushRendingElement
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.domain.push.PushRendingElement r3 = (kr.co.popone.fitts.model.domain.push.PushRendingElement) r3
            java.lang.Long r0 = r2.orderId
            java.lang.Long r1 = r3.orderId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.Long r0 = r2.lineItemVariantId
            java.lang.Long r1 = r3.lineItemVariantId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.domain.push.PushRendingState r0 = r2.pushRendingState
            kr.co.popone.fitts.model.domain.push.PushRendingState r3 = r3.pushRendingState
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            return r3
        L_0x0029:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.domain.push.PushRendingElement.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Long l = this.orderId;
        int i = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.lineItemVariantId;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        PushRendingState pushRendingState2 = this.pushRendingState;
        if (pushRendingState2 != null) {
            i = pushRendingState2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushRendingElement(orderId=");
        sb.append(this.orderId);
        sb.append(", lineItemVariantId=");
        sb.append(this.lineItemVariantId);
        sb.append(", pushRendingState=");
        sb.append(this.pushRendingState);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Long l = this.orderId;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        Long l2 = this.lineItemVariantId;
        if (l2 != null) {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.pushRendingState.name());
    }

    public PushRendingElement(@Nullable Long l, @Nullable Long l2, @NotNull PushRendingState pushRendingState2) {
        Intrinsics.checkParameterIsNotNull(pushRendingState2, "pushRendingState");
        this.orderId = l;
        this.lineItemVariantId = l2;
        this.pushRendingState = pushRendingState2;
    }

    @Nullable
    public final Long getOrderId() {
        return this.orderId;
    }

    @Nullable
    public final Long getLineItemVariantId() {
        return this.lineItemVariantId;
    }

    @NotNull
    public final PushRendingState getPushRendingState() {
        return this.pushRendingState;
    }
}
