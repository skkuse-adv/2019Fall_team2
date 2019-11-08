package kr.co.popone.fitts.feature.showroom;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.showroom.ShowRoomAdapter.Delegate;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class ShowRoomAdapter$onBindViewHolder$9 implements OnClickListener {
    final /* synthetic */ Post $currentItem;
    final /* synthetic */ ShowRoomAdapter this$0;

    ShowRoomAdapter$onBindViewHolder$9(ShowRoomAdapter showRoomAdapter, Post post) {
        this.this$0 = showRoomAdapter;
        this.$currentItem = post;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Post post = this.$currentItem;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        access$getDelegate$p.onPostContentClicked(post, view);
    }
}
