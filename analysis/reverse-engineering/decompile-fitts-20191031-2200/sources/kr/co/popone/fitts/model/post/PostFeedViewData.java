package kr.co.popone.fitts.model.post;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.search.IntergratedSearchInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostFeedViewData implements IntergratedSearchInterface {
    @Nullable
    private final String coverThumbnail;
    @Nullable
    private final String coverUrl;
    @Nullable
    private final String dominantColor;
    @NotNull
    private final String fittsId;
    private final boolean isSuitable;
    private final long postId;
    @Nullable
    private final String profileUrl;
    @NotNull
    private final String title;

    @NotNull
    public static /* synthetic */ PostFeedViewData copy$default(PostFeedViewData postFeedViewData, long j, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, Object obj) {
        PostFeedViewData postFeedViewData2 = postFeedViewData;
        int i2 = i;
        return postFeedViewData.copy((i2 & 1) != 0 ? postFeedViewData2.postId : j, (i2 & 2) != 0 ? postFeedViewData2.coverUrl : str, (i2 & 4) != 0 ? postFeedViewData2.coverThumbnail : str2, (i2 & 8) != 0 ? postFeedViewData2.dominantColor : str3, (i2 & 16) != 0 ? postFeedViewData2.title : str4, (i2 & 32) != 0 ? postFeedViewData2.profileUrl : str5, (i2 & 64) != 0 ? postFeedViewData2.fittsId : str6, (i2 & 128) != 0 ? postFeedViewData2.isSuitable : z);
    }

    public final long component1() {
        return this.postId;
    }

    @Nullable
    public final String component2() {
        return this.coverUrl;
    }

    @Nullable
    public final String component3() {
        return this.coverThumbnail;
    }

    @Nullable
    public final String component4() {
        return this.dominantColor;
    }

    @NotNull
    public final String component5() {
        return this.title;
    }

    @Nullable
    public final String component6() {
        return this.profileUrl;
    }

    @NotNull
    public final String component7() {
        return this.fittsId;
    }

    public final boolean component8() {
        return this.isSuitable;
    }

    @NotNull
    public final PostFeedViewData copy(long j, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, @NotNull String str6, boolean z) {
        String str7 = str4;
        Intrinsics.checkParameterIsNotNull(str7, "title");
        String str8 = str6;
        Intrinsics.checkParameterIsNotNull(str8, "fittsId");
        PostFeedViewData postFeedViewData = new PostFeedViewData(j, str, str2, str3, str7, str5, str8, z);
        return postFeedViewData;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PostFeedViewData) {
                PostFeedViewData postFeedViewData = (PostFeedViewData) obj;
                if ((this.postId == postFeedViewData.postId) && Intrinsics.areEqual((Object) this.coverUrl, (Object) postFeedViewData.coverUrl) && Intrinsics.areEqual((Object) this.coverThumbnail, (Object) postFeedViewData.coverThumbnail) && Intrinsics.areEqual((Object) this.dominantColor, (Object) postFeedViewData.dominantColor) && Intrinsics.areEqual((Object) this.title, (Object) postFeedViewData.title) && Intrinsics.areEqual((Object) this.profileUrl, (Object) postFeedViewData.profileUrl) && Intrinsics.areEqual((Object) this.fittsId, (Object) postFeedViewData.fittsId)) {
                    if (this.isSuitable == postFeedViewData.isSuitable) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.postId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.coverUrl;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.coverThumbnail;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.dominantColor;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.title;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.profileUrl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.fittsId;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = (hashCode5 + i2) * 31;
        boolean z = this.isSuitable;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostFeedViewData(postId=");
        sb.append(this.postId);
        sb.append(", coverUrl=");
        sb.append(this.coverUrl);
        sb.append(", coverThumbnail=");
        sb.append(this.coverThumbnail);
        sb.append(", dominantColor=");
        sb.append(this.dominantColor);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", profileUrl=");
        sb.append(this.profileUrl);
        sb.append(", fittsId=");
        sb.append(this.fittsId);
        sb.append(", isSuitable=");
        sb.append(this.isSuitable);
        sb.append(")");
        return sb.toString();
    }

    public PostFeedViewData(long j, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, @NotNull String str6, boolean z) {
        Intrinsics.checkParameterIsNotNull(str4, "title");
        Intrinsics.checkParameterIsNotNull(str6, "fittsId");
        this.postId = j;
        this.coverUrl = str;
        this.coverThumbnail = str2;
        this.dominantColor = str3;
        this.title = str4;
        this.profileUrl = str5;
        this.fittsId = str6;
        this.isSuitable = z;
    }

    public final long getPostId() {
        return this.postId;
    }

    @Nullable
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    public final String getCoverThumbnail() {
        return this.coverThumbnail;
    }

    @Nullable
    public final String getDominantColor() {
        return this.dominantColor;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getProfileUrl() {
        return this.profileUrl;
    }

    @NotNull
    public final String getFittsId() {
        return this.fittsId;
    }

    public final boolean isSuitable() {
        return this.isSuitable;
    }
}
