package kr.co.popone.fitts.feature.store.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.paging.PagedList;
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
import kr.co.popone.fitts.event.ShopBookmarkEvent;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.feature.store.bridge.ShopBridgeAdapter.Delegate;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.model.datamodel.social.feed.SlidingBanner$Type;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.store.bridge.ShopBridgeViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopBridgeActivity extends BaseActivity implements Delegate {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ShopBridgeActivity.class), "offset", "getOffset()I"))};
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_STORE_ID = "store_id";
    private HashMap _$_findViewCache;
    private final Lazy offset$delegate = LazyKt__LazyJVMKt.lazy(new ShopBridgeActivity$offset$2(this));
    private final ShopBridgeAdapter storeBridgeAdapter = new ShopBridgeAdapter(this);
    @NotNull
    public ShopBridgeViewModel vm;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@Nullable Context context, long j) {
            if (context != null) {
                Intent intent = new Intent(context, ShopBridgeActivity.class);
                intent.putExtra(ShopBridgeActivity.KEY_STORE_ID, j);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }
    }

    /* access modifiers changed from: private */
    public final int getOffset() {
        Lazy lazy = this.offset$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).intValue();
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
        return C0013R$layout.activity_store_bridge;
    }

    @NotNull
    public final ShopBridgeViewModel getVm() {
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        return shopBridgeViewModel;
    }

    public final void setVm(@NotNull ShopBridgeViewModel shopBridgeViewModel) {
        Intrinsics.checkParameterIsNotNull(shopBridgeViewModel, "<set-?>");
        this.vm = shopBridgeViewModel;
    }

    @NotNull
    public ActivityAnimationType finishAnimationType() {
        return ActivityAnimationType.SLIDE_LTOR;
    }

    @Nullable
    public Lifecycle getProvidedLifecycle() {
        return getLifecycle();
    }

    @NotNull
    public SlidingBanner$Type getSlidingBanner() {
        return SlidingBanner$Type.SHOP_BRIDGE;
    }

    @Nullable
    public SessionManager getSessionManager() {
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        return shopBridgeViewModel.getSessionManager();
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AndroidInjection.inject((Activity) this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerStoreBridge);
        recyclerView.setAdapter(this.storeBridgeAdapter);
        recyclerView.addOnScrollListener(new ShopBridgeActivity$onCreate$$inlined$apply$lambda$1(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new ShopBridgeActivity$onCreate$2(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.bookmarkButton)).setOnClickListener(new ShopBridgeActivity$onCreate$3(this));
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        String str = "vm";
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        shopBridgeViewModel.shopTitleUpdated().observe(this, new ShopBridgeActivity$sam$androidx_lifecycle_Observer$0(new ShopBridgeActivity$onCreate$4(this)));
        ShopBridgeViewModel shopBridgeViewModel2 = this.vm;
        if (shopBridgeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        shopBridgeViewModel2.shopLinkUrlUpdated().observe(this, new ShopBridgeActivity$sam$androidx_lifecycle_Observer$0(new ShopBridgeActivity$onCreate$5(this)));
        ShopBridgeViewModel shopBridgeViewModel3 = this.vm;
        if (shopBridgeViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        shopBridgeViewModel3.shopBridgeFeedsUpdated().observe(this, new ShopBridgeActivity$sam$androidx_lifecycle_Observer$0(new ShopBridgeActivity$onCreate$6(this)));
        ShopBridgeViewModel shopBridgeViewModel4 = this.vm;
        if (shopBridgeViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        shopBridgeViewModel4.updateBookmarkIcon().observe(this, new ShopBridgeActivity$sam$androidx_lifecycle_Observer$0(new ShopBridgeActivity$onCreate$7(this)));
        ShopBridgeViewModel shopBridgeViewModel5 = this.vm;
        if (shopBridgeViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        shopBridgeViewModel5.shopBookmarkEventUpdated().observeForever(new ShopBridgeActivity$sam$androidx_lifecycle_Observer$0(new ShopBridgeActivity$onCreate$8(this)));
        ShopBridgeViewModel shopBridgeViewModel6 = this.vm;
        if (shopBridgeViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        shopBridgeViewModel6.productLikeEventUpdated().observeForever(new ShopBridgeActivity$sam$androidx_lifecycle_Observer$0(new ShopBridgeActivity$onCreate$9(this)));
        ShopBridgeViewModel shopBridgeViewModel7 = this.vm;
        if (shopBridgeViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        shopBridgeViewModel7.routeToStoreBrowser().observe(this, new ShopBridgeActivity$sam$androidx_lifecycle_Observer$0(new ShopBridgeActivity$onCreate$10(this)));
        ShopBridgeViewModel shopBridgeViewModel8 = this.vm;
        if (shopBridgeViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        shopBridgeViewModel8.errorOccur().observe(this, new ShopBridgeActivity$sam$androidx_lifecycle_Observer$0(new ShopBridgeActivity$onCreate$11(this)));
    }

    /* access modifiers changed from: private */
    public final void updateShopTitle(String str) {
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textStoreBridgeTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textStoreBridgeTitle");
        textView.setText(str);
    }

    /* access modifiers changed from: private */
    public final void updateShopLinkUrl(String str) {
        ((Button) _$_findCachedViewById(C0010R$id.buttonGoStore)).setOnClickListener(new ShopBridgeActivity$updateShopLinkUrl$1(this, str));
    }

    /* access modifiers changed from: private */
    public final void updateShopFeeds(PagedList<FeedItem> pagedList) {
        this.storeBridgeAdapter.submitList(pagedList);
    }

    /* access modifiers changed from: private */
    public final void updateBookmarkState(int i) {
        ((ImageButton) _$_findCachedViewById(C0010R$id.bookmarkButton)).setImageDrawable(ContextCompat.getDrawable(this, i));
    }

    /* access modifiers changed from: private */
    public final void updateShopBookmarkHeader(ShopBookmarkEvent shopBookmarkEvent) {
        this.storeBridgeAdapter.updateBookmarkState(shopBookmarkEvent);
    }

    /* access modifiers changed from: private */
    public final void updateProductLikeState(WishStateUpdateEvent wishStateUpdateEvent) {
        this.storeBridgeAdapter.updateProductLikeState(wishStateUpdateEvent);
    }

    /* access modifiers changed from: private */
    public final void routeToStoreBrowserActivity(String str) {
        kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, this, str, "shop", null, null, 24, null);
    }

    public void onSchemeClick(@NotNull ViewHolder viewHolder, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        shopBridgeViewModel.handleScheme(this, str);
    }

    public void onSlidingBannerClick(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        shopBridgeViewModel.handleScheme(this, str);
    }

    public void onAddShopBookmark(long j) {
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        shopBridgeViewModel.addShopBookmark(j);
    }

    public void onRemoveShopBookmark(long j) {
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        shopBridgeViewModel.removeShopBookmark(j);
    }

    public void onProductClick(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        shopBridgeViewModel.productFeedClick(str);
    }

    public void onAddLikeProduct(long j) {
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        shopBridgeViewModel.addLikeProductClick(j);
    }

    public void onRemoveLikeProduct(long j) {
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        shopBridgeViewModel.removeLikeProductClick(j);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ShopBridgeViewModel shopBridgeViewModel = this.vm;
        String str = "vm";
        if (shopBridgeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        shopBridgeViewModel.shopBookmarkEventUpdated().removeObservers(this);
        ShopBridgeViewModel shopBridgeViewModel2 = this.vm;
        if (shopBridgeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        shopBridgeViewModel2.productLikeEventUpdated().removeObservers(this);
        super.onDestroy();
    }
}
