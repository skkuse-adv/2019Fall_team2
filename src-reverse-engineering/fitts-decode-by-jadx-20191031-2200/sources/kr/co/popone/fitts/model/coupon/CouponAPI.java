package kr.co.popone.fitts.model.coupon;

import androidx.annotation.NonNull;
import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.Single;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CouponAPI {

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class AgreementImage {
        @SerializedName("ratio")
        @Nullable
        private final Double ratio;
        @SerializedName("url")
        @Nullable
        private final String url;

        @NotNull
        public static /* synthetic */ AgreementImage copy$default(AgreementImage agreementImage, String str, Double d, int i, Object obj) {
            if ((i & 1) != 0) {
                str = agreementImage.url;
            }
            if ((i & 2) != 0) {
                d = agreementImage.ratio;
            }
            return agreementImage.copy(str, d);
        }

        @Nullable
        public final String component1() {
            return this.url;
        }

        @Nullable
        public final Double component2() {
            return this.ratio;
        }

        @NotNull
        public final AgreementImage copy(@Nullable String str, @Nullable Double d) {
            return new AgreementImage(str, d);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.ratio, (java.lang.Object) r3.ratio) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.coupon.CouponAPI.AgreementImage
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.model.coupon.CouponAPI$AgreementImage r3 = (kr.co.popone.fitts.model.coupon.CouponAPI.AgreementImage) r3
                java.lang.String r0 = r2.url
                java.lang.String r1 = r3.url
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                java.lang.Double r0 = r2.ratio
                java.lang.Double r3 = r3.ratio
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.coupon.CouponAPI.AgreementImage.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.url;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d = this.ratio;
            if (d != null) {
                i = d.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AgreementImage(url=");
            sb.append(this.url);
            sb.append(", ratio=");
            sb.append(this.ratio);
            sb.append(")");
            return sb.toString();
        }

        public AgreementImage(@Nullable String str, @Nullable Double d) {
            this.url = str;
            this.ratio = d;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final Double getRatio() {
            return this.ratio;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class AvailableCouponCountResponse {
        @SerializedName("count")
        private final int count;

        @NotNull
        public static /* synthetic */ AvailableCouponCountResponse copy$default(AvailableCouponCountResponse availableCouponCountResponse, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = availableCouponCountResponse.count;
            }
            return availableCouponCountResponse.copy(i);
        }

        public final int component1() {
            return this.count;
        }

        @NotNull
        public final AvailableCouponCountResponse copy(int i) {
            return new AvailableCouponCountResponse(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof AvailableCouponCountResponse) {
                    if (this.count == ((AvailableCouponCountResponse) obj).count) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.count;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AvailableCouponCountResponse(count=");
            sb.append(this.count);
            sb.append(")");
            return sb.toString();
        }

        public AvailableCouponCountResponse(int i) {
            this.count = i;
        }

        public final int getCount() {
            return this.count;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class CouponAgreementApply {
        @SerializedName("message")
        @Nullable
        private final String message;

        @NotNull
        public static /* synthetic */ CouponAgreementApply copy$default(CouponAgreementApply couponAgreementApply, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = couponAgreementApply.message;
            }
            return couponAgreementApply.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.message;
        }

        @NotNull
        public final CouponAgreementApply copy(@Nullable String str) {
            return new CouponAgreementApply(str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.message, (java.lang.Object) ((kr.co.popone.fitts.model.coupon.CouponAPI.CouponAgreementApply) r2).message) != false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
            /*
                r1 = this;
                if (r1 == r2) goto L_0x0015
                boolean r0 = r2 instanceof kr.co.popone.fitts.model.coupon.CouponAPI.CouponAgreementApply
                if (r0 == 0) goto L_0x0013
                kr.co.popone.fitts.model.coupon.CouponAPI$CouponAgreementApply r2 = (kr.co.popone.fitts.model.coupon.CouponAPI.CouponAgreementApply) r2
                java.lang.String r0 = r1.message
                java.lang.String r2 = r2.message
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                if (r2 == 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r2 = 0
                return r2
            L_0x0015:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.coupon.CouponAPI.CouponAgreementApply.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.message;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CouponAgreementApply(message=");
            sb.append(this.message);
            sb.append(")");
            return sb.toString();
        }

        public CouponAgreementApply(@Nullable String str) {
            this.message = str;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class CouponInfo {
        @SerializedName("agreement")
        @Nullable
        private final Boolean agreement;
        @SerializedName("agreement_image")
        @NotNull
        private final AgreementImage agreementImage;
        @SerializedName("display_message")
        @NotNull
        private final String displayMessage;
        @SerializedName("end_date")
        @NotNull
        private final Date endDate;
        @SerializedName("expired")
        private final boolean expired;
        private final long id;
        @SerializedName("min_order_price")
        @Nullable
        private final Integer minOrderPrice;
        @SerializedName("start_date")
        @NotNull
        private final Date startDate;
        @NotNull
        private final String state;
        private final int value;

        @NotNull
        public static /* synthetic */ CouponInfo copy$default(CouponInfo couponInfo, long j, int i, String str, boolean z, Date date, Date date2, Boolean bool, String str2, Integer num, AgreementImage agreementImage2, int i2, Object obj) {
            CouponInfo couponInfo2 = couponInfo;
            int i3 = i2;
            return couponInfo.copy((i3 & 1) != 0 ? couponInfo2.id : j, (i3 & 2) != 0 ? couponInfo2.value : i, (i3 & 4) != 0 ? couponInfo2.state : str, (i3 & 8) != 0 ? couponInfo2.expired : z, (i3 & 16) != 0 ? couponInfo2.startDate : date, (i3 & 32) != 0 ? couponInfo2.endDate : date2, (i3 & 64) != 0 ? couponInfo2.agreement : bool, (i3 & 128) != 0 ? couponInfo2.displayMessage : str2, (i3 & 256) != 0 ? couponInfo2.minOrderPrice : num, (i3 & 512) != 0 ? couponInfo2.agreementImage : agreementImage2);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final AgreementImage component10() {
            return this.agreementImage;
        }

        public final int component2() {
            return this.value;
        }

        @NotNull
        public final String component3() {
            return this.state;
        }

        public final boolean component4() {
            return this.expired;
        }

        @NotNull
        public final Date component5() {
            return this.startDate;
        }

        @NotNull
        public final Date component6() {
            return this.endDate;
        }

        @Nullable
        public final Boolean component7() {
            return this.agreement;
        }

        @NotNull
        public final String component8() {
            return this.displayMessage;
        }

        @Nullable
        public final Integer component9() {
            return this.minOrderPrice;
        }

        @NotNull
        public final CouponInfo copy(long j, int i, @NotNull String str, boolean z, @NotNull Date date, @NotNull Date date2, @Nullable Boolean bool, @NotNull String str2, @Nullable Integer num, @NotNull AgreementImage agreementImage2) {
            String str3 = str;
            Intrinsics.checkParameterIsNotNull(str3, ServerProtocol.DIALOG_PARAM_STATE);
            Date date3 = date;
            Intrinsics.checkParameterIsNotNull(date3, "startDate");
            Date date4 = date2;
            Intrinsics.checkParameterIsNotNull(date4, "endDate");
            String str4 = str2;
            Intrinsics.checkParameterIsNotNull(str4, "displayMessage");
            AgreementImage agreementImage3 = agreementImage2;
            Intrinsics.checkParameterIsNotNull(agreementImage3, "agreementImage");
            CouponInfo couponInfo = new CouponInfo(j, i, str3, z, date3, date4, bool, str4, num, agreementImage3);
            return couponInfo;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof CouponInfo) {
                    CouponInfo couponInfo = (CouponInfo) obj;
                    if (this.id == couponInfo.id) {
                        if ((this.value == couponInfo.value) && Intrinsics.areEqual((Object) this.state, (Object) couponInfo.state)) {
                            if (!(this.expired == couponInfo.expired) || !Intrinsics.areEqual((Object) this.startDate, (Object) couponInfo.startDate) || !Intrinsics.areEqual((Object) this.endDate, (Object) couponInfo.endDate) || !Intrinsics.areEqual((Object) this.agreement, (Object) couponInfo.agreement) || !Intrinsics.areEqual((Object) this.displayMessage, (Object) couponInfo.displayMessage) || !Intrinsics.areEqual((Object) this.minOrderPrice, (Object) couponInfo.minOrderPrice) || !Intrinsics.areEqual((Object) this.agreementImage, (Object) couponInfo.agreementImage)) {
                                return false;
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
            int i = ((((int) (j ^ (j >>> 32))) * 31) + this.value) * 31;
            String str = this.state;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            boolean z = this.expired;
            if (z) {
                z = true;
            }
            int i3 = (hashCode + (z ? 1 : 0)) * 31;
            Date date = this.startDate;
            int hashCode2 = (i3 + (date != null ? date.hashCode() : 0)) * 31;
            Date date2 = this.endDate;
            int hashCode3 = (hashCode2 + (date2 != null ? date2.hashCode() : 0)) * 31;
            Boolean bool = this.agreement;
            int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
            String str2 = this.displayMessage;
            int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
            Integer num = this.minOrderPrice;
            int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
            AgreementImage agreementImage2 = this.agreementImage;
            if (agreementImage2 != null) {
                i2 = agreementImage2.hashCode();
            }
            return hashCode6 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CouponInfo(id=");
            sb.append(this.id);
            sb.append(", value=");
            sb.append(this.value);
            sb.append(", state=");
            sb.append(this.state);
            sb.append(", expired=");
            sb.append(this.expired);
            sb.append(", startDate=");
            sb.append(this.startDate);
            sb.append(", endDate=");
            sb.append(this.endDate);
            sb.append(", agreement=");
            sb.append(this.agreement);
            sb.append(", displayMessage=");
            sb.append(this.displayMessage);
            sb.append(", minOrderPrice=");
            sb.append(this.minOrderPrice);
            sb.append(", agreementImage=");
            sb.append(this.agreementImage);
            sb.append(")");
            return sb.toString();
        }

        public CouponInfo(long j, int i, @NotNull String str, boolean z, @NotNull Date date, @NotNull Date date2, @Nullable Boolean bool, @NotNull String str2, @Nullable Integer num, @NotNull AgreementImage agreementImage2) {
            Intrinsics.checkParameterIsNotNull(str, ServerProtocol.DIALOG_PARAM_STATE);
            Intrinsics.checkParameterIsNotNull(date, "startDate");
            Intrinsics.checkParameterIsNotNull(date2, "endDate");
            Intrinsics.checkParameterIsNotNull(str2, "displayMessage");
            Intrinsics.checkParameterIsNotNull(agreementImage2, "agreementImage");
            this.id = j;
            this.value = i;
            this.state = str;
            this.expired = z;
            this.startDate = date;
            this.endDate = date2;
            this.agreement = bool;
            this.displayMessage = str2;
            this.minOrderPrice = num;
            this.agreementImage = agreementImage2;
        }

        public final long getId() {
            return this.id;
        }

        public final int getValue() {
            return this.value;
        }

        @NotNull
        @NonNull
        public final String getState() {
            return this.state;
        }

        public final boolean getExpired() {
            return this.expired;
        }

        @NotNull
        public final Date getStartDate() {
            return this.startDate;
        }

        @NotNull
        public final Date getEndDate() {
            return this.endDate;
        }

        @Nullable
        public final Boolean getAgreement() {
            return this.agreement;
        }

        @NotNull
        public final String getDisplayMessage() {
            return this.displayMessage;
        }

        @Nullable
        public final Integer getMinOrderPrice() {
            return this.minOrderPrice;
        }

        @NotNull
        public final AgreementImage getAgreementImage() {
            return this.agreementImage;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class CouponRegisterResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        @NotNull
        public static /* synthetic */ CouponRegisterResult copy$default(CouponRegisterResult couponRegisterResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = couponRegisterResult.message;
            }
            return couponRegisterResult.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        @NotNull
        public final CouponRegisterResult copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            return new CouponRegisterResult(str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.message, (java.lang.Object) ((kr.co.popone.fitts.model.coupon.CouponAPI.CouponRegisterResult) r2).message) != false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
            /*
                r1 = this;
                if (r1 == r2) goto L_0x0015
                boolean r0 = r2 instanceof kr.co.popone.fitts.model.coupon.CouponAPI.CouponRegisterResult
                if (r0 == 0) goto L_0x0013
                kr.co.popone.fitts.model.coupon.CouponAPI$CouponRegisterResult r2 = (kr.co.popone.fitts.model.coupon.CouponAPI.CouponRegisterResult) r2
                java.lang.String r0 = r1.message
                java.lang.String r2 = r2.message
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                if (r2 == 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r2 = 0
                return r2
            L_0x0015:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.coupon.CouponAPI.CouponRegisterResult.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.message;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CouponRegisterResult(message=");
            sb.append(this.message);
            sb.append(")");
            return sb.toString();
        }

        public CouponRegisterResult(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @PUT("/api/v9/coupons/{id}/agreement_apply")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<CouponAgreementApply> requestAgreeTerms(@Path("id") long j);

    @NotNull
    @GET("/api/v9/coupons/available_coupon_count")
    @Headers({"Accept: application/json"})
    Single<AvailableCouponCountResponse> requestAvailableCouponCount();

    @NotNull
    @GET("/api/v9/coupons")
    @Headers({"Accept: application/json"})
    Single<List<CouponInfo>> requestCoupons(@Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/coupons/register")
    @Headers({"Accept: application/json"})
    Single<CouponRegisterResult> requestRegisterCoupon(@NotNull @Field("coupon_code") String str);

    @NotNull
    @POST("/api/v9/coupons/register_fittscard")
    @Headers({"Accept: application/json"})
    Single<CouponRegisterResult> requestRegisterFittsCard();
}
