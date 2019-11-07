package kr.co.popone.fitts.feature.intro.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ResetPasswordActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Boolean> requestObservable;
    /* access modifiers changed from: private */
    public Disposable resetPasswordRequest;
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

    public ResetPasswordActivity() {
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(Boolean.valueOf(false));
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(false)");
        this.requestObservable = createDefault;
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
        setContentView((int) C0013R$layout.activity_reset_password);
        ((ImageButton) _$_findCachedViewById(C0010R$id.cancelButton)).setOnClickListener(new ResetPasswordActivity$onCreate$1(this));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.userIDEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "userIDEditText");
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        Intrinsics.checkExpressionValueIsNotNull(textChanges, "RxTextView.textChanges(this)");
        textChanges.subscribe((Consumer<? super T>) new ResetPasswordActivity$onCreate$2<Object>(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.resetPasswordButton)).setOnClickListener(new ResetPasswordActivity$onCreate$3(this));
        this.requestObservable.subscribe((Consumer<? super T>) new ResetPasswordActivity$onCreate$4<Object>(this));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.resetPasswordRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
