package kr.co.popone.fitts.feature.ncommerce;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse;

final class PointRevenueDetailFragment$onViewCreated$4<T> implements Observer<UserResponse$NCommerceResponse> {
    final /* synthetic */ PointRevenueDetailFragment this$0;

    PointRevenueDetailFragment$onViewCreated$4(PointRevenueDetailFragment pointRevenueDetailFragment) {
        this.this$0 = pointRevenueDetailFragment;
    }

    public final void onChanged(UserResponse$NCommerceResponse userResponse$NCommerceResponse) {
        PointRevenueDetailFragment pointRevenueDetailFragment = this.this$0;
        if (userResponse$NCommerceResponse == null) {
            Intrinsics.throwNpe();
        }
        pointRevenueDetailFragment.updateNCommerceInfo(userResponse$NCommerceResponse.getThisMonthNCommerce());
        this.this$0.updateLastRevenueInfo(userResponse$NCommerceResponse.getNCommerceHistory());
        this.this$0.pointRevenueTopThreeAdapter.setItems(userResponse$NCommerceResponse.getTopSharedPosts());
    }
}
