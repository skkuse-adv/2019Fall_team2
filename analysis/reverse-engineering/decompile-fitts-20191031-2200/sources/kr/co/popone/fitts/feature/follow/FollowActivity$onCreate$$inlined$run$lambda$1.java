package kr.co.popone.fitts.feature.follow;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.follow.FollowAdapter.Delegate;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.utils.Snackbar;
import org.jetbrains.annotations.NotNull;
import org.simple.eventbus.EventBus;
import retrofit2.HttpException;

public final class FollowActivity$onCreate$$inlined$run$lambda$1 implements Delegate {
    final /* synthetic */ FollowActivity this$0;

    FollowActivity$onCreate$$inlined$run$lambda$1(FollowActivity followActivity) {
        this.this$0 = followActivity;
    }

    public boolean shouldShowFollowButton(int i) {
        return ((User) this.this$0.userList.get(i)).getId() != this.this$0.getSessionManager$app_productionFittsRelease().getUserID();
    }

    public int getGetFollowCount() {
        return this.this$0.followCount;
    }

    @NotNull
    public List<User> getFollowUsers() {
        return this.this$0.userList;
    }

    public void onProfileImageClick(@NotNull User user) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        ShowRoomActivity.Companion.start(this.this$0, Long.valueOf(user.getId()), FollowActivity.access$getParameters$p(this.this$0).isFollowing() ? "following" : "follower");
    }

    public void onFollowClicked(@NotNull final User user, @NotNull final View view) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        Intrinsics.checkParameterIsNotNull(view, "followButton");
        view.setClickable(false);
        boolean isFollowing = user.isFollowing();
        if (!isFollowing) {
            Disposable access$getPutFollowRequest$p = this.this$0.putFollowRequest;
            if (access$getPutFollowRequest$p != null) {
                access$getPutFollowRequest$p.dispose();
            }
            FollowActivity followActivity = this.this$0;
            followActivity.putFollowRequest = followActivity.getUserAPI$app_productionFittsRelease().putFollow(user.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<FollowResult, Throwable>(this) {
                final /* synthetic */ FollowActivity$onCreate$$inlined$run$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(FollowResult followResult, Throwable th) {
                    this.this$0.this$0.putFollowRequest = null;
                    view.setClickable(true);
                    if (followResult != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("user followed success ");
                        sb.append(followResult);
                        Logger.d(sb.toString(), new Object[0]);
                        Message message = new Message();
                        message.what = 2;
                        Bundle bundle = new Bundle();
                        bundle.putLong("userId", user.getId());
                        bundle.putBoolean("isFollowed", true);
                        message.setData(bundle);
                        EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.MY_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.FOLLOW_MESSAGE);
                        this.this$0.this$0.getEventTracker$app_productionFittsRelease().logCustom("Follow", new CustomAttributes().put("from", FollowActivity.access$getParameters$p(this.this$0.this$0).isFollowing() ? "following_list" : "follower_list"));
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("error occured ");
                    sb2.append(th);
                    Logger.d(sb2.toString(), new Object[0]);
                    if (!(th instanceof HttpException)) {
                        Snackbar.Companion.showMessage(this.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                    } else if (((HttpException) th).code() == 401) {
                        Intent intent = new Intent(this.this$0.this$0, IntroActivity.class);
                        intent.addFlags(32768);
                        intent.addFlags(268435456);
                        this.this$0.this$0.startActivity(intent);
                    }
                }
            });
        } else if (isFollowing) {
            Disposable access$getDeleteFollowRequest$p = this.this$0.deleteFollowRequest;
            if (access$getDeleteFollowRequest$p != null) {
                access$getDeleteFollowRequest$p.dispose();
            }
            FollowActivity followActivity2 = this.this$0;
            followActivity2.deleteFollowRequest = followActivity2.getUserAPI$app_productionFittsRelease().deleteFollow(user.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<FollowResult, Throwable>(this) {
                final /* synthetic */ FollowActivity$onCreate$$inlined$run$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(FollowResult followResult, Throwable th) {
                    this.this$0.this$0.deleteFollowRequest = null;
                    view.setClickable(true);
                    if (followResult != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("user unfollowed success ");
                        sb.append(followResult);
                        Logger.d(sb.toString(), new Object[0]);
                        Message message = new Message();
                        message.what = 2;
                        Bundle bundle = new Bundle();
                        bundle.putLong("userId", user.getId());
                        bundle.putBoolean("isFollowed", false);
                        message.setData(bundle);
                        EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.MY_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.FOLLOW_MESSAGE);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("error occured ");
                    sb2.append(th);
                    Logger.d(sb2.toString(), new Object[0]);
                    if (!(th instanceof HttpException)) {
                        Snackbar.Companion.showMessage(this.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                    } else if (((HttpException) th).code() == 401) {
                        Intent intent = new Intent(this.this$0.this$0, IntroActivity.class);
                        intent.addFlags(32768);
                        intent.addFlags(268435456);
                        this.this$0.this$0.startActivity(intent);
                    }
                }
            });
        }
    }
}
