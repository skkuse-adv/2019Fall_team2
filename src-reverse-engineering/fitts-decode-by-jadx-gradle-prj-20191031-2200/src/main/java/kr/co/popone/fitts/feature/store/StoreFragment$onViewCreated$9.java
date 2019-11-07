package kr.co.popone.fitts.feature.store;

import androidx.viewpager.widget.ViewPager;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;

final class StoreFragment$onViewCreated$9<T> implements Consumer<MainEvent$MainTabChangeEvent> {
    final /* synthetic */ StoreFragment this$0;

    StoreFragment$onViewCreated$9(StoreFragment storeFragment) {
        this.this$0 = storeFragment;
    }

    public final void accept(MainEvent$MainTabChangeEvent mainEvent$MainTabChangeEvent) {
        ViewPager viewPager = (ViewPager) this.this$0._$_findCachedViewById(C0010R$id.storeViewPager);
        Intrinsics.checkExpressionValueIsNotNull(viewPager, "storeViewPager");
        viewPager.setCurrentItem(0);
    }
}
