package kr.co.popone.fitts.feature.collection;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.collection.CollectionAPI;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.ActionLogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostCollectionActivity extends AppCompatActivity {
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
    public PostCollectionAdapter collectionAdapter;
    /* access modifiers changed from: private */
    public Disposable collectionDetailRequest;
    private long collectionID;
    /* access modifiers changed from: private */
    public Disposable collectionItemsRequest;
    @NotNull
    public EventTracker eventTracker;
    @NotNull
    public FittsSchemeHandler schemeHandler;

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

    public static final /* synthetic */ PostCollectionAdapter access$getCollectionAdapter$p(PostCollectionActivity postCollectionActivity) {
        PostCollectionAdapter postCollectionAdapter = postCollectionActivity.collectionAdapter;
        if (postCollectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionAdapter");
        }
        return postCollectionAdapter;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_post_collection);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(Color.argb(255, 255, 255, 255));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new PostCollectionActivity$onCreate$1(this));
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView)).addOnScrollListener(new PostCollectionActivity$onCreate$2(this, system.getDisplayMetrics().widthPixels - ViewExtensionsKt.dpToPx((Context) this, 48)));
        this.collectionAdapter = new PostCollectionAdapter(this, new PostCollectionActivity$onCreate$3(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        PostCollectionAdapter postCollectionAdapter = this.collectionAdapter;
        if (postCollectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionAdapter");
        }
        recyclerView.setAdapter(postCollectionAdapter);
        this.collectionID = getIntent().getLongExtra("id", 0);
        if (this.collectionID != 0) {
            loadDetailData();
            loadListData(true);
            requestActionLog(this.collectionID);
            ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView)).addOnScrollListener(new PostCollectionActivity$onCreate$4(this));
            ActionLogUtil actionLogUtil2 = this.actionLogUtil;
            if (actionLogUtil2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
            }
            Logger.d(actionLogUtil2);
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
        actionLogAPI2.collectActionLog("collection", actionLogUtil2.getMainPath(), actionLogUtil2.getSubPath(), Long.valueOf(actionLogUtil2.getFromId()), Long.valueOf(j)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(PostCollectionActivity$requestActionLog$1$1.INSTANCE, PostCollectionActivity$requestActionLog$1$2.INSTANCE);
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
        this.collectionDetailRequest = collectionAPI2.requestCollectionDetail(this.collectionID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PostCollectionActivity$loadDetailData$1<Object,Object>(this));
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
            PostCollectionAdapter postCollectionAdapter = this.collectionAdapter;
            if (postCollectionAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            postCollectionAdapter.setCollectionItems(CollectionsKt__CollectionsKt.emptyList());
        }
        PostCollectionAdapter postCollectionAdapter2 = this.collectionAdapter;
        if (postCollectionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        postCollectionAdapter2.setShowsLoading(true);
        CollectionAPI collectionAPI2 = this.collectionAPI;
        if (collectionAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionAPI");
        }
        long j = this.collectionID;
        PostCollectionAdapter postCollectionAdapter3 = this.collectionAdapter;
        if (postCollectionAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        if (true ^ postCollectionAdapter3.getCollectionItems().isEmpty()) {
            PostCollectionAdapter postCollectionAdapter4 = this.collectionAdapter;
            if (postCollectionAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            l = Long.valueOf(((CollectionEntry) CollectionsKt___CollectionsKt.last(postCollectionAdapter4.getCollectionItems())).getId());
        } else {
            l = null;
        }
        this.collectionItemsRequest = collectionAPI2.requestCollectionList(j, l, Integer.valueOf(20)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PostCollectionActivity$loadListData$1<Object,Object>(this));
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
