package kr.co.popone.fitts.feature.card;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.GraphResponse;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.identification.view.IdentificationActivity;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FittsCardRendingActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(FittsCardRendingActivity.class), "SCREEN_WIDTH", "getSCREEN_WIDTH()I"))};
    public static final Companion Companion = new Companion(null);
    private final double FITTS_CARD_DESC_BOTTOM_RATIO = 1.6111d;
    private final double FITTS_CARD_DESC_TOP_RATIO = 3.7194d;
    private final int REQUEST_IVS = 1010;
    private final Lazy SCREEN_WIDTH$delegate = LazyKt__LazyJVMKt.lazy(new FittsCardRendingActivity$SCREEN_WIDTH$2(this));
    private HashMap _$_findViewCache;
    @NotNull
    public CouponAPI couponAPI;
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    public EventTracker eventTracker;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            ContextExtensionKt.activityStart(context, new Intent(context, FittsCardRendingActivity.class), ActivityAnimationType.SLIDE_UP);
        }
    }

    private final int getSCREEN_WIDTH() {
        Lazy lazy = this.SCREEN_WIDTH$delegate;
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

    @NotNull
    public final CouponAPI getCouponAPI() {
        CouponAPI couponAPI2 = this.couponAPI;
        if (couponAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponAPI");
        }
        return couponAPI2;
    }

    public final void setCouponAPI(@NotNull CouponAPI couponAPI2) {
        Intrinsics.checkParameterIsNotNull(couponAPI2, "<set-?>");
        this.couponAPI = couponAPI2;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return eventTracker2;
    }

    public final void setEventTracker(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "<set-?>");
        this.eventTracker = eventTracker2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_fitts_card_rending);
        Glide.with((FragmentActivity) this).load(Integer.valueOf(C0008R$drawable.img_fitts_card_desc_top)).apply(new RequestOptions().override(getSCREEN_WIDTH(), getHeightByRatio(this.FITTS_CARD_DESC_TOP_RATIO))).into((ImageView) _$_findCachedViewById(C0010R$id.imageFittsCardDescTop));
        Glide.with((FragmentActivity) this).load(Integer.valueOf(C0008R$drawable.img_fitts_card_desc_bottom)).apply(new RequestOptions().override(getSCREEN_WIDTH(), getHeightByRatio(this.FITTS_CARD_DESC_BOTTOM_RATIO))).into((ImageView) _$_findCachedViewById(C0010R$id.imageFittsCardDescBottom));
        ((ConstraintLayout) _$_findCachedViewById(C0010R$id.buttonCoupontDownload)).setOnClickListener(new FittsCardRendingActivity$onCreate$1(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new FittsCardRendingActivity$onCreate$2(this));
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        eventTracker2.customLogTapFittsCard();
    }

    /* access modifiers changed from: private */
    public final void issueFittsCard() {
        CompositeDisposable compositeDisposable = this.disposables;
        CouponAPI couponAPI2 = this.couponAPI;
        if (couponAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponAPI");
        }
        Disposable subscribe = couponAPI2.requestRegisterFittsCard().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new FittsCardRendingActivity$issueFittsCard$1(this), new FittsCardRendingActivity$issueFittsCard$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "couponAPI.requestRegiste…or(it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final void handleFittsCardIssued(String str) {
        switch (str.hashCode()) {
            case -1867169789:
                if (str.equals(GraphResponse.SUCCESS_KEY)) {
                    showResultDialog("💌쿠폰이 발급되었습니다.\n스토어에서 바로 사용해보세요! 😢");
                    return;
                }
                return;
            case 124188829:
                if (str.equals("not_allow_age")) {
                    showResultDialog("핏츠카드는\n20세 이상부터\n발급 가능합니다 😢");
                    return;
                }
                return;
            case 188164328:
                if (str.equals("exist_post")) {
                    showResultDialog("첫 포스트를 작성하지 않은\n핏티님만 이용 가능합니다 😢");
                    return;
                }
                return;
            case 1432991139:
                if (str.equals("not_yet_ivs")) {
                    ActivityExtensionKt.activityStartForResult(this, new Intent(this, IdentificationActivity.class), ActivityAnimationType.SLIDE_UP, this.REQUEST_IVS);
                    return;
                }
                return;
            case 1939017270:
                if (str.equals("end_event")) {
                    showResultDialog("이벤트 기간이 아닙니다 😢");
                    return;
                }
                return;
            case 1978176170:
                if (str.equals("already_register")) {
                    showResultDialog("이미 등록된 쿠폰이에요 😢");
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != this.REQUEST_IVS) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            issueFittsCard();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    private final void showResultDialog(String str) {
        DialogExtensions.INSTANCE.showMessageDialog(this, "", str, new FittsCardRendingActivity$showResultDialog$1(this), "확인");
    }

    private final int getHeightByRatio(double d) {
        double screen_width = (double) getSCREEN_WIDTH();
        Double.isNaN(screen_width);
        return (int) (screen_width * d);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_DOWN.getEnter(), ActivityAnimationType.SLIDE_DOWN.getExit());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.disposables.dispose();
        super.onDestroy();
    }
}
