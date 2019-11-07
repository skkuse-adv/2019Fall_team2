package kr.co.popone.fitts.model.payment;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.Single;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.datamodel.commerce.Product;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PaymentAPI {

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class CouponEnrollResult {
        @SerializedName("id")
        private final int id;

        @NotNull
        public static /* synthetic */ CouponEnrollResult copy$default(CouponEnrollResult couponEnrollResult, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = couponEnrollResult.id;
            }
            return couponEnrollResult.copy(i);
        }

        public final int component1() {
            return this.id;
        }

        @NotNull
        public final CouponEnrollResult copy(int i) {
            return new CouponEnrollResult(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof CouponEnrollResult) {
                    if (this.id == ((CouponEnrollResult) obj).id) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.id;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CouponEnrollResult(id=");
            sb.append(this.id);
            sb.append(")");
            return sb.toString();
        }

        public CouponEnrollResult(int i) {
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }
    }

    public static final class DefaultImpls {
        @NotNull
        @GET("/api/v9/payments/invoices")
        @Headers({"Accept: application/json"})
        public static /* synthetic */ Single requestPaymentInvoiceList$default(PaymentAPI paymentAPI, Long l, Integer num, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    l = null;
                }
                if ((i & 2) != 0) {
                    num = null;
                }
                if ((i & 4) != 0) {
                    str = null;
                }
                return paymentAPI.requestPaymentInvoiceList(l, num, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestPaymentInvoiceList");
        }

        @NotNull
        @GET("/api/v9/payments/history")
        @Headers({"Accept: application/json"})
        public static /* synthetic */ Single requestPaymentHistoryList$default(PaymentAPI paymentAPI, Long l, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    l = null;
                }
                if ((i & 2) != 0) {
                    num = null;
                }
                return paymentAPI.requestPaymentHistoryList(l, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestPaymentHistoryList");
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class PaymentHistory {
        @SerializedName("created_at")
        @NotNull
        private final Date createdAt;
        @SerializedName("id")
        private final long id;
        @SerializedName("message")
        @NotNull
        private final String message;
        @SerializedName("type")
        @NotNull
        private final String type;
        @SerializedName("value")
        private final int value;

        @NotNull
        public static /* synthetic */ PaymentHistory copy$default(PaymentHistory paymentHistory, long j, String str, int i, String str2, Date date, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = paymentHistory.id;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                str = paymentHistory.type;
            }
            String str3 = str;
            if ((i2 & 4) != 0) {
                i = paymentHistory.value;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                str2 = paymentHistory.message;
            }
            String str4 = str2;
            if ((i2 & 16) != 0) {
                date = paymentHistory.createdAt;
            }
            return paymentHistory.copy(j2, str3, i3, str4, date);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.type;
        }

        public final int component3() {
            return this.value;
        }

        @NotNull
        public final String component4() {
            return this.message;
        }

        @NotNull
        public final Date component5() {
            return this.createdAt;
        }

        @NotNull
        public final PaymentHistory copy(long j, @NotNull String str, int i, @NotNull String str2, @NotNull Date date) {
            Intrinsics.checkParameterIsNotNull(str, "type");
            Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            Intrinsics.checkParameterIsNotNull(date, "createdAt");
            PaymentHistory paymentHistory = new PaymentHistory(j, str, i, str2, date);
            return paymentHistory;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof PaymentHistory) {
                    PaymentHistory paymentHistory = (PaymentHistory) obj;
                    if ((this.id == paymentHistory.id) && Intrinsics.areEqual((Object) this.type, (Object) paymentHistory.type)) {
                        if (!(this.value == paymentHistory.value) || !Intrinsics.areEqual((Object) this.message, (Object) paymentHistory.message) || !Intrinsics.areEqual((Object) this.createdAt, (Object) paymentHistory.createdAt)) {
                            return false;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.type;
            int i2 = 0;
            int hashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.value) * 31;
            String str2 = this.message;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Date date = this.createdAt;
            if (date != null) {
                i2 = date.hashCode();
            }
            return hashCode2 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PaymentHistory(id=");
            sb.append(this.id);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(", value=");
            sb.append(this.value);
            sb.append(", message=");
            sb.append(this.message);
            sb.append(", createdAt=");
            sb.append(this.createdAt);
            sb.append(")");
            return sb.toString();
        }

        public PaymentHistory(long j, @NotNull String str, int i, @NotNull String str2, @NotNull Date date) {
            Intrinsics.checkParameterIsNotNull(str, "type");
            Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            Intrinsics.checkParameterIsNotNull(date, "createdAt");
            this.id = j;
            this.type = str;
            this.value = i;
            this.message = str2;
            this.createdAt = date;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        public final int getValue() {
            return this.value;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @NotNull
        public final Date getCreatedAt() {
            return this.createdAt;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class PaymentUsage {
        @SerializedName("balance")
        private final int balance;
        @SerializedName("color")
        @Nullable
        private final String color;
        @SerializedName("completed_at")
        @Nullable
        private final Date completedAt;
        @SerializedName("coupon")
        @Nullable
        private final CouponInfo coupon;
        @SerializedName("created_at")
        @NotNull
        private final Date createdAt;
        @SerializedName("id")
        private final long id;
        @SerializedName("link_url")
        @NotNull
        private final String linkUrl;
        @SerializedName("price")
        private final int price;
        @SerializedName("product")
        @Nullable
        private final Product product;
        @SerializedName("rejected_at")
        @Nullable
        private final Date rejectedAt;
        @SerializedName("reject_description")
        @Nullable
        private final String rejectedDescription;
        @SerializedName("shipped_at")
        @Nullable
        private final Date shippedAt;
        @SerializedName("shipping_address")
        @NotNull
        private final String shippingAddress;
        @SerializedName("shipping_address2")
        @Nullable
        private final String shippingAddress2;
        @SerializedName("shipping_contact")
        @NotNull
        private final String shippingContact;
        @SerializedName("shipping_message")
        @Nullable
        private final String shippingMessage;
        @SerializedName("shipping_name")
        @NotNull
        private final String shippingName;
        @SerializedName("shipping_price")
        private final int shippingPrice;
        @SerializedName("shipping_zipcode")
        @Nullable
        private final String shippingZipCode;
        @SerializedName("size")
        @Nullable
        private final String size;
        @SerializedName("status")
        @NotNull
        private final Status status;
        @SerializedName("user")
        @NotNull
        private final User user;

        public enum Status {
            PENDING,
            REJECTED,
            COMPLETED
        }

        @NotNull
        public static /* synthetic */ PaymentUsage copy$default(PaymentUsage paymentUsage, long j, User user2, CouponInfo couponInfo, int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Product product2, Status status2, Date date, Date date2, String str10, Date date3, Date date4, int i4, Object obj) {
            PaymentUsage paymentUsage2 = paymentUsage;
            int i5 = i4;
            return paymentUsage.copy((i5 & 1) != 0 ? paymentUsage2.id : j, (i5 & 2) != 0 ? paymentUsage2.user : user2, (i5 & 4) != 0 ? paymentUsage2.coupon : couponInfo, (i5 & 8) != 0 ? paymentUsage2.price : i, (i5 & 16) != 0 ? paymentUsage2.shippingPrice : i2, (i5 & 32) != 0 ? paymentUsage2.balance : i3, (i5 & 64) != 0 ? paymentUsage2.color : str, (i5 & 128) != 0 ? paymentUsage2.size : str2, (i5 & 256) != 0 ? paymentUsage2.shippingName : str3, (i5 & 512) != 0 ? paymentUsage2.shippingContact : str4, (i5 & 1024) != 0 ? paymentUsage2.shippingAddress : str5, (i5 & 2048) != 0 ? paymentUsage2.shippingAddress2 : str6, (i5 & 4096) != 0 ? paymentUsage2.shippingZipCode : str7, (i5 & 8192) != 0 ? paymentUsage2.shippingMessage : str8, (i5 & 16384) != 0 ? paymentUsage2.linkUrl : str9, (i5 & 32768) != 0 ? paymentUsage2.product : product2, (i5 & 65536) != 0 ? paymentUsage2.status : status2, (i5 & 131072) != 0 ? paymentUsage2.shippedAt : date, (i5 & 262144) != 0 ? paymentUsage2.completedAt : date2, (i5 & 524288) != 0 ? paymentUsage2.rejectedDescription : str10, (i5 & 1048576) != 0 ? paymentUsage2.rejectedAt : date3, (i5 & 2097152) != 0 ? paymentUsage2.createdAt : date4);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component10() {
            return this.shippingContact;
        }

        @NotNull
        public final String component11() {
            return this.shippingAddress;
        }

        @Nullable
        public final String component12() {
            return this.shippingAddress2;
        }

        @Nullable
        public final String component13() {
            return this.shippingZipCode;
        }

        @Nullable
        public final String component14() {
            return this.shippingMessage;
        }

        @NotNull
        public final String component15() {
            return this.linkUrl;
        }

        @Nullable
        public final Product component16() {
            return this.product;
        }

        @NotNull
        public final Status component17() {
            return this.status;
        }

        @Nullable
        public final Date component18() {
            return this.shippedAt;
        }

        @Nullable
        public final Date component19() {
            return this.completedAt;
        }

        @NotNull
        public final User component2() {
            return this.user;
        }

        @Nullable
        public final String component20() {
            return this.rejectedDescription;
        }

        @Nullable
        public final Date component21() {
            return this.rejectedAt;
        }

        @NotNull
        public final Date component22() {
            return this.createdAt;
        }

        @Nullable
        public final CouponInfo component3() {
            return this.coupon;
        }

        public final int component4() {
            return this.price;
        }

        public final int component5() {
            return this.shippingPrice;
        }

        public final int component6() {
            return this.balance;
        }

        @Nullable
        public final String component7() {
            return this.color;
        }

        @Nullable
        public final String component8() {
            return this.size;
        }

        @NotNull
        public final String component9() {
            return this.shippingName;
        }

        @NotNull
        public final PaymentUsage copy(long j, @NotNull User user2, @Nullable CouponInfo couponInfo, int i, int i2, int i3, @Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @NotNull String str9, @Nullable Product product2, @NotNull Status status2, @Nullable Date date, @Nullable Date date2, @Nullable String str10, @Nullable Date date3, @NotNull Date date4) {
            long j2 = j;
            User user3 = user2;
            CouponInfo couponInfo2 = couponInfo;
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            String str11 = str;
            String str12 = str2;
            String str13 = str3;
            String str14 = str4;
            String str15 = str5;
            String str16 = str6;
            String str17 = str7;
            String str18 = str8;
            String str19 = str9;
            Product product3 = product2;
            Status status3 = status2;
            Date date5 = date;
            Date date6 = date2;
            String str20 = str10;
            Date date7 = date3;
            Date date8 = date4;
            Intrinsics.checkParameterIsNotNull(user2, "user");
            Intrinsics.checkParameterIsNotNull(str3, "shippingName");
            Intrinsics.checkParameterIsNotNull(str4, "shippingContact");
            Intrinsics.checkParameterIsNotNull(str5, "shippingAddress");
            Intrinsics.checkParameterIsNotNull(str9, "linkUrl");
            Intrinsics.checkParameterIsNotNull(status2, "status");
            Intrinsics.checkParameterIsNotNull(date4, "createdAt");
            PaymentUsage paymentUsage = new PaymentUsage(j, user3, couponInfo2, i4, i5, i6, str11, str12, str13, str14, str15, str16, str17, str18, str19, product3, status3, date5, date6, str20, date7, date8);
            return paymentUsage;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof PaymentUsage) {
                    PaymentUsage paymentUsage = (PaymentUsage) obj;
                    if ((this.id == paymentUsage.id) && Intrinsics.areEqual((Object) this.user, (Object) paymentUsage.user) && Intrinsics.areEqual((Object) this.coupon, (Object) paymentUsage.coupon)) {
                        if (this.price == paymentUsage.price) {
                            if (this.shippingPrice == paymentUsage.shippingPrice) {
                                if (!(this.balance == paymentUsage.balance) || !Intrinsics.areEqual((Object) this.color, (Object) paymentUsage.color) || !Intrinsics.areEqual((Object) this.size, (Object) paymentUsage.size) || !Intrinsics.areEqual((Object) this.shippingName, (Object) paymentUsage.shippingName) || !Intrinsics.areEqual((Object) this.shippingContact, (Object) paymentUsage.shippingContact) || !Intrinsics.areEqual((Object) this.shippingAddress, (Object) paymentUsage.shippingAddress) || !Intrinsics.areEqual((Object) this.shippingAddress2, (Object) paymentUsage.shippingAddress2) || !Intrinsics.areEqual((Object) this.shippingZipCode, (Object) paymentUsage.shippingZipCode) || !Intrinsics.areEqual((Object) this.shippingMessage, (Object) paymentUsage.shippingMessage) || !Intrinsics.areEqual((Object) this.linkUrl, (Object) paymentUsage.linkUrl) || !Intrinsics.areEqual((Object) this.product, (Object) paymentUsage.product) || !Intrinsics.areEqual((Object) this.status, (Object) paymentUsage.status) || !Intrinsics.areEqual((Object) this.shippedAt, (Object) paymentUsage.shippedAt) || !Intrinsics.areEqual((Object) this.completedAt, (Object) paymentUsage.completedAt) || !Intrinsics.areEqual((Object) this.rejectedDescription, (Object) paymentUsage.rejectedDescription) || !Intrinsics.areEqual((Object) this.rejectedAt, (Object) paymentUsage.rejectedAt) || !Intrinsics.areEqual((Object) this.createdAt, (Object) paymentUsage.createdAt)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            User user2 = this.user;
            int i2 = 0;
            int hashCode = (i + (user2 != null ? user2.hashCode() : 0)) * 31;
            CouponInfo couponInfo = this.coupon;
            int hashCode2 = (((((((hashCode + (couponInfo != null ? couponInfo.hashCode() : 0)) * 31) + this.price) * 31) + this.shippingPrice) * 31) + this.balance) * 31;
            String str = this.color;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.size;
            int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.shippingName;
            int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.shippingContact;
            int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.shippingAddress;
            int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.shippingAddress2;
            int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.shippingZipCode;
            int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.shippingMessage;
            int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.linkUrl;
            int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
            Product product2 = this.product;
            int hashCode12 = (hashCode11 + (product2 != null ? product2.hashCode() : 0)) * 31;
            Status status2 = this.status;
            int hashCode13 = (hashCode12 + (status2 != null ? status2.hashCode() : 0)) * 31;
            Date date = this.shippedAt;
            int hashCode14 = (hashCode13 + (date != null ? date.hashCode() : 0)) * 31;
            Date date2 = this.completedAt;
            int hashCode15 = (hashCode14 + (date2 != null ? date2.hashCode() : 0)) * 31;
            String str10 = this.rejectedDescription;
            int hashCode16 = (hashCode15 + (str10 != null ? str10.hashCode() : 0)) * 31;
            Date date3 = this.rejectedAt;
            int hashCode17 = (hashCode16 + (date3 != null ? date3.hashCode() : 0)) * 31;
            Date date4 = this.createdAt;
            if (date4 != null) {
                i2 = date4.hashCode();
            }
            return hashCode17 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PaymentUsage(id=");
            sb.append(this.id);
            sb.append(", user=");
            sb.append(this.user);
            sb.append(", coupon=");
            sb.append(this.coupon);
            sb.append(", price=");
            sb.append(this.price);
            sb.append(", shippingPrice=");
            sb.append(this.shippingPrice);
            sb.append(", balance=");
            sb.append(this.balance);
            sb.append(", color=");
            sb.append(this.color);
            sb.append(", size=");
            sb.append(this.size);
            sb.append(", shippingName=");
            sb.append(this.shippingName);
            sb.append(", shippingContact=");
            sb.append(this.shippingContact);
            sb.append(", shippingAddress=");
            sb.append(this.shippingAddress);
            sb.append(", shippingAddress2=");
            sb.append(this.shippingAddress2);
            sb.append(", shippingZipCode=");
            sb.append(this.shippingZipCode);
            sb.append(", shippingMessage=");
            sb.append(this.shippingMessage);
            sb.append(", linkUrl=");
            sb.append(this.linkUrl);
            sb.append(", product=");
            sb.append(this.product);
            sb.append(", status=");
            sb.append(this.status);
            sb.append(", shippedAt=");
            sb.append(this.shippedAt);
            sb.append(", completedAt=");
            sb.append(this.completedAt);
            sb.append(", rejectedDescription=");
            sb.append(this.rejectedDescription);
            sb.append(", rejectedAt=");
            sb.append(this.rejectedAt);
            sb.append(", createdAt=");
            sb.append(this.createdAt);
            sb.append(")");
            return sb.toString();
        }

        public PaymentUsage(long j, @NotNull User user2, @Nullable CouponInfo couponInfo, int i, int i2, int i3, @Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @NotNull String str9, @Nullable Product product2, @NotNull Status status2, @Nullable Date date, @Nullable Date date2, @Nullable String str10, @Nullable Date date3, @NotNull Date date4) {
            User user3 = user2;
            String str11 = str3;
            String str12 = str4;
            String str13 = str5;
            String str14 = str9;
            Status status3 = status2;
            Date date5 = date4;
            Intrinsics.checkParameterIsNotNull(user2, "user");
            Intrinsics.checkParameterIsNotNull(str11, "shippingName");
            Intrinsics.checkParameterIsNotNull(str12, "shippingContact");
            Intrinsics.checkParameterIsNotNull(str13, "shippingAddress");
            Intrinsics.checkParameterIsNotNull(str14, "linkUrl");
            Intrinsics.checkParameterIsNotNull(status3, "status");
            Intrinsics.checkParameterIsNotNull(date5, "createdAt");
            this.id = j;
            this.user = user3;
            this.coupon = couponInfo;
            this.price = i;
            this.shippingPrice = i2;
            this.balance = i3;
            this.color = str;
            this.size = str2;
            this.shippingName = str11;
            this.shippingContact = str12;
            this.shippingAddress = str13;
            this.shippingAddress2 = str6;
            this.shippingZipCode = str7;
            this.shippingMessage = str8;
            this.linkUrl = str14;
            this.product = product2;
            this.status = status3;
            this.shippedAt = date;
            this.completedAt = date2;
            this.rejectedDescription = str10;
            this.rejectedAt = date3;
            this.createdAt = date5;
        }

        @IntRange(from = 1)
        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final User getUser() {
            return this.user;
        }

        @Nullable
        public final CouponInfo getCoupon() {
            return this.coupon;
        }

        public final int getPrice() {
            return this.price;
        }

        public final int getShippingPrice() {
            return this.shippingPrice;
        }

        public final int getBalance() {
            return this.balance;
        }

        @Nullable
        public final String getColor() {
            return this.color;
        }

        @Nullable
        public final String getSize() {
            return this.size;
        }

        @NotNull
        @NonNull
        public final String getShippingName() {
            return this.shippingName;
        }

        @NotNull
        @NonNull
        public final String getShippingContact() {
            return this.shippingContact;
        }

        @NotNull
        @NonNull
        public final String getShippingAddress() {
            return this.shippingAddress;
        }

        @Nullable
        public final String getShippingAddress2() {
            return this.shippingAddress2;
        }

        @Nullable
        public final String getShippingZipCode() {
            return this.shippingZipCode;
        }

        @Nullable
        public final String getShippingMessage() {
            return this.shippingMessage;
        }

        @NotNull
        @NonNull
        public final String getLinkUrl() {
            return this.linkUrl;
        }

        @Nullable
        public final Product getProduct() {
            return this.product;
        }

        @NotNull
        @NonNull
        public final Status getStatus() {
            return this.status;
        }

        @Nullable
        public final Date getShippedAt() {
            return this.shippedAt;
        }

        @Nullable
        public final Date getCompletedAt() {
            return this.completedAt;
        }

        @Nullable
        public final String getRejectedDescription() {
            return this.rejectedDescription;
        }

        @Nullable
        public final Date getRejectedAt() {
            return this.rejectedAt;
        }

        @NotNull
        @NonNull
        public final Date getCreatedAt() {
            return this.createdAt;
        }
    }

    @NotNull
    @DELETE("/api/v9/payments/invoices/{id}")
    @Headers({"Accept: application/json"})
    Single<String> deletePaymentUsageHistory(@Path("id") long j);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/payments/enroll")
    @Headers({"Accept: application/json"})
    Single<CouponEnrollResult> requestEnrollCouponUse(@Field("price") int i, @Field("shipping_price") @Nullable Integer num, @Field("coupon_id") @Nullable Long l, @Field("color") @Nullable String str, @Field("size") @Nullable String str2, @NotNull @Field("shipping_name") String str3, @NotNull @Field("shipping_contact") String str4, @NotNull @Field("shipping_zipcode") String str5, @NotNull @Field("shipping_address") String str6, @Field("shipping_address2") @Nullable String str7, @NotNull @Field("shipping_message") String str8, @NotNull @Field("link_url") String str9, @Field("shipping_save") @Nullable Boolean bool, @Field("ssn") @Nullable String str10);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/payments/enroll")
    @Headers({"Accept: application/json"})
    Single<CouponEnrollResult> requestEnrollRewardUse(@Field("price") int i, @Field("shipping_price") @Nullable Integer num, @Field("color") @Nullable String str, @Field("size") @Nullable String str2, @NotNull @Field("shipping_name") String str3, @NotNull @Field("shipping_contact") String str4, @NotNull @Field("shipping_zipcode") String str5, @NotNull @Field("shipping_address") String str6, @Field("shipping_address2") @Nullable String str7, @NotNull @Field("shipping_message") String str8, @NotNull @Field("link_url") String str9, @Field("shipping_save") @Nullable Boolean bool, @Field("ssn") @Nullable String str10);

    @NotNull
    @GET("/api/v9/payments/history")
    @Headers({"Accept: application/json"})
    Single<List<PaymentHistory>> requestPaymentHistoryList(@Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @FormUrlEncoded
    @NotNull
    @POST("/payments/request_payment")
    @Headers({"Accept: text/html"})
    Call<String> requestPaymentIamPort(@NotNull @Field("iamport_payment_type") String str, @NotNull @Field("from_type") String str2, @NotNull @Field("variants") String str3, @NotNull @Field("name") String str4, @NotNull @Field("contact") String str5, @Field("email") @Nullable String str6, @NotNull @Field("shipping_name") String str7, @NotNull @Field("shipping_contact") String str8, @NotNull @Field("shipping_zipcode") String str9, @NotNull @Field("shipping_address") String str10, @NotNull @Field("shipping_address2") String str11, @Field("shipping_message") @Nullable String str12, @Field("multiple_adjustment_type") @Nullable String str13, @Field("multiple_adjustment_price") @Nullable Integer num, @Field("coupon_id") @Nullable Long l, @Field("membership_id") @Nullable Long l2, @Field("post_id") @Nullable Long l3, @NotNull @Field("type") String str14, @Field("type_id") @Nullable Long l4);

    @NotNull
    @GET("/api/v9/payments/invoices/{id}")
    @Headers({"Accept: application/json"})
    Single<PaymentUsage> requestPaymentInvoice(@Path("id") long j);

    @NotNull
    @GET("/api/v9/payments/invoices")
    @Headers({"Accept: application/json"})
    Single<List<PaymentUsage>> requestPaymentInvoiceList(@Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num, @Nullable @Query("type") String str);
}
