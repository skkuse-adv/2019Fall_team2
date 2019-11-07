package kr.co.popone.fitts.feature.search;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ShopSearchActivity$onCreate$5 extends OnScrollListener {
    final /* synthetic */ ShopSearchActivity this$0;

    ShopSearchActivity$onCreate$5(ShopSearchActivity shopSearchActivity) {
        this.this$0 = shopSearchActivity;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        int i3;
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            int childCount = layoutManager.getChildCount();
            int itemCount = layoutManager.getItemCount();
            if (layoutManager instanceof LinearLayoutManager) {
                i3 = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            } else if (layoutManager instanceof GridLayoutManager) {
                i3 = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
            } else {
                throw new IllegalAccessException();
            }
            if (childCount + i3 >= itemCount && this.this$0.resultShopsDisposable == null && this.this$0.canLoadMore) {
                this.this$0.searchShop(false);
            }
        }
    }
}
