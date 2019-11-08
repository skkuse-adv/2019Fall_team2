package kr.co.popone.fitts.model.datamodel.social.feed;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class FeedInfo {
    @SerializedName("items")
    @NotNull
    private final List<Feed> items;
    @SerializedName("trend_title")
    @NotNull
    private final String title;
    @SerializedName("version")
    @NotNull
    private final String version;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.datamodel.social.feed.Feed>, for r3v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo copy$default(kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo r0, java.lang.String r1, java.lang.String r2, java.util.List<kr.co.popone.fitts.model.datamodel.social.feed.Feed> r3, int r4, java.lang.Object r5) {
        /*
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            java.lang.String r1 = r0.version
        L_0x0006:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000c
            java.lang.String r2 = r0.title
        L_0x000c:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0012
            java.util.List<kr.co.popone.fitts.model.datamodel.social.feed.Feed> r3 = r0.items
        L_0x0012:
            kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo r0 = r0.copy(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo.copy$default(kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo, java.lang.String, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo");
    }

    @NotNull
    public final String component1() {
        return this.version;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final List<Feed> component3() {
        return this.items;
    }

    @NotNull
    public final FeedInfo copy(@NotNull String str, @NotNull String str2, @NotNull List<Feed> list) {
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(list, "items");
        return new FeedInfo(str, str2, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.items, (java.lang.Object) r3.items) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo r3 = (kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo) r3
            java.lang.String r0 = r2.version
            java.lang.String r1 = r3.version
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.title
            java.lang.String r1 = r3.title
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.util.List<kr.co.popone.fitts.model.datamodel.social.feed.Feed> r0 = r2.items
            java.util.List<kr.co.popone.fitts.model.datamodel.social.feed.Feed> r3 = r3.items
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            return r3
        L_0x0029:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.version;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Feed> list = this.items;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedInfo(version=");
        sb.append(this.version);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(")");
        return sb.toString();
    }

    public FeedInfo(@NotNull String str, @NotNull String str2, @NotNull List<Feed> list) {
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(list, "items");
        this.version = str;
        this.title = str2;
        this.items = list;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<Feed> getItems() {
        return this.items;
    }
}
