package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.feature.post.upload.preview.PostPreviewActivity;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.model.post.PostViewData.PostMode;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class CreatePostActivity$onCreate$7<T> implements Consumer<Unit> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$7(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Unit unit) {
        this.this$0.getViewModel().createPostButtonClicked(new Function3<PostMode, CreatePost, PostVariantViewData, Unit>(this) {
            final /* synthetic */ CreatePostActivity$onCreate$7 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((PostMode) obj, (CreatePost) obj2, (PostVariantViewData) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PostMode postMode, @NotNull CreatePost createPost, @Nullable PostVariantViewData postVariantViewData) {
                Intrinsics.checkParameterIsNotNull(postMode, "mode");
                Intrinsics.checkParameterIsNotNull(createPost, "data");
                String str = "create_post_data";
                if (postMode == PostMode.CREATE) {
                    CreatePostActivity createPostActivity = this.this$0.this$0;
                    ContextExtensionKt.activityStart(createPostActivity, AnkoInternals.createIntent(createPostActivity, PostPreviewActivity.class, new Pair[]{TuplesKt.to(str, createPost), TuplesKt.to(PostPreviewActivity.Companion.getKEY_VARIANT_INFO(), postVariantViewData)}), ActivityAnimationType.SLIDE_RTOL);
                } else if (postMode == PostMode.MODIFY) {
                    CreatePostActivity createPostActivity2 = this.this$0.this$0;
                    createPostActivity2.activityStartForResult(AnkoInternals.createIntent(createPostActivity2, PostPreviewActivity.class, new Pair[]{TuplesKt.to(str, createPost), TuplesKt.to("modify_post", Boolean.valueOf(true))}), 101, C0001R$anim.slide_right, C0001R$anim.fade_out);
                }
            }
        });
    }
}
