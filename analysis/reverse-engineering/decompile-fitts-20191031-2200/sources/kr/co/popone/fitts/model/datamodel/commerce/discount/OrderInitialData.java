package kr.co.popone.fitts.model.datamodel.commerce.discount;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderInitialData implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final long eventId;
    @NotNull
    private final OrderInfoViewData orderInfo;
    @Nullable
    private final Long postId;
    @NotNull
    private final Type type;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            OrderInitialData orderInitialData = new OrderInitialData((OrderInfoViewData) OrderInfoViewData.CREATOR.createFromParcel(parcel), (Type) Enum.valueOf(Type.class, parcel.readString()), parcel.readLong(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
            return orderInitialData;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new OrderInitialData[i];
        }
    }

    public enum Type {
        CART(r2, r2),
        DIRECT("direct", "products");
        
        @NotNull
        private final String orderParam;
        @NotNull
        private final String priceParam;

        private Type(String str, String str2) {
            this.orderParam = str;
            this.priceParam = str2;
        }

        @NotNull
        public final String getOrderParam() {
            return this.orderParam;
        }

        @NotNull
        public final String getPriceParam() {
            return this.priceParam;
        }
    }

    @NotNull
    public static /* synthetic */ OrderInitialData copy$default(OrderInitialData orderInitialData, OrderInfoViewData orderInfoViewData, Type type2, long j, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            orderInfoViewData = orderInitialData.orderInfo;
        }
        if ((i & 2) != 0) {
            type2 = orderInitialData.type;
        }
        Type type3 = type2;
        if ((i & 4) != 0) {
            j = orderInitialData.eventId;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            l = orderInitialData.postId;
        }
        return orderInitialData.copy(orderInfoViewData, type3, j2, l);
    }

    @NotNull
    public final OrderInfoViewData component1() {
        return this.orderInfo;
    }

    @NotNull
    public final Type component2() {
        return this.type;
    }

    public final long component3() {
        return this.eventId;
    }

    @Nullable
    public final Long component4() {
        return this.postId;
    }

    @NotNull
    public final OrderInitialData copy(@NotNull OrderInfoViewData orderInfoViewData, @NotNull Type type2, long j, @Nullable Long l) {
        Intrinsics.checkParameterIsNotNull(orderInfoViewData, "orderInfo");
        Intrinsics.checkParameterIsNotNull(type2, "type");
        OrderInitialData orderInitialData = new OrderInitialData(orderInfoViewData, type2, j, l);
        return orderInitialData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderInitialData) {
                OrderInitialData orderInitialData = (OrderInitialData) obj;
                if (Intrinsics.areEqual((Object) this.orderInfo, (Object) orderInitialData.orderInfo) && Intrinsics.areEqual((Object) this.type, (Object) orderInitialData.type)) {
                    if (!(this.eventId == orderInitialData.eventId) || !Intrinsics.areEqual((Object) this.postId, (Object) orderInitialData.postId)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        OrderInfoViewData orderInfoViewData = this.orderInfo;
        int i = 0;
        int hashCode = (orderInfoViewData != null ? orderInfoViewData.hashCode() : 0) * 31;
        Type type2 = this.type;
        int hashCode2 = (hashCode + (type2 != null ? type2.hashCode() : 0)) * 31;
        long j = this.eventId;
        int i2 = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        Long l = this.postId;
        if (l != null) {
            i = l.hashCode();
        }
        return i2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderInitialData(orderInfo=");
        sb.append(this.orderInfo);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", eventId=");
        sb.append(this.eventId);
        sb.append(", postId=");
        sb.append(this.postId);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this.orderInfo.writeToParcel(parcel, 0);
        parcel.writeString(this.type.name());
        parcel.writeLong(this.eventId);
        Long l = this.postId;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
            return;
        }
        parcel.writeInt(0);
    }

    public OrderInitialData(@NotNull OrderInfoViewData orderInfoViewData, @NotNull Type type2, long j, @Nullable Long l) {
        Intrinsics.checkParameterIsNotNull(orderInfoViewData, "orderInfo");
        Intrinsics.checkParameterIsNotNull(type2, "type");
        this.orderInfo = orderInfoViewData;
        this.type = type2;
        this.eventId = j;
        this.postId = l;
    }

    @NotNull
    public final OrderInfoViewData getOrderInfo() {
        return this.orderInfo;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    public /* synthetic */ OrderInitialData(OrderInfoViewData orderInfoViewData, Type type2, long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            j = -1;
        }
        this(orderInfoViewData, type2, j, l);
    }

    public final long getEventId() {
        return this.eventId;
    }

    @Nullable
    public final Long getPostId() {
        return this.postId;
    }
}
