package kr.co.popone.fitts.feature.main;

import android.content.Intent;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.datamodel.service.alarm.AlarmCount;
import retrofit2.HttpException;

final class MainActivity$getAlarmCount$1<T1, T2> implements BiConsumer<AlarmCount, Throwable> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$getAlarmCount$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(AlarmCount alarmCount, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("alarmCountResult ");
        sb.append(alarmCount);
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.alarmCountRequest = null;
        if (alarmCount != null) {
            ((MainTabBar) this.this$0._$_findCachedViewById(C0010R$id.mainTabBar)).setNotificationBadge(alarmCount.getNew_badge_count());
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("error occured ");
        sb2.append(th);
        Logger.d(sb2.toString(), new Object[0]);
        if (!(th instanceof HttpException)) {
            Logger.d("ErrorOccur::getAlarmCount", new Object[0]);
            this.this$0.showMessage("죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this.this$0, IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.this$0.startActivity(intent);
        }
    }
}
