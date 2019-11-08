package kr.co.popone.fitts.feature.home;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.cart.CartActivity;

final class HomeFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ HomeFragment this$0;

    HomeFragment$onViewCreated$2(HomeFragment homeFragment) {
        this.this$0 = homeFragment;
    }

    public final void onClick(View view) {
        CartActivity.Companion.start(this.this$0.getContext(), "home");
    }
}
