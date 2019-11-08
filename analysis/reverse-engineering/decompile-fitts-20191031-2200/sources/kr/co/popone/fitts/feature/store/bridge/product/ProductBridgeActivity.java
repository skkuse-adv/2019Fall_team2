package kr.co.popone.fitts.feature.store.bridge.product;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.BaseActivity;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.feature.store.bridge.product.ProductBridgeAdapter.Delegate;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.ui.decorator.ProductBridgeDecorator;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.store.bridge.product.ProductBridgeViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductBridgeActivity extends BaseActivity implements Delegate {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ProductBridgeActivity.class), "productBridgeAdapter", "getProductBridgeAdapter()Lkr/co/popone/fitts/feature/store/bridge/product/ProductBridgeAdapter;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ProductBridgeActivity.class), "HEADER_HEIGHT", "getHEADER_HEIGHT()D")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ProductBridgeActivity.class), "postId", "getPostId()J")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ProductBridgeActivity.class), "fromPost", "getFromPost()Z"))};
    public static final Companion Companion = new Companion(null);
    private final Lazy HEADER_HEIGHT$delegate = LazyKt__LazyJVMKt.lazy(new ProductBridgeActivity$HEADER_HEIGHT$2(this));
    private HashMap _$_findViewCache;
    private final Lazy fromPost$delegate = LazyKt__LazyJVMKt.lazy(new ProductBridgeActivity$fromPost$2(this));
    private final Lazy postId$delegate = LazyKt__LazyJVMKt.lazy(new ProductBridgeActivity$postId$2(this));
    private final Lazy productBridgeAdapter$delegate = LazyKt__LazyJVMKt.lazy(new ProductBridgeActivity$productBridgeAdapter$2(this));
    @NotNull
    public ProductBridgeViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@Nullable Context context, long j, boolean z, boolean z2) {
            if (context != null) {
                Intent intent = new Intent(context, ProductBridgeActivity.class);
                intent.putExtra("post_id", j);
                intent.putExtra("has_product_info", z);
                intent.putExtra("from_post", z2);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }
    }

    private final boolean getFromPost() {
        Lazy lazy = this.fromPost$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return ((Boolean) lazy.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final double getHEADER_HEIGHT() {
        Lazy lazy = this.HEADER_HEIGHT$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return ((Number) lazy.getValue()).doubleValue();
    }

    private final long getPostId() {
        Lazy lazy = this.postId$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return ((Number) lazy.getValue()).longValue();
    }

    /* access modifiers changed from: private */
    public final ProductBridgeAdapter getProductBridgeAdapter() {
        Lazy lazy = this.productBridgeAdapter$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ProductBridgeAdapter) lazy.getValue();
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

    public int layoutResource() {
        return C0013R$layout.activity_product_bridge;
    }

    @NotNull
    public final ProductBridgeViewModel getViewModel() {
        ProductBridgeViewModel productBridgeViewModel = this.viewModel;
        if (productBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return productBridgeViewModel;
    }

    public final void setViewModel(@NotNull ProductBridgeViewModel productBridgeViewModel) {
        Intrinsics.checkParameterIsNotNull(productBridgeViewModel, "<set-?>");
        this.viewModel = productBridgeViewModel;
    }

    @Nullable
    public SessionManager getSessionManager() {
        ProductBridgeViewModel productBridgeViewModel = this.viewModel;
        if (productBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return productBridgeViewModel.getSessionMannager();
    }

    @NotNull
    public ActivityAnimationType finishAnimationType() {
        return ActivityAnimationType.SLIDE_LTOR;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerProducts);
        recyclerView.setAdapter(getProductBridgeAdapter());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new ProductBridgeActivity$onCreate$$inlined$apply$lambda$1(this));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(new ProductBridgeActivity$onCreate$$inlined$apply$lambda$2(this));
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new ProductBridgeDecorator());
        }
        ((ImageButton) _$_findCachedViewById(C0010R$id.buttonBack)).setOnClickListener(new ProductBridgeActivity$onCreate$2(this));
        ProductBridgeViewModel productBridgeViewModel = this.viewModel;
        String str = "viewModel";
        if (productBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        productBridgeViewModel.getProductItemsLiveData().observe(new ProductBridgeActivity$onCreate$3(this), new ProductBridgeActivity$onCreate$4(this));
        ProductBridgeViewModel productBridgeViewModel2 = this.viewModel;
        if (productBridgeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        productBridgeViewModel2.getErrorLiveData().observe(new ProductBridgeActivity$onCreate$5(this), new ProductBridgeActivity$onCreate$6(this));
        ProductBridgeViewModel productBridgeViewModel3 = this.viewModel;
        if (productBridgeViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        productBridgeViewModel3.updateProgressViewState().observe(this, new ProductBridgeActivity$onCreate$7(this));
        ProductBridgeViewModel productBridgeViewModel4 = this.viewModel;
        if (productBridgeViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        productBridgeViewModel4.getRecommendProductList(getPostId());
    }

    public void productHeaderClicked(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        StoreBrowserActivity.Companion.start(this, str, null, null, Long.valueOf(getPostId()));
        boolean booleanExtra = getIntent().getBooleanExtra("has_product_info", false);
        ProductBridgeViewModel productBridgeViewModel = this.viewModel;
        String str2 = "viewModel";
        if (productBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
        }
        productBridgeViewModel.logViewProductNotInStore(booleanExtra);
        if (getFromPost()) {
            ProductBridgeViewModel productBridgeViewModel2 = this.viewModel;
            if (productBridgeViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
            }
            productBridgeViewModel2.showProductFromPostActionLog(getPostId());
        }
    }

    public void onSchemeClick(@NotNull ViewHolder viewHolder, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        ProductBridgeViewModel productBridgeViewModel = this.viewModel;
        if (productBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        productBridgeViewModel.handleScheme(this, str);
    }

    public void onProductClick(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, this, str, "bridge not store", null, null, 24, null);
    }
}
