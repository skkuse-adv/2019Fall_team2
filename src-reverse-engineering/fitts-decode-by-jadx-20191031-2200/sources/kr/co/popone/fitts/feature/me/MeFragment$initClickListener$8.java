package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.feature.order.orderlist.OrderListActivity;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.anko.internals.AnkoInternals;

final class MeFragment$initClickListener$8 implements OnClickListener {
    final /* synthetic */ MeFragment this$0;

    MeFragment$initClickListener$8(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void onClick(View view) {
        MeFragment meFragment = this.this$0;
        Pair[] pairArr = new Pair[0];
        FragmentActivity requireActivity = meFragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        FragmentExtensionKt.activityStart(meFragment, AnkoInternals.createIntent(requireActivity, OrderListActivity.class, pairArr), ActivityAnimationType.SLIDE_RTOL);
    }
}
