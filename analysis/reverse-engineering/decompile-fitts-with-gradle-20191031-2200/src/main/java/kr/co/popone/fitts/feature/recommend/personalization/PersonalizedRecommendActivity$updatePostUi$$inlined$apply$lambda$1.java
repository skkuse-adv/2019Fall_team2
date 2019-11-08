package kr.co.popone.fitts.feature.recommend.personalization;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater.Delegate;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class PersonalizedRecommendActivity$updatePostUi$$inlined$apply$lambda$1 implements Delegate {
    final /* synthetic */ List $posts$inlined;
    final /* synthetic */ PersonalizedRecommendActivity this$0;

    PersonalizedRecommendActivity$updatePostUi$$inlined$apply$lambda$1(PersonalizedRecommendActivity personalizedRecommendActivity, GridLayoutManager gridLayoutManager, List list) {
        this.this$0 = personalizedRecommendActivity;
        this.$posts$inlined = list;
    }

    @NotNull
    public List<Post> getPostAdapterList() {
        return this.$posts$inlined;
    }

    public void onPostContentClicked(@NotNull Post post, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(post, "data");
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.this$0.startPostActivity(post);
    }
}
