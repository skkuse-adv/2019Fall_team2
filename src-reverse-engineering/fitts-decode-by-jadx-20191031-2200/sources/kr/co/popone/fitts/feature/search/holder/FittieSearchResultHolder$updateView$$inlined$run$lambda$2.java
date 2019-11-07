package kr.co.popone.fitts.feature.search.holder;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.user.User;

final class FittieSearchResultHolder$updateView$$inlined$run$lambda$2 implements OnClickListener {
    final /* synthetic */ User $this_run;
    final /* synthetic */ FittieSearchResultHolder this$0;

    FittieSearchResultHolder$updateView$$inlined$run$lambda$2(User user, FittieSearchResultHolder fittieSearchResultHolder) {
        this.$this_run = user;
        this.this$0 = fittieSearchResultHolder;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().onFollowClick(this.$this_run.getId(), this.$this_run.isFollowing());
    }
}
