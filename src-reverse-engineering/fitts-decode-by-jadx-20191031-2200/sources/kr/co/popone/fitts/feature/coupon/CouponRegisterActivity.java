package kr.co.popone.fitts.feature.coupon;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CouponRegisterActivity extends AppCompatActivity implements OnEditorActionListener {
    private HashMap _$_findViewCache;
    @NotNull
    public CouponAPI couponAPI;
    /* access modifiers changed from: private */
    public Disposable couponRegisterRequest;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Boolean> loadingSubject;

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

    public CouponRegisterActivity() {
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(Boolean.valueOf(false));
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(false)");
        this.loadingSubject = createDefault;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_coupon_register);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new CouponRegisterActivity$onCreate$1(this));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.couponCodeEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "couponCodeEditText");
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        Intrinsics.checkExpressionValueIsNotNull(textChanges, "RxTextView.textChanges(this)");
        textChanges.subscribe((Consumer<? super T>) new CouponRegisterActivity$onCreate$2<Object>(this));
        ((EditText) _$_findCachedViewById(C0010R$id.couponCodeEditText)).setOnEditorActionListener(this);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setEnabled(false);
        ((TextView) _$_findCachedViewById(C0010R$id.confirmButton)).setOnClickListener(new CouponRegisterActivity$onCreate$3(this));
        this.loadingSubject.subscribe((Consumer<? super T>) new CouponRegisterActivity$onCreate$4<Object>(this));
    }

    public boolean onEditorAction(@Nullable TextView textView, int i, @Nullable KeyEvent keyEvent) {
        if (textView != null && textView.getId() == 2131362084 && i == 6) {
            this.loadingSubject.onNext(Boolean.valueOf(true));
            requestRegisterCoupon();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void requestRegisterCoupon() {
        if (this.couponRegisterRequest == null) {
            CouponAPI couponAPI2 = this.couponAPI;
            if (couponAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("couponAPI");
            }
            EditText editText = (EditText) _$_findCachedViewById(C0010R$id.couponCodeEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText, "couponCodeEditText");
            this.couponRegisterRequest = couponAPI2.requestRegisterCoupon(editText.getText().toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new CouponRegisterActivity$requestRegisterCoupon$1<Object,Object>(this));
        }
    }

    /* access modifiers changed from: private */
    public final void showMessageDialog() {
        DialogExtensions.INSTANCE.showMessageDialog(this, "쿠폰 등록이 완료되었어요!", "쿠폰함에서 쿠폰을 확인해보세요.", new CouponRegisterActivity$showMessageDialog$1(this), "확인");
    }

    public void onBackPressed() {
        setResult(0);
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.couponRegisterRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
