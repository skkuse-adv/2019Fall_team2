package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.feature.search.view.IntergratedSearchResultFragment.WhenMappings;

final class IntergratedSearchResultFragment$onViewCreated$5<T> implements Observer<NetworkState> {
    final /* synthetic */ IntergratedSearchResultFragment this$0;

    IntergratedSearchResultFragment$onViewCreated$5(IntergratedSearchResultFragment intergratedSearchResultFragment) {
        this.this$0 = intergratedSearchResultFragment;
    }

    public final void onChanged(NetworkState networkState) {
        int i = WhenMappings.$EnumSwitchMapping$0[networkState.getStatus().ordinal()];
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
            SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout3, str);
            swipeRefreshLayout3.setRefreshing(false);
            FragmentExtensionKt.handleError(this.this$0, networkState.getMsg());
            StringBuilder sb = new StringBuilder();
            sb.append("NetworkTest::InterSearchResult, ");
            sb.append(networkState);
            Logger.d(sb.toString(), new Object[0]);
        }
    }
}
