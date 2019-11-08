package kr.co.popone.fitts.feature.home;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.main.DrawerMenuListner;

final class HomeFragment$onViewCreated$3 implements OnClickListener {
    final /* synthetic */ HomeFragment this$0;

    HomeFragment$onViewCreated$3(HomeFragment homeFragment) {
        this.this$0 = homeFragment;
    }

    public final void onClick(View view) {
        DrawerMenuListner drawerMenuListner = this.this$0.getDrawerMenuListner();
        if (drawerMenuListner != null) {
            drawerMenuListner.onMenuClicked();
        }
        this.this$0.getViewModel().logTapSlideMenu();
    }
}
