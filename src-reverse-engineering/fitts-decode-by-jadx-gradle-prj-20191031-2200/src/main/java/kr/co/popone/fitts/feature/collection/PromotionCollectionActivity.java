package kr.co.popone.fitts.feature.collection;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import dagger.android.AndroidInjection;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.collection.CollectionAPI;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.ActionLogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

public final class PromotionCollectionActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_ID = "id";
    private HashMap _$_findViewCache;
    @NotNull
    public ActionLogAPI actionLogAPI;
    @NotNull
    public ActionLogUtil actionLogUtil;
    /* access modifiers changed from: private */
    public boolean canLoadMore;
    @NotNull
    public CollectionAPI collectionAPI;
    /* access modifiers changed from: private */
    public PromotionCollectionAdapter collectionAdapter;
    /* access modifiers changed from: private */
    public Disposable collectionDetailRequest;
    /* access modifiers changed from: private */
    public CollectionDetailResponse collectionDetailResponse;
    private long collectionID;
    /* access modifiers changed from: private */
    public Disposable collectionItemsRequest;
    @NotNull
    public EventTracker eventTracker;
    /* access modifiers changed from: private */
    public final Map<Long, Disposable> fittieFollowRequests = new LinkedHashMap();
    @NotNull
    public PostAPI postAPI;
    /* access modifiers changed from: private */
    public final Map<Long, Disposable> postLikeRequests = new LinkedHashMap();
    @NotNull
    public FittsSchemeHandler schemeHandler;
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public UserAPI userAPI;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

    public static final /* synthetic */ PromotionCollectionAdapter access$getCollectionAdapter$p(PromotionCollectionActivity promotionCollectionActivity) {
        PromotionCollectionAdapter promotionCollectionAdapter = promotionCollectionActivity.collectionAdapter;
        if (promotionCollectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionAdapter");
        }
        return promotionCollectionAdapter;
    }

    @NotNull
    public final PostAPI getPostAPI$app_productionFittsRelease() {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        return postAPI2;
    }

    public final void setPostAPI$app_productionFittsRelease(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "<set-?>");
        this.postAPI = postAPI2;
    }

    @NotNull
    public final CollectionAPI getCollectionAPI$app_productionFittsRelease() {
        CollectionAPI collectionAPI2 = this.collectionAPI;
        if (collectionAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionAPI");
        }
        return collectionAPI2;
    }

    public final void setCollectionAPI$app_productionFittsRelease(@NotNull CollectionAPI collectionAPI2) {
        Intrinsics.checkParameterIsNotNull(collectionAPI2, "<set-?>");
        this.collectionAPI = collectionAPI2;
    }

    @NotNull
    public final FittsSchemeHandler getSchemeHandler$app_productionFittsRelease() {
        FittsSchemeHandler fittsSchemeHandler = this.schemeHandler;
        if (fittsSchemeHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schemeHandler");
        }
        return fittsSchemeHandler;
    }

    public final void setSchemeHandler$app_productionFittsRelease(@NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "<set-?>");
        this.schemeHandler = fittsSchemeHandler;
    }

    @NotNull
    public final SessionManager getSessionManager$app_productionFittsRelease() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager$app_productionFittsRelease(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
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

    @NotNull
    public final ActionLogAPI getActionLogAPI$app_productionFittsRelease() {
        ActionLogAPI actionLogAPI2 = this.actionLogAPI;
        if (actionLogAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogAPI");
        }
        return actionLogAPI2;
    }

    public final void setActionLogAPI$app_productionFittsRelease(@NotNull ActionLogAPI actionLogAPI2) {
        Intrinsics.checkParameterIsNotNull(actionLogAPI2, "<set-?>");
        this.actionLogAPI = actionLogAPI2;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_promotion_collection);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(Color.argb(255, 255, 255, 255));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new PromotionCollectionActivity$onCreate$1(this));
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView)).addOnScrollListener(new PromotionCollectionActivity$onCreate$2(this, system.getDisplayMetrics().widthPixels - ViewExtensionsKt.dpToPx((Context) this, 48)));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        String str = "recyclerView";
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
        ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0);
        }
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        this.collectionAdapter = new PromotionCollectionAdapter(this, sessionManager2, new PromotionCollectionActivity$onCreate$3(this));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
        PromotionCollectionAdapter promotionCollectionAdapter = this.collectionAdapter;
        if (promotionCollectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionAdapter");
        }
        recyclerView2.setAdapter(promotionCollectionAdapter);
        this.collectionID = getIntent().getLongExtra("id", 0);
        if (this.collectionID != 0) {
            loadDetailData();
            loadListData(true);
            requestActionLog(this.collectionID);
            ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView)).addOnScrollListener(new PromotionCollectionActivity$onCreate$4(this));
            EventBus.getDefault().register(this);
            return;
        }
        throw new IllegalAccessException();
    }

    private final void requestActionLog(long j) {
        ActionLogUtil actionLogUtil2 = this.actionLogUtil;
        if (actionLogUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
        }
        ActionLogAPI actionLogAPI2 = this.actionLogAPI;
        if (actionLogAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogAPI");
        }
        actionLogAPI2.collectActionLog("collection", actionLogUtil2.getMainPath(), actionLogUtil2.getSubPath(), Long.valueOf(actionLogUtil2.getFromId()), Long.valueOf(j)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(PromotionCollectionActivity$requestActionLog$1$1.INSTANCE, PromotionCollectionActivity$requestActionLog$1$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void updateListForLikes(long j, boolean z) {
        PromotionCollectionAdapter promotionCollectionAdapter = this.collectionAdapter;
        String str = "collectionAdapter";
        if (promotionCollectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        int i = 0;
        for (CollectionEntry post : promotionCollectionAdapter.getCollectionItems()) {
            Post post2 = post.getPost();
            if (post2 == null) {
                Intrinsics.throwNpe();
            }
            if (post2.getId() == j && post2.isLiked() != z) {
                post2.setLiked(z);
                int likesCount = post2.getLikesCount();
                post2.setLikesCount(z ? likesCount + 1 : likesCount - 1);
                PromotionCollectionAdapter promotionCollectionAdapter2 = this.collectionAdapter;
                if (promotionCollectionAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                }
                promotionCollectionAdapter2.notifyCollectionItemChanged(i);
            }
            i++;
        }
    }

    /* access modifiers changed from: private */
    public final void updateListForFollow(long j, boolean z) {
        PromotionCollectionAdapter promotionCollectionAdapter = this.collectionAdapter;
        String str = "collectionAdapter";
        if (promotionCollectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        int i = 0;
        for (CollectionEntry collectionEntry : promotionCollectionAdapter.getCollectionItems()) {
            Post post = collectionEntry.getPost();
            if (post == null) {
                Intrinsics.throwNpe();
            }
            if (post.getUser().getId() == j) {
                collectionEntry.getPost().getUser().setFollowing(z);
                PromotionCollectionAdapter promotionCollectionAdapter2 = this.collectionAdapter;
                if (promotionCollectionAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                }
                promotionCollectionAdapter2.notifyCollectionItemChanged(i);
            }
            i++;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.collectionDetailRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.collectionItemsRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        for (Entry value : this.fittieFollowRequests.entrySet()) {
            ((Disposable) value.getValue()).dispose();
        }
        for (Entry value2 : this.postLikeRequests.entrySet()) {
            ((Disposable) value2.getValue()).dispose();
        }
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    private final void loadDetailData() {
        Disposable disposable = this.collectionDetailRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        CollectionAPI collectionAPI2 = this.collectionAPI;
        if (collectionAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionAPI");
        }
        this.collectionDetailRequest = collectionAPI2.requestCollectionDetail(this.collectionID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PromotionCollectionActivity$loadDetailData$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final void loadListData(boolean z) {
        Long l;
        Disposable disposable = this.collectionItemsRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        String str = "collectionAdapter";
        if (z) {
            this.canLoadMore = false;
            PromotionCollectionAdapter promotionCollectionAdapter = this.collectionAdapter;
            if (promotionCollectionAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            promotionCollectionAdapter.setCollectionItems(CollectionsKt__CollectionsKt.emptyList());
        }
        PromotionCollectionAdapter promotionCollectionAdapter2 = this.collectionAdapter;
        if (promotionCollectionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        promotionCollectionAdapter2.setShowsLoading(true);
        CollectionAPI collectionAPI2 = this.collectionAPI;
        if (collectionAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionAPI");
        }
        long j = this.collectionID;
        PromotionCollectionAdapter promotionCollectionAdapter3 = this.collectionAdapter;
        if (promotionCollectionAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        if (true ^ promotionCollectionAdapter3.getCollectionItems().isEmpty()) {
            PromotionCollectionAdapter promotionCollectionAdapter4 = this.collectionAdapter;
            if (promotionCollectionAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            l = Long.valueOf(((CollectionEntry) CollectionsKt___CollectionsKt.last(promotionCollectionAdapter4.getCollectionItems())).getId());
        } else {
            l = null;
        }
        this.collectionItemsRequest = collectionAPI2.requestCollectionList(j, l, Integer.valueOf(20)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PromotionCollectionActivity$loadListData$1<Object,Object>(this));
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "home_message")
    public final void onReceive(@NotNull Message message) {
        Intrinsics.checkParameterIsNotNull(message, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if (message.what == 1) {
            long j = message.getData().getLong("postId");
            boolean z = message.getData().getBoolean("isAddedComment");
            int i = 0;
            PromotionCollectionAdapter promotionCollectionAdapter = this.collectionAdapter;
            String str = "collectionAdapter";
            if (promotionCollectionAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            for (CollectionEntry collectionEntry : promotionCollectionAdapter.getCollectionItems()) {
                Post post = collectionEntry.getPost();
                if (post == null) {
                    Intrinsics.throwNpe();
                }
                if (post.getId() == j) {
                    if (z) {
                        Post post2 = collectionEntry.getPost();
                        post2.setCommentsCount(post2.getCommentsCount() + 1);
                    } else {
                        Post post3 = collectionEntry.getPost();
                        post3.setCommentsCount(post3.getCommentsCount() - 1);
                    }
                    PromotionCollectionAdapter promotionCollectionAdapter2 = this.collectionAdapter;
                    if (promotionCollectionAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    promotionCollectionAdapter2.notifyCollectionItemChanged(i);
                }
                i++;
            }
        }
    }
}
