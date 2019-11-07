package kr.co.popone.fitts.feature.push.order;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderReservationSoldOutFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_ID = StringKeyGenerator.Companion.generate(OrderReservationSoldOutFragment.class, "key_order_id");
    private HashMap _$_findViewCache;
    @NotNull
    public OrderPushRendingViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderReservationSoldOutFragment newInstance(long j) {
            OrderReservationSoldOutFragment orderReservationSoldOutFragment = new OrderReservationSoldOutFragment();
            Bundle bundle = new Bundle();
            bundle.putLong(OrderReservationSoldOutFragment.KEY_ORDER_ID, j);
            orderReservationSoldOutFragment.setArguments(bundle);
            return orderReservationSoldOutFragment;
        }
    }

    @NotNull
    public static final OrderReservationSoldOutFragment newInstance(long j) {
        return Companion.newInstance(j);
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
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final OrderPushRendingViewModel getViewModel() {
        OrderPushRendingViewModel orderPushRendingViewModel = this.viewModel;
        if (orderPushRendingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return orderPushRendingViewModel;
    }

    public final void setViewModel(@NotNull OrderPushRendingViewModel orderPushRendingViewModel) {
        Intrinsics.checkParameterIsNotNull(orderPushRendingViewModel, "<set-?>");
        this.viewModel = orderPushRendingViewModel;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_order_reservation_sold_out, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new OrderReservationSoldOutFragment$onViewCreated$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.orderDetailButton)).setOnClickListener(new OrderReservationSoldOutFragment$onViewCreated$2(this));
        Bundle arguments = getArguments();
        String str = "viewModel";
        if (arguments != null) {
            long j = arguments.getLong(KEY_ORDER_ID);
            OrderPushRendingViewModel orderPushRendingViewModel = this.viewModel;
            if (orderPushRendingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            orderPushRendingViewModel.requestOrderInfo(j);
        }
        OrderPushRendingViewModel orderPushRendingViewModel2 = this.viewModel;
        if (orderPushRendingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel2.getOrderDetailViewDataLiveData().observe(new OrderReservationSoldOutFragment$onViewCreated$4(this), new OrderReservationSoldOutFragment$onViewCreated$5(this));
        OrderPushRendingViewModel orderPushRendingViewModel3 = this.viewModel;
        if (orderPushRendingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel3.getErrorLiveData().observe(new OrderReservationSoldOutFragment$onViewCreated$6(this), new OrderReservationSoldOutFragment$onViewCreated$7(this));
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textTitle");
        textView.setText("예약하신 상품이\n품절되었어요😢");
    }
}
