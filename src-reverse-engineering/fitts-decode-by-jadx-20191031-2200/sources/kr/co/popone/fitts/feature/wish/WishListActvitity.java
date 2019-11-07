package kr.co.popone.fitts.feature.wish;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.home.feed.ProductFeedHolder.Delegate;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.wish.WishListViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class WishListActvitity extends AppCompatActivity implements Delegate {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(WishListActvitity.class), "decorator", "getDecorator()Lkr/co/popone/fitts/ui/decorator/RecyclerDecorator;"))};
    private HashMap _$_findViewCache;
    private final Lazy decorator$delegate = LazyKt__LazyJVMKt.lazy(WishListActvitity$decorator$2.INSTANCE);
    @NotNull
    public WishListViewModel viewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 3;
        }
    }

    private final RecyclerDecorator getDecorator() {
        Lazy lazy = this.decorator$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (RecyclerDecorator) lazy.getValue();
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
    public final WishListViewModel getViewModel() {
        WishListViewModel wishListViewModel = this.viewModel;
        if (wishListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return wishListViewModel;
    }

    public final void setViewModel(@NotNull WishListViewModel wishListViewModel) {
        Intrinsics.checkParameterIsNotNull(wishListViewModel, "<set-?>");
        this.viewModel = wishListViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_wishlist_actvitity);
        WishListAdapter wishListAdapter = new WishListAdapter(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.wishListRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new WishListActvitity$onCreate$$inlined$apply$lambda$1(recyclerView, this, wishListAdapter));
        recyclerView.setAdapter(wishListAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(getDecorator());
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new WishListActvitity$onCreate$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonGoShopping)).setOnClickListener(new WishListActvitity$onCreate$3(this));
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout)).setOnRefreshListener(new WishListActvitity$onCreate$4(this));
        WishListViewModel wishListViewModel = this.viewModel;
        String str = "viewModel";
        if (wishListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        wishListViewModel.getWishListFeeds().observe(new WishListActvitity$onCreate$5(this), new WishListActvitity$onCreate$6(wishListAdapter));
        WishListViewModel wishListViewModel2 = this.viewModel;
        if (wishListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        wishListViewModel2.getNetworkState().observe(new WishListActvitity$onCreate$7(this), new WishListActvitity$onCreate$8(this, wishListAdapter));
        WishListViewModel wishListViewModel3 = this.viewModel;
        if (wishListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        wishListViewModel3.isEmptyList().observe(new WishListActvitity$onCreate$9(this), new WishListActvitity$onCreate$10(this));
    }

    public void onBackPressed() {
        ActivityExtensionKt.finishWithAnimation(this, ActivityAnimationType.SLIDE_LTOR);
    }

    public final int getGridSpanSize(int i) {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.wishListRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "wishListRecyclerView");
        Adapter adapter = recyclerView.getAdapter();
        Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemViewType(i)) : null;
        return (valueOf != null && valueOf.intValue() == 2131558709) ? 3 : 1;
    }

    public void onProductClicked(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Companion.start$default(StoreBrowserActivity.Companion, this, str, "wishlist", null, null, 24, null);
    }
}
