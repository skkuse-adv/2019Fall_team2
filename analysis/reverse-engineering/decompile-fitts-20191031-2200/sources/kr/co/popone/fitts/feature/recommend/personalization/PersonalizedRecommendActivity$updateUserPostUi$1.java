package kr.co.popone.fitts.feature.recommend.personalization;

import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendUserPostAdapter.Delegate;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class PersonalizedRecommendActivity$updateUserPostUi$1 implements Delegate {
    final /* synthetic */ List $posts;
    final /* synthetic */ PersonalizedRecommendActivity this$0;

    PersonalizedRecommendActivity$updateUserPostUi$1(PersonalizedRecommendActivity personalizedRecommendActivity, List list) {
        this.this$0 = personalizedRecommendActivity;
        this.$posts = list;
    }

    @NotNull
    public List<Post> getPosts() {
        return this.$posts;
    }

    public void onPostContentClicked(@NotNull Post post, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(post, "data");
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.this$0.startPostActivity(post);
    }
}
