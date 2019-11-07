package kr.co.popone.fitts.feature.showroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.kakao.message.template.MessageTemplateProtocol;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.feature.appreview.AppReview;
import kr.co.popone.fitts.feature.comment.CommentsActivity;
import kr.co.popone.fitts.feature.follow.FollowActivity;
import kr.co.popone.fitts.feature.follow.FollowActivity.Parameters;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.feature.me.ModifyProfileActivity;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.feature.showroom.ShowRoomAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.datamodel.service.post.ImageFile;
import kr.co.popone.fitts.model.datamodel.service.post.LikeResult;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.utils.Snackbar;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import photopicker.view.ImageSelectorActivity;
import photopicker.view.ImageSelectorActivity.Companion;
import retrofit2.HttpException;

public final class ShowRoomActivity$onCreate$$inlined$run$lambda$1 implements Delegate {
    final /* synthetic */ RecyclerView $this_run;
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$onCreate$$inlined$run$lambda$1(RecyclerView recyclerView, ShowRoomActivity showRoomActivity) {
        this.$this_run = recyclerView;
        this.this$0 = showRoomActivity;
    }

    @Nullable
    public ShowRoom getUserInfo() {
        return this.this$0.showRoomInfo;
    }

    public boolean isLinearView() {
        return this.this$0.isLinear();
    }

    @NotNull
    public SessionManager getAdapterSessionManager() {
        return this.this$0.getSessionManager$app_productionFittsRelease();
    }

    @NotNull
    public List<Post> getShowRoomPostList() {
        return this.this$0.postList;
    }

    public void onModifyProfileImageClicked() {
        Companion companion = ImageSelectorActivity.Companion;
        Companion.start$default(companion, (Activity) this.this$0, companion.getMODE_SINGLE(), true, ImageFile.Companion.getTYPE_PROFILE(), 0, (PostType) null, 48, (Object) null);
    }

    public void onModifyProfileClicked() {
        ShowRoomActivity showRoomActivity = this.this$0;
        showRoomActivity.startActivity(AnkoInternals.createIntent(showRoomActivity, ModifyProfileActivity.class, new Pair[0]));
        this.this$0.overridePendingTransition(C0001R$anim.slide_right, C0001R$anim.fade_out);
    }

    public void onFollowersCountClicked(@NotNull ShowRoom showRoom) {
        Intrinsics.checkParameterIsNotNull(showRoom, "showRoomInfo");
        DefaultImpls.logCustom$default(this.this$0.getEventTracker$app_productionFittsRelease(), "Tap Follower List", null, 2, null);
        Intent intent = new Intent(this.$this_run.getContext(), FollowActivity.class);
        Integer followersCount = showRoom.getUser().getFollowersCount();
        if (followersCount == null) {
            Intrinsics.throwNpe();
        }
        intent.putExtra("parameters", new Parameters(false, followersCount.intValue(), Long.valueOf(showRoom.getUser().getId())));
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.$this_run.getContext(), C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        this.this$0.startActivity(intent, makeCustomAnimation.toBundle());
    }

    public void onFollowingCountClicked(@NotNull ShowRoom showRoom) {
        Intrinsics.checkParameterIsNotNull(showRoom, "showRoomInfo");
        DefaultImpls.logCustom$default(this.this$0.getEventTracker$app_productionFittsRelease(), "Tap Following List", null, 2, null);
        Intent intent = new Intent(this.$this_run.getContext(), FollowActivity.class);
        Integer followingsCount = showRoom.getUser().getFollowingsCount();
        if (followingsCount == null) {
            Intrinsics.throwNpe();
        }
        intent.putExtra("parameters", new Parameters(true, followingsCount.intValue(), Long.valueOf(showRoom.getUser().getId())));
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.$this_run.getContext(), C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        this.this$0.startActivity(intent, makeCustomAnimation.toBundle());
    }

    public void onPostContentClicked(@NotNull Post post, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(post, "data");
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.this$0.getEventTracker$app_productionFittsRelease().logCustom("View Post", new CustomAttributes().put("from", "showroom"));
        CompositeDisposable access$getDisposables$p = this.this$0.disposables;
        Disposable subscribe = ActionLogAPI.DefaultImpls.collectActionLog$default(this.this$0.getActionLogAPI$app_productionFittsRelease(), "Post", "Showroom", null, Long.valueOf(this.this$0.getIntent().getLongExtra(ShowRoomActivity.KEY_USER_ID, -1)), null, 16, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(ShowRoomActivity$onCreate$4$1$onPostContentClicked$1.INSTANCE, ShowRoomActivity$onCreate$4$1$onPostContentClicked$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "actionLogAPI.collectActi…                       })");
        DisposableKt.plusAssign(access$getDisposables$p, subscribe);
        Intent intent = new Intent(this.$this_run.getContext(), PostActivity.class);
        intent.putExtra("post_id", post.getId());
        Image coverImage = post.getCoverImage();
        intent.putExtra("post_cover", coverImage != null ? coverImage.getUrl() : null);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        this.this$0.startActivity(intent, makeCustomAnimation.toBundle());
    }

    public void onFollowClicked(@NotNull final User user, @NotNull final View view) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        Intrinsics.checkParameterIsNotNull(view, "followButton");
        view.setClickable(false);
        boolean isFollowing = user.isFollowing();
        if (!isFollowing) {
            if (Intrinsics.areEqual((Object) user.getStatus(), (Object) "deactivated")) {
                view.setClickable(true);
                Logger.d("user follow_deactivated", new Object[0]);
                Snackbar.Companion.showMessage(this.this$0, "탈퇴한 사용자입니다");
                return;
            }
            Disposable access$getPutFollowRequest$p = this.this$0.putFollowRequest;
            if (access$getPutFollowRequest$p != null) {
                access$getPutFollowRequest$p.dispose();
            }
            ShowRoomActivity showRoomActivity = this.this$0;
            showRoomActivity.putFollowRequest = showRoomActivity.getUserAPI$app_productionFittsRelease().putFollow(user.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<FollowResult, Throwable>(this) {
                final /* synthetic */ ShowRoomActivity$onCreate$$inlined$run$lambda$1 this$0;

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
                        this.this$0.this$0.getEventTracker$app_productionFittsRelease().logCustom("Follow", new CustomAttributes().put("from", "showroom"));
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
            ShowRoomActivity showRoomActivity2 = this.this$0;
            showRoomActivity2.deleteFollowRequest = showRoomActivity2.getUserAPI$app_productionFittsRelease().deleteFollow(user.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<FollowResult, Throwable>(this) {
                final /* synthetic */ ShowRoomActivity$onCreate$$inlined$run$lambda$1 this$0;

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

    public void onLikedClicked(@NotNull final Post post, @NotNull final View view) {
        Intrinsics.checkParameterIsNotNull(post, "data");
        Intrinsics.checkParameterIsNotNull(view, "likeButton");
        this.this$0.getEventTracker$app_productionFittsRelease().logCustom("Feedback", new CustomAttributes().put("type", "like"));
        view.setClickable(false);
        boolean isLiked = post.isLiked();
        if (!isLiked) {
            this.this$0.getEventTracker$app_productionFittsRelease().logCustom("Like", new CustomAttributes().put("from", "showroom"));
            AppReview.INSTANCE.addLikeCount();
            AppReview.INSTANCE.showReviewDialogAfterLikeIfNeeded(this.this$0);
            Disposable access$getPutLikeRequest$p = this.this$0.putLikeRequest;
            if (access$getPutLikeRequest$p != null) {
                access$getPutLikeRequest$p.dispose();
            }
            ShowRoomActivity showRoomActivity = this.this$0;
            showRoomActivity.putLikeRequest = showRoomActivity.getPostAPI$app_productionFittsRelease().putLikes(post.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<LikeResult, Throwable>(this) {
                final /* synthetic */ ShowRoomActivity$onCreate$$inlined$run$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(LikeResult likeResult, Throwable th) {
                    this.this$0.this$0.putLikeRequest = null;
                    view.setClickable(true);
                    if (likeResult != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("post liked success ");
                        sb.append(likeResult);
                        Logger.d(sb.toString(), new Object[0]);
                        Message message = new Message();
                        message.what = 3;
                        Bundle bundle = new Bundle();
                        bundle.putLong("postId", post.getId());
                        bundle.putBoolean("isLiked", true);
                        message.setData(bundle);
                        EventBus.getDefault().post(message, AppManager.MY_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
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
        } else if (isLiked) {
            Disposable access$getDeleteLikeRequest$p = this.this$0.deleteLikeRequest;
            if (access$getDeleteLikeRequest$p != null) {
                access$getDeleteLikeRequest$p.dispose();
            }
            ShowRoomActivity showRoomActivity2 = this.this$0;
            showRoomActivity2.deleteLikeRequest = showRoomActivity2.getPostAPI$app_productionFittsRelease().deleteLikes(post.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<LikeResult, Throwable>(this) {
                final /* synthetic */ ShowRoomActivity$onCreate$$inlined$run$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(LikeResult likeResult, Throwable th) {
                    this.this$0.this$0.deleteLikeRequest = null;
                    view.setClickable(true);
                    if (likeResult != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("post unliked success ");
                        sb.append(likeResult);
                        Logger.d(sb.toString(), new Object[0]);
                        Message message = new Message();
                        message.what = 3;
                        Bundle bundle = new Bundle();
                        bundle.putLong("postId", post.getId());
                        bundle.putBoolean("isLiked", false);
                        message.setData(bundle);
                        EventBus.getDefault().post(message, AppManager.MY_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
                        EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
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

    public void onCommentClicked(@NotNull Post post) {
        Intrinsics.checkParameterIsNotNull(post, "data");
        Intent intent = new Intent(this.$this_run.getContext(), CommentsActivity.class);
        intent.putExtra(CommentsActivity.PARAM_POST_OWNER, post.getUser().getId() == this.this$0.getSessionManager$app_productionFittsRelease().getUserID());
        intent.putExtra("comment_post_id", post.getId());
        intent.putExtra(MessageTemplateProtocol.COMMENT_COUNT, post.getCommentsCount());
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.$this_run.getContext(), C0001R$anim.slide_up, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
        this.this$0.startActivity(intent, makeCustomAnimation.toBundle());
    }

    public void onLinearClicked() {
        this.this$0.setLinear(true);
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.post_list);
        String str = "post_list";
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
        recyclerView.setLayoutManager(ShowRoomActivity.access$getLinearLayoutManager$p(this.this$0));
        RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.post_list);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
        Adapter adapter = recyclerView2.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void onGridClicked() {
        this.this$0.setLinear(false);
        String str = "post_list";
        if (this.this$0.postList.isEmpty()) {
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.post_list);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
            recyclerView.setLayoutManager(ShowRoomActivity.access$getLinearLayoutManager$p(this.this$0));
        } else {
            RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.post_list);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
            recyclerView2.setLayoutManager(ShowRoomActivity.access$getGridLayoutManager$p(this.this$0));
        }
        RecyclerView recyclerView3 = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.post_list);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView3, str);
        Adapter adapter = recyclerView3.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void onCreatePostClicked() {
        CreatePostActivityUtil.showCreatePostActivity$default(this.this$0.getCreatePostActivityUtil$app_productionFittsRelease(), this.this$0, "showroom", false, null, 12, null);
    }
}
