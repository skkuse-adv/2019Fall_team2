package kr.co.popone.fitts.viewmodel.ncommerce;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse;

final class NCommerceViewModel$requestNCommerceInfo$1<T> implements Consumer<UserResponse$NCommerceResponse> {
    final /* synthetic */ NCommerceViewModel this$0;

    NCommerceViewModel$requestNCommerceInfo$1(NCommerceViewModel nCommerceViewModel) {
        this.this$0 = nCommerceViewModel;
    }

    public final void accept(UserResponse$NCommerceResponse userResponse$NCommerceResponse) {
        this.this$0.getNCommerceResponseLiveData().setValue(userResponse$NCommerceResponse);
    }
}
