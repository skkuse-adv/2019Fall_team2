package kr.co.popone.fitts.model.post;

import com.kakao.usermgmt.StringSet;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationCoverRes;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationEditDrawable;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationStyleTag;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import kr.co.popone.fitts.model.post.PostViewData.PostMode;
import org.jetbrains.annotations.NotNull;

public final class PostViewDataExtensionKt {
    private static final Regex SHOP_LINK_REGEX = new Regex("(http|https)://([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,3}/.+");

    public static final void addUserTag(@NotNull PostViewData postViewData, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, StringSet.tag);
        if (!postViewData.getUserTags().contains(str)) {
            postViewData.getUserTags().add(str);
        }
    }

    public static final void deleteUserTag(@NotNull PostViewData postViewData, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, StringSet.tag);
        postViewData.getUserTags().remove(str);
    }

    @NotNull
    public static final CreatePost convert(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        CreatePost createPost = new CreatePost(postViewData.getPostId());
        createPost.setPostID(postViewData.getPostId());
        String postType = postViewData.getPostType();
        if (postType != null) {
            String upperCase = postType.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            createPost.setPostType(PostType.valueOf(upperCase));
            createPost.setTitle(postViewData.getTitle());
            createPost.setAboutFit(postViewData.getAboutFit());
            createPost.setStar(postViewData.getStarScore());
            createPost.setStyleTags(postViewData.getStyleTags());
            createPost.setTags(postViewData.getUserTags());
            createPost.setAboutSize(postViewData.getAboutSize());
            createPost.setShop(postViewData.getShopUrl());
            createPost.setPrice(postViewData.getPrice());
            createPost.setCoverID(postViewData.getCoverImage().getCoverImageId());
            createPost.setCoverImagePath(postViewData.getCoverImage().getCoverImagePath());
            for (PostDetailImage postDetailImage : postViewData.getDetailImages()) {
                CreatePostImage createPostImage = new CreatePostImage(postDetailImage.getDetailImagePath());
                createPostImage.setId(postDetailImage.getDetailImageId());
                createPostImage.setDescription(postDetailImage.getDetailImageDescription());
                createPost.getFreeformImagesPath().add(createPostImage);
            }
            return createPost;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final void editDetailImages(@NotNull PostViewData postViewData, @NotNull ArrayList<CreatePostImage> arrayList) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Intrinsics.checkParameterIsNotNull(arrayList, "images");
        postViewData.getDetailImages().clear();
        for (CreatePostImage createPostImage : arrayList) {
            postViewData.getDetailImages().add(new PostDetailImage(createPostImage.getId(), createPostImage.getPath(), createPostImage.getDescription()));
        }
    }

    public static final int getScrolledPosition(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        String str = "SHOES";
        String str2 = "CLOTHES";
        boolean z = true;
        if (postViewData.getPostMode() == PostMode.CREATE) {
            if (postViewData.getCoverImage().getCoverImagePath().length() == 0) {
                return C0010R$id.post_cover_layout;
            }
            if (postViewData.getTitle().length() == 0) {
                return C0010R$id.layout_create_post;
            }
            if (postViewData.getDetailImages().size() < getDetailImageMinCount(postViewData)) {
                return C0010R$id.post_images_layout;
            }
            if (postViewData.getStarScore() <= 0.0f) {
                return C0010R$id.post_rating_layout;
            }
            if (postViewData.getAboutFit().length() < getAboutFitMinCount(postViewData)) {
                return C0010R$id.about_product_layout;
            }
            if (postViewData.getStyleTags().isEmpty()) {
                return C0010R$id.post_tag_layout;
            }
            if (Intrinsics.areEqual((Object) postViewData.getPostType(), (Object) str2)) {
                if (postViewData.getAboutSize().length() != 0) {
                    z = false;
                }
                if (z) {
                    return C0010R$id.about_size_layout;
                }
            }
            return (!Intrinsics.areEqual((Object) postViewData.getPostType(), (Object) str) || StringsKt__StringNumberConversionsKt.toIntOrNull(postViewData.getAboutSize()) == null || Integer.parseInt(postViewData.getAboutSize()) <= 0 || Integer.parseInt(postViewData.getAboutSize()) > 300) ? C0010R$id.shop_layout : C0010R$id.about_size_layout;
        }
        if (postViewData.getCoverImage().getCoverImagePath().length() == 0) {
            return C0010R$id.post_cover_layout;
        }
        if (postViewData.getTitle().length() == 0) {
            return C0010R$id.layout_create_post;
        }
        if (postViewData.getDetailImages().size() < getDetailImageMinCount(postViewData)) {
            return C0010R$id.post_images_layout;
        }
        if (postViewData.getStarScore() <= 0.0f) {
            return C0010R$id.post_rating_layout;
        }
        if (postViewData.getAboutFit().length() < getAboutFitMinCount(postViewData)) {
            return C0010R$id.about_product_layout;
        }
        if (Intrinsics.areEqual((Object) postViewData.getPostType(), (Object) str2)) {
            if (postViewData.getAboutSize().length() != 0) {
                z = false;
            }
            if (z) {
                return C0010R$id.about_size_layout;
            }
        }
        return (!Intrinsics.areEqual((Object) postViewData.getPostType(), (Object) str) || StringsKt__StringNumberConversionsKt.toIntOrNull(postViewData.getAboutSize()) == null || Integer.parseInt(postViewData.getAboutSize()) <= 0 || Integer.parseInt(postViewData.getAboutSize()) > 300) ? C0010R$id.shop_layout : C0010R$id.about_size_layout;
    }

    public static final int getAboutFitMinCount(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        String postType = postViewData.getPostType();
        return (postType.hashCode() == 1584551976 && postType.equals("CLOTHES")) ? 50 : 100;
    }

    public static final int getDetailImageMinCount(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        String postType = postViewData.getPostType();
        return (postType.hashCode() == 1584551976 && postType.equals("CLOTHES")) ? 1 : 2;
    }

    public static final void convertPostModel(@NotNull PostViewData postViewData, @NotNull CreatePost createPost) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Intrinsics.checkParameterIsNotNull(createPost, "item");
        postViewData.setPostId(createPost.getPostID());
        postViewData.setPostType(createPost.getPostType().name());
        postViewData.setTitle(createPost.getTitle());
        postViewData.setAboutFit(createPost.getAboutFit());
        postViewData.setStarScore(createPost.getStar());
        postViewData.setStyleTags(createPost.getStyleTags());
        postViewData.setUserTags(createPost.getTags());
        postViewData.setAboutSize(createPost.getAboutSize());
        postViewData.setShopUrl(createPost.getShop());
        postViewData.setPrice(createPost.getPrice());
        createPost.getCoverID();
        postViewData.setCoverImage(new PostCoverImage(createPost.getCoverID(), createPost.getCoverImagePath()));
        for (CreatePostImage createPostImage : createPost.getFreeformImagesPath()) {
            postViewData.getDetailImages().add(new PostDetailImage(createPostImage.getId(), createPostImage.getPath(), createPostImage.getDescription()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006d, code lost:
        if (r6 != null) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void convertPostModel(@org.jetbrains.annotations.NotNull kr.co.popone.fitts.model.post.PostViewData r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kr.co.popone.fitts.model.post.PostAPI.Post r7) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            kr.co.popone.fitts.model.post.PostViewData$PostMode r0 = kr.co.popone.fitts.model.post.PostViewData.PostMode.MODIFY
            r5.setPostMode(r0)
            r5.setPostType(r6)
            long r0 = r7.getId()
            r5.setPostId(r0)
            kr.co.popone.fitts.model.post.PostCoverImage r6 = r5.getCoverImage()
            kr.co.popone.fitts.model.datamodel.service.post.Image r0 = r7.getCoverImage()
            if (r0 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x002b:
            int r0 = r0.getAttachment_id()
            r6.setCoverImageId(r0)
            kr.co.popone.fitts.model.post.PostCoverImage r6 = r5.getCoverImage()
            kr.co.popone.fitts.model.datamodel.service.post.Image r0 = r7.getCoverImage()
            java.lang.String r0 = r0.getUrl()
            r6.setCoverImagePath(r0)
            java.lang.String r6 = r7.getTitle()
            r5.setTitle(r6)
            java.lang.String r6 = r7.getAboutFit()
            r5.setAboutFit(r6)
            float r6 = r7.getStars()
            r5.setStarScore(r6)
            java.lang.String r6 = r7.getAboutSize()
            java.lang.String r0 = ""
            if (r6 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r6 = r0
        L_0x0060:
            r5.setAboutSize(r6)
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r6 = r7.getLinkInfo()
            if (r6 == 0) goto L_0x0070
            java.lang.String r6 = r6.getLinkUrl()
            if (r6 == 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r6 = r0
        L_0x0071:
            r5.setShopUrl(r6)
            java.util.List r6 = r7.getTags()
            if (r6 == 0) goto L_0x0096
            java.util.Iterator r6 = r6.iterator()
        L_0x007e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0096
            java.lang.Object r0 = r6.next()
            kr.co.popone.fitts.model.post.PostAPI$Tag r0 = (kr.co.popone.fitts.model.post.PostAPI.Tag) r0
            java.util.ArrayList r1 = r5.getUserTags()
            java.lang.String r0 = r0.getTitle()
            r1.add(r0)
            goto L_0x007e
        L_0x0096:
            java.util.List r6 = r7.getFreeformImages()
            if (r6 == 0) goto L_0x00c9
            java.util.Iterator r6 = r6.iterator()
        L_0x00a0:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x00c9
            java.lang.Object r0 = r6.next()
            kr.co.popone.fitts.model.datamodel.service.post.Image r0 = (kr.co.popone.fitts.model.datamodel.service.post.Image) r0
            java.util.ArrayList r1 = r5.getDetailImages()
            kr.co.popone.fitts.model.post.PostDetailImage r2 = new kr.co.popone.fitts.model.post.PostDetailImage
            int r3 = r0.getAttachment_id()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = r0.getUrl()
            java.lang.String r0 = r0.getDescription()
            r2.<init>(r3, r4, r0)
            r1.add(r2)
            goto L_0x00a0
        L_0x00c9:
            java.util.List r6 = r7.getStyles()
            if (r6 == 0) goto L_0x00eb
            java.util.Iterator r6 = r6.iterator()
        L_0x00d3:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00eb
            java.lang.Object r7 = r6.next()
            kr.co.popone.fitts.model.post.PostAPI$Style r7 = (kr.co.popone.fitts.model.post.PostAPI.Style) r7
            java.util.ArrayList r0 = r5.getStyleTags()
            java.lang.String r7 = r7.getName()
            r0.add(r7)
            goto L_0x00d3
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.post.PostViewDataExtensionKt.convertPostModel(kr.co.popone.fitts.model.post.PostViewData, java.lang.String, kr.co.popone.fitts.model.post.PostAPI$Post):void");
    }

    public static final boolean isPostValidate(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        boolean z = true;
        if (postViewData.getPostMode() == PostMode.CREATE) {
            if (postViewData.getTitle().length() > 0) {
                if ((postViewData.getCoverImage().getCoverImagePath().length() > 0) && postViewData.getDetailImages().size() >= getDetailImageMinCount(postViewData) && postViewData.getStarScore() > 0.0f && postViewData.getAboutFit().length() >= getAboutFitMinCount(postViewData) && aboutSizeValidation(postViewData)) {
                    if ((postViewData.getShopUrl().length() > 0) && postViewData.getStyleTags().size() > 0 && SHOP_LINK_REGEX.matches(postViewData.getShopUrl()) && !postViewData.isBlockedLink()) {
                        z = false;
                    }
                }
            }
            return z;
        }
        if (postViewData.getTitle().length() > 0) {
            if ((postViewData.getCoverImage().getCoverImagePath().length() > 0) && postViewData.getDetailImages().size() >= getDetailImageMinCount(postViewData) && postViewData.getStarScore() > 0.0f && postViewData.getAboutFit().length() >= getAboutFitMinCount(postViewData) && aboutSizeValidation(postViewData)) {
                if ((postViewData.getShopUrl().length() > 0) && SHOP_LINK_REGEX.matches(postViewData.getShopUrl()) && !postViewData.isBlockedLink()) {
                    z = false;
                }
            }
        }
        return z;
    }

    private static final boolean aboutSizeValidation(@NotNull PostViewData postViewData) {
        String postType = postViewData.getPostType();
        int hashCode = postType.hashCode();
        if (hashCode != 78875336) {
            if (hashCode != 1584551976 || !postType.equals("CLOTHES")) {
                return true;
            }
            if (!(postViewData.getAboutSize().length() == 0)) {
                return true;
            }
        } else if (!postType.equals("SHOES")) {
            return true;
        } else {
            if (StringsKt__StringNumberConversionsKt.toIntOrNull(postViewData.getAboutSize()) != null && Integer.parseInt(postViewData.getAboutSize()) > 0 && Integer.parseInt(postViewData.getAboutSize()) <= 300) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Single<ValidationEditDrawable> isPostTitleValidate(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Single<ValidationEditDrawable> map = Single.just(postViewData.getTitle()).map(PostViewDataExtensionKt$isPostTitleValidate$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "Single.just(title)\n     …wable.VALID\n            }");
        return map;
    }

    @NotNull
    public static final Single<ValidationTextColor> isStarScoreValidate(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Single<ValidationTextColor> map = Single.just(Float.valueOf(postViewData.getStarScore())).map(PostViewDataExtensionKt$isStarScoreValidate$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "Single.just(starScore)\n …Color.VALID\n            }");
        return map;
    }

    @NotNull
    public static final Single<ValidationTextColor> isAboutFitValidate(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Single<ValidationTextColor> map = Single.just(postViewData.getAboutFit()).map(new PostViewDataExtensionKt$isAboutFitValidate$1(postViewData));
        Intrinsics.checkExpressionValueIsNotNull(map, "Single.just(aboutFit)\n  …Color.VALID\n            }");
        return map;
    }

    @NotNull
    public static final Single<ValidationTextColor> isAboutSizeValidate(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Single<ValidationTextColor> map = Single.just(postViewData.getPostType()).map(new PostViewDataExtensionKt$isAboutSizeValidate$1(postViewData));
        Intrinsics.checkExpressionValueIsNotNull(map, "Single.just(postType)\n  …          }\n            }");
        return map;
    }

    public static final boolean isShopLinkValidate(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        return !(postViewData.getShopUrl().length() == 0) && SHOP_LINK_REGEX.matches(postViewData.getShopUrl());
    }

    @NotNull
    public static final Single<LinkInfo> isBlockedShopLink(@NotNull PostViewData postViewData, @NotNull PostAPI postAPI) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postAPI, "postAPI");
        return postAPI.requestLinkInfo(postViewData.getShopUrl());
    }

    @NotNull
    public static final Single<ValidationCoverRes> isCoverImageValidate(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Single<ValidationCoverRes> map = Single.just(postViewData.getCoverImage().getCoverImagePath()).map(PostViewDataExtensionKt$isCoverImageValidate$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "Single.just(coverImage.c…erRes.VALID\n            }");
        return map;
    }

    @NotNull
    public static final Single<ValidationTextColor> isDetailImagesValidate(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Single<ValidationTextColor> map = Single.just(postViewData.getDetailImages()).map(new PostViewDataExtensionKt$isDetailImagesValidate$1(Intrinsics.areEqual((Object) postViewData.getPostType(), (Object) "CLOTHES") ? 1 : 2));
        Intrinsics.checkExpressionValueIsNotNull(map, "Single.just(detailImages…Color.VALID\n            }");
        return map;
    }

    @NotNull
    public static final ArrayList<CreatePostImage> convertDetailImage(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        ArrayList<CreatePostImage> arrayList = new ArrayList<>();
        for (PostDetailImage postDetailImage : postViewData.getDetailImages()) {
            CreatePostImage createPostImage = new CreatePostImage(postDetailImage.getDetailImagePath());
            createPostImage.setDescription(postDetailImage.getDetailImageDescription());
            createPostImage.setId(postDetailImage.getDetailImageId());
            arrayList.add(createPostImage);
        }
        return arrayList;
    }

    public static final int detailImageString(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        String str = "CLOTHES";
        if (postViewData.getDetailImages().size() >= (Intrinsics.areEqual((Object) postViewData.getPostType(), (Object) str) ? 1 : 2)) {
            return C0016R$string.detail_insert_pic1_desc2;
        }
        String postType = postViewData.getPostType();
        return (postType.hashCode() == 1584551976 && postType.equals(str)) ? C0016R$string.detail_insert_hint_clothe : C0016R$string.detail_insert_hint_bag;
    }

    @NotNull
    public static final Single<ValidationStyleTag> addFittsStyleTag(@NotNull PostViewData postViewData, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, StringSet.tag);
        Single<ValidationStyleTag> map = Single.just(postViewData.getStyleTags()).map(new PostViewDataExtensionKt$addFittsStyleTag$1(postViewData, str));
        Intrinsics.checkExpressionValueIsNotNull(map, "Single.just(styleTags)\n …          }\n            }");
        return map;
    }

    @NotNull
    public static final Single<ValidationTextColor> isStyleTagValidate(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Single<ValidationTextColor> map = Single.just(postViewData.getStyleTags()).map(PostViewDataExtensionKt$isStyleTagValidate$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "Single.just(styleTags)\n …Color.VALID\n            }");
        return map;
    }

    public static final boolean isNotPostEmpty(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        if (!(postViewData.getTitle().length() > 0)) {
            if (!(postViewData.getCoverImage().getCoverImagePath().length() > 0) && !(!postViewData.getDetailImages().isEmpty()) && postViewData.getStarScore() <= 0.0f) {
                if (!(postViewData.getAboutFit().length() > 0)) {
                    if (!(postViewData.getAboutSize().length() > 0)) {
                        if (!(postViewData.getShopUrl().length() > 0)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static final void addDetailImages(@NotNull PostViewData postViewData, @NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(postViewData, "receiver$0");
        Intrinsics.checkParameterIsNotNull(arrayList, "images");
        for (String postDetailImage : arrayList) {
            postViewData.getDetailImages().add(new PostDetailImage(null, postDetailImage, null));
        }
    }
}
