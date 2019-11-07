package kr.co.popone.fitts.feature.order.detail;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.event.OrderEvent$CreatePostOrderVariant;
import kr.co.popone.fitts.feature.post.PostType;

final class OrderDetailActivity$startCreatePostActivity$$inlined$run$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OrderEvent$CreatePostOrderVariant $this_run;
    final /* synthetic */ OrderDetailActivity this$0;

    OrderDetailActivity$startCreatePostActivity$$inlined$run$lambda$1(OrderEvent$CreatePostOrderVariant orderEvent$CreatePostOrderVariant, OrderDetailActivity orderDetailActivity) {
        this.$this_run = orderEvent$CreatePostOrderVariant;
        this.this$0 = orderDetailActivity;
        super(0);
    }

    public final void invoke() {
        PostType postType = this.$this_run.getPostType();
        if (postType != null) {
            this.this$0.getViewModel().startCreatePost(this.this$0, postType, this.$this_run.getPostVariantViewData(), "order");
        }
    }
}
