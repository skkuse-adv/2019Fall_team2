package kr.co.popone.fitts.feature.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModifyUserInfoActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Boolean> loadingSubject;
    @NotNull
    public UserAPI userAPI;
    /* access modifiers changed from: private */
    public Disposable userInfoDisposable;
    /* access modifiers changed from: private */
    public Disposable userInfoRegisterDisposable;

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

    public ModifyUserInfoActivity() {
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(Boolean.valueOf(false));
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(false)");
        this.loadingSubject = createDefault;
    }

    @NotNull
    public final UserAPI getUserAPI() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        return userAPI2;
    }

    public final void setUserAPI(@NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "<set-?>");
        this.userAPI = userAPI2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_modify_user_info);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setEnabled(false);
        ((TextView) _$_findCachedViewById(C0010R$id.confirmButton)).setOnClickListener(new ModifyUserInfoActivity$onCreate$1(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new ModifyUserInfoActivity$onCreate$2(this));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.userNameEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "userNameEditText");
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        String str = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str);
        textChanges.subscribe((Consumer<? super T>) new ModifyUserInfoActivity$onCreate$3<Object>(this));
        ((EditText) _$_findCachedViewById(C0010R$id.userNameEditText)).setOnClickListener(new ModifyUserInfoActivity$onCreate$4(this));
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.userPhoneEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "userPhoneEditText");
        InitialValueObservable textChanges2 = RxTextView.textChanges(editText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str);
        textChanges2.subscribe((Consumer<? super T>) new ModifyUserInfoActivity$onCreate$5<Object>(this));
        this.loadingSubject.subscribe((Consumer<? super T>) new ModifyUserInfoActivity$onCreate$6<Object>(this));
        requestUserInfo();
    }

    private final void requestUserInfo() {
        if (this.userInfoDisposable == null) {
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            this.userInfoDisposable = userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ModifyUserInfoActivity$requestUserInfo$1<Object,Object>(this));
        }
    }

    /* access modifiers changed from: private */
    public final void initializeUserInfoUI(MyInfo myInfo) {
        String name = myInfo.getContactInfo().getName();
        if (name != null) {
            ((EditText) _$_findCachedViewById(C0010R$id.userNameEditText)).setText(name);
            EditText editText = (EditText) _$_findCachedViewById(C0010R$id.userNameEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText, "userNameEditText");
            editText.setCursorVisible(false);
        }
        String contact = myInfo.getContactInfo().getContact();
        if (contact != null) {
            ((EditText) _$_findCachedViewById(C0010R$id.userPhoneEditText)).setText(contact);
        }
    }

    /* access modifiers changed from: private */
    public final boolean checkUserInput() {
        boolean z;
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.userNameEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "userNameEditText");
        String str = "";
        if (Intrinsics.areEqual((Object) editText.getText().toString(), (Object) str)) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.userNameTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, "userNameTextView");
            Sdk27PropertiesKt.setTextColor(textView, ContextCompat.getColor(this, C0006R$color.neon_red));
            z = false;
        } else {
            z = true;
        }
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.userPhoneEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "userPhoneEditText");
        if (!Intrinsics.areEqual((Object) editText2.getText().toString(), (Object) str)) {
            return z;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.userPhoneTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "userPhoneTextView");
        Sdk27PropertiesKt.setTextColor(textView2, ContextCompat.getColor(this, C0006R$color.neon_red));
        return false;
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.userInfoRegisterDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
