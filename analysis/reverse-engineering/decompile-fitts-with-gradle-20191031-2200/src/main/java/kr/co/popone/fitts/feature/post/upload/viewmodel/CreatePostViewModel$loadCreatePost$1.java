package kr.co.popone.fitts.feature.post.upload.viewmodel;

import android.content.Intent;
import com.google.gson.Gson;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivity;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.model.post.PostViewData;
import kr.co.popone.fitts.model.post.PostViewData.PostMode;
import kr.co.popone.fitts.model.post.PostViewDataExtensionKt;
import org.jetbrains.annotations.NotNull;

final class CreatePostViewModel$loadCreatePost$1<T> implements SingleOnSubscribe<T> {
    final /* synthetic */ Intent $intent;
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$loadCreatePost$1(CreatePostViewModel createPostViewModel, Intent intent) {
        this.this$0 = createPostViewModel;
        this.$intent = intent;
    }

    public final void subscribe(@NotNull SingleEmitter<PostViewData> singleEmitter) {
        String str = "it";
        Intrinsics.checkParameterIsNotNull(singleEmitter, str);
        String stringExtra = this.$intent.getStringExtra("post_type");
        PostVariantViewData postVariantViewData = (PostVariantViewData) this.$intent.getParcelableExtra(CreatePostActivity.PARAMETER_ORDER_LINEITEM_VARIANT);
        if (this.this$0.getSessionManager().isPostTemporary(postVariantViewData != null ? Long.valueOf(postVariantViewData.getVariantId()) : null)) {
            if (postVariantViewData == null) {
                CreatePost createPost = (CreatePost) new Gson().fromJson(this.this$0.getSessionManager().getGetPostTemporary(), CreatePost.class);
                PostViewData postViewData = this.this$0.getPostViewData();
                Intrinsics.checkExpressionValueIsNotNull(createPost, str);
                PostViewDataExtensionKt.convertPostModel(postViewData, createPost);
            } else {
                CreatePost createPost2 = (CreatePost) new Gson().fromJson(this.this$0.getSessionManager().getPostableProductTemporary(postVariantViewData.getVariantId()), CreatePost.class);
                PostViewData postViewData2 = this.this$0.getPostViewData();
                Intrinsics.checkExpressionValueIsNotNull(createPost2, str);
                PostViewDataExtensionKt.convertPostModel(postViewData2, createPost2);
            }
        }
        this.this$0.getPostViewData().setPostMode(PostMode.CREATE);
        PostViewData postViewData3 = this.this$0.getPostViewData();
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "type");
        if (stringExtra != null) {
            String upperCase = stringExtra.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            postViewData3.setPostType(upperCase);
            this.this$0.getPostViewData().setPostVariantViewData(postVariantViewData);
            singleEmitter.onSuccess(this.this$0.getPostViewData());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
