package kr.co.popone.fitts.paging.post;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class FollowingPostDataSource$loadAfter$2<T> implements Consumer<Throwable> {
    final /* synthetic */ FollowingPostDataSource this$0;

    FollowingPostDataSource$loadAfter$2(FollowingPostDataSource followingPostDataSource) {
        this.this$0 = followingPostDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
