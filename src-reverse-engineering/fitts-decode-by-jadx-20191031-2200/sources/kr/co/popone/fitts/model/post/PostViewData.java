package kr.co.popone.fitts.model.post;

import io.fabric.sdk.android.services.settings.AppSettingsData;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostViewData {
    @NotNull
    private String aboutFit;
    @NotNull
    private String aboutSize;
    @NotNull
    private PostCoverImage coverImage;
    @NotNull
    private ArrayList<PostDetailImage> detailImages;
    private boolean isBlockedLink;
    private long postId;
    @NotNull
    private PostMode postMode = PostMode.CREATE;
    @NotNull
    private String postType;
    @Nullable
    private PostVariantViewData postVariantViewData;
    @NotNull
    private String price;
    @NotNull
    private String shopUrl;
    private float starScore;
    @NotNull
    private ArrayList<String> styleTags;
    @NotNull
    private String title;
    @NotNull
    private ArrayList<String> userTags;

    public enum PostMode {
        CREATE(AppSettingsData.STATUS_NEW),
        MODIFY("modify");

        private PostMode(String str) {
        }
    }

    public PostViewData() {
        String str = "";
        this.postType = str;
        this.title = str;
        this.aboutFit = str;
        this.aboutSize = str;
        this.shopUrl = str;
        this.price = str;
        this.styleTags = new ArrayList<>();
        this.userTags = new ArrayList<>();
        this.coverImage = new PostCoverImage(0, str);
        this.detailImages = new ArrayList<>();
    }

    @NotNull
    public final PostMode getPostMode() {
        return this.postMode;
    }

    public final void setPostMode(@NotNull PostMode postMode2) {
        Intrinsics.checkParameterIsNotNull(postMode2, "<set-?>");
        this.postMode = postMode2;
    }

    public final long getPostId() {
        return this.postId;
    }

    public final void setPostId(long j) {
        this.postId = j;
    }

    @NotNull
    public final String getPostType() {
        return this.postType;
    }

    public final void setPostType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.postType = str;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public final String getAboutFit() {
        return this.aboutFit;
    }

    public final void setAboutFit(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.aboutFit = str;
    }

    @NotNull
    public final String getAboutSize() {
        return this.aboutSize;
    }

    public final void setAboutSize(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.aboutSize = str;
    }

    @NotNull
    public final String getShopUrl() {
        return this.shopUrl;
    }

    public final void setShopUrl(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.shopUrl = str;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    public final void setPrice(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.price = str;
    }

    public final float getStarScore() {
        return this.starScore;
    }

    public final void setStarScore(float f) {
        this.starScore = f;
    }

    @NotNull
    public final ArrayList<String> getStyleTags() {
        return this.styleTags;
    }

    public final void setStyleTags(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.styleTags = arrayList;
    }

    @NotNull
    public final ArrayList<String> getUserTags() {
        return this.userTags;
    }

    public final void setUserTags(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.userTags = arrayList;
    }

    @NotNull
    public final PostCoverImage getCoverImage() {
        return this.coverImage;
    }

    public final void setCoverImage(@NotNull PostCoverImage postCoverImage) {
        Intrinsics.checkParameterIsNotNull(postCoverImage, "<set-?>");
        this.coverImage = postCoverImage;
    }

    @NotNull
    public final ArrayList<PostDetailImage> getDetailImages() {
        return this.detailImages;
    }

    public final void setDetailImages(@NotNull ArrayList<PostDetailImage> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.detailImages = arrayList;
    }

    public final boolean isBlockedLink() {
        return this.isBlockedLink;
    }

    public final void setBlockedLink(boolean z) {
        this.isBlockedLink = z;
    }

    @Nullable
    public final PostVariantViewData getPostVariantViewData() {
        return this.postVariantViewData;
    }

    public final void setPostVariantViewData(@Nullable PostVariantViewData postVariantViewData2) {
        this.postVariantViewData = postVariantViewData2;
    }
}
