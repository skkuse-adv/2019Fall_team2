package kr.co.popone.fitts.feature.follow;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.user.User;

final class FollowAdapter$onBindViewHolder$1 implements OnClickListener {
    final /* synthetic */ User $currentItem;
    final /* synthetic */ FollowAdapter this$0;

    FollowAdapter$onBindViewHolder$1(FollowAdapter followAdapter, User user) {
        this.this$0 = followAdapter;
        this.$currentItem = user;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onProfileImageClick(this.$currentItem);
    }
}
