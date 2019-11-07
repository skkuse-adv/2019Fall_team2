package kr.co.popone.fitts.model.datamodel.commerce.shop.bridge;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import org.jetbrains.annotations.NotNull;

public final class ShopBridgeTitleFeed implements FeedItem {
    @NotNull
    private final String title;

    @NotNull
    public static /* synthetic */ ShopBridgeTitleFeed copy$default(ShopBridgeTitleFeed shopBridgeTitleFeed, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopBridgeTitleFeed.title;
        }
        return shopBridgeTitleFeed.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final ShopBridgeTitleFeed copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        return new ShopBridgeTitleFeed(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.title, (java.lang.Object) ((kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeTitleFeed) r2).title) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeTitleFeed
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeTitleFeed r2 = (kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeTitleFeed) r2
            java.lang.String r0 = r1.title
            java.lang.String r2 = r2.title
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            return r2
        L_0x0015:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeTitleFeed.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.title;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShopBridgeTitleFeed(title=");
        sb.append(this.title);
        sb.append(")");
        return sb.toString();
    }

    public ShopBridgeTitleFeed(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        this.title = str;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
