package kr.co.popone.fitts.feature.setting;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import com.facebook.internal.ServerProtocol;
import com.kakao.usermgmt.UserManagement;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SettingActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable logout;
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public UserAPI userAPI;

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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_setting);
        PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        Intrinsics.checkExpressionValueIsNotNull(packageInfo, "this.packageManager.getP…Info(this.packageName, 0)");
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.version);
        Intrinsics.checkExpressionValueIsNotNull(textView, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        textView.setText(packageInfo.versionName);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        ((ImageButton) _$_findCachedViewById(C0010R$id.back)).setOnClickListener(new SettingActivity$onCreate$1(this));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.modify_profile_button)).setOnClickListener(new SettingActivity$onCreate$2(this, makeCustomAnimation));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.setting_alarm_button)).setOnClickListener(new SettingActivity$onCreate$3(this, makeCustomAnimation));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.notify_button)).setOnClickListener(new SettingActivity$onCreate$4(this, makeCustomAnimation));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.contact_us_button)).setOnClickListener(new SettingActivity$onCreate$5(this, makeCustomAnimation));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.send_opinion_button)).setOnClickListener(new SettingActivity$onCreate$6(this, makeCustomAnimation));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.instagrm_button)).setOnClickListener(new SettingActivity$onCreate$7(this, makeCustomAnimation));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.facebook_button)).setOnClickListener(new SettingActivity$onCreate$8(this, makeCustomAnimation));
        ((ConstraintLayout) _$_findCachedViewById(C0010R$id.askPlusFriendLayout)).setOnClickListener(new SettingActivity$onCreate$9(this, makeCustomAnimation));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.terms_button)).setOnClickListener(new SettingActivity$onCreate$10(this, makeCustomAnimation));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.privacy_button)).setOnClickListener(new SettingActivity$onCreate$11(this, makeCustomAnimation));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.buttonBusinessInfo)).setOnClickListener(new SettingActivity$onCreate$12(this));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.version_button)).setOnClickListener(SettingActivity$onCreate$13.INSTANCE);
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.logout_button)).setOnClickListener(new SettingActivity$onCreate$14(this, makeCustomAnimation));
        ((RelativeLayout) _$_findCachedViewById(C0010R$id.withdraw_button)).setOnClickListener(new SettingActivity$onCreate$15(this, makeCustomAnimation));
    }

    /* access modifiers changed from: private */
    public final void logoutWithFirebaseToken(String str, ActivityOptionsCompat activityOptionsCompat) {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        this.logout = userAPI2.deletePushToken(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(new SettingActivity$logoutWithFirebaseToken$1(this)).subscribe((BiConsumer<? super T, ? super Throwable>) new SettingActivity$logoutWithFirebaseToken$2<Object,Object>(this, activityOptionsCompat));
    }

    /* access modifiers changed from: private */
    public final void logoutWithoutFirebaseToken(ActivityOptionsCompat activityOptionsCompat) {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        this.logout = userAPI2.logout().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new SettingActivity$logoutWithoutFirebaseToken$1<Object,Object>(this, activityOptionsCompat));
    }

    /* access modifiers changed from: private */
    public final void logoutKakaoAuth(ActivityOptionsCompat activityOptionsCompat) {
        UserManagement.getInstance().requestLogout(new SettingActivity$logoutKakaoAuth$1(this, activityOptionsCompat));
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.logout;
        if (disposable != null) {
            disposable.dispose();
        }
        this.logout = null;
        super.onDestroy();
    }
}
