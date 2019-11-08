package kr.co.popone.fitts.feature.post.upload.preview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.main.MainActivity;
import kr.co.popone.fitts.model.datamodel.service.post.ImageFile;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.ResponseImageId;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.utils.Snackbar;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostPreviewActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PostPreviewActivity.class), "previewType", "getPreviewType()Lkr/co/popone/fitts/feature/post/upload/preview/PostPreviewActivity$PreviewType;"))};
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String KEY_VARIANT_INFO = StringKeyGenerator.Companion.generate(PostPreviewActivity.class, "variant_info");
    private HashMap _$_findViewCache;
    @NotNull
    public EventTracker eventTracker;
    /* access modifiers changed from: private */
    public boolean isNewPost = true;
    /* access modifiers changed from: private */
    public Disposable linkInfoRequest;
    @NotNull
    public PostAPI postAPI;
    private final Lazy previewType$delegate = LazyKt__LazyJVMKt.lazy(new PostPreviewActivity$previewType$2(this));
    /* access modifiers changed from: private */
    public boolean requiresAdditionalInfo;
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public Disposable uploadPostRequest;
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
            return PostPreviewActivity.KEY_VARIANT_INFO;
        }
    }

    public enum PreviewType {
        CreatePost,
        UpdatePost
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[PreviewType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[PreviewType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = new int[PreviewType.values().length];

        static {
            $EnumSwitchMapping$0[PreviewType.CreatePost.ordinal()] = 1;
            $EnumSwitchMapping$0[PreviewType.UpdatePost.ordinal()] = 2;
            $EnumSwitchMapping$1[PreviewType.CreatePost.ordinal()] = 1;
            $EnumSwitchMapping$1[PreviewType.UpdatePost.ordinal()] = 2;
            $EnumSwitchMapping$2[PreviewType.CreatePost.ordinal()] = 1;
            $EnumSwitchMapping$2[PreviewType.UpdatePost.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    public final PreviewType getPreviewType() {
        Lazy lazy = this.previewType$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (PreviewType) lazy.getValue();
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
    public final PostAPI getPostAPI() {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        return postAPI2;
    }

    public final void setPostAPI(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "<set-?>");
        this.postAPI = postAPI2;
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
        setContentView((int) C0013R$layout.activity_postpreview);
        Serializable serializableExtra = getIntent().getSerializableExtra("create_post_data");
        if (serializableExtra != null) {
            CreatePost createPost = (CreatePost) serializableExtra;
            createPost.getPostType();
            this.isNewPost = createPost.getCoverID() == 0;
            int i = WhenMappings.$EnumSwitchMapping$0[getPreviewType().ordinal()];
            String str = "create_post_button";
            if (i == 1) {
                Button button = (Button) _$_findCachedViewById(C0010R$id.create_post_button);
                Intrinsics.checkExpressionValueIsNotNull(button, str);
                button.setVisibility(4);
            } else if (i == 2) {
                Button button2 = (Button) _$_findCachedViewById(C0010R$id.create_post_button);
                Intrinsics.checkExpressionValueIsNotNull(button2, str);
                button2.setText("게시");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("createPost data : ");
            sb.append(createPost);
            Logger.d(sb.toString(), new Object[0]);
            Disposable disposable = this.userInfoRequest;
            if (disposable != null) {
                disposable.dispose();
            }
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            this.userInfoRequest = userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PostPreviewActivity$onCreate$1<Object,Object>(this, createPost));
            ((ImageButton) _$_findCachedViewById(C0010R$id.close_button)).setOnClickListener(new PostPreviewActivity$onCreate$2(this));
            ((Button) _$_findCachedViewById(C0010R$id.create_post_button)).setOnClickListener(new PostPreviewActivity$onCreate$3(this, createPost));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.model.post.PostAPI.CreatePost");
    }

    public void onBackPressed() {
        if (this.uploadPostRequest == null) {
            finish();
            overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
            return;
        }
        Snackbar.Companion.showMessage(this, "포스트가 작성중입니다. 잠시만 기다려 주세요");
    }

    /* access modifiers changed from: private */
    public final Part createImageMultipart(String str) {
        Part createFormData = Part.createFormData("file", str, RequestBody.create(MediaType.parse("image/jpeg"), new ImageFile(ImageFile.Companion.getTYPE_POST(), str).getFile()));
        Intrinsics.checkExpressionValueIsNotNull(createFormData, "MultipartBody.Part.creat…E_POST, imagePath).file))");
        return createFormData;
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

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.userInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        this.userInfoRequest = null;
        Disposable disposable2 = this.linkInfoRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.linkInfoRequest = null;
        Disposable disposable3 = this.uploadPostRequest;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.uploadPostRequest = null;
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str = MainActivity.PARAMETER_RETAIN_FILTER;
        String str2 = MainActivity.PARAMETER_GOTO_MY_SHOWROOM;
        String str3 = "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)";
        Boolean valueOf = Boolean.valueOf(true);
        switch (i) {
            case 100:
                if (i2 == -1) {
                    ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this, C0001R$anim.slide_up, C0001R$anim.fade_out);
                    Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, str3);
                    Intent createIntent = AnkoInternals.createIntent(this, MainActivity.class, new Pair[]{TuplesKt.to(str2, valueOf), TuplesKt.to(str, valueOf)});
                    createIntent.addFlags(67108864);
                    startActivity(createIntent, makeCustomAnimation.toBundle());
                    return;
                }
                return;
            case 101:
                ActivityOptionsCompat makeCustomAnimation2 = ActivityOptionsCompat.makeCustomAnimation(this, C0001R$anim.slide_up, C0001R$anim.fade_out);
                Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation2, str3);
                Intent createIntent2 = AnkoInternals.createIntent(this, MainActivity.class, new Pair[]{TuplesKt.to(str2, valueOf), TuplesKt.to(str, valueOf)});
                createIntent2.addFlags(67108864);
                startActivity(createIntent2, makeCustomAnimation2.toBundle());
                return;
            case 102:
                ActivityOptionsCompat makeCustomAnimation3 = ActivityOptionsCompat.makeCustomAnimation(this, C0001R$anim.slide_up, C0001R$anim.fade_out);
                Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation3, str3);
                Intent createIntent3 = AnkoInternals.createIntent(this, MainActivity.class, new Pair[]{TuplesKt.to(str2, valueOf), TuplesKt.to(str, valueOf)});
                createIntent3.addFlags(67108864);
                startActivity(createIntent3, makeCustomAnimation3.toBundle());
                return;
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }
}
