package kr.co.popone.fitts.feature.me;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import kr.co.popone.fitts.model.datamodel.service.user.BodyType;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModifyBodyActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    @NotNull
    private BodyData bodyInfo = new BodyData();
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public Disposable setUserInfoRequest;
    @NotNull
    public UserAPI userAPI;
    /* access modifiers changed from: private */
    public Disposable userInfoRequest;

    public static final class BodyData {
        @Nullable
        private String description;
        @Nullable
        private Integer height;
        @Nullable
        private String type;
        @Nullable
        private Integer weight;

        @Nullable
        public final String getType() {
            return this.type;
        }

        public final void setType(@Nullable String str) {
            this.type = str;
        }

        @Nullable
        public final Integer getWeight() {
            return this.weight;
        }

        public final void setWeight(@Nullable Integer num) {
            this.weight = num;
        }

        @Nullable
        public final Integer getHeight() {
            return this.height;
        }

        public final void setHeight(@Nullable Integer num) {
            this.height = num;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        public final void setDescription(@Nullable String str) {
            this.description = str;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[BodyType.values().length];

        static {
            $EnumSwitchMapping$0[BodyType.TRIANGLE.ordinal()] = 1;
            $EnumSwitchMapping$0[BodyType.HOURGLASS.ordinal()] = 2;
            $EnumSwitchMapping$0[BodyType.RECTANGLE.ordinal()] = 3;
            $EnumSwitchMapping$0[BodyType.INVERTED_TRIANGLE.ordinal()] = 4;
            $EnumSwitchMapping$0[BodyType.NORMAL.ordinal()] = 5;
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

    @NotNull
    public final BodyData getBodyInfo() {
        return this.bodyInfo;
    }

    public final void setBodyInfo(@NotNull BodyData bodyData) {
        Intrinsics.checkParameterIsNotNull(bodyData, "<set-?>");
        this.bodyInfo = bodyData;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_modify_body);
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(C0010R$id.triangleBodyTypeButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "triangleBodyTypeButton");
        imageButton.setSelected(false);
        ImageButton imageButton2 = (ImageButton) _$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton2, "invertedTriangleBodyTypeButton");
        imageButton2.setSelected(false);
        ImageButton imageButton3 = (ImageButton) _$_findCachedViewById(C0010R$id.hourglassBodyTypeButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton3, "hourglassBodyTypeButton");
        imageButton3.setSelected(false);
        ImageButton imageButton4 = (ImageButton) _$_findCachedViewById(C0010R$id.rectangleBodyTypeButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton4, "rectangleBodyTypeButton");
        imageButton4.setSelected(false);
        ImageButton imageButton5 = (ImageButton) _$_findCachedViewById(C0010R$id.normalBodyTypeButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton5, "normalBodyTypeButton");
        imageButton5.setSelected(false);
        ((ImageButton) _$_findCachedViewById(C0010R$id.triangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this, C0006R$color.gray3));
        ((ImageButton) _$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this, C0006R$color.gray3));
        ((ImageButton) _$_findCachedViewById(C0010R$id.hourglassBodyTypeButton)).setColorFilter(ContextCompat.getColor(this, C0006R$color.gray3));
        ((ImageButton) _$_findCachedViewById(C0010R$id.rectangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this, C0006R$color.gray3));
        ((ImageButton) _$_findCachedViewById(C0010R$id.normalBodyTypeButton)).setColorFilter(ContextCompat.getColor(this, C0006R$color.gray3));
        ((TextView) _$_findCachedViewById(C0010R$id.triangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this, C0006R$color.gray3));
        ((TextView) _$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this, C0006R$color.gray3));
        ((TextView) _$_findCachedViewById(C0010R$id.hourglassBodyTypeDesc)).setTextColor(ContextCompat.getColor(this, C0006R$color.gray3));
        ((TextView) _$_findCachedViewById(C0010R$id.rectangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this, C0006R$color.gray3));
        ((TextView) _$_findCachedViewById(C0010R$id.normalBodyTypeDesc)).setTextColor(ContextCompat.getColor(this, C0006R$color.gray3));
        ((ImageButton) _$_findCachedViewById(C0010R$id.close_button)).setOnClickListener(new ModifyBodyActivity$onCreate$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.modify_button)).setOnClickListener(new ModifyBodyActivity$onCreate$2(this));
        CompositeDisposable compositeDisposable = this.disposables;
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.profile_height);
        Intrinsics.checkExpressionValueIsNotNull(editText, "profile_height");
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        String str = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str);
        Disposable subscribe = textChanges.observeOn(Schedulers.io()).filter(ModifyBodyActivity$onCreate$3.INSTANCE).filter(ModifyBodyActivity$onCreate$4.INSTANCE).map(ModifyBodyActivity$onCreate$5.INSTANCE).observeOn(AndroidSchedulers.mainThread()).onErrorReturn(new ModifyBodyActivity$onCreate$6(this)).subscribe((Consumer<? super T>) new ModifyBodyActivity$onCreate$7<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "profile_height\n         …ht = it\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.disposables;
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.profile_weight);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "profile_weight");
        InitialValueObservable textChanges2 = RxTextView.textChanges(editText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str);
        Disposable subscribe2 = textChanges2.observeOn(Schedulers.io()).filter(ModifyBodyActivity$onCreate$8.INSTANCE).filter(ModifyBodyActivity$onCreate$9.INSTANCE).map(ModifyBodyActivity$onCreate$10.INSTANCE).onErrorReturn(new ModifyBodyActivity$onCreate$11(this)).subscribe((Consumer<? super T>) new ModifyBodyActivity$onCreate$12<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "profile_weight\n         …ht = it\n                }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        ((EditText) _$_findCachedViewById(C0010R$id.body_description)).addTextChangedListener(new ModifyBodyActivity$onCreate$13(this));
        ModifyBodyActivity$onCreate$typeClickListener$1 modifyBodyActivity$onCreate$typeClickListener$1 = new ModifyBodyActivity$onCreate$typeClickListener$1(this);
        for (ImageButton onClickListener : CollectionsKt__CollectionsKt.listOf((ImageButton) _$_findCachedViewById(C0010R$id.triangleBodyTypeButton), (ImageButton) _$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeButton), (ImageButton) _$_findCachedViewById(C0010R$id.hourglassBodyTypeButton), (ImageButton) _$_findCachedViewById(C0010R$id.rectangleBodyTypeButton), (ImageButton) _$_findCachedViewById(C0010R$id.normalBodyTypeButton))) {
            onClickListener.setOnClickListener(modifyBodyActivity$onCreate$typeClickListener$1);
        }
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(C0010R$id.topClothingSizeSeekBar);
        String str2 = "topClothingSizeSeekBar";
        Intrinsics.checkExpressionValueIsNotNull(seekBar, str2);
        seekBar.setMax(BodyInfo.Companion.getSizeList().size() - 1);
        SeekBar seekBar2 = (SeekBar) _$_findCachedViewById(C0010R$id.topClothingSizeSeekBar);
        Intrinsics.checkExpressionValueIsNotNull(seekBar2, str2);
        seekBar2.setProgress(6);
        SeekBar seekBar3 = (SeekBar) _$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar);
        String str3 = "bottomClothingSizeSeekBar";
        Intrinsics.checkExpressionValueIsNotNull(seekBar3, str3);
        seekBar3.setMax(BodyInfo.Companion.getSizeList().size() - 1);
        SeekBar seekBar4 = (SeekBar) _$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar);
        Intrinsics.checkExpressionValueIsNotNull(seekBar4, str3);
        seekBar4.setProgress(6);
        ((SeekBar) _$_findCachedViewById(C0010R$id.topClothingSizeSeekBar)).setOnSeekBarChangeListener(new ModifyBodyActivity$onCreate$15(this));
        ((SeekBar) _$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar)).setOnSeekBarChangeListener(new ModifyBodyActivity$onCreate$16(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.sizeHelpButton)).setOnClickListener(new ModifyBodyActivity$onCreate$17(this));
        getUserInfo();
    }

    public final void getUserInfo() {
        Disposable disposable = this.userInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        this.userInfoRequest = userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ModifyBodyActivity$getUserInfo$1<Object,Object>(this));
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
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.userInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.setUserInfoRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.userInfoRequest = null;
        this.setUserInfoRequest = null;
        this.disposables.dispose();
        super.onDestroy();
    }
}
