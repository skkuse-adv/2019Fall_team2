package kr.co.popone.fitts.feature.ncommerce;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.NCommerceEvent$NCommercePostClickEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class PointRevenueTopThreeAdapter$RevenueTopThreeHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Post $post$inlined;

    PointRevenueTopThreeAdapter$RevenueTopThreeHolder$bindTo$$inlined$with$lambda$1(Post post, int i) {
        this.$post$inlined = post;
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(new NCommerceEvent$NCommercePostClickEvent(this.$post$inlined));
    }
}
