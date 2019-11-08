package kr.co.popone.fitts.feature.post.upload.viewmodel;

import android.content.Intent;
import com.google.gson.Gson;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivity;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.model.post.PostViewData;
import kr.co.popone.fitts.model.post.PostViewData.PostMode;
import kr.co.popone.fitts.model.post.PostViewDataExtensionKt;
import org.jetbrains.annotations.NotNull;

final class CreatePostViewModel$loadModifyPost$1<T> implements SingleOnSubscribe<T> {
    final /* synthetic */ Intent $intent;
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$loadModifyPost$1(CreatePostViewModel createPostViewModel, Intent intent) {
        this.this$0 = createPostViewModel;
        this.$intent = intent;
    }

    public final void subscribe(@NotNull final SingleEmitter<PostViewData> singleEmitter) {
        Intrinsics.checkParameterIsNotNull(singleEmitter, "emitter");
        final String stringExtra = this.$intent.getStringExtra("post_type");
        SessionManager sessionManager = this.this$0.getSessionManager();
        Intent intent = this.$intent;
        String str = CreatePostActivity.PARAMETER_MODIFY_POST_ID;
        String modifyPostTemporary = sessionManager.getModifyPostTemporary(intent.getLongExtra(str, 0));
        final PostVariantViewData postVariantViewData = (PostVariantViewData) this.$intent.getParcelableExtra(CreatePostActivity.PARAMETER_ORDER_LINEITEM_VARIANT);
        if (modifyPostTemporary.length() > 0) {
            CreatePost createPost = (CreatePost) new Gson().fromJson(modifyPostTemporary, CreatePost.class);
            PostViewData postViewData = this.this$0.getPostViewData();
            Intrinsics.checkExpressionValueIsNotNull(createPost, "it");
            PostViewDataExtensionKt.convertPostModel(postViewData, createPost);
            PostViewData postViewData2 = this.this$0.getPostViewData();
            Intrinsics.checkExpressionValueIsNotNull(stringExtra, "type");
            postViewData2.setPostType(stringExtra);
            this.this$0.getPostViewData().setPostMode(PostMode.MODIFY);
            this.this$0.getPostViewData().setPostVariantViewData(postVariantViewData);
            singleEmitter.onSuccess(this.this$0.getPostViewData());
            return;
        }
        this.this$0.getPostViewData().setPostId(this.$intent.getLongExtra(str, 0));
        Intrinsics.checkExpressionValueIsNotNull(this.this$0.getPostAPI().getPost(this.this$0.getPostViewData().getPostId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<Post, Throwable>(this) {
            final /* synthetic */ CreatePostViewModel$loadModifyPost$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Post post, Throwable th) {
                if (post != null) {
                    PostViewData postViewData = this.this$0.this$0.getPostViewData();
                    String str = stringExtra;
                    Intrinsics.checkExpressionValueIsNotNull(str, "type");
                    PostViewDataExtensionKt.convertPostModel(postViewData, str, post);
                    this.this$0.this$0.getPostViewData().setPostVariantViewData(postVariantViewData);
                    singleEmitter.onSuccess(this.this$0.this$0.getPostViewData());
                    return;
                }
                singleEmitter.onError(th);
            }
        }), "postAPI.getPost(postView…                        }");
    }
}
