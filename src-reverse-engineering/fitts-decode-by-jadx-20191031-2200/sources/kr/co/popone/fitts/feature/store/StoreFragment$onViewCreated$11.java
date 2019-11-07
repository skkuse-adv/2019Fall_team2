package kr.co.popone.fitts.feature.store;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class StoreFragment$onViewCreated$11<T> implements Observer<Integer> {
    final /* synthetic */ StoreFragment this$0;

    StoreFragment$onViewCreated$11(StoreFragment storeFragment) {
        this.this$0 = storeFragment;
    }

    public final void onChanged(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.recommendationNewBadge);
            String str = "recommendationNewBadge";
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            textView.setText(String.valueOf(intValue));
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.recommendationNewBadge);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            textView2.setVisibility(intValue < 1 ? 8 : 0);
        }
    }
}
