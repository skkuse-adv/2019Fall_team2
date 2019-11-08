package kr.co.popone.fitts.viewmodel.order;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;

final class OrderViewModel$membershipStateChanged$$inlined$with$lambda$3<T> implements Consumer<Throwable> {
    final /* synthetic */ OrderViewModel this$0;

    OrderViewModel$membershipStateChanged$$inlined$with$lambda$3(OrderViewModel orderViewModel, Membership membership) {
        this.this$0 = orderViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0._toastTextLiveData.setValue("멤버십을 이용하실수 없습니다");
    }
}
