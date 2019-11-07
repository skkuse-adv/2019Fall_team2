package kr.co.popone.fitts.model.datamodel.commerce.discount;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount.Type;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class SpecialDiscountInfo {
    @SerializedName("coming_soon_image_url")
    @NotNull
    private final String comingSoonImageUrl;
    @SerializedName("current_date")
    @NotNull
    private final Date currentDate;
    @SerializedName("end_date")
    @NotNull
    private final Date endDate;
    private final long id;
    @SerializedName("open_image_url")
    @NotNull
    private final String openImageUrl;
    @SerializedName("special_discount_info")
    @NotNull
    private final List<SpecialDiscount> specialDiscounts;
    @SerializedName("start_date")
    @NotNull
    private final Date startDate;
    @SerializedName("state")
    @NotNull
    private final State state;

    public enum State {
        OPEN,
        COMING_SOON
    }

    @NotNull
    public static /* synthetic */ SpecialDiscountInfo copy$default(SpecialDiscountInfo specialDiscountInfo, long j, Date date, Date date2, Date date3, String str, String str2, State state2, List list, int i, Object obj) {
        SpecialDiscountInfo specialDiscountInfo2 = specialDiscountInfo;
        int i2 = i;
        return specialDiscountInfo.copy((i2 & 1) != 0 ? specialDiscountInfo2.id : j, (i2 & 2) != 0 ? specialDiscountInfo2.startDate : date, (i2 & 4) != 0 ? specialDiscountInfo2.endDate : date2, (i2 & 8) != 0 ? specialDiscountInfo2.currentDate : date3, (i2 & 16) != 0 ? specialDiscountInfo2.openImageUrl : str, (i2 & 32) != 0 ? specialDiscountInfo2.comingSoonImageUrl : str2, (i2 & 64) != 0 ? specialDiscountInfo2.state : state2, (i2 & 128) != 0 ? specialDiscountInfo2.specialDiscounts : list);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final Date component2() {
        return this.startDate;
    }

    @NotNull
    public final Date component3() {
        return this.endDate;
    }

    @NotNull
    public final Date component4() {
        return this.currentDate;
    }

    @NotNull
    public final String component5() {
        return this.openImageUrl;
    }

    @NotNull
    public final String component6() {
        return this.comingSoonImageUrl;
    }

    @NotNull
    public final State component7() {
        return this.state;
    }

    @NotNull
    public final List<SpecialDiscount> component8() {
        return this.specialDiscounts;
    }

    @NotNull
    public final SpecialDiscountInfo copy(long j, @NotNull Date date, @NotNull Date date2, @NotNull Date date3, @NotNull String str, @NotNull String str2, @NotNull State state2, @NotNull List<SpecialDiscount> list) {
        Date date4 = date;
        Intrinsics.checkParameterIsNotNull(date, "startDate");
        Date date5 = date2;
        Intrinsics.checkParameterIsNotNull(date2, "endDate");
        Date date6 = date3;
        Intrinsics.checkParameterIsNotNull(date6, "currentDate");
        String str3 = str;
        Intrinsics.checkParameterIsNotNull(str3, "openImageUrl");
        String str4 = str2;
        Intrinsics.checkParameterIsNotNull(str4, "comingSoonImageUrl");
        State state3 = state2;
        Intrinsics.checkParameterIsNotNull(state3, ServerProtocol.DIALOG_PARAM_STATE);
        List<SpecialDiscount> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "specialDiscounts");
        SpecialDiscountInfo specialDiscountInfo = new SpecialDiscountInfo(j, date4, date5, date6, str3, str4, state3, list2);
        return specialDiscountInfo;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SpecialDiscountInfo) {
                SpecialDiscountInfo specialDiscountInfo = (SpecialDiscountInfo) obj;
                if (!(this.id == specialDiscountInfo.id) || !Intrinsics.areEqual((Object) this.startDate, (Object) specialDiscountInfo.startDate) || !Intrinsics.areEqual((Object) this.endDate, (Object) specialDiscountInfo.endDate) || !Intrinsics.areEqual((Object) this.currentDate, (Object) specialDiscountInfo.currentDate) || !Intrinsics.areEqual((Object) this.openImageUrl, (Object) specialDiscountInfo.openImageUrl) || !Intrinsics.areEqual((Object) this.comingSoonImageUrl, (Object) specialDiscountInfo.comingSoonImageUrl) || !Intrinsics.areEqual((Object) this.state, (Object) specialDiscountInfo.state) || !Intrinsics.areEqual((Object) this.specialDiscounts, (Object) specialDiscountInfo.specialDiscounts)) {
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
        Date date = this.startDate;
        int i2 = 0;
        int hashCode = (i + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.endDate;
        int hashCode2 = (hashCode + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.currentDate;
        int hashCode3 = (hashCode2 + (date3 != null ? date3.hashCode() : 0)) * 31;
        String str = this.openImageUrl;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.comingSoonImageUrl;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        State state2 = this.state;
        int hashCode6 = (hashCode5 + (state2 != null ? state2.hashCode() : 0)) * 31;
        List<SpecialDiscount> list = this.specialDiscounts;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode6 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpecialDiscountInfo(id=");
        sb.append(this.id);
        sb.append(", startDate=");
        sb.append(this.startDate);
        sb.append(", endDate=");
        sb.append(this.endDate);
        sb.append(", currentDate=");
        sb.append(this.currentDate);
        sb.append(", openImageUrl=");
        sb.append(this.openImageUrl);
        sb.append(", comingSoonImageUrl=");
        sb.append(this.comingSoonImageUrl);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", specialDiscounts=");
        sb.append(this.specialDiscounts);
        sb.append(")");
        return sb.toString();
    }

    public SpecialDiscountInfo(long j, @NotNull Date date, @NotNull Date date2, @NotNull Date date3, @NotNull String str, @NotNull String str2, @NotNull State state2, @NotNull List<SpecialDiscount> list) {
        Intrinsics.checkParameterIsNotNull(date, "startDate");
        Intrinsics.checkParameterIsNotNull(date2, "endDate");
        Intrinsics.checkParameterIsNotNull(date3, "currentDate");
        Intrinsics.checkParameterIsNotNull(str, "openImageUrl");
        Intrinsics.checkParameterIsNotNull(str2, "comingSoonImageUrl");
        Intrinsics.checkParameterIsNotNull(state2, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(list, "specialDiscounts");
        this.id = j;
        this.startDate = date;
        this.endDate = date2;
        this.currentDate = date3;
        this.openImageUrl = str;
        this.comingSoonImageUrl = str2;
        this.state = state2;
        this.specialDiscounts = list;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final Date getStartDate() {
        return this.startDate;
    }

    @NotNull
    public final Date getEndDate() {
        return this.endDate;
    }

    @NotNull
    public final Date getCurrentDate() {
        return this.currentDate;
    }

    @NotNull
    public final String getOpenImageUrl() {
        return this.openImageUrl;
    }

    @NotNull
    public final String getComingSoonImageUrl() {
        return this.comingSoonImageUrl;
    }

    @NotNull
    public final State getState() {
        return this.state;
    }

    @NotNull
    public final List<SpecialDiscount> getSpecialDiscounts() {
        return this.specialDiscounts;
    }

    @NotNull
    public final List<SpecialDiscountFeed> toFeedItem() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (Object next : this.specialDiscounts) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SpecialDiscount specialDiscount = (SpecialDiscount) next;
            if (specialDiscount.getType() == Type.SINGLE) {
                SpecialDiscountFeed specialDiscountFeed = new SpecialDiscountFeed(this.id, SpecialDiscountFeed.Type.SINGLE, CollectionsKt__CollectionsJVMKt.listOf(specialDiscount), i == 0 ? this.openImageUrl : null);
                arrayList.add(specialDiscountFeed);
            } else if (specialDiscount.getType() == Type.GRID) {
                arrayList2.add(specialDiscount);
                if (arrayList2.size() == 2 || i == CollectionsKt__CollectionsKt.getLastIndex(this.specialDiscounts)) {
                    SpecialDiscountFeed specialDiscountFeed2 = new SpecialDiscountFeed(this.id, SpecialDiscountFeed.Type.DOUBLE, CollectionsKt__IterablesKt.flatten(CollectionsKt__CollectionsJVMKt.listOf(arrayList2)), null);
                    arrayList.add(specialDiscountFeed2);
                    arrayList2.clear();
                }
            }
            i = i2;
        }
        return arrayList;
    }
}
