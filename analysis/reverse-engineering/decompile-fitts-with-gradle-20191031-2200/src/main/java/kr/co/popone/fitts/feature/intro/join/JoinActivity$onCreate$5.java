package kr.co.popone.fitts.feature.intro.join;

import android.os.Handler;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ScrollView;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$5 implements OnFocusChangeListener {
    final /* synthetic */ Handler $handler;
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$5(JoinActivity joinActivity, Handler handler) {
        this.this$0 = joinActivity;
        this.$handler = handler;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.$handler.postDelayed(new Runnable(this) {
                final /* synthetic */ JoinActivity$onCreate$5 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    ((ScrollView) this.this$0.this$0._$_findCachedViewById(C0010R$id.scrollView1)).smoothScrollTo(0, 400);
                }
            }, 100);
        }
    }
}
