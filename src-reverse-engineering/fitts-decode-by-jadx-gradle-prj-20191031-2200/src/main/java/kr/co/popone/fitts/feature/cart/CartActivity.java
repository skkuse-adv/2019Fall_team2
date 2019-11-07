package kr.co.popone.fitts.feature.cart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.cart.CartViewModel;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_START_FROM = StringKeyGenerator.Companion.generate(CartActivity.class, "start_from");
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final CartAdatper cartAdatper = new CartAdatper();
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    public CartViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@Nullable Context context, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "from");
            if (context != null) {
                Intent intent = new Intent(context, CartActivity.class);
                intent.putExtra(CartActivity.KEY_START_FROM, str);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final CartViewModel getViewModel() {
        CartViewModel cartViewModel = this.viewModel;
        if (cartViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return cartViewModel;
    }

    public final void setViewModel(@NotNull CartViewModel cartViewModel) {
        Intrinsics.checkParameterIsNotNull(cartViewModel, "<set-?>");
        this.viewModel = cartViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_cart);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.cartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.cartAdatper);
        _$_findCachedViewById(C0010R$id.checkBoxView).setOnClickListener(new CartActivity$onCreate$2(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new CartActivity$onCreate$3(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonGoShopping)).setOnClickListener(new CartActivity$onCreate$4(this));
        this.cartAdatper.getVariantsCountLiveData().observe(new CartActivity$onCreate$5(this), new CartActivity$onCreate$6(this));
        CartViewModel cartViewModel = this.viewModel;
        String str = "viewModel";
        if (cartViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        cartViewModel.getCreatedCartLineItemLiveData().observe(new CartActivity$onCreate$7(this), new CartActivity$onCreate$8(this));
        CartViewModel cartViewModel2 = this.viewModel;
        if (cartViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        cartViewModel2.getUpdatedCartLineItemLiveData().observe(new CartActivity$onCreate$9(this), new CartActivity$onCreate$10(this));
        CartViewModel cartViewModel3 = this.viewModel;
        if (cartViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        cartViewModel3.getRemovedCartLineItemLiveData().observe(new CartActivity$onCreate$11(this), new CartActivity$onCreate$12(this));
        CartViewModel cartViewModel4 = this.viewModel;
        if (cartViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        cartViewModel4.getOrderableLiveData().observe(new CartActivity$onCreate$13(this), new CartActivity$onCreate$14(this));
        CartViewModel cartViewModel5 = this.viewModel;
        if (cartViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        cartViewModel5.getPriceCartLineItemLiveData().observe(new CartActivity$onCreate$15(this), new CartActivity$onCreate$16(this));
        CartViewModel cartViewModel6 = this.viewModel;
        if (cartViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        cartViewModel6.getEmptyCartLineItemLiveData().observe(new CartActivity$onCreate$17(this), new CartActivity$onCreate$18(this));
        CartViewModel cartViewModel7 = this.viewModel;
        if (cartViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        cartViewModel7.getErrorLiveData().observe(new CartActivity$onCreate$19(this), new CartActivity$onCreate$20(this));
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = RxBus.INSTANCE.toObservable().throttleLast(300, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new CartActivity$onCreate$21<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        leaveEnterLog();
    }

    /* access modifiers changed from: private */
    public final void calculateTotalPrice() {
        String checkedVariantsAsJson = this.cartAdatper.getCheckedVariantsAsJson();
        CartViewModel cartViewModel = this.viewModel;
        if (cartViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cartViewModel.updateVariantsAndLineItemPrice(checkedVariantsAsJson);
    }

    /* access modifiers changed from: private */
    public final void makeOrder() {
        String preOrderableVariantsJson = this.cartAdatper.getPreOrderableVariantsJson();
        CartViewModel cartViewModel = this.viewModel;
        if (cartViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cartViewModel.getPreOrderItems(preOrderableVariantsJson);
    }

    /* access modifiers changed from: private */
    public final void updateLayoutVisiblity(boolean z) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C0010R$id.cartListLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "cartListLayout");
        int i = 8;
        constraintLayout.setVisibility(z ? 8 : 0);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C0010R$id.emptyLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "emptyLayout");
        if (z) {
            i = 0;
        }
        constraintLayout2.setVisibility(i);
    }

    /* access modifiers changed from: private */
    public final void showDeleteConfirmDialog(long j) {
        DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this, "", "상품을 장바구니에서 삭제할까요?", new CartActivity$showDeleteConfirmDialog$1(this, j), null, null, null, 0, DimensionsKt.HDPI, null);
    }

    /* access modifiers changed from: private */
    public final void showEmptyOrderableItemsDialog() {
        DialogExtensions.INSTANCE.showMessageDialog(this, "", "구매할 상품을 선택해주세요.", CartActivity$showEmptyOrderableItemsDialog$1.INSTANCE, "확인");
    }

    /* access modifiers changed from: private */
    public final boolean hasOrderableItems() {
        return !Intrinsics.areEqual((Object) this.cartAdatper.getCheckedVariantsAsJson(), (Object) "[]");
    }

    private final void leaveEnterLog() {
        String stringExtra = getIntent().getStringExtra(KEY_START_FROM);
        if (stringExtra != null) {
            CartViewModel cartViewModel = this.viewModel;
            if (cartViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            cartViewModel.leaveCartEnterLog(stringExtra);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.disposable.dispose();
        super.onDestroy();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }
}
