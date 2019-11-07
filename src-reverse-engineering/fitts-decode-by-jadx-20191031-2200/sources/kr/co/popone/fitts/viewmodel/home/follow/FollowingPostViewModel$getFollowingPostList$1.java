package kr.co.popone.fitts.viewmodel.home.follow;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.post.FollowingPostDataSource;
import org.jetbrains.annotations.NotNull;

final class FollowingPostViewModel$getFollowingPostList$1<I, O> implements Function<X, LiveData<Y>> {
    public static final FollowingPostViewModel$getFollowingPostList$1 INSTANCE = new FollowingPostViewModel$getFollowingPostList$1();

    FollowingPostViewModel$getFollowingPostList$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(FollowingPostDataSource followingPostDataSource) {
        return followingPostDataSource.getNetworkStateLiveData();
    }
}
