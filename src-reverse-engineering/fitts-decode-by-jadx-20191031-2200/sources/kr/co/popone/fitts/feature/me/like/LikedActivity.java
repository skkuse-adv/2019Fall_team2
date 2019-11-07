package kr.co.popone.fitts.feature.me.like;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.paginate.Paginate;
import com.paginate.Paginate.Callbacks;
import com.paginate.recycler.LoadingListItemCreator;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.home.PostItemDecoration;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.utils.ActionLogUtil;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LikedActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public ActionLogUtil actionLogUtil;
    @Nullable
    private Long base;
    @NotNull
    public EventTracker eventTracker;
    /* access modifiers changed from: private */
    public boolean isLoadingData;
    private boolean isTotalItemLoaded;
    private int likeCount;
    /* access modifiers changed from: private */
    public Disposable likeCountRequest;
    /* access modifiers changed from: private */
    public Disposable likeListRequest;
    private int limit = 10;
    /* access modifiers changed from: private */
    public Paginate paginate;
    @NotNull
    public PostAPI postAPI;
    /* access modifiers changed from: private */
    public ArrayList<Post> postList = new ArrayList<>();
    @NotNull
    public UserAPI userAPI;

    private final class CustomLoadingListItemCreator implements LoadingListItemCreator {
        public CustomLoadingListItemCreator() {
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.loading_list_item, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new VH(inflate);
        }

        public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
            Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
            VH vh = (VH) viewHolder;
            if (LikedActivity.this.isTotalItemLoaded()) {
                vh.getLoadMoreItem().setVisibility(8);
            }
        }
    }

    public static final class VH extends ViewHolder {
        @NotNull
        private ProgressBar loadMoreItem;

        public VH(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            View findViewById = view.findViewById(C0010R$id.loading_progress);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.loading_progress)");
            this.loadMoreItem = (ProgressBar) findViewById;
        }

        @NotNull
        public final ProgressBar getLoadMoreItem() {
            return this.loadMoreItem;
        }

        public final void setLoadMoreItem(@NotNull ProgressBar progressBar) {
            Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
            this.loadMoreItem = progressBar;
        }
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
    public final EventTracker getEventTracker$app_productionFittsRelease() {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return eventTracker2;
    }

    public final void setEventTracker$app_productionFittsRelease(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "<set-?>");
        this.eventTracker = eventTracker2;
    }

    @NotNull
    public final PostAPI getPostAPI() {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        return postAPI2;
    }

    public final void setPostAPI(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "<set-?>");
        this.postAPI = postAPI2;
    }

    @NotNull
    public final UserAPI getUserAPI() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        return userAPI2;
    }

    public final void setUserAPI(@NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "<set-?>");
        this.userAPI = userAPI2;
    }

    @NotNull
    public final ActionLogUtil getActionLogUtil$app_productionFittsRelease() {
        ActionLogUtil actionLogUtil2 = this.actionLogUtil;
        if (actionLogUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
        }
        return actionLogUtil2;
    }

    public final void setActionLogUtil$app_productionFittsRelease(@NotNull ActionLogUtil actionLogUtil2) {
        Intrinsics.checkParameterIsNotNull(actionLogUtil2, "<set-?>");
        this.actionLogUtil = actionLogUtil2;
    }

    public final boolean isTotalItemLoaded() {
        return this.isTotalItemLoaded;
    }

    public final void setTotalItemLoaded(boolean z) {
        this.isTotalItemLoaded = z;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }

    @Nullable
    public final Long getBase$app_productionFittsRelease() {
        return this.base;
    }

    public final void setBase$app_productionFittsRelease(@Nullable Long l) {
        this.base = l;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final void setLikeCount(int i) {
        this.likeCount = i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_liked);
        ((ImageButton) _$_findCachedViewById(C0010R$id.close_button)).setOnClickListener(new LikedActivity$onCreate$1(this));
        requestLikedPosts();
        requestLikedCount();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.liked_list);
        String str = "liked_list";
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
        recyclerView.setAdapter(new LikedPostAdapter(this, new LikedActivity$onCreate$2(this)));
        ((RecyclerView) _$_findCachedViewById(C0010R$id.liked_list)).addItemDecoration(new PostItemDecoration(true, true));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new LikedActivity$onCreate$3());
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        eventTracker2.customLogEnterLikedPost();
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.liked_list);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
        recyclerView2.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C0010R$id.liked_list);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView3, str);
        initPaginate(recyclerView3);
    }

    public final void requestLikedPosts() {
        this.isLoadingData = true;
        Disposable disposable = this.likeListRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        this.likeListRequest = userAPI2.getLikedPosts(Long.valueOf(getIntent().getLongExtra("user_id", -1)), this.base, this.limit).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new LikedActivity$requestLikedPosts$1<Object,Object>(this));
    }

    private final void requestLikedCount() {
        Disposable disposable = this.likeCountRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        this.likeCountRequest = userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new LikedActivity$requestLikedCount$1<Object,Object>(this));
    }

    private final void initPaginate(RecyclerView recyclerView) {
        Paginate paginate2 = this.paginate;
        if (paginate2 != null) {
            if (paginate2 == null) {
                Intrinsics.throwNpe();
            }
            paginate2.unbind();
        }
        this.paginate = Paginate.with(recyclerView, (Callbacks) new LikedActivity$initPaginate$callbacks$1(this)).setLoadingTriggerThreshold(0).setLoadingListItemCreator(new CustomLoadingListItemCreator()).build();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.likeListRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        this.likeListRequest = null;
        this.isTotalItemLoaded = false;
        this.isLoadingData = false;
        this.base = null;
        super.onDestroy();
    }
}
