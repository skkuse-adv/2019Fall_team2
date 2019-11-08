package kr.co.popone.fitts.feature.ncommerce;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.type.NetworkState;

final class PointUsageHistoryFragment$onViewCreated$5<T> implements Observer<NetworkState> {
    final /* synthetic */ PointUsageHistoryFragment this$0;

    PointUsageHistoryFragment$onViewCreated$5(PointUsageHistoryFragment pointUsageHistoryFragment) {
        this.this$0 = pointUsageHistoryFragment;
    }

    public final void onChanged(NetworkState networkState) {
        this.this$0.pointUsageHistoryAdapter.updateNetworkState(networkState);
    }
}
