package kr.co.popone.fitts.feature.intro.join;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState;
import kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState.InitState;
import kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState.InvalidState;
import kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState.ValidState;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JoinActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int age;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Integer> ageObservable;
    @NotNull
    private String bodyType;
    /* access modifiers changed from: private */
    public final BehaviorSubject<String> bodyTypeObservable;
    /* access modifiers changed from: private */
    public Disposable createUserRequest;
    @NotNull
    private String email;
    /* access modifiers changed from: private */
    public Disposable emailDuplicationCheckRequest;
    /* access modifiers changed from: private */
    public final BehaviorSubject<String> emailObservable;
    @NotNull
    public EventTracker eventTracker;
    @NotNull
    private String fittsID;
    /* access modifiers changed from: private */
    public final BehaviorSubject<String> fittsIDObservable;
    /* access modifiers changed from: private */
    public final Pattern fittsIdRexPattern;
    private int height;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Integer> heightObservable;
    /* access modifiers changed from: private */
    public Disposable idDuplicationCheckRequest;
    /* access modifiers changed from: private */
    public int maxHeight;
    /* access modifiers changed from: private */
    public int maxWeight;
    /* access modifiers changed from: private */
    public int minHeight;
    /* access modifiers changed from: private */
    public int minWeight;
    /* access modifiers changed from: private */
    public String password;
    /* access modifiers changed from: private */
    public final BehaviorSubject<String> passwordObservable;
    /* access modifiers changed from: private */
    public String profileImage;
    @Nullable
    private String provider;
    @Nullable
    private String recommenderId;
    /* access modifiers changed from: private */
    public final List<String> selectedStyles = new ArrayList();
    /* access modifiers changed from: private */
    public final BehaviorSubject<List<String>> selectedStylesObservable;
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Integer> shoeSizeObservable;
    @Nullable
    private String token;
    @NotNull
    public UserAPI userAPI;
    private final CompositeDisposable viewDisposables;
    private int weight;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Integer> weightObservable;

    public static final class FilterData {
        @NotNull
        private ArrayList<Integer> height = new ArrayList<>();
        @NotNull
        private ArrayList<Integer> weight = new ArrayList<>();

        @NotNull
        public final ArrayList<Integer> getHeight() {
            return this.height;
        }

        public final void setHeight(@NotNull ArrayList<Integer> arrayList) {
            Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
            this.height = arrayList;
        }

        @NotNull
        public final ArrayList<Integer> getWeight() {
            return this.weight;
        }

        public final void setWeight(@NotNull ArrayList<Integer> arrayList) {
            Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
            this.weight = arrayList;
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

    public JoinActivity() {
        String str = "";
        BehaviorSubject<String> createDefault = BehaviorSubject.createDefault(str);
        String str2 = "BehaviorSubject.createDefault(\"\")";
        Intrinsics.checkExpressionValueIsNotNull(createDefault, str2);
        this.emailObservable = createDefault;
        BehaviorSubject<String> createDefault2 = BehaviorSubject.createDefault(str);
        Intrinsics.checkExpressionValueIsNotNull(createDefault2, str2);
        this.passwordObservable = createDefault2;
        BehaviorSubject<String> createDefault3 = BehaviorSubject.createDefault(str);
        Intrinsics.checkExpressionValueIsNotNull(createDefault3, str2);
        this.fittsIDObservable = createDefault3;
        Integer valueOf = Integer.valueOf(0);
        BehaviorSubject<Integer> createDefault4 = BehaviorSubject.createDefault(valueOf);
        String str3 = "BehaviorSubject.createDefault(0)";
        Intrinsics.checkExpressionValueIsNotNull(createDefault4, str3);
        this.weightObservable = createDefault4;
        BehaviorSubject<Integer> createDefault5 = BehaviorSubject.createDefault(valueOf);
        Intrinsics.checkExpressionValueIsNotNull(createDefault5, str3);
        this.heightObservable = createDefault5;
        BehaviorSubject<Integer> createDefault6 = BehaviorSubject.createDefault(valueOf);
        Intrinsics.checkExpressionValueIsNotNull(createDefault6, str3);
        this.shoeSizeObservable = createDefault6;
        BehaviorSubject<Integer> createDefault7 = BehaviorSubject.createDefault(valueOf);
        Intrinsics.checkExpressionValueIsNotNull(createDefault7, str3);
        this.ageObservable = createDefault7;
        BehaviorSubject<String> createDefault8 = BehaviorSubject.createDefault(str);
        Intrinsics.checkExpressionValueIsNotNull(createDefault8, str2);
        this.bodyTypeObservable = createDefault8;
        BehaviorSubject<List<String>> createDefault9 = BehaviorSubject.createDefault(this.selectedStyles);
        Intrinsics.checkExpressionValueIsNotNull(createDefault9, "BehaviorSubject.createDe…<String>>(selectedStyles)");
        this.selectedStylesObservable = createDefault9;
        this.fittsIdRexPattern = Pattern.compile("^(?=[a-zA-Z0-9]+$).{4,15}$");
        this.viewDisposables = new CompositeDisposable();
        this.email = str;
        this.fittsID = str;
        this.password = str;
        this.bodyType = str;
    }

    @NotNull
    public final EventTracker getEventTracker$app_productionFittsRelease() {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return eventTracker2;
    }

    public final void setEventTracker$app_productionFittsRelease(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "<set-?>");
        this.eventTracker = eventTracker2;
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
    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.email = str;
    }

    @Nullable
    public final String getProvider() {
        return this.provider;
    }

    public final void setProvider(@Nullable String str) {
        this.provider = str;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }

    public final void setToken(@Nullable String str) {
        this.token = str;
    }

    @NotNull
    public final String getFittsID() {
        return this.fittsID;
    }

    public final void setFittsID(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.fittsID = str;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void setWeight(int i) {
        this.weight = i;
    }

    @NotNull
    public final String getBodyType() {
        return this.bodyType;
    }

    public final void setBodyType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.bodyType = str;
    }

    @Nullable
    public final String getRecommenderId() {
        return this.recommenderId;
    }

    public final void setRecommenderId(@Nullable String str) {
        this.recommenderId = str;
    }

    /* JADX WARNING: type inference failed for: r2v58, types: [kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$38, kotlin.jvm.functions.Function1] */
    /* JADX WARNING: type inference failed for: r2v59 */
    /* JADX WARNING: type inference failed for: r3v68, types: [kr.co.popone.fitts.feature.intro.join.JoinActivity$sam$io_reactivex_functions_Function$0] */
    /* JADX WARNING: type inference failed for: r2v66 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r10) {
        /*
            r9 = this;
            dagger.android.AndroidInjection.inject(r9)
            super.onCreate(r10)
            r10 = 2131558463(0x7f0d003f, float:1.8742243E38)
            r9.setContentView(r10)
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r0 = "provider"
            java.lang.String r10 = r10.getStringExtra(r0)
            if (r10 == 0) goto L_0x0022
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r10 = r10.getStringExtra(r0)
            r9.provider = r10
        L_0x0022:
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r0 = "token"
            java.lang.String r10 = r10.getStringExtra(r0)
            if (r10 == 0) goto L_0x0038
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r10 = r10.getStringExtra(r0)
            r9.token = r10
        L_0x0038:
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r0 = "email"
            java.lang.String r10 = r10.getStringExtra(r0)
            if (r10 == 0) goto L_0x0053
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r10 = r10.getStringExtra(r0)
            java.lang.String r0 = "intent.getStringExtra(\"email\")"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r0)
            r9.email = r10
        L_0x0053:
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r0 = "profile_image"
            java.lang.String r10 = r10.getStringExtra(r0)
            if (r10 == 0) goto L_0x0069
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r10 = r10.getStringExtra(r0)
            r9.profileImage = r10
        L_0x0069:
            java.lang.String r10 = r9.email
            int r10 = r10.length()
            r0 = 1
            r1 = 0
            if (r10 != 0) goto L_0x0075
            r10 = 1
            goto L_0x0076
        L_0x0075:
            r10 = 0
        L_0x0076:
            java.lang.String r2 = "emailLayout"
            java.lang.String r3 = "emailEditText"
            r4 = 8
            java.lang.String r5 = "RxTextView.textChanges(this)"
            if (r10 == 0) goto L_0x00c2
            int r10 = kr.co.popone.fitts.C0010R$id.emailLayout
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r2)
            r10.setVisibility(r1)
            int r10 = kr.co.popone.fitts.C0010R$id.emailEditText
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.EditText r10 = (android.widget.EditText) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r3)
            r10.setVisibility(r1)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            int r2 = kr.co.popone.fitts.C0010R$id.emailEditText
            android.view.View r2 = r9._$_findCachedViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            com.jakewharton.rxbinding2.InitialValueObservable r2 = com.jakewharton.rxbinding2.widget.RxTextView.textChanges(r2)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$1 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$1
            r3.<init>(r9)
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r3)
            java.lang.String r3 = "emailEditText.textChange…          }\n            }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r2)
            goto L_0x0118
        L_0x00c2:
            android.widget.LinearLayout$LayoutParams r10 = new android.widget.LinearLayout$LayoutParams
            r6 = -1
            r7 = -2
            r10.<init>(r6, r7)
            r6 = 55
            float r6 = (float) r6
            android.content.res.Resources r7 = r9.getResources()
            java.lang.String r8 = "this.resources"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            int r7 = r7.densityDpi
            float r7 = (float) r7
            r8 = 1126170624(0x43200000, float:160.0)
            float r7 = r7 / r8
            float r6 = r6 * r7
            int r6 = (int) r6
            r10.setMargins(r1, r6, r1, r1)
            int r6 = kr.co.popone.fitts.C0010R$id.insertIDLayout
            android.view.View r6 = r9._$_findCachedViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            java.lang.String r7 = "insertIDLayout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            r6.setLayoutParams(r10)
            int r10 = kr.co.popone.fitts.C0010R$id.emailLayout
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r2)
            r10.setVisibility(r4)
            int r10 = kr.co.popone.fitts.C0010R$id.emailEditText
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.EditText r10 = (android.widget.EditText) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r3)
            r10.setVisibility(r4)
            io.reactivex.subjects.BehaviorSubject<java.lang.String> r10 = r9.emailObservable
            java.lang.String r2 = r9.email
            r10.onNext(r2)
        L_0x0118:
            java.lang.String r10 = r9.provider
            if (r10 == 0) goto L_0x0125
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0123
            goto L_0x0125
        L_0x0123:
            r10 = 0
            goto L_0x0126
        L_0x0125:
            r10 = 1
        L_0x0126:
            java.lang.String r2 = "button_next_first"
            java.lang.String r3 = "passwordInputLayout"
            java.lang.String r6 = "passwordLayout"
            if (r10 == 0) goto L_0x0190
            int r10 = kr.co.popone.fitts.C0010R$id.passwordLayout
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r6)
            r10.setVisibility(r1)
            int r10 = kr.co.popone.fitts.C0010R$id.passwordInputLayout
            android.view.View r10 = r9._$_findCachedViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r3)
            r10.setVisibility(r1)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            int r3 = kr.co.popone.fitts.C0010R$id.passwordEditText
            android.view.View r3 = r9._$_findCachedViewById(r3)
            com.google.android.material.textfield.TextInputEditText r3 = (com.google.android.material.textfield.TextInputEditText) r3
            java.lang.String r6 = "passwordEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
            com.jakewharton.rxbinding2.InitialValueObservable r3 = com.jakewharton.rxbinding2.widget.RxTextView.textChanges(r3)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r5)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$2 r6 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$2
            r6.<init>(r9)
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r6)
            java.lang.String r6 = "passwordEditText.textCha…          }\n            }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r3)
            int r10 = kr.co.popone.fitts.C0010R$id.button_next_first
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r2)
            r10.setVisibility(r1)
            int r10 = kr.co.popone.fitts.C0010R$id.button_next_firstSNS
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            java.lang.String r2 = "button_next_firstSNS"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r2)
            r10.setVisibility(r4)
            goto L_0x01ca
        L_0x0190:
            int r10 = kr.co.popone.fitts.C0010R$id.passwordLayout
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r6)
            r10.setVisibility(r4)
            int r10 = kr.co.popone.fitts.C0010R$id.passwordInputLayout
            android.view.View r10 = r9._$_findCachedViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r3)
            r10.setVisibility(r4)
            int r10 = kr.co.popone.fitts.C0010R$id.button_next_first
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r2)
            r10.setVisibility(r4)
            int r10 = kr.co.popone.fitts.C0010R$id.button_next_firstSNS
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            java.lang.String r2 = "button_next_firstSNS"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r2)
            r10.setVisibility(r1)
        L_0x01ca:
            android.os.Handler r10 = new android.os.Handler
            r10.<init>()
            int r2 = kr.co.popone.fitts.C0010R$id.emailEditText
            android.view.View r2 = r9._$_findCachedViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$3 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$3
            r3.<init>(r9, r10)
            r2.setOnFocusChangeListener(r3)
            int r2 = kr.co.popone.fitts.C0010R$id.IDEditText
            android.view.View r2 = r9._$_findCachedViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$4 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$4
            r3.<init>(r9, r10)
            r2.setOnFocusChangeListener(r3)
            int r2 = kr.co.popone.fitts.C0010R$id.passwordEditText
            android.view.View r2 = r9._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputEditText r2 = (com.google.android.material.textfield.TextInputEditText) r2
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$5 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$5
            r3.<init>(r9, r10)
            r2.setOnFocusChangeListener(r3)
            int r10 = kr.co.popone.fitts.C0010R$id.term4
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$6 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$6
            r2.<init>(r9)
            r10.setOnClickListener(r2)
            int r10 = kr.co.popone.fitts.C0010R$id.term2
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$7 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$7
            r2.<init>(r9)
            r10.setOnClickListener(r2)
            int r10 = kr.co.popone.fitts.C0010R$id.backButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$8 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$8
            r2.<init>(r9)
            r10.setOnClickListener(r2)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            int r2 = kr.co.popone.fitts.C0010R$id.IDEditText
            android.view.View r2 = r9._$_findCachedViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            java.lang.String r3 = "IDEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            com.jakewharton.rxbinding2.InitialValueObservable r2 = com.jakewharton.rxbinding2.widget.RxTextView.textChanges(r2)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$9 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$9
            r3.<init>(r9)
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r3)
            java.lang.String r3 = "IDEditText.textChanges()…}\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r2)
            int r10 = kr.co.popone.fitts.C0010R$id.button_next_first
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$10 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$10
            r2.<init>(r9)
            r10.setOnClickListener(r2)
            int r10 = kr.co.popone.fitts.C0010R$id.button_next_firstSNS
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$11 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$11
            r2.<init>(r9)
            r10.setOnClickListener(r2)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            int r2 = kr.co.popone.fitts.C0010R$id.heightEditText
            android.view.View r2 = r9._$_findCachedViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            java.lang.String r3 = "heightEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            com.jakewharton.rxbinding2.InitialValueObservable r2 = com.jakewharton.rxbinding2.widget.RxTextView.textChanges(r2)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$12 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$12
            r3.<init>(r9)
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r3)
            java.lang.String r3 = "heightEditText.textChang…)\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r2)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            int r2 = kr.co.popone.fitts.C0010R$id.weightEditText
            android.view.View r2 = r9._$_findCachedViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            java.lang.String r3 = "weightEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            com.jakewharton.rxbinding2.InitialValueObservable r2 = com.jakewharton.rxbinding2.widget.RxTextView.textChanges(r2)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$13 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$13
            r3.<init>(r9)
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r3)
            java.lang.String r3 = "weightEditText.textChang…)\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r2)
            int r10 = kr.co.popone.fitts.C0010R$id.finishBodyInfoInputButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$14 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$14
            r2.<init>(r9)
            r10.setOnClickListener(r2)
            int r10 = kr.co.popone.fitts.C0010R$id.finishBodyTypeInputButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$15 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$15
            r2.<init>(r9)
            r10.setOnClickListener(r2)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            int r2 = kr.co.popone.fitts.C0010R$id.shoeSizeInputEditText
            android.view.View r2 = r9._$_findCachedViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            java.lang.String r3 = "shoeSizeInputEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            com.jakewharton.rxbinding2.InitialValueObservable r2 = com.jakewharton.rxbinding2.widget.RxTextView.textChanges(r2)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$16 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$16
            r3.<init>(r9)
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r3)
            java.lang.String r3 = "shoeSizeInputEditText.te…)\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r2)
            int r10 = kr.co.popone.fitts.C0010R$id.finishShoeSizeInputButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$17 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$17
            r2.<init>(r9)
            r10.setOnClickListener(r2)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            io.reactivex.subjects.BehaviorSubject<java.lang.Integer> r2 = r9.shoeSizeObservable
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$18 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$18
            r3.<init>(r9)
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r3)
            java.lang.String r3 = "shoeSizeObservable.subsc…le.button_next)\n        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r2)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            int r2 = kr.co.popone.fitts.C0010R$id.ageEditText
            android.view.View r2 = r9._$_findCachedViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            java.lang.String r3 = "ageEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            com.jakewharton.rxbinding2.InitialValueObservable r2 = com.jakewharton.rxbinding2.widget.RxTextView.textChanges(r2)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$19 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$19
            r3.<init>(r9)
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r3)
            java.lang.String r3 = "ageEditText.textChanges(…)\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r2)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$styleClickListener$1 r10 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$styleClickListener$1
            r10.<init>(r9)
            r2 = 14
            android.widget.Button[] r2 = new android.widget.Button[r2]
            int r3 = kr.co.popone.fitts.C0010R$id.style1Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r1] = r3
            int r3 = kr.co.popone.fitts.C0010R$id.style2Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            r0 = 2
            int r3 = kr.co.popone.fitts.C0010R$id.style3Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            r0 = 3
            int r3 = kr.co.popone.fitts.C0010R$id.style4Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            r0 = 4
            int r3 = kr.co.popone.fitts.C0010R$id.style5Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            r0 = 5
            int r3 = kr.co.popone.fitts.C0010R$id.style6Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            r0 = 6
            int r3 = kr.co.popone.fitts.C0010R$id.style7Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            r0 = 7
            int r3 = kr.co.popone.fitts.C0010R$id.style8Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            int r0 = kr.co.popone.fitts.C0010R$id.style9Button
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r2[r4] = r0
            r0 = 9
            int r3 = kr.co.popone.fitts.C0010R$id.style10Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            r0 = 10
            int r3 = kr.co.popone.fitts.C0010R$id.style11Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            r0 = 11
            int r3 = kr.co.popone.fitts.C0010R$id.style12Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            r0 = 12
            int r3 = kr.co.popone.fitts.C0010R$id.style13Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            r0 = 13
            int r3 = kr.co.popone.fitts.C0010R$id.style14Button
            android.view.View r3 = r9._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            r2[r0] = r3
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r2)
            android.content.res.Resources r2 = r9.getResources()
            r3 = 2130903041(0x7f030001, float:1.7412889E38)
            java.lang.String[] r2 = r2.getStringArray(r3)
            java.util.Iterator r3 = r0.iterator()
        L_0x040f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x042e
            java.lang.Object r4 = r3.next()
            int r6 = r1 + 1
            if (r1 >= 0) goto L_0x0420
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x0420:
            android.widget.Button r4 = (android.widget.Button) r4
            java.lang.String r7 = "button"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r7)
            r1 = r2[r1]
            r4.setText(r1)
            r1 = r6
            goto L_0x040f
        L_0x042e:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            java.util.Iterator r0 = r0.iterator()
        L_0x0434:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x045f
            java.lang.Object r1 = r0.next()
            android.widget.Button r1 = (android.widget.Button) r1
            r1.setOnClickListener(r10)
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            boolean r2 = r1.isSelected()
            if (r2 == 0) goto L_0x045b
            java.util.List<java.lang.String> r2 = r9.selectedStyles
            java.lang.CharSequence r3 = r1.getText()
            java.lang.String r3 = r3.toString()
            r2.add(r3)
        L_0x045b:
            kr.co.popone.fitts.utils.ButtonExtensionsKt.updateStyleButton(r1)
            goto L_0x0434
        L_0x045f:
            io.reactivex.subjects.BehaviorSubject<java.util.List<java.lang.String>> r10 = r9.selectedStylesObservable
            java.util.List<java.lang.String> r0 = r9.selectedStyles
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0)
            r10.onNext(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.finishStyleInputButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$22 r0 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$22
            r0.<init>(r9)
            r10.setOnClickListener(r0)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            io.reactivex.subjects.BehaviorSubject<java.util.List<java.lang.String>> r0 = r9.selectedStylesObservable
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$23 r1 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$23
            r1.<init>(r9)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r1)
            java.lang.String r1 = "selectedStylesObservable…le.button_next)\n        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r0)
            int r10 = kr.co.popone.fitts.C0010R$id.finishAgeInputButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$24 r0 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$24
            r0.<init>(r9)
            r10.setOnClickListener(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.triangleBodyTypeButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$25 r0 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$25
            r0.<init>(r9)
            r10.setOnClickListener(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.rectangleBodyTypeButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$26 r0 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$26
            r0.<init>(r9)
            r10.setOnClickListener(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.invertedTriangleBodyTypeButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$27 r0 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$27
            r0.<init>(r9)
            r10.setOnClickListener(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.hourglassBodyTypeButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$28 r0 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$28
            r0.<init>(r9)
            r10.setOnClickListener(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.normalBodyTypeButton
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$29 r0 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$29
            r0.<init>(r9)
            r10.setOnClickListener(r0)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            io.reactivex.subjects.BehaviorSubject<java.lang.String> r0 = r9.emailObservable
            io.reactivex.subjects.BehaviorSubject<java.lang.String> r1 = r9.fittsIDObservable
            io.reactivex.subjects.BehaviorSubject<java.lang.String> r2 = r9.passwordObservable
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$30 r3 = kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$30.INSTANCE
            io.reactivex.Observable r0 = io.reactivex.Observable.combineLatest(r0, r1, r2, r3)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$31 r1 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$31
            r1.<init>(r9)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r1)
            java.lang.String r1 = "Observable.combineLatest…le.button_next)\n        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r0)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            io.reactivex.subjects.BehaviorSubject<java.lang.String> r0 = r9.emailObservable
            io.reactivex.subjects.BehaviorSubject<java.lang.String> r2 = r9.fittsIDObservable
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$32 r3 = kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$32.INSTANCE
            io.reactivex.Observable r0 = io.reactivex.Observable.combineLatest(r0, r2, r3)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$33 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$33
            r2.<init>(r9)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r0)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            io.reactivex.subjects.BehaviorSubject<java.lang.Integer> r0 = r9.weightObservable
            io.reactivex.subjects.BehaviorSubject<java.lang.Integer> r2 = r9.heightObservable
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$34 r3 = kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$34.INSTANCE
            io.reactivex.Observable r0 = io.reactivex.Observable.combineLatest(r0, r2, r3)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$35 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$35
            r2.<init>(r9)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r0)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            io.reactivex.subjects.BehaviorSubject<java.lang.String> r0 = r9.bodyTypeObservable
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$36 r1 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$36
            r1.<init>(r9)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r1)
            java.lang.String r1 = "bodyTypeObservable.subsc…le.button_next)\n        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r0)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            io.reactivex.subjects.BehaviorSubject<java.lang.Integer> r0 = r9.ageObservable
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$37 r1 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$37
            r1.<init>(r9)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r1)
            java.lang.String r1 = "ageObservable.subscribe …le.button_next)\n        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r0)
            io.reactivex.disposables.CompositeDisposable r10 = r9.viewDisposables
            int r0 = kr.co.popone.fitts.C0010R$id.viewJoinInvitation
            android.view.View r0 = r9._$_findCachedViewById(r0)
            java.lang.String r1 = "viewJoinInvitation"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r2 = kr.co.popone.fitts.C0010R$id.editInvitationCode
            android.view.View r0 = r0.findViewById(r2)
            android.widget.EditText r0 = (android.widget.EditText) r0
            java.lang.String r2 = "viewJoinInvitation.editInvitationCode"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            com.jakewharton.rxbinding2.InitialValueObservable r0 = com.jakewharton.rxbinding2.widget.RxTextView.textChanges(r0)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            io.reactivex.Scheduler r2 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Observable r0 = r0.subscribeOn(r2)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$38 r2 = kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$38.INSTANCE
            if (r2 == 0) goto L_0x05a1
            kr.co.popone.fitts.feature.intro.join.JoinActivity$sam$io_reactivex_functions_Function$0 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$sam$io_reactivex_functions_Function$0
            r3.<init>(r2)
            r2 = r3
        L_0x05a1:
            io.reactivex.functions.Function r2 = (io.reactivex.functions.Function) r2
            io.reactivex.Observable r0 = r0.map(r2)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$39 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$39
            r2.<init>(r9)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$sam$io_reactivex_functions_Function$0 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$sam$io_reactivex_functions_Function$0
            r3.<init>(r2)
            io.reactivex.Observable r0 = r0.flatMap(r3)
            io.reactivex.Scheduler r2 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Observable r0 = r0.observeOn(r2)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$40 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$40
            r2.<init>(r9)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$sam$io_reactivex_functions_Consumer$0 r3 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$sam$io_reactivex_functions_Consumer$0
            r3.<init>(r2)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$41 r2 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$41
            r2.<init>(r9)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r3, r2)
            java.lang.String r2 = "viewJoinInvitation.editI…ror(it)\n                }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r10, r0)
            int r10 = kr.co.popone.fitts.C0010R$id.viewJoinInvitation
            android.view.View r10 = r9._$_findCachedViewById(r10)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r1)
            int r0 = kr.co.popone.fitts.C0010R$id.buttonInputComplete
            android.view.View r10 = r10.findViewById(r0)
            android.widget.Button r10 = (android.widget.Button) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$42 r0 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$42
            r0.<init>(r9)
            r10.setOnClickListener(r0)
            int r10 = kr.co.popone.fitts.C0010R$id.viewJoinInvitation
            android.view.View r10 = r9._$_findCachedViewById(r10)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r1)
            int r0 = kr.co.popone.fitts.C0010R$id.buttonInputSkip
            android.view.View r10 = r10.findViewById(r0)
            android.widget.TextView r10 = (android.widget.TextView) r10
            kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$43 r0 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$onCreate$43
            r0.<init>(r9)
            r10.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.intro.join.JoinActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public final Observable<RecommenderCheckState> checkValidInvitationCode(String str) {
        if (str.length() == 0) {
            Observable<RecommenderCheckState> just = Observable.just(InitState.INSTANCE);
            Intrinsics.checkExpressionValueIsNotNull(just, "Observable.just(RecommenderCheckState.InitState)");
            return just;
        } else if (!this.fittsIdRexPattern.matcher(str).matches()) {
            Observable<RecommenderCheckState> just2 = Observable.just(InvalidState.INSTANCE);
            Intrinsics.checkExpressionValueIsNotNull(just2, "Observable.just(Recommen…rCheckState.InvalidState)");
            return just2;
        } else {
            Logger.d("getAvaliableRecommender is called", new Object[0]);
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            Observable<RecommenderCheckState> onErrorReturn = userAPI2.getAvaliableRecommender(str).subscribeOn(Schedulers.io()).toObservable().map(new JoinActivity$checkValidInvitationCode$1(this, str)).onErrorReturn(JoinActivity$checkValidInvitationCode$2.INSTANCE);
            Intrinsics.checkExpressionValueIsNotNull(onErrorReturn, "userAPI.getAvaliableReco…CheckState.InvalidState }");
            return onErrorReturn;
        }
    }

    /* access modifiers changed from: private */
    public final RecommenderCheckState handleRecommenderResult(String str, boolean z) {
        return z ? new ValidState(str) : InvalidState.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void handleRecommenderCheckState(RecommenderCheckState recommenderCheckState) {
        View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.viewJoinInvitation);
        String str = "buttonInputSkip";
        String str2 = "buttonInputComplete";
        String str3 = "textInvalidCode";
        if (recommenderCheckState instanceof InitState) {
            TextView textView = (TextView) _$_findCachedViewById.findViewById(C0010R$id.textInvalidCode);
            Intrinsics.checkExpressionValueIsNotNull(textView, str3);
            ViewExtensionsKt.gone(textView);
            Button button = (Button) _$_findCachedViewById.findViewById(C0010R$id.buttonInputComplete);
            Intrinsics.checkExpressionValueIsNotNull(button, str2);
            button.setEnabled(false);
            TextView textView2 = (TextView) _$_findCachedViewById.findViewById(C0010R$id.buttonInputSkip);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            textView2.setEnabled(true);
            this.recommenderId = null;
        } else if (recommenderCheckState instanceof InvalidState) {
            TextView textView3 = (TextView) _$_findCachedViewById.findViewById(C0010R$id.textInvalidCode);
            Intrinsics.checkExpressionValueIsNotNull(textView3, str3);
            ViewExtensionsKt.visible(textView3);
            Button button2 = (Button) _$_findCachedViewById.findViewById(C0010R$id.buttonInputComplete);
            Intrinsics.checkExpressionValueIsNotNull(button2, str2);
            button2.setEnabled(false);
            TextView textView4 = (TextView) _$_findCachedViewById.findViewById(C0010R$id.buttonInputSkip);
            Intrinsics.checkExpressionValueIsNotNull(textView4, str);
            textView4.setEnabled(true);
            this.recommenderId = null;
        } else if (recommenderCheckState instanceof ValidState) {
            TextView textView5 = (TextView) _$_findCachedViewById.findViewById(C0010R$id.textInvalidCode);
            Intrinsics.checkExpressionValueIsNotNull(textView5, str3);
            ViewExtensionsKt.gone(textView5);
            Button button3 = (Button) _$_findCachedViewById.findViewById(C0010R$id.buttonInputComplete);
            Intrinsics.checkExpressionValueIsNotNull(button3, str2);
            button3.setEnabled(true);
            TextView textView6 = (TextView) _$_findCachedViewById.findViewById(C0010R$id.buttonInputSkip);
            Intrinsics.checkExpressionValueIsNotNull(textView6, str);
            textView6.setEnabled(false);
            this.recommenderId = ((ValidState) recommenderCheckState).getCode();
        }
    }

    /* access modifiers changed from: private */
    public final void requestJoin() {
        if (this.createUserRequest == null) {
            hideKeyboard();
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C0010R$id.loadingProgressBar);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "loadingProgressBar");
            progressBar.setVisibility(0);
            FilterData filterData = new FilterData();
            filterData.getHeight().add(0, Integer.valueOf(this.height - 2));
            filterData.getHeight().add(1, Integer.valueOf(this.height + 2));
            filterData.getWeight().add(0, Integer.valueOf(this.weight - 2));
            filterData.getWeight().add(1, Integer.valueOf(this.weight + 2));
            Gson gson = new Gson();
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            String str = this.email;
            String str2 = this.provider;
            String str3 = this.token;
            String str4 = this.fittsID;
            String str5 = this.password;
            int i = this.height;
            int i2 = this.weight;
            Integer num = (Integer) this.shoeSizeObservable.getValue();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue();
            String str6 = this.bodyType;
            int i3 = this.age;
            String json = gson.toJson((Object) filterData);
            Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(bodyFilter)");
            String json2 = gson.toJson((Object) this.selectedStyles);
            Intrinsics.checkExpressionValueIsNotNull(json2, "gson.toJson(selectedStyles)");
            this.createUserRequest = userAPI2.requestCreateUser(str, str2, str3, str4, str5, i, i2, intValue, str6, i3, json, json2, this.recommenderId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new JoinActivity$requestJoin$1(this), new JoinActivity$requestJoin$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void showKeyboard() {
        if (getCurrentFocus() != null) {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).toggleSoftInput(2, 1);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    /* access modifiers changed from: private */
    public final void hideKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public void onBackPressed() {
        hideKeyboard();
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C0010R$id.idInputLayout);
        String str = "idInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, str);
        if (relativeLayout.getVisibility() == 0) {
            finish();
            overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C0010R$id.bodyInfoInputLayout);
        String str2 = "bodyInfoInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, str2);
        if (relativeLayout2.getVisibility() == 0) {
            RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(C0010R$id.idInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, str);
            relativeLayout3.setVisibility(0);
            RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(C0010R$id.bodyInfoInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout4, str2);
            relativeLayout4.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C0010R$id.bodyTypeInputLayout);
        String str3 = "bodyTypeInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, str3);
        if (constraintLayout.getVisibility() == 0) {
            RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(C0010R$id.bodyInfoInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout5, str2);
            relativeLayout5.setVisibility(0);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C0010R$id.bodyTypeInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, str3);
            constraintLayout2.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) _$_findCachedViewById(C0010R$id.shoeSizeInputLayout);
        String str4 = "shoeSizeInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, str4);
        if (constraintLayout3.getVisibility() == 0) {
            ConstraintLayout constraintLayout4 = (ConstraintLayout) _$_findCachedViewById(C0010R$id.bodyTypeInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout4, str3);
            constraintLayout4.setVisibility(0);
            ConstraintLayout constraintLayout5 = (ConstraintLayout) _$_findCachedViewById(C0010R$id.shoeSizeInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout5, str4);
            constraintLayout5.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout6 = (ConstraintLayout) _$_findCachedViewById(C0010R$id.styleInputLayout);
        String str5 = "styleInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout6, str5);
        if (constraintLayout6.getVisibility() == 0) {
            ConstraintLayout constraintLayout7 = (ConstraintLayout) _$_findCachedViewById(C0010R$id.shoeSizeInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout7, str4);
            constraintLayout7.setVisibility(0);
            ConstraintLayout constraintLayout8 = (ConstraintLayout) _$_findCachedViewById(C0010R$id.styleInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout8, str5);
            constraintLayout8.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout6 = (RelativeLayout) _$_findCachedViewById(C0010R$id.ageInputLayout);
        String str6 = "ageInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout6, str6);
        if (relativeLayout6.getVisibility() == 0) {
            ConstraintLayout constraintLayout9 = (ConstraintLayout) _$_findCachedViewById(C0010R$id.styleInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout9, str5);
            constraintLayout9.setVisibility(0);
            RelativeLayout relativeLayout7 = (RelativeLayout) _$_findCachedViewById(C0010R$id.ageInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout7, str6);
            relativeLayout7.setVisibility(8);
            return;
        }
        View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.viewJoinInvitation);
        String str7 = "viewJoinInvitation";
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, str7);
        if (_$_findCachedViewById.getVisibility() == 0) {
            View _$_findCachedViewById2 = _$_findCachedViewById(C0010R$id.viewJoinInvitation);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, str7);
            ViewExtensionsKt.gone(_$_findCachedViewById2);
            RelativeLayout relativeLayout8 = (RelativeLayout) _$_findCachedViewById(C0010R$id.ageInputLayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout8, str6);
            ViewExtensionsKt.visible(relativeLayout8);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.emailDuplicationCheckRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.idDuplicationCheckRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.createUserRequest;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.viewDisposables.dispose();
        super.onDestroy();
    }
}
