package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.web.SimpleWebActivity;

final class MeFragment$initClickListener$12 implements OnClickListener {
    final /* synthetic */ MeFragment this$0;

    MeFragment$initClickListener$12(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void onClick(View view) {
        SimpleWebActivity.Companion.start(this.this$0.getContext(), SimpleWebActivity.URL_SERVICE_CENTER, "스토어 고객센터");
    }
}
