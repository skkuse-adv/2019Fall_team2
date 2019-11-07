package kr.co.popone.fitts.feature.refund;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.internal.ServerProtocol;
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
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundDetailViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RefundCompleteActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_EXCHANGE_REFUND_ID = StringKeyGenerator.Companion.generate(RefundCompleteActivity.class, "exchange_refund_id");
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_LINE_ITEM_VARIANT_ID = StringKeyGenerator.Companion.generate(RefundCompleteActivity.class, "order_line_item_variant_id");
    /* access modifiers changed from: private */
    public static final String KEY_PAYMENT_METHOD = StringKeyGenerator.Companion.generate(RefundCompleteActivity.class, "payment_method");
    private HashMap _$_findViewCache;
    @NotNull
    public DispatchingAndroidInjector<Fragment> fragmentInjector;
    @NotNull
    public RefundDetailViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startRefundApplyComplete(@NotNull Context context, long j, long j2, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "paymentMethod");
            Intent intent = new Intent(context, RefundCompleteActivity.class);
            intent.putExtra(RefundCompleteActivity.KEY_ORDER_LINE_ITEM_VARIANT_ID, j);
            intent.putExtra(RefundCompleteActivity.KEY_EXCHANGE_REFUND_ID, j2);
            intent.putExtra(RefundCompleteActivity.KEY_PAYMENT_METHOD, str);
            ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
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
    public final DispatchingAndroidInjector<Fragment> getFragmentInjector$app_productionFittsRelease() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector = this.fragmentInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentInjector");
        }
        return dispatchingAndroidInjector;
    }

    public final void setFragmentInjector$app_productionFittsRelease(@NotNull DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        Intrinsics.checkParameterIsNotNull(dispatchingAndroidInjector, "<set-?>");
        this.fragmentInjector = dispatchingAndroidInjector;
    }

    @NotNull
    public final RefundDetailViewModel getViewModel() {
        RefundDetailViewModel refundDetailViewModel = this.viewModel;
        if (refundDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return refundDetailViewModel;
    }

    public final void setViewModel(@NotNull RefundDetailViewModel refundDetailViewModel) {
        Intrinsics.checkParameterIsNotNull(refundDetailViewModel, "<set-?>");
        this.viewModel = refundDetailViewModel;
    }

    @NotNull
    public AndroidInjector<Fragment> supportFragmentInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector = this.fragmentInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentInjector");
        }
        return dispatchingAndroidInjector;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_refund_complete);
        RefundDetailViewModel refundDetailViewModel = this.viewModel;
        String str = "viewModel";
        if (refundDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        long longExtra = getIntent().getLongExtra(KEY_ORDER_LINE_ITEM_VARIANT_ID, -1);
        long longExtra2 = getIntent().getLongExtra(KEY_EXCHANGE_REFUND_ID, -1);
        String stringExtra = getIntent().getStringExtra(KEY_PAYMENT_METHOD);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(KEY_PAYMENT_METHOD)");
        refundDetailViewModel.getRefundDetailInfo(longExtra, longExtra2, stringExtra);
        RefundDetailViewModel refundDetailViewModel2 = this.viewModel;
        if (refundDetailViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundDetailViewModel2.getRefundInfoLiveData().observe(new RefundCompleteActivity$onCreate$1(this), new RefundCompleteActivity$onCreate$2(this));
        RefundDetailViewModel refundDetailViewModel3 = this.viewModel;
        if (refundDetailViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundDetailViewModel3.getErrorLiveData().observe(new RefundCompleteActivity$onCreate$3(this), new RefundCompleteActivity$onCreate$4(this));
    }

    public final void transactionFragment(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.DIALOG_PARAM_STATE);
        int hashCode = str.hashCode();
        if (hashCode == -1367724422) {
            boolean equals = str.equals("cancel");
        } else if (hashCode != -707924457) {
            if (hashCode == 93029230 && str.equals("apply")) {
                FragmentTransactionExtensionKt.beginTransaction((AppCompatActivity) this, (int) C0010R$id.refundCompleteContainer, (Fragment) RefundApplyCompleteFragment.Companion.newInstance());
            }
        } else if (str.equals("refunded")) {
            FragmentTransactionExtensionKt.beginTransaction((AppCompatActivity) this, (int) C0010R$id.refundCompleteContainer, (Fragment) RefundCompleteFragment.Companion.newInstance());
        }
    }

    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getFragments().size() <= 1) {
            ActivityExtensionKt.finishWithAnimation(this, ActivityAnimationType.SLIDE_LTOR);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }
}
