package kr.co.popone.fitts.model.datamodel.social.membership;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.ImageUrlWithRatio;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Membership {
    public static final Companion Companion = new Companion(null);
    public static final long EMPTY_OBJ_ID = -1;
    @SerializedName("discount_percentage")
    private final int discountPercentage;
    @SerializedName("end_date")
    @NotNull
    private final Date endDate;
    @SerializedName("id")
    private final long id;
    @SerializedName("max_price")
    private final int maximumPrice;
    @SerializedName("membership_no")
    private final long membershipNo;
    @SerializedName("min_price")
    private final int minimumPrice;
    @SerializedName("popup_image")
    @Nullable
    private final ImageUrlWithRatio popup;
    @SerializedName("start_date")
    @NotNull
    private final Date startDate;
    @SerializedName("membership_user_state")
    @Nullable
    private final State state;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("membership_type")
    @Nullable
    private final Type type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Membership newEmpty() {
            Membership membership = new Membership(-1, null, -1, "", new Date(), new Date(), 0, 0, 0, null, null);
            return membership;
        }
    }

    public enum State {
        ACTIVE,
        INACTIVE,
        DEACTIVATED
    }

    public enum Type {
        FITPLE,
        GENERAL
    }

    @NotNull
    public static /* synthetic */ Membership copy$default(Membership membership, long j, Type type2, long j2, String str, Date date, Date date2, int i, int i2, int i3, ImageUrlWithRatio imageUrlWithRatio, State state2, int i4, Object obj) {
        Membership membership2 = membership;
        int i5 = i4;
        return membership.copy((i5 & 1) != 0 ? membership2.id : j, (i5 & 2) != 0 ? membership2.type : type2, (i5 & 4) != 0 ? membership2.membershipNo : j2, (i5 & 8) != 0 ? membership2.title : str, (i5 & 16) != 0 ? membership2.startDate : date, (i5 & 32) != 0 ? membership2.endDate : date2, (i5 & 64) != 0 ? membership2.discountPercentage : i, (i5 & 128) != 0 ? membership2.minimumPrice : i2, (i5 & 256) != 0 ? membership2.maximumPrice : i3, (i5 & 512) != 0 ? membership2.popup : imageUrlWithRatio, (i5 & 1024) != 0 ? membership2.state : state2);
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final ImageUrlWithRatio component10() {
        return this.popup;
    }

    @Nullable
    public final State component11() {
        return this.state;
    }

    @Nullable
    public final Type component2() {
        return this.type;
    }

    public final long component3() {
        return this.membershipNo;
    }

    @NotNull
    public final String component4() {
        return this.title;
    }

    @NotNull
    public final Date component5() {
        return this.startDate;
    }

    @NotNull
    public final Date component6() {
        return this.endDate;
    }

    public final int component7() {
        return this.discountPercentage;
    }

    public final int component8() {
        return this.minimumPrice;
    }

    public final int component9() {
        return this.maximumPrice;
    }

    @NotNull
    public final Membership copy(long j, @Nullable Type type2, long j2, @NotNull String str, @NotNull Date date, @NotNull Date date2, int i, int i2, int i3, @Nullable ImageUrlWithRatio imageUrlWithRatio, @Nullable State state2) {
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Date date3 = date;
        Intrinsics.checkParameterIsNotNull(date3, "startDate");
        Date date4 = date2;
        Intrinsics.checkParameterIsNotNull(date4, "endDate");
        Membership membership = new Membership(j, type2, j2, str2, date3, date4, i, i2, i3, imageUrlWithRatio, state2);
        return membership;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Membership) {
                Membership membership = (Membership) obj;
                if ((this.id == membership.id) && Intrinsics.areEqual((Object) this.type, (Object) membership.type)) {
                    if ((this.membershipNo == membership.membershipNo) && Intrinsics.areEqual((Object) this.title, (Object) membership.title) && Intrinsics.areEqual((Object) this.startDate, (Object) membership.startDate) && Intrinsics.areEqual((Object) this.endDate, (Object) membership.endDate)) {
                        if (this.discountPercentage == membership.discountPercentage) {
                            if (this.minimumPrice == membership.minimumPrice) {
                                if (!(this.maximumPrice == membership.maximumPrice) || !Intrinsics.areEqual((Object) this.popup, (Object) membership.popup) || !Intrinsics.areEqual((Object) this.state, (Object) membership.state)) {
                                    return false;
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
        Type type2 = this.type;
        int i2 = 0;
        int hashCode = (i + (type2 != null ? type2.hashCode() : 0)) * 31;
        long j2 = this.membershipNo;
        int i3 = (hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.title;
        int hashCode2 = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        Date date = this.startDate;
        int hashCode3 = (hashCode2 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.endDate;
        int hashCode4 = (((((((hashCode3 + (date2 != null ? date2.hashCode() : 0)) * 31) + this.discountPercentage) * 31) + this.minimumPrice) * 31) + this.maximumPrice) * 31;
        ImageUrlWithRatio imageUrlWithRatio = this.popup;
        int hashCode5 = (hashCode4 + (imageUrlWithRatio != null ? imageUrlWithRatio.hashCode() : 0)) * 31;
        State state2 = this.state;
        if (state2 != null) {
            i2 = state2.hashCode();
        }
        return hashCode5 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Membership(id=");
        sb.append(this.id);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", membershipNo=");
        sb.append(this.membershipNo);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", startDate=");
        sb.append(this.startDate);
        sb.append(", endDate=");
        sb.append(this.endDate);
        sb.append(", discountPercentage=");
        sb.append(this.discountPercentage);
        sb.append(", minimumPrice=");
        sb.append(this.minimumPrice);
        sb.append(", maximumPrice=");
        sb.append(this.maximumPrice);
        sb.append(", popup=");
        sb.append(this.popup);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(")");
        return sb.toString();
    }

    public Membership(long j, @Nullable Type type2, long j2, @NotNull String str, @NotNull Date date, @NotNull Date date2, int i, int i2, int i3, @Nullable ImageUrlWithRatio imageUrlWithRatio, @Nullable State state2) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(date, "startDate");
        Intrinsics.checkParameterIsNotNull(date2, "endDate");
        this.id = j;
        this.type = type2;
        this.membershipNo = j2;
        this.title = str;
        this.startDate = date;
        this.endDate = date2;
        this.discountPercentage = i;
        this.minimumPrice = i2;
        this.maximumPrice = i3;
        this.popup = imageUrlWithRatio;
        this.state = state2;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final Type getType() {
        return this.type;
    }

    public final long getMembershipNo() {
        return this.membershipNo;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final Date getStartDate() {
        return this.startDate;
    }

    @NotNull
    public final Date getEndDate() {
        return this.endDate;
    }

    public final int getDiscountPercentage() {
        return this.discountPercentage;
    }

    public final int getMinimumPrice() {
        return this.minimumPrice;
    }

    public final int getMaximumPrice() {
        return this.maximumPrice;
    }

    @Nullable
    public final ImageUrlWithRatio getPopup() {
        return this.popup;
    }

    @Nullable
    public final State getState() {
        return this.state;
    }

    public final boolean isUsableMembership(int i) {
        return this.minimumPrice <= i && this.maximumPrice >= i;
    }

    @Nullable
    public final String getUnusableReason(int i) {
        String str = "총 상품금액이 ";
        if (i > this.maximumPrice) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(IntExtensionsKt.commaString(this.maximumPrice));
            sb.append("원 이하여야 할인 가능합니다.");
            return sb.toString();
        } else if (i >= this.minimumPrice) {
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(IntExtensionsKt.commaString(this.minimumPrice));
            sb2.append("원 이상이어야 할인 가능합니다.");
            return sb2.toString();
        }
    }

    public final boolean isNotDeative() {
        State state2 = this.state;
        return state2 == State.ACTIVE || state2 == State.INACTIVE;
    }

    public final boolean isInactive() {
        return this.state == State.INACTIVE;
    }
}
