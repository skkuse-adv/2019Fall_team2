package kr.co.popone.fitts.feature.home;

import com.google.android.material.appbar.AppBarLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.anko.support.v4.__ViewPager_OnPageChangeListener;
import org.jetbrains.annotations.NotNull;

final class HomeFragment$onViewCreated$$inlined$apply$lambda$1 extends Lambda implements Function1<__ViewPager_OnPageChangeListener, Unit> {
    final /* synthetic */ HomeFragment this$0;

    HomeFragment$onViewCreated$$inlined$apply$lambda$1(HomeFragment homeFragment) {
        this.this$0 = homeFragment;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((__ViewPager_OnPageChangeListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull __ViewPager_OnPageChangeListener __viewpager_onpagechangelistener) {
        Intrinsics.checkParameterIsNotNull(__viewpager_onpagechangelistener, "receiver$0");
        __viewpager_onpagechangelistener.onPageSelected((Function1<? super Integer, Unit>) new Function1<Integer, Unit>(this) {
            final /* synthetic */ HomeFragment$onViewCreated$$inlined$apply$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                ((AppBarLayout) this.this$0.this$0._$_findCachedViewById(C0010R$id.app_bar)).setExpanded(true);
                this.this$0.this$0.getViewModel().leaveHomeTabLog(i);
            }
        });
    }
}
