package kr.co.popone.fitts.feature.recommend.personalization;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater.Delegate;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater.RecommandedHolder;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class PersonalizedRecommendPostAdpater$onBindViewHolder$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ Post $currentItem$inlined;
    final /* synthetic */ RecommandedHolder $this_run;
    final /* synthetic */ PersonalizedRecommendPostAdpater this$0;

    PersonalizedRecommendPostAdpater$onBindViewHolder$$inlined$let$lambda$1(RecommandedHolder recommandedHolder, Post post, PersonalizedRecommendPostAdpater personalizedRecommendPostAdpater, ViewHolder viewHolder) {
        this.$this_run = recommandedHolder;
        this.$currentItem$inlined = post;
        this.this$0 = personalizedRecommendPostAdpater;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Post post = this.$currentItem$inlined;
        View view2 = this.$this_run.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
        access$getDelegate$p.onPostContentClicked(post, view2);
    }
}
