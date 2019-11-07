package kr.co.popone.fitts.viewmodel.trend;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class TrendFeedViewModel$$special$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ TrendFeedViewModel this$0;

    TrendFeedViewModel$$special$$inlined$let$lambda$2(TrendFeedViewModel trendFeedViewModel) {
        this.this$0 = trendFeedViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0._networkState.setValue(NetworkState.Companion.error(th));
    }
}
