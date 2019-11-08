package kr.co.popone.fitts.viewmodel.store;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.user.UserAPI.BadgeCount;

final class StoreViewModel$getBadgeCount$1<T1, T2> implements BiConsumer<BadgeCount, Throwable> {
    final /* synthetic */ StoreViewModel this$0;

    StoreViewModel$getBadgeCount$1(StoreViewModel storeViewModel) {
        this.this$0 = storeViewModel;
    }

    public final void accept(BadgeCount badgeCount, Throwable th) {
        if (badgeCount != null) {
            this.this$0.getCartVariantCountLiveData().setValue(Integer.valueOf(badgeCount.getCartVariantCount()));
        } else {
            this.this$0.getErrorLiveData().setValue(th);
        }
    }
}
