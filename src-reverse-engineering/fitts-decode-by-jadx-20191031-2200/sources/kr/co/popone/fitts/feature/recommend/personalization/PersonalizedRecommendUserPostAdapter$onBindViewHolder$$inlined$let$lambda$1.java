package kr.co.popone.fitts.feature.recommend.personalization;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendUserPostAdapter.Delegate;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendUserPostAdapter.RecommendUserSubHolder;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class PersonalizedRecommendUserPostAdapter$onBindViewHolder$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ Post $currentItem$inlined;
    final /* synthetic */ RecommendUserSubHolder $this_run;
    final /* synthetic */ PersonalizedRecommendUserPostAdapter this$0;

    PersonalizedRecommendUserPostAdapter$onBindViewHolder$$inlined$let$lambda$1(RecommendUserSubHolder recommendUserSubHolder, Post post, PersonalizedRecommendUserPostAdapter personalizedRecommendUserPostAdapter, ViewHolder viewHolder) {
        this.$this_run = recommendUserSubHolder;
        this.$currentItem$inlined = post;
        this.this$0 = personalizedRecommendUserPostAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Post post = this.$currentItem$inlined;
        View view2 = this.$this_run.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
        access$getDelegate$p.onPostContentClicked(post, view2);
    }
}
