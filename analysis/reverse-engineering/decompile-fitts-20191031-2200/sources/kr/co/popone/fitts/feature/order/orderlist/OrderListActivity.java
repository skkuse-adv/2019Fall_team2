package kr.co.popone.fitts.feature.order.orderlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.ui.custom.ScrollChildSwipeRefreshLayout;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.order.list.OrderListViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderListActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    /* access modifiers changed from: private */
    public final OrderListAdapter orderListAdapter = new OrderListAdapter();
    @NotNull
    public OrderListViewModel viewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 3;
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
    public final OrderListViewModel getViewModel() {
        OrderListViewModel orderListViewModel = this.viewModel;
        if (orderListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return orderListViewModel;
    }

    public final void setViewModel(@NotNull OrderListViewModel orderListViewModel) {
        Intrinsics.checkParameterIsNotNull(orderListViewModel, "<set-?>");
        this.viewModel = orderListViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_order_list);
        ((RecyclerView) _$_findCachedViewById(C0010R$id.orderListRecyclerView)).setAdapter(this.orderListAdapter);
        ((ScrollChildSwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout)).setOnRefreshListener(new OrderListActivity$onCreate$2(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new OrderListActivity$onCreate$3(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonGoShopping)).setOnClickListener(new OrderListActivity$onCreate$4(this));
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).filter(OrderListActivity$onCreate$5.INSTANCE).map(OrderListActivity$onCreate$6.INSTANCE).throttleLast(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new OrderListActivity$onCreate$7(this), OrderListActivity$onCreate$8.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   … $it\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        ScrollChildSwipeRefreshLayout scrollChildSwipeRefreshLayout = (ScrollChildSwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.orderListRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "orderListRecyclerView");
        scrollChildSwipeRefreshLayout.setScrollUpChild(recyclerView);
        getOrderList();
    }

    /* access modifiers changed from: private */
    public final void getOrderList() {
        OrderListViewModel orderListViewModel = this.viewModel;
        String str = "viewModel";
        if (orderListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderListViewModel.requestOrderList();
        OrderListViewModel orderListViewModel2 = this.viewModel;
        if (orderListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        LiveData pagedOrderListLiveData = orderListViewModel2.getPagedOrderListLiveData();
        if (pagedOrderListLiveData != null) {
            pagedOrderListLiveData.observe(new OrderListActivity$getOrderList$1(this), new OrderListActivity$getOrderList$2(this));
        }
        OrderListViewModel orderListViewModel3 = this.viewModel;
        if (orderListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        LiveData networkState = orderListViewModel3.getNetworkState();
        if (networkState != null) {
            networkState.observe(new OrderListActivity$getOrderList$3(this), new OrderListActivity$getOrderList$4(this));
        }
        OrderListViewModel orderListViewModel4 = this.viewModel;
        if (orderListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        LiveData isEmptyList = orderListViewModel4.isEmptyList();
        if (isEmptyList != null) {
            isEmptyList.observe(new OrderListActivity$getOrderList$5(this), new OrderListActivity$getOrderList$6(this));
        }
    }

    /* access modifiers changed from: private */
    public final void isEmptyList(boolean z) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C0010R$id.emptyLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "emptyLayout");
        int i = 0;
        constraintLayout.setVisibility(z ? 0 : 8);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.orderListRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "orderListRecyclerView");
        if (z) {
            i = 8;
        }
        recyclerView.setVisibility(i);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.disposables.dispose();
        super.onDestroy();
    }
}
