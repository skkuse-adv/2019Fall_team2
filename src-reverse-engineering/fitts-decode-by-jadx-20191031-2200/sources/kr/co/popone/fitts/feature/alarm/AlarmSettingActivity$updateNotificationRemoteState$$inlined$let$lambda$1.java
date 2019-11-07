package kr.co.popone.fitts.feature.alarm;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.service.alarm.AlarmAgreement;

final class AlarmSettingActivity$updateNotificationRemoteState$$inlined$let$lambda$1<T> implements Consumer<AlarmAgreement> {
    final /* synthetic */ AlarmSettingActivity this$0;

    AlarmSettingActivity$updateNotificationRemoteState$$inlined$let$lambda$1(AlarmSettingActivity alarmSettingActivity) {
        this.this$0 = alarmSettingActivity;
    }

    public final void accept(AlarmAgreement alarmAgreement) {
        this.this$0.showNotificationActiveDialog(alarmAgreement.getMessage());
    }
}
