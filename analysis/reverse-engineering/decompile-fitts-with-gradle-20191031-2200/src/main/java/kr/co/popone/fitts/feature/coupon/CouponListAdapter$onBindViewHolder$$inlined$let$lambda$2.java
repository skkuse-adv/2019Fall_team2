package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;

final class CouponListAdapter$onBindViewHolder$$inlined$let$lambda$2 implements OnClickListener {
    final /* synthetic */ int $pos$inlined;
    final /* synthetic */ CouponListAdapter this$0;

    CouponListAdapter$onBindViewHolder$$inlined$let$lambda$2(CouponInfo couponInfo, int i, CouponListAdapter couponListAdapter, ViewHolder viewHolder) {
        this.$pos$inlined = i;
        this.this$0 = couponListAdapter;
    }

    public final void onClick(View view) {
        this.this$0.delegate.useButtonClicked(this.$pos$inlined);
    }
}
