package kr.co.popone.fitts.feature.post.upload.crop;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;

final class PostImageDetailAdapter$imageRemoveButtonListener$1 implements OnClickListener {
    final /* synthetic */ PostImageDetailAdapter this$0;

    PostImageDetailAdapter$imageRemoveButtonListener$1(PostImageDetailAdapter postImageDetailAdapter) {
        this.this$0 = postImageDetailAdapter;
    }

    public final void onClick(View view) {
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        Object tag = view.getTag();
        if (tag != null) {
            int intValue = ((Integer) tag).intValue();
            Object obj = this.this$0.delegate.getPostImages().get(intValue);
            Intrinsics.checkExpressionValueIsNotNull(obj, "delegate.postImages[position]");
            this.this$0.delegate.onRemoveClick((CreatePostImage) obj, intValue);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
