package kr.co.popone.fitts.model.datamodel.social.feed;

import com.facebook.internal.ServerProtocol;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.model.datamodel.service.banner.BannerImage;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Style;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.store.StoreImageInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FeedVariant {
    @SerializedName("banner_scheme")
    @Nullable
    private final String bannerScheme;
    @SerializedName("body_info")
    @Nullable
    private final BodyInfo bodyInfo;
    @SerializedName("cover_image")
    @Nullable
    private final Image coverImage;
    @SerializedName("discount_percentage")
    @Nullable
    private final Double discountRate;
    private final long id;
    @SerializedName("image")
    @Nullable
    private final BannerImage image;
    @SerializedName("image_scheme")
    @Nullable
    private final String imageScheme;
    @SerializedName("image_url")
    @Nullable
    private final String imageUrl;
    @SerializedName("is_in_wish_list")
    @Nullable
    private Boolean isInWishList;
    @SerializedName("is_new")
    private final boolean isNewShop;
    @SerializedName("is_favorite")
    private boolean isShopFavorite;
    @SerializedName("link_url")
    @Nullable
    private final String linkUrl;
    @SerializedName("origin_price")
    @Nullable
    private final Long originPrice;
    @SerializedName("profile_image_url")
    @Nullable
    private final String profileImageUrl;
    @SerializedName("sales_price")
    @Nullable
    private final Long salesPrice;
    @SerializedName("body_feature")
    @Nullable
    private final String shopBodyFeature;
    @SerializedName("main_image")
    @NotNull
    private final StoreImageInfo shopImageInfo;
    @SerializedName("company_name")
    @NotNull
    private final String shopName;
    @SerializedName("products")
    @Nullable
    private final List<Product> shopPreViews;
    @SerializedName("product_feature")
    @Nullable
    private final String shopProductFeature;
    @SerializedName("styles")
    @NotNull
    private final List<Style> shopStyles;
    @SerializedName("state")
    @NotNull
    private final String state;
    @SerializedName("tag_scheme")
    @Nullable
    private final String tagScheme;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("user")
    @Nullable
    private final User user;

    @NotNull
    public static /* synthetic */ FeedVariant copy$default(FeedVariant feedVariant, long j, String str, User user2, Image image2, BannerImage bannerImage, String str2, String str3, String str4, String str5, Long l, Double d, Long l2, String str6, BodyInfo bodyInfo2, Boolean bool, String str7, String str8, List list, String str9, String str10, StoreImageInfo storeImageInfo, boolean z, List list2, boolean z2, String str11, int i, Object obj) {
        FeedVariant feedVariant2 = feedVariant;
        int i2 = i;
        return feedVariant.copy((i2 & 1) != 0 ? feedVariant2.id : j, (i2 & 2) != 0 ? feedVariant2.title : str, (i2 & 4) != 0 ? feedVariant2.user : user2, (i2 & 8) != 0 ? feedVariant2.coverImage : image2, (i2 & 16) != 0 ? feedVariant2.image : bannerImage, (i2 & 32) != 0 ? feedVariant2.bannerScheme : str2, (i2 & 64) != 0 ? feedVariant2.imageUrl : str3, (i2 & 128) != 0 ? feedVariant2.imageScheme : str4, (i2 & 256) != 0 ? feedVariant2.linkUrl : str5, (i2 & 512) != 0 ? feedVariant2.originPrice : l, (i2 & 1024) != 0 ? feedVariant2.discountRate : d, (i2 & 2048) != 0 ? feedVariant2.salesPrice : l2, (i2 & 4096) != 0 ? feedVariant2.profileImageUrl : str6, (i2 & 8192) != 0 ? feedVariant2.bodyInfo : bodyInfo2, (i2 & 16384) != 0 ? feedVariant2.isInWishList : bool, (i2 & 32768) != 0 ? feedVariant2.shopName : str7, (i2 & 65536) != 0 ? feedVariant2.state : str8, (i2 & 131072) != 0 ? feedVariant2.shopStyles : list, (i2 & 262144) != 0 ? feedVariant2.shopProductFeature : str9, (i2 & 524288) != 0 ? feedVariant2.shopBodyFeature : str10, (i2 & 1048576) != 0 ? feedVariant2.shopImageInfo : storeImageInfo, (i2 & 2097152) != 0 ? feedVariant2.isShopFavorite : z, (i2 & 4194304) != 0 ? feedVariant2.shopPreViews : list2, (i2 & 8388608) != 0 ? feedVariant2.isNewShop : z2, (i2 & 16777216) != 0 ? feedVariant2.tagScheme : str11);
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final Long component10() {
        return this.originPrice;
    }

    @Nullable
    public final Double component11() {
        return this.discountRate;
    }

    @Nullable
    public final Long component12() {
        return this.salesPrice;
    }

    @Nullable
    public final String component13() {
        return this.profileImageUrl;
    }

    @Nullable
    public final BodyInfo component14() {
        return this.bodyInfo;
    }

    @Nullable
    public final Boolean component15() {
        return this.isInWishList;
    }

    @NotNull
    public final String component16() {
        return this.shopName;
    }

    @NotNull
    public final String component17() {
        return this.state;
    }

    @NotNull
    public final List<Style> component18() {
        return this.shopStyles;
    }

    @Nullable
    public final String component19() {
        return this.shopProductFeature;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component20() {
        return this.shopBodyFeature;
    }

    @NotNull
    public final StoreImageInfo component21() {
        return this.shopImageInfo;
    }

    public final boolean component22() {
        return this.isShopFavorite;
    }

    @Nullable
    public final List<Product> component23() {
        return this.shopPreViews;
    }

    public final boolean component24() {
        return this.isNewShop;
    }

    @Nullable
    public final String component25() {
        return this.tagScheme;
    }

    @Nullable
    public final User component3() {
        return this.user;
    }

    @Nullable
    public final Image component4() {
        return this.coverImage;
    }

    @Nullable
    public final BannerImage component5() {
        return this.image;
    }

    @Nullable
    public final String component6() {
        return this.bannerScheme;
    }

    @Nullable
    public final String component7() {
        return this.imageUrl;
    }

    @Nullable
    public final String component8() {
        return this.imageScheme;
    }

    @Nullable
    public final String component9() {
        return this.linkUrl;
    }

    @NotNull
    public final FeedVariant copy(long j, @Nullable String str, @Nullable User user2, @Nullable Image image2, @Nullable BannerImage bannerImage, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Long l, @Nullable Double d, @Nullable Long l2, @Nullable String str6, @Nullable BodyInfo bodyInfo2, @Nullable Boolean bool, @NotNull String str7, @NotNull String str8, @NotNull List<Style> list, @Nullable String str9, @Nullable String str10, @NotNull StoreImageInfo storeImageInfo, boolean z, @Nullable List<Product> list2, boolean z2, @Nullable String str11) {
        long j2 = j;
        String str12 = str;
        User user3 = user2;
        Image image3 = image2;
        BannerImage bannerImage2 = bannerImage;
        String str13 = str2;
        String str14 = str3;
        String str15 = str4;
        String str16 = str5;
        Long l3 = l;
        Double d2 = d;
        Long l4 = l2;
        String str17 = str6;
        BodyInfo bodyInfo3 = bodyInfo2;
        Boolean bool2 = bool;
        String str18 = str7;
        String str19 = str8;
        List<Style> list3 = list;
        String str20 = str9;
        String str21 = str10;
        StoreImageInfo storeImageInfo2 = storeImageInfo;
        boolean z3 = z;
        List<Product> list4 = list2;
        boolean z4 = z2;
        String str22 = str11;
        Intrinsics.checkParameterIsNotNull(str7, "shopName");
        Intrinsics.checkParameterIsNotNull(str8, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(list, "shopStyles");
        Intrinsics.checkParameterIsNotNull(storeImageInfo, "shopImageInfo");
        FeedVariant feedVariant = new FeedVariant(j, str12, user3, image3, bannerImage2, str13, str14, str15, str16, l3, d2, l4, str17, bodyInfo3, bool2, str18, str19, list3, str20, str21, storeImageInfo2, z3, list4, z4, str22);
        return feedVariant;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof FeedVariant) {
                FeedVariant feedVariant = (FeedVariant) obj;
                if ((this.id == feedVariant.id) && Intrinsics.areEqual((Object) this.title, (Object) feedVariant.title) && Intrinsics.areEqual((Object) this.user, (Object) feedVariant.user) && Intrinsics.areEqual((Object) this.coverImage, (Object) feedVariant.coverImage) && Intrinsics.areEqual((Object) this.image, (Object) feedVariant.image) && Intrinsics.areEqual((Object) this.bannerScheme, (Object) feedVariant.bannerScheme) && Intrinsics.areEqual((Object) this.imageUrl, (Object) feedVariant.imageUrl) && Intrinsics.areEqual((Object) this.imageScheme, (Object) feedVariant.imageScheme) && Intrinsics.areEqual((Object) this.linkUrl, (Object) feedVariant.linkUrl) && Intrinsics.areEqual((Object) this.originPrice, (Object) feedVariant.originPrice) && Intrinsics.areEqual((Object) this.discountRate, (Object) feedVariant.discountRate) && Intrinsics.areEqual((Object) this.salesPrice, (Object) feedVariant.salesPrice) && Intrinsics.areEqual((Object) this.profileImageUrl, (Object) feedVariant.profileImageUrl) && Intrinsics.areEqual((Object) this.bodyInfo, (Object) feedVariant.bodyInfo) && Intrinsics.areEqual((Object) this.isInWishList, (Object) feedVariant.isInWishList) && Intrinsics.areEqual((Object) this.shopName, (Object) feedVariant.shopName) && Intrinsics.areEqual((Object) this.state, (Object) feedVariant.state) && Intrinsics.areEqual((Object) this.shopStyles, (Object) feedVariant.shopStyles) && Intrinsics.areEqual((Object) this.shopProductFeature, (Object) feedVariant.shopProductFeature) && Intrinsics.areEqual((Object) this.shopBodyFeature, (Object) feedVariant.shopBodyFeature) && Intrinsics.areEqual((Object) this.shopImageInfo, (Object) feedVariant.shopImageInfo)) {
                    if ((this.isShopFavorite == feedVariant.isShopFavorite) && Intrinsics.areEqual((Object) this.shopPreViews, (Object) feedVariant.shopPreViews)) {
                        if (!(this.isNewShop == feedVariant.isNewShop) || !Intrinsics.areEqual((Object) this.tagScheme, (Object) feedVariant.tagScheme)) {
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
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        User user2 = this.user;
        int hashCode2 = (hashCode + (user2 != null ? user2.hashCode() : 0)) * 31;
        Image image2 = this.coverImage;
        int hashCode3 = (hashCode2 + (image2 != null ? image2.hashCode() : 0)) * 31;
        BannerImage bannerImage = this.image;
        int hashCode4 = (hashCode3 + (bannerImage != null ? bannerImage.hashCode() : 0)) * 31;
        String str2 = this.bannerScheme;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.imageUrl;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.imageScheme;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.linkUrl;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Long l = this.originPrice;
        int hashCode9 = (hashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Double d = this.discountRate;
        int hashCode10 = (hashCode9 + (d != null ? d.hashCode() : 0)) * 31;
        Long l2 = this.salesPrice;
        int hashCode11 = (hashCode10 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str6 = this.profileImageUrl;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        BodyInfo bodyInfo2 = this.bodyInfo;
        int hashCode13 = (hashCode12 + (bodyInfo2 != null ? bodyInfo2.hashCode() : 0)) * 31;
        Boolean bool = this.isInWishList;
        int hashCode14 = (hashCode13 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str7 = this.shopName;
        int hashCode15 = (hashCode14 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.state;
        int hashCode16 = (hashCode15 + (str8 != null ? str8.hashCode() : 0)) * 31;
        List<Style> list = this.shopStyles;
        int hashCode17 = (hashCode16 + (list != null ? list.hashCode() : 0)) * 31;
        String str9 = this.shopProductFeature;
        int hashCode18 = (hashCode17 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.shopBodyFeature;
        int hashCode19 = (hashCode18 + (str10 != null ? str10.hashCode() : 0)) * 31;
        StoreImageInfo storeImageInfo = this.shopImageInfo;
        int hashCode20 = (hashCode19 + (storeImageInfo != null ? storeImageInfo.hashCode() : 0)) * 31;
        boolean z = this.isShopFavorite;
        if (z) {
            z = true;
        }
        int i3 = (hashCode20 + (z ? 1 : 0)) * 31;
        List<Product> list2 = this.shopPreViews;
        int hashCode21 = (i3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z2 = this.isNewShop;
        if (z2) {
            z2 = true;
        }
        int i4 = (hashCode21 + (z2 ? 1 : 0)) * 31;
        String str11 = this.tagScheme;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return i4 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedVariant(id=");
        sb.append(this.id);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", user=");
        sb.append(this.user);
        sb.append(", coverImage=");
        sb.append(this.coverImage);
        sb.append(", image=");
        sb.append(this.image);
        sb.append(", bannerScheme=");
        sb.append(this.bannerScheme);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", imageScheme=");
        sb.append(this.imageScheme);
        sb.append(", linkUrl=");
        sb.append(this.linkUrl);
        sb.append(", originPrice=");
        sb.append(this.originPrice);
        sb.append(", discountRate=");
        sb.append(this.discountRate);
        sb.append(", salesPrice=");
        sb.append(this.salesPrice);
        sb.append(", profileImageUrl=");
        sb.append(this.profileImageUrl);
        sb.append(", bodyInfo=");
        sb.append(this.bodyInfo);
        sb.append(", isInWishList=");
        sb.append(this.isInWishList);
        sb.append(", shopName=");
        sb.append(this.shopName);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", shopStyles=");
        sb.append(this.shopStyles);
        sb.append(", shopProductFeature=");
        sb.append(this.shopProductFeature);
        sb.append(", shopBodyFeature=");
        sb.append(this.shopBodyFeature);
        sb.append(", shopImageInfo=");
        sb.append(this.shopImageInfo);
        sb.append(", isShopFavorite=");
        sb.append(this.isShopFavorite);
        sb.append(", shopPreViews=");
        sb.append(this.shopPreViews);
        sb.append(", isNewShop=");
        sb.append(this.isNewShop);
        sb.append(", tagScheme=");
        sb.append(this.tagScheme);
        sb.append(")");
        return sb.toString();
    }

    public FeedVariant(long j, @Nullable String str, @Nullable User user2, @Nullable Image image2, @Nullable BannerImage bannerImage, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Long l, @Nullable Double d, @Nullable Long l2, @Nullable String str6, @Nullable BodyInfo bodyInfo2, @Nullable Boolean bool, @NotNull String str7, @NotNull String str8, @NotNull List<Style> list, @Nullable String str9, @Nullable String str10, @NotNull StoreImageInfo storeImageInfo, boolean z, @Nullable List<Product> list2, boolean z2, @Nullable String str11) {
        String str12 = str7;
        String str13 = str8;
        List<Style> list3 = list;
        StoreImageInfo storeImageInfo2 = storeImageInfo;
        Intrinsics.checkParameterIsNotNull(str12, "shopName");
        Intrinsics.checkParameterIsNotNull(str13, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(list3, "shopStyles");
        Intrinsics.checkParameterIsNotNull(storeImageInfo2, "shopImageInfo");
        this.id = j;
        this.title = str;
        this.user = user2;
        this.coverImage = image2;
        this.image = bannerImage;
        this.bannerScheme = str2;
        this.imageUrl = str3;
        this.imageScheme = str4;
        this.linkUrl = str5;
        this.originPrice = l;
        this.discountRate = d;
        this.salesPrice = l2;
        this.profileImageUrl = str6;
        this.bodyInfo = bodyInfo2;
        this.isInWishList = bool;
        this.shopName = str12;
        this.state = str13;
        this.shopStyles = list3;
        this.shopProductFeature = str9;
        this.shopBodyFeature = str10;
        this.shopImageInfo = storeImageInfo2;
        this.isShopFavorite = z;
        this.shopPreViews = list2;
        this.isNewShop = z2;
        this.tagScheme = str11;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final Image getCoverImage() {
        return this.coverImage;
    }

    @Nullable
    public final BannerImage getImage() {
        return this.image;
    }

    @Nullable
    public final String getBannerScheme() {
        return this.bannerScheme;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getImageScheme() {
        return this.imageScheme;
    }

    @Nullable
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    @Nullable
    public final Long getOriginPrice() {
        return this.originPrice;
    }

    @Nullable
    public final Double getDiscountRate() {
        return this.discountRate;
    }

    @Nullable
    public final Long getSalesPrice() {
        return this.salesPrice;
    }

    @Nullable
    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    @Nullable
    public final BodyInfo getBodyInfo() {
        return this.bodyInfo;
    }

    @Nullable
    public final Boolean isInWishList() {
        return this.isInWishList;
    }

    public final void setInWishList(@Nullable Boolean bool) {
        this.isInWishList = bool;
    }

    @NotNull
    public final String getShopName() {
        return this.shopName;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    @NotNull
    public final List<Style> getShopStyles() {
        return this.shopStyles;
    }

    @Nullable
    public final String getShopProductFeature() {
        return this.shopProductFeature;
    }

    @Nullable
    public final String getShopBodyFeature() {
        return this.shopBodyFeature;
    }

    @NotNull
    public final StoreImageInfo getShopImageInfo() {
        return this.shopImageInfo;
    }

    public final boolean isShopFavorite() {
        return this.isShopFavorite;
    }

    public final void setShopFavorite(boolean z) {
        this.isShopFavorite = z;
    }

    @Nullable
    public final List<Product> getShopPreViews() {
        return this.shopPreViews;
    }

    public final boolean isNewShop() {
        return this.isNewShop;
    }

    @Nullable
    public final String getTagScheme() {
        return this.tagScheme;
    }

    public final boolean isEmptyPost() {
        String str = this.title;
        return (str == null || str.length() == 0) || this.user == null || this.coverImage == null;
    }

    public final boolean isEmptyProduct() {
        String str = this.imageUrl;
        if (!(str == null || str.length() == 0)) {
            String str2 = this.linkUrl;
            if (!(str2 == null || str2.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmptyImage() {
        return this.image == null;
    }

    public final boolean isEmptyBanner() {
        return this.image == null;
    }

    public final boolean isEmptyFittie() {
        return this.user == null;
    }

    public final boolean isEmptyImageTag() {
        return this.title == null;
    }

    public final boolean isDiscount() {
        Double d = this.discountRate;
        return d != null && d.doubleValue() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final boolean isComingSoonShop() {
        return Intrinsics.areEqual((Object) this.state, (Object) "coming_soon");
    }

    public final int shopParallelTitleColor() {
        return isComingSoonShop() ? C0006R$color.gray4 : C0006R$color.gray6;
    }

    public final int getShopBookmarkIcon() {
        return this.isShopFavorite ? C0008R$drawable.img_icon_bookmark_on : C0008R$drawable.img_icon_bookmark_off;
    }
}
