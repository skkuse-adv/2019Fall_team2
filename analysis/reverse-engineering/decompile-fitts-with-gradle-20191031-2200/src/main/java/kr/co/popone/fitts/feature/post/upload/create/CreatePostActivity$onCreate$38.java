package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.RatingBar;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CreatePostActivity$onCreate$38<T> implements Consumer<Float> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$38(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Float f) {
        RatingBar ratingBar = (RatingBar) this.this$0._$_findCachedViewById(C0010R$id.post_rating);
        Intrinsics.checkExpressionValueIsNotNull(ratingBar, "post_rating");
        Intrinsics.checkExpressionValueIsNotNull(f, "it");
        ratingBar.setRating(f.floatValue());
    }
}
