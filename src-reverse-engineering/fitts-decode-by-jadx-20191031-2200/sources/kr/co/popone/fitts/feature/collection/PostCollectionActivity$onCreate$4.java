package kr.co.popone.fitts.feature.collection;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class PostCollectionActivity$onCreate$4 extends OnScrollListener {
    final /* synthetic */ PostCollectionActivity this$0;

    PostCollectionActivity$onCreate$4(PostCollectionActivity postCollectionActivity) {
        this.this$0 = postCollectionActivity;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.getChildCount() + linearLayoutManager.findFirstVisibleItemPosition() >= linearLayoutManager.getItemCount() && this.this$0.collectionItemsRequest == null && this.this$0.canLoadMore) {
                this.this$0.loadListData(false);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }
}
