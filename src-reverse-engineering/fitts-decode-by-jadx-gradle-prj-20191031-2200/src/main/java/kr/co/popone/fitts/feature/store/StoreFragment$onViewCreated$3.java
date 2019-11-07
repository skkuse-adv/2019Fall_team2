package kr.co.popone.fitts.feature.store;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kr.co.popone.fitts.feature.main.DrawerMenuListner;

final class StoreFragment$onViewCreated$3<T> implements Consumer<Unit> {
    final /* synthetic */ StoreFragment this$0;

    StoreFragment$onViewCreated$3(StoreFragment storeFragment) {
        this.this$0 = storeFragment;
    }

    public final void accept(Unit unit) {
        DrawerMenuListner access$getDrawerMenuListner$p = this.this$0.drawerMenuListner;
        if (access$getDrawerMenuListner$p != null) {
            access$getDrawerMenuListner$p.onMenuClicked();
        }
        this.this$0.getViewModel().logTapSlideMenu();
    }
}
