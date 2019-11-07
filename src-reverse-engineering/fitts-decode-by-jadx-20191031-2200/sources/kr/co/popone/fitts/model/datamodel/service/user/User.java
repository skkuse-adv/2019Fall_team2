package kr.co.popone.fitts.model.datamodel.service.user;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class User {
    @SerializedName("body_info")
    @Nullable
    private final BodyInfo bodyInfo;
    @Nullable
    private final String email;
    @SerializedName("fittsid")
    @NotNull
    private final String fittsID;
    @SerializedName("followers_count")
    @Nullable
    private Integer followersCount;
    @SerializedName("followings_count")
    @Nullable
    private Integer followingsCount;
    private final long id;
    @SerializedName("following")
    private boolean isFollowing;
    @SerializedName("is_suitable")
    private final boolean isSuitable;
    @SerializedName("posts_count")
    @Nullable
    private final Integer postsCount;
    @SerializedName("profile_image_url")
    @NotNull
    private String profileImageUrl;
    @SerializedName("required_additional_info")
    private final boolean requiredAdditionalInfo;
    @SerializedName("reward_points")
    @Nullable
    private final String rewardPoints;
    @SerializedName("state")
    @Nullable
    private final String status;
    @NotNull
    private final List<String> styles;
    @SerializedName("verify_state")
    @Nullable
    private final String verifyState;

    @NotNull
    public static /* synthetic */ User copy$default(User user, long j, String str, String str2, String str3, String str4, boolean z, String str5, String str6, boolean z2, BodyInfo bodyInfo2, Integer num, Integer num2, Integer num3, boolean z3, List list, int i, Object obj) {
        User user2 = user;
        int i2 = i;
        return user.copy((i2 & 1) != 0 ? user2.id : j, (i2 & 2) != 0 ? user2.email : str, (i2 & 4) != 0 ? user2.fittsID : str2, (i2 & 8) != 0 ? user2.status : str3, (i2 & 16) != 0 ? user2.verifyState : str4, (i2 & 32) != 0 ? user2.requiredAdditionalInfo : z, (i2 & 64) != 0 ? user2.profileImageUrl : str5, (i2 & 128) != 0 ? user2.rewardPoints : str6, (i2 & 256) != 0 ? user2.isFollowing : z2, (i2 & 512) != 0 ? user2.bodyInfo : bodyInfo2, (i2 & 1024) != 0 ? user2.followingsCount : num, (i2 & 2048) != 0 ? user2.followersCount : num2, (i2 & 4096) != 0 ? user2.postsCount : num3, (i2 & 8192) != 0 ? user2.isSuitable : z3, (i2 & 16384) != 0 ? user2.styles : list);
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final BodyInfo component10() {
        return this.bodyInfo;
    }

    @Nullable
    public final Integer component11() {
        return this.followingsCount;
    }

    @Nullable
    public final Integer component12() {
        return this.followersCount;
    }

    @Nullable
    public final Integer component13() {
        return this.postsCount;
    }

    public final boolean component14() {
        return this.isSuitable;
    }

    @NotNull
    public final List<String> component15() {
        return this.styles;
    }

    @Nullable
    public final String component2() {
        return this.email;
    }

    @NotNull
    public final String component3() {
        return this.fittsID;
    }

    @Nullable
    public final String component4() {
        return this.status;
    }

    @Nullable
    public final String component5() {
        return this.verifyState;
    }

    public final boolean component6() {
        return this.requiredAdditionalInfo;
    }

    @NotNull
    public final String component7() {
        return this.profileImageUrl;
    }

    @Nullable
    public final String component8() {
        return this.rewardPoints;
    }

    public final boolean component9() {
        return this.isFollowing;
    }

    @NotNull
    public final User copy(long j, @Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, boolean z, @NotNull String str5, @Nullable String str6, boolean z2, @Nullable BodyInfo bodyInfo2, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, boolean z3, @NotNull List<String> list) {
        long j2 = j;
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        boolean z4 = z;
        String str11 = str5;
        String str12 = str6;
        boolean z5 = z2;
        BodyInfo bodyInfo3 = bodyInfo2;
        Integer num4 = num;
        Integer num5 = num2;
        Integer num6 = num3;
        boolean z6 = z3;
        List<String> list2 = list;
        Intrinsics.checkParameterIsNotNull(str2, "fittsID");
        Intrinsics.checkParameterIsNotNull(str5, "profileImageUrl");
        Intrinsics.checkParameterIsNotNull(list, "styles");
        User user = new User(j, str7, str8, str9, str10, z4, str11, str12, z5, bodyInfo3, num4, num5, num6, z6, list2);
        return user;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof User) {
                User user = (User) obj;
                if ((this.id == user.id) && Intrinsics.areEqual((Object) this.email, (Object) user.email) && Intrinsics.areEqual((Object) this.fittsID, (Object) user.fittsID) && Intrinsics.areEqual((Object) this.status, (Object) user.status) && Intrinsics.areEqual((Object) this.verifyState, (Object) user.verifyState)) {
                    if ((this.requiredAdditionalInfo == user.requiredAdditionalInfo) && Intrinsics.areEqual((Object) this.profileImageUrl, (Object) user.profileImageUrl) && Intrinsics.areEqual((Object) this.rewardPoints, (Object) user.rewardPoints)) {
                        if ((this.isFollowing == user.isFollowing) && Intrinsics.areEqual((Object) this.bodyInfo, (Object) user.bodyInfo) && Intrinsics.areEqual((Object) this.followingsCount, (Object) user.followingsCount) && Intrinsics.areEqual((Object) this.followersCount, (Object) user.followersCount) && Intrinsics.areEqual((Object) this.postsCount, (Object) user.postsCount)) {
                            if (!(this.isSuitable == user.isSuitable) || !Intrinsics.areEqual((Object) this.styles, (Object) user.styles)) {
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
        String str = this.email;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.fittsID;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.verifyState;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.requiredAdditionalInfo;
        if (z) {
            z = true;
        }
        int i3 = (hashCode4 + (z ? 1 : 0)) * 31;
        String str5 = this.profileImageUrl;
        int hashCode5 = (i3 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.rewardPoints;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z2 = this.isFollowing;
        if (z2) {
            z2 = true;
        }
        int i4 = (hashCode6 + (z2 ? 1 : 0)) * 31;
        BodyInfo bodyInfo2 = this.bodyInfo;
        int hashCode7 = (i4 + (bodyInfo2 != null ? bodyInfo2.hashCode() : 0)) * 31;
        Integer num = this.followingsCount;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.followersCount;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.postsCount;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 31;
        boolean z3 = this.isSuitable;
        if (z3) {
            z3 = true;
        }
        int i5 = (hashCode10 + (z3 ? 1 : 0)) * 31;
        List<String> list = this.styles;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i5 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User(id=");
        sb.append(this.id);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(", fittsID=");
        sb.append(this.fittsID);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", verifyState=");
        sb.append(this.verifyState);
        sb.append(", requiredAdditionalInfo=");
        sb.append(this.requiredAdditionalInfo);
        sb.append(", profileImageUrl=");
        sb.append(this.profileImageUrl);
        sb.append(", rewardPoints=");
        sb.append(this.rewardPoints);
        sb.append(", isFollowing=");
        sb.append(this.isFollowing);
        sb.append(", bodyInfo=");
        sb.append(this.bodyInfo);
        sb.append(", followingsCount=");
        sb.append(this.followingsCount);
        sb.append(", followersCount=");
        sb.append(this.followersCount);
        sb.append(", postsCount=");
        sb.append(this.postsCount);
        sb.append(", isSuitable=");
        sb.append(this.isSuitable);
        sb.append(", styles=");
        sb.append(this.styles);
        sb.append(")");
        return sb.toString();
    }

    public User(long j, @Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, boolean z, @NotNull String str5, @Nullable String str6, boolean z2, @Nullable BodyInfo bodyInfo2, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, boolean z3, @NotNull List<String> list) {
        String str7 = str2;
        String str8 = str5;
        List<String> list2 = list;
        Intrinsics.checkParameterIsNotNull(str2, "fittsID");
        Intrinsics.checkParameterIsNotNull(str5, "profileImageUrl");
        Intrinsics.checkParameterIsNotNull(list2, "styles");
        this.id = j;
        this.email = str;
        this.fittsID = str7;
        this.status = str3;
        this.verifyState = str4;
        this.requiredAdditionalInfo = z;
        this.profileImageUrl = str8;
        this.rewardPoints = str6;
        this.isFollowing = z2;
        this.bodyInfo = bodyInfo2;
        this.followingsCount = num;
        this.followersCount = num2;
        this.postsCount = num3;
        this.isSuitable = z3;
        this.styles = list2;
    }

    @NonNull
    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @NotNull
    @NonNull
    public final String getFittsID() {
        return this.fittsID;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getVerifyState() {
        return this.verifyState;
    }

    public final boolean getRequiredAdditionalInfo() {
        return this.requiredAdditionalInfo;
    }

    @NotNull
    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public final void setProfileImageUrl(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.profileImageUrl = str;
    }

    @Nullable
    public final String getRewardPoints() {
        return this.rewardPoints;
    }

    @NonNull
    public final boolean isFollowing() {
        return this.isFollowing;
    }

    public final void setFollowing(boolean z) {
        this.isFollowing = z;
    }

    @Nullable
    public final BodyInfo getBodyInfo() {
        return this.bodyInfo;
    }

    @Nullable
    public final Integer getFollowingsCount() {
        return this.followingsCount;
    }

    public final void setFollowingsCount(@Nullable Integer num) {
        this.followingsCount = num;
    }

    @Nullable
    public final Integer getFollowersCount() {
        return this.followersCount;
    }

    public final void setFollowersCount(@Nullable Integer num) {
        this.followersCount = num;
    }

    @Nullable
    public final Integer getPostsCount() {
        return this.postsCount;
    }

    public final boolean isSuitable() {
        return this.isSuitable;
    }

    @NotNull
    public final List<String> getStyles() {
        return this.styles;
    }

    public final int getFollowStateResource() {
        return this.isFollowing ? C0008R$drawable.round_button_following : C0008R$drawable.round_button_follow;
    }

    @NotNull
    public final String getFollowStateText() {
        return this.isFollowing ? "팔로잉" : "팔로우";
    }

    public final int getFollowStateTextColor() {
        if (this.isFollowing) {
            return C0006R$color.gray4;
        }
        return 17170443;
    }
}
