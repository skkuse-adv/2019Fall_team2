package kr.co.popone.fitts.feature.ncommerce;

import android.content.Intent;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.utils.ActivityAnimationType;

final class PointRevenueDetailFragment$onViewCreated$8<T> implements Observer<Post> {
    final /* synthetic */ PointRevenueDetailFragment this$0;

    PointRevenueDetailFragment$onViewCreated$8(PointRevenueDetailFragment pointRevenueDetailFragment) {
        this.this$0 = pointRevenueDetailFragment;
    }

    public final void onChanged(Post post) {
        PointRevenueDetailFragment pointRevenueDetailFragment = this.this$0;
        Intent intent = new Intent(pointRevenueDetailFragment.getContext(), PostActivity.class);
        if (post == null) {
            Intrinsics.throwNpe();
        }
        intent.putExtra("post_id", post.getId());
        Image coverImage = post.getCoverImage();
        intent.putExtra("post_cover", coverImage != null ? coverImage.getUrl() : null);
        FragmentExtensionKt.activityStart(pointRevenueDetailFragment, intent, ActivityAnimationType.SLIDE_RTOL);
    }
}
