package kr.co.popone.fitts.feature.search;

import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.search.SearchHistoryView.Delegate;

public final class ShopSearchActivity$onCreate$3 implements Delegate {
    final /* synthetic */ ShopSearchActivity this$0;

    ShopSearchActivity$onCreate$3(ShopSearchActivity shopSearchActivity) {
        this.this$0 = shopSearchActivity;
    }

    public void onItemSelected(int i) {
        ((SearchBar) this.this$0._$_findCachedViewById(C0010R$id.searchBar)).goSearch((String) this.this$0.getSearchHistoryRepository$app_productionFittsRelease().getHistory().get(i));
    }

    public void onDeleteClicked() {
        this.this$0.getSearchHistoryRepository$app_productionFittsRelease().setHistory(CollectionsKt__CollectionsKt.emptyList());
        this.this$0.getSearchHistoryRepository$app_productionFittsRelease().saveHistory();
        ((SearchHistoryView) this.this$0._$_findCachedViewById(C0010R$id.searchHistoryView)).setItems(this.this$0.getSearchHistoryRepository$app_productionFittsRelease().getHistory());
    }
}
