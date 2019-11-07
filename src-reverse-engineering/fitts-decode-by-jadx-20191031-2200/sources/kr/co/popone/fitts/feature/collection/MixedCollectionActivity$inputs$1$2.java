package kr.co.popone.fitts.feature.collection;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.viewmodel.MixedCollectionViewModel$Input;
import org.jetbrains.annotations.NotNull;

public final class MixedCollectionActivity$inputs$1$2 extends OnScrollListener {
    final /* synthetic */ MixedCollectionViewModel$Input $this_with;

    MixedCollectionActivity$inputs$1$2(MixedCollectionViewModel$Input mixedCollectionViewModel$Input) {
        this.$this_with = mixedCollectionViewModel$Input;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        this.$this_with.nestedScrollViewScrolled(i2);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.$this_with.recyclerViewScrolled(linearLayoutManager.getChildCount(), linearLayoutManager.getItemCount(), linearLayoutManager.findFirstVisibleItemPosition());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }
}
