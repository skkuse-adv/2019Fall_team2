package kr.co.popone.fitts.feature.alarm;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AlarmSettingActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(AlarmSettingActivity.class), "notificationState", "getNotificationState()Lkr/co/popone/fitts/feature/alarm/AlarmSettingActivity$NotificationState;"))};
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final ReadWriteProperty notificationState$delegate;
    @NotNull
    public UserAPI userAPI;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public enum NotificationState {
        INIT(null),
        ACTIVE(Boolean.valueOf(true)),
        INACTIVE(Boolean.valueOf(false));
        
        @Nullable
        private final Boolean isActive;

        private NotificationState(Boolean bool) {
            this.isActive = bool;
        }

        @Nullable
        public final Boolean isActive() {
            return this.isActive;
        }
    }

    private final void setNotificationState(NotificationState notificationState) {
        this.notificationState$delegate.setValue(this, $$delegatedProperties[0], notificationState);
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

    public AlarmSettingActivity() {
        Delegates delegates = Delegates.INSTANCE;
        NotificationState notificationState = NotificationState.INIT;
        this.notificationState$delegate = new AlarmSettingActivity$$special$$inlined$observable$1(notificationState, notificationState, this);
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
        setContentView((int) C0013R$layout.activity_alarm_setting);
        ((ImageButton) _$_findCachedViewById(C0010R$id.goBackButton)).setOnClickListener(new AlarmSettingActivity$onCreate$1(this));
        ((Switch) _$_findCachedViewById(C0010R$id.notificationStateSwitch)).setOnClickListener(new AlarmSettingActivity$onCreate$2(this));
    }

    /* access modifiers changed from: private */
    public final Unit updateNotificationStateView(Boolean bool) {
        if (bool == null) {
            return null;
        }
        boolean booleanValue = bool.booleanValue();
        Switch switchR = (Switch) _$_findCachedViewById(C0010R$id.notificationStateSwitch);
        Intrinsics.checkExpressionValueIsNotNull(switchR, "notificationStateSwitch");
        switchR.setChecked(booleanValue);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void startNotificationSettingActivity() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        if (VERSION.SDK_INT >= 26) {
            intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        } else {
            intent.putExtra("app_package", getPackageName());
            intent.putExtra("app_uid", getApplicationInfo().uid);
        }
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final Unit updateNotificationRemoteState(Boolean bool) {
        if (bool == null) {
            return null;
        }
        boolean booleanValue = bool.booleanValue();
        CompositeDisposable compositeDisposable = this.disposables;
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        Disposable subscribe = userAPI2.uploadAgreements(booleanValue).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new AlarmSettingActivity$updateNotificationRemoteState$$inlined$let$lambda$1(this), new AlarmSettingActivity$updateNotificationRemoteState$$inlined$let$lambda$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userAPI.uploadAgreements…error)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void showNotificationActiveDialog(String str) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0013R$layout.dialog_confirm2);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        View findViewById = dialog.findViewById(C0010R$id.dialog_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById<TextView>(R.id.dialog_title)");
        ((TextView) findViewById).setText("이벤트 및 마케팅 알림");
        View findViewById2 = dialog.findViewById(C0010R$id.dialog_sub);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById<TextView>(R.id.dialog_sub)");
        ((TextView) findViewById2).setText(str);
        ((TextView) dialog.findViewById(C0010R$id.ok)).setOnClickListener(new AlarmSettingActivity$showNotificationActiveDialog$1$1(dialog));
        dialog.show();
    }

    private final void getNotificationState() {
        setNotificationState(NotificationManagerCompat.from(this).areNotificationsEnabled() ? NotificationState.ACTIVE : NotificationState.INACTIVE);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getNotificationState();
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.disposables.dispose();
        super.onDestroy();
    }
}
