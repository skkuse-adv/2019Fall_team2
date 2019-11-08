package kr.co.popone.fitts.viewmodel;

import android.os.Bundle;
import android.os.Message;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.model.collection.CollectionAPI;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.collection.MixedCollection;
import kr.co.popone.fitts.model.collection.MixedCollection.ToolbarState;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;

public final class MixedCollectionViewModel$ViewModel implements MixedCollectionViewModel$Input, MixedCollectionViewModel$Output {
    @NotNull
    private final PublishSubject<Unit> activityFinish;
    @NotNull
    private final CollectionAPI collectionAPI;
    @NotNull
    private final PublishSubject<ArrayList<CollectionEntry>> collectionAddedList;
    @NotNull
    private final PublishSubject<CollectionDetailResponse> collectionDetail;
    @Nullable
    private Disposable collectionDetailDisposable;
    @NotNull
    private final PublishSubject<ArrayList<CollectionEntry>> collectionList;
    @Nullable
    private Disposable collectionListDisposable;
    @NotNull
    private final FittsCommerceRepository commerceRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final PublishSubject<Throwable> errorOccur;
    @NotNull
    private final EventTracker eventTracker;
    @NotNull
    private final PublishSubject<User> follow;
    @Nullable
    private Disposable followDisposable;
    private boolean hasMore;
    @NotNull
    private final PublishSubject<Integer> index;
    @NotNull
    private final MixedCollectionViewModel$Input input = this;
    @NotNull
    private final BehaviorSubject<Boolean> isLoading;
    @NotNull
    private final MixedCollection mixedCollection;
    @NotNull
    private final MixedCollectionViewModel$Output output = this;
    @NotNull
    private final PublishSubject<ToolbarState> toolbarTag;
    @Nullable
    private Disposable unfollowDisposable;
    @NotNull
    private final UserAPI userAPI;

    public MixedCollectionViewModel$ViewModel(long j, int i, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull CollectionAPI collectionAPI2, @NotNull EventTracker eventTracker2, @NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(collectionAPI2, "collectionAPI");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(userAPI2, "userAPI");
        this.commerceRepository = fittsCommerceRepository;
        this.collectionAPI = collectionAPI2;
        this.eventTracker = eventTracker2;
        this.userAPI = userAPI2;
        PublishSubject<CollectionDetailResponse> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<Co…llectionDetailResponse>()");
        this.collectionDetail = create;
        PublishSubject<ArrayList<CollectionEntry>> create2 = PublishSubject.create();
        String str = "PublishSubject.create<Ar…onAPI.CollectionEntry>>()";
        Intrinsics.checkExpressionValueIsNotNull(create2, str);
        this.collectionList = create2;
        PublishSubject<ArrayList<CollectionEntry>> create3 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create3, str);
        this.collectionAddedList = create3;
        PublishSubject<Unit> create4 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create4, "PublishSubject.create<Unit>()");
        this.activityFinish = create4;
        PublishSubject<ToolbarState> create5 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create5, "PublishSubject.create<Mi…ollection.ToolbarState>()");
        this.toolbarTag = create5;
        PublishSubject<Throwable> create6 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create6, "PublishSubject.create<Throwable>()");
        this.errorOccur = create6;
        PublishSubject<Integer> create7 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create7, "PublishSubject.create<Int>()");
        this.index = create7;
        PublishSubject<User> create8 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create8, "PublishSubject.create<User>()");
        this.follow = create8;
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(Boolean.valueOf(false));
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(false)");
        this.isLoading = createDefault;
        this.mixedCollection = new MixedCollection(j, i);
    }

    @NotNull
    public final FittsCommerceRepository getCommerceRepository() {
        return this.commerceRepository;
    }

    @NotNull
    public final CollectionAPI getCollectionAPI() {
        return this.collectionAPI;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        return this.eventTracker;
    }

    @NotNull
    public final UserAPI getUserAPI() {
        return this.userAPI;
    }

    @NotNull
    public final MixedCollectionViewModel$Input getInput() {
        return this.input;
    }

    @NotNull
    public final MixedCollectionViewModel$Output getOutput() {
        return this.output;
    }

    @NotNull
    public final MixedCollection getMixedCollection() {
        return this.mixedCollection;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    @Nullable
    public final Disposable getCollectionDetailDisposable() {
        return this.collectionDetailDisposable;
    }

    public final void setCollectionDetailDisposable(@Nullable Disposable disposable) {
        this.collectionDetailDisposable = disposable;
    }

    @Nullable
    public final Disposable getCollectionListDisposable() {
        return this.collectionListDisposable;
    }

    public final void setCollectionListDisposable(@Nullable Disposable disposable) {
        this.collectionListDisposable = disposable;
    }

    @Nullable
    public final Disposable getUnfollowDisposable() {
        return this.unfollowDisposable;
    }

    public final void setUnfollowDisposable(@Nullable Disposable disposable) {
        this.unfollowDisposable = disposable;
    }

    @Nullable
    public final Disposable getFollowDisposable() {
        return this.followDisposable;
    }

    public final void setFollowDisposable(@Nullable Disposable disposable) {
        this.followDisposable = disposable;
    }

    @NotNull
    public final PublishSubject<CollectionDetailResponse> getCollectionDetail() {
        return this.collectionDetail;
    }

    @NotNull
    public final PublishSubject<ArrayList<CollectionEntry>> getCollectionList() {
        return this.collectionList;
    }

    @NotNull
    public final PublishSubject<ArrayList<CollectionEntry>> getCollectionAddedList() {
        return this.collectionAddedList;
    }

    @NotNull
    public final PublishSubject<Unit> getActivityFinish() {
        return this.activityFinish;
    }

    @NotNull
    public final PublishSubject<ToolbarState> getToolbarTag() {
        return this.toolbarTag;
    }

    @NotNull
    public final PublishSubject<Throwable> getErrorOccur() {
        return this.errorOccur;
    }

    @NotNull
    public final PublishSubject<Integer> getIndex() {
        return this.index;
    }

    @NotNull
    public final PublishSubject<User> getFollow() {
        return this.follow;
    }

    @NotNull
    public final BehaviorSubject<Boolean> isLoading() {
        return this.isLoading;
    }

    public void requestMixedCollectionDetail() {
        Disposable disposable = this.collectionDetailDisposable;
        if (disposable == null) {
            if (disposable != null) {
                disposable.dispose();
            }
            this.collectionDetailDisposable = this.collectionAPI.requestCollectionDetail(this.mixedCollection.getPostId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new MixedCollectionViewModel$ViewModel$requestMixedCollectionDetail$1<Object,Object>(this));
        }
    }

    public void requestMixedCollectionList(boolean z) {
        this.isLoading.onNext(Boolean.valueOf(true));
        Disposable disposable = this.collectionListDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        if (z) {
            this.hasMore = false;
            this.mixedCollection.clearMixedCollectionEntries();
        }
        this.collectionListDisposable = this.collectionAPI.requestCollectionList(this.mixedCollection.getPostId(), this.mixedCollection.getLastItemId(), Integer.valueOf(20)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new MixedCollectionViewModel$ViewModel$requestMixedCollectionList$1<Object,Object>(this, z));
    }

    public void backButtonClicked() {
        this.activityFinish.onNext(Unit.INSTANCE);
    }

    public void profileClicked(int i) {
        this.index.onNext(Integer.valueOf(i));
    }

    public void bannerClicked(int i) {
        this.index.onNext(Integer.valueOf(i));
    }

    public void nestedScrollViewScrolled(int i) {
        this.toolbarTag.onNext(this.mixedCollection.getToolbarState(i));
    }

    public void recyclerViewScrolled(int i, int i2, int i3) {
        if (i + i3 >= i2 && this.collectionListDisposable == null && this.hasMore) {
            requestMixedCollectionList(false);
        }
    }

    public void followButtonClicked(int i) {
        User user = this.mixedCollection.getUser(i);
        if (user != null) {
            String str = "collection";
            String str2 = "from";
            if (user.isFollowing()) {
                requestUnFollow(i);
                this.eventTracker.logCustom("Unfollow", new CustomAttributes().put(str2, str));
            } else if (Intrinsics.areEqual((Object) user.getStatus(), (Object) "deactivated")) {
                this.mixedCollection.updateFollowingUser(i, false);
            } else {
                requestFollow(i);
                this.eventTracker.logCustom("Follow", new CustomAttributes().put(str2, str));
            }
        }
    }

    private final void requestFollow(int i) {
        if (this.followDisposable == null) {
            Long userId = this.mixedCollection.getUserId(i);
            if (userId != null) {
                this.followDisposable = this.userAPI.putFollow(userId.longValue()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new MixedCollectionViewModel$ViewModel$requestFollow$$inlined$let$lambda$1<Object,Object>(this, i));
            }
        }
    }

    private final void requestUnFollow(int i) {
        if (this.unfollowDisposable == null) {
            Long userId = this.mixedCollection.getUserId(i);
            if (userId != null) {
                this.unfollowDisposable = this.userAPI.deleteFollow(userId.longValue()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new MixedCollectionViewModel$ViewModel$requestUnFollow$$inlined$let$lambda$1<Object,Object>(this, i));
            }
        }
    }

    public void addLikeProductClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.addWishProduct(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new MixedCollectionViewModel$ViewModel$addLikeProductClick$1(j), MixedCollectionViewModel$ViewModel$addLikeProductClick$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.addWi…\")\n                    })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public void removeLikeProductClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.deleteWishProduct(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new MixedCollectionViewModel$ViewModel$removeLikeProductClick$1(j), MixedCollectionViewModel$ViewModel$removeLikeProductClick$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.delet…{\n\n                    })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public Observable<Unit> finishActivity() {
        return this.activityFinish;
    }

    @NotNull
    public Observable<ToolbarState> toolbarTagUpdated() {
        Observable<ToolbarState> filter = this.toolbarTag.filter(MixedCollectionViewModel$ViewModel$toolbarTagUpdated$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(filter, "toolbarTag\n             …NOT\n                    }");
        return filter;
    }

    @NotNull
    public Observable<ArrayList<CollectionEntry>> collectionListUpdated() {
        return this.collectionList;
    }

    @NotNull
    public Observable<ArrayList<CollectionEntry>> collectionListAdded() {
        return this.collectionAddedList;
    }

    @NotNull
    public Observable<CollectionDetailResponse> collectionDetailUpdated() {
        return this.collectionDetail;
    }

    @NotNull
    public Observable<Long> showRoomUpdated() {
        Observable<Long> map = this.index.map(new MixedCollectionViewModel$ViewModel$showRoomUpdated$1(this)).filter(MixedCollectionViewModel$ViewModel$showRoomUpdated$2.INSTANCE).map(MixedCollectionViewModel$ViewModel$showRoomUpdated$3.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "index\n                  …     .map { it.user?.id }");
        return map;
    }

    @NotNull
    public Observable<String> bannerLinkUpdated() {
        Observable<String> map = this.index.map(new MixedCollectionViewModel$ViewModel$bannerLinkUpdated$1(this)).filter(MixedCollectionViewModel$ViewModel$bannerLinkUpdated$2.INSTANCE).map(MixedCollectionViewModel$ViewModel$bannerLinkUpdated$3.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "index\n                  …     .map { it.link_url }");
        return map;
    }

    @NotNull
    public Observable<Throwable> onErrorOccured() {
        return this.errorOccur;
    }

    @NotNull
    public Observable<Boolean> loadingViewUpdated() {
        return this.isLoading;
    }

    public final void onDestroy() {
        Disposable disposable = this.collectionDetailDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.collectionListDisposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.unfollowDisposable;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        Disposable disposable4 = this.followDisposable;
        if (disposable4 != null) {
            disposable4.dispose();
        }
        this.collectionDetailDisposable = null;
        this.collectionListDisposable = null;
        this.unfollowDisposable = null;
        this.followDisposable = null;
    }

    public final void notifyFollowResult(@NotNull User user, boolean z) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        Message message = new Message();
        message.what = 2;
        Bundle bundle = new Bundle();
        bundle.putLong("userId", user.getId());
        bundle.putBoolean("isFollowed", z);
        message.setData(bundle);
        EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
        EventBus.getDefault().post(message, AppManager.MY_MESSAGE);
        EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
        EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
        EventBus.getDefault().post(message, AppManager.FOLLOW_MESSAGE);
    }
}
