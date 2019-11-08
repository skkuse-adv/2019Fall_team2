package kr.co.popone.fitts.feature.coupon;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class UsedCouponHistoryFragment$onViewCreated$2 extends OnScrollListener {
    final /* synthetic */ UsedCouponHistoryFragment this$0;

    UsedCouponHistoryFragment$onViewCreated$2(UsedCouponHistoryFragment usedCouponHistoryFragment) {
        this.this$0 = usedCouponHistoryFragment;
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
            if (childCount + i3 >= itemCount && this.this$0.usedCouponHistoryRequest == null && this.this$0.hasMoreUsedCouponHistory) {
                this.this$0.loadUsedCouponHistory(false);
            }
        }
    }
}
