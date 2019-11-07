package kr.co.popone.fitts.feature.search;

import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.search.SearchBar.State;
import kr.co.popone.fitts.feature.search.ShopSearchActivity.WhenMappings;
import kr.co.popone.fitts.utils.ListUtilsKt;

final class ShopSearchActivity$onCreate$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ ShopSearchActivity this$0;

    ShopSearchActivity$onCreate$1(ShopSearchActivity shopSearchActivity) {
        this.this$0 = shopSearchActivity;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(State state) {
        if (state != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            String str = "searchResultView";
            String str2 = "searchHistoryView";
            boolean z = true;
            int i2 = 0;
            if (i == 1) {
                SearchHistoryView searchHistoryView = (SearchHistoryView) this.this$0._$_findCachedViewById(C0010R$id.searchHistoryView);
                Intrinsics.checkExpressionValueIsNotNull(searchHistoryView, str2);
                searchHistoryView.setVisibility(0);
                FrameLayout frameLayout = (FrameLayout) this.this$0._$_findCachedViewById(C0010R$id.searchResultView);
                Intrinsics.checkExpressionValueIsNotNull(frameLayout, str);
                frameLayout.setVisibility(8);
            } else if (i == 2) {
                SearchHistoryView searchHistoryView2 = (SearchHistoryView) this.this$0._$_findCachedViewById(C0010R$id.searchHistoryView);
                Intrinsics.checkExpressionValueIsNotNull(searchHistoryView2, str2);
                if (((SearchBar) this.this$0._$_findCachedViewById(C0010R$id.searchBar)).getText().length() <= 0) {
                    z = false;
                }
                if (z) {
                    i2 = 8;
                }
                searchHistoryView2.setVisibility(i2);
                FrameLayout frameLayout2 = (FrameLayout) this.this$0._$_findCachedViewById(C0010R$id.searchResultView);
                Intrinsics.checkExpressionValueIsNotNull(frameLayout2, str);
                frameLayout2.setVisibility(8);
            } else if (i == 3) {
                SearchHistoryView searchHistoryView3 = (SearchHistoryView) this.this$0._$_findCachedViewById(C0010R$id.searchHistoryView);
                Intrinsics.checkExpressionValueIsNotNull(searchHistoryView3, str2);
                searchHistoryView3.setVisibility(8);
                FrameLayout frameLayout3 = (FrameLayout) this.this$0._$_findCachedViewById(C0010R$id.searchResultView);
                Intrinsics.checkExpressionValueIsNotNull(frameLayout3, str);
                frameLayout3.setVisibility(0);
                this.this$0.getSearchHistoryRepository$app_productionFittsRelease().setHistory(ListUtilsKt.listUniqueInsert(this.this$0.getSearchHistoryRepository$app_productionFittsRelease().getHistory(), ((SearchBar) this.this$0._$_findCachedViewById(C0010R$id.searchBar)).getText().toString(), 10));
                this.this$0.getSearchHistoryRepository$app_productionFittsRelease().saveHistory();
                ((SearchHistoryView) this.this$0._$_findCachedViewById(C0010R$id.searchHistoryView)).setItems(this.this$0.getSearchHistoryRepository$app_productionFittsRelease().getHistory());
                this.this$0.searchShop(true);
            }
        }
    }
}
