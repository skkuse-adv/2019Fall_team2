package kr.co.popone.fitts.feature.coupon;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.model.user.UserAPI.DefaultImpls;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CouponPointInputUserInfoActivity extends AppCompatActivity implements OnEditorActionListener {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Boolean> loadingSubject;
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public UserAPI userAPI;
    /* access modifiers changed from: private */
    public Disposable userInfoRegisterDisposable;

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PARAMETER_NAME = "parameters";
        @Nullable
        private final Long couponId;
        @Nullable
        private final Integer value;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                Long l = null;
                Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
                if (parcel.readInt() != 0) {
                    l = Long.valueOf(parcel.readLong());
                }
                return new Parameters(valueOf, l);
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, Integer num, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                num = parameters.value;
            }
            if ((i & 2) != 0) {
                l = parameters.couponId;
            }
            return parameters.copy(num, l);
        }

        @Nullable
        public final Integer component1() {
            return this.value;
        }

        @Nullable
        public final Long component2() {
            return this.couponId;
        }

        @NotNull
        public final Parameters copy(@Nullable Integer num, @Nullable Long l) {
            return new Parameters(num, l);
        }

        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.couponId, (java.lang.Object) r3.couponId) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.feature.coupon.CouponPointInputUserInfoActivity.Parameters
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.feature.coupon.CouponPointInputUserInfoActivity$Parameters r3 = (kr.co.popone.fitts.feature.coupon.CouponPointInputUserInfoActivity.Parameters) r3
                java.lang.Integer r0 = r2.value
                java.lang.Integer r1 = r3.value
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                java.lang.Long r0 = r2.couponId
                java.lang.Long r3 = r3.couponId
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                if (r3 == 0) goto L_0x001d
                goto L_0x001f
            L_0x001d:
                r3 = 0
                return r3
            L_0x001f:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.coupon.CouponPointInputUserInfoActivity.Parameters.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            Integer num = this.value;
            int i = 0;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            Long l = this.couponId;
            if (l != null) {
                i = l.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(value=");
            sb.append(this.value);
            sb.append(", couponId=");
            sb.append(this.couponId);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            Integer num = this.value;
            if (num != null) {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            } else {
                parcel.writeInt(0);
            }
            Long l = this.couponId;
            if (l != null) {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
                return;
            }
            parcel.writeInt(0);
        }

        public Parameters(@Nullable Integer num, @Nullable Long l) {
            this.value = num;
            this.couponId = l;
        }

        @Nullable
        public final Integer getValue() {
            return this.value;
        }

        @Nullable
        public final Long getCouponId() {
            return this.couponId;
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

    public CouponPointInputUserInfoActivity() {
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(Boolean.valueOf(false));
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(false)");
        this.loadingSubject = createDefault;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
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
        setContentView((int) C0013R$layout.activity_coupon_point_input_user_info);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setEnabled(false);
        ((TextView) _$_findCachedViewById(C0010R$id.confirmButton)).setOnClickListener(new CouponPointInputUserInfoActivity$onCreate$1(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new CouponPointInputUserInfoActivity$onCreate$2(this));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.userNameEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "userNameEditText");
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        String str = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str);
        textChanges.subscribe((Consumer<? super T>) new CouponPointInputUserInfoActivity$onCreate$3<Object>(this));
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.userPhoneEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "userPhoneEditText");
        InitialValueObservable textChanges2 = RxTextView.textChanges(editText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str);
        textChanges2.subscribe((Consumer<? super T>) new CouponPointInputUserInfoActivity$onCreate$4<Object>(this));
        this.loadingSubject.subscribe((Consumer<? super T>) new CouponPointInputUserInfoActivity$onCreate$5<Object>(this));
        ((EditText) _$_findCachedViewById(C0010R$id.userPhoneEditText)).setOnEditorActionListener(this);
    }

    public boolean onEditorAction(@Nullable TextView textView, int i, @Nullable KeyEvent keyEvent) {
        if (textView != null && textView.getId() == 2131363375 && i == 6) {
            confirmModifyUserInfo();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void confirmModifyUserInfo() {
        if (checkUserInput() && this.userInfoRegisterDisposable == null) {
            this.loadingSubject.onNext(Boolean.valueOf(true));
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            EditText editText = (EditText) _$_findCachedViewById(C0010R$id.userNameEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText, "userNameEditText");
            String obj = editText.getText().toString();
            EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.userPhoneEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText2, "userPhoneEditText");
            this.userInfoRegisterDisposable = DefaultImpls.updateAdditionalInfo$default(userAPI2, obj, editText2.getText().toString(), null, null, null, null, null, null, 128, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CouponPointInputUserInfoActivity$confirmModifyUserInfo$1(this), new CouponPointInputUserInfoActivity$confirmModifyUserInfo$2(this));
        }
    }

    private final boolean checkUserInput() {
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
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
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
