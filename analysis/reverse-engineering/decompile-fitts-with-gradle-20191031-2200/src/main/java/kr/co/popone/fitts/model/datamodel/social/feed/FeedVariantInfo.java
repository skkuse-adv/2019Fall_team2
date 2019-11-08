package kr.co.popone.fitts.model.datamodel.social.feed;

import com.google.gson.annotations.SerializedName;
import com.kakao.message.template.MessageTemplateProtocol;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class FeedVariantInfo {
    @SerializedName("item")
    @NotNull
    private final FeedVariant feed;

    @NotNull
    public static /* synthetic */ FeedVariantInfo copy$default(FeedVariantInfo feedVariantInfo, FeedVariant feedVariant, int i, Object obj) {
        if ((i & 1) != 0) {
            feedVariant = feedVariantInfo.feed;
        }
        return feedVariantInfo.copy(feedVariant);
    }

    @NotNull
    public final FeedVariant component1() {
        return this.feed;
    }

    @NotNull
    public final FeedVariantInfo copy(@NotNull FeedVariant feedVariant) {
        Intrinsics.checkParameterIsNotNull(feedVariant, MessageTemplateProtocol.TYPE_FEED);
        return new FeedVariantInfo(feedVariant);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.feed, (java.lang.Object) ((kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo) r2).feed) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo r2 = (kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo) r2
            kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant r0 = r1.feed
            kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant r2 = r2.feed
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        FeedVariant feedVariant = this.feed;
        if (feedVariant != null) {
            return feedVariant.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedVariantInfo(feed=");
        sb.append(this.feed);
        sb.append(")");
        return sb.toString();
    }

    public FeedVariantInfo(@NotNull FeedVariant feedVariant) {
        Intrinsics.checkParameterIsNotNull(feedVariant, MessageTemplateProtocol.TYPE_FEED);
        this.feed = feedVariant;
    }

    @NotNull
    public final FeedVariant getFeed() {
        return this.feed;
    }
}
