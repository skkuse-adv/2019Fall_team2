package kr.co.popone.fitts.feature.main;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.user.UserAPI.BadgeCount;

final class MainActivity$getBadgeCount$1<T1, T2> implements BiConsumer<BadgeCount, Throwable> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$getBadgeCount$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(BadgeCount badgeCount, Throwable th) {
        if (badgeCount != null) {
            ((MainTabBar) this.this$0._$_findCachedViewById(C0010R$id.mainTabBar)).setPostableBadgeCount(badgeCount.getPostableCount());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("MainActivity::getBadgeCount=");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
