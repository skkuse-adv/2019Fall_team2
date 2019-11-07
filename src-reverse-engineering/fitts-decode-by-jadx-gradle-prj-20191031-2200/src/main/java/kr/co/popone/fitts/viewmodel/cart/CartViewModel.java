package kr.co.popone.fitts.viewmodel.cart;

import androidx.lifecycle.MutableLiveData;
import com.orhanobut.logger.Logger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.model.cart.CartLineItemsDomain;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import kr.co.popone.fitts.repository.CartRepository;
import org.jetbrains.annotations.NotNull;

public final class CartViewModel extends BaseViewModel {
    private final CartRepository cartRepository;
    @NotNull
    private final MutableLiveData<CartLineItemsDomain> createdCartLineItemLiveData = new MutableLiveData<>();
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final MutableLiveData<Unit> emptyCartLineItemLiveData = new MutableLiveData<>();
    private final EventTracker eventTracker;
    @NotNull
    private final MutableLiveData<OrderInfoViewData> orderableLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<CartLineItemsDomain> priceCartLineItemLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<CartLineItemsDomain> removedCartLineItemLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<CartLineItemsDomain> updatedCartLineItemLiveData = new MutableLiveData<>();

    public CartViewModel(@NotNull CartRepository cartRepository2, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(cartRepository2, "cartRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.cartRepository = cartRepository2;
        this.eventTracker = eventTracker2;
        createVariantsDetail();
    }

    @NotNull
    public final MutableLiveData<CartLineItemsDomain> getCreatedCartLineItemLiveData() {
        return this.createdCartLineItemLiveData;
    }

    @NotNull
    public final MutableLiveData<CartLineItemsDomain> getUpdatedCartLineItemLiveData() {
        return this.updatedCartLineItemLiveData;
    }

    @NotNull
    public final MutableLiveData<CartLineItemsDomain> getRemovedCartLineItemLiveData() {
        return this.removedCartLineItemLiveData;
    }

    @NotNull
    public final MutableLiveData<Unit> getEmptyCartLineItemLiveData() {
        return this.emptyCartLineItemLiveData;
    }

    @NotNull
    public final MutableLiveData<CartLineItemsDomain> getPriceCartLineItemLiveData() {
        return this.priceCartLineItemLiveData;
    }

    @NotNull
    public final MutableLiveData<OrderInfoViewData> getOrderableLiveData() {
        return this.orderableLiveData;
    }

    private final void createVariantsDetail() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.cartRepository.getCartLineItems().subscribe((BiConsumer<? super T, ? super Throwable>) new CartViewModel$createVariantsDetail$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "cartRepository.getCartLi…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void updateVariantsDetail(long j, int i) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.cartRepository.putVariantsItem(j, i).subscribe((BiConsumer<? super T, ? super Throwable>) new CartViewModel$updateVariantsDetail$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "cartRepository.putVarian…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void removeVariantsDetail(long j) {
        DefaultImpls.logCustom$default(this.eventTracker, "Remove Product In Cart", null, 2, null);
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.cartRepository.removeVariantsItem(j).subscribe((BiConsumer<? super T, ? super Throwable>) new CartViewModel$removeVariantsDetail$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "cartRepository.removeVar…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void updateVariantsAndLineItemPrice(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "variantsJson");
        if (Intrinsics.areEqual((Object) str, (Object) "[]")) {
            this.emptyCartLineItemLiveData.postValue(Unit.INSTANCE);
            return;
        }
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.cartRepository.getVariantsAndLineItemPrice(str).subscribe((BiConsumer<? super T, ? super Throwable>) new CartViewModel$updateVariantsAndLineItemPrice$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "cartRepository.getVarian…  }\n                    }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void getPreOrderItems(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "variantsJson");
        DefaultImpls.logCustom$default(this.eventTracker, "Buy In Cart", null, 2, null);
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.cartRepository.putPreOrderableItems(str).subscribe((BiConsumer<? super T, ? super Throwable>) new CartViewModel$getPreOrderItems$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "cartRepository.putPreOrd…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void leaveCartEnterLog(@NotNull String str) {
        String str2 = "from";
        Intrinsics.checkParameterIsNotNull(str, str2);
        StringBuilder sb = new StringBuilder();
        sb.append("CartViewModel::CartEnter - ");
        sb.append(str);
        Logger.d(sb.toString(), new Object[0]);
        this.eventTracker.logCustom("Tap Cart", new CustomAttributes().put(str2, str));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
