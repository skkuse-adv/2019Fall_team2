package kr.co.popone.fitts.feature.search.holder;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.search.holder.StoreSearchResultViewHolder.Delegate;
import kr.co.popone.fitts.model.store.StoreInfo;

final class StoreSearchResultViewHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Delegate $delegate$inlined;
    final /* synthetic */ StoreInfo $storeInfo$inlined;

    StoreSearchResultViewHolder$bindTo$$inlined$with$lambda$1(StoreInfo storeInfo, Delegate delegate) {
        this.$storeInfo$inlined = storeInfo;
        this.$delegate$inlined = delegate;
    }

    public final void onClick(View view) {
        this.$delegate$inlined.onStoreClicked(this.$storeInfo$inlined.getId());
    }
}
