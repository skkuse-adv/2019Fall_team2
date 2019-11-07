package kr.co.popone.fitts.feature.recommend.personalization;

import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import org.simple.eventbus.EventBus;

final class PersonalizedRecommendActivity$followButtonClicked$1<T1, T2> implements BiConsumer<FollowResult, Throwable> {
    final /* synthetic */ User $data;
    final /* synthetic */ TextView $followButton;
    final /* synthetic */ PersonalizedRecommendActivity this$0;

    PersonalizedRecommendActivity$followButtonClicked$1(PersonalizedRecommendActivity personalizedRecommendActivity, TextView textView, User user) {
        this.this$0 = personalizedRecommendActivity;
        this.$followButton = textView;
        this.$data = user;
    }

    public final void accept(FollowResult followResult, Throwable th) {
        this.this$0.followingDisposable = null;
        this.$followButton.setClickable(true);
        if (followResult != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("user followed success ");
            sb.append(followResult);
            Logger.d(sb.toString(), new Object[0]);
            Message message = new Message();
            message.what = 2;
            Bundle bundle = new Bundle();
            bundle.putLong("userId", this.$data.getId());
            bundle.putBoolean("isFollowed", true);
            message.setData(bundle);
            EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
            EventBus.getDefault().post(message, AppManager.MY_MESSAGE);
            EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
            EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
            EventBus.getDefault().post(message, AppManager.FOLLOW_MESSAGE);
            this.this$0.getEventTracker$app_productionFittsRelease().logCustom("Follow", new CustomAttributes().put("from", "recommend"));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("error occured ");
        sb2.append(th);
        Logger.d(sb2.toString(), new Object[0]);
        this.$data.setFollowing(false);
        this.this$0.updateFollowButtonStateUi(this.$followButton, C0008R$drawable.round_button_follow, C0016R$string.follow, 17170443);
        this.this$0.handleError(th);
    }
}
