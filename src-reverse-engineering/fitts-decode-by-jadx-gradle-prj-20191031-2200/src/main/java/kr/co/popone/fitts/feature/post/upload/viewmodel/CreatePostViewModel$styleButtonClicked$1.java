package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationStyleTag;

final class CreatePostViewModel$styleButtonClicked$1<T> implements Consumer<ValidationStyleTag> {
    final /* synthetic */ int $index;
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$styleButtonClicked$1(CreatePostViewModel createPostViewModel, int i) {
        this.this$0 = createPostViewModel;
        this.$index = i;
    }

    public final void accept(ValidationStyleTag validationStyleTag) {
        if (validationStyleTag != ValidationStyleTag.NOTHING) {
            PublishSubject styleTagUpdated = this.this$0.getStyleTagUpdated();
            Integer valueOf = Integer.valueOf(this.$index);
            Boolean isChecked = validationStyleTag.isChecked();
            if (isChecked == null) {
                Intrinsics.throwNpe();
            }
            styleTagUpdated.onNext(new Pair(valueOf, isChecked));
        }
    }
}
