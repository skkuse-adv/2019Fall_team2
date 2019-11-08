package kr.co.popone.fitts.viewmodel.ncommerce;

import io.reactivex.functions.Consumer;

final class NCommerceViewModel$checkIdentityVerify$2<T> implements Consumer<Throwable> {
    final /* synthetic */ NCommerceViewModel this$0;

    NCommerceViewModel$checkIdentityVerify$2(NCommerceViewModel nCommerceViewModel) {
        this.this$0 = nCommerceViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
