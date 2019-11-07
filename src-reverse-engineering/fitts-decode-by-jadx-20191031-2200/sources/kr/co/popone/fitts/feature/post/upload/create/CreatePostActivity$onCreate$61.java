package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CreatePostActivity$onCreate$61<T> implements Consumer<Boolean> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$61(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Boolean bool) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.post_image_insert_button);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "post_image_insert_button");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        int i = 8;
        linearLayout.setVisibility(bool.booleanValue() ? 8 : 0);
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.post_image_list);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "post_image_list");
        if (bool.booleanValue()) {
            i = 0;
        }
        recyclerView.setVisibility(i);
    }
}
