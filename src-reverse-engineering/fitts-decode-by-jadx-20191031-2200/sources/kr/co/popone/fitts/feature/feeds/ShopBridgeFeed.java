package kr.co.popone.fitts.feature.feeds;

import com.kakao.message.template.MessageTemplateProtocol;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import org.jetbrains.annotations.NotNull;

public final class ShopBridgeFeed implements FeedItem {
    @NotNull
    private final Feed feed;
    @NotNull
    private final String shopName;

    @NotNull
    public static /* synthetic */ ShopBridgeFeed copy$default(ShopBridgeFeed shopBridgeFeed, String str, Feed feed2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopBridgeFeed.shopName;
        }
        if ((i & 2) != 0) {
            feed2 = shopBridgeFeed.feed;
        }
        return shopBridgeFeed.copy(str, feed2);
    }

    @NotNull
    public final String component1() {
        return this.shopName;
    }

    @NotNull
    public final Feed component2() {
        return this.feed;
    }

    @NotNull
    public final ShopBridgeFeed copy(@NotNull String str, @NotNull Feed feed2) {
        Intrinsics.checkParameterIsNotNull(str, "shopName");
        Intrinsics.checkParameterIsNotNull(feed2, MessageTemplateProtocol.TYPE_FEED);
        return new ShopBridgeFeed(str, feed2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.feed, (java.lang.Object) r3.feed) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.feature.feeds.ShopBridgeFeed
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.feature.feeds.ShopBridgeFeed r3 = (kr.co.popone.fitts.feature.feeds.ShopBridgeFeed) r3
            java.lang.String r0 = r2.shopName
            java.lang.String r1 = r3.shopName
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.datamodel.social.feed.Feed r0 = r2.feed
            kr.co.popone.fitts.model.datamodel.social.feed.Feed r3 = r3.feed
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.feeds.ShopBridgeFeed.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.shopName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Feed feed2 = this.feed;
        if (feed2 != null) {
            i = feed2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShopBridgeFeed(shopName=");
        sb.append(this.shopName);
        sb.append(", feed=");
        sb.append(this.feed);
        sb.append(")");
        return sb.toString();
    }

    public ShopBridgeFeed(@NotNull String str, @NotNull Feed feed2) {
        Intrinsics.checkParameterIsNotNull(str, "shopName");
        Intrinsics.checkParameterIsNotNull(feed2, MessageTemplateProtocol.TYPE_FEED);
        this.shopName = str;
        this.feed = feed2;
    }

    @NotNull
    public final String getShopName() {
        return this.shopName;
    }

    @NotNull
    public final Feed getFeed() {
        return this.feed;
    }
}
