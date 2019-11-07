package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.store.bookmark.ShopBookmarkActivity;

final class MeFragment$initClickListener$10 implements OnClickListener {
    final /* synthetic */ MeFragment this$0;

    MeFragment$initClickListener$10(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void onClick(View view) {
        ShopBookmarkActivity.Companion.start(this.this$0.getContext());
        this.this$0.getEventTracker$app_productionFittsRelease().customLogTapBookmarkList();
    }
}
