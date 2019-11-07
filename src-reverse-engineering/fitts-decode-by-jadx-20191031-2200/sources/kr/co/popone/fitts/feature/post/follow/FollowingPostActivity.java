package kr.co.popone.fitts.feature.post.follow;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.ui.custom.ScrollChildSwipeRefreshLayout;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.home.follow.FollowingPostViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

public final class FollowingPostActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(FollowingPostActivity.class), "followingPostAdapter", "getFollowingPostAdapter()Lkr/co/popone/fitts/feature/post/follow/FollowingPostAdapter;"))};
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final Lazy followingPostAdapter$delegate = LazyKt__LazyJVMKt.lazy(new FollowingPostActivity$followingPostAdapter$2(this));
    @NotNull
    public FollowingPostViewModel viewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 3;
        }
    }

    /* access modifiers changed from: private */
    public final FollowingPostAdapter getFollowingPostAdapter() {
        Lazy lazy = this.followingPostAdapter$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (FollowingPostAdapter) lazy.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final FollowingPostViewModel getViewModel() {
        FollowingPostViewModel followingPostViewModel = this.viewModel;
        if (followingPostViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return followingPostViewModel;
    }

    public final void setViewModel(@NotNull FollowingPostViewModel followingPostViewModel) {
        Intrinsics.checkParameterIsNotNull(followingPostViewModel, "<set-?>");
        this.viewModel = followingPostViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_following_post);
        EventBus.getDefault().register(this);
        Logger.d("FollowingPostActivity, onCreate", new Object[0]);
        ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView)).setAdapter(getFollowingPostAdapter());
        ((ScrollChildSwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout)).setOnRefreshListener(new FollowingPostActivity$onCreate$2(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new FollowingPostActivity$onCreate$3(this));
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).throttleLast(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new FollowingPostActivity$onCreate$4(this), new FollowingPostActivity$onCreate$5(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …or(it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        getFollowingPostList();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "post_message")
    public final void onReceive(@NotNull Message message) {
        Intrinsics.checkParameterIsNotNull(message, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        int i = message.what;
        if (i == 2) {
            getFollowingPostAdapter().updateFittieFollowing(message.getData().getLong("userId"), message.getData().getBoolean("isFollowed"));
        } else if (i == 3) {
            getFollowingPostAdapter().updatePostLike(message.getData().getLong("postId"), message.getData().getBoolean("isLiked"));
        }
    }

    /* access modifiers changed from: private */
    public final void getFollowingPostList() {
        FollowingPostViewModel followingPostViewModel = this.viewModel;
        String str = "viewModel";
        if (followingPostViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        followingPostViewModel.getFollowingPostList();
        FollowingPostViewModel followingPostViewModel2 = this.viewModel;
        if (followingPostViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        LiveData postListLiveData = followingPostViewModel2.getPostListLiveData();
        if (postListLiveData != null) {
            postListLiveData.observe(new FollowingPostActivity$getFollowingPostList$1(this), new FollowingPostActivity$getFollowingPostList$2(this));
        }
        FollowingPostViewModel followingPostViewModel3 = this.viewModel;
        if (followingPostViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        LiveData networkState = followingPostViewModel3.getNetworkState();
        if (networkState != null) {
            networkState.observe(new FollowingPostActivity$getFollowingPostList$3(this), new FollowingPostActivity$getFollowingPostList$4(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        this.disposables.dispose();
        super.onDestroy();
    }
}
