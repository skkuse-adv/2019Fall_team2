package kr.co.popone.fitts.viewmodel.search.result;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource.Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.log.ActionLogAPI.DefaultImpls;
import kr.co.popone.fitts.model.search.IntergratedSearchViewData;
import kr.co.popone.fitts.model.search.SearchResult;
import kr.co.popone.fitts.paging.search.FittieResultDataSource;
import kr.co.popone.fitts.paging.search.FittieResultSourceFactory;
import kr.co.popone.fitts.paging.search.PostSearchResultDataSource;
import kr.co.popone.fitts.paging.search.PostSearchResultSourceFactory;
import kr.co.popone.fitts.paging.search.ProductResultDataSource;
import kr.co.popone.fitts.paging.search.ProductResultSourceFactory;
import kr.co.popone.fitts.repository.SearchRepository;
import kr.co.popone.fitts.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;

public final class SearchResultViewModel extends BaseViewModel {
    private final ActionLogAPI actionLog;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    private final MutableLiveData<FittieResultDataSource> fittieDataSource;
    private final LiveData<NetworkState> fittieNetworkState;
    private final LiveData<PagedList<SearchResult>> fittieResultLiveData;
    private final LiveData<Boolean> isEmptyFitties;
    private final LiveData<Boolean> isEmptyPosts;
    private final LiveData<Boolean> isEmptyProducts;
    private final String keyword;
    private final LiveData<NetworkState> postNetworkState;
    private final LiveData<PagedList<SearchResult>> postResultLiveData;
    private final MutableLiveData<PostSearchResultDataSource> postsDataSource;
    private final LiveData<NetworkState> productNetworkState;
    private final MutableLiveData<ProductResultDataSource> productsDataSource;
    private final LiveData<PagedList<SearchResult>> productsResultLiveData;
    private final SearchRepository searchRepository;
    /* access modifiers changed from: private */
    public final MutableLiveData<NetworkState> unifiedNetworkState = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<IntergratedSearchViewData> unifiedResultLiveData = new MutableLiveData<>();
    private final UserRepository userRepository;

    public SearchResultViewModel(@NotNull String str, @NotNull SearchRepository searchRepository2, @NotNull UserRepository userRepository2, @NotNull EventTracker eventTracker2, @NotNull ActionLogAPI actionLogAPI) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        Intrinsics.checkParameterIsNotNull(searchRepository2, "searchRepository");
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(actionLogAPI, "actionLog");
        this.keyword = str;
        this.searchRepository = searchRepository2;
        this.userRepository = userRepository2;
        this.eventTracker = eventTracker2;
        this.actionLog = actionLogAPI;
        getUnifiedSearchList();
        PostSearchResultSourceFactory postSearchResultSourceFactory = new PostSearchResultSourceFactory(this.keyword, this.searchRepository);
        this.postsDataSource = postSearchResultSourceFactory.getPostsResultSource();
        LiveData<NetworkState> switchMap = Transformations.switchMap(postSearchResultSourceFactory.getPostsResultSource(), SearchResultViewModel$1$1.INSTANCE);
        String str2 = "Transformations.switchMa…ateLiveData\n            }";
        Intrinsics.checkExpressionValueIsNotNull(switchMap, str2);
        this.postNetworkState = switchMap;
        LiveData<Boolean> switchMap2 = Transformations.switchMap(postSearchResultSourceFactory.getPostsResultSource(), SearchResultViewModel$1$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…istLiveData\n            }");
        this.isEmptyPosts = switchMap2;
        LiveData<PagedList<SearchResult>> build = new LivePagedListBuilder((Factory<Key, Value>) postSearchResultSourceFactory, getPageConfig()).build();
        String str3 = "LivePagedListBuilder(it, getPageConfig()).build()";
        Intrinsics.checkExpressionValueIsNotNull(build, str3);
        this.postResultLiveData = build;
        ProductResultSourceFactory productResultSourceFactory = new ProductResultSourceFactory(this.keyword, this.searchRepository);
        this.productsDataSource = productResultSourceFactory.getProductsDataSource();
        LiveData<NetworkState> switchMap3 = Transformations.switchMap(productResultSourceFactory.getProductsDataSource(), SearchResultViewModel$2$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap3, str2);
        this.productNetworkState = switchMap3;
        LiveData<Boolean> switchMap4 = Transformations.switchMap(productResultSourceFactory.getProductsDataSource(), SearchResultViewModel$2$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap4, "Transformations.switchMa…ptyProducts\n            }");
        this.isEmptyProducts = switchMap4;
        LiveData<PagedList<SearchResult>> build2 = new LivePagedListBuilder((Factory<Key, Value>) productResultSourceFactory, getPageConfig()).build();
        Intrinsics.checkExpressionValueIsNotNull(build2, str3);
        this.productsResultLiveData = build2;
        FittieResultSourceFactory fittieResultSourceFactory = new FittieResultSourceFactory(this.keyword, this.searchRepository);
        this.fittieDataSource = fittieResultSourceFactory.getFittieDataSource();
        LiveData<NetworkState> switchMap5 = Transformations.switchMap(fittieResultSourceFactory.getFittieDataSource(), SearchResultViewModel$3$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap5, str2);
        this.fittieNetworkState = switchMap5;
        LiveData<Boolean> switchMap6 = Transformations.switchMap(fittieResultSourceFactory.getFittieDataSource(), SearchResultViewModel$3$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap6, "Transformations.switchMa…ce) { it.isEmptyFitties }");
        this.isEmptyFitties = switchMap6;
        LiveData<PagedList<SearchResult>> build3 = new LivePagedListBuilder((Factory<Key, Value>) fittieResultSourceFactory, getPageConfig()).build();
        Intrinsics.checkExpressionValueIsNotNull(build3, str3);
        this.fittieResultLiveData = build3;
        Logger.d("SearchResultViewModel::INIT", new Object[0]);
    }

    public final void refreshPostSearchResult() {
        PostSearchResultDataSource postSearchResultDataSource = (PostSearchResultDataSource) this.postsDataSource.getValue();
        if (postSearchResultDataSource != null) {
            postSearchResultDataSource.invalidate();
        }
    }

    public final void refreshProductSearchResult() {
        ProductResultDataSource productResultDataSource = (ProductResultDataSource) this.productsDataSource.getValue();
        if (productResultDataSource != null) {
            productResultDataSource.invalidate();
        }
    }

    public final void refreshFittieSearchResult() {
        FittieResultDataSource fittieResultDataSource = (FittieResultDataSource) this.fittieDataSource.getValue();
        if (fittieResultDataSource != null) {
            fittieResultDataSource.invalidate();
        }
    }

    private final Config getPageConfig() {
        return new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(30).setPrefetchDistance(3).setPageSize(30).build();
    }

    @SuppressLint({"CheckResult"})
    private final void getUnifiedSearchList() {
        this.unifiedNetworkState.setValue(NetworkState.Companion.getINIT_LOADING());
        this.searchRepository.getUnifiedSearchList(this.keyword).subscribe(new SearchResultViewModel$getUnifiedSearchList$1(this), new SearchResultViewModel$getUnifiedSearchList$2(this));
    }

    public final void updateFollowState(long j, boolean z) {
        if (z) {
            CompositeDisposable compositeDisposable = this.disposables;
            Disposable subscribe = this.userRepository.deleteUserFollow(j).subscribe(new SearchResultViewModel$updateFollowState$1(this, j), SearchResultViewModel$updateFollowState$2.INSTANCE);
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "userRepository.deleteUse…{\n\n                    })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        CompositeDisposable compositeDisposable2 = this.disposables;
        Disposable subscribe2 = this.userRepository.putUserFollow(j).subscribe(new SearchResultViewModel$updateFollowState$3(this, j), SearchResultViewModel$updateFollowState$4.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "userRepository.putUserFo…{\n\n                    })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    /* access modifiers changed from: private */
    public final void sendFollowUpdateEvent(long j, boolean z) {
        Message message = new Message();
        message.what = 2;
        Bundle bundle = new Bundle();
        bundle.putLong("userId", j);
        bundle.putBoolean("isFollowed", z);
        message.setData(bundle);
        EventBus.getDefault().post(message, AppManager.FOLLOW_MESSAGE);
    }

    public final void logTapSearchTab(@Nullable Integer num) {
        String searchTabName = getSearchTabName(num);
        if (searchTabName != null) {
            this.eventTracker.customLogTapSearchTab(searchTabName);
        }
    }

    private final String getSearchTabName(Integer num) {
        if (num != null && num.intValue() == 1) {
            return "post";
        }
        if (num != null && num.intValue() == 2) {
            return "product";
        }
        if (num != null && num.intValue() == 3) {
            return "fittie";
        }
        return null;
    }

    public final void logTapShopList() {
        this.eventTracker.customLogTapShopList("search");
    }

    public final void leaveActionLog(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = DefaultImpls.collectActionLog$default(this.actionLog, str, "Search", null, null, null, 28, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SearchResultViewModel$leaveActionLog$1(str), new SearchResultViewModel$leaveActionLog$2(str));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "actionLog.collectActionL…arch\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final MutableLiveData<IntergratedSearchViewData> getUnifiedResult() {
        return this.unifiedResultLiveData;
    }

    @NotNull
    public final LiveData<PagedList<SearchResult>> getPostResult() {
        return this.postResultLiveData;
    }

    @NotNull
    public final LiveData<PagedList<SearchResult>> getProductResult() {
        return this.productsResultLiveData;
    }

    @NotNull
    public final LiveData<PagedList<SearchResult>> getFittieResult() {
        return this.fittieResultLiveData;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getUnifiedNetworkState() {
        return this.unifiedNetworkState;
    }

    @NotNull
    public final LiveData<NetworkState> getPostNetworkState() {
        return this.postNetworkState;
    }

    @NotNull
    public final LiveData<NetworkState> getProductNetworkState() {
        return this.productNetworkState;
    }

    @NotNull
    public final LiveData<NetworkState> getFittieNetworkState() {
        return this.fittieNetworkState;
    }

    @NotNull
    public final LiveData<Boolean> isEmptyPosts() {
        return this.isEmptyPosts;
    }

    @NotNull
    public final LiveData<Boolean> isEmptyProducts() {
        return this.isEmptyProducts;
    }

    @NotNull
    public final LiveData<Boolean> isEmptyFitties() {
        return this.isEmptyFitties;
    }
}
