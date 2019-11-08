package kr.co.popone.fitts.model.order;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.payment.PaymentInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderCompleteViewData implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final int depositPrice;
    private final long orderId;
    @Nullable
    private final PaymentInfo paymentInfo;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new OrderCompleteViewData(parcel.readLong(), parcel.readInt(), parcel.readInt() != 0 ? (PaymentInfo) PaymentInfo.CREATOR.createFromParcel(parcel) : null);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new OrderCompleteViewData[i];
        }
    }

    @NotNull
    public static /* synthetic */ OrderCompleteViewData copy$default(OrderCompleteViewData orderCompleteViewData, long j, int i, PaymentInfo paymentInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = orderCompleteViewData.orderId;
        }
        if ((i2 & 2) != 0) {
            i = orderCompleteViewData.depositPrice;
        }
        if ((i2 & 4) != 0) {
            paymentInfo2 = orderCompleteViewData.paymentInfo;
        }
        return orderCompleteViewData.copy(j, i, paymentInfo2);
    }

    public final long component1() {
        return this.orderId;
    }

    public final int component2() {
        return this.depositPrice;
    }

    @Nullable
    public final PaymentInfo component3() {
        return this.paymentInfo;
    }

    @NotNull
    public final OrderCompleteViewData copy(long j, int i, @Nullable PaymentInfo paymentInfo2) {
        return new OrderCompleteViewData(j, i, paymentInfo2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderCompleteViewData) {
                OrderCompleteViewData orderCompleteViewData = (OrderCompleteViewData) obj;
                if (this.orderId == orderCompleteViewData.orderId) {
                    if (!(this.depositPrice == orderCompleteViewData.depositPrice) || !Intrinsics.areEqual((Object) this.paymentInfo, (Object) orderCompleteViewData.paymentInfo)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.orderId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.depositPrice) * 31;
        PaymentInfo paymentInfo2 = this.paymentInfo;
        return i + (paymentInfo2 != null ? paymentInfo2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderCompleteViewData(orderId=");
        sb.append(this.orderId);
        sb.append(", depositPrice=");
        sb.append(this.depositPrice);
        sb.append(", paymentInfo=");
        sb.append(this.paymentInfo);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.orderId);
        parcel.writeInt(this.depositPrice);
        PaymentInfo paymentInfo2 = this.paymentInfo;
        if (paymentInfo2 != null) {
            parcel.writeInt(1);
            paymentInfo2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public OrderCompleteViewData(long j, int i, @Nullable PaymentInfo paymentInfo2) {
        this.orderId = j;
        this.depositPrice = i;
        this.paymentInfo = paymentInfo2;
    }

    public final long getOrderId() {
        return this.orderId;
    }

    public final int getDepositPrice() {
        return this.depositPrice;
    }

    @Nullable
    public final PaymentInfo getPaymentInfo() {
        return this.paymentInfo;
    }
}
