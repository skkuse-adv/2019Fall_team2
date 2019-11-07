package kr.co.popone.fitts.feature.me.like;

import android.content.Intent;
import java.util.List;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.me.like.LikedPostAdapter.Delegate;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LikedActivity$onCreate$2 implements Delegate {
    final /* synthetic */ LikedActivity this$0;

    LikedActivity$onCreate$2(LikedActivity likedActivity) {
        this.this$0 = likedActivity;
    }

    public int getLikesPostCount() {
        return this.this$0.getLikeCount();
    }

    @NotNull
    public List<Post> getLikesPosts() {
        return this.this$0.postList;
    }

    public void onPostClicked(long j, @Nullable String str) {
        LikedActivity likedActivity = this.this$0;
        Intent intent = new Intent(likedActivity, PostActivity.class);
        intent.putExtra("post_id", j);
        intent.putExtra("post_cover", str);
        ContextExtensionKt.activityStart(likedActivity, intent, ActivityAnimationType.SLIDE_RTOL);
        this.this$0.getEventTracker$app_productionFittsRelease().logCustom("View Post", new CustomAttributes().put("from", "like"));
    }
}
