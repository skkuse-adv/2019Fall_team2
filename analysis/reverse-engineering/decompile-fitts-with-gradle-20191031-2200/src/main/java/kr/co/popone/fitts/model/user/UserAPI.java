package kr.co.popone.fitts.model.user;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.facebook.internal.NativeProtocol;
import com.google.gson.annotations.SerializedName;
import com.kakao.message.template.MessageTemplateProtocol;
import com.uber.rave.annotation.Validated;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.alarm.AlarmAgreement;
import kr.co.popone.fitts.model.datamodel.service.alarm.AlarmCount;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.datamodel.service.user.Recommender;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.datamodel.social.point.PointInfo;
import kr.co.popone.fitts.model.order.PostableOrderLineItemVariant;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.remote.model.RefundAccount;
import kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UserAPI {

    public static final class BadgeCount {
        @SerializedName("cart_item_count")
        private final int cartVariantCount;
        @SerializedName("postable_products_count")
        private final int postableCount;

        @NotNull
        public static /* synthetic */ BadgeCount copy$default(BadgeCount badgeCount, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = badgeCount.cartVariantCount;
            }
            if ((i3 & 2) != 0) {
                i2 = badgeCount.postableCount;
            }
            return badgeCount.copy(i, i2);
        }

        public final int component1() {
            return this.cartVariantCount;
        }

        public final int component2() {
            return this.postableCount;
        }

        @NotNull
        public final BadgeCount copy(int i, int i2) {
            return new BadgeCount(i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof BadgeCount) {
                    BadgeCount badgeCount = (BadgeCount) obj;
                    if (this.cartVariantCount == badgeCount.cartVariantCount) {
                        if (this.postableCount == badgeCount.postableCount) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.cartVariantCount * 31) + this.postableCount;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BadgeCount(cartVariantCount=");
            sb.append(this.cartVariantCount);
            sb.append(", postableCount=");
            sb.append(this.postableCount);
            sb.append(")");
            return sb.toString();
        }

        public BadgeCount(int i, int i2) {
            this.cartVariantCount = i;
            this.postableCount = i2;
        }

        public final int getCartVariantCount() {
            return this.cartVariantCount;
        }

        public final int getPostableCount() {
            return this.postableCount;
        }
    }

    public static final class DefaultImpls {
        @FormUrlEncoded
        @NotNull
        @POST("/api/v9/users")
        @Headers({"Accept: application/json"})
        public static /* synthetic */ Single requestCreateUser$default(UserAPI userAPI, String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6, int i4, String str7, String str8, String str9, int i5, Object obj) {
            if (obj == null) {
                return userAPI.requestCreateUser(str, str2, str3, str4, str5, i, i2, i3, str6, i4, str7, str8, (i5 & 4096) != 0 ? null : str9);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestCreateUser");
        }

        @FormUrlEncoded
        @PUT("/api/v9/users/me")
        @NotNull
        @Headers({"Accept: application/json"})
        public static /* synthetic */ Single setUserInfo$default(UserAPI userAPI, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                if ((i & 8) != 0) {
                    str4 = null;
                }
                if ((i & 16) != 0) {
                    str5 = null;
                }
                if ((i & 32) != 0) {
                    str6 = null;
                }
                if ((i & 64) != 0) {
                    num = null;
                }
                if ((i & 128) != 0) {
                    str7 = null;
                }
                return userAPI.setUserInfo(str, str2, str3, str4, str5, str6, num, str7);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setUserInfo");
        }

        @NotNull
        @GET("/api/v9/users/{user_id}/followings")
        @Headers({"Accept: application/json"})
        public static /* synthetic */ Single requestFollowings$default(UserAPI userAPI, long j, Long l, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    l = null;
                }
                if ((i & 4) != 0) {
                    num = null;
                }
                return userAPI.requestFollowings(j, l, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestFollowings");
        }

        @FormUrlEncoded
        @PUT("/api/v9/users/me/additional_info")
        @NotNull
        @Headers({"Accept: application/json"})
        public static /* synthetic */ Completable updateAdditionalInfo$default(UserAPI userAPI, String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, int i, Object obj) {
            if (obj == null) {
                return userAPI.updateAdditionalInfo(str, str2, str3, str4, str5, num, str6, (i & 128) != 0 ? null : str7);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAdditionalInfo");
        }

        @NotNull
        @GET("/api/v9/users/{user_id}/followers")
        @Headers({"Accept: application/json"})
        public static /* synthetic */ Single requestFollowers$default(UserAPI userAPI, long j, Long l, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    l = null;
                }
                if ((i & 4) != 0) {
                    num = null;
                }
                return userAPI.requestFollowers(j, l, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestFollowers");
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class EmailAvailable {
        private int code;
        @NotNull
        private final String email;
        private final boolean is_available;
        @NotNull
        private String message;

        @NotNull
        public static /* synthetic */ EmailAvailable copy$default(EmailAvailable emailAvailable, String str, boolean z, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = emailAvailable.email;
            }
            if ((i2 & 2) != 0) {
                z = emailAvailable.is_available;
            }
            if ((i2 & 4) != 0) {
                str2 = emailAvailable.message;
            }
            if ((i2 & 8) != 0) {
                i = emailAvailable.code;
            }
            return emailAvailable.copy(str, z, str2, i);
        }

        @NotNull
        public final String component1() {
            return this.email;
        }

        public final boolean component2() {
            return this.is_available;
        }

        @NotNull
        public final String component3() {
            return this.message;
        }

        public final int component4() {
            return this.code;
        }

        @NotNull
        public final EmailAvailable copy(@NotNull String str, boolean z, @NotNull String str2, int i) {
            Intrinsics.checkParameterIsNotNull(str, "email");
            Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            return new EmailAvailable(str, z, str2, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof EmailAvailable) {
                    EmailAvailable emailAvailable = (EmailAvailable) obj;
                    if (Intrinsics.areEqual((Object) this.email, (Object) emailAvailable.email)) {
                        if ((this.is_available == emailAvailable.is_available) && Intrinsics.areEqual((Object) this.message, (Object) emailAvailable.message)) {
                            if (this.code == emailAvailable.code) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.email;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.is_available;
            if (z) {
                z = true;
            }
            int i2 = (hashCode + (z ? 1 : 0)) * 31;
            String str2 = this.message;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return ((i2 + i) * 31) + this.code;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("EmailAvailable(email=");
            sb.append(this.email);
            sb.append(", is_available=");
            sb.append(this.is_available);
            sb.append(", message=");
            sb.append(this.message);
            sb.append(", code=");
            sb.append(this.code);
            sb.append(")");
            return sb.toString();
        }

        public EmailAvailable(@NotNull String str, boolean z, @NotNull String str2, int i) {
            Intrinsics.checkParameterIsNotNull(str, "email");
            Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            this.email = str;
            this.is_available = z;
            this.message = str2;
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getEmail() {
            return this.email;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public final boolean is_available() {
            return this.is_available;
        }

        public final void setCode(int i) {
            this.code = i;
        }

        public final void setMessage(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.message = str;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Enroll {
        @NotNull
        private final String created_at;
        private final long id;
        @Nullable
        private final String reject_description;
        @Nullable
        private final String rejected_at;
        @Nullable
        private final Integer reward_points_at_confirm;
        @NotNull
        private final String status;

        @NotNull
        public static /* synthetic */ Enroll copy$default(Enroll enroll, long j, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
            Enroll enroll2 = enroll;
            return enroll.copy((i & 1) != 0 ? enroll2.id : j, (i & 2) != 0 ? enroll2.status : str, (i & 4) != 0 ? enroll2.created_at : str2, (i & 8) != 0 ? enroll2.reject_description : str3, (i & 16) != 0 ? enroll2.rejected_at : str4, (i & 32) != 0 ? enroll2.reward_points_at_confirm : num);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.status;
        }

        @NotNull
        public final String component3() {
            return this.created_at;
        }

        @Nullable
        public final String component4() {
            return this.reject_description;
        }

        @Nullable
        public final String component5() {
            return this.rejected_at;
        }

        @Nullable
        public final Integer component6() {
            return this.reward_points_at_confirm;
        }

        @NotNull
        public final Enroll copy(long j, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num) {
            String str5 = str;
            Intrinsics.checkParameterIsNotNull(str, "status");
            String str6 = str2;
            Intrinsics.checkParameterIsNotNull(str2, "created_at");
            Enroll enroll = new Enroll(j, str5, str6, str3, str4, num);
            return enroll;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Enroll) {
                    Enroll enroll = (Enroll) obj;
                    if (!(this.id == enroll.id) || !Intrinsics.areEqual((Object) this.status, (Object) enroll.status) || !Intrinsics.areEqual((Object) this.created_at, (Object) enroll.created_at) || !Intrinsics.areEqual((Object) this.reject_description, (Object) enroll.reject_description) || !Intrinsics.areEqual((Object) this.rejected_at, (Object) enroll.rejected_at) || !Intrinsics.areEqual((Object) this.reward_points_at_confirm, (Object) enroll.reward_points_at_confirm)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.status;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.created_at;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.reject_description;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.rejected_at;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            Integer num = this.reward_points_at_confirm;
            if (num != null) {
                i2 = num.hashCode();
            }
            return hashCode4 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Enroll(id=");
            sb.append(this.id);
            sb.append(", status=");
            sb.append(this.status);
            sb.append(", created_at=");
            sb.append(this.created_at);
            sb.append(", reject_description=");
            sb.append(this.reject_description);
            sb.append(", rejected_at=");
            sb.append(this.rejected_at);
            sb.append(", reward_points_at_confirm=");
            sb.append(this.reward_points_at_confirm);
            sb.append(")");
            return sb.toString();
        }

        public Enroll(long j, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num) {
            Intrinsics.checkParameterIsNotNull(str, "status");
            Intrinsics.checkParameterIsNotNull(str2, "created_at");
            this.id = j;
            this.status = str;
            this.created_at = str2;
            this.reject_description = str3;
            this.rejected_at = str4;
            this.reward_points_at_confirm = num;
        }

        @NotNull
        public final String getCreated_at() {
            return this.created_at;
        }

        public final long getId() {
            return this.id;
        }

        @Nullable
        public final String getReject_description() {
            return this.reject_description;
        }

        @Nullable
        public final String getRejected_at() {
            return this.rejected_at;
        }

        @Nullable
        public final Integer getReward_points_at_confirm() {
            return this.reward_points_at_confirm;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class IdAvailable {
        private int code;
        @NotNull
        private final String fittsid;
        private final boolean is_available;
        @NotNull
        private String message;

        @NotNull
        public static /* synthetic */ IdAvailable copy$default(IdAvailable idAvailable, String str, boolean z, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = idAvailable.fittsid;
            }
            if ((i2 & 2) != 0) {
                z = idAvailable.is_available;
            }
            if ((i2 & 4) != 0) {
                str2 = idAvailable.message;
            }
            if ((i2 & 8) != 0) {
                i = idAvailable.code;
            }
            return idAvailable.copy(str, z, str2, i);
        }

        @NotNull
        public final String component1() {
            return this.fittsid;
        }

        public final boolean component2() {
            return this.is_available;
        }

        @NotNull
        public final String component3() {
            return this.message;
        }

        public final int component4() {
            return this.code;
        }

        @NotNull
        public final IdAvailable copy(@NotNull String str, boolean z, @NotNull String str2, int i) {
            Intrinsics.checkParameterIsNotNull(str, "fittsid");
            Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            return new IdAvailable(str, z, str2, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof IdAvailable) {
                    IdAvailable idAvailable = (IdAvailable) obj;
                    if (Intrinsics.areEqual((Object) this.fittsid, (Object) idAvailable.fittsid)) {
                        if ((this.is_available == idAvailable.is_available) && Intrinsics.areEqual((Object) this.message, (Object) idAvailable.message)) {
                            if (this.code == idAvailable.code) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.fittsid;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.is_available;
            if (z) {
                z = true;
            }
            int i2 = (hashCode + (z ? 1 : 0)) * 31;
            String str2 = this.message;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return ((i2 + i) * 31) + this.code;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("IdAvailable(fittsid=");
            sb.append(this.fittsid);
            sb.append(", is_available=");
            sb.append(this.is_available);
            sb.append(", message=");
            sb.append(this.message);
            sb.append(", code=");
            sb.append(this.code);
            sb.append(")");
            return sb.toString();
        }

        public IdAvailable(@NotNull String str, boolean z, @NotNull String str2, int i) {
            Intrinsics.checkParameterIsNotNull(str, "fittsid");
            Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            this.fittsid = str;
            this.is_available = z;
            this.message = str2;
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getFittsid() {
            return this.fittsid;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public final boolean is_available() {
            return this.is_available;
        }

        public final void setCode(int i) {
            this.code = i;
        }

        public final void setMessage(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.message = str;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class IvsInfo {
        @SerializedName("contact_info")
        @NotNull
        private final UserContactInfo contactInfo;
        @SerializedName("date_of_birth")
        @NotNull
        private final String dateOfBirth;
        @SerializedName("gender_number")
        @NotNull
        private final String genderNumber;
        private final long id;

        public static final class UserContactInfo {
            @SerializedName("contact")
            @NotNull
            private final String contact;
            @SerializedName("name")
            @NotNull
            private final String name;

            @NotNull
            public static /* synthetic */ UserContactInfo copy$default(UserContactInfo userContactInfo, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = userContactInfo.name;
                }
                if ((i & 2) != 0) {
                    str2 = userContactInfo.contact;
                }
                return userContactInfo.copy(str, str2);
            }

            @NotNull
            public final String component1() {
                return this.name;
            }

            @NotNull
            public final String component2() {
                return this.contact;
            }

            @NotNull
            public final UserContactInfo copy(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkParameterIsNotNull(str, "name");
                Intrinsics.checkParameterIsNotNull(str2, "contact");
                return new UserContactInfo(str, str2);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
                if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.contact, (java.lang.Object) r3.contact) != false) goto L_0x001f;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
                /*
                    r2 = this;
                    if (r2 == r3) goto L_0x001f
                    boolean r0 = r3 instanceof kr.co.popone.fitts.model.user.UserAPI.IvsInfo.UserContactInfo
                    if (r0 == 0) goto L_0x001d
                    kr.co.popone.fitts.model.user.UserAPI$IvsInfo$UserContactInfo r3 = (kr.co.popone.fitts.model.user.UserAPI.IvsInfo.UserContactInfo) r3
                    java.lang.String r0 = r2.name
                    java.lang.String r1 = r3.name
                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                    if (r0 == 0) goto L_0x001d
                    java.lang.String r0 = r2.contact
                    java.lang.String r3 = r3.contact
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
                throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.user.UserAPI.IvsInfo.UserContactInfo.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                String str = this.name;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.contact;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("UserContactInfo(name=");
                sb.append(this.name);
                sb.append(", contact=");
                sb.append(this.contact);
                sb.append(")");
                return sb.toString();
            }

            public UserContactInfo(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkParameterIsNotNull(str, "name");
                Intrinsics.checkParameterIsNotNull(str2, "contact");
                this.name = str;
                this.contact = str2;
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            @NotNull
            public final String getContact() {
                return this.contact;
            }
        }

        @NotNull
        public static /* synthetic */ IvsInfo copy$default(IvsInfo ivsInfo, long j, String str, String str2, UserContactInfo userContactInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                j = ivsInfo.id;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = ivsInfo.dateOfBirth;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = ivsInfo.genderNumber;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                userContactInfo = ivsInfo.contactInfo;
            }
            return ivsInfo.copy(j2, str3, str4, userContactInfo);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.dateOfBirth;
        }

        @NotNull
        public final String component3() {
            return this.genderNumber;
        }

        @NotNull
        public final UserContactInfo component4() {
            return this.contactInfo;
        }

        @NotNull
        public final IvsInfo copy(long j, @NotNull String str, @NotNull String str2, @NotNull UserContactInfo userContactInfo) {
            Intrinsics.checkParameterIsNotNull(str, "dateOfBirth");
            Intrinsics.checkParameterIsNotNull(str2, "genderNumber");
            Intrinsics.checkParameterIsNotNull(userContactInfo, "contactInfo");
            IvsInfo ivsInfo = new IvsInfo(j, str, str2, userContactInfo);
            return ivsInfo;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof IvsInfo) {
                    IvsInfo ivsInfo = (IvsInfo) obj;
                    if (!(this.id == ivsInfo.id) || !Intrinsics.areEqual((Object) this.dateOfBirth, (Object) ivsInfo.dateOfBirth) || !Intrinsics.areEqual((Object) this.genderNumber, (Object) ivsInfo.genderNumber) || !Intrinsics.areEqual((Object) this.contactInfo, (Object) ivsInfo.contactInfo)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.dateOfBirth;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.genderNumber;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            UserContactInfo userContactInfo = this.contactInfo;
            if (userContactInfo != null) {
                i2 = userContactInfo.hashCode();
            }
            return hashCode2 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("IvsInfo(id=");
            sb.append(this.id);
            sb.append(", dateOfBirth=");
            sb.append(this.dateOfBirth);
            sb.append(", genderNumber=");
            sb.append(this.genderNumber);
            sb.append(", contactInfo=");
            sb.append(this.contactInfo);
            sb.append(")");
            return sb.toString();
        }

        public IvsInfo(long j, @NotNull String str, @NotNull String str2, @NotNull UserContactInfo userContactInfo) {
            Intrinsics.checkParameterIsNotNull(str, "dateOfBirth");
            Intrinsics.checkParameterIsNotNull(str2, "genderNumber");
            Intrinsics.checkParameterIsNotNull(userContactInfo, "contactInfo");
            this.id = j;
            this.dateOfBirth = str;
            this.genderNumber = str2;
            this.contactInfo = userContactInfo;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getDateOfBirth() {
            return this.dateOfBirth;
        }

        @NotNull
        public final String getGenderNumber() {
            return this.genderNumber;
        }

        @NotNull
        public final UserContactInfo getContactInfo() {
            return this.contactInfo;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Me {
        @SerializedName("auth_token")
        @NotNull
        private final String auth_token;
        @SerializedName("fittsid")
        @NotNull
        private final String fittsid;
        private final long id;

        @NotNull
        public static /* synthetic */ Me copy$default(Me me2, long j, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = me2.id;
            }
            if ((i & 2) != 0) {
                str = me2.fittsid;
            }
            if ((i & 4) != 0) {
                str2 = me2.auth_token;
            }
            return me2.copy(j, str, str2);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.fittsid;
        }

        @NotNull
        public final String component3() {
            return this.auth_token;
        }

        @NotNull
        public final Me copy(long j, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "fittsid");
            Intrinsics.checkParameterIsNotNull(str2, "auth_token");
            return new Me(j, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Me) {
                    Me me2 = (Me) obj;
                    if (!(this.id == me2.id) || !Intrinsics.areEqual((Object) this.fittsid, (Object) me2.fittsid) || !Intrinsics.areEqual((Object) this.auth_token, (Object) me2.auth_token)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.fittsid;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.auth_token;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Me(id=");
            sb.append(this.id);
            sb.append(", fittsid=");
            sb.append(this.fittsid);
            sb.append(", auth_token=");
            sb.append(this.auth_token);
            sb.append(")");
            return sb.toString();
        }

        public Me(long j, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "fittsid");
            Intrinsics.checkParameterIsNotNull(str2, "auth_token");
            this.id = j;
            this.fittsid = str;
            this.auth_token = str2;
        }

        @IntRange(from = 1)
        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final String getFittsid() {
            return this.fittsid;
        }

        @NotNull
        @NonNull
        public final String getAuth_token() {
            return this.auth_token;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class PostableResponse {
        @SerializedName("is_postable")
        private final boolean isPostable;
        @SerializedName("unpostable_reason")
        @Nullable
        private final UnpostableReason unpostableReason;

        @Validated(factory = ValidatorFactoryImpl.class)
        public static final class UnpostableReason {
            @SerializedName("remaining_hour")
            private final int remainingHour;
            @NotNull
            private final Type type;

            public enum Type {
                POSTING_LIMIT,
                BLACKLIST,
                WATCHLIST
            }

            @NotNull
            public static /* synthetic */ UnpostableReason copy$default(UnpostableReason unpostableReason, Type type2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    type2 = unpostableReason.type;
                }
                if ((i2 & 2) != 0) {
                    i = unpostableReason.remainingHour;
                }
                return unpostableReason.copy(type2, i);
            }

            @NotNull
            public final Type component1() {
                return this.type;
            }

            public final int component2() {
                return this.remainingHour;
            }

            @NotNull
            public final UnpostableReason copy(@NotNull Type type2, int i) {
                Intrinsics.checkParameterIsNotNull(type2, "type");
                return new UnpostableReason(type2, i);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    if (obj instanceof UnpostableReason) {
                        UnpostableReason unpostableReason = (UnpostableReason) obj;
                        if (Intrinsics.areEqual((Object) this.type, (Object) unpostableReason.type)) {
                            if (this.remainingHour == unpostableReason.remainingHour) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                return true;
            }

            public int hashCode() {
                Type type2 = this.type;
                return ((type2 != null ? type2.hashCode() : 0) * 31) + this.remainingHour;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("UnpostableReason(type=");
                sb.append(this.type);
                sb.append(", remainingHour=");
                sb.append(this.remainingHour);
                sb.append(")");
                return sb.toString();
            }

            public UnpostableReason(@NotNull Type type2, int i) {
                Intrinsics.checkParameterIsNotNull(type2, "type");
                this.type = type2;
                this.remainingHour = i;
            }

            @NotNull
            @NonNull
            public final Type getType() {
                return this.type;
            }

            public final int getRemainingHour() {
                return this.remainingHour;
            }
        }

        @NotNull
        public static /* synthetic */ PostableResponse copy$default(PostableResponse postableResponse, boolean z, UnpostableReason unpostableReason2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = postableResponse.isPostable;
            }
            if ((i & 2) != 0) {
                unpostableReason2 = postableResponse.unpostableReason;
            }
            return postableResponse.copy(z, unpostableReason2);
        }

        public final boolean component1() {
            return this.isPostable;
        }

        @Nullable
        public final UnpostableReason component2() {
            return this.unpostableReason;
        }

        @NotNull
        public final PostableResponse copy(boolean z, @Nullable UnpostableReason unpostableReason2) {
            return new PostableResponse(z, unpostableReason2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof PostableResponse) {
                    PostableResponse postableResponse = (PostableResponse) obj;
                    if (!(this.isPostable == postableResponse.isPostable) || !Intrinsics.areEqual((Object) this.unpostableReason, (Object) postableResponse.unpostableReason)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.isPostable;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            UnpostableReason unpostableReason2 = this.unpostableReason;
            return i + (unpostableReason2 != null ? unpostableReason2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PostableResponse(isPostable=");
            sb.append(this.isPostable);
            sb.append(", unpostableReason=");
            sb.append(this.unpostableReason);
            sb.append(")");
            return sb.toString();
        }

        public PostableResponse(boolean z, @Nullable UnpostableReason unpostableReason2) {
            this.isPostable = z;
            this.unpostableReason = unpostableReason2;
        }

        public final boolean isPostable() {
            return this.isPostable;
        }

        @Nullable
        public final UnpostableReason getUnpostableReason() {
            return this.unpostableReason;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class ResponseImageId {
        private int id;

        @NotNull
        public static /* synthetic */ ResponseImageId copy$default(ResponseImageId responseImageId, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = responseImageId.id;
            }
            return responseImageId.copy(i);
        }

        public final int component1() {
            return this.id;
        }

        @NotNull
        public final ResponseImageId copy(int i) {
            return new ResponseImageId(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof ResponseImageId) {
                    if (this.id == ((ResponseImageId) obj).id) {
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
            sb.append("ResponseImageId(id=");
            sb.append(this.id);
            sb.append(")");
            return sb.toString();
        }

        public ResponseImageId(int i) {
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Reward {
        private final int fittie;
        private final int post;

        @NotNull
        public static /* synthetic */ Reward copy$default(Reward reward, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = reward.post;
            }
            if ((i3 & 2) != 0) {
                i2 = reward.fittie;
            }
            return reward.copy(i, i2);
        }

        public final int component1() {
            return this.post;
        }

        public final int component2() {
            return this.fittie;
        }

        @NotNull
        public final Reward copy(int i, int i2) {
            return new Reward(i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Reward) {
                    Reward reward = (Reward) obj;
                    if (this.post == reward.post) {
                        if (this.fittie == reward.fittie) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.post * 31) + this.fittie;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Reward(post=");
            sb.append(this.post);
            sb.append(", fittie=");
            sb.append(this.fittie);
            sb.append(")");
            return sb.toString();
        }

        public Reward(int i, int i2) {
            this.post = i;
            this.fittie = i2;
        }

        public final int getFittie() {
            return this.fittie;
        }

        public final int getPost() {
            return this.post;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class ShippingAddressResponse implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        @SerializedName("address")
        @NotNull
        private final String address;
        @SerializedName("address2")
        @Nullable
        private final String address2;
        @SerializedName("contact")
        @NotNull
        private final String contact;
        private final long id;
        @SerializedName("message")
        @Nullable
        private final String message;
        @SerializedName("name")
        @NotNull
        private final String name;
        @SerializedName("zipcode")
        @NotNull
        private final String zipCode;

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                ShippingAddressResponse shippingAddressResponse = new ShippingAddressResponse(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                return shippingAddressResponse;
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new ShippingAddressResponse[i];
            }
        }

        @NotNull
        public static /* synthetic */ ShippingAddressResponse copy$default(ShippingAddressResponse shippingAddressResponse, long j, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            ShippingAddressResponse shippingAddressResponse2 = shippingAddressResponse;
            return shippingAddressResponse.copy((i & 1) != 0 ? shippingAddressResponse2.id : j, (i & 2) != 0 ? shippingAddressResponse2.name : str, (i & 4) != 0 ? shippingAddressResponse2.contact : str2, (i & 8) != 0 ? shippingAddressResponse2.zipCode : str3, (i & 16) != 0 ? shippingAddressResponse2.address : str4, (i & 32) != 0 ? shippingAddressResponse2.address2 : str5, (i & 64) != 0 ? shippingAddressResponse2.message : str6);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.name;
        }

        @NotNull
        public final String component3() {
            return this.contact;
        }

        @NotNull
        public final String component4() {
            return this.zipCode;
        }

        @NotNull
        public final String component5() {
            return this.address;
        }

        @Nullable
        public final String component6() {
            return this.address2;
        }

        @Nullable
        public final String component7() {
            return this.message;
        }

        @NotNull
        public final ShippingAddressResponse copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6) {
            String str7 = str;
            Intrinsics.checkParameterIsNotNull(str, "name");
            String str8 = str2;
            Intrinsics.checkParameterIsNotNull(str2, "contact");
            String str9 = str3;
            Intrinsics.checkParameterIsNotNull(str3, "zipCode");
            String str10 = str4;
            Intrinsics.checkParameterIsNotNull(str10, MessageTemplateProtocol.ADDRESS);
            ShippingAddressResponse shippingAddressResponse = new ShippingAddressResponse(j, str7, str8, str9, str10, str5, str6);
            return shippingAddressResponse;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof ShippingAddressResponse) {
                    ShippingAddressResponse shippingAddressResponse = (ShippingAddressResponse) obj;
                    if (!(this.id == shippingAddressResponse.id) || !Intrinsics.areEqual((Object) this.name, (Object) shippingAddressResponse.name) || !Intrinsics.areEqual((Object) this.contact, (Object) shippingAddressResponse.contact) || !Intrinsics.areEqual((Object) this.zipCode, (Object) shippingAddressResponse.zipCode) || !Intrinsics.areEqual((Object) this.address, (Object) shippingAddressResponse.address) || !Intrinsics.areEqual((Object) this.address2, (Object) shippingAddressResponse.address2) || !Intrinsics.areEqual((Object) this.message, (Object) shippingAddressResponse.message)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.name;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.contact;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.zipCode;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.address;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.address2;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.message;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            return hashCode5 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ShippingAddressResponse(id=");
            sb.append(this.id);
            sb.append(", name=");
            sb.append(this.name);
            sb.append(", contact=");
            sb.append(this.contact);
            sb.append(", zipCode=");
            sb.append(this.zipCode);
            sb.append(", address=");
            sb.append(this.address);
            sb.append(", address2=");
            sb.append(this.address2);
            sb.append(", message=");
            sb.append(this.message);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeLong(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.contact);
            parcel.writeString(this.zipCode);
            parcel.writeString(this.address);
            parcel.writeString(this.address2);
            parcel.writeString(this.message);
        }

        public ShippingAddressResponse(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "contact");
            Intrinsics.checkParameterIsNotNull(str3, "zipCode");
            Intrinsics.checkParameterIsNotNull(str4, MessageTemplateProtocol.ADDRESS);
            this.id = j;
            this.name = str;
            this.contact = str2;
            this.zipCode = str3;
            this.address = str4;
            this.address2 = str5;
            this.message = str6;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        @NonNull
        public final String getContact() {
            return this.contact;
        }

        @NotNull
        @NonNull
        public final String getZipCode() {
            return this.zipCode;
        }

        @NotNull
        @NonNull
        public final String getAddress() {
            return this.address;
        }

        @Nullable
        public final String getAddress2() {
            return this.address2;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class UserInvoice {
        @NotNull
        private final String action;
        @SerializedName("created_at")
        @Nullable
        private final Date createdAt;
        private final long id;
        @SerializedName("reject_description")
        @Nullable
        private final String rejectDescription;
        @SerializedName("rejected_at")
        @Nullable
        private final Date rejectedAt;
        @SerializedName("reward")
        @Nullable
        private final PaymentHistory reward;
        @NotNull
        private final String type;
        @SerializedName("verified_at")
        @Nullable
        private final String verifyAt;

        @NotNull
        public static /* synthetic */ UserInvoice copy$default(UserInvoice userInvoice, long j, String str, String str2, Date date, Date date2, PaymentHistory paymentHistory, String str3, String str4, int i, Object obj) {
            UserInvoice userInvoice2 = userInvoice;
            int i2 = i;
            return userInvoice.copy((i2 & 1) != 0 ? userInvoice2.id : j, (i2 & 2) != 0 ? userInvoice2.action : str, (i2 & 4) != 0 ? userInvoice2.type : str2, (i2 & 8) != 0 ? userInvoice2.createdAt : date, (i2 & 16) != 0 ? userInvoice2.rejectedAt : date2, (i2 & 32) != 0 ? userInvoice2.reward : paymentHistory, (i2 & 64) != 0 ? userInvoice2.verifyAt : str3, (i2 & 128) != 0 ? userInvoice2.rejectDescription : str4);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.action;
        }

        @NotNull
        public final String component3() {
            return this.type;
        }

        @Nullable
        public final Date component4() {
            return this.createdAt;
        }

        @Nullable
        public final Date component5() {
            return this.rejectedAt;
        }

        @Nullable
        public final PaymentHistory component6() {
            return this.reward;
        }

        @Nullable
        public final String component7() {
            return this.verifyAt;
        }

        @Nullable
        public final String component8() {
            return this.rejectDescription;
        }

        @NotNull
        public final UserInvoice copy(long j, @NotNull String str, @NotNull String str2, @Nullable Date date, @Nullable Date date2, @Nullable PaymentHistory paymentHistory, @Nullable String str3, @Nullable String str4) {
            String str5 = str;
            Intrinsics.checkParameterIsNotNull(str, NativeProtocol.WEB_DIALOG_ACTION);
            String str6 = str2;
            Intrinsics.checkParameterIsNotNull(str2, "type");
            UserInvoice userInvoice = new UserInvoice(j, str5, str6, date, date2, paymentHistory, str3, str4);
            return userInvoice;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof UserInvoice) {
                    UserInvoice userInvoice = (UserInvoice) obj;
                    if (!(this.id == userInvoice.id) || !Intrinsics.areEqual((Object) this.action, (Object) userInvoice.action) || !Intrinsics.areEqual((Object) this.type, (Object) userInvoice.type) || !Intrinsics.areEqual((Object) this.createdAt, (Object) userInvoice.createdAt) || !Intrinsics.areEqual((Object) this.rejectedAt, (Object) userInvoice.rejectedAt) || !Intrinsics.areEqual((Object) this.reward, (Object) userInvoice.reward) || !Intrinsics.areEqual((Object) this.verifyAt, (Object) userInvoice.verifyAt) || !Intrinsics.areEqual((Object) this.rejectDescription, (Object) userInvoice.rejectDescription)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.action;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.type;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Date date = this.createdAt;
            int hashCode3 = (hashCode2 + (date != null ? date.hashCode() : 0)) * 31;
            Date date2 = this.rejectedAt;
            int hashCode4 = (hashCode3 + (date2 != null ? date2.hashCode() : 0)) * 31;
            PaymentHistory paymentHistory = this.reward;
            int hashCode5 = (hashCode4 + (paymentHistory != null ? paymentHistory.hashCode() : 0)) * 31;
            String str3 = this.verifyAt;
            int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.rejectDescription;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            return hashCode6 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("UserInvoice(id=");
            sb.append(this.id);
            sb.append(", action=");
            sb.append(this.action);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(", createdAt=");
            sb.append(this.createdAt);
            sb.append(", rejectedAt=");
            sb.append(this.rejectedAt);
            sb.append(", reward=");
            sb.append(this.reward);
            sb.append(", verifyAt=");
            sb.append(this.verifyAt);
            sb.append(", rejectDescription=");
            sb.append(this.rejectDescription);
            sb.append(")");
            return sb.toString();
        }

        public UserInvoice(long j, @NotNull String str, @NotNull String str2, @Nullable Date date, @Nullable Date date2, @Nullable PaymentHistory paymentHistory, @Nullable String str3, @Nullable String str4) {
            Intrinsics.checkParameterIsNotNull(str, NativeProtocol.WEB_DIALOG_ACTION);
            Intrinsics.checkParameterIsNotNull(str2, "type");
            this.id = j;
            this.action = str;
            this.type = str2;
            this.createdAt = date;
            this.rejectedAt = date2;
            this.reward = paymentHistory;
            this.verifyAt = str3;
            this.rejectDescription = str4;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final String getAction() {
            return this.action;
        }

        @NotNull
        @NonNull
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        public final Date getRejectedAt() {
            return this.rejectedAt;
        }

        @Nullable
        public final PaymentHistory getReward() {
            return this.reward;
        }

        @Nullable
        public final String getVerifyAt() {
            return this.verifyAt;
        }

        @Nullable
        public final String getRejectDescription() {
            return this.rejectDescription;
        }
    }

    public static final class UserShippingInfo {
        @SerializedName("shipping_address")
        @NotNull
        private final String address;
        @SerializedName("shipping_address2")
        @Nullable
        private final String address2;
        @SerializedName("shipping_contact")
        @NotNull
        private final String contact;
        @SerializedName("shipping_message")
        @Nullable
        private final String message;
        @SerializedName("shipping_name")
        @NotNull
        private final String name;
        @SerializedName("shipping_zipcode")
        @NotNull
        private final String zipCode;

        @NotNull
        public static /* synthetic */ UserShippingInfo copy$default(UserShippingInfo userShippingInfo, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userShippingInfo.name;
            }
            if ((i & 2) != 0) {
                str2 = userShippingInfo.contact;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = userShippingInfo.zipCode;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = userShippingInfo.address;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = userShippingInfo.address2;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = userShippingInfo.message;
            }
            return userShippingInfo.copy(str, str7, str8, str9, str10, str6);
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final String component2() {
            return this.contact;
        }

        @NotNull
        public final String component3() {
            return this.zipCode;
        }

        @NotNull
        public final String component4() {
            return this.address;
        }

        @Nullable
        public final String component5() {
            return this.address2;
        }

        @Nullable
        public final String component6() {
            return this.message;
        }

        @NotNull
        public final UserShippingInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "contact");
            Intrinsics.checkParameterIsNotNull(str3, "zipCode");
            Intrinsics.checkParameterIsNotNull(str4, MessageTemplateProtocol.ADDRESS);
            UserShippingInfo userShippingInfo = new UserShippingInfo(str, str2, str3, str4, str5, str6);
            return userShippingInfo;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.message, (java.lang.Object) r3.message) != false) goto L_0x0047;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x0047
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.user.UserAPI.UserShippingInfo
                if (r0 == 0) goto L_0x0045
                kr.co.popone.fitts.model.user.UserAPI$UserShippingInfo r3 = (kr.co.popone.fitts.model.user.UserAPI.UserShippingInfo) r3
                java.lang.String r0 = r2.name
                java.lang.String r1 = r3.name
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0045
                java.lang.String r0 = r2.contact
                java.lang.String r1 = r3.contact
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0045
                java.lang.String r0 = r2.zipCode
                java.lang.String r1 = r3.zipCode
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0045
                java.lang.String r0 = r2.address
                java.lang.String r1 = r3.address
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0045
                java.lang.String r0 = r2.address2
                java.lang.String r1 = r3.address2
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0045
                java.lang.String r0 = r2.message
                java.lang.String r3 = r3.message
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                if (r3 == 0) goto L_0x0045
                goto L_0x0047
            L_0x0045:
                r3 = 0
                return r3
            L_0x0047:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.user.UserAPI.UserShippingInfo.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.contact;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.zipCode;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.address;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.address2;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.message;
            if (str6 != null) {
                i = str6.hashCode();
            }
            return hashCode5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("UserShippingInfo(name=");
            sb.append(this.name);
            sb.append(", contact=");
            sb.append(this.contact);
            sb.append(", zipCode=");
            sb.append(this.zipCode);
            sb.append(", address=");
            sb.append(this.address);
            sb.append(", address2=");
            sb.append(this.address2);
            sb.append(", message=");
            sb.append(this.message);
            sb.append(")");
            return sb.toString();
        }

        public UserShippingInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "contact");
            Intrinsics.checkParameterIsNotNull(str3, "zipCode");
            Intrinsics.checkParameterIsNotNull(str4, MessageTemplateProtocol.ADDRESS);
            this.name = str;
            this.contact = str2;
            this.zipCode = str3;
            this.address = str4;
            this.address2 = str5;
            this.message = str6;
        }

        @NotNull
        @NonNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        @NonNull
        public final String getContact() {
            return this.contact;
        }

        @NotNull
        @NonNull
        public final String getZipCode() {
            return this.zipCode;
        }

        @NotNull
        @NonNull
        public final String getAddress() {
            return this.address;
        }

        @Nullable
        public final String getAddress2() {
            return this.address2;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }
    }

    @NotNull
    @DELETE("/api/v9/users/{id}/follows")
    @Headers({"Accept: application/json"})
    Single<FollowResult> deleteFollow(@Path("id") long j);

    @NotNull
    @DELETE("/api/v9/users/me/token")
    @Headers({"Accept: application/json"})
    Single<String> deletePushToken(@NotNull @Query("token") String str);

    @NotNull
    @DELETE("/api/v9/users/me")
    @Headers({"Accept: application/json"})
    Single<String> deleteUser();

    @NotNull
    @GET
    Single<ResponseBody> downloadSNSProfileImage(@NotNull @Url String str);

    @NotNull
    @GET("/api/v9/users/me/badge")
    @Headers({"Accept: application/json"})
    Single<AlarmCount> getAlarmCount();

    @NotNull
    @GET("/api/v9/check_available_recommend_user")
    @Headers({"Accept: application/json"})
    Single<Recommender> getAvaliableRecommender(@NotNull @Query("fittsid") String str);

    @NotNull
    @GET("/api/v9/users/me/count")
    @Headers({"Accept: application/json"})
    Single<BadgeCount> getBadgeCount();

    @NotNull
    @GET("/api/v9/users/{user_id}/likes")
    @Headers({"Accept: application/json"})
    Single<ArrayList<Post>> getLikedPosts(@Nullable @Path("user_id") Long l, @Nullable @Query("base") Long l2, @Query("limit") int i);

    @NotNull
    @GET("/api/v9/users/me/n_commerce")
    @Headers({"Accept: application/json"})
    Single<UserResponse$NCommerceResponse> getNCommerceInfo();

    @NotNull
    @GET("/api/v9/users/me/postable_olivs_info")
    @Headers({"Accept: application/json"})
    Single<PostableOrderLineItemVariant> getPostableOlivsInfo();

    @NotNull
    @GET("/api/v9/users/me/refund_accounts")
    @Headers({"Accept: application/json"})
    Single<RefundAccount> getRefundAccounts();

    @NotNull
    @GET("/api/v9/users/{user_id}/posts")
    @Headers({"Accept: application/json"})
    Single<ArrayList<Post>> getShowRoomPosts(@Path("user_id") long j, @NotNull @Query("type") String str, @Nullable @Query("base") Long l, @Query("limit") int i);

    @NotNull
    @GET("/api/v9/users/me")
    @Headers({"Accept: application/json"})
    Single<MyInfo> getUserInfo();

    @NotNull
    @POST("/api/v9/users/sign_out")
    @Headers({"Accept: application/json"})
    Single<String> logout();

    @NotNull
    @POST("/api/v9/users/me/refund_accounts")
    @Headers({"Accept: application/json"})
    Single<RefundAccount> postRefundAccounts(@NotNull @Query("bank_account_holder") String str, @NotNull @Query("bank_account_number") String str2, @NotNull @Query("bank_name") String str3);

    @PUT("/api/v9/users/{id}/follows")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<FollowResult> putFollow(@Path("id") long j);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/users")
    @Headers({"Accept: application/json"})
    Single<Me> requestCreateUser(@NotNull @Field("email") String str, @Field("auth_provider") @Nullable String str2, @Field("auth_token") @Nullable String str3, @NotNull @Field("fittsid") String str4, @NotNull @Field("password") String str5, @Field("height") int i, @Field("weight") int i2, @Field("shoe_size") int i3, @NotNull @Field("body_type") String str6, @Field("age") int i4, @NotNull @Field("body_filter") String str7, @NotNull @Field("styles") String str8, @Field("recommender_fittsid") @Nullable String str9);

    @NotNull
    @GET("/api/v9/users/email_available")
    @Headers({"Accept: application/json"})
    Observable<EmailAvailable> requestEmailAvailable(@Nullable @Query("email") String str);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/users/sign_in")
    @Headers({"Accept: application/json"})
    Single<Me> requestEmailLogin(@NotNull @Field("fittsid") String str, @NotNull @Field("password") String str2);

    @NotNull
    @GET("/api/v9/users/{user_id}/followers")
    @Headers({"Accept: application/json"})
    Single<List<User>> requestFollowers(@Path("user_id") long j, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @GET("/api/v9/users/{user_id}/followings")
    @Headers({"Accept: application/json"})
    Single<List<User>> requestFollowings(@Path("user_id") long j, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @GET("/api/v9/users/fittsid_available")
    @Headers({"Accept: application/json"})
    Single<IdAvailable> requestIdAvailable(@NotNull @Query("fittsid") String str);

    @NotNull
    @GET("/api/v9/users/me/ivs_info")
    @Headers({"Accept: application/json"})
    Single<IvsInfo> requestIvsInfo();

    @NotNull
    @GET("/api/v9/users/me/invoices/{id}")
    @Headers({"Accept: application/json"})
    Single<UserInvoice> requestMyInvoice(@Path("id") long j);

    @NotNull
    @GET("/api/v9/users/me/postable")
    @Headers({"Accept: application/json"})
    Single<PostableResponse> requestPostable();

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/users/sign_in")
    @Headers({"Accept: application/json"})
    Single<Me> requestSNSLogin(@NotNull @Field("auth_provider") String str, @NotNull @Field("auth_token") String str2);

    @NotNull
    @GET("/api/v9/users/me/shipping_address")
    @Headers({"Accept: application/json"})
    Single<ShippingAddressResponse> requestShippingAddress();

    @NotNull
    @GET("/api/v9/users/{user_id}/showroom")
    @Headers({"Accept: application/json"})
    Single<ShowRoom> requestShowRoomInfo(@Nullable @Path("user_id") Long l);

    @NotNull
    @POST("/api/v9/users/reset_password")
    @Headers({"Accept: application/json"})
    Completable resetPassword(@NotNull @Query("fittsid") String str);

    @NotNull
    @GET("/api/v9/users/me/reward_points")
    @Headers({"Accept: application/json"})
    Single<PointInfo> rewardPoints();

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/users/me/web_log")
    @Headers({"Accept: application/json"})
    Completable sendWebLog(@NotNull @Field("page_url") String str, @NotNull @Field("entry_point") String str2);

    @FormUrlEncoded
    @PUT("/api/v9/users/me")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<MyInfo> setUserInfo(@Field("body_info") @Nullable String str, @Field("body_filter") @Nullable String str2, @Field("styles") @Nullable String str3, @Field("showroom_intro") @Nullable String str4, @Field("top") @Nullable String str5, @Field("bottom") @Nullable String str6, @Field("shoe_size") @Nullable Integer num, @Field("shoe_description") @Nullable String str7);

    @FormUrlEncoded
    @PUT("/api/v9/users/me/additional_info")
    @NotNull
    @Headers({"Accept: application/json"})
    Completable updateAdditionalInfo(@Field("name") @Nullable String str, @Field("contact") @Nullable String str2, @Field("body_description") @Nullable String str3, @Field("top") @Nullable String str4, @Field("bottom") @Nullable String str5, @Field("shoe_size") @Nullable Integer num, @Field("shoe_description") @Nullable String str6, @Field("recommender") @Nullable String str7);

    @FormUrlEncoded
    @PUT("/api/v9/users/me/token")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<String> updateFCMToken(@NotNull @Field("token") String str, @NotNull @Field("platform") String str2);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/users/me/ivs_info")
    @Headers({"Accept: application/json"})
    Completable updateIvsInfo(@NotNull @Field("ssn") String str);

    @FormUrlEncoded
    @PUT("/api/v9/users/me/agreements/marketing")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<AlarmAgreement> uploadAgreements(@Field("marketing_agreement") boolean z);

    @Multipart
    @NotNull
    @POST("/api/v9/uploads")
    @Headers({"Accept: application/json"})
    Single<ResponseImageId> uploadFile(@NotNull @Part MultipartBody.Part part);

    @PUT("/api/v9/users/me")
    @Multipart
    @NotNull
    @Headers({"Accept: application/json"})
    Single<MyInfo> uploadProfile(@NotNull @Part MultipartBody.Part part);

    @FormUrlEncoded
    @PUT("/api/v9/users/me/showroom")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<String> uploadShowroomImage(@Field("cover_image") int i);
}
