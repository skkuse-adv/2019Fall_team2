package kr.co.popone.fitts.model.datamodel.service.alarm;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;
import kr.co.popone.fitts.model.datamodel.service.post.Comment;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.user.UserAPI.UserInvoice;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class Alarm {
    @SerializedName("application")
    @Nullable
    private final Enroll application;
    @SerializedName("collection")
    @Nullable
    private final CollectionDetailResponse collection;
    @SerializedName("comment")
    @Nullable
    private final Comment comment;
    @SerializedName("created_at")
    @NotNull
    private final String createdAt;
    private final long id;
    @SerializedName("message")
    @NotNull
    private String message;
    @SerializedName("post")
    @Nullable
    private final Post post;
    @SerializedName("recommend")
    @Nullable
    private final Recommend recommend;
    @SerializedName("reward")
    @Nullable
    private final Reward reward;
    @SerializedName("reward_invoice")
    @Nullable
    private final PaymentUsage rewardInvoice;
    @SerializedName("scheme")
    @Nullable
    private final String scheme;
    @SerializedName("state")
    @Nullable
    private final String state;
    @SerializedName("type")
    @Nullable
    private final Type type;
    @SerializedName("user")
    @Nullable
    private final User user;
    @SerializedName("user_invoice")
    @Nullable
    private final UserInvoice userInvoice;

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Enroll {
        @SerializedName("created_at")
        @NotNull
        private final String createdAt;
        @SerializedName("status")
        @NotNull
        private final String enrollStatus;
        @SerializedName("id")
        private final long id;
        @SerializedName("reject_description")
        @Nullable
        private final String rejectDescription;
        @SerializedName("rejected_at")
        @Nullable
        private final String rejectedAt;
        @SerializedName("reward_points_at_confirm")
        private final int rewardPoints;

        @NotNull
        public static /* synthetic */ Enroll copy$default(Enroll enroll, long j, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
            Enroll enroll2 = enroll;
            return enroll.copy((i2 & 1) != 0 ? enroll2.id : j, (i2 & 2) != 0 ? enroll2.enrollStatus : str, (i2 & 4) != 0 ? enroll2.createdAt : str2, (i2 & 8) != 0 ? enroll2.rejectDescription : str3, (i2 & 16) != 0 ? enroll2.rejectedAt : str4, (i2 & 32) != 0 ? enroll2.rewardPoints : i);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.enrollStatus;
        }

        @NotNull
        public final String component3() {
            return this.createdAt;
        }

        @Nullable
        public final String component4() {
            return this.rejectDescription;
        }

        @Nullable
        public final String component5() {
            return this.rejectedAt;
        }

        public final int component6() {
            return this.rewardPoints;
        }

        @NotNull
        public final Enroll copy(long j, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, int i) {
            String str5 = str;
            Intrinsics.checkParameterIsNotNull(str, "enrollStatus");
            String str6 = str2;
            Intrinsics.checkParameterIsNotNull(str2, "createdAt");
            Enroll enroll = new Enroll(j, str5, str6, str3, str4, i);
            return enroll;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Enroll) {
                    Enroll enroll = (Enroll) obj;
                    if ((this.id == enroll.id) && Intrinsics.areEqual((Object) this.enrollStatus, (Object) enroll.enrollStatus) && Intrinsics.areEqual((Object) this.createdAt, (Object) enroll.createdAt) && Intrinsics.areEqual((Object) this.rejectDescription, (Object) enroll.rejectDescription) && Intrinsics.areEqual((Object) this.rejectedAt, (Object) enroll.rejectedAt)) {
                        if (this.rewardPoints == enroll.rewardPoints) {
                            return true;
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
            String str = this.enrollStatus;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.createdAt;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.rejectDescription;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.rejectedAt;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            return ((hashCode3 + i2) * 31) + this.rewardPoints;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Enroll(id=");
            sb.append(this.id);
            sb.append(", enrollStatus=");
            sb.append(this.enrollStatus);
            sb.append(", createdAt=");
            sb.append(this.createdAt);
            sb.append(", rejectDescription=");
            sb.append(this.rejectDescription);
            sb.append(", rejectedAt=");
            sb.append(this.rejectedAt);
            sb.append(", rewardPoints=");
            sb.append(this.rewardPoints);
            sb.append(")");
            return sb.toString();
        }

        public Enroll(long j, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, int i) {
            Intrinsics.checkParameterIsNotNull(str, "enrollStatus");
            Intrinsics.checkParameterIsNotNull(str2, "createdAt");
            this.id = j;
            this.enrollStatus = str;
            this.createdAt = str2;
            this.rejectDescription = str3;
            this.rejectedAt = str4;
            this.rewardPoints = i;
        }

        @NonNull
        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final String getEnrollStatus() {
            return this.enrollStatus;
        }

        @NotNull
        @NonNull
        public final String getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        public final String getRejectDescription() {
            return this.rejectDescription;
        }

        @Nullable
        public final String getRejectedAt() {
            return this.rejectedAt;
        }

        @NonNull
        public final int getRewardPoints() {
            return this.rewardPoints;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Recommend {
        @SerializedName("id")
        private final long id;
        @SerializedName("recommendee")
        @NotNull
        private final User recommendee;
        @SerializedName("recommender")
        @NotNull
        private final User recommender;

        @NotNull
        public static /* synthetic */ Recommend copy$default(Recommend recommend, long j, User user, User user2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = recommend.id;
            }
            if ((i & 2) != 0) {
                user = recommend.recommendee;
            }
            if ((i & 4) != 0) {
                user2 = recommend.recommender;
            }
            return recommend.copy(j, user, user2);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final User component2() {
            return this.recommendee;
        }

        @NotNull
        public final User component3() {
            return this.recommender;
        }

        @NotNull
        public final Recommend copy(long j, @NotNull User user, @NotNull User user2) {
            Intrinsics.checkParameterIsNotNull(user, "recommendee");
            Intrinsics.checkParameterIsNotNull(user2, "recommender");
            return new Recommend(j, user, user2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Recommend) {
                    Recommend recommend = (Recommend) obj;
                    if (!(this.id == recommend.id) || !Intrinsics.areEqual((Object) this.recommendee, (Object) recommend.recommendee) || !Intrinsics.areEqual((Object) this.recommender, (Object) recommend.recommender)) {
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
            User user = this.recommendee;
            int i2 = 0;
            int hashCode = (i + (user != null ? user.hashCode() : 0)) * 31;
            User user2 = this.recommender;
            if (user2 != null) {
                i2 = user2.hashCode();
            }
            return hashCode + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Recommend(id=");
            sb.append(this.id);
            sb.append(", recommendee=");
            sb.append(this.recommendee);
            sb.append(", recommender=");
            sb.append(this.recommender);
            sb.append(")");
            return sb.toString();
        }

        public Recommend(long j, @NotNull User user, @NotNull User user2) {
            Intrinsics.checkParameterIsNotNull(user, "recommendee");
            Intrinsics.checkParameterIsNotNull(user2, "recommender");
            this.id = j;
            this.recommendee = user;
            this.recommender = user2;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final User getRecommendee() {
            return this.recommendee;
        }

        @NotNull
        @NonNull
        public final User getRecommender() {
            return this.recommender;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Reward {
        @SerializedName("created_at")
        @Nullable
        private final Date createdAt;
        @SerializedName("id")
        private final long id;
        @SerializedName("message")
        @Nullable
        private final String message;
        @SerializedName("type")
        @Nullable
        private final String type;
        @SerializedName("value")
        private final int value;

        @NotNull
        public static /* synthetic */ Reward copy$default(Reward reward, long j, String str, int i, String str2, Date date, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = reward.id;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                str = reward.type;
            }
            String str3 = str;
            if ((i2 & 4) != 0) {
                i = reward.value;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                str2 = reward.message;
            }
            String str4 = str2;
            if ((i2 & 16) != 0) {
                date = reward.createdAt;
            }
            return reward.copy(j2, str3, i3, str4, date);
        }

        public final long component1() {
            return this.id;
        }

        @Nullable
        public final String component2() {
            return this.type;
        }

        public final int component3() {
            return this.value;
        }

        @Nullable
        public final String component4() {
            return this.message;
        }

        @Nullable
        public final Date component5() {
            return this.createdAt;
        }

        @NotNull
        public final Reward copy(long j, @Nullable String str, int i, @Nullable String str2, @Nullable Date date) {
            Reward reward = new Reward(j, str, i, str2, date);
            return reward;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Reward) {
                    Reward reward = (Reward) obj;
                    if ((this.id == reward.id) && Intrinsics.areEqual((Object) this.type, (Object) reward.type)) {
                        if (!(this.value == reward.value) || !Intrinsics.areEqual((Object) this.message, (Object) reward.message) || !Intrinsics.areEqual((Object) this.createdAt, (Object) reward.createdAt)) {
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
            sb.append("Reward(id=");
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

        public Reward(long j, @Nullable String str, int i, @Nullable String str2, @Nullable Date date) {
            this.id = j;
            this.type = str;
            this.value = i;
            this.message = str2;
            this.createdAt = date;
        }

        public final long getId() {
            return this.id;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        public final int getValue() {
            return this.value;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final Date getCreatedAt() {
            return this.createdAt;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public enum Type {
        POST,
        LIKE,
        COMMENT,
        FOLLOW,
        MENTION,
        POST_INVOICE,
        RECOMMENDER,
        MEMBERSHIP_INVOICE
    }

    @NotNull
    public static /* synthetic */ Alarm copy$default(Alarm alarm, long j, Type type2, String str, User user2, String str2, String str3, PaymentUsage paymentUsage, Enroll enroll, UserInvoice userInvoice2, Post post2, CollectionDetailResponse collectionDetailResponse, Comment comment2, String str4, Reward reward2, Recommend recommend2, int i, Object obj) {
        Alarm alarm2 = alarm;
        int i2 = i;
        return alarm.copy((i2 & 1) != 0 ? alarm2.id : j, (i2 & 2) != 0 ? alarm2.type : type2, (i2 & 4) != 0 ? alarm2.state : str, (i2 & 8) != 0 ? alarm2.user : user2, (i2 & 16) != 0 ? alarm2.message : str2, (i2 & 32) != 0 ? alarm2.createdAt : str3, (i2 & 64) != 0 ? alarm2.rewardInvoice : paymentUsage, (i2 & 128) != 0 ? alarm2.application : enroll, (i2 & 256) != 0 ? alarm2.userInvoice : userInvoice2, (i2 & 512) != 0 ? alarm2.post : post2, (i2 & 1024) != 0 ? alarm2.collection : collectionDetailResponse, (i2 & 2048) != 0 ? alarm2.comment : comment2, (i2 & 4096) != 0 ? alarm2.scheme : str4, (i2 & 8192) != 0 ? alarm2.reward : reward2, (i2 & 16384) != 0 ? alarm2.recommend : recommend2);
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final Post component10() {
        return this.post;
    }

    @Nullable
    public final CollectionDetailResponse component11() {
        return this.collection;
    }

    @Nullable
    public final Comment component12() {
        return this.comment;
    }

    @Nullable
    public final String component13() {
        return this.scheme;
    }

    @Nullable
    public final Reward component14() {
        return this.reward;
    }

    @Nullable
    public final Recommend component15() {
        return this.recommend;
    }

    @Nullable
    public final Type component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.state;
    }

    @Nullable
    public final User component4() {
        return this.user;
    }

    @NotNull
    public final String component5() {
        return this.message;
    }

    @NotNull
    public final String component6() {
        return this.createdAt;
    }

    @Nullable
    public final PaymentUsage component7() {
        return this.rewardInvoice;
    }

    @Nullable
    public final Enroll component8() {
        return this.application;
    }

    @Nullable
    public final UserInvoice component9() {
        return this.userInvoice;
    }

    @NotNull
    public final Alarm copy(long j, @Nullable Type type2, @Nullable String str, @Nullable User user2, @NotNull String str2, @NotNull String str3, @Nullable PaymentUsage paymentUsage, @Nullable Enroll enroll, @Nullable UserInvoice userInvoice2, @Nullable Post post2, @Nullable CollectionDetailResponse collectionDetailResponse, @Nullable Comment comment2, @Nullable String str4, @Nullable Reward reward2, @Nullable Recommend recommend2) {
        long j2 = j;
        Type type3 = type2;
        String str5 = str;
        User user3 = user2;
        String str6 = str2;
        String str7 = str3;
        PaymentUsage paymentUsage2 = paymentUsage;
        Enroll enroll2 = enroll;
        UserInvoice userInvoice3 = userInvoice2;
        Post post3 = post2;
        CollectionDetailResponse collectionDetailResponse2 = collectionDetailResponse;
        Comment comment3 = comment2;
        String str8 = str4;
        Reward reward3 = reward2;
        Recommend recommend3 = recommend2;
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(str3, "createdAt");
        Alarm alarm = new Alarm(j, type3, str5, user3, str6, str7, paymentUsage2, enroll2, userInvoice3, post3, collectionDetailResponse2, comment3, str8, reward3, recommend3);
        return alarm;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Alarm) {
                Alarm alarm = (Alarm) obj;
                if (!(this.id == alarm.id) || !Intrinsics.areEqual((Object) this.type, (Object) alarm.type) || !Intrinsics.areEqual((Object) this.state, (Object) alarm.state) || !Intrinsics.areEqual((Object) this.user, (Object) alarm.user) || !Intrinsics.areEqual((Object) this.message, (Object) alarm.message) || !Intrinsics.areEqual((Object) this.createdAt, (Object) alarm.createdAt) || !Intrinsics.areEqual((Object) this.rewardInvoice, (Object) alarm.rewardInvoice) || !Intrinsics.areEqual((Object) this.application, (Object) alarm.application) || !Intrinsics.areEqual((Object) this.userInvoice, (Object) alarm.userInvoice) || !Intrinsics.areEqual((Object) this.post, (Object) alarm.post) || !Intrinsics.areEqual((Object) this.collection, (Object) alarm.collection) || !Intrinsics.areEqual((Object) this.comment, (Object) alarm.comment) || !Intrinsics.areEqual((Object) this.scheme, (Object) alarm.scheme) || !Intrinsics.areEqual((Object) this.reward, (Object) alarm.reward) || !Intrinsics.areEqual((Object) this.recommend, (Object) alarm.recommend)) {
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
        Type type2 = this.type;
        int i2 = 0;
        int hashCode = (i + (type2 != null ? type2.hashCode() : 0)) * 31;
        String str = this.state;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        User user2 = this.user;
        int hashCode3 = (hashCode2 + (user2 != null ? user2.hashCode() : 0)) * 31;
        String str2 = this.message;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.createdAt;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PaymentUsage paymentUsage = this.rewardInvoice;
        int hashCode6 = (hashCode5 + (paymentUsage != null ? paymentUsage.hashCode() : 0)) * 31;
        Enroll enroll = this.application;
        int hashCode7 = (hashCode6 + (enroll != null ? enroll.hashCode() : 0)) * 31;
        UserInvoice userInvoice2 = this.userInvoice;
        int hashCode8 = (hashCode7 + (userInvoice2 != null ? userInvoice2.hashCode() : 0)) * 31;
        Post post2 = this.post;
        int hashCode9 = (hashCode8 + (post2 != null ? post2.hashCode() : 0)) * 31;
        CollectionDetailResponse collectionDetailResponse = this.collection;
        int hashCode10 = (hashCode9 + (collectionDetailResponse != null ? collectionDetailResponse.hashCode() : 0)) * 31;
        Comment comment2 = this.comment;
        int hashCode11 = (hashCode10 + (comment2 != null ? comment2.hashCode() : 0)) * 31;
        String str4 = this.scheme;
        int hashCode12 = (hashCode11 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Reward reward2 = this.reward;
        int hashCode13 = (hashCode12 + (reward2 != null ? reward2.hashCode() : 0)) * 31;
        Recommend recommend2 = this.recommend;
        if (recommend2 != null) {
            i2 = recommend2.hashCode();
        }
        return hashCode13 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alarm(id=");
        sb.append(this.id);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", user=");
        sb.append(this.user);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", rewardInvoice=");
        sb.append(this.rewardInvoice);
        sb.append(", application=");
        sb.append(this.application);
        sb.append(", userInvoice=");
        sb.append(this.userInvoice);
        sb.append(", post=");
        sb.append(this.post);
        sb.append(", collection=");
        sb.append(this.collection);
        sb.append(", comment=");
        sb.append(this.comment);
        sb.append(", scheme=");
        sb.append(this.scheme);
        sb.append(", reward=");
        sb.append(this.reward);
        sb.append(", recommend=");
        sb.append(this.recommend);
        sb.append(")");
        return sb.toString();
    }

    public Alarm(long j, @Nullable Type type2, @Nullable String str, @Nullable User user2, @NotNull String str2, @NotNull String str3, @Nullable PaymentUsage paymentUsage, @Nullable Enroll enroll, @Nullable UserInvoice userInvoice2, @Nullable Post post2, @Nullable CollectionDetailResponse collectionDetailResponse, @Nullable Comment comment2, @Nullable String str4, @Nullable Reward reward2, @Nullable Recommend recommend2) {
        String str5 = str2;
        String str6 = str3;
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(str3, "createdAt");
        this.id = j;
        this.type = type2;
        this.state = str;
        this.user = user2;
        this.message = str5;
        this.createdAt = str6;
        this.rewardInvoice = paymentUsage;
        this.application = enroll;
        this.userInvoice = userInvoice2;
        this.post = post2;
        this.collection = collectionDetailResponse;
        this.comment = comment2;
        this.scheme = str4;
        this.reward = reward2;
        this.recommend = recommend2;
    }

    @NonNull
    public final long getId() {
        return this.id;
    }

    @Nullable
    public final Type getType() {
        return this.type;
    }

    @Nullable
    public final String getState() {
        return this.state;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    @NotNull
    @NonNull
    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.message = str;
    }

    @NotNull
    @NonNull
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final PaymentUsage getRewardInvoice() {
        return this.rewardInvoice;
    }

    @Nullable
    public final Enroll getApplication() {
        return this.application;
    }

    @Nullable
    public final UserInvoice getUserInvoice() {
        return this.userInvoice;
    }

    @Nullable
    public final Post getPost() {
        return this.post;
    }

    @Nullable
    public final CollectionDetailResponse getCollection() {
        return this.collection;
    }

    @Nullable
    public final Comment getComment() {
        return this.comment;
    }

    @Nullable
    public final String getScheme() {
        return this.scheme;
    }

    @Nullable
    public final Reward getReward() {
        return this.reward;
    }

    @Nullable
    public final Recommend getRecommend() {
        return this.recommend;
    }
}
