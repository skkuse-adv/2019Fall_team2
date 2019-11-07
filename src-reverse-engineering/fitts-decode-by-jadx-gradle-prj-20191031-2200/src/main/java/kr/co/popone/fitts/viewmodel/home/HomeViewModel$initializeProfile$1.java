package kr.co.popone.fitts.viewmodel.home;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;

final class HomeViewModel$initializeProfile$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ HomeViewModel this$0;

    HomeViewModel$initializeProfile$1(HomeViewModel homeViewModel) {
        this.this$0 = homeViewModel;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        if (myInfo != null) {
            this.this$0.repository.updateSession(myInfo);
        } else {
            this.this$0.getErrorLiveData().setValue(th);
        }
    }
}
