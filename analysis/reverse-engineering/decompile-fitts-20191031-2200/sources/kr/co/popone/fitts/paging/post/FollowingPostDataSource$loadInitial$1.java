package kr.co.popone.fitts.paging.post;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class FollowingPostDataSource$loadInitial$1<T> implements Consumer<ArrayList<Post>> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ FollowingPostDataSource this$0;

    FollowingPostDataSource$loadInitial$1(FollowingPostDataSource followingPostDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = followingPostDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(ArrayList<Post> arrayList) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        this.$callback.onResult(arrayList);
    }
}
