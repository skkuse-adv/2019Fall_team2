package kr.co.popone.fitts.feature.banner;

import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.banner.BannerActivity.WhenMappings;

final class BannerActivity$onCreate$10<T> implements Observer<NetworkState> {
    final /* synthetic */ BannerActivity this$0;

    BannerActivity$onCreate$10(BannerActivity bannerActivity) {
        this.this$0 = bannerActivity;
    }

    public final void onChanged(NetworkState networkState) {
        Status status = networkState != null ? networkState.getStatus() : null;
        if (status != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            String str = "refreshLayout";
            if (i == 1 || i == 2) {
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
                swipeRefreshLayout.setRefreshing(true);
            } else if (i == 3 || i == 4) {
                SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
                swipeRefreshLayout2.setRefreshing(false);
            } else if (i == 5) {
                ActivityExtensionKt.handleError(this.this$0, networkState.getMsg());
            }
        }
    }
}
