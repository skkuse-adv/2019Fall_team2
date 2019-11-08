package kr.co.popone.fitts.feature.main;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.feature.main.MainActivity.ShopTooltipState;

final class MainActivity$showStoreMarketingToolTip$1<T1, T2> implements BiConsumer<Long, Throwable> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$showStoreMarketingToolTip$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(Long l, Throwable th) {
        this.this$0.setShopTooltip(ShopTooltipState.DISMISS);
    }
}
