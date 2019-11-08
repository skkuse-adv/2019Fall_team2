package kr.co.popone.fitts.feature.coupon;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.extension.FragmentTransactionExtensionKt;
import kr.co.popone.fitts.feature.coupon.CouponListFragment.OnFragmentInteractionListener;
import kr.co.popone.fitts.feature.identification.view.IdentificationActivity;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CouponHomeActivity extends AppCompatActivity implements HasSupportFragmentInjector, OnFragmentInteractionListener {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    @NotNull
    public DispatchingAndroidInjector<Fragment> fragmentInjector;
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public UserAPI userAPI;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
    public final SessionManager getSessionManager$app_productionFittsRelease() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager$app_productionFittsRelease(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    @NotNull
    public final UserAPI getUserAPI$app_productionFittsRelease() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        return userAPI2;
    }

    public final void setUserAPI$app_productionFittsRelease(@NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "<set-?>");
        this.userAPI = userAPI2;
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
        setContentView((int) C0013R$layout.activity_coupon_home);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new CouponHomeActivity$onCreate$1(this));
        ((TextView) _$_findCachedViewById(C0010R$id.registerButton)).setOnClickListener(new CouponHomeActivity$onCreate$2(this));
        loadUserInfo();
        FragmentTransactionExtensionKt.beginTransaction((AppCompatActivity) this, (int) C0010R$id.containerCoupon, (Fragment) CouponListFragment.Companion.newInstance());
    }

    public void onBackPressed() {
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }

    /* access modifiers changed from: private */
    @SuppressLint({"RestrictedApi"})
    public final void startCouponRegisterActivity() {
        Intent intent = new Intent(this, CouponRegisterActivity.class);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this, C0001R$anim.slide_up, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
        startActivityForResult(intent, 106, makeCustomAnimation.toBundle());
    }

    /* access modifiers changed from: private */
    @SuppressLint({"RestrictedApi"})
    public final void startIdentificationActivity() {
        Intent intent = new Intent(this, IdentificationActivity.class);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this, C0001R$anim.slide_up, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
        startActivityForResult(intent, 105, makeCustomAnimation.toBundle());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 105) {
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            sessionManager2.loadUserInfo();
        } else if (i != 106) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            loadUserInfo();
        }
    }

    private final void loadUserInfo() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new CouponHomeActivity$loadUserInfo$1<Object,Object>(this));
    }
}
