package kr.co.popone.fitts.model.search;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostFeedViewData;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.model.view.FittieFollowViewData;
import org.jetbrains.annotations.NotNull;

public final class IntergratedSearchViewData {
    @NotNull
    private final HasMoreInfo hasMore;
    @NotNull
    private final List<PostFeedViewData> posts;
    @NotNull
    private final List<ProductFeedViewData> products;
    @NotNull
    private final List<StoreInfo> store;
    @NotNull
    private final List<FittieFollowViewData> users;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.post.PostFeedViewData>, for r4v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.store.ProductFeedViewData>, for r6v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.store.StoreInfo>, for r7v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.view.FittieFollowViewData>, for r5v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.search.IntergratedSearchViewData copy$default(kr.co.popone.fitts.model.search.IntergratedSearchViewData r3, java.util.List<kr.co.popone.fitts.model.post.PostFeedViewData> r4, java.util.List<kr.co.popone.fitts.model.view.FittieFollowViewData> r5, java.util.List<kr.co.popone.fitts.model.store.ProductFeedViewData> r6, java.util.List<kr.co.popone.fitts.model.store.StoreInfo> r7, kr.co.popone.fitts.model.search.HasMoreInfo r8, int r9, java.lang.Object r10) {
        /*
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            java.util.List<kr.co.popone.fitts.model.post.PostFeedViewData> r4 = r3.posts
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            java.util.List<kr.co.popone.fitts.model.view.FittieFollowViewData> r5 = r3.users
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            java.util.List<kr.co.popone.fitts.model.store.ProductFeedViewData> r6 = r3.products
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            java.util.List<kr.co.popone.fitts.model.store.StoreInfo> r7 = r3.store
        L_0x001a:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0021
            kr.co.popone.fitts.model.search.HasMoreInfo r8 = r3.hasMore
        L_0x0021:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            kr.co.popone.fitts.model.search.IntergratedSearchViewData r3 = r5.copy(r6, r7, r8, r9, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.IntergratedSearchViewData.copy$default(kr.co.popone.fitts.model.search.IntergratedSearchViewData, java.util.List, java.util.List, java.util.List, java.util.List, kr.co.popone.fitts.model.search.HasMoreInfo, int, java.lang.Object):kr.co.popone.fitts.model.search.IntergratedSearchViewData");
    }

    @NotNull
    public final List<PostFeedViewData> component1() {
        return this.posts;
    }

    @NotNull
    public final List<FittieFollowViewData> component2() {
        return this.users;
    }

    @NotNull
    public final List<ProductFeedViewData> component3() {
        return this.products;
    }

    @NotNull
    public final List<StoreInfo> component4() {
        return this.store;
    }

    @NotNull
    public final HasMoreInfo component5() {
        return this.hasMore;
    }

    @NotNull
    public final IntergratedSearchViewData copy(@NotNull List<PostFeedViewData> list, @NotNull List<FittieFollowViewData> list2, @NotNull List<ProductFeedViewData> list3, @NotNull List<StoreInfo> list4, @NotNull HasMoreInfo hasMoreInfo) {
        Intrinsics.checkParameterIsNotNull(list, "posts");
        Intrinsics.checkParameterIsNotNull(list2, "users");
        Intrinsics.checkParameterIsNotNull(list3, "products");
        Intrinsics.checkParameterIsNotNull(list4, "store");
        Intrinsics.checkParameterIsNotNull(hasMoreInfo, "hasMore");
        IntergratedSearchViewData intergratedSearchViewData = new IntergratedSearchViewData(list, list2, list3, list4, hasMoreInfo);
        return intergratedSearchViewData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.hasMore, (java.lang.Object) r3.hasMore) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x003d
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.search.IntergratedSearchViewData
            if (r0 == 0) goto L_0x003b
            kr.co.popone.fitts.model.search.IntergratedSearchViewData r3 = (kr.co.popone.fitts.model.search.IntergratedSearchViewData) r3
            java.util.List<kr.co.popone.fitts.model.post.PostFeedViewData> r0 = r2.posts
            java.util.List<kr.co.popone.fitts.model.post.PostFeedViewData> r1 = r3.posts
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.util.List<kr.co.popone.fitts.model.view.FittieFollowViewData> r0 = r2.users
            java.util.List<kr.co.popone.fitts.model.view.FittieFollowViewData> r1 = r3.users
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.util.List<kr.co.popone.fitts.model.store.ProductFeedViewData> r0 = r2.products
            java.util.List<kr.co.popone.fitts.model.store.ProductFeedViewData> r1 = r3.products
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.util.List<kr.co.popone.fitts.model.store.StoreInfo> r0 = r2.store
            java.util.List<kr.co.popone.fitts.model.store.StoreInfo> r1 = r3.store
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            kr.co.popone.fitts.model.search.HasMoreInfo r0 = r2.hasMore
            kr.co.popone.fitts.model.search.HasMoreInfo r3 = r3.hasMore
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r3 = 0
            return r3
        L_0x003d:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.IntergratedSearchViewData.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List<PostFeedViewData> list = this.posts;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<FittieFollowViewData> list2 = this.users;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ProductFeedViewData> list3 = this.products;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<StoreInfo> list4 = this.store;
        int hashCode4 = (hashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31;
        HasMoreInfo hasMoreInfo = this.hasMore;
        if (hasMoreInfo != null) {
            i = hasMoreInfo.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IntergratedSearchViewData(posts=");
        sb.append(this.posts);
        sb.append(", users=");
        sb.append(this.users);
        sb.append(", products=");
        sb.append(this.products);
        sb.append(", store=");
        sb.append(this.store);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(")");
        return sb.toString();
    }

    public IntergratedSearchViewData(@NotNull List<PostFeedViewData> list, @NotNull List<FittieFollowViewData> list2, @NotNull List<ProductFeedViewData> list3, @NotNull List<StoreInfo> list4, @NotNull HasMoreInfo hasMoreInfo) {
        Intrinsics.checkParameterIsNotNull(list, "posts");
        Intrinsics.checkParameterIsNotNull(list2, "users");
        Intrinsics.checkParameterIsNotNull(list3, "products");
        Intrinsics.checkParameterIsNotNull(list4, "store");
        Intrinsics.checkParameterIsNotNull(hasMoreInfo, "hasMore");
        this.posts = list;
        this.users = list2;
        this.products = list3;
        this.store = list4;
        this.hasMore = hasMoreInfo;
    }

    @NotNull
    public final List<PostFeedViewData> getPosts() {
        return this.posts;
    }

    @NotNull
    public final List<FittieFollowViewData> getUsers() {
        return this.users;
    }

    @NotNull
    public final List<ProductFeedViewData> getProducts() {
        return this.products;
    }

    @NotNull
    public final List<StoreInfo> getStore() {
        return this.store;
    }

    @NotNull
    public final HasMoreInfo getHasMore() {
        return this.hasMore;
    }
}
