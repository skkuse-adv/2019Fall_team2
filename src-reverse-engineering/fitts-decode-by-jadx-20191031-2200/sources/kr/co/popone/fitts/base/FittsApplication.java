package kr.co.popone.fitts.base;

import android.app.Activity;
import android.app.Service;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import androidx.multidex.MultiDexApplication;
import com.bumptech.glide.Glide;
import com.crashlytics.android.Crashlytics.Builder;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.CrashlyticsCore;
import com.kakao.auth.KakaoSDK;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;
import io.fabric.sdk.android.Fabric;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.di.component.DaggerAppComponent;
import kr.co.popone.fitts.di.module.AppModule;
import kr.co.popone.fitts.di.module.GlobeConfigModule;
import kr.co.popone.fitts.di.module.ServiceModule;
import kr.co.popone.fitts.feature.appreview.AppReview;
import kr.co.popone.fitts.feature.intro.join.KakaoSDKAdapter;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;

public final class FittsApplication extends MultiDexApplication implements HasActivityInjector, HasServiceInjector {
    @NotNull
    private final String SAVED_FLAG_APP_VERSION = "app_version";
    @NotNull
    public DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @NotNull
    public DispatchingAndroidInjector<Service> dispatchingServiceInjector;
    private final FittsApplication$fcmTokenManager$1 fcmTokenManager = new FittsApplication$fcmTokenManager$1(this);
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public UserAPI userAPI;

    @NotNull
    public AndroidInjector<Service> serviceInjector() {
        DispatchingAndroidInjector<Service> dispatchingAndroidInjector2 = this.dispatchingServiceInjector;
        if (dispatchingAndroidInjector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatchingServiceInjector");
        }
        return dispatchingAndroidInjector2;
    }

    @NotNull
    public AndroidInjector<Activity> activityInjector() {
        DispatchingAndroidInjector<Activity> dispatchingAndroidInjector2 = this.dispatchingAndroidInjector;
        if (dispatchingAndroidInjector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatchingAndroidInjector");
        }
        return dispatchingAndroidInjector2;
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
    public final DispatchingAndroidInjector<Activity> getDispatchingAndroidInjector$app_productionFittsRelease() {
        DispatchingAndroidInjector<Activity> dispatchingAndroidInjector2 = this.dispatchingAndroidInjector;
        if (dispatchingAndroidInjector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatchingAndroidInjector");
        }
        return dispatchingAndroidInjector2;
    }

    public final void setDispatchingAndroidInjector$app_productionFittsRelease(@NotNull DispatchingAndroidInjector<Activity> dispatchingAndroidInjector2) {
        Intrinsics.checkParameterIsNotNull(dispatchingAndroidInjector2, "<set-?>");
        this.dispatchingAndroidInjector = dispatchingAndroidInjector2;
    }

    @NotNull
    public final DispatchingAndroidInjector<Service> getDispatchingServiceInjector$app_productionFittsRelease() {
        DispatchingAndroidInjector<Service> dispatchingAndroidInjector2 = this.dispatchingServiceInjector;
        if (dispatchingAndroidInjector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatchingServiceInjector");
        }
        return dispatchingAndroidInjector2;
    }

    public final void setDispatchingServiceInjector$app_productionFittsRelease(@NotNull DispatchingAndroidInjector<Service> dispatchingAndroidInjector2) {
        Intrinsics.checkParameterIsNotNull(dispatchingAndroidInjector2, "<set-?>");
        this.dispatchingServiceInjector = dispatchingAndroidInjector2;
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
    public final String getSAVED_FLAG_APP_VERSION() {
        return this.SAVED_FLAG_APP_VERSION;
    }

    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().appModule(new AppModule(this, new Handler())).globeConfigModule(getGlobeConfigModule()).serviceModule(new ServiceModule()).build().inject(this);
        Logger.addLogAdapter(new FittsApplication$onCreate$1());
        KakaoSDK.init(new KakaoSDKAdapter(this));
        Fabric.with(this, new Builder().core(new CrashlyticsCore.Builder().disabled(false).build()).build(), new Answers());
        AppReview.INSTANCE.init(this);
        this.fcmTokenManager.start();
        checkAppVersion();
    }

    public void onTerminate() {
        this.fcmTokenManager.stop();
        super.onTerminate();
    }

    private final void checkAppVersion() {
        String str = "PreferenceManager.getDef…ltSharedPreferences(this)";
        try {
            String str2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, str);
            String string = defaultSharedPreferences.getString(this.SAVED_FLAG_APP_VERSION, null);
            if (str2 != null && (!Intrinsics.areEqual((Object) string, (Object) str2))) {
                SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(this);
                Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences2, str);
                defaultSharedPreferences2.edit().putString(this.SAVED_FLAG_APP_VERSION, str2).apply();
            }
        } catch (Exception unused) {
            Logger.d("App version check failed", new Object[0]);
        }
    }

    private final GlobeConfigModule getGlobeConfigModule() {
        return GlobeConfigModule.Companion.builder("https://fitts.co.kr/").globeHttpHandler(new FittsApplication$getGlobeConfigModule$1(this)).build();
    }

    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Glide.get(this).trimMemory(i);
    }
}
