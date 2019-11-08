package kr.co.popone.fitts.feature.me;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class MeFragment$getBadgeCount$2<T> implements Consumer<Integer> {
    final /* synthetic */ MeFragment this$0;

    MeFragment$getBadgeCount$2(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void accept(Integer num) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.recommendationNewBadge);
        String str = "recommendationNewBadge";
        Intrinsics.checkExpressionValueIsNotNull(textView, str);
        textView.setText(String.valueOf(num.intValue()));
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.recommendationNewBadge);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        textView2.setVisibility(Intrinsics.compare(num.intValue(), 1) < 0 ? 8 : 0);
    }
}
