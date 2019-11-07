package kr.co.popone.fitts.feature.recommend.personalization;

import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;
import kr.co.popone.fitts.model.datamodel.service.user.User;

final class PersonalizedRecommendActivity$followButtonClicked$2<T1, T2> implements BiConsumer<FollowResult, Throwable> {
    final /* synthetic */ User $data;
    final /* synthetic */ TextView $followButton;
    final /* synthetic */ PersonalizedRecommendActivity this$0;

    PersonalizedRecommendActivity$followButtonClicked$2(PersonalizedRecommendActivity personalizedRecommendActivity, TextView textView, User user) {
        this.this$0 = personalizedRecommendActivity;
        this.$followButton = textView;
        this.$data = user;
    }

    public final void accept(FollowResult followResult, Throwable th) {
        this.this$0.unfollowingDisposable = null;
        this.$followButton.setClickable(true);
        if (followResult != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("user unfollowed success ");
            sb.append(followResult);
            Logger.d(sb.toString(), new Object[0]);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("error occured ");
        sb2.append(th);
        Logger.d(sb2.toString(), new Object[0]);
        this.$data.setFollowing(true);
        this.this$0.updateFollowButtonStateUi(this.$followButton, C0008R$drawable.round_button_following, C0016R$string.following, C0006R$color.gray4);
        this.this$0.handleError(th);
    }
}
