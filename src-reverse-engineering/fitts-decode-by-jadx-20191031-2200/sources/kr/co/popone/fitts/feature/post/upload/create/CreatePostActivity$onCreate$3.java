package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Activity;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.post.ImageFile;
import org.jetbrains.annotations.NotNull;
import photopicker.view.ImageSelectorActivity;
import photopicker.view.ImageSelectorActivity.Companion;

final class CreatePostActivity$onCreate$3<T> implements Consumer<Unit> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$3(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Unit unit) {
        this.this$0.getViewModel().postDetailImageInsertClicked(new Function1<String, Unit>(this) {
            final /* synthetic */ CreatePostActivity$onCreate$3 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "it");
                Companion companion = ImageSelectorActivity.Companion;
                companion.start((Activity) this.this$0.this$0, companion.getMODE_MULTIPLE(), false, ImageFile.Companion.getTYPE_POST(), ImageSelectorActivity.Companion.getTYPE_POST_DETAIL(), str);
            }
        });
    }
}
