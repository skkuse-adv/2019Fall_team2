package kr.co.popone.fitts.model.search;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StyleRecommendViewData {
    @Nullable
    private final String styleCoverImage;
    @NotNull
    private final String styleKeyword;

    @NotNull
    public static /* synthetic */ StyleRecommendViewData copy$default(StyleRecommendViewData styleRecommendViewData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = styleRecommendViewData.styleKeyword;
        }
        if ((i & 2) != 0) {
            str2 = styleRecommendViewData.styleCoverImage;
        }
        return styleRecommendViewData.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.styleKeyword;
    }

    @Nullable
    public final String component2() {
        return this.styleCoverImage;
    }

    @NotNull
    public final StyleRecommendViewData copy(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "styleKeyword");
        return new StyleRecommendViewData(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.styleCoverImage, (java.lang.Object) r3.styleCoverImage) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.search.StyleRecommendViewData
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.search.StyleRecommendViewData r3 = (kr.co.popone.fitts.model.search.StyleRecommendViewData) r3
            java.lang.String r0 = r2.styleKeyword
            java.lang.String r1 = r3.styleKeyword
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.styleCoverImage
            java.lang.String r3 = r3.styleCoverImage
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.StyleRecommendViewData.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.styleKeyword;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.styleCoverImage;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StyleRecommendViewData(styleKeyword=");
        sb.append(this.styleKeyword);
        sb.append(", styleCoverImage=");
        sb.append(this.styleCoverImage);
        sb.append(")");
        return sb.toString();
    }

    public StyleRecommendViewData(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "styleKeyword");
        this.styleKeyword = str;
        this.styleCoverImage = str2;
    }

    @NotNull
    public final String getStyleKeyword() {
        return this.styleKeyword;
    }

    @Nullable
    public final String getStyleCoverImage() {
        return this.styleCoverImage;
    }
}
