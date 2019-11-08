package kr.co.popone.fitts.feature.recommend.personalization;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendUserAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class PersonalizedRecommendActivity$updateUserUi$1 implements Delegate {
    final /* synthetic */ PersonalizedRecommendActivity this$0;

    PersonalizedRecommendActivity$updateUserUi$1(PersonalizedRecommendActivity personalizedRecommendActivity) {
        this.this$0 = personalizedRecommendActivity;
    }

    @NotNull
    public List<User> getUserAdapterList() {
        return PersonalizedRecommendActivity.access$getUsers$p(this.this$0);
    }

    public void onUserUiInitialized(long j, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        this.this$0.getShowRoomPostsRequest(j, recyclerView);
    }

    public void onFollowClicked(@NotNull User user, @NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(user, "data");
        Intrinsics.checkParameterIsNotNull(textView, "followButton");
        this.this$0.followButtonClicked(user, textView);
    }

    public void onPostContentClicked(@NotNull Post post, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(post, "data");
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.this$0.startPostActivity(post);
    }

    public void onProfileClicked(@NotNull User user) {
        Intrinsics.checkParameterIsNotNull(user, "data");
        this.this$0.startShowRoomActivity(user);
    }
}
