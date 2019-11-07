package kr.co.popone.fitts.services;

import android.app.Service;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.RemoteMessage.Notification;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.event.MessagingTokenEvent;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;

public final class FittsFirebaseMessagingService extends FirebaseMessagingService {
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    public FittsNotificationHandler fittsNotificationHandler;
    @NotNull
    public FittsServiceRepository serviceRepository;
    @NotNull
    public SessionManager sessionManager;

    @NotNull
    public final FittsNotificationHandler getFittsNotificationHandler$app_productionFittsRelease() {
        FittsNotificationHandler fittsNotificationHandler2 = this.fittsNotificationHandler;
        if (fittsNotificationHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fittsNotificationHandler");
        }
        return fittsNotificationHandler2;
    }

    public final void setFittsNotificationHandler$app_productionFittsRelease(@NotNull FittsNotificationHandler fittsNotificationHandler2) {
        Intrinsics.checkParameterIsNotNull(fittsNotificationHandler2, "<set-?>");
        this.fittsNotificationHandler = fittsNotificationHandler2;
    }

    @NotNull
    public final FittsServiceRepository getServiceRepository$app_productionFittsRelease() {
        FittsServiceRepository fittsServiceRepository = this.serviceRepository;
        if (fittsServiceRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceRepository");
        }
        return fittsServiceRepository;
    }

    public final void setServiceRepository$app_productionFittsRelease(@NotNull FittsServiceRepository fittsServiceRepository) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "<set-?>");
        this.serviceRepository = fittsServiceRepository;
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

    public void onCreate() {
        AndroidInjection.inject((Service) this);
        super.onCreate();
    }

    public void onMessageReceived(@NotNull RemoteMessage remoteMessage) {
        Intrinsics.checkParameterIsNotNull(remoteMessage, "remoteMessage");
        StringBuilder sb = new StringBuilder();
        sb.append("FittsFirebaseMessagingService onMessageReceived From: ");
        sb.append(remoteMessage.getFrom());
        Logger.d(sb.toString(), new Object[0]);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Message Notification sound payload: ");
        Notification notification = remoteMessage.getNotification();
        sb2.append(notification != null ? notification.getSound() : null);
        Logger.d(sb2.toString(), new Object[0]);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("FittsFirebaseMessagingService Message data payload: ");
        sb3.append(remoteMessage.getData());
        Logger.d(sb3.toString(), new Object[0]);
        String str = (String) remoteMessage.getData().get("badge");
        String str2 = (String) remoteMessage.getData().get("url");
        String str3 = (String) remoteMessage.getData().get("callback_id");
        if (str3 != null) {
            try {
                CompositeDisposable compositeDisposable = this.disposables;
                FittsServiceRepository fittsServiceRepository = this.serviceRepository;
                if (fittsServiceRepository == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceRepository");
                }
                Disposable subscribe = fittsServiceRepository.updateNotificationFeedback(Long.parseLong(str3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(FittsFirebaseMessagingService$onMessageReceived$1.INSTANCE, FittsFirebaseMessagingService$onMessageReceived$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "serviceRepository.update…       .subscribe({}, {})");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } catch (NumberFormatException e) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("exception ");
                sb4.append(e);
                Logger.d(sb4.toString(), new Object[0]);
            }
        }
        if (str != null && str2 != null) {
            try {
                SessionManager sessionManager2 = this.sessionManager;
                if (sessionManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
                }
                sessionManager2.loadUserInfo();
                int parseInt = Integer.parseInt(str);
                FittsNotificationHandler fittsNotificationHandler2 = this.fittsNotificationHandler;
                if (fittsNotificationHandler2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fittsNotificationHandler");
                }
                fittsNotificationHandler2.handleNotification(str2, parseInt);
            } catch (NumberFormatException e2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("FittsFirebaseMessagingService exception ");
                sb5.append(e2);
                Logger.d(sb5.toString(), new Object[0]);
            }
        }
    }

    public void onNewToken(@Nullable String str) {
        super.onNewToken(str);
        EventBus.getDefault().post(new MessagingTokenEvent());
    }

    public void onDestroy() {
        this.disposables.dispose();
        super.onDestroy();
    }
}
