package kr.co.popone.fitts.model.domain.payment;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PaymentModuleData implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @Nullable
    private final Integer adjustPrice;
    @Nullable
    private final String adjustType;
    @NotNull
    private final String buyerContact;
    @Nullable
    private final String buyerEmail;
    @NotNull
    private final String buyerName;
    @Nullable
    private final Long couponId;
    @Nullable
    private final Long eventId;
    @NotNull
    private final String from;
    @Nullable
    private final Long membershipId;
    @Nullable
    private final Long postId;
    @NotNull
    private final String shippingAddress;
    @NotNull
    private final String shippingAddress2;
    @NotNull
    private final String shippingContact;
    @Nullable
    private final String shippingMessage;
    @NotNull
    private final String shippingName;
    @NotNull
    private final String shippingZipCode;
    @NotNull
    private final String type;
    @NotNull
    private final String variantsJson;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            PaymentModuleData paymentModuleData = new PaymentModuleData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
            return paymentModuleData;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new PaymentModuleData[i];
        }
    }

    @NotNull
    public static /* synthetic */ PaymentModuleData copy$default(PaymentModuleData paymentModuleData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Integer num, Long l, Long l2, Long l3, Long l4, int i, Object obj) {
        PaymentModuleData paymentModuleData2 = paymentModuleData;
        int i2 = i;
        return paymentModuleData.copy((i2 & 1) != 0 ? paymentModuleData2.type : str, (i2 & 2) != 0 ? paymentModuleData2.from : str2, (i2 & 4) != 0 ? paymentModuleData2.variantsJson : str3, (i2 & 8) != 0 ? paymentModuleData2.buyerName : str4, (i2 & 16) != 0 ? paymentModuleData2.buyerContact : str5, (i2 & 32) != 0 ? paymentModuleData2.buyerEmail : str6, (i2 & 64) != 0 ? paymentModuleData2.shippingName : str7, (i2 & 128) != 0 ? paymentModuleData2.shippingContact : str8, (i2 & 256) != 0 ? paymentModuleData2.shippingZipCode : str9, (i2 & 512) != 0 ? paymentModuleData2.shippingAddress : str10, (i2 & 1024) != 0 ? paymentModuleData2.shippingAddress2 : str11, (i2 & 2048) != 0 ? paymentModuleData2.shippingMessage : str12, (i2 & 4096) != 0 ? paymentModuleData2.adjustType : str13, (i2 & 8192) != 0 ? paymentModuleData2.adjustPrice : num, (i2 & 16384) != 0 ? paymentModuleData2.couponId : l, (i2 & 32768) != 0 ? paymentModuleData2.membershipId : l2, (i2 & 65536) != 0 ? paymentModuleData2.postId : l3, (i2 & 131072) != 0 ? paymentModuleData2.eventId : l4);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final String component10() {
        return this.shippingAddress;
    }

    @NotNull
    public final String component11() {
        return this.shippingAddress2;
    }

    @Nullable
    public final String component12() {
        return this.shippingMessage;
    }

    @Nullable
    public final String component13() {
        return this.adjustType;
    }

    @Nullable
    public final Integer component14() {
        return this.adjustPrice;
    }

    @Nullable
    public final Long component15() {
        return this.couponId;
    }

    @Nullable
    public final Long component16() {
        return this.membershipId;
    }

    @Nullable
    public final Long component17() {
        return this.postId;
    }

    @Nullable
    public final Long component18() {
        return this.eventId;
    }

    @NotNull
    public final String component2() {
        return this.from;
    }

    @NotNull
    public final String component3() {
        return this.variantsJson;
    }

    @NotNull
    public final String component4() {
        return this.buyerName;
    }

    @NotNull
    public final String component5() {
        return this.buyerContact;
    }

    @Nullable
    public final String component6() {
        return this.buyerEmail;
    }

    @NotNull
    public final String component7() {
        return this.shippingName;
    }

    @NotNull
    public final String component8() {
        return this.shippingContact;
    }

    @NotNull
    public final String component9() {
        return this.shippingZipCode;
    }

    @NotNull
    public final PaymentModuleData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @Nullable String str12, @Nullable String str13, @Nullable Integer num, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
        String str14 = str;
        String str15 = str2;
        String str16 = str3;
        String str17 = str4;
        String str18 = str5;
        String str19 = str6;
        String str20 = str7;
        String str21 = str8;
        String str22 = str9;
        String str23 = str10;
        String str24 = str11;
        String str25 = str12;
        String str26 = str13;
        Integer num2 = num;
        Long l5 = l;
        Long l6 = l2;
        Long l7 = l3;
        Long l8 = l4;
        String str27 = str14;
        Intrinsics.checkParameterIsNotNull(str14, "type");
        Intrinsics.checkParameterIsNotNull(str2, "from");
        Intrinsics.checkParameterIsNotNull(str3, "variantsJson");
        Intrinsics.checkParameterIsNotNull(str4, "buyerName");
        Intrinsics.checkParameterIsNotNull(str5, "buyerContact");
        Intrinsics.checkParameterIsNotNull(str7, "shippingName");
        Intrinsics.checkParameterIsNotNull(str8, "shippingContact");
        Intrinsics.checkParameterIsNotNull(str9, "shippingZipCode");
        Intrinsics.checkParameterIsNotNull(str10, "shippingAddress");
        Intrinsics.checkParameterIsNotNull(str11, "shippingAddress2");
        PaymentModuleData paymentModuleData = new PaymentModuleData(str27, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, num2, l5, l6, l7, l8);
        return paymentModuleData;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ba, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.eventId, (java.lang.Object) r3.eventId) != false) goto L_0x00bf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x00bf
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.domain.payment.PaymentModuleData
            if (r0 == 0) goto L_0x00bd
            kr.co.popone.fitts.model.domain.payment.PaymentModuleData r3 = (kr.co.popone.fitts.model.domain.payment.PaymentModuleData) r3
            java.lang.String r0 = r2.type
            java.lang.String r1 = r3.type
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.from
            java.lang.String r1 = r3.from
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.variantsJson
            java.lang.String r1 = r3.variantsJson
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.buyerName
            java.lang.String r1 = r3.buyerName
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.buyerContact
            java.lang.String r1 = r3.buyerContact
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.buyerEmail
            java.lang.String r1 = r3.buyerEmail
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.shippingName
            java.lang.String r1 = r3.shippingName
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.shippingContact
            java.lang.String r1 = r3.shippingContact
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.shippingZipCode
            java.lang.String r1 = r3.shippingZipCode
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.shippingAddress
            java.lang.String r1 = r3.shippingAddress
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.shippingAddress2
            java.lang.String r1 = r3.shippingAddress2
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.shippingMessage
            java.lang.String r1 = r3.shippingMessage
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r2.adjustType
            java.lang.String r1 = r3.adjustType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.Integer r0 = r2.adjustPrice
            java.lang.Integer r1 = r3.adjustPrice
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.Long r0 = r2.couponId
            java.lang.Long r1 = r3.couponId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.Long r0 = r2.membershipId
            java.lang.Long r1 = r3.membershipId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.Long r0 = r2.postId
            java.lang.Long r1 = r3.postId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00bd
            java.lang.Long r0 = r2.eventId
            java.lang.Long r3 = r3.eventId
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r3 = 0
            return r3
        L_0x00bf:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.domain.payment.PaymentModuleData.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.from;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.variantsJson;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.buyerName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.buyerContact;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.buyerEmail;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.shippingName;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.shippingContact;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.shippingZipCode;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.shippingAddress;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.shippingAddress2;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.shippingMessage;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.adjustType;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        Integer num = this.adjustPrice;
        int hashCode14 = (hashCode13 + (num != null ? num.hashCode() : 0)) * 31;
        Long l = this.couponId;
        int hashCode15 = (hashCode14 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.membershipId;
        int hashCode16 = (hashCode15 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.postId;
        int hashCode17 = (hashCode16 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.eventId;
        if (l4 != null) {
            i = l4.hashCode();
        }
        return hashCode17 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentModuleData(type=");
        sb.append(this.type);
        sb.append(", from=");
        sb.append(this.from);
        sb.append(", variantsJson=");
        sb.append(this.variantsJson);
        sb.append(", buyerName=");
        sb.append(this.buyerName);
        sb.append(", buyerContact=");
        sb.append(this.buyerContact);
        sb.append(", buyerEmail=");
        sb.append(this.buyerEmail);
        sb.append(", shippingName=");
        sb.append(this.shippingName);
        sb.append(", shippingContact=");
        sb.append(this.shippingContact);
        sb.append(", shippingZipCode=");
        sb.append(this.shippingZipCode);
        sb.append(", shippingAddress=");
        sb.append(this.shippingAddress);
        sb.append(", shippingAddress2=");
        sb.append(this.shippingAddress2);
        sb.append(", shippingMessage=");
        sb.append(this.shippingMessage);
        sb.append(", adjustType=");
        sb.append(this.adjustType);
        sb.append(", adjustPrice=");
        sb.append(this.adjustPrice);
        sb.append(", couponId=");
        sb.append(this.couponId);
        sb.append(", membershipId=");
        sb.append(this.membershipId);
        sb.append(", postId=");
        sb.append(this.postId);
        sb.append(", eventId=");
        sb.append(this.eventId);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeString(this.from);
        parcel.writeString(this.variantsJson);
        parcel.writeString(this.buyerName);
        parcel.writeString(this.buyerContact);
        parcel.writeString(this.buyerEmail);
        parcel.writeString(this.shippingName);
        parcel.writeString(this.shippingContact);
        parcel.writeString(this.shippingZipCode);
        parcel.writeString(this.shippingAddress);
        parcel.writeString(this.shippingAddress2);
        parcel.writeString(this.shippingMessage);
        parcel.writeString(this.adjustType);
        Integer num = this.adjustPrice;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Long l = this.couponId;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        Long l2 = this.membershipId;
        if (l2 != null) {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        } else {
            parcel.writeInt(0);
        }
        Long l3 = this.postId;
        if (l3 != null) {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        } else {
            parcel.writeInt(0);
        }
        Long l4 = this.eventId;
        if (l4 != null) {
            parcel.writeInt(1);
            parcel.writeLong(l4.longValue());
            return;
        }
        parcel.writeInt(0);
    }

    public PaymentModuleData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @Nullable String str12, @Nullable String str13, @Nullable Integer num, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
        String str14 = str;
        String str15 = str2;
        String str16 = str3;
        String str17 = str4;
        String str18 = str5;
        String str19 = str7;
        String str20 = str8;
        String str21 = str9;
        String str22 = str10;
        String str23 = str11;
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(str2, "from");
        Intrinsics.checkParameterIsNotNull(str3, "variantsJson");
        Intrinsics.checkParameterIsNotNull(str17, "buyerName");
        Intrinsics.checkParameterIsNotNull(str18, "buyerContact");
        Intrinsics.checkParameterIsNotNull(str19, "shippingName");
        Intrinsics.checkParameterIsNotNull(str20, "shippingContact");
        Intrinsics.checkParameterIsNotNull(str21, "shippingZipCode");
        Intrinsics.checkParameterIsNotNull(str22, "shippingAddress");
        Intrinsics.checkParameterIsNotNull(str23, "shippingAddress2");
        this.type = str14;
        this.from = str15;
        this.variantsJson = str16;
        this.buyerName = str17;
        this.buyerContact = str18;
        this.buyerEmail = str6;
        this.shippingName = str19;
        this.shippingContact = str20;
        this.shippingZipCode = str21;
        this.shippingAddress = str22;
        this.shippingAddress2 = str23;
        this.shippingMessage = str12;
        this.adjustType = str13;
        this.adjustPrice = num;
        this.couponId = l;
        this.membershipId = l2;
        this.postId = l3;
        this.eventId = l4;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    @NotNull
    public final String getVariantsJson() {
        return this.variantsJson;
    }

    @NotNull
    public final String getBuyerName() {
        return this.buyerName;
    }

    @NotNull
    public final String getBuyerContact() {
        return this.buyerContact;
    }

    @Nullable
    public final String getBuyerEmail() {
        return this.buyerEmail;
    }

    @NotNull
    public final String getShippingName() {
        return this.shippingName;
    }

    @NotNull
    public final String getShippingContact() {
        return this.shippingContact;
    }

    @NotNull
    public final String getShippingZipCode() {
        return this.shippingZipCode;
    }

    @NotNull
    public final String getShippingAddress() {
        return this.shippingAddress;
    }

    @NotNull
    public final String getShippingAddress2() {
        return this.shippingAddress2;
    }

    @Nullable
    public final String getShippingMessage() {
        return this.shippingMessage;
    }

    @Nullable
    public final String getAdjustType() {
        return this.adjustType;
    }

    @Nullable
    public final Integer getAdjustPrice() {
        return this.adjustPrice;
    }

    @Nullable
    public final Long getCouponId() {
        return this.couponId;
    }

    @Nullable
    public final Long getMembershipId() {
        return this.membershipId;
    }

    @Nullable
    public final Long getPostId() {
        return this.postId;
    }

    @Nullable
    public final Long getEventId() {
        return this.eventId;
    }
}
