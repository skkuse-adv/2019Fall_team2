package kr.co.popone.fitts.viewmodel.ncommerce;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.social.point.PointInfo;

final class NCommerceViewModel$requestFittsPointInfo$1<T> implements Consumer<PointInfo> {
    final /* synthetic */ NCommerceViewModel this$0;

    NCommerceViewModel$requestFittsPointInfo$1(NCommerceViewModel nCommerceViewModel) {
        this.this$0 = nCommerceViewModel;
    }

    public final void accept(PointInfo pointInfo) {
        this.this$0.getRewardPointsResultLiveData().setValue(pointInfo);
    }
}
