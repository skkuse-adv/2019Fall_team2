package kr.co.popone.fitts.model.post;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostCoverImage {
    private int coverImageId;
    @NotNull
    private String coverImagePath;

    @NotNull
    public static /* synthetic */ PostCoverImage copy$default(PostCoverImage postCoverImage, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = postCoverImage.coverImageId;
        }
        if ((i2 & 2) != 0) {
            str = postCoverImage.coverImagePath;
        }
        return postCoverImage.copy(i, str);
    }

    public final int component1() {
        return this.coverImageId;
    }

    @NotNull
    public final String component2() {
        return this.coverImagePath;
    }

    @NotNull
    public final PostCoverImage copy(int i, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "coverImagePath");
        return new PostCoverImage(i, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PostCoverImage) {
                PostCoverImage postCoverImage = (PostCoverImage) obj;
                if (!(this.coverImageId == postCoverImage.coverImageId) || !Intrinsics.areEqual((Object) this.coverImagePath, (Object) postCoverImage.coverImagePath)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.coverImageId * 31;
        String str = this.coverImagePath;
        return i + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostCoverImage(coverImageId=");
        sb.append(this.coverImageId);
        sb.append(", coverImagePath=");
        sb.append(this.coverImagePath);
        sb.append(")");
        return sb.toString();
    }

    public PostCoverImage(int i, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "coverImagePath");
        this.coverImageId = i;
        this.coverImagePath = str;
    }

    public final int getCoverImageId() {
        return this.coverImageId;
    }

    public final void setCoverImageId(int i) {
        this.coverImageId = i;
    }

    @NotNull
    public final String getCoverImagePath() {
        return this.coverImagePath;
    }

    public final void setCoverImagePath(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.coverImagePath = str;
    }
}
