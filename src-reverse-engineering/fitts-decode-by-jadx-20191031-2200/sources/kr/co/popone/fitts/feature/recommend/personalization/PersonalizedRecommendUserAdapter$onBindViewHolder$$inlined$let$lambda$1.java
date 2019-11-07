package kr.co.popone.fitts.feature.recommend.personalization;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendUserAdapter.RecommendUserHolder;
import kr.co.popone.fitts.model.datamodel.service.user.User;

final class PersonalizedRecommendUserAdapter$onBindViewHolder$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ User $currentItem$inlined;
    final /* synthetic */ RecommendUserHolder $this_run;
    final /* synthetic */ PersonalizedRecommendUserAdapter this$0;

    PersonalizedRecommendUserAdapter$onBindViewHolder$$inlined$let$lambda$1(RecommendUserHolder recommendUserHolder, User user, PersonalizedRecommendUserAdapter personalizedRecommendUserAdapter, ViewHolder viewHolder) {
        this.$this_run = recommendUserHolder;
        this.$currentItem$inlined = user;
        this.this$0 = personalizedRecommendUserAdapter;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onFollowClicked(this.$currentItem$inlined, this.$this_run.getFollowButton());
    }
}
