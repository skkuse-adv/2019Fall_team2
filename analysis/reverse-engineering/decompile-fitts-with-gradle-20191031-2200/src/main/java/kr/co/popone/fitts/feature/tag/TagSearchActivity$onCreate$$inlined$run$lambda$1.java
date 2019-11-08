package kr.co.popone.fitts.feature.tag;

import android.content.Intent;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat;
import com.kakao.usermgmt.StringSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.feature.tag.TagSearchPostAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.utils.ActionLogUtil;
import org.jetbrains.annotations.NotNull;

public final class TagSearchActivity$onCreate$$inlined$run$lambda$1 implements Delegate {
    final /* synthetic */ TagSearchActivity this$0;

    TagSearchActivity$onCreate$$inlined$run$lambda$1(TagSearchActivity tagSearchActivity) {
        this.this$0 = tagSearchActivity;
    }

    @NotNull
    public List<Post> getTagPosts() {
        return this.this$0.tagPostList;
    }

    public void onCoverImageClick(@NotNull Post post, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(post, "post");
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.this$0.getEventTracker$app_productionFittsRelease().logCustom("View Post", new CustomAttributes().put("from", StringSet.tag));
        ActionLogUtil.defineCurrentWindow$default(this.this$0.getActionLogUtil$app_productionFittsRelease(), "Tag", "", 0, 4, null);
        Intent intent = new Intent(this.this$0, PostActivity.class);
        intent.putExtra("post_id", post.getId());
        Image coverImage = post.getCoverImage();
        intent.putExtra("post_cover", coverImage != null ? coverImage.getUrl() : null);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        this.this$0.startActivity(intent, makeCustomAnimation.toBundle());
    }
}
