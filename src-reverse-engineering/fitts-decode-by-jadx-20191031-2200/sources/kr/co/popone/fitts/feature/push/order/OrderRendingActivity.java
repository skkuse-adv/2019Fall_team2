package kr.co.popone.fitts.feature.push.order;

import android.app.Activity;
import android.content.Context;
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
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.base.extension.FragmentTransactionExtensionKt;
import kr.co.popone.fitts.model.domain.push.PushRendingElement;
import kr.co.popone.fitts.model.domain.push.PushRendingState;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderRendingActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_PUSH_REDERING_ELEMENT = StringKeyGenerator.Companion.generate(OrderRendingActivity.class, "push_redering_element");
    private HashMap _$_findViewCache;
    @NotNull
    public DispatchingAndroidInjector<Fragment> fragmentInjector;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @NotNull PushRendingElement pushRendingElement) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(pushRendingElement, "pushRendingElement");
            Intent intent = new Intent(context, OrderRendingActivity.class);
            intent.putExtra(OrderRendingActivity.KEY_PUSH_REDERING_ELEMENT, pushRendingElement);
            ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_UP);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[PushRendingState.values().length];

        static {
            $EnumSwitchMapping$0[PushRendingState.RESERVATION_COMPLETE.ordinal()] = 1;
            $EnumSwitchMapping$0[PushRendingState.PAYMENT_PRESS.ordinal()] = 2;
            $EnumSwitchMapping$0[PushRendingState.RESERVATION_CANCEL_SOLD_OUT.ordinal()] = 3;
            $EnumSwitchMapping$0[PushRendingState.RESERVATION_CANCEL_MISPRICE.ordinal()] = 4;
            $EnumSwitchMapping$0[PushRendingState.PAYMENT_COMPLETE.ordinal()] = 5;
            $EnumSwitchMapping$0[PushRendingState.PAYMENT_CANCEL_SOLD_OUT.ordinal()] = 6;
            $EnumSwitchMapping$0[PushRendingState.PAYMENT_CANCEL_MISPRICE.ordinal()] = 7;
            $EnumSwitchMapping$0[PushRendingState.ADMIN_CANCEL_ALL_SELLER_FAULT.ordinal()] = 8;
            $EnumSwitchMapping$0[PushRendingState.ADMIN_CANCEL_ALL_CUSTOMER_FAULT.ordinal()] = 9;
            $EnumSwitchMapping$0[PushRendingState.ADMIN_CANCEL_PARTIAL_SELLER_FAULT.ordinal()] = 10;
            $EnumSwitchMapping$0[PushRendingState.ADMIN_CANCEL_PARTIAL_CUSTOMER_FAULT.ordinal()] = 11;
            $EnumSwitchMapping$0[PushRendingState.DONE.ordinal()] = 12;
            $EnumSwitchMapping$0[PushRendingState.SHIPPING_DONE.ordinal()] = 13;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_order_rending);
        PushRendingElement pushRendingElement = (PushRendingElement) getIntent().getParcelableExtra(KEY_PUSH_REDERING_ELEMENT);
        if (pushRendingElement.getOrderId() != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[pushRendingElement.getPushRendingState().ordinal()]) {
                case 1:
                    startTransaction(OrderReservationCompleteFragment.Companion.newInstance(pushRendingElement.getOrderId().longValue()));
                    return;
                case 2:
                    startTransaction(OrderPaymentRushFragment.Companion.newInstance(pushRendingElement.getOrderId().longValue()));
                    return;
                case 3:
                    startTransaction(OrderReservationSoldOutFragment.Companion.newInstance(pushRendingElement.getOrderId().longValue()));
                    return;
                case 4:
                    startTransaction(OrderReservationCancelFragment.Companion.newInstance(pushRendingElement.getOrderId().longValue()));
                    return;
                case 5:
                    startTransaction(OrderPaymentCompleteFragment.Companion.newInstance(pushRendingElement.getOrderId().longValue()));
                    return;
                case 6:
                    startTransaction(PaymentCancelSoldOutFragment.Companion.newInstance(pushRendingElement.getOrderId().longValue()));
                    return;
                case 7:
                    startTransaction(PaymentCancelMisPriceFragment.Companion.newInstance(pushRendingElement.getOrderId().longValue()));
                    return;
                case 8:
                    startTransaction(OrderAllCancelFragment.Companion.newInstance(pushRendingElement.getOrderId().longValue(), "seller"));
                    return;
                case 9:
                    startTransaction(OrderAllCancelFragment.Companion.newInstance(pushRendingElement.getOrderId().longValue(), "customer"));
                    return;
                case 10:
                    kr.co.popone.fitts.feature.push.order.OrderPartCancelFragment.Companion companion = OrderPartCancelFragment.Companion;
                    long longValue = pushRendingElement.getOrderId().longValue();
                    Long lineItemVariantId = pushRendingElement.getLineItemVariantId();
                    if (lineItemVariantId == null) {
                        Intrinsics.throwNpe();
                    }
                    startTransaction(companion.newInstance(longValue, lineItemVariantId.longValue(), "seller"));
                    return;
                case 11:
                    kr.co.popone.fitts.feature.push.order.OrderPartCancelFragment.Companion companion2 = OrderPartCancelFragment.Companion;
                    long longValue2 = pushRendingElement.getOrderId().longValue();
                    Long lineItemVariantId2 = pushRendingElement.getLineItemVariantId();
                    if (lineItemVariantId2 == null) {
                        Intrinsics.throwNpe();
                    }
                    startTransaction(companion2.newInstance(longValue2, lineItemVariantId2.longValue(), "customer"));
                    return;
                case 12:
                    kr.co.popone.fitts.feature.push.order.OrderCompleteFragment.Companion companion3 = OrderCompleteFragment.Companion;
                    long longValue3 = pushRendingElement.getOrderId().longValue();
                    Long lineItemVariantId3 = pushRendingElement.getLineItemVariantId();
                    if (lineItemVariantId3 == null) {
                        Intrinsics.throwNpe();
                    }
                    startTransaction(companion3.newInstance(longValue3, lineItemVariantId3.longValue()));
                    return;
                case 13:
                    kr.co.popone.fitts.feature.push.order.OrderShippingCompleteFragment.Companion companion4 = OrderShippingCompleteFragment.Companion;
                    long longValue4 = pushRendingElement.getOrderId().longValue();
                    Long lineItemVariantId4 = pushRendingElement.getLineItemVariantId();
                    if (lineItemVariantId4 == null) {
                        Intrinsics.throwNpe();
                    }
                    startTransaction(companion4.newInstance(longValue4, lineItemVariantId4.longValue()));
                    return;
                default:
                    return;
            }
        }
    }

    private final void startTransaction(Fragment fragment) {
        FragmentTransactionExtensionKt.beginTransaction((AppCompatActivity) this, (int) C0010R$id.orderRendingContainer, fragment);
    }

    public void onBackPressed() {
        ActivityExtensionKt.finishWithAnimation(this, ActivityAnimationType.SLIDE_DOWN);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_DOWN.getEnter(), ActivityAnimationType.SLIDE_DOWN.getExit());
    }
}
