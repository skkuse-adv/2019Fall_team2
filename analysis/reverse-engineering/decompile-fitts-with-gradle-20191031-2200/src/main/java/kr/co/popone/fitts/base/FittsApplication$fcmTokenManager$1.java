package kr.co.popone.fitts.base;

import androidx.core.app.NotificationCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager.LoggedInEvent;
import kr.co.popone.fitts.event.MessagingTokenEvent;
import org.jetbrains.annotations.NotNull;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

public final class FittsApplication$fcmTokenManager$1 {
    final /* synthetic */ FittsApplication this$0;

    FittsApplication$fcmTokenManager$1(FittsApplication fittsApplication) {
        this.this$0 = fittsApplication;
    }

    public final void start() {
        EventBus.getDefault().register(this);
        updateFCMTokenIfNeeded();
    }

    public final void stop() {
        EventBus.getDefault().unregister(this);
    }

    @Subscriber
    public final void loggedIn(@NotNull LoggedInEvent loggedInEvent) {
        Intrinsics.checkParameterIsNotNull(loggedInEvent, NotificationCompat.CATEGORY_EVENT);
        Logger.d("fcmTokenManager loggedIn", new Object[0]);
        updateFCMTokenIfNeeded();
    }

    @Subscriber
    public final void tokenRefreshed(@NotNull MessagingTokenEvent messagingTokenEvent) {
        Intrinsics.checkParameterIsNotNull(messagingTokenEvent, NotificationCompat.CATEGORY_EVENT);
        Logger.d("fcmTokenManager tokenRefreshed", new Object[0]);
        updateFCMTokenIfNeeded();
    }

    private final void updateFCMTokenIfNeeded() {
        Logger.d("fcmTokenManager updateFCMTokenIfNeeded", new Object[0]);
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "FirebaseInstanceId.getInstance()");
        instance.getInstanceId().addOnSuccessListener(new FittsApplication$fcmTokenManager$1$updateFCMTokenIfNeeded$1(this));
    }
}
