package kr.co.popone.fitts.viewmodel.home.follow;

import android.os.Bundle;
import android.os.Message;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource.Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.paging.post.FollowingPostSourceFactory;
import kr.co.popone.fitts.repository.PostRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;

public final class FollowingPostViewModel extends BaseViewModel {
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    @Nullable
    private LiveData<NetworkState> networkState;
    @Nullable
    private LiveData<PagedList<Post>> postListLiveData;
    private final PostRepository postRepository;
    private final SessionManager sessionManager;
    private final UserAPI userAPI;

    public FollowingPostViewModel(@NotNull UserAPI userAPI2, @NotNull PostRepository postRepository2, @NotNull EventTracker eventTracker2, @NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "userAPI");
        Intrinsics.checkParameterIsNotNull(postRepository2, "postRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        this.userAPI = userAPI2;
        this.postRepository = postRepository2;
        this.eventTracker = eventTracker2;
        this.sessionManager = sessionManager2;
        this.eventTracker.customLogFollowingFeed();
    }

    @Nullable
    public final LiveData<PagedList<Post>> getPostListLiveData() {
        return this.postListLiveData;
    }

    public final void setPostListLiveData(@Nullable LiveData<PagedList<Post>> liveData) {
        this.postListLiveData = liveData;
    }

    @Nullable
    public final LiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final void setNetworkState(@Nullable LiveData<NetworkState> liveData) {
        this.networkState = liveData;
    }

    public final void getFollowingPostList() {
        FollowingPostSourceFactory followingPostSourceFactory = new FollowingPostSourceFactory(this.postRepository);
        this.networkState = Transformations.switchMap(followingPostSourceFactory.getFollowingPostLiveData(), FollowingPostViewModel$getFollowingPostList$1.INSTANCE);
        this.postListLiveData = new LivePagedListBuilder((Factory<Key, Value>) followingPostSourceFactory, getPagedListConfig()).build();
    }

    public final long getUserId() {
        return this.sessionManager.getUserID();
    }

    public final void updateLikeState(long j, boolean z) {
        if (z) {
            CompositeDisposable compositeDisposable = this.disposables;
            Disposable subscribe = this.postRepository.deletePostLike(j).subscribe(new FollowingPostViewModel$updateLikeState$1(this, j), new FollowingPostViewModel$updateLikeState$2(this));
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "postRepository.deletePos…it\n                    })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        CompositeDisposable compositeDisposable2 = this.disposables;
        Disposable subscribe2 = this.postRepository.putPostLike(j).subscribe(new FollowingPostViewModel$updateLikeState$3(this, j), new FollowingPostViewModel$updateLikeState$4(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "postRepository.putPostLi…it\n                    })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    public final void updateFollowState(long j, boolean z) {
        if (z) {
            CompositeDisposable compositeDisposable = this.disposables;
            Disposable subscribe = this.userAPI.deleteFollow(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new FollowingPostViewModel$updateFollowState$1(this, j), new FollowingPostViewModel$updateFollowState$2(this));
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "userAPI.deleteFollow(use…it\n                    })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        CompositeDisposable compositeDisposable2 = this.disposables;
        Disposable subscribe2 = this.userAPI.putFollow(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new FollowingPostViewModel$updateFollowState$3(this, j), new FollowingPostViewModel$updateFollowState$4(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "userAPI.putFollow(userId…it\n                    })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    private final Config getPagedListConfig() {
        Config build = new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(12).setPageSize(12).setPrefetchDistance(3).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "PagedList.Config.Builder…                 .build()");
        return build;
    }

    /* access modifiers changed from: private */
    public final void postFollowStateChangeEvent(long j, boolean z) {
        Message message = new Message();
        message.what = 2;
        Bundle bundle = new Bundle();
        bundle.putLong("userId", j);
        bundle.putBoolean("isFollowed", z);
        message.setData(bundle);
        EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
        EventBus.getDefault().post(message, AppManager.MY_MESSAGE);
        EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
        EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
        EventBus.getDefault().post(message, AppManager.FOLLOW_MESSAGE);
    }

    /* access modifiers changed from: private */
    public final void postLikeStateChangeEvent(long j, boolean z) {
        Message message = new Message();
        message.what = 3;
        Bundle bundle = new Bundle();
        bundle.putLong("postId", j);
        bundle.putBoolean("isLiked", z);
        message.setData(bundle);
        EventBus.getDefault().post(message, AppManager.MY_MESSAGE);
        EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
        EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
        EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
