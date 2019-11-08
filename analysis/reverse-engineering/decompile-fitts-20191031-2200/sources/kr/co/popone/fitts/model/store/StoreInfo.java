package kr.co.popone.fitts.model.store;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.model.post.PostAPI.Style;
import kr.co.popone.fitts.model.search.IntergratedSearchInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreInfo implements IntergratedSearchInterface, FeedItem {
    @SerializedName("body_feature")
    @Nullable
    private final String bodyFeatrue;
    @SerializedName("created_at")
    @Nullable
    private final Date createdAt;
    private final long id;
    @SerializedName("is_favorite")
    private boolean isBookmark;
    @SerializedName("is_new")
    @Nullable
    private final Boolean isNew;
    @SerializedName("items")
    @NotNull
    private final List<Feed> items;
    @SerializedName("mobile_host")
    @Nullable
    private final String mobileHost;
    @SerializedName("mobile_shop_url")
    @Nullable
    private final String mobileShopUrl;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("product_feature")
    @Nullable
    private final String productFeature;
    @SerializedName("return_address")
    @Nullable
    private final String returnAddress;
    @SerializedName("service_start_date")
    @Nullable
    private final Date serviceStartDate;
    @SerializedName("state")
    @Nullable
    private final String state;
    @SerializedName("company_address")
    @Nullable
    private final String storeAddress;
    @SerializedName("shop_contact")
    @NotNull
    private final StoreContact storeContactInfo;
    @SerializedName("script_to_remove_buy_button")
    @Nullable
    private final String storeDomRemoveScript;
    @SerializedName("host")
    @NotNull
    private final String storeHost;
    @SerializedName("main_image")
    @Nullable
    private final StoreImageInfo storeImageInfo;
    @SerializedName("company_name")
    @NotNull
    private final String storeName;
    @SerializedName("company_registration_number")
    @Nullable
    private final String storeRegNumber;
    @SerializedName("shop_url")
    @NotNull
    private final String storeUrl;
    @SerializedName("styles")
    @NotNull
    private final List<Style> styles;
    @SerializedName("updated_at")
    @Nullable
    private final Date updatedAt;

    @NotNull
    public static /* synthetic */ StoreInfo copy$default(StoreInfo storeInfo, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, Date date, String str8, Date date2, Date date3, String str9, String str10, StoreContact storeContact, String str11, List list, String str12, String str13, StoreImageInfo storeImageInfo2, Boolean bool, boolean z, List list2, int i, Object obj) {
        StoreInfo storeInfo2 = storeInfo;
        int i2 = i;
        return storeInfo.copy((i2 & 1) != 0 ? storeInfo2.id : j, (i2 & 2) != 0 ? storeInfo2.name : str, (i2 & 4) != 0 ? storeInfo2.storeHost : str2, (i2 & 8) != 0 ? storeInfo2.storeUrl : str3, (i2 & 16) != 0 ? storeInfo2.storeName : str4, (i2 & 32) != 0 ? storeInfo2.storeRegNumber : str5, (i2 & 64) != 0 ? storeInfo2.storeAddress : str6, (i2 & 128) != 0 ? storeInfo2.returnAddress : str7, (i2 & 256) != 0 ? storeInfo2.serviceStartDate : date, (i2 & 512) != 0 ? storeInfo2.state : str8, (i2 & 1024) != 0 ? storeInfo2.createdAt : date2, (i2 & 2048) != 0 ? storeInfo2.updatedAt : date3, (i2 & 4096) != 0 ? storeInfo2.mobileHost : str9, (i2 & 8192) != 0 ? storeInfo2.mobileShopUrl : str10, (i2 & 16384) != 0 ? storeInfo2.storeContactInfo : storeContact, (i2 & 32768) != 0 ? storeInfo2.storeDomRemoveScript : str11, (i2 & 65536) != 0 ? storeInfo2.styles : list, (i2 & 131072) != 0 ? storeInfo2.productFeature : str12, (i2 & 262144) != 0 ? storeInfo2.bodyFeatrue : str13, (i2 & 524288) != 0 ? storeInfo2.storeImageInfo : storeImageInfo2, (i2 & 1048576) != 0 ? storeInfo2.isNew : bool, (i2 & 2097152) != 0 ? storeInfo2.isBookmark : z, (i2 & 4194304) != 0 ? storeInfo2.items : list2);
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final String component10() {
        return this.state;
    }

    @Nullable
    public final Date component11() {
        return this.createdAt;
    }

    @Nullable
    public final Date component12() {
        return this.updatedAt;
    }

    @Nullable
    public final String component13() {
        return this.mobileHost;
    }

    @Nullable
    public final String component14() {
        return this.mobileShopUrl;
    }

    @NotNull
    public final StoreContact component15() {
        return this.storeContactInfo;
    }

    @Nullable
    public final String component16() {
        return this.storeDomRemoveScript;
    }

    @NotNull
    public final List<Style> component17() {
        return this.styles;
    }

    @Nullable
    public final String component18() {
        return this.productFeature;
    }

    @Nullable
    public final String component19() {
        return this.bodyFeatrue;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final StoreImageInfo component20() {
        return this.storeImageInfo;
    }

    @Nullable
    public final Boolean component21() {
        return this.isNew;
    }

    public final boolean component22() {
        return this.isBookmark;
    }

    @NotNull
    public final List<Feed> component23() {
        return this.items;
    }

    @NotNull
    public final String component3() {
        return this.storeHost;
    }

    @NotNull
    public final String component4() {
        return this.storeUrl;
    }

    @NotNull
    public final String component5() {
        return this.storeName;
    }

    @Nullable
    public final String component6() {
        return this.storeRegNumber;
    }

    @Nullable
    public final String component7() {
        return this.storeAddress;
    }

    @Nullable
    public final String component8() {
        return this.returnAddress;
    }

    @Nullable
    public final Date component9() {
        return this.serviceStartDate;
    }

    @NotNull
    public final StoreInfo copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Date date, @Nullable String str8, @Nullable Date date2, @Nullable Date date3, @Nullable String str9, @Nullable String str10, @NotNull StoreContact storeContact, @Nullable String str11, @NotNull List<Style> list, @Nullable String str12, @Nullable String str13, @Nullable StoreImageInfo storeImageInfo2, @Nullable Boolean bool, boolean z, @NotNull List<Feed> list2) {
        long j2 = j;
        String str14 = str;
        String str15 = str2;
        String str16 = str3;
        String str17 = str4;
        String str18 = str5;
        String str19 = str6;
        String str20 = str7;
        Date date4 = date;
        String str21 = str8;
        Date date5 = date2;
        Date date6 = date3;
        String str22 = str9;
        String str23 = str10;
        StoreContact storeContact2 = storeContact;
        String str24 = str11;
        List<Style> list3 = list;
        String str25 = str12;
        String str26 = str13;
        StoreImageInfo storeImageInfo3 = storeImageInfo2;
        Boolean bool2 = bool;
        boolean z2 = z;
        List<Feed> list4 = list2;
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "storeHost");
        Intrinsics.checkParameterIsNotNull(str3, "storeUrl");
        Intrinsics.checkParameterIsNotNull(str4, "storeName");
        Intrinsics.checkParameterIsNotNull(storeContact, "storeContactInfo");
        Intrinsics.checkParameterIsNotNull(list, "styles");
        Intrinsics.checkParameterIsNotNull(list2, "items");
        StoreInfo storeInfo = new StoreInfo(j, str14, str15, str16, str17, str18, str19, str20, date4, str21, date5, date6, str22, str23, storeContact2, str24, list3, str25, str26, storeImageInfo3, bool2, z2, list4);
        return storeInfo;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof StoreInfo) {
                StoreInfo storeInfo = (StoreInfo) obj;
                if ((this.id == storeInfo.id) && Intrinsics.areEqual((Object) this.name, (Object) storeInfo.name) && Intrinsics.areEqual((Object) this.storeHost, (Object) storeInfo.storeHost) && Intrinsics.areEqual((Object) this.storeUrl, (Object) storeInfo.storeUrl) && Intrinsics.areEqual((Object) this.storeName, (Object) storeInfo.storeName) && Intrinsics.areEqual((Object) this.storeRegNumber, (Object) storeInfo.storeRegNumber) && Intrinsics.areEqual((Object) this.storeAddress, (Object) storeInfo.storeAddress) && Intrinsics.areEqual((Object) this.returnAddress, (Object) storeInfo.returnAddress) && Intrinsics.areEqual((Object) this.serviceStartDate, (Object) storeInfo.serviceStartDate) && Intrinsics.areEqual((Object) this.state, (Object) storeInfo.state) && Intrinsics.areEqual((Object) this.createdAt, (Object) storeInfo.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) storeInfo.updatedAt) && Intrinsics.areEqual((Object) this.mobileHost, (Object) storeInfo.mobileHost) && Intrinsics.areEqual((Object) this.mobileShopUrl, (Object) storeInfo.mobileShopUrl) && Intrinsics.areEqual((Object) this.storeContactInfo, (Object) storeInfo.storeContactInfo) && Intrinsics.areEqual((Object) this.storeDomRemoveScript, (Object) storeInfo.storeDomRemoveScript) && Intrinsics.areEqual((Object) this.styles, (Object) storeInfo.styles) && Intrinsics.areEqual((Object) this.productFeature, (Object) storeInfo.productFeature) && Intrinsics.areEqual((Object) this.bodyFeatrue, (Object) storeInfo.bodyFeatrue) && Intrinsics.areEqual((Object) this.storeImageInfo, (Object) storeInfo.storeImageInfo) && Intrinsics.areEqual((Object) this.isNew, (Object) storeInfo.isNew)) {
                    if (!(this.isBookmark == storeInfo.isBookmark) || !Intrinsics.areEqual((Object) this.items, (Object) storeInfo.items)) {
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
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.storeHost;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.storeUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.storeName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.storeRegNumber;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.storeAddress;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.returnAddress;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Date date = this.serviceStartDate;
        int hashCode8 = (hashCode7 + (date != null ? date.hashCode() : 0)) * 31;
        String str8 = this.state;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Date date2 = this.createdAt;
        int hashCode10 = (hashCode9 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.updatedAt;
        int hashCode11 = (hashCode10 + (date3 != null ? date3.hashCode() : 0)) * 31;
        String str9 = this.mobileHost;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.mobileShopUrl;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        StoreContact storeContact = this.storeContactInfo;
        int hashCode14 = (hashCode13 + (storeContact != null ? storeContact.hashCode() : 0)) * 31;
        String str11 = this.storeDomRemoveScript;
        int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 31;
        List<Style> list = this.styles;
        int hashCode16 = (hashCode15 + (list != null ? list.hashCode() : 0)) * 31;
        String str12 = this.productFeature;
        int hashCode17 = (hashCode16 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.bodyFeatrue;
        int hashCode18 = (hashCode17 + (str13 != null ? str13.hashCode() : 0)) * 31;
        StoreImageInfo storeImageInfo2 = this.storeImageInfo;
        int hashCode19 = (hashCode18 + (storeImageInfo2 != null ? storeImageInfo2.hashCode() : 0)) * 31;
        Boolean bool = this.isNew;
        int hashCode20 = (hashCode19 + (bool != null ? bool.hashCode() : 0)) * 31;
        boolean z = this.isBookmark;
        if (z) {
            z = true;
        }
        int i3 = (hashCode20 + (z ? 1 : 0)) * 31;
        List<Feed> list2 = this.items;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return i3 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreInfo(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", storeHost=");
        sb.append(this.storeHost);
        sb.append(", storeUrl=");
        sb.append(this.storeUrl);
        sb.append(", storeName=");
        sb.append(this.storeName);
        sb.append(", storeRegNumber=");
        sb.append(this.storeRegNumber);
        sb.append(", storeAddress=");
        sb.append(this.storeAddress);
        sb.append(", returnAddress=");
        sb.append(this.returnAddress);
        sb.append(", serviceStartDate=");
        sb.append(this.serviceStartDate);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", updatedAt=");
        sb.append(this.updatedAt);
        sb.append(", mobileHost=");
        sb.append(this.mobileHost);
        sb.append(", mobileShopUrl=");
        sb.append(this.mobileShopUrl);
        sb.append(", storeContactInfo=");
        sb.append(this.storeContactInfo);
        sb.append(", storeDomRemoveScript=");
        sb.append(this.storeDomRemoveScript);
        sb.append(", styles=");
        sb.append(this.styles);
        sb.append(", productFeature=");
        sb.append(this.productFeature);
        sb.append(", bodyFeatrue=");
        sb.append(this.bodyFeatrue);
        sb.append(", storeImageInfo=");
        sb.append(this.storeImageInfo);
        sb.append(", isNew=");
        sb.append(this.isNew);
        sb.append(", isBookmark=");
        sb.append(this.isBookmark);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(")");
        return sb.toString();
    }

    public StoreInfo(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Date date, @Nullable String str8, @Nullable Date date2, @Nullable Date date3, @Nullable String str9, @Nullable String str10, @NotNull StoreContact storeContact, @Nullable String str11, @NotNull List<Style> list, @Nullable String str12, @Nullable String str13, @Nullable StoreImageInfo storeImageInfo2, @Nullable Boolean bool, boolean z, @NotNull List<Feed> list2) {
        String str14 = str;
        String str15 = str2;
        String str16 = str3;
        String str17 = str4;
        StoreContact storeContact2 = storeContact;
        List<Style> list3 = list;
        List<Feed> list4 = list2;
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "storeHost");
        Intrinsics.checkParameterIsNotNull(str3, "storeUrl");
        Intrinsics.checkParameterIsNotNull(str17, "storeName");
        Intrinsics.checkParameterIsNotNull(storeContact2, "storeContactInfo");
        Intrinsics.checkParameterIsNotNull(list3, "styles");
        Intrinsics.checkParameterIsNotNull(list4, "items");
        this.id = j;
        this.name = str14;
        this.storeHost = str15;
        this.storeUrl = str16;
        this.storeName = str17;
        this.storeRegNumber = str5;
        this.storeAddress = str6;
        this.returnAddress = str7;
        this.serviceStartDate = date;
        this.state = str8;
        this.createdAt = date2;
        this.updatedAt = date3;
        this.mobileHost = str9;
        this.mobileShopUrl = str10;
        this.storeContactInfo = storeContact2;
        this.storeDomRemoveScript = str11;
        this.styles = list3;
        this.productFeature = str12;
        this.bodyFeatrue = str13;
        this.storeImageInfo = storeImageInfo2;
        this.isNew = bool;
        this.isBookmark = z;
        this.items = list4;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getStoreHost() {
        return this.storeHost;
    }

    @NotNull
    public final String getStoreUrl() {
        return this.storeUrl;
    }

    @NotNull
    public final String getStoreName() {
        return this.storeName;
    }

    @Nullable
    public final String getStoreRegNumber() {
        return this.storeRegNumber;
    }

    @Nullable
    public final String getStoreAddress() {
        return this.storeAddress;
    }

    @Nullable
    public final String getReturnAddress() {
        return this.returnAddress;
    }

    @Nullable
    public final Date getServiceStartDate() {
        return this.serviceStartDate;
    }

    @Nullable
    public final String getState() {
        return this.state;
    }

    @Nullable
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    @Nullable
    public final String getMobileHost() {
        return this.mobileHost;
    }

    @Nullable
    public final String getMobileShopUrl() {
        return this.mobileShopUrl;
    }

    @NotNull
    public final StoreContact getStoreContactInfo() {
        return this.storeContactInfo;
    }

    @Nullable
    public final String getStoreDomRemoveScript() {
        return this.storeDomRemoveScript;
    }

    @NotNull
    public final List<Style> getStyles() {
        return this.styles;
    }

    @Nullable
    public final String getProductFeature() {
        return this.productFeature;
    }

    @Nullable
    public final String getBodyFeatrue() {
        return this.bodyFeatrue;
    }

    @Nullable
    public final StoreImageInfo getStoreImageInfo() {
        return this.storeImageInfo;
    }

    @Nullable
    public final Boolean isNew() {
        return this.isNew;
    }

    public final boolean isBookmark() {
        return this.isBookmark;
    }

    public final void setBookmark(boolean z) {
        this.isBookmark = z;
    }

    @NotNull
    public final List<Feed> getItems() {
        return this.items;
    }
}
