package kr.co.popone.fitts.model.datamodel.service.user;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class MyInfo implements Serializable {
    @SerializedName("state")
    @NotNull
    private final String activeStatus;
    @SerializedName("body_filter")
    @Nullable
    private final BodyFilter bodyFilter;
    @SerializedName("body_info")
    @NotNull
    private final BodyInfo bodyInfo;
    @SerializedName("contact_info")
    @NotNull
    private final ContactInfo contactInfo;
    @SerializedName("email")
    @NotNull
    private final String email;
    @SerializedName("fittsid")
    @NotNull
    private final String fittsID;
    @SerializedName("followers_count")
    private final int followersCount;
    @SerializedName("followings_count")
    private int followingsCount;
    private final long id;
    @SerializedName("following")
    private boolean isFollowing;
    @SerializedName("likes_count")
    @Nullable
    private Integer likesCount;
    @SerializedName("posts_count")
    @Nullable
    private final Integer postsCount;
    @SerializedName("profile_image_url")
    @NotNull
    private final String profileImageUrl;
    @SerializedName("required_additional_info")
    private final boolean requiredAdditionalInfo;
    @SerializedName("required_clothes_size")
    private final boolean requiredClothesSize;
    @SerializedName("required_contact_info")
    private final boolean requiredContactInfo;
    @SerializedName("required_recommend_fitties")
    private final boolean requiredFittieRecommend;
    @SerializedName("required_shoe_description")
    private final boolean requiredFootDescription;
    @SerializedName("required_identity_verification_service")
    private final boolean requiredIdentityVerify;
    @SerializedName("required_shoe_size")
    private final boolean requiredShoeSize;
    @SerializedName("reward_points")
    private final int rewardPoints;
    @NotNull
    private final List<String> styles;
    @SerializedName("verify_state")
    @Nullable
    private final String verifyState;

    @NotNull
    public static /* synthetic */ MyInfo copy$default(MyInfo myInfo, long j, String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, ContactInfo contactInfo2, String str5, boolean z8, BodyInfo bodyInfo2, BodyFilter bodyFilter2, int i, int i2, int i3, Integer num, Integer num2, List list, int i4, Object obj) {
        MyInfo myInfo2 = myInfo;
        int i5 = i4;
        return myInfo.copy((i5 & 1) != 0 ? myInfo2.id : j, (i5 & 2) != 0 ? myInfo2.email : str, (i5 & 4) != 0 ? myInfo2.fittsID : str2, (i5 & 8) != 0 ? myInfo2.activeStatus : str3, (i5 & 16) != 0 ? myInfo2.verifyState : str4, (i5 & 32) != 0 ? myInfo2.requiredAdditionalInfo : z, (i5 & 64) != 0 ? myInfo2.requiredClothesSize : z2, (i5 & 128) != 0 ? myInfo2.requiredShoeSize : z3, (i5 & 256) != 0 ? myInfo2.requiredContactInfo : z4, (i5 & 512) != 0 ? myInfo2.requiredIdentityVerify : z5, (i5 & 1024) != 0 ? myInfo2.requiredFootDescription : z6, (i5 & 2048) != 0 ? myInfo2.requiredFittieRecommend : z7, (i5 & 4096) != 0 ? myInfo2.contactInfo : contactInfo2, (i5 & 8192) != 0 ? myInfo2.profileImageUrl : str5, (i5 & 16384) != 0 ? myInfo2.isFollowing : z8, (i5 & 32768) != 0 ? myInfo2.bodyInfo : bodyInfo2, (i5 & 65536) != 0 ? myInfo2.bodyFilter : bodyFilter2, (i5 & 131072) != 0 ? myInfo2.rewardPoints : i, (i5 & 262144) != 0 ? myInfo2.followingsCount : i2, (i5 & 524288) != 0 ? myInfo2.followersCount : i3, (i5 & 1048576) != 0 ? myInfo2.likesCount : num, (i5 & 2097152) != 0 ? myInfo2.postsCount : num2, (i5 & 4194304) != 0 ? myInfo2.styles : list);
    }

    public final long component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.requiredIdentityVerify;
    }

    public final boolean component11() {
        return this.requiredFootDescription;
    }

    public final boolean component12() {
        return this.requiredFittieRecommend;
    }

    @NotNull
    public final ContactInfo component13() {
        return this.contactInfo;
    }

    @NotNull
    public final String component14() {
        return this.profileImageUrl;
    }

    public final boolean component15() {
        return this.isFollowing;
    }

    @NotNull
    public final BodyInfo component16() {
        return this.bodyInfo;
    }

    @Nullable
    public final BodyFilter component17() {
        return this.bodyFilter;
    }

    public final int component18() {
        return this.rewardPoints;
    }

    public final int component19() {
        return this.followingsCount;
    }

    @NotNull
    public final String component2() {
        return this.email;
    }

    public final int component20() {
        return this.followersCount;
    }

    @Nullable
    public final Integer component21() {
        return this.likesCount;
    }

    @Nullable
    public final Integer component22() {
        return this.postsCount;
    }

    @NotNull
    public final List<String> component23() {
        return this.styles;
    }

    @NotNull
    public final String component3() {
        return this.fittsID;
    }

    @NotNull
    public final String component4() {
        return this.activeStatus;
    }

    @Nullable
    public final String component5() {
        return this.verifyState;
    }

    public final boolean component6() {
        return this.requiredAdditionalInfo;
    }

    public final boolean component7() {
        return this.requiredClothesSize;
    }

    public final boolean component8() {
        return this.requiredShoeSize;
    }

    public final boolean component9() {
        return this.requiredContactInfo;
    }

    @NotNull
    public final MyInfo copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, @NotNull ContactInfo contactInfo2, @NotNull String str5, boolean z8, @NotNull BodyInfo bodyInfo2, @Nullable BodyFilter bodyFilter2, int i, int i2, int i3, @Nullable Integer num, @Nullable Integer num2, @NotNull List<String> list) {
        long j2 = j;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        boolean z9 = z;
        boolean z10 = z2;
        boolean z11 = z3;
        boolean z12 = z4;
        boolean z13 = z5;
        boolean z14 = z6;
        boolean z15 = z7;
        ContactInfo contactInfo3 = contactInfo2;
        String str10 = str5;
        boolean z16 = z8;
        BodyInfo bodyInfo3 = bodyInfo2;
        BodyFilter bodyFilter3 = bodyFilter2;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        Integer num3 = num;
        Integer num4 = num2;
        List<String> list2 = list;
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "fittsID");
        Intrinsics.checkParameterIsNotNull(str3, "activeStatus");
        Intrinsics.checkParameterIsNotNull(contactInfo2, "contactInfo");
        Intrinsics.checkParameterIsNotNull(str5, "profileImageUrl");
        Intrinsics.checkParameterIsNotNull(bodyInfo2, "bodyInfo");
        Intrinsics.checkParameterIsNotNull(list, "styles");
        MyInfo myInfo = new MyInfo(j, str6, str7, str8, str9, z9, z10, z11, z12, z13, z14, z15, contactInfo3, str10, z16, bodyInfo3, bodyFilter3, i4, i5, i6, num3, num4, list2);
        return myInfo;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MyInfo) {
                MyInfo myInfo = (MyInfo) obj;
                if ((this.id == myInfo.id) && Intrinsics.areEqual((Object) this.email, (Object) myInfo.email) && Intrinsics.areEqual((Object) this.fittsID, (Object) myInfo.fittsID) && Intrinsics.areEqual((Object) this.activeStatus, (Object) myInfo.activeStatus) && Intrinsics.areEqual((Object) this.verifyState, (Object) myInfo.verifyState)) {
                    if (this.requiredAdditionalInfo == myInfo.requiredAdditionalInfo) {
                        if (this.requiredClothesSize == myInfo.requiredClothesSize) {
                            if (this.requiredShoeSize == myInfo.requiredShoeSize) {
                                if (this.requiredContactInfo == myInfo.requiredContactInfo) {
                                    if (this.requiredIdentityVerify == myInfo.requiredIdentityVerify) {
                                        if (this.requiredFootDescription == myInfo.requiredFootDescription) {
                                            if ((this.requiredFittieRecommend == myInfo.requiredFittieRecommend) && Intrinsics.areEqual((Object) this.contactInfo, (Object) myInfo.contactInfo) && Intrinsics.areEqual((Object) this.profileImageUrl, (Object) myInfo.profileImageUrl)) {
                                                if ((this.isFollowing == myInfo.isFollowing) && Intrinsics.areEqual((Object) this.bodyInfo, (Object) myInfo.bodyInfo) && Intrinsics.areEqual((Object) this.bodyFilter, (Object) myInfo.bodyFilter)) {
                                                    if (this.rewardPoints == myInfo.rewardPoints) {
                                                        if (this.followingsCount == myInfo.followingsCount) {
                                                            if (!(this.followersCount == myInfo.followersCount) || !Intrinsics.areEqual((Object) this.likesCount, (Object) myInfo.likesCount) || !Intrinsics.areEqual((Object) this.postsCount, (Object) myInfo.postsCount) || !Intrinsics.areEqual((Object) this.styles, (Object) myInfo.styles)) {
                                                                return false;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
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
        String str3 = this.activeStatus;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.verifyState;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.requiredAdditionalInfo;
        if (z) {
            z = true;
        }
        int i3 = (hashCode4 + (z ? 1 : 0)) * 31;
        boolean z2 = this.requiredClothesSize;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.requiredShoeSize;
        if (z3) {
            z3 = true;
        }
        int i5 = (i4 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.requiredContactInfo;
        if (z4) {
            z4 = true;
        }
        int i6 = (i5 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.requiredIdentityVerify;
        if (z5) {
            z5 = true;
        }
        int i7 = (i6 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.requiredFootDescription;
        if (z6) {
            z6 = true;
        }
        int i8 = (i7 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.requiredFittieRecommend;
        if (z7) {
            z7 = true;
        }
        int i9 = (i8 + (z7 ? 1 : 0)) * 31;
        ContactInfo contactInfo2 = this.contactInfo;
        int hashCode5 = (i9 + (contactInfo2 != null ? contactInfo2.hashCode() : 0)) * 31;
        String str5 = this.profileImageUrl;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z8 = this.isFollowing;
        if (z8) {
            z8 = true;
        }
        int i10 = (hashCode6 + (z8 ? 1 : 0)) * 31;
        BodyInfo bodyInfo2 = this.bodyInfo;
        int hashCode7 = (i10 + (bodyInfo2 != null ? bodyInfo2.hashCode() : 0)) * 31;
        BodyFilter bodyFilter2 = this.bodyFilter;
        int hashCode8 = (((((((hashCode7 + (bodyFilter2 != null ? bodyFilter2.hashCode() : 0)) * 31) + this.rewardPoints) * 31) + this.followingsCount) * 31) + this.followersCount) * 31;
        Integer num = this.likesCount;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.postsCount;
        int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 31;
        List<String> list = this.styles;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode10 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyInfo(id=");
        sb.append(this.id);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(", fittsID=");
        sb.append(this.fittsID);
        sb.append(", activeStatus=");
        sb.append(this.activeStatus);
        sb.append(", verifyState=");
        sb.append(this.verifyState);
        sb.append(", requiredAdditionalInfo=");
        sb.append(this.requiredAdditionalInfo);
        sb.append(", requiredClothesSize=");
        sb.append(this.requiredClothesSize);
        sb.append(", requiredShoeSize=");
        sb.append(this.requiredShoeSize);
        sb.append(", requiredContactInfo=");
        sb.append(this.requiredContactInfo);
        sb.append(", requiredIdentityVerify=");
        sb.append(this.requiredIdentityVerify);
        sb.append(", requiredFootDescription=");
        sb.append(this.requiredFootDescription);
        sb.append(", requiredFittieRecommend=");
        sb.append(this.requiredFittieRecommend);
        sb.append(", contactInfo=");
        sb.append(this.contactInfo);
        sb.append(", profileImageUrl=");
        sb.append(this.profileImageUrl);
        sb.append(", isFollowing=");
        sb.append(this.isFollowing);
        sb.append(", bodyInfo=");
        sb.append(this.bodyInfo);
        sb.append(", bodyFilter=");
        sb.append(this.bodyFilter);
        sb.append(", rewardPoints=");
        sb.append(this.rewardPoints);
        sb.append(", followingsCount=");
        sb.append(this.followingsCount);
        sb.append(", followersCount=");
        sb.append(this.followersCount);
        sb.append(", likesCount=");
        sb.append(this.likesCount);
        sb.append(", postsCount=");
        sb.append(this.postsCount);
        sb.append(", styles=");
        sb.append(this.styles);
        sb.append(")");
        return sb.toString();
    }

    public MyInfo(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, @NotNull ContactInfo contactInfo2, @NotNull String str5, boolean z8, @NotNull BodyInfo bodyInfo2, @Nullable BodyFilter bodyFilter2, int i, int i2, int i3, @Nullable Integer num, @Nullable Integer num2, @NotNull List<String> list) {
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        ContactInfo contactInfo3 = contactInfo2;
        String str9 = str5;
        BodyInfo bodyInfo3 = bodyInfo2;
        List<String> list2 = list;
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "fittsID");
        Intrinsics.checkParameterIsNotNull(str3, "activeStatus");
        Intrinsics.checkParameterIsNotNull(contactInfo3, "contactInfo");
        Intrinsics.checkParameterIsNotNull(str9, "profileImageUrl");
        Intrinsics.checkParameterIsNotNull(bodyInfo3, "bodyInfo");
        Intrinsics.checkParameterIsNotNull(list2, "styles");
        this.id = j;
        this.email = str6;
        this.fittsID = str7;
        this.activeStatus = str8;
        this.verifyState = str4;
        this.requiredAdditionalInfo = z;
        this.requiredClothesSize = z2;
        this.requiredShoeSize = z3;
        this.requiredContactInfo = z4;
        this.requiredIdentityVerify = z5;
        this.requiredFootDescription = z6;
        this.requiredFittieRecommend = z7;
        this.contactInfo = contactInfo3;
        this.profileImageUrl = str9;
        this.isFollowing = z8;
        this.bodyInfo = bodyInfo3;
        this.bodyFilter = bodyFilter2;
        this.rewardPoints = i;
        this.followingsCount = i2;
        this.followersCount = i3;
        this.likesCount = num;
        this.postsCount = num2;
        this.styles = list2;
    }

    @NonNull
    public final long getId() {
        return this.id;
    }

    @NotNull
    @NonNull
    public final String getEmail() {
        return this.email;
    }

    @NotNull
    @NonNull
    public final String getFittsID() {
        return this.fittsID;
    }

    @NotNull
    @NonNull
    public final String getActiveStatus() {
        return this.activeStatus;
    }

    @Nullable
    public final String getVerifyState() {
        return this.verifyState;
    }

    public final boolean getRequiredAdditionalInfo() {
        return this.requiredAdditionalInfo;
    }

    public final boolean getRequiredClothesSize() {
        return this.requiredClothesSize;
    }

    public final boolean getRequiredShoeSize() {
        return this.requiredShoeSize;
    }

    public final boolean getRequiredContactInfo() {
        return this.requiredContactInfo;
    }

    public final boolean getRequiredIdentityVerify() {
        return this.requiredIdentityVerify;
    }

    public final boolean getRequiredFootDescription() {
        return this.requiredFootDescription;
    }

    public final boolean getRequiredFittieRecommend() {
        return this.requiredFittieRecommend;
    }

    @NotNull
    public final ContactInfo getContactInfo() {
        return this.contactInfo;
    }

    @NotNull
    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    @NonNull
    public final boolean isFollowing() {
        return this.isFollowing;
    }

    public final void setFollowing(boolean z) {
        this.isFollowing = z;
    }

    @NotNull
    @NonNull
    public final BodyInfo getBodyInfo() {
        return this.bodyInfo;
    }

    @Nullable
    public final BodyFilter getBodyFilter() {
        return this.bodyFilter;
    }

    public final int getRewardPoints() {
        return this.rewardPoints;
    }

    public final int getFollowingsCount() {
        return this.followingsCount;
    }

    public final void setFollowingsCount(int i) {
        this.followingsCount = i;
    }

    public final int getFollowersCount() {
        return this.followersCount;
    }

    @Nullable
    public final Integer getLikesCount() {
        return this.likesCount;
    }

    public final void setLikesCount(@Nullable Integer num) {
        this.likesCount = num;
    }

    @Nullable
    public final Integer getPostsCount() {
        return this.postsCount;
    }

    @NotNull
    public final List<String> getStyles() {
        return this.styles;
    }
}
