package kr.co.popone.fitts.feature.store.list;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.store.StoreInfo;

final class StoreListViewHolder$updateStoreListUi$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ StoreInfo $this_with;
    final /* synthetic */ StoreListViewHolder this$0;

    StoreListViewHolder$updateStoreListUi$$inlined$with$lambda$1(StoreInfo storeInfo, StoreListViewHolder storeListViewHolder) {
        this.$this_with = storeInfo;
        this.this$0 = storeListViewHolder;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onStoreClick(this.$this_with.getId());
    }
}
