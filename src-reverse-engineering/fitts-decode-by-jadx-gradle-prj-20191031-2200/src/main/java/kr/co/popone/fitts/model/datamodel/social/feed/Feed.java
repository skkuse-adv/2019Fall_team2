package kr.co.popone.fitts.model.datamodel.social.feed;

import android.content.Context;
import android.view.View;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.feature.feeds.title.DateInfoTitleView;
import kr.co.popone.fitts.feature.feeds.title.FittieInfoTitleView;
import kr.co.popone.fitts.feature.feeds.title.NormalTitleView;
import kr.co.popone.fitts.feature.feeds.title.RightAlignTitleView;
import kr.co.popone.fitts.feature.feeds.title.SmallSimpleTitleView;
import kr.co.popone.fitts.feature.feeds.title.TagInfoTitleView;
import kr.co.popone.fitts.feature.feeds.title.TagTypeTitleView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Feed implements FeedItem {
    @SerializedName("items")
    @NotNull
    private final List<FeedVariantInfo> feeds;
    private final long id;
    @SerializedName("view_more_scheme")
    @Nullable
    private final String scheme;
    @SerializedName("sub_title")
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("title_type")
    @Nullable
    private final TitleType titleType;
    @SerializedName("feed_type")
    private final Type type;

    public enum TitleType {
        SIMILAR_GROUP_PRODUCT,
        FOLLOWERS_NEW_POST,
        SIMILAR_GROUP_SHOP,
        POST_TODAY,
        TREND,
        TAGS,
        TAG_TITLE,
        SHOP_SHOW,
        NORMAL
    }

    public enum Type {
        BANNER,
        BANNER_HOME,
        POST_BIG_LEFT,
        POST_BIG_RIGHT,
        POST_TRIPLE,
        POST,
        PRODUCT_BIG_LEFT,
        PRODUCT_BIG_RIGHT,
        PRODUCT,
        PRODUCT_DOUBLE,
        IMAGE,
        TAGS,
        COLLECTION,
        FITTIE,
        IMAGE_TAG,
        SHOP_PREVIEW,
        SHOP_PARALLEL,
        ONLY_TITLE
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[Type.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = new int[Type.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = new int[TitleType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = new int[TitleType.values().length];

        static {
            $EnumSwitchMapping$0[Type.POST.ordinal()] = 1;
            $EnumSwitchMapping$1[Type.PRODUCT.ordinal()] = 1;
            $EnumSwitchMapping$1[Type.IMAGE.ordinal()] = 2;
            $EnumSwitchMapping$2[Type.PRODUCT.ordinal()] = 1;
            $EnumSwitchMapping$3[TitleType.SIMILAR_GROUP_SHOP.ordinal()] = 1;
            $EnumSwitchMapping$3[TitleType.FOLLOWERS_NEW_POST.ordinal()] = 2;
            $EnumSwitchMapping$3[TitleType.SIMILAR_GROUP_PRODUCT.ordinal()] = 3;
            $EnumSwitchMapping$3[TitleType.POST_TODAY.ordinal()] = 4;
            $EnumSwitchMapping$3[TitleType.TREND.ordinal()] = 5;
            $EnumSwitchMapping$3[TitleType.TAG_TITLE.ordinal()] = 6;
            $EnumSwitchMapping$3[TitleType.TAGS.ordinal()] = 7;
            $EnumSwitchMapping$3[TitleType.NORMAL.ordinal()] = 8;
            $EnumSwitchMapping$3[TitleType.SHOP_SHOW.ordinal()] = 9;
            $EnumSwitchMapping$4[TitleType.SIMILAR_GROUP_SHOP.ordinal()] = 1;
            $EnumSwitchMapping$4[TitleType.FOLLOWERS_NEW_POST.ordinal()] = 2;
            $EnumSwitchMapping$4[TitleType.SIMILAR_GROUP_PRODUCT.ordinal()] = 3;
            $EnumSwitchMapping$4[TitleType.POST_TODAY.ordinal()] = 4;
            $EnumSwitchMapping$4[TitleType.TREND.ordinal()] = 5;
            $EnumSwitchMapping$4[TitleType.TAG_TITLE.ordinal()] = 6;
            $EnumSwitchMapping$4[TitleType.TAGS.ordinal()] = 7;
            $EnumSwitchMapping$4[TitleType.NORMAL.ordinal()] = 8;
            $EnumSwitchMapping$4[TitleType.SHOP_SHOW.ordinal()] = 9;
        }
    }

    @NotNull
    public static /* synthetic */ Feed copy$default(Feed feed, long j, TitleType titleType2, String str, String str2, String str3, Type type2, List list, int i, Object obj) {
        Feed feed2 = feed;
        return feed.copy((i & 1) != 0 ? feed2.id : j, (i & 2) != 0 ? feed2.titleType : titleType2, (i & 4) != 0 ? feed2.title : str, (i & 8) != 0 ? feed2.subtitle : str2, (i & 16) != 0 ? feed2.scheme : str3, (i & 32) != 0 ? feed2.type : type2, (i & 64) != 0 ? feed2.feeds : list);
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final TitleType component2() {
        return this.titleType;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @Nullable
    public final String component4() {
        return this.subtitle;
    }

    @Nullable
    public final String component5() {
        return this.scheme;
    }

    @NotNull
    public final List<FeedVariantInfo> component7() {
        return this.feeds;
    }

    @NotNull
    public final Feed copy(long j, @Nullable TitleType titleType2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Type type2, @NotNull List<FeedVariantInfo> list) {
        List<FeedVariantInfo> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "feeds");
        Feed feed = new Feed(j, titleType2, str, str2, str3, type2, list2);
        return feed;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Feed) {
                Feed feed = (Feed) obj;
                if (!(this.id == feed.id) || !Intrinsics.areEqual((Object) this.titleType, (Object) feed.titleType) || !Intrinsics.areEqual((Object) this.title, (Object) feed.title) || !Intrinsics.areEqual((Object) this.subtitle, (Object) feed.subtitle) || !Intrinsics.areEqual((Object) this.scheme, (Object) feed.scheme) || !Intrinsics.areEqual((Object) this.type, (Object) feed.type) || !Intrinsics.areEqual((Object) this.feeds, (Object) feed.feeds)) {
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
        TitleType titleType2 = this.titleType;
        int i2 = 0;
        int hashCode = (i + (titleType2 != null ? titleType2.hashCode() : 0)) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.subtitle;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.scheme;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Type type2 = this.type;
        int hashCode5 = (hashCode4 + (type2 != null ? type2.hashCode() : 0)) * 31;
        List<FeedVariantInfo> list = this.feeds;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode5 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Feed(id=");
        sb.append(this.id);
        sb.append(", titleType=");
        sb.append(this.titleType);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", subtitle=");
        sb.append(this.subtitle);
        sb.append(", scheme=");
        sb.append(this.scheme);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", feeds=");
        sb.append(this.feeds);
        sb.append(")");
        return sb.toString();
    }

    public Feed(long j, @Nullable TitleType titleType2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Type type2, @NotNull List<FeedVariantInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "feeds");
        this.id = j;
        this.titleType = titleType2;
        this.title = str;
        this.subtitle = str2;
        this.scheme = str3;
        this.type = type2;
        this.feeds = list;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final TitleType getTitleType() {
        return this.titleType;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getScheme() {
        return this.scheme;
    }

    @NotNull
    public final List<FeedVariantInfo> getFeeds() {
        return this.feeds;
    }

    @Nullable
    public final Type getHomeFeedType() {
        Type type2;
        Type type3 = null;
        if (this.type == null || this.feeds.size() < 1) {
            return null;
        }
        Type type4 = this.type;
        if (type4 == null || WhenMappings.$EnumSwitchMapping$0[type4.ordinal()] != 1) {
            type2 = this.type;
        } else if (this.feeds.size() == 2) {
            type2 = Type.POST;
        } else {
            if (this.titleType != null) {
                type3 = Type.ONLY_TITLE;
            }
            type2 = type3;
        }
        return type2;
    }

    @Nullable
    public final Type getShopBridgeFeedType() {
        if (this.type == null || this.feeds.size() < 1) {
            return null;
        }
        Type type2 = this.type;
        if (type2 == null) {
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[type2.ordinal()];
        if (i == 1 || i == 2) {
            return this.type;
        }
        return null;
    }

    @Nullable
    public final Type getStoreFeedType() {
        if (this.type == null || this.feeds.size() < 1) {
            return null;
        }
        Type type2 = this.type;
        if (type2 == null || WhenMappings.$EnumSwitchMapping$2[type2.ordinal()] != 1) {
            return this.type;
        }
        if (this.feeds.size() == 2) {
            return Type.PRODUCT_DOUBLE;
        }
        if (this.feeds.size() == 3) {
            return Type.PRODUCT;
        }
        return null;
    }

    public final boolean updateProductLikeState(long j, boolean z) {
        if (getStoreFeedType() != Type.PRODUCT_DOUBLE) {
            return false;
        }
        FeedVariantInfo feedVariantInfo = (FeedVariantInfo) CollectionsKt___CollectionsKt.firstOrNull(this.feeds);
        if (feedVariantInfo != null) {
            FeedVariant feed = feedVariantInfo.getFeed();
            if (feed != null && feed.getId() == j) {
                FeedVariantInfo feedVariantInfo2 = (FeedVariantInfo) CollectionsKt___CollectionsKt.firstOrNull(this.feeds);
                if (feedVariantInfo2 != null) {
                    FeedVariant feed2 = feedVariantInfo2.getFeed();
                    if (feed2 != null) {
                        feed2.setInWishList(Boolean.valueOf(z));
                    }
                }
                return true;
            }
        }
        FeedVariantInfo feedVariantInfo3 = (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(this.feeds, 1);
        if (feedVariantInfo3 == null) {
            return false;
        }
        FeedVariant feed3 = feedVariantInfo3.getFeed();
        if (feed3 == null || feed3.getId() != j) {
            return false;
        }
        FeedVariantInfo feedVariantInfo4 = (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(this.feeds, 1);
        if (feedVariantInfo4 != null) {
            FeedVariant feed4 = feedVariantInfo4.getFeed();
            if (feed4 != null) {
                feed4.setInWishList(Boolean.valueOf(z));
            }
        }
        return true;
    }

    public final boolean updateShopBookmarkState(long j, boolean z) {
        if (getStoreFeedType() != Type.SHOP_PREVIEW) {
            return false;
        }
        FeedVariantInfo feedVariantInfo = (FeedVariantInfo) CollectionsKt___CollectionsKt.firstOrNull(this.feeds);
        if (feedVariantInfo == null) {
            return false;
        }
        FeedVariant feed = feedVariantInfo.getFeed();
        if (feed == null || feed.getId() != j) {
            return false;
        }
        FeedVariantInfo feedVariantInfo2 = (FeedVariantInfo) CollectionsKt___CollectionsKt.firstOrNull(this.feeds);
        if (feedVariantInfo2 != null) {
            FeedVariant feed2 = feedVariantInfo2.getFeed();
            if (feed2 != null) {
                feed2.setShopFavorite(z);
            }
        }
        return true;
    }

    @Nullable
    public final Type getTrendFeedType() {
        if (this.type == null || this.feeds.size() < 1) {
            return null;
        }
        return this.type;
    }

    @Nullable
    public static /* synthetic */ View getTitleHeaderView$default(Feed feed, Context context, SessionManager sessionManager, int i, Object obj) {
        if ((i & 2) != 0) {
            sessionManager = null;
        }
        return feed.getTitleHeaderView(context, sessionManager);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getTitleHeaderView(@org.jetbrains.annotations.NotNull android.content.Context r4, @org.jetbrains.annotations.Nullable kr.co.popone.fitts.base.SessionManager r5) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            kr.co.popone.fitts.model.datamodel.social.feed.Feed$TitleType r0 = r3.titleType
            if (r0 != 0) goto L_0x000a
            goto L_0x0069
        L_0x000a:
            int[] r1 = kr.co.popone.fitts.model.datamodel.social.feed.Feed.WhenMappings.$EnumSwitchMapping$3
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L_0x005e;
                case 2: goto L_0x005e;
                case 3: goto L_0x0054;
                case 4: goto L_0x0048;
                case 5: goto L_0x003c;
                case 6: goto L_0x0032;
                case 7: goto L_0x0028;
                case 8: goto L_0x001e;
                case 9: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0069
        L_0x0016:
            kr.co.popone.fitts.feature.feeds.title.RightAlignTitleView r5 = new kr.co.popone.fitts.feature.feeds.title.RightAlignTitleView
            java.lang.String r0 = r3.title
            r5.<init>(r4, r0)
            goto L_0x006a
        L_0x001e:
            kr.co.popone.fitts.feature.feeds.title.NormalTitleView r5 = new kr.co.popone.fitts.feature.feeds.title.NormalTitleView
            java.lang.String r0 = r3.title
            java.lang.String r1 = r3.scheme
            r5.<init>(r4, r0, r1)
            goto L_0x006a
        L_0x0028:
            kr.co.popone.fitts.feature.feeds.title.SmallSimpleTitleView r5 = new kr.co.popone.fitts.feature.feeds.title.SmallSimpleTitleView
            java.lang.String r0 = r3.title
            java.lang.String r1 = r3.scheme
            r5.<init>(r4, r0, r1)
            goto L_0x006a
        L_0x0032:
            kr.co.popone.fitts.feature.feeds.title.TagTypeTitleView r5 = new kr.co.popone.fitts.feature.feeds.title.TagTypeTitleView
            java.lang.String r0 = r3.title
            java.lang.String r1 = r3.subtitle
            r5.<init>(r4, r0, r1)
            goto L_0x006a
        L_0x003c:
            kr.co.popone.fitts.feature.feeds.title.TagInfoTitleView r5 = new kr.co.popone.fitts.feature.feeds.title.TagInfoTitleView
            java.lang.String r0 = r3.title
            java.lang.String r1 = r3.subtitle
            java.lang.String r2 = r3.scheme
            r5.<init>(r4, r0, r1, r2)
            goto L_0x006a
        L_0x0048:
            kr.co.popone.fitts.feature.feeds.title.DateInfoTitleView r5 = new kr.co.popone.fitts.feature.feeds.title.DateInfoTitleView
            java.lang.String r0 = r3.title
            java.lang.String r1 = r3.subtitle
            java.lang.String r2 = r3.scheme
            r5.<init>(r4, r0, r1, r2)
            goto L_0x006a
        L_0x0054:
            kr.co.popone.fitts.feature.feeds.title.FittieInfoTitleView r0 = new kr.co.popone.fitts.feature.feeds.title.FittieInfoTitleView
            java.lang.String r1 = "님과 유사한 체형의"
            java.lang.String r2 = "핏티들이 좋아하는 상품"
            r0.<init>(r4, r5, r1, r2)
            goto L_0x0067
        L_0x005e:
            kr.co.popone.fitts.feature.feeds.title.FittieInfoTitleView r0 = new kr.co.popone.fitts.feature.feeds.title.FittieInfoTitleView
            java.lang.String r1 = r3.title
            java.lang.String r2 = r3.subtitle
            r0.<init>(r4, r5, r1, r2)
        L_0x0067:
            r5 = r0
            goto L_0x006a
        L_0x0069:
            r5 = 0
        L_0x006a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.feed.Feed.getTitleHeaderView(android.content.Context, kr.co.popone.fitts.base.SessionManager):android.view.View");
    }

    @Nullable
    public static /* synthetic */ View getShopBridgeTitleView$default(Feed feed, Context context, String str, SessionManager sessionManager, int i, Object obj) {
        if ((i & 4) != 0) {
            sessionManager = null;
        }
        return feed.getShopBridgeTitleView(context, str, sessionManager);
    }

    @Nullable
    public final View getShopBridgeTitleView(@NotNull Context context, @NotNull String str, @Nullable SessionManager sessionManager) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "shopName");
        TitleType titleType2 = this.titleType;
        if (titleType2 != null) {
            switch (WhenMappings.$EnumSwitchMapping$4[titleType2.ordinal()]) {
                case 1:
                case 2:
                    return new FittieInfoTitleView(context, sessionManager, this.title, this.subtitle);
                case 3:
                    StringBuilder sb = new StringBuilder();
                    sb.append("핏티들이 좋아하는 ");
                    sb.append(str);
                    sb.append(" 상품");
                    return new FittieInfoTitleView(context, sessionManager, "님과 유사한 체형의", sb.toString());
                case 4:
                    return new DateInfoTitleView(context, this.title, this.subtitle, this.scheme);
                case 5:
                    return new TagInfoTitleView(context, this.title, this.subtitle, this.scheme);
                case 6:
                    return new TagTypeTitleView(context, this.title, this.subtitle);
                case 7:
                    return new SmallSimpleTitleView(context, this.title, this.scheme);
                case 8:
                    return new NormalTitleView(context, this.title, this.scheme);
                case 9:
                    return new RightAlignTitleView(context, this.title);
            }
        }
        return null;
    }
}
