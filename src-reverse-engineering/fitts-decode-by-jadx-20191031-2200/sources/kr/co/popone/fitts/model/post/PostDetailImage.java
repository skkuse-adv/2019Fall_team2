package kr.co.popone.fitts.model.post;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostDetailImage {
    @Nullable
    private String detailImageDescription;
    @Nullable
    private Integer detailImageId;
    @NotNull
    private String detailImagePath;

    @NotNull
    public static /* synthetic */ PostDetailImage copy$default(PostDetailImage postDetailImage, Integer num, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = postDetailImage.detailImageId;
        }
        if ((i & 2) != 0) {
            str = postDetailImage.detailImagePath;
        }
        if ((i & 4) != 0) {
            str2 = postDetailImage.detailImageDescription;
        }
        return postDetailImage.copy(num, str, str2);
    }

    @Nullable
    public final Integer component1() {
        return this.detailImageId;
    }

    @NotNull
    public final String component2() {
        return this.detailImagePath;
    }

    @Nullable
    public final String component3() {
        return this.detailImageDescription;
    }

    @NotNull
    public final PostDetailImage copy(@Nullable Integer num, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "detailImagePath");
        return new PostDetailImage(num, str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.detailImageDescription, (java.lang.Object) r3.detailImageDescription) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.post.PostDetailImage
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.post.PostDetailImage r3 = (kr.co.popone.fitts.model.post.PostDetailImage) r3
            java.lang.Integer r0 = r2.detailImageId
            java.lang.Integer r1 = r3.detailImageId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.detailImagePath
            java.lang.String r1 = r3.detailImagePath
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.detailImageDescription
            java.lang.String r3 = r3.detailImageDescription
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.post.PostDetailImage.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Integer num = this.detailImageId;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.detailImagePath;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.detailImageDescription;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostDetailImage(detailImageId=");
        sb.append(this.detailImageId);
        sb.append(", detailImagePath=");
        sb.append(this.detailImagePath);
        sb.append(", detailImageDescription=");
        sb.append(this.detailImageDescription);
        sb.append(")");
        return sb.toString();
    }

    public PostDetailImage(@Nullable Integer num, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "detailImagePath");
        this.detailImageId = num;
        this.detailImagePath = str;
        this.detailImageDescription = str2;
    }

    @Nullable
    public final Integer getDetailImageId() {
        return this.detailImageId;
    }

    public final void setDetailImageId(@Nullable Integer num) {
        this.detailImageId = num;
    }

    @NotNull
    public final String getDetailImagePath() {
        return this.detailImagePath;
    }

    public final void setDetailImagePath(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.detailImagePath = str;
    }

    @Nullable
    public final String getDetailImageDescription() {
        return this.detailImageDescription;
    }

    public final void setDetailImageDescription(@Nullable String str) {
        this.detailImageDescription = str;
    }
}
