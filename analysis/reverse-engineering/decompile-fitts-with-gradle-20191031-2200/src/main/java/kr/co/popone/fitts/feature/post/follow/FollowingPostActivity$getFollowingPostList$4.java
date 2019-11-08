package kr.co.popone.fitts.feature.post.follow;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.post.follow.FollowingPostActivity.WhenMappings;
import kr.co.popone.fitts.ui.custom.ScrollChildSwipeRefreshLayout;

final class FollowingPostActivity$getFollowingPostList$4<T> implements Observer<NetworkState> {
    final /* synthetic */ FollowingPostActivity this$0;

    FollowingPostActivity$getFollowingPostList$4(FollowingPostActivity followingPostActivity) {
        this.this$0 = followingPostActivity;
    }

    public final void onChanged(NetworkState networkState) {
        Status status;
        if (networkState != null) {
            status = networkState.getStatus();
        } else {
            status = null;
        }
        if (status != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            String str = "refreshLayout";
            if (i == 1) {
                ScrollChildSwipeRefreshLayout scrollChildSwipeRefreshLayout = (ScrollChildSwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(scrollChildSwipeRefreshLayout, str);
                scrollChildSwipeRefreshLayout.setRefreshing(true);
                return;
            } else if (i == 2) {
                ScrollChildSwipeRefreshLayout scrollChildSwipeRefreshLayout2 = (ScrollChildSwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(scrollChildSwipeRefreshLayout2, str);
                scrollChildSwipeRefreshLayout2.setRefreshing(false);
                return;
            } else if (i == 3) {
                ScrollChildSwipeRefreshLayout scrollChildSwipeRefreshLayout3 = (ScrollChildSwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(scrollChildSwipeRefreshLayout3, str);
                scrollChildSwipeRefreshLayout3.setRefreshing(false);
                ActivityExtensionKt.handleError(this.this$0, networkState.getMsg());
                return;
            }
        }
        this.this$0.getFollowingPostAdapter().updateNetworkState(networkState);
    }
}
