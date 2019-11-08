package kr.co.popone.fitts.viewmodel.store.browser;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import com.orhanobut.logger.Logger;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.product.AffiliatesProduct;
import kr.co.popone.fitts.model.product.AffiliatesProductRestrictState;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;
import kr.co.popone.fitts.model.store.ProductOptionViewData;
import kr.co.popone.fitts.model.store.ProductVariantViewData;
import kr.co.popone.fitts.repository.CartRepository;
import kr.co.popone.fitts.repository.ProductRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreBrowserViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<AffiliatesProduct> affiliatesProductLiveData;
    @NotNull
    private final MutableLiveData<Boolean> buyButtonGoneLiveData;
    private final CartRepository cartRepository;
    @NotNull
    private final MutableLiveData<Throwable> checkOrderableExceptionLiveData;
    @NotNull
    private final MutableLiveData<Unit> closeLoadingView;
    /* access modifiers changed from: private */
    public final FittsCommerceRepository commerceRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    /* access modifiers changed from: private */
    public String domRemoveScript;
    @NotNull
    private final MutableLiveData<Throwable> errorMessageLiveData;
    private Long eventId;
    /* access modifiers changed from: private */
    public final EventTracker eventTracker;
    /* access modifiers changed from: private */
    public Function0<? extends List<Post>> getRelatedPosts;
    private Function0<Boolean> isFirstAffiliatesCheck;
    private final PublishSubject<Boolean> isPageLoadedSubject;
    @NotNull
    private final MutableLiveData<Boolean> isPageLoaedLiveData;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Boolean> isPartnerSubject;
    /* access modifiers changed from: private */
    public final BehaviorSubject<AffiliatesProduct> isProductSubject;
    @NotNull
    private final MutableLiveData<Boolean> isShowLoadingBottomView;
    @NotNull
    private final MutableLiveData<Boolean> isShowStoreStoreInfoBubble;
    @NotNull
    private final MutableLiveData<Boolean> isWishProductLiveData;
    /* access modifiers changed from: private */
    public Disposable loadingDisposable;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Boolean> loadingTimerSubject;
    @NotNull
    private final MutableLiveData<List<ProductVariantViewData>> optionsLiveData;
    @NotNull
    private final MutableLiveData<Pair<OrderInfoViewData, Long>> orderInfoLiveData;
    @NotNull
    private final MutableLiveData<OrderableOptionViewData> orderableOptionLiveData;
    /* access modifiers changed from: private */
    public Long postId;
    /* access modifiers changed from: private */
    public final ProductRepository productRepository;
    @NotNull
    private final MutableLiveData<List<Post>> relatedPostsLiveData;
    private final FittsSchemeHandler schemeHandler;
    @NotNull
    private final MutableLiveData<Unit> soldOutLiveData;
    @NotNull
    private final MutableLiveData<Pair<Boolean, String>> storeNameLiveData;
    private final StoreRepository storeRepository;
    @NotNull
    private final MutableLiveData<String> toastLiveData;
    @NotNull
    private final MutableLiveData<Throwable> totalPriceErrorLiveData;
    @NotNull
    private final MutableLiveData<Integer> totalPriceLiveData;
    private final PublishSubject<Integer> webPageProgressSubject;

    public static final /* synthetic */ Disposable access$getLoadingDisposable$p(StoreBrowserViewModel storeBrowserViewModel) {
        Disposable disposable = storeBrowserViewModel.loadingDisposable;
        if (disposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingDisposable");
        }
        return disposable;
    }

    public StoreBrowserViewModel(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull ProductRepository productRepository2, @NotNull StoreRepository storeRepository2, @NotNull CartRepository cartRepository2, @NotNull EventTracker eventTracker2, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(productRepository2, "productRepository");
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        Intrinsics.checkParameterIsNotNull(cartRepository2, "cartRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        this.commerceRepository = fittsCommerceRepository;
        this.productRepository = productRepository2;
        this.storeRepository = storeRepository2;
        this.cartRepository = cartRepository2;
        this.eventTracker = eventTracker2;
        this.schemeHandler = fittsSchemeHandler;
        BehaviorSubject<AffiliatesProduct> create = BehaviorSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "BehaviorSubject.create<AffiliatesProduct>()");
        this.isProductSubject = create;
        PublishSubject<Boolean> create2 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create2, "PublishSubject.create<Boolean>()");
        this.isPageLoadedSubject = create2;
        this.isPageLoaedLiveData = new MutableLiveData<>();
        this.affiliatesProductLiveData = new MutableLiveData<>();
        this.optionsLiveData = new MutableLiveData<>();
        this.orderableOptionLiveData = new MutableLiveData<>();
        this.totalPriceLiveData = new MutableLiveData<>();
        this.totalPriceErrorLiveData = new MutableLiveData<>();
        this.toastLiveData = new MutableLiveData<>();
        this.orderInfoLiveData = new MutableLiveData<>();
        this.isWishProductLiveData = new MutableLiveData<>();
        this.checkOrderableExceptionLiveData = new MutableLiveData<>();
        this.soldOutLiveData = new MutableLiveData<>();
        this.closeLoadingView = new MutableLiveData<>();
        this.isShowLoadingBottomView = new MutableLiveData<>();
        this.isShowStoreStoreInfoBubble = new MutableLiveData<>();
        this.storeNameLiveData = new MutableLiveData<>();
        this.buyButtonGoneLiveData = new MutableLiveData<>();
        PublishSubject<Integer> create3 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create3, "PublishSubject.create<Int>()");
        this.webPageProgressSubject = create3;
        Boolean valueOf = Boolean.valueOf(false);
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(valueOf);
        String str = "BehaviorSubject.createDefault(false)";
        Intrinsics.checkExpressionValueIsNotNull(createDefault, str);
        this.loadingTimerSubject = createDefault;
        BehaviorSubject<Boolean> createDefault2 = BehaviorSubject.createDefault(valueOf);
        Intrinsics.checkExpressionValueIsNotNull(createDefault2, str);
        this.isPartnerSubject = createDefault2;
        this.isFirstAffiliatesCheck = StoreBrowserViewModel$isFirstAffiliatesCheck$1.INSTANCE;
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = Observables.INSTANCE.combineLatest(this.isProductSubject, this.isPageLoadedSubject).filter(AnonymousClass1.INSTANCE).map(AnonymousClass2.INSTANCE).subscribe(new Consumer<AffiliatesProduct>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(AffiliatesProduct affiliatesProduct) {
                this.this$0.getAffiliatesProductLiveData().setValue(affiliatesProduct);
            }
        }, new Consumer<Throwable>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Throwable th) {
                this.this$0.getErrorLiveData().setValue(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "Observables.combineLates…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.disposables;
        Disposable subscribe2 = this.isProductSubject.flatMap(new Function<T, ObservableSource<? extends R>>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            @NotNull
            public final Observable<Boolean> apply(@NotNull AffiliatesProduct affiliatesProduct) {
                Intrinsics.checkParameterIsNotNull(affiliatesProduct, "it");
                FittsCommerceRepository access$getCommerceRepository$p = this.this$0.commerceRepository;
                Long productId = affiliatesProduct.getProductId();
                return access$getCommerceRepository$p.checkWishProductById(productId != null ? productId.longValue() : -1);
            }
        }).subscribe(new Consumer<Boolean>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Boolean bool) {
                this.this$0.isWishProductLiveData().setValue(bool);
            }
        }, new Consumer<Throwable>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Throwable th) {
                this.this$0.getErrorLiveData().setValue(th);
            }
        });
        String str2 = "isProductSubject\n       …e = it\n                })";
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, str2);
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.disposables;
        Disposable subscribe3 = this.isProductSubject.filter(AnonymousClass8.INSTANCE).flatMap(new Function<T, ObservableSource<? extends R>>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final Observable<List<ProductVariantViewData>> apply(@NotNull AffiliatesProduct affiliatesProduct) {
                Intrinsics.checkParameterIsNotNull(affiliatesProduct, "it");
                ProductRepository access$getProductRepository$p = this.this$0.productRepository;
                Long productId = affiliatesProduct.getProductId();
                return access$getProductRepository$p.getProductVariantOptions(productId != null ? productId.longValue() : -1);
            }
        }).filter(AnonymousClass10.INSTANCE).onErrorReturn(AnonymousClass11.INSTANCE).subscribe(new Consumer<List<? extends ProductVariantViewData>>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(List<ProductVariantViewData> list) {
                try {
                    boolean z = true;
                    if (list.size() == 1) {
                        String optionsGroupName = ((ProductVariantViewData) list.get(0)).getOptionsGroupName();
                        if (optionsGroupName != null) {
                            if (!StringsKt__StringsJVMKt.isBlank(optionsGroupName)) {
                                z = false;
                            }
                        }
                        if (z) {
                            List options = ((ProductVariantViewData) list.get(0)).getOptions();
                            if (options != null) {
                                ProductOptionViewData productOptionViewData = (ProductOptionViewData) options.get(0);
                                if (productOptionViewData != null) {
                                    StoreBrowserViewModel storeBrowserViewModel = this.this$0;
                                    Long optionId = productOptionViewData.getOptionId();
                                    if (optionId == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    long longValue = optionId.longValue();
                                    String optionValue = productOptionViewData.getOptionValue();
                                    if (optionValue == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    storeBrowserViewModel.getSigleItemVariantInfo(longValue, optionValue);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    this.this$0.getOptionsLiveData().setValue(list);
                } catch (IndexOutOfBoundsException e) {
                    this.this$0.getErrorLiveData().setValue(e);
                }
            }
        }, new Consumer<Throwable>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Throwable th) {
                this.this$0.getErrorLiveData().setValue(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe3, str2);
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.disposables;
        Disposable subscribe4 = Observables.INSTANCE.combineLatest(this.isPartnerSubject, this.isPageLoadedSubject).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new Consumer<Pair<? extends Boolean, ? extends Boolean>>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Pair<Boolean, Boolean> pair) {
                Object first = pair.getFirst();
                Intrinsics.checkExpressionValueIsNotNull(first, "it.first");
                if (((Boolean) first).booleanValue()) {
                    this.this$0.isShowLoadingBottomView().setValue(Boolean.valueOf(!((Boolean) pair.getSecond()).booleanValue()));
                } else {
                    this.this$0.isShowLoadingBottomView().setValue(Boolean.valueOf(false));
                }
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe4, "Observables.combineLates…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.disposables;
        Disposable subscribe5 = this.isProductSubject.subscribeOn(Schedulers.io()).filter(AnonymousClass15.INSTANCE).filter(AnonymousClass16.INSTANCE).flatMap(new Function<T, ObservableSource<? extends R>>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final Observable<List<Post>> apply(@NotNull AffiliatesProduct affiliatesProduct) {
                Intrinsics.checkParameterIsNotNull(affiliatesProduct, "it");
                ProductRepository access$getProductRepository$p = this.this$0.productRepository;
                Long productId = affiliatesProduct.getProductId();
                if (productId == null) {
                    Intrinsics.throwNpe();
                }
                return access$getProductRepository$p.getRelatedPosts(productId.longValue());
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new Consumer<List<? extends Post>>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(final List<Post> list) {
                this.this$0.getRelatedPosts = new Function0<List<? extends Post>>() {
                    public final List<Post> invoke() {
                        return list;
                    }
                };
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe5, "isProductSubject\n       … = {it}\n                }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        Disposable subscribe6 = Observables.INSTANCE.combineLatest(this.webPageProgressSubject, this.loadingTimerSubject).filter(AnonymousClass19.INSTANCE).filter(AnonymousClass20.INSTANCE).subscribe(new Consumer<Pair<? extends Integer, ? extends Boolean>>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Pair<Integer, Boolean> pair) {
                this.this$0.getCloseLoadingView().setValue(Unit.INSTANCE);
                StoreBrowserViewModel.access$getLoadingDisposable$p(this.this$0).dispose();
            }
        }, new Consumer<Throwable>(this) {
            final /* synthetic */ StoreBrowserViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Throwable th) {
                this.this$0.getCloseLoadingView().setValue(Unit.INSTANCE);
                StoreBrowserViewModel.access$getLoadingDisposable$p(this.this$0).dispose();
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe6, "Observables.combineLates…pose()\n                })");
        this.loadingDisposable = subscribe6;
        this.errorMessageLiveData = new MutableLiveData<>();
        this.relatedPostsLiveData = new MutableLiveData<>();
    }

    @NotNull
    public final MutableLiveData<Boolean> isPageLoaedLiveData() {
        return this.isPageLoaedLiveData;
    }

    @NotNull
    public final MutableLiveData<AffiliatesProduct> getAffiliatesProductLiveData() {
        return this.affiliatesProductLiveData;
    }

    @NotNull
    public final MutableLiveData<List<ProductVariantViewData>> getOptionsLiveData() {
        return this.optionsLiveData;
    }

    @NotNull
    public final MutableLiveData<OrderableOptionViewData> getOrderableOptionLiveData() {
        return this.orderableOptionLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> getTotalPriceLiveData() {
        return this.totalPriceLiveData;
    }

    @NotNull
    public final MutableLiveData<Throwable> getTotalPriceErrorLiveData() {
        return this.totalPriceErrorLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getToastLiveData() {
        return this.toastLiveData;
    }

    @NotNull
    public final MutableLiveData<Pair<OrderInfoViewData, Long>> getOrderInfoLiveData() {
        return this.orderInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> isWishProductLiveData() {
        return this.isWishProductLiveData;
    }

    @NotNull
    public final MutableLiveData<Throwable> getCheckOrderableExceptionLiveData() {
        return this.checkOrderableExceptionLiveData;
    }

    @NotNull
    public final MutableLiveData<Unit> getSoldOutLiveData() {
        return this.soldOutLiveData;
    }

    @NotNull
    public final MutableLiveData<Unit> getCloseLoadingView() {
        return this.closeLoadingView;
    }

    @NotNull
    public final MutableLiveData<Boolean> isShowLoadingBottomView() {
        return this.isShowLoadingBottomView;
    }

    @NotNull
    public final MutableLiveData<Boolean> isShowStoreStoreInfoBubble() {
        return this.isShowStoreStoreInfoBubble;
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, String>> getStoreNameLiveData() {
        return this.storeNameLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getBuyButtonGoneLiveData() {
        return this.buyButtonGoneLiveData;
    }

    public final void initPostId(@NotNull Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        this.postId = (Long) function0.invoke();
    }

    public final void initEventId(@NotNull Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        this.eventId = (Long) function0.invoke();
    }

    public final void updateWebPageLoadingProgress(int i) {
        this.webPageProgressSubject.onNext(Integer.valueOf(i));
        if (i < 15) {
            this.isPartnerSubject.onNext(Boolean.valueOf(false));
        }
    }

    public final void startLoadingTimer() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = Single.timer(1000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new StoreBrowserViewModel$startLoadingTimer$1(this), new StoreBrowserViewModel$startLoadingTimer$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "Single.timer(1000, TimeU…(true)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void isWebpageLoaded(boolean z) {
        this.isPageLoaedLiveData.setValue(Boolean.valueOf(z));
        this.isPageLoadedSubject.onNext(Boolean.valueOf(z));
    }

    public final void checkProductLink(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.storeRepository.postStoreInfo(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new StoreBrowserViewModel$checkProductLink$1(this), new StoreBrowserViewModel$checkProductLink$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "storeRepository.postStor…= null\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.disposables;
        ProductRepository productRepository2 = this.productRepository;
        Long l = this.postId;
        Long l2 = this.eventId;
        Disposable subscribe2 = productRepository2.checkOrderableProductVariant(str, l, (l2 != null && l2.longValue() == -1) ? "normal" : "special_discount", this.eventId).onErrorReturn(StoreBrowserViewModel$checkProductLink$3.INSTANCE).subscribe(new StoreBrowserViewModel$checkProductLink$4(this), new StoreBrowserViewModel$checkProductLink$5(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "productRepository.checkO…false)\n                })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    public final void executeDomRemoveScript(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        function1.invoke(this.domRemoveScript);
    }

    public final void checkPartnerAndLoading(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.storeRepository.postStoreInfo(str).subscribe(new StoreBrowserViewModel$checkPartnerAndLoading$1(this), new StoreBrowserViewModel$checkPartnerAndLoading$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "storeRepository.postStor… 스토어\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final void showStoreLoadingView(boolean z, String str) {
        this.storeNameLiveData.setValue(new Pair(Boolean.valueOf(z), str));
        startLoadingTimer();
    }

    public final void getSigleItemVariantInfo(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "option");
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.productRepository.getProductVariant(j).map(new StoreBrowserViewModel$getSigleItemVariantInfo$1(this, str)).subscribe((BiConsumer<? super T, ? super Throwable>) new StoreBrowserViewModel$getSigleItemVariantInfo$2<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "productRepository.getPro…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void getVariantsInfo(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.productRepository.getProductVariant(j).map(new StoreBrowserViewModel$getVariantsInfo$1(this)).subscribe((BiConsumer<? super T, ? super Throwable>) new StoreBrowserViewModel$getVariantsInfo$2<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "productRepository.getPro…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void getTotalVariantOptions(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "options");
        CompositeDisposable compositeDisposable = this.disposables;
        ProductRepository productRepository2 = this.productRepository;
        Long l = this.eventId;
        Disposable subscribe = productRepository2.getProductVariantsTotalPrice(str, (l != null && l.longValue() == -1) ? "normal" : "special_discount", this.eventId).subscribe((BiConsumer<? super T, ? super Throwable>) new StoreBrowserViewModel$getTotalVariantOptions$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "productRepository.getPro…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void registerVariantToCart(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "variantsJson");
        DefaultImpls.logCustom$default(this.eventTracker, "Add Cart", null, 2, null);
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.cartRepository.updateCartLineItemVariantCount(str, this.postId).subscribe(new StoreBrowserViewModel$registerVariantToCart$1(this), new StoreBrowserViewModel$registerVariantToCart$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "cartRepository.updateCar…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final MutableLiveData<Throwable> getErrorMessageLiveData() {
        return this.errorMessageLiveData;
    }

    public final void getPreOrderInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "variantsJson");
        DefaultImpls.logCustom$default(this.eventTracker, "Buy Now", null, 2, null);
        CompositeDisposable compositeDisposable = this.disposables;
        ProductRepository productRepository2 = this.productRepository;
        Long l = this.eventId;
        Disposable subscribe = productRepository2.getProductVariantsPreOrderData(str, (l != null && l.longValue() == -1) ? "normal" : "special_discount", this.eventId).subscribe((BiConsumer<? super T, ? super Throwable>) new StoreBrowserViewModel$getPreOrderInfo$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "productRepository.getPro…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void enrollWishList() {
        AffiliatesProduct affiliatesProduct = (AffiliatesProduct) this.isProductSubject.getValue();
        if (affiliatesProduct != null) {
            Long productId = affiliatesProduct.getProductId();
            if (productId != null) {
                long longValue = productId.longValue();
                CompositeDisposable compositeDisposable = this.disposables;
                Disposable subscribe = this.commerceRepository.addWishProduct(longValue).subscribe(new StoreBrowserViewModel$enrollWishList$$inlined$let$lambda$1(longValue, this), new StoreBrowserViewModel$enrollWishList$$inlined$let$lambda$2(this));
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.addWi…it\n                    })");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
    }

    public final void removeWishList() {
        AffiliatesProduct affiliatesProduct = (AffiliatesProduct) this.isProductSubject.getValue();
        if (affiliatesProduct != null) {
            Long productId = affiliatesProduct.getProductId();
            if (productId != null) {
                long longValue = productId.longValue();
                CompositeDisposable compositeDisposable = this.disposables;
                Disposable subscribe = this.commerceRepository.deleteWishProduct(longValue).subscribe(new StoreBrowserViewModel$removeWishList$$inlined$let$lambda$1(longValue, this), new StoreBrowserViewModel$removeWishList$$inlined$let$lambda$2(this));
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.delet…it\n                    })");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
    }

    public final void leaveEnterLog(@Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("leaveEnterLog::");
        sb.append(str);
        Logger.d(sb.toString(), new Object[0]);
        if (str != null) {
            this.eventTracker.logCustom("View Product In Store", new CustomAttributes().put("from", str));
        }
    }

    public final void startShowStoreInfoBubble() {
        if (((Boolean) this.isFirstAffiliatesCheck.invoke()).booleanValue()) {
            this.isShowStoreStoreInfoBubble.setValue(Boolean.valueOf(true));
            CompositeDisposable compositeDisposable = this.disposables;
            Disposable subscribe = Single.timer(2, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new StoreBrowserViewModel$startShowStoreInfoBubble$1<Object,Object>(this));
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "Single.timer(2, TimeUnit…lse\n                    }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            this.isFirstAffiliatesCheck = StoreBrowserViewModel$startShowStoreInfoBubble$2.INSTANCE;
        }
    }

    public final void handleScheme(@NotNull Activity activity, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        this.schemeHandler.handleScheme(activity, str);
    }

    public final void handleRestrictType(@NotNull Function1<? super AffiliatesProductRestrictState, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        AffiliatesProduct affiliatesProduct = (AffiliatesProduct) this.affiliatesProductLiveData.getValue();
        if (affiliatesProduct != null) {
            AffiliatesProductRestrictState restrictType = affiliatesProduct.getRestrictType();
            if (restrictType != null) {
                function1.invoke(restrictType);
            }
        }
    }

    @NotNull
    public final MutableLiveData<List<Post>> getRelatedPostsLiveData() {
        return this.relatedPostsLiveData;
    }

    public final void showRelatedPostsDialog() {
        MutableLiveData<List<Post>> mutableLiveData = this.relatedPostsLiveData;
        Function0<? extends List<Post>> function0 = this.getRelatedPosts;
        mutableLiveData.setValue(function0 != null ? (List) function0.invoke() : null);
    }

    public final void leavePostEnterLog() {
        Logger.d("HomeFeedViewModel::ViewPost, from home", new Object[0]);
        this.eventTracker.logCustom("View Post", new CustomAttributes().put("from", "browser"));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
