package kr.co.popone.fitts.model.search;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SearchRecommendViewData {
    @NotNull
    private final List<String> recommendKeywords;
    @NotNull
    private final List<StyleRecommendViewData> recommendStyles;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r1v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.search.StyleRecommendViewData>, for r2v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.search.SearchRecommendViewData copy$default(kr.co.popone.fitts.model.search.SearchRecommendViewData r0, java.util.List<java.lang.String> r1, java.util.List<kr.co.popone.fitts.model.search.StyleRecommendViewData> r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            java.util.List<java.lang.String> r1 = r0.recommendKeywords
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            java.util.List<kr.co.popone.fitts.model.search.StyleRecommendViewData> r2 = r0.recommendStyles
        L_0x000c:
            kr.co.popone.fitts.model.search.SearchRecommendViewData r0 = r0.copy(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchRecommendViewData.copy$default(kr.co.popone.fitts.model.search.SearchRecommendViewData, java.util.List, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.search.SearchRecommendViewData");
    }

    @NotNull
    public final List<String> component1() {
        return this.recommendKeywords;
    }

    @NotNull
    public final List<StyleRecommendViewData> component2() {
        return this.recommendStyles;
    }

    @NotNull
    public final SearchRecommendViewData copy(@NotNull List<String> list, @NotNull List<StyleRecommendViewData> list2) {
        Intrinsics.checkParameterIsNotNull(list, "recommendKeywords");
        Intrinsics.checkParameterIsNotNull(list2, "recommendStyles");
        return new SearchRecommendViewData(list, list2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.recommendStyles, (java.lang.Object) r3.recommendStyles) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.search.SearchRecommendViewData
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.search.SearchRecommendViewData r3 = (kr.co.popone.fitts.model.search.SearchRecommendViewData) r3
            java.util.List<java.lang.String> r0 = r2.recommendKeywords
            java.util.List<java.lang.String> r1 = r3.recommendKeywords
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.util.List<kr.co.popone.fitts.model.search.StyleRecommendViewData> r0 = r2.recommendStyles
            java.util.List<kr.co.popone.fitts.model.search.StyleRecommendViewData> r3 = r3.recommendStyles
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchRecommendViewData.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List<String> list = this.recommendKeywords;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<StyleRecommendViewData> list2 = this.recommendStyles;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchRecommendViewData(recommendKeywords=");
        sb.append(this.recommendKeywords);
        sb.append(", recommendStyles=");
        sb.append(this.recommendStyles);
        sb.append(")");
        return sb.toString();
    }

    public SearchRecommendViewData(@NotNull List<String> list, @NotNull List<StyleRecommendViewData> list2) {
        Intrinsics.checkParameterIsNotNull(list, "recommendKeywords");
        Intrinsics.checkParameterIsNotNull(list2, "recommendStyles");
        this.recommendKeywords = list;
        this.recommendStyles = list2;
    }

    @NotNull
    public final List<String> getRecommendKeywords() {
        return this.recommendKeywords;
    }

    @NotNull
    public final List<StyleRecommendViewData> getRecommendStyles() {
        return this.recommendStyles;
    }
}
