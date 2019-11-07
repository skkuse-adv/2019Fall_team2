package kr.co.popone.fitts.feature.common.fittie;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.model.view.FittieFollowViewData;

final class FittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$2 implements OnClickListener {
    final /* synthetic */ FittieFollowViewData $this_run;
    final /* synthetic */ View $this_with$inlined;

    FittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$2(FittieFollowViewData fittieFollowViewData, View view, FittieHorizontalFeedViewHolder fittieHorizontalFeedViewHolder, FittieFollowViewData fittieFollowViewData2, boolean z) {
        this.$this_run = fittieFollowViewData;
        this.$this_with$inlined = view;
    }

    public final void onClick(View view) {
        ShowRoomActivity.Companion.start(this.$this_with$inlined.getContext(), Long.valueOf(this.$this_run.getId()), "search");
    }
}
