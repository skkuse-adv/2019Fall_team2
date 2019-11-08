package kr.co.popone.fitts.feature.alarm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.feature.alarm.AlarmSettingActivity.NotificationState;
import org.jetbrains.annotations.NotNull;

public final class AlarmSettingActivity$$special$$inlined$observable$1 extends ObservableProperty<NotificationState> {
    final /* synthetic */ AlarmSettingActivity this$0;

    public AlarmSettingActivity$$special$$inlined$observable$1(Object obj, Object obj2, AlarmSettingActivity alarmSettingActivity) {
        this.this$0 = alarmSettingActivity;
        super(obj2);
    }

    /* access modifiers changed from: protected */
    public void afterChange(@NotNull KProperty<?> kProperty, NotificationState notificationState, NotificationState notificationState2) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        NotificationState notificationState3 = notificationState2;
        NotificationState notificationState4 = notificationState;
        if (notificationState4 == NotificationState.INIT || notificationState4 == notificationState3) {
            this.this$0.updateNotificationStateView(notificationState3.isActive());
            return;
        }
        this.this$0.updateNotificationRemoteState(notificationState3.isActive());
        this.this$0.updateNotificationStateView(notificationState3.isActive());
    }
}
