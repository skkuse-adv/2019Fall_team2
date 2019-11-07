package kr.co.popone.fitts.feature.post;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.service.post.ImageFile;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.ResponseImageId;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProfileInputActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String KEY_VARIANT_INFO = StringKeyGenerator.Companion.generate(ProfileInputActivity.class, "variant_info");
    @NotNull
    public static final String POST_DATA_PARAM = "post_data";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable createPostRequest;
    @NotNull
    public EventTracker eventTracker;
    @NotNull
    public PostAPI postAPI;
    private CreatePost postData;
    private Disposable referralIDAvailabilityCheckRequest;
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public UserAPI userAPI;
    /* access modifiers changed from: private */
    public Disposable userInfoRequest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getKEY_VARIANT_INFO() {
            return ProfileInputActivity.KEY_VARIANT_INFO;
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
    public final PostAPI getPostAPI$app_productionFittsRelease() {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        return postAPI2;
    }

    public final void setPostAPI$app_productionFittsRelease(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "<set-?>");
        this.postAPI = postAPI2;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_profile_input);
        this.postData = (CreatePost) getIntent().getSerializableExtra(POST_DATA_PARAM);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setEnabled(false);
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        this.userInfoRequest = userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ProfileInputActivity$onCreate$1<Object,Object>(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new ProfileInputActivity$onCreate$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.confirmButton)).setOnClickListener(new ProfileInputActivity$onCreate$3(this));
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(C0010R$id.topClothingSizeSeekBar);
        String str = "topClothingSizeSeekBar";
        Intrinsics.checkExpressionValueIsNotNull(seekBar, str);
        seekBar.setMax(BodyInfo.Companion.getSizeList().size() - 1);
        SeekBar seekBar2 = (SeekBar) _$_findCachedViewById(C0010R$id.topClothingSizeSeekBar);
        Intrinsics.checkExpressionValueIsNotNull(seekBar2, str);
        seekBar2.setProgress(6);
        SeekBar seekBar3 = (SeekBar) _$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar);
        String str2 = "bottomClothingSizeSeekBar";
        Intrinsics.checkExpressionValueIsNotNull(seekBar3, str2);
        seekBar3.setMax(BodyInfo.Companion.getSizeList().size() - 1);
        SeekBar seekBar4 = (SeekBar) _$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar);
        Intrinsics.checkExpressionValueIsNotNull(seekBar4, str2);
        seekBar4.setProgress(6);
        ((SeekBar) _$_findCachedViewById(C0010R$id.topClothingSizeSeekBar)).setOnSeekBarChangeListener(new ProfileInputActivity$onCreate$4(this));
        ((SeekBar) _$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar)).setOnSeekBarChangeListener(new ProfileInputActivity$onCreate$5(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.sizeHelpButton)).setOnClickListener(new ProfileInputActivity$onCreate$6(this));
    }

    /* access modifiers changed from: private */
    public final void createPostAndUpdateAdditionalInfo() {
        if (validateFields()) {
            setInputFieldsEnabled(false);
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
            swipeRefreshLayout.setRefreshing(true);
            EditText editText = (EditText) _$_findCachedViewById(C0010R$id.bodyDescriptionEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText, "bodyDescriptionEditText");
            String obj = editText.getText().toString();
            EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.shoeSizeInputEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText2, "shoeSizeInputEditText");
            int parseInt = Integer.parseInt(editText2.getText().toString());
            EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.footDescriptionInputEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText3, "footDescriptionInputEditText");
            String obj2 = editText3.getText().toString();
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.topClothingSizeTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, "topClothingSizeTextView");
            String obj3 = textView.getText().toString();
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.bottomClothingSizeTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "bottomClothingSizeTextView");
            userAPI2.updateAdditionalInfo(null, null, obj, obj3, textView2.getText().toString(), Integer.valueOf(parseInt), obj2, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(ProfileInputActivity$createPostAndUpdateAdditionalInfo$1.INSTANCE, ProfileInputActivity$createPostAndUpdateAdditionalInfo$2.INSTANCE);
            CreatePost createPost = this.postData;
            if (createPost != null) {
                PostVariantViewData postVariantViewData = (PostVariantViewData) getIntent().getParcelableExtra(KEY_VARIANT_INFO);
                SessionManager sessionManager2 = this.sessionManager;
                if (sessionManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
                }
                sessionManager2.setIsPostTemporary(postVariantViewData != null ? Long.valueOf(postVariantViewData.getVariantId()) : null, false);
                this.createPostRequest = Observable.fromCallable(ProfileInputActivity$createPostAndUpdateAdditionalInfo$3.INSTANCE).flatMap(new ProfileInputActivity$createPostAndUpdateAdditionalInfo$4(this, createPost)).flatMap(new ProfileInputActivity$createPostAndUpdateAdditionalInfo$5(this, createPost)).flatMap(ProfileInputActivity$createPostAndUpdateAdditionalInfo$6.INSTANCE).flatMap(new ProfileInputActivity$createPostAndUpdateAdditionalInfo$7(this, createPost, postVariantViewData)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ProfileInputActivity$createPostAndUpdateAdditionalInfo$8(this), new ProfileInputActivity$createPostAndUpdateAdditionalInfo$9(this));
                return;
            }
            showPostFirstWriteNotice();
        }
    }

    public void onBackPressed() {
        setResult(0);
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    /* access modifiers changed from: private */
    public final void setInputFieldsEnabled(boolean z) {
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.bodyDescriptionEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "bodyDescriptionEditText");
        editText.setEnabled(z);
        Button button = (Button) _$_findCachedViewById(C0010R$id.confirmButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "confirmButton");
        button.setEnabled(z);
    }

    private final boolean validateFields() {
        boolean z;
        int color = ContextCompat.getColor(this, C0006R$color.neon_red);
        int color2 = ContextCompat.getColor(this, C0006R$color.gray6);
        int color3 = ContextCompat.getColor(this, C0006R$color.gray4);
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.bodyDescriptionEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "bodyDescriptionEditText");
        String str = "bodyDescriptionLabel";
        if (editText.getText().length() < 15) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.bodyDescriptionLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            Sdk27PropertiesKt.setTextColor(textView, color);
            z = false;
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.bodyDescriptionLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            Sdk27PropertiesKt.setTextColor(textView2, color2);
            z = true;
        }
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.shoeSizeInputEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "shoeSizeInputEditText");
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(editText2.getText().toString());
        String str2 = "shoeSizeInputDescription";
        String str3 = "shoeSizeInputLabel";
        if (intOrNull == null || intOrNull.intValue() < 100 || intOrNull.intValue() > 400 || intOrNull.intValue() % 5 != 0) {
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.shoeSizeInputLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView3, str3);
            Sdk27PropertiesKt.setTextColor(textView3, color);
            TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.shoeSizeInputDescription);
            Intrinsics.checkExpressionValueIsNotNull(textView4, str2);
            Sdk27PropertiesKt.setTextColor(textView4, color);
            z = false;
        } else {
            TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.shoeSizeInputLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView5, str3);
            Sdk27PropertiesKt.setTextColor(textView5, color2);
            TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.shoeSizeInputDescription);
            Intrinsics.checkExpressionValueIsNotNull(textView6, str2);
            Sdk27PropertiesKt.setTextColor(textView6, color3);
        }
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.footDescriptionInputEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "footDescriptionInputEditText");
        String str4 = "footDescriptionInputLabel";
        if (editText3.getText().length() < 8) {
            TextView textView7 = (TextView) _$_findCachedViewById(C0010R$id.footDescriptionInputLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView7, str4);
            Sdk27PropertiesKt.setTextColor(textView7, color);
            return false;
        }
        TextView textView8 = (TextView) _$_findCachedViewById(C0010R$id.footDescriptionInputLabel);
        Intrinsics.checkExpressionValueIsNotNull(textView8, str4);
        Sdk27PropertiesKt.setTextColor(textView8, color2);
        return z;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != 100) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        setResult(-1);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.userInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.createPostRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.referralIDAvailabilityCheckRequest;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public final Observable<ResponseImageId> fileUpload(Part part) {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        Observable<ResponseImageId> observeOn = postAPI2.fileUpload(part).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "postAPI.fileUpload(image…dSchedulers.mainThread())");
        return observeOn;
    }

    /* access modifiers changed from: private */
    public final Part createImageMultipart(String str) {
        Part createFormData = Part.createFormData("file", str, RequestBody.create(MediaType.parse("image/jpeg"), new ImageFile(ImageFile.Companion.getTYPE_POST(), str).getFile()));
        Intrinsics.checkExpressionValueIsNotNull(createFormData, "MultipartBody.Part.creat…E_POST, imagePath).file))");
        return createFormData;
    }

    /* access modifiers changed from: private */
    public final void showPostFirstWriteNotice() {
        startActivityForResult(AnkoInternals.createIntent(this, PostFirstWriteNoticeActivity.class, new Pair[0]), 100);
    }
}
