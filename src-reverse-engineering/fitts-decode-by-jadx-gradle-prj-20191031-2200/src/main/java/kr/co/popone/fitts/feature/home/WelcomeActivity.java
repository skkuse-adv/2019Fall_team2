package kr.co.popone.fitts.feature.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.utils.ScreenUtilsKt;

public final class WelcomeActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    @NotNull
    public CreatePostActivityUtil createPostActivityUtil;
    @NotNull
    public EventTracker eventTracker;
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public UserAPI userAPI;
    private Disposable userCheckRequest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
    public final CreatePostActivityUtil getCreatePostActivityUtil$app_productionFittsRelease() {
        CreatePostActivityUtil createPostActivityUtil2 = this.createPostActivityUtil;
        if (createPostActivityUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createPostActivityUtil");
        }
        return createPostActivityUtil2;
    }

    public final void setCreatePostActivityUtil$app_productionFittsRelease(@NotNull CreatePostActivityUtil createPostActivityUtil2) {
        Intrinsics.checkParameterIsNotNull(createPostActivityUtil2, "<set-?>");
        this.createPostActivityUtil = createPostActivityUtil2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_welcome);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new WelcomeActivity$onCreate$1(this));
        ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.rewardEventBannerImageView);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "rewardEventBannerImageView");
        imageView.getLayoutParams().height = MathKt__MathJVMKt.roundToInt(((float) (ScreenUtilsKt.screenWidth(this) - (ViewExtensionsKt.dpToPx((Context) this, 27) * 2))) / 4.0933332f);
        ((ImageView) _$_findCachedViewById(C0010R$id.rewardEventBannerImageView)).setOnClickListener(new WelcomeActivity$onCreate$2(this));
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        eventTracker2.customLogViewWelcomNotice();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        CreatePostActivityUtil createPostActivityUtil2 = this.createPostActivityUtil;
        if (createPostActivityUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createPostActivityUtil");
        }
        createPostActivityUtil2.clear();
        Disposable disposable = this.userCheckRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
