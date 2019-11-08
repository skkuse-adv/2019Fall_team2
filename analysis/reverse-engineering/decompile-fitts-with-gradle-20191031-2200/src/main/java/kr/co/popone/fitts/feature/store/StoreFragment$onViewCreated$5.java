package kr.co.popone.fitts.feature.store;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kr.co.popone.fitts.feature.search.view.SearchActivity;

final class StoreFragment$onViewCreated$5<T> implements Consumer<Unit> {
    final /* synthetic */ StoreFragment this$0;

    StoreFragment$onViewCreated$5(StoreFragment storeFragment) {
        this.this$0 = storeFragment;
    }

    public final void accept(Unit unit) {
        SearchActivity.Companion.start(this.this$0.getContext());
    }
}
