package kr.co.popone.fitts.model.remote.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class UserResponse$NCommerceResponse {
    @SerializedName("monthly_total_return")
    @NotNull
    private final List<NCommerce> NCommerceHistory;
    @SerializedName("this_month")
    @NotNull
    private final NCommerce thisMonthNCommerce;
    @SerializedName("top_shared_posts")
    @NotNull
    private final List<Post> topSharedPosts;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post>, for r2v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.remote.user.NCommerce>, for r3v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse copy$default(kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse r0, kr.co.popone.fitts.model.remote.user.NCommerce r1, java.util.List<kr.co.popone.fitts.model.post.PostAPI.Post> r2, java.util.List<kr.co.popone.fitts.model.remote.user.NCommerce> r3, int r4, java.lang.Object r5) {
        /*
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            kr.co.popone.fitts.model.remote.user.NCommerce r1 = r0.thisMonthNCommerce
        L_0x0006:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000c
            java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r2 = r0.topSharedPosts
        L_0x000c:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0012
            java.util.List<kr.co.popone.fitts.model.remote.user.NCommerce> r3 = r0.NCommerceHistory
        L_0x0012:
            kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse r0 = r0.copy(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse.copy$default(kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse, kr.co.popone.fitts.model.remote.user.NCommerce, java.util.List, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse");
    }

    @NotNull
    public final NCommerce component1() {
        return this.thisMonthNCommerce;
    }

    @NotNull
    public final List<Post> component2() {
        return this.topSharedPosts;
    }

    @NotNull
    public final List<NCommerce> component3() {
        return this.NCommerceHistory;
    }

    @NotNull
    public final UserResponse$NCommerceResponse copy(@NotNull NCommerce nCommerce, @NotNull List<Post> list, @NotNull List<NCommerce> list2) {
        Intrinsics.checkParameterIsNotNull(nCommerce, "thisMonthNCommerce");
        Intrinsics.checkParameterIsNotNull(list, "topSharedPosts");
        Intrinsics.checkParameterIsNotNull(list2, "NCommerceHistory");
        return new UserResponse$NCommerceResponse(nCommerce, list, list2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.NCommerceHistory, (java.lang.Object) r3.NCommerceHistory) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse r3 = (kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse) r3
            kr.co.popone.fitts.model.remote.user.NCommerce r0 = r2.thisMonthNCommerce
            kr.co.popone.fitts.model.remote.user.NCommerce r1 = r3.thisMonthNCommerce
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r0 = r2.topSharedPosts
            java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r1 = r3.topSharedPosts
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.util.List<kr.co.popone.fitts.model.remote.user.NCommerce> r0 = r2.NCommerceHistory
            java.util.List<kr.co.popone.fitts.model.remote.user.NCommerce> r3 = r3.NCommerceHistory
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        NCommerce nCommerce = this.thisMonthNCommerce;
        int i = 0;
        int hashCode = (nCommerce != null ? nCommerce.hashCode() : 0) * 31;
        List<Post> list = this.topSharedPosts;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<NCommerce> list2 = this.NCommerceHistory;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NCommerceResponse(thisMonthNCommerce=");
        sb.append(this.thisMonthNCommerce);
        sb.append(", topSharedPosts=");
        sb.append(this.topSharedPosts);
        sb.append(", NCommerceHistory=");
        sb.append(this.NCommerceHistory);
        sb.append(")");
        return sb.toString();
    }

    public UserResponse$NCommerceResponse(@NotNull NCommerce nCommerce, @NotNull List<Post> list, @NotNull List<NCommerce> list2) {
        Intrinsics.checkParameterIsNotNull(nCommerce, "thisMonthNCommerce");
        Intrinsics.checkParameterIsNotNull(list, "topSharedPosts");
        Intrinsics.checkParameterIsNotNull(list2, "NCommerceHistory");
        this.thisMonthNCommerce = nCommerce;
        this.topSharedPosts = list;
        this.NCommerceHistory = list2;
    }

    @NotNull
    public final NCommerce getThisMonthNCommerce() {
        return this.thisMonthNCommerce;
    }

    @NotNull
    public final List<Post> getTopSharedPosts() {
        return this.topSharedPosts;
    }

    @NotNull
    public final List<NCommerce> getNCommerceHistory() {
        return this.NCommerceHistory;
    }
}
