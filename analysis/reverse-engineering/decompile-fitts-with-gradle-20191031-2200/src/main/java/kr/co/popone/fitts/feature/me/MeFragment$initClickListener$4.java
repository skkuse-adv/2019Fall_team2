package kr.co.popone.fitts.feature.me;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.feature.ncommerce.NCommerceActivity;
import kr.co.popone.fitts.utils.ActivityAnimationType;

final class MeFragment$initClickListener$4 implements OnClickListener {
    final /* synthetic */ MeFragment this$0;

    MeFragment$initClickListener$4(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void onClick(View view) {
        MeFragment meFragment = this.this$0;
        FragmentExtensionKt.activityStart(meFragment, new Intent(meFragment.getContext(), NCommerceActivity.class), ActivityAnimationType.SLIDE_RTOL);
    }
}
