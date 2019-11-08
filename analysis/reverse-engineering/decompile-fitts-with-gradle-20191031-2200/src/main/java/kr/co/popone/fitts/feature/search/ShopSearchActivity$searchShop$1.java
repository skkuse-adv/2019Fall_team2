package kr.co.popone.fitts.feature.search;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import io.reactivex.functions.BiConsumer;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult;

final class ShopSearchActivity$searchShop$1<T1, T2> implements BiConsumer<SearchShopResult, Throwable> {
    final /* synthetic */ ShopSearchActivity this$0;

    ShopSearchActivity$searchShop$1(ShopSearchActivity shopSearchActivity) {
        this.this$0 = shopSearchActivity;
    }

    public final void accept(SearchShopResult searchShopResult, Throwable th) {
        this.this$0.resultShopsDisposable = null;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        boolean z = false;
        swipeRefreshLayout.setRefreshing(false);
        if (searchShopResult != null) {
            ShopSearchActivity shopSearchActivity = this.this$0;
            shopSearchActivity.resultShops = CollectionsKt___CollectionsKt.plus((Collection<? extends T>) shopSearchActivity.resultShops, (Iterable<? extends T>) searchShopResult.getResults());
            this.this$0.resultShopsTotalCount = searchShopResult.getTotalCount();
            this.this$0.reloadShopResults();
            if (this.this$0.resultShops.isEmpty()) {
                this.this$0.showEmptyResultView();
            }
            ShopSearchActivity shopSearchActivity2 = this.this$0;
            if (searchShopResult.getResults().size() >= 20) {
                z = true;
            }
            shopSearchActivity2.canLoadMore = z;
        }
    }
}
