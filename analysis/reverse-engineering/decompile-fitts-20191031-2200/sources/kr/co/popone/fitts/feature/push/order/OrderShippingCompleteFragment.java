package kr.co.popone.fitts.feature.push.order;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.order.OrderDiscountType;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.utils.ScreenUtilsKt;

public final class OrderShippingCompleteFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_ID = StringKeyGenerator.Companion.generate(OrderShippingCompleteFragment.class, "key_order_id");
    /* access modifiers changed from: private */
    public static final String KEY_VARIANT_ID = StringKeyGenerator.Companion.generate(OrderShippingCompleteFragment.class, "key_variant_id");
    private final float FITTS_CARD_IMAGE_RATIO = 0.825f;
    private final float GENERAL_IMAGE_RATIO = 0.41111112f;
    private final String SCHEME_ALPHA = "fitts://collection/85?type=mixed";
    private final String SCHEME_ALPHA_SPECIAL_DISCOUNT = "fitts://collection/84?type=mixed";
    private final String SCHEME_BETA = "fitts://collection/282?type=mixed";
    private final String SCHEME_BETA_SPECIAL_DISCOUNT = "fitts://collection/268?type=mixed";
    private final float SPECIAL_DISCOUNT_IMAGE_RATIO = 0.35f;
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
        public final OrderShippingCompleteFragment newInstance(long j, long j2) {
            OrderShippingCompleteFragment orderShippingCompleteFragment = new OrderShippingCompleteFragment();
            Bundle bundle = new Bundle();
            bundle.putLong(OrderShippingCompleteFragment.KEY_ORDER_ID, j);
            bundle.putLong(OrderShippingCompleteFragment.KEY_VARIANT_ID, j2);
            orderShippingCompleteFragment.setArguments(bundle);
            return orderShippingCompleteFragment;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[OrderDiscountType.values().length];

        static {
            $EnumSwitchMapping$0[OrderDiscountType.GENERAL.ordinal()] = 1;
            $EnumSwitchMapping$0[OrderDiscountType.SPECIAL_DISCOUNT.ordinal()] = 2;
            $EnumSwitchMapping$0[OrderDiscountType.FITTS_CARD.ordinal()] = 3;
        }
    }

    @NotNull
    public static final OrderShippingCompleteFragment newInstance(long j, long j2) {
        return Companion.newInstance(j, j2);
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
        return layoutInflater.inflate(C0013R$layout.fragment_shipping_complete, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new OrderShippingCompleteFragment$onViewCreated$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonOrderDetail)).setOnClickListener(new OrderShippingCompleteFragment$onViewCreated$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonGoPosting)).setOnClickListener(new OrderShippingCompleteFragment$onViewCreated$3(this));
        OrderPushRendingViewModel orderPushRendingViewModel = this.viewModel;
        String str = "viewModel";
        if (orderPushRendingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel.getOrderDetailViewDataLiveData().observe(new OrderShippingCompleteFragment$onViewCreated$4(this), new OrderShippingCompleteFragment$onViewCreated$5(this));
        OrderPushRendingViewModel orderPushRendingViewModel2 = this.viewModel;
        if (orderPushRendingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel2.getRefundAccountInputedLiveData().observe(new OrderShippingCompleteFragment$onViewCreated$6(this), new OrderShippingCompleteFragment$onViewCreated$7(this));
        OrderPushRendingViewModel orderPushRendingViewModel3 = this.viewModel;
        if (orderPushRendingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel3.getExchangeRefundLiveData().observe(new OrderShippingCompleteFragment$onViewCreated$8(this), new OrderShippingCompleteFragment$onViewCreated$9(this));
        OrderPushRendingViewModel orderPushRendingViewModel4 = this.viewModel;
        if (orderPushRendingViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel4.getErrorLiveData().observe(new OrderShippingCompleteFragment$onViewCreated$10(this), new OrderShippingCompleteFragment$onViewCreated$11(this));
        Bundle arguments = getArguments();
        if (arguments != null) {
            long j = arguments.getLong(KEY_ORDER_ID);
            OrderPushRendingViewModel orderPushRendingViewModel5 = this.viewModel;
            if (orderPushRendingViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            orderPushRendingViewModel5.requestOrderInfo(j);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            long j2 = arguments2.getLong(KEY_VARIANT_ID);
            OrderPushRendingViewModel orderPushRendingViewModel6 = this.viewModel;
            if (orderPushRendingViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            orderPushRendingViewModel6.requestPreRefundItemInfo(j2);
        }
    }

    /* access modifiers changed from: private */
    public final void updateOrderStateImage(OrderDetailViewData orderDetailViewData) {
        if (orderDetailViewData != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[orderDetailViewData.getOrderDiscountType().ordinal()];
            if (i == 1) {
                loadOrderStateImage(C0008R$drawable.img_shipping_complete_general, this.GENERAL_IMAGE_RATIO);
                updateOrderState(this.SCHEME_ALPHA, this.SCHEME_BETA);
            } else if (i == 2) {
                loadOrderStateImage(C0008R$drawable.img_shipping_complete_special_discount, this.SPECIAL_DISCOUNT_IMAGE_RATIO);
                updateOrderState(this.SCHEME_ALPHA_SPECIAL_DISCOUNT, this.SCHEME_BETA_SPECIAL_DISCOUNT);
            } else if (i == 3) {
                loadOrderStateImage(C0008R$drawable.img_shipping_complete_fittca, this.FITTS_CARD_IMAGE_RATIO);
                updateOrderState(this.SCHEME_ALPHA, this.SCHEME_BETA);
            }
        }
    }

    private final void updateOrderState(String str, String str2) {
        ((ImageView) _$_findCachedViewById(C0010R$id.imageOrderState)).setOnClickListener(new OrderShippingCompleteFragment$updateOrderState$1(this, str, str2));
    }

    private final void loadOrderStateImage(int i, float f) {
        Context context = getContext();
        int screenWidth = context != null ? ScreenUtilsKt.screenWidth(context) : 0;
        Glide.with((Fragment) this).load(Integer.valueOf(i)).apply(new RequestOptions().override(screenWidth, (int) (((float) screenWidth) * f))).into((ImageView) _$_findCachedViewById(C0010R$id.imageOrderState));
    }
}
