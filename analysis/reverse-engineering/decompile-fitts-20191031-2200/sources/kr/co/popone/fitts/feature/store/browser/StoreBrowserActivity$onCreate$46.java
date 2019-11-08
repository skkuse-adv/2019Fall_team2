package kr.co.popone.fitts.feature.store.browser;

import android.view.View;
import android.view.View.OnClickListener;

final class StoreBrowserActivity$onCreate$46 implements OnClickListener {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$46(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onClick(View view) {
        this.this$0.getViewModel().showRelatedPostsDialog();
    }
}
