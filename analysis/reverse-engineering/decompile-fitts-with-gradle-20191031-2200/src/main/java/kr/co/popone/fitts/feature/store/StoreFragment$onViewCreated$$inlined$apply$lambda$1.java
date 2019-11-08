package kr.co.popone.fitts.feature.store;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.Tab;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.anko.support.v4.__ViewPager_OnPageChangeListener;
import org.jetbrains.annotations.NotNull;

final class StoreFragment$onViewCreated$$inlined$apply$lambda$1 extends Lambda implements Function1<__ViewPager_OnPageChangeListener, Unit> {
    final /* synthetic */ StoreFragment this$0;

    StoreFragment$onViewCreated$$inlined$apply$lambda$1(StoreFragment storeFragment) {
        this.this$0 = storeFragment;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((__ViewPager_OnPageChangeListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull __ViewPager_OnPageChangeListener __viewpager_onpagechangelistener) {
        Intrinsics.checkParameterIsNotNull(__viewpager_onpagechangelistener, "receiver$0");
        __viewpager_onpagechangelistener.onPageSelected((Function1<? super Integer, Unit>) new Function1<Integer, Unit>(this) {
            final /* synthetic */ StoreFragment$onViewCreated$$inlined$apply$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                ((AppBarLayout) this.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar)).setExpanded(true);
                this.this$0.this$0.getViewModel().onStoreTabSelected(i, "store");
                Tab tabAt = ((TabLayout) this.this$0.this$0._$_findCachedViewById(C0010R$id.storeTab)).getTabAt(i);
                if (tabAt != null) {
                    tabAt.select();
                }
            }
        });
    }
}
