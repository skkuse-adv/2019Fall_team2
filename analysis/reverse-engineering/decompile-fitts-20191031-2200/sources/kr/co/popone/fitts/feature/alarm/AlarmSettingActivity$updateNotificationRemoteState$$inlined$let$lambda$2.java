package kr.co.popone.fitts.feature.alarm;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class AlarmSettingActivity$updateNotificationRemoteState$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ AlarmSettingActivity this$0;

    AlarmSettingActivity$updateNotificationRemoteState$$inlined$let$lambda$2(AlarmSettingActivity alarmSettingActivity) {
        this.this$0 = alarmSettingActivity;
    }

    public final void accept(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
