package kr.co.popone.fitts.feature.store;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.store.SubCategoryAdapter.SubCategoryHolder;
import kr.co.popone.fitts.model.category.SubCategoryViewData;

final class SubCategoryAdapter$SubCategoryHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ SubCategoryHolder this$0;

    SubCategoryAdapter$SubCategoryHolder$bindTo$$inlined$with$lambda$1(SubCategoryHolder subCategoryHolder, SubCategoryViewData subCategoryViewData, int i) {
        this.this$0 = subCategoryHolder;
        this.$position$inlined = i;
    }

    public final void onClick(View view) {
        this.this$0.this$0.delegate.onCategoryClicked(this.$position$inlined);
    }
}
