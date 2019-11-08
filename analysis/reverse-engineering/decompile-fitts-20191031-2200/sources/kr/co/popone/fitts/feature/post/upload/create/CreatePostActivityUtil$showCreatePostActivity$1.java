package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Activity;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.user.UserAPI.PostableResponse;

final class CreatePostActivityUtil$showCreatePostActivity$1<T> implements Consumer<PostableResponse> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function0 $dismiss;
    final /* synthetic */ String $from;
    final /* synthetic */ boolean $isInitCall;
    final /* synthetic */ CreatePostActivityUtil this$0;

    CreatePostActivityUtil$showCreatePostActivity$1(CreatePostActivityUtil createPostActivityUtil, Activity activity, boolean z, String str, Function0 function0) {
        this.this$0 = createPostActivityUtil;
        this.$activity = activity;
        this.$isInitCall = z;
        this.$from = str;
        this.$dismiss = function0;
    }

    public final void accept(PostableResponse postableResponse) {
        CreatePostActivityUtil createPostActivityUtil = this.this$0;
        Activity activity = this.$activity;
        boolean z = this.$isInitCall;
        Intrinsics.checkExpressionValueIsNotNull(postableResponse, "it");
        createPostActivityUtil.checkPostableUser(activity, z, postableResponse, new Function0<Unit>(this) {
            final /* synthetic */ CreatePostActivityUtil$showCreatePostActivity$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                CreatePostActivityUtil$showCreatePostActivity$1 createPostActivityUtil$showCreatePostActivity$1 = this.this$0;
                createPostActivityUtil$showCreatePostActivity$1.this$0.createPost(createPostActivityUtil$showCreatePostActivity$1.$activity, createPostActivityUtil$showCreatePostActivity$1.$isInitCall, new Function0<Unit>(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        CreatePostActivityUtil$showCreatePostActivity$1 createPostActivityUtil$showCreatePostActivity$1 = this.this$0.this$0;
                        createPostActivityUtil$showCreatePostActivity$1.this$0.showPostTypeSelectDialog(createPostActivityUtil$showCreatePostActivity$1.$activity, createPostActivityUtil$showCreatePostActivity$1.$from, createPostActivityUtil$showCreatePostActivity$1.$dismiss);
                    }
                });
            }
        });
    }
}
