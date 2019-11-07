package kr.co.popone.fitts.feature.ncommerce;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.type.NetworkState;

final class PointHistoryFragment$onViewCreated$7<T> implements Observer<NetworkState> {
    final /* synthetic */ PointHistoryFragment this$0;

    PointHistoryFragment$onViewCreated$7(PointHistoryFragment pointHistoryFragment) {
        this.this$0 = pointHistoryFragment;
    }

    public final void onChanged(NetworkState networkState) {
        this.this$0.pointHistoryAdapter.updateNetworkState(networkState);
    }
}
