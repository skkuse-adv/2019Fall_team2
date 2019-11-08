package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.feature.post.upload.guide.PostGuideActivity;
import kr.co.popone.fitts.feature.post.upload.guide.PostGuideActivity.Parameters;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$5<T> implements Consumer<Unit> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$5(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Unit unit) {
        this.this$0.getViewModel().helpButtonClicked(new Function1<String, Unit>(this) {
            final /* synthetic */ CreatePostActivity$onCreate$5 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "it");
                CreatePostActivity createPostActivity = this.this$0.this$0;
                ContextExtensionKt.activityStart(createPostActivity, AnkoInternals.createIntent(createPostActivity, PostGuideActivity.class, new Pair[]{TuplesKt.to("parameters", new Parameters(str))}), ActivityAnimationType.SLIDE_RTOL);
            }
        });
    }
}
