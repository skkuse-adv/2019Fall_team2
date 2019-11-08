package kr.co.popone.fitts.feature.post.detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.utils.Snackbar;
import org.simple.eventbus.EventBus;
import retrofit2.HttpException;

final class PostActivity$onActivityResult$1$$special$$inlined$let$lambda$3 implements OnClickListener {
    final /* synthetic */ TextView $this_run;
    final /* synthetic */ User $user$inlined;
    final /* synthetic */ PostActivity$onActivityResult$1 this$0;

    PostActivity$onActivityResult$1$$special$$inlined$let$lambda$3(TextView textView, User user, PostActivity$onActivityResult$1 postActivity$onActivityResult$1, Post post) {
        this.$this_run = textView;
        this.$user$inlined = user;
        this.this$0 = postActivity$onActivityResult$1;
    }

    public final void onClick(View view) {
        this.$this_run.setClickable(false);
        User access$getPostUser$p = this.this$0.this$0.postUser;
        if (access$getPostUser$p == null) {
            Intrinsics.throwNpe();
        }
        boolean isFollowing = access$getPostUser$p.isFollowing();
        if (!isFollowing) {
            if (Intrinsics.areEqual((Object) this.$user$inlined.getStatus(), (Object) "deactivated")) {
                this.$this_run.setClickable(true);
                Logger.d("user follow_deactivated", new Object[0]);
                Snackbar.Companion.showMessage(this.this$0.this$0, "탈퇴한 사용자입니다");
                return;
            }
            Disposable access$getPutFollowRequest$p = this.this$0.this$0.putFollowRequest;
            if (access$getPutFollowRequest$p != null) {
                access$getPutFollowRequest$p.dispose();
            }
            PostActivity postActivity = this.this$0.this$0;
            postActivity.putFollowRequest = postActivity.getUserAPI().putFollow(this.$user$inlined.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<FollowResult, Throwable>(this) {
                final /* synthetic */ PostActivity$onActivityResult$1$$special$$inlined$let$lambda$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(FollowResult followResult, Throwable th) {
                    this.this$0.this$0.this$0.putFollowRequest = null;
                    this.this$0.$this_run.setClickable(true);
                    if (followResult != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("user followed success ");
                        sb.append(followResult);
                        Logger.d(sb.toString(), new Object[0]);
                        Message message = new Message();
                        message.what = 2;
                        Bundle bundle = new Bundle();
                        bundle.putLong("userId", this.this$0.$user$inlined.getId());
                        bundle.putBoolean("isFollowed", true);
                        message.setData(bundle);
                        EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.MY_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.FOLLOW_MESSAGE);
                        this.this$0.this$0.this$0.getEventTracker$app_productionFittsRelease().logCustom("Follow", new CustomAttributes().put("from", "post_detail"));
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("error occured ");
                    sb2.append(th);
                    Logger.d(sb2.toString(), new Object[0]);
                    if (!(th instanceof HttpException)) {
                        Snackbar.Companion.showMessage(this.this$0.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                    } else if (((HttpException) th).code() == 401) {
                        Intent intent = new Intent(this.this$0.this$0.this$0, IntroActivity.class);
                        intent.addFlags(32768);
                        intent.addFlags(268435456);
                        this.this$0.this$0.this$0.startActivity(intent);
                    }
                }
            });
        } else if (isFollowing) {
            Disposable access$getDeleteFollowRequest$p = this.this$0.this$0.deleteFollowRequest;
            if (access$getDeleteFollowRequest$p != null) {
                access$getDeleteFollowRequest$p.dispose();
            }
            PostActivity postActivity2 = this.this$0.this$0;
            postActivity2.deleteFollowRequest = postActivity2.getUserAPI().deleteFollow(this.$user$inlined.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<FollowResult, Throwable>(this) {
                final /* synthetic */ PostActivity$onActivityResult$1$$special$$inlined$let$lambda$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(FollowResult followResult, Throwable th) {
                    this.this$0.this$0.this$0.deleteFollowRequest = null;
                    this.this$0.$this_run.setClickable(true);
                    if (followResult != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("user unfollowed success ");
                        sb.append(followResult);
                        Logger.d(sb.toString(), new Object[0]);
                        Message message = new Message();
                        message.what = 2;
                        Bundle bundle = new Bundle();
                        bundle.putLong("userId", this.this$0.$user$inlined.getId());
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
                        Snackbar.Companion.showMessage(this.this$0.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                    } else if (((HttpException) th).code() == 401) {
                        Intent intent = new Intent(this.this$0.this$0.this$0, IntroActivity.class);
                        intent.addFlags(32768);
                        intent.addFlags(268435456);
                        this.this$0.this$0.this$0.startActivity(intent);
                    }
                }
            });
        }
    }
}
