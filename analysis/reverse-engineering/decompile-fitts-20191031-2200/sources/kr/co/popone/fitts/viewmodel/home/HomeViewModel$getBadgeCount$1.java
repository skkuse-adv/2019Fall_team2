package kr.co.popone.fitts.viewmodel.home;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.user.UserAPI.BadgeCount;

final class HomeViewModel$getBadgeCount$1<T1, T2> implements BiConsumer<BadgeCount, Throwable> {
    final /* synthetic */ HomeViewModel this$0;

    HomeViewModel$getBadgeCount$1(HomeViewModel homeViewModel) {
        this.this$0 = homeViewModel;
    }

    public final void accept(BadgeCount badgeCount, Throwable th) {
        if (badgeCount != null) {
            this.this$0.getCartVariantCountLiveData().setValue(Integer.valueOf(badgeCount.getCartVariantCount()));
        } else {
            this.this$0.getErrorLiveData().setValue(th);
        }
    }
}
