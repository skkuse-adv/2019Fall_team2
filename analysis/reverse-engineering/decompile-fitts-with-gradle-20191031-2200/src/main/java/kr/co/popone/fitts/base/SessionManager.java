package kr.co.popone.fitts.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.orhanobut.logger.Logger;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.MyPostDeletedEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.simple.eventbus.EventBus;

public final class SessionManager {
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Editor editor;
    private SharedPreferences pref;
    private int privateMode;
    @NotNull
    public UserAPI userAPI;
    @Nullable
    private MyInfo userInfo;
    /* access modifiers changed from: private */
    public Disposable userInfoRequest;

    public static final class LoggedInEvent {
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("Fitts_Data", this.privateMode);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…s(PREF_NAME, privateMode)");
        this.pref = sharedPreferences;
        Editor edit = this.pref.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "pref.edit()");
        this.editor = edit;
        RxBus.INSTANCE.toObservable().subscribe((Consumer<? super T>) new Consumer<Object>(this) {
            final /* synthetic */ SessionManager this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Object obj) {
                if (obj instanceof MyPostDeletedEvent) {
                    this.this$0.loadUserInfo();
                }
            }
        });
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
    public final Editor getEditor() {
        return this.editor;
    }

    public final void setEditor(@NotNull Editor editor2) {
        Intrinsics.checkParameterIsNotNull(editor2, "<set-?>");
        this.editor = editor2;
    }

    @Nullable
    public final MyInfo getUserInfo() {
        return this.userInfo;
    }

    public final void setUserInfo(@Nullable MyInfo myInfo) {
        this.userInfo = myInfo;
    }

    public final boolean isLoggedIn() {
        return this.pref.getBoolean("IsLoggedIn", false);
    }

    @Nullable
    public final String getFittsID() {
        return this.pref.getString("fittsid", null);
    }

    public final long getUserID() {
        return this.pref.getLong("userid", 0);
    }

    @Nullable
    public final String getToken() {
        return this.pref.getString("fitts_token", null);
    }

    public final int getHeight() {
        return this.pref.getInt(SettingsJsonConstants.ICON_HEIGHT_KEY, -1);
    }

    public final void setHeight(int i) {
        this.editor.putInt(SettingsJsonConstants.ICON_HEIGHT_KEY, i);
        this.editor.apply();
    }

    public final int getWeight() {
        return this.pref.getInt("weight", -1);
    }

    public final void setWeight(int i) {
        this.editor.putInt("weight", i);
        this.editor.apply();
    }

    private final int getSimilarityHeightMin() {
        return this.pref.getInt("height_min_similarity", -1);
    }

    private final int getSimilarityHeightMax() {
        return this.pref.getInt("height_max_similarity", -1);
    }

    private final int getSimilarityWeightMin() {
        return this.pref.getInt("weight_min_similarity", -1);
    }

    private final int getSimilarityWeightMax() {
        return this.pref.getInt("weight_max_similarity", -1);
    }

    @NotNull
    public final String getFilter() {
        String str = "max";
        String str2 = "min";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str2, getSimilarityHeightMin());
            jSONObject2.put(str, getSimilarityHeightMax());
            jSONObject.put(SettingsJsonConstants.ICON_HEIGHT_KEY, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(str2, getSimilarityWeightMin());
            jSONObject3.put(str, getSimilarityWeightMax());
            jSONObject.put("weight", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject4 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject4, "obj.toString()");
        return jSONObject4;
    }

    public final void successLogin(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkParameterIsNotNull(str, "fittsID");
        Intrinsics.checkParameterIsNotNull(str2, "Token");
        this.editor.putBoolean("IsLoggedIn", true);
        this.editor.putLong("userid", j);
        this.editor.putString("fittsid", str);
        this.editor.putString("fitts_token", str2);
        this.editor.apply();
        EventBus.getDefault().post(new LoggedInEvent());
    }

    public final void setStoreToolTipShown(boolean z) {
        this.editor.putBoolean("is_store_tooltip_shown", z);
        this.editor.apply();
    }

    public final void setFirstAppStart(boolean z) {
        this.editor.putBoolean("IsFirstApp", z);
        this.editor.apply();
    }

    public final void setIsPostTemporary(@Nullable Long l, boolean z) {
        Editor editor2 = this.editor;
        StringBuilder sb = new StringBuilder();
        sb.append("IsSavePostTemporary");
        sb.append(l);
        editor2.putBoolean(sb.toString(), z);
        this.editor.apply();
    }

    public final boolean isPostTemporary(@Nullable Long l) {
        SharedPreferences sharedPreferences = this.pref;
        StringBuilder sb = new StringBuilder();
        sb.append("IsSavePostTemporary");
        sb.append(l);
        return sharedPreferences.getBoolean(sb.toString(), false);
    }

    @NotNull
    public final String getGetPostTemporary() {
        String string = this.pref.getString("postTemporary", "");
        Intrinsics.checkExpressionValueIsNotNull(string, "pref.getString(KEY_POST_TEMPORARY, \"\")");
        return string;
    }

    public final void setPostTemporary(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "data");
        this.editor.putString("postTemporary", str);
        this.editor.apply();
    }

    public final void setPostableProductPostTemporary(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "data");
        Editor editor2 = this.editor;
        StringBuilder sb = new StringBuilder();
        sb.append("postablePostTemporary");
        sb.append(j);
        editor2.putString(sb.toString(), str);
        this.editor.apply();
    }

    public final void setModifyPostTemporary(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "data");
        Editor editor2 = this.editor;
        StringBuilder sb = new StringBuilder();
        sb.append("modifyPostTemporary");
        sb.append(j);
        editor2.putString(sb.toString(), str);
        this.editor.apply();
    }

    public final void setFirebaseToken(@Nullable String str) {
        this.editor.putString("firebase_token", str);
        this.editor.apply();
    }

    @Nullable
    public final String getFirebaseToken() {
        return this.pref.getString("firebase_token", null);
    }

    @NotNull
    public final String getPostableProductTemporary(long j) {
        SharedPreferences sharedPreferences = this.pref;
        StringBuilder sb = new StringBuilder();
        sb.append("postablePostTemporary");
        sb.append(j);
        String string = sharedPreferences.getString(sb.toString(), "");
        Intrinsics.checkExpressionValueIsNotNull(string, "pref.getString(KEY_POSTA…EMPORARY + variantId, \"\")");
        return string;
    }

    @NotNull
    public final String getModifyPostTemporary(long j) {
        SharedPreferences sharedPreferences = this.pref;
        StringBuilder sb = new StringBuilder();
        sb.append("modifyPostTemporary");
        sb.append(j);
        String string = sharedPreferences.getString(sb.toString(), "");
        Intrinsics.checkExpressionValueIsNotNull(string, "pref.getString(KEY_MODIF…T_TEMPORARY + postId, \"\")");
        return string;
    }

    public final void loadUserInfo() {
        if (this.userInfoRequest == null) {
            Logger.d("loaduserInfo", new Object[0]);
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            this.userInfoRequest = userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new SessionManager$loadUserInfo$1<Object,Object>(this));
        }
    }

    public final void loadUserInfo(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        if (this.userInfoRequest == null) {
            Logger.d("loaduserInfo", new Object[0]);
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            this.userInfoRequest = userAPI2.getUserInfo().subscribeOn(Schedulers.io()).retry(2).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new SessionManager$loadUserInfo$2<Object,Object>(this, function0));
        }
    }

    public final void setBodyFilterAll(boolean z) {
        this.editor.putBoolean("body_filter_all", z);
        this.editor.apply();
    }

    public final void setSimilarityBodyFilter(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        if (num != null) {
            this.editor.putInt("height_min_similarity", num.intValue());
        }
        if (num2 != null) {
            this.editor.putInt("height_max_similarity", num2.intValue());
        }
        if (num3 != null) {
            this.editor.putInt("weight_min_similarity", num3.intValue());
        }
        if (num4 != null) {
            this.editor.putInt("weight_max_similarity", num4.intValue());
        }
        this.editor.apply();
    }

    public final void logout() {
        this.editor.putBoolean("IsLoggedIn", false);
        this.editor.clear();
        this.editor.apply();
    }
}
