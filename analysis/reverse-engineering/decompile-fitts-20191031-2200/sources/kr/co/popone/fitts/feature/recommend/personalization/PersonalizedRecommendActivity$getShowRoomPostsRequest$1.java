package kr.co.popone.fitts.feature.recommend.personalization;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.BiConsumer;
import java.util.ArrayList;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class PersonalizedRecommendActivity$getShowRoomPostsRequest$1<T1, T2> implements BiConsumer<ArrayList<Post>, Throwable> {
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ PersonalizedRecommendActivity this$0;

    PersonalizedRecommendActivity$getShowRoomPostsRequest$1(PersonalizedRecommendActivity personalizedRecommendActivity, RecyclerView recyclerView) {
        this.this$0 = personalizedRecommendActivity;
        this.$recyclerView = recyclerView;
    }

    public final void accept(ArrayList<Post> arrayList, Throwable th) {
        this.this$0.updateUserPostUi(this.$recyclerView, arrayList, th);
    }
}
