package kr.co.popone.fitts.viewmodel.store.bridge.product;

import android.app.Activity;
import androidx.core.os.EnvironmentCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.service.log.ActionLog;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.store.ProductBridgeViewData;
import kr.co.popone.fitts.repository.PostRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductBridgeViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<Integer> _progressViewState = new MutableLiveData<>();
    private final CompositeDisposable disposable = new CompositeDisposable();
    private final EventTracker eventTracker;
    @Nullable
    private LiveData<NetworkState> networkState;
    private final PostRepository postRepository;
    @NotNull
    private MutableLiveData<ArrayList<ProductBridgeViewData>> productItemsLiveData = new MutableLiveData<>();
    private final FittsSchemeHandler schemeHandler;
    private final FittsServiceRepository serviceRepository;
    private final SessionManager sessionManager;

    public ProductBridgeViewModel(@NotNull FittsServiceRepository fittsServiceRepository, @NotNull PostRepository postRepository2, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker2, @NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(postRepository2, "postRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        this.serviceRepository = fittsServiceRepository;
        this.postRepository = postRepository2;
        this.schemeHandler = fittsSchemeHandler;
        this.eventTracker = eventTracker2;
        this.sessionManager = sessionManager2;
        logTapBridgeNotStore();
        this._progressViewState.setValue(Integer.valueOf(0));
    }

    @NotNull
    public final MutableLiveData<ArrayList<ProductBridgeViewData>> getProductItemsLiveData() {
        return this.productItemsLiveData;
    }

    public final void setProductItemsLiveData(@NotNull MutableLiveData<ArrayList<ProductBridgeViewData>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.productItemsLiveData = mutableLiveData;
    }

    @Nullable
    public final LiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final void setNetworkState(@Nullable LiveData<NetworkState> liveData) {
        this.networkState = liveData;
    }

    @NotNull
    public final MutableLiveData<Integer> updateProgressViewState() {
        return this._progressViewState;
    }

    public final void getRecommendProductList(long j) {
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = this.postRepository.getRecommendProduct(j, null, Integer.valueOf(15)).flatMap(new ProductBridgeViewModel$getRecommendProductList$1(this, j)).subscribe(new ProductBridgeViewModel$getRecommendProductList$2(this), new ProductBridgeViewModel$getRecommendProductList$3(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "postRepository.getRecomm…w.GONE\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final Single<ArrayList<ProductBridgeViewData>> getProductBridgeHeaderInfo(long j, ArrayList<Product> arrayList) {
        Single<ArrayList<ProductBridgeViewData>> map = this.postRepository.getProductDetailAndRecommend(j).map(new ProductBridgeViewModel$getProductBridgeHeaderInfo$1(arrayList));
        Intrinsics.checkExpressionValueIsNotNull(map, "postRepository.getProduc…  }\n                    }");
        return map;
    }

    private final void logTapBridgeNotStore() {
        this.eventTracker.customLogTapBridgeNotStore();
    }

    public final void logViewProductNotInStore(boolean z) {
        this.eventTracker.customLogViewProductNotStore(z ? "recognized" : EnvironmentCompat.MEDIA_UNKNOWN);
    }

    public final void handleScheme(@NotNull Activity activity, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (str != null) {
            this.schemeHandler.handleScheme(activity, str);
        }
    }

    public final void showProductFromPostActionLog(long j) {
        ActionLog actionLog = new ActionLog("product", "PostDetail", null, Long.valueOf(j), null, null, 32, null);
        DisposableKt.addTo(SubscribersKt.subscribeBy(this.serviceRepository.postFittsActionLog(actionLog), (Function1<? super Throwable, Unit>) ProductBridgeViewModel$showProductFromPostActionLog$1$1.INSTANCE, (Function0<Unit>) ProductBridgeViewModel$showProductFromPostActionLog$1$2.INSTANCE), this.disposable);
    }

    @NotNull
    public final SessionManager getSessionMannager() {
        return this.sessionManager;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposable.dispose();
        super.onCleared();
    }
}
