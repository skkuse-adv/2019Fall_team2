package kr.co.popone.fitts.feature.post.notification;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class PostDeleteNotificationDetailActivity$onCreate$3 implements OnRefreshListener {
    final /* synthetic */ PostDeleteNotificationDetailActivity this$0;

    PostDeleteNotificationDetailActivity$onCreate$3(PostDeleteNotificationDetailActivity postDeleteNotificationDetailActivity) {
        this.this$0 = postDeleteNotificationDetailActivity;
    }

    public final void onRefresh() {
        this.this$0.loadDataIfNeeded();
    }
}
