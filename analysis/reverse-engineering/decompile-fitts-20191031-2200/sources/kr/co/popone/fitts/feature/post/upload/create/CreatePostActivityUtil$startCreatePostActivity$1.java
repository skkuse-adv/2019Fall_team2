package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Activity;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.reactivex.functions.Consumer;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivity.Companion;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.model.user.UserAPI.PostableResponse;

final class CreatePostActivityUtil$startCreatePostActivity$1<T> implements Consumer<PostableResponse> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ PostType $postType;
    final /* synthetic */ PostVariantViewData $postVariantViewData;
    final /* synthetic */ CreatePostActivityUtil this$0;

    CreatePostActivityUtil$startCreatePostActivity$1(CreatePostActivityUtil createPostActivityUtil, Activity activity, PostType postType, PostVariantViewData postVariantViewData) {
        this.this$0 = createPostActivityUtil;
        this.$activity = activity;
        this.$postType = postType;
        this.$postVariantViewData = postVariantViewData;
    }

    public final void accept(PostableResponse postableResponse) {
        CreatePostActivityUtil createPostActivityUtil = this.this$0;
        Activity activity = this.$activity;
        Intrinsics.checkExpressionValueIsNotNull(postableResponse, "it");
        createPostActivityUtil.checkPostableUser(activity, false, postableResponse, new Function0<Unit>(this) {
            final /* synthetic */ CreatePostActivityUtil$startCreatePostActivity$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                CreatePostActivityUtil$startCreatePostActivity$1 createPostActivityUtil$startCreatePostActivity$1 = this.this$0;
                createPostActivityUtil$startCreatePostActivity$1.this$0.createPost(createPostActivityUtil$startCreatePostActivity$1.$activity, false, new Function0<Unit>(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        Companion companion = CreatePostActivity.Companion;
                        CreatePostActivityUtil$startCreatePostActivity$1 createPostActivityUtil$startCreatePostActivity$1 = this.this$0.this$0;
                        Activity activity = createPostActivityUtil$startCreatePostActivity$1.$activity;
                        String name = createPostActivityUtil$startCreatePostActivity$1.$postType.name();
                        if (name != null) {
                            String lowerCase = name.toLowerCase();
                            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
                            companion.startCreate(activity, lowerCase, AppSettingsData.STATUS_NEW, this.this$0.this$0.$postVariantViewData);
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                });
            }
        });
    }
}
