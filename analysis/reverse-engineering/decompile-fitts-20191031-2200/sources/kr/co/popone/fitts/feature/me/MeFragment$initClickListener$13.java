package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.cart.CartActivity;

final class MeFragment$initClickListener$13 implements OnClickListener {
    final /* synthetic */ MeFragment this$0;

    MeFragment$initClickListener$13(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void onClick(View view) {
        CartActivity.Companion.start(this.this$0.getContext(), "my");
    }
}
