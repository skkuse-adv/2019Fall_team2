package kr.co.popone.fitts.feature.intro.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.feature.main.MainActivity;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LoginActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable loginRequest;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_login);
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.email);
        String str = "email";
        Intrinsics.checkExpressionValueIsNotNull(editText, str);
        InitialValueObservable focusChanges = RxView.focusChanges(editText);
        String str2 = "RxView.focusChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(focusChanges, str2);
        focusChanges.subscribe((Consumer<? super T>) new LoginActivity$onCreate$1<Object>(this));
        TextInputEditText textInputEditText = (TextInputEditText) _$_findCachedViewById(C0010R$id.password);
        String str3 = "password";
        Intrinsics.checkExpressionValueIsNotNull(textInputEditText, str3);
        InitialValueObservable focusChanges2 = RxView.focusChanges(textInputEditText);
        Intrinsics.checkExpressionValueIsNotNull(focusChanges2, str2);
        focusChanges2.subscribe((Consumer<? super T>) new LoginActivity$onCreate$2<Object>(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.button_login)).setOnClickListener(new LoginActivity$onCreate$3(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.button_back)).setOnClickListener(new LoginActivity$onCreate$4(this));
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.email);
        Intrinsics.checkExpressionValueIsNotNull(editText2, str);
        InitialValueObservable textChanges = RxTextView.textChanges(editText2);
        String str4 = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str4);
        TextInputEditText textInputEditText2 = (TextInputEditText) _$_findCachedViewById(C0010R$id.password);
        Intrinsics.checkExpressionValueIsNotNull(textInputEditText2, str3);
        InitialValueObservable textChanges2 = RxTextView.textChanges(textInputEditText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str4);
        Observable.combineLatest((ObservableSource<? extends T1>) textChanges, (ObservableSource<? extends T2>) textChanges2, (BiFunction<? super T1, ? super T2, ? extends R>) LoginActivity$onCreate$5.INSTANCE).subscribe((Consumer<? super T>) new LoginActivity$onCreate$6<Object>(this));
        ((Button) _$_findCachedViewById(C0010R$id.resetPasswordButton)).setOnClickListener(new LoginActivity$onCreate$7(this));
    }

    private final void hideNoUserWarning() {
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.warning_view);
        Intrinsics.checkExpressionValueIsNotNull(textView, "warning_view");
        textView.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public final void showNoUserWarning(String str) {
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.warning_view);
        String str2 = "warning_view";
        Intrinsics.checkExpressionValueIsNotNull(textView, str2);
        textView.setText(str);
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.warning_view);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str2);
        textView2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void gotoMainView() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(32768);
        intent.addFlags(268435456);
        intent.addFlags(536870912);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        startActivity(intent, makeCustomAnimation.toBundle());
    }

    /* access modifiers changed from: private */
    public final void onLogin(String str, String str2) {
        hideNoUserWarning();
        Disposable disposable = this.loginRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        this.loginRequest = userAPI2.requestEmailLogin(str, str2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(new LoginActivity$onLogin$1(this)).subscribe(new LoginActivity$onLogin$2(this), new LoginActivity$onLogin$3(this));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.loginRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
