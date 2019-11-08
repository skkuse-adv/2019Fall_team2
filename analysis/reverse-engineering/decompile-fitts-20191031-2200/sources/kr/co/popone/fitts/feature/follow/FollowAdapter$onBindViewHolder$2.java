package kr.co.popone.fitts.feature.follow;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.follow.FollowAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.service.user.User;

final class FollowAdapter$onBindViewHolder$2 implements OnClickListener {
    final /* synthetic */ User $currentItem;
    final /* synthetic */ FollowAdapter this$0;

    FollowAdapter$onBindViewHolder$2(FollowAdapter followAdapter, User user) {
        this.this$0 = followAdapter;
        this.$currentItem = user;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        User user = this.$currentItem;
        View findViewById = view.findViewById(C0010R$id.follow_button);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "it.findViewById(R.id.follow_button)");
        access$getDelegate$p.onFollowClicked(user, findViewById);
    }
}
