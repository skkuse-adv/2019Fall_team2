package kr.co.popone.fitts.paging.post;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import com.facebook.internal.NativeProtocol;
import com.kakao.auth.StringSet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.repository.PostRepository;
import org.jetbrains.annotations.NotNull;

public final class FollowingPostDataSource extends ItemKeyedDataSource<Long, Post> {
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();
    private final PostRepository postRepository;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<Post> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public FollowingPostDataSource(@NotNull PostRepository postRepository2) {
        Intrinsics.checkParameterIsNotNull(postRepository2, "postRepository");
        this.postRepository = postRepository2;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<Post> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        String str = "following";
        this.postRepository.getPostsByType(str, str, (Long) loadInitialParams.requestedInitialKey, loadInitialParams.requestedLoadSize).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new FollowingPostDataSource$loadInitial$1(this, loadInitialCallback), new FollowingPostDataSource$loadInitial$2(this));
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<Post> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
        String str = "following";
        this.postRepository.getPostsByType(str, str, (Long) loadParams.key, loadParams.requestedLoadSize).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new FollowingPostDataSource$loadAfter$1(this, loadCallback), new FollowingPostDataSource$loadAfter$2(this));
    }

    @NotNull
    public Long getKey(@NotNull Post post) {
        Intrinsics.checkParameterIsNotNull(post, "item");
        return Long.valueOf(post.getId());
    }
}
