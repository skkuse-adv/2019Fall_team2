package kr.co.popone.fitts.feature.order;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Pair;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.feature.reward.AddressWebViewActivity;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.anko.internals.AnkoInternals;

final class OrderActivity$onCreate$25 implements OnClickListener {
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$25(OrderActivity orderActivity) {
        this.this$0 = orderActivity;
    }

    public final void onClick(View view) {
        OrderActivity orderActivity = this.this$0;
        ActivityExtensionKt.activityStartForResult(orderActivity, AnkoInternals.createIntent(orderActivity, AddressWebViewActivity.class, new Pair[0]), ActivityAnimationType.SLIDE_UP, 101);
    }
}
