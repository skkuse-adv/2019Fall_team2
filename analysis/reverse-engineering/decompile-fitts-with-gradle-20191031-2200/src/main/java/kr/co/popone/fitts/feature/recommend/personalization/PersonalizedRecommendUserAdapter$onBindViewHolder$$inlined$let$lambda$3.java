package kr.co.popone.fitts.feature.recommend.personalization;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kr.co.popone.fitts.model.datamodel.service.user.User;

final class PersonalizedRecommendUserAdapter$onBindViewHolder$$inlined$let$lambda$3 implements OnClickListener {
    final /* synthetic */ User $currentItem$inlined;
    final /* synthetic */ PersonalizedRecommendUserAdapter this$0;

    PersonalizedRecommendUserAdapter$onBindViewHolder$$inlined$let$lambda$3(User user, PersonalizedRecommendUserAdapter personalizedRecommendUserAdapter, ViewHolder viewHolder) {
        this.$currentItem$inlined = user;
        this.this$0 = personalizedRecommendUserAdapter;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onProfileClicked(this.$currentItem$inlined);
    }
}
