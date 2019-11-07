package kr.co.popone.fitts.feature.main;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.main.MainTabBar.Tab;

final class MainActivity$updateTabSelectedWithDelay$1<T> implements Consumer<Long> {
    final /* synthetic */ int $tab;
    final /* synthetic */ MainActivity this$0;

    MainActivity$updateTabSelectedWithDelay$1(MainActivity mainActivity, int i) {
        this.this$0 = mainActivity;
        this.$tab = i;
    }

    public final void accept(Long l) {
        SwipeViewPager swipeViewPager = (SwipeViewPager) this.this$0._$_findCachedViewById(C0010R$id.viewpager_main);
        Intrinsics.checkExpressionValueIsNotNull(swipeViewPager, "viewpager_main");
        swipeViewPager.setCurrentItem(this.$tab);
        int i = this.$tab;
        if (i == 0) {
            ((MainTabBar) this.this$0._$_findCachedViewById(C0010R$id.mainTabBar)).setSelectedTab(Tab.Home);
        } else if (i == 1) {
            ((MainTabBar) this.this$0._$_findCachedViewById(C0010R$id.mainTabBar)).setSelectedTab(Tab.Store);
        } else if (i == 2) {
            ((MainTabBar) this.this$0._$_findCachedViewById(C0010R$id.mainTabBar)).setSelectedTab(Tab.Notification);
        } else if (i == 3) {
            ((MainTabBar) this.this$0._$_findCachedViewById(C0010R$id.mainTabBar)).setSelectedTab(Tab.My);
        }
    }
}
