package kr.co.popone.fitts.feature.order.complete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.main.MainTabBar.Tab;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderCompleteRenderActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_ID = StringKeyGenerator.Companion.generate(OrderCompleteRenderActivity.class, "order_complete");
    private HashMap _$_findViewCache;
    @NotNull
    public DispatchingAndroidInjector<Fragment> fragmentInjector;
    @NotNull
    public OrderCompleteRenderViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Activity activity, long j) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intent intent = new Intent(activity, OrderCompleteRenderActivity.class);
            intent.putExtra(OrderCompleteRenderActivity.KEY_ORDER_ID, j);
            ContextExtensionKt.activityStart(activity, intent, ActivityAnimationType.SLIDE_UP);
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
    public AndroidInjector<Fragment> supportFragmentInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector = this.fragmentInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentInjector");
        }
        return dispatchingAndroidInjector;
    }

    @NotNull
    public final DispatchingAndroidInjector<Fragment> getFragmentInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector = this.fragmentInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentInjector");
        }
        return dispatchingAndroidInjector;
    }

    public final void setFragmentInjector(@NotNull DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        Intrinsics.checkParameterIsNotNull(dispatchingAndroidInjector, "<set-?>");
        this.fragmentInjector = dispatchingAndroidInjector;
    }

    @NotNull
    public final OrderCompleteRenderViewModel getViewModel() {
        OrderCompleteRenderViewModel orderCompleteRenderViewModel = this.viewModel;
        if (orderCompleteRenderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return orderCompleteRenderViewModel;
    }

    public final void setViewModel(@NotNull OrderCompleteRenderViewModel orderCompleteRenderViewModel) {
        Intrinsics.checkParameterIsNotNull(orderCompleteRenderViewModel, "<set-?>");
        this.viewModel = orderCompleteRenderViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_order_compelete);
        long longExtra = getIntent().getLongExtra(KEY_ORDER_ID, -1);
        OrderCompleteRenderViewModel orderCompleteRenderViewModel = this.viewModel;
        String str = "viewModel";
        if (orderCompleteRenderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderCompleteRenderViewModel.getOrderLineItem(longExtra);
        OrderCompleteRenderViewModel orderCompleteRenderViewModel2 = this.viewModel;
        if (orderCompleteRenderViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderCompleteRenderViewModel2.getOrderDetailViewDataLiveData().observe(new OrderCompleteRenderActivity$onCreate$2(this), new OrderCompleteRenderActivity$onCreate$3(this));
    }

    public void onBackPressed() {
        RxBus.INSTANCE.post(new MainEvent$MainTabChangeEvent(Tab.Store));
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_DOWN.getEnter(), ActivityAnimationType.SLIDE_DOWN.getExit());
    }
}
