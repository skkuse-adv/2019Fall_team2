package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.feature.search.adapter.PostResultAdapter;
import kr.co.popone.fitts.feature.search.view.PostSearchResultFragment.WhenMappings;

final class PostSearchResultFragment$onViewCreated$8<T> implements Observer<NetworkState> {
    final /* synthetic */ PostResultAdapter $postResultAdapter;
    final /* synthetic */ PostSearchResultFragment this$0;

    PostSearchResultFragment$onViewCreated$8(PostSearchResultFragment postSearchResultFragment, PostResultAdapter postResultAdapter) {
        this.this$0 = postSearchResultFragment;
        this.$postResultAdapter = postResultAdapter;
    }

    public final void onChanged(NetworkState networkState) {
        int i = WhenMappings.$EnumSwitchMapping$0[networkState.getStatus().ordinal()];
        String str = "refreshLayout";
        if (i == 1) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
            swipeRefreshLayout.setRefreshing(true);
        } else if (i == 2) {
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
            swipeRefreshLayout2.setRefreshing(false);
        } else if (i != 3) {
            this.$postResultAdapter.updateNetworkState(networkState);
        } else {
            this.$postResultAdapter.updateNetworkState(networkState);
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
