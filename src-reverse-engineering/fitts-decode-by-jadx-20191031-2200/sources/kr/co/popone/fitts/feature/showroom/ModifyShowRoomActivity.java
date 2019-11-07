package kr.co.popone.fitts.feature.showroom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.model.user.UserAPI.DefaultImpls;
import kr.co.popone.fitts.utils.Snackbar;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModifyShowRoomActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ModifyShowRoomActivity.class), "styles", "getStyles()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ModifyShowRoomActivity.class), "styleButtons", "getStyleButtons()Ljava/util/List;"))};
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Set<String> selectedStyles = new LinkedHashSet();
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public Disposable setShowroomInfoRequest;
    /* access modifiers changed from: private */
    public Disposable showroomInfoRequest;
    private final Lazy styleButtons$delegate = LazyKt__LazyJVMKt.lazy(new ModifyShowRoomActivity$styleButtons$2(this));
    private final Lazy styles$delegate = LazyKt__LazyJVMKt.lazy(new ModifyShowRoomActivity$styles$2(this));
    @NotNull
    public UserAPI userAPI;

    /* access modifiers changed from: private */
    public final List<Button> getStyleButtons() {
        Lazy lazy = this.styleButtons$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (List) lazy.getValue();
    }

    /* access modifiers changed from: private */
    public final List<String> getStyles() {
        Lazy lazy = this.styles$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (List) lazy.getValue();
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
        setContentView((int) C0013R$layout.activity_modify_showroom);
        getUserInfo();
        ((ImageButton) _$_findCachedViewById(C0010R$id.close_button)).setOnClickListener(new ModifyShowRoomActivity$onCreate$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.modify_profile_button)).setOnClickListener(new ModifyShowRoomActivity$onCreate$2(this));
        ModifyShowRoomActivity$onCreate$styleClickListener$1 modifyShowRoomActivity$onCreate$styleClickListener$1 = new ModifyShowRoomActivity$onCreate$styleClickListener$1(this);
        int i = 0;
        for (Object next : getStyles()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Button button = (Button) getStyleButtons().get(i);
            button.setText((String) next);
            button.setOnClickListener(modifyShowRoomActivity$onCreate$styleClickListener$1);
            i = i2;
        }
    }

    public final void getUserInfo() {
        Disposable disposable = this.showroomInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        this.showroomInfoRequest = userAPI2.requestShowRoomInfo(Long.valueOf(sessionManager2.getUserID())).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ModifyShowRoomActivity$getUserInfo$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final void modifyShowRoom() {
        if (this.selectedStyles.isEmpty()) {
            Snackbar.Companion.showMessage(this, "스타일을 1개 이상 선택해주세요");
            return;
        }
        Button button = (Button) _$_findCachedViewById(C0010R$id.modify_profile_button);
        Intrinsics.checkExpressionValueIsNotNull(button, "modify_profile_button");
        button.setEnabled(false);
        Disposable disposable = this.setShowroomInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        String json = new Gson().toJson((Object) CollectionsKt___CollectionsKt.toList(this.selectedStyles));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.showroom_intro);
        Intrinsics.checkExpressionValueIsNotNull(editText, "showroom_intro");
        this.setShowroomInfoRequest = DefaultImpls.setUserInfo$default(userAPI2, null, null, json, editText.getText().toString(), null, null, null, null, DimensionsKt.HDPI, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ModifyShowRoomActivity$modifyShowRoom$1<Object,Object>(this));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.showroomInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.setShowroomInfoRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onDestroy();
    }
}
