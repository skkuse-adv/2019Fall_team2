package kr.co.popone.fitts.paging.post;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class FollowingPostDataSource$loadAfter$1<T> implements Consumer<ArrayList<Post>> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ FollowingPostDataSource this$0;

    FollowingPostDataSource$loadAfter$1(FollowingPostDataSource followingPostDataSource, LoadCallback loadCallback) {
        this.this$0 = followingPostDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(ArrayList<Post> arrayList) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        this.$callback.onResult(arrayList);
    }
}
