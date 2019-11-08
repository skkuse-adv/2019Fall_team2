package kr.co.popone.fitts.feature.search;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.C0010R$id;

final class ShopWebViewActivity$onCreate$5<T> implements Consumer<Long> {
    final /* synthetic */ ShopWebViewActivity this$0;

    ShopWebViewActivity$onCreate$5(ShopWebViewActivity shopWebViewActivity) {
        this.this$0 = shopWebViewActivity;
    }

    public final void accept(Long l) {
        this.this$0.linkCopyGuideTimerRequest = null;
        StringBuilder sb = new StringBuilder();
        sb.append("timer triggered on thread(");
        sb.append(Thread.currentThread());
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        ((ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.linkCopyGuideLayout)).animate().alpha(0.0f);
    }
}
