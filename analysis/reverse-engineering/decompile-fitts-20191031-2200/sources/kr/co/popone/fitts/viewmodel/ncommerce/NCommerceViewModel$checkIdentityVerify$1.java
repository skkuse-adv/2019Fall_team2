package kr.co.popone.fitts.viewmodel.ncommerce;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;

final class NCommerceViewModel$checkIdentityVerify$1<T> implements Consumer<MyInfo> {
    final /* synthetic */ Function0 $body;

    NCommerceViewModel$checkIdentityVerify$1(Function0 function0) {
        this.$body = function0;
    }

    public final void accept(MyInfo myInfo) {
        if (myInfo.getRequiredIdentityVerify()) {
            this.$body.invoke();
        }
    }
}
