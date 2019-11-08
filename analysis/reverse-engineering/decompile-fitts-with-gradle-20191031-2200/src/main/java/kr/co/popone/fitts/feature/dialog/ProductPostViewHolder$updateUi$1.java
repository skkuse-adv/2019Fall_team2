package kr.co.popone.fitts.feature.dialog;

import android.view.View;
import android.view.View.OnClickListener;

final class ProductPostViewHolder$updateUi$1 implements OnClickListener {
    final /* synthetic */ long $postId;
    final /* synthetic */ ProductPostViewHolder this$0;

    ProductPostViewHolder$updateUi$1(ProductPostViewHolder productPostViewHolder, long j) {
        this.this$0 = productPostViewHolder;
        this.$postId = j;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onPostClick(this.$postId);
    }
}
