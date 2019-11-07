package kr.co.popone.fitts.di.module;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTrackerImpl;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.LoginUserInfo;
import kr.co.popone.fitts.model.LoginUserInfoImpl;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.services.FittsNotificationHandler;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.services.FittsSchemeHandlerImpl;
import kr.co.popone.fitts.utils.ActionLogUtil;
import kr.co.popone.fitts.utils.DataHolderManager;
import org.jetbrains.annotations.NotNull;

public final class AppModule {
    private final Application application;
    private final Handler handler;

    public AppModule(@NotNull Application application2, @NotNull Handler handler2) {
        Intrinsics.checkParameterIsNotNull(application2, "application");
        Intrinsics.checkParameterIsNotNull(handler2, "handler");
        this.application = application2;
        this.handler = handler2;
    }

    @NotNull
    public final Application provideApplication() {
        return this.application;
    }

    @NotNull
    public final Gson provideGson() {
        return new Gson();
    }

    @NotNull
    public final Handler provideHandler() {
        return this.handler;
    }

    @NotNull
    public final Context provideContext() {
        return this.application;
    }

    @NotNull
    public final FittsNotificationHandler provideNotificationHandler() {
        return new FittsNotificationHandler();
    }

    @NotNull
    public final LoginUserInfo provideLoginUserInfo(@NotNull SessionManager sessionManager) {
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        return new LoginUserInfoImpl(sessionManager);
    }

    @NotNull
    public final EventTracker provideEventTracker(@NotNull FirebaseAnalytics firebaseAnalytics) {
        Intrinsics.checkParameterIsNotNull(firebaseAnalytics, "firebaseAnalytics");
        return new EventTrackerImpl(firebaseAnalytics);
    }

    @NotNull
    public final FirebaseAnalytics provideFirebaseAnalytics() {
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(this.application);
        Intrinsics.checkExpressionValueIsNotNull(instance, "FirebaseAnalytics.getInstance(application)");
        return instance;
    }

    @NotNull
    public final FittsSchemeHandler provideSchemeHandler(@NotNull EventTracker eventTracker, @NotNull FittsServiceRepository fittsServiceRepository, @NotNull CreatePostActivityUtil createPostActivityUtil) {
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(createPostActivityUtil, "createPostActivityUtil");
        return new FittsSchemeHandlerImpl(eventTracker, fittsServiceRepository, createPostActivityUtil);
    }

    @NotNull
    public final CreatePostActivityUtil provideCreatePostActivityUtil(@NotNull EventTracker eventTracker, @NotNull UserAPI userAPI, @NotNull FittsServiceRepository fittsServiceRepository, @NotNull SessionManager sessionManager) {
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(userAPI, "userAPI");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        return new CreatePostActivityUtil(sessionManager, userAPI, fittsServiceRepository, eventTracker);
    }

    @NotNull
    public final ActionLogUtil provideActionLogUtil(@NotNull ActionLogAPI actionLogAPI) {
        Intrinsics.checkParameterIsNotNull(actionLogAPI, "actionLogApi");
        return new ActionLogUtil(actionLogAPI);
    }

    @NotNull
    public final DataHolderManager provideDataHoldermanager() {
        return new DataHolderManager();
    }
}
