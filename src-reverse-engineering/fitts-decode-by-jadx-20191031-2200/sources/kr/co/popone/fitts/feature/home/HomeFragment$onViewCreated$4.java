package kr.co.popone.fitts.feature.home;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.search.view.SearchActivity;

final class HomeFragment$onViewCreated$4 implements OnClickListener {
    final /* synthetic */ HomeFragment this$0;

    HomeFragment$onViewCreated$4(HomeFragment homeFragment) {
        this.this$0 = homeFragment;
    }

    public final void onClick(View view) {
        SearchActivity.Companion.start(this.this$0.getContext());
    }
}
