package kr.co.popone.fitts.feature.store.bookmark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.store.list.StoreListAdapter;
import kr.co.popone.fitts.feature.store.list.StoreListAdapter.Delegate;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.decorator.FirstItemMarginDecorator;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.store.list.ShopBookmarkViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopBookmarkActivity extends AppCompatActivity implements Delegate {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ShopBookmarkActivity.class), "decorator", "getDecorator()Lkr/co/popone/fitts/ui/decorator/FirstItemMarginDecorator;"))};
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private final Lazy decorator$delegate = LazyKt__LazyJVMKt.lazy(ShopBookmarkActivity$decorator$2.INSTANCE);
    @NotNull
    public ShopBookmarkViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Unit start(@Nullable Context context) {
            if (context == null) {
                return null;
            }
            ContextExtensionKt.activityStart(context, new Intent(context, ShopBookmarkActivity.class), ActivityAnimationType.SLIDE_RTOL);
            return Unit.INSTANCE;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 3;
        }
    }

    private final FirstItemMarginDecorator getDecorator() {
        Lazy lazy = this.decorator$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (FirstItemMarginDecorator) lazy.getValue();
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
    public final ShopBookmarkViewModel getViewModel() {
        ShopBookmarkViewModel shopBookmarkViewModel = this.viewModel;
        if (shopBookmarkViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return shopBookmarkViewModel;
    }

    public final void setViewModel(@NotNull ShopBookmarkViewModel shopBookmarkViewModel) {
        Intrinsics.checkParameterIsNotNull(shopBookmarkViewModel, "<set-?>");
        this.viewModel = shopBookmarkViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_shop_bookmark);
        StoreListAdapter storeListAdapter = new StoreListAdapter(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerBookmarkedShop);
        recyclerView.setAdapter(storeListAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(getDecorator());
        }
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textToolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textToolbarTitle");
        textView.setText("즐겨찾기 목록");
        ((ImageButton) _$_findCachedViewById(C0010R$id.buttonBack)).setOnClickListener(new ShopBookmarkActivity$onCreate$2(this));
        ((TextView) _$_findCachedViewById(C0010R$id.buttonGoShop)).setOnClickListener(new ShopBookmarkActivity$onCreate$3(this));
        ShopBookmarkViewModel shopBookmarkViewModel = this.viewModel;
        if (shopBookmarkViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        shopBookmarkViewModel.bookmarkListUpdated().observe(this, new ShopBookmarkActivity$onCreate$$inlined$with$lambda$1(this, storeListAdapter));
        shopBookmarkViewModel.networkStateUpdated().observe(this, new ShopBookmarkActivity$onCreate$$inlined$with$lambda$2(this, storeListAdapter));
        shopBookmarkViewModel.viewisiblityUpdated().observe(this, new ShopBookmarkActivity$onCreate$$inlined$with$lambda$3(this, storeListAdapter));
        shopBookmarkViewModel.navToShopBridge().observe(this, new ShopBookmarkActivity$onCreate$$inlined$with$lambda$4(this, storeListAdapter));
    }

    /* access modifiers changed from: private */
    public final void updateViewVisiblity(boolean z) {
        String str = "groupEmptyView";
        String str2 = "recyclerBookmarkedShop";
        if (z) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerBookmarkedShop);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, str2);
            ViewExtensionsKt.gone(recyclerView);
            Group group = (Group) _$_findCachedViewById(C0010R$id.groupEmptyView);
            Intrinsics.checkExpressionValueIsNotNull(group, str);
            ViewExtensionsKt.visible(group);
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerBookmarkedShop);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str2);
        ViewExtensionsKt.visible(recyclerView2);
        Group group2 = (Group) _$_findCachedViewById(C0010R$id.groupEmptyView);
        Intrinsics.checkExpressionValueIsNotNull(group2, str);
        ViewExtensionsKt.gone(group2);
    }

    public void shopListEmpty() {
        updateViewVisiblity(true);
    }

    public void onStoreClick(long j) {
        ShopBookmarkViewModel shopBookmarkViewModel = this.viewModel;
        if (shopBookmarkViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        shopBookmarkViewModel.bookmarkShopClicked(j);
    }

    public void finish() {
        super.finish();
        ActivityExtensionKt.finishAnimation(this, ActivityAnimationType.SLIDE_LTOR);
    }
}
