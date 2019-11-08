package kr.co.popone.fitts.feature.collection;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.kakao.message.template.MessageTemplateProtocol;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.collection.MixedCollectionAdapter.Delegate;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.model.collection.CollectionAPI;
import kr.co.popone.fitts.model.collection.MixedCollection.ToolbarState;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.ui.ViewExtensions;
import kr.co.popone.fitts.utils.ActionLogUtil;
import kr.co.popone.fitts.utils.Snackbar;
import kr.co.popone.fitts.viewmodel.MixedCollectionViewModel$Input;
import kr.co.popone.fitts.viewmodel.MixedCollectionViewModel$Output;
import kr.co.popone.fitts.viewmodel.MixedCollectionViewModel$ViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;
import retrofit2.HttpException;

public final class MixedCollectionActivity extends AppCompatActivity implements Delegate {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_ID = "id";
    private HashMap _$_findViewCache;
    @NotNull
    public ActionLogAPI actionLogAPI;
    @NotNull
    public ActionLogUtil actionLogUtil;
    @NotNull
    public CollectionAPI collectionAPI;
    @NotNull
    public FittsCommerceRepository commerceRepository;
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    public EventTracker eventTracker;
    /* access modifiers changed from: private */
    public final MixedCollectionAdapter mixedCollectionAdapter = new MixedCollectionAdapter(this, this);
    private Parcelable recyclerViewState;
    @NotNull
    public FittsSchemeHandler schemeHandler;
    @NotNull
    public UserAPI userAPI;
    @NotNull
    public MixedCollectionViewModel$ViewModel viewModel;

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
    public final UserAPI getUserAPI$app_productionFittsRelease() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        return userAPI2;
    }

    public final void setUserAPI$app_productionFittsRelease(@NotNull UserAPI userAPI2) {
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
    public final FittsCommerceRepository getCommerceRepository$app_productionFittsRelease() {
        FittsCommerceRepository fittsCommerceRepository = this.commerceRepository;
        if (fittsCommerceRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commerceRepository");
        }
        return fittsCommerceRepository;
    }

    public final void setCommerceRepository$app_productionFittsRelease(@NotNull FittsCommerceRepository fittsCommerceRepository) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "<set-?>");
        this.commerceRepository = fittsCommerceRepository;
    }

    @NotNull
    public final MixedCollectionViewModel$ViewModel getViewModel() {
        MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel = this.viewModel;
        if (mixedCollectionViewModel$ViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return mixedCollectionViewModel$ViewModel;
    }

    public final void setViewModel(@NotNull MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel) {
        Intrinsics.checkParameterIsNotNull(mixedCollectionViewModel$ViewModel, "<set-?>");
        this.viewModel = mixedCollectionViewModel$ViewModel;
    }

    @NotNull
    public final CompositeDisposable getDisposables() {
        return this.disposables;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_mixed_collection);
        initializeMixedCollectionActivity(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        String str = "recyclerView";
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
        recyclerView.setAdapter(this.mixedCollectionAdapter);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
        LayoutManager layoutManager = recyclerView2.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.onRestoreInstanceState(this.recyclerViewState);
        }
    }

    private final void initializeMixedCollectionActivity(Intent intent) {
        if (intent != null) {
            Resources system = Resources.getSystem();
            Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
            int dpToPx = system.getDisplayMetrics().widthPixels - ViewExtensions.INSTANCE.dpToPx((Context) this, 48);
            long longExtra = intent.getLongExtra("id", -1);
            FittsCommerceRepository fittsCommerceRepository = this.commerceRepository;
            if (fittsCommerceRepository == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commerceRepository");
            }
            CollectionAPI collectionAPI2 = this.collectionAPI;
            if (collectionAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collectionAPI");
            }
            EventTracker eventTracker2 = this.eventTracker;
            if (eventTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
            }
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel = new MixedCollectionViewModel$ViewModel(longExtra, dpToPx, fittsCommerceRepository, collectionAPI2, eventTracker2, userAPI2);
            this.viewModel = mixedCollectionViewModel$ViewModel;
            MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel2 = this.viewModel;
            if (mixedCollectionViewModel$ViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            mixedCollectionViewModel$ViewModel2.requestMixedCollectionDetail();
            EventBus.getDefault().register(this);
            inits();
            inputs();
            outputs();
            requestActionLog();
        }
    }

    private final void requestActionLog() {
        ActionLogUtil actionLogUtil2 = this.actionLogUtil;
        if (actionLogUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
        }
        ActionLogAPI actionLogAPI2 = this.actionLogAPI;
        if (actionLogAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogAPI");
        }
        actionLogAPI2.collectActionLog("collection", actionLogUtil2.getMainPath(), actionLogUtil2.getSubPath(), Long.valueOf(actionLogUtil2.getFromId()), Long.valueOf(getIntent().getLongExtra("id", 0))).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(MixedCollectionActivity$requestActionLog$1$1.INSTANCE, MixedCollectionActivity$requestActionLog$1$2.INSTANCE);
    }

    private final void inits() {
        ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView)).setAdapter(this.mixedCollectionAdapter);
        updateToolbarUI(ToolbarState.TRANSPARENT);
    }

    private final void inputs() {
        MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel = this.viewModel;
        if (mixedCollectionViewModel$ViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MixedCollectionViewModel$Input input = mixedCollectionViewModel$ViewModel.getInput();
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new MixedCollectionActivity$inputs$1$1(input));
        ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView)).addOnScrollListener(new MixedCollectionActivity$inputs$1$2(input));
    }

    private final boolean outputs() {
        MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel = this.viewModel;
        if (mixedCollectionViewModel$ViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MixedCollectionViewModel$Output output = mixedCollectionViewModel$ViewModel.getOutput();
        return this.disposables.addAll(output.finishActivity().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MixedCollectionActivity$outputs$$inlined$with$lambda$1<Object>(this)), output.toolbarTagUpdated().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MixedCollectionActivity$outputs$$inlined$with$lambda$2<Object>(this)), output.collectionListUpdated().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MixedCollectionActivity$outputs$$inlined$with$lambda$3<Object>(this)), output.collectionListAdded().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MixedCollectionActivity$outputs$$inlined$with$lambda$4<Object>(this)), output.collectionDetailUpdated().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MixedCollectionActivity$outputs$$inlined$with$lambda$5<Object>(this)), output.showRoomUpdated().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MixedCollectionActivity$outputs$$inlined$with$lambda$6<Object>(this)), output.bannerLinkUpdated().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MixedCollectionActivity$outputs$$inlined$with$lambda$7<Object>(this)), output.onErrorOccured().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MixedCollectionActivity$outputs$$inlined$with$lambda$8<Object>(this)), output.loadingViewUpdated().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MixedCollectionActivity$outputs$$inlined$with$lambda$9<Object>(this)));
    }

    /* access modifiers changed from: private */
    public final void handleCustomScheme(String str) {
        if (str != null && StringsKt__StringsJVMKt.startsWith$default(str, "fitts://", false, 2, null)) {
            Uri parse = Uri.parse(str);
            Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
            String host = parse.getHost();
            if (host != null && host.hashCode() == -1741312354 && host.equals("collection")) {
                actionLogCollection(parse);
            }
        }
    }

    private final void actionLogCollection(Uri uri) {
        try {
            String lastPathSegment = uri.getLastPathSegment();
            Long valueOf = lastPathSegment != null ? Long.valueOf(Long.parseLong(lastPathSegment)) : null;
            CompositeDisposable compositeDisposable = this.disposables;
            ActionLogUtil actionLogUtil2 = this.actionLogUtil;
            if (actionLogUtil2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
            }
            Disposable subscribe = actionLogUtil2.actionLogOpenSchemeFromMixedCollection("collection", valueOf).subscribe(MixedCollectionActivity$actionLogCollection$1.INSTANCE, MixedCollectionActivity$actionLogCollection$2.INSTANCE);
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "actionLogUtil.actionLogO…\")\n                    })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("ExceptionOccured::");
            sb.append(e);
            Logger.d(sb.toString(), new Object[0]);
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "follow_message")
    private final void onReceive(Message message) {
        if (message.what == 2) {
            this.mixedCollectionAdapter.updateFollow(message.getData().getLong("userId"), message.getData().getBoolean("isFollowed"));
        }
    }

    public void onProfileClicked(int i) {
        MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel = this.viewModel;
        if (mixedCollectionViewModel$ViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mixedCollectionViewModel$ViewModel.getInput().profileClicked(i);
    }

    public void onPostClicked(@NotNull Post post) {
        String str = "post";
        Intrinsics.checkParameterIsNotNull(post, str);
        CompositeDisposable compositeDisposable = this.disposables;
        ActionLogUtil actionLogUtil2 = this.actionLogUtil;
        if (actionLogUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
        }
        Disposable subscribe = actionLogUtil2.actionLogMixedCollection(str, Long.valueOf(post.getId())).subscribe(MixedCollectionActivity$onPostClicked$1.INSTANCE, MixedCollectionActivity$onPostClicked$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "actionLogUtil.actionLogM…:$it\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        startPostActivity(post);
    }

    public void onFollowClicked(int i) {
        MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel = this.viewModel;
        if (mixedCollectionViewModel$ViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mixedCollectionViewModel$ViewModel.getInput().followButtonClicked(i);
    }

    public void bannerClicked(int i) {
        ActionLogUtil actionLogUtil2 = this.actionLogUtil;
        if (actionLogUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
        }
        ActionLogUtil.defineCurrentWindow$default(actionLogUtil2, "collection", "", 0, 4, null);
        MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel = this.viewModel;
        if (mixedCollectionViewModel$ViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mixedCollectionViewModel$ViewModel.getInput().bannerClicked(i);
    }

    public void productClicked(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, MessageTemplateProtocol.LINK);
        kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, this, str, "collection", null, null, 24, null);
    }

    public void showSnackBar(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, MessageTemplateProtocol.CONTENTS);
        Snackbar.Companion.showMessage(this, str);
    }

    public void onProductClick(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, this, str, "collection", null, null, 24, null);
    }

    public void onAddLikeProduct(long j) {
        MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel = this.viewModel;
        if (mixedCollectionViewModel$ViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mixedCollectionViewModel$ViewModel.addLikeProductClick(j);
    }

    public void onRemoveLikeProduct(long j) {
        MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel = this.viewModel;
        if (mixedCollectionViewModel$ViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mixedCollectionViewModel$ViewModel.removeLikeProductClick(j);
    }

    /* access modifiers changed from: private */
    public final void updateToolbarUI(ToolbarState toolbarState) {
        boolean z = toolbarState == ToolbarState.WHITE;
        int i = z ? 0 : (int) 4294967295L;
        int i2 = z ? (int) 4294967295L : 0;
        int argb = z ? Color.argb(150, 0, 0, 0) : Color.argb(255, 255, 255, 255);
        int i3 = z ? 0 : 8;
        ObjectAnimator ofObject = ObjectAnimator.ofObject((Toolbar) _$_findCachedViewById(C0010R$id.toolbar), "backgroundColor", new ArgbEvaluator(), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ofObject.setDuration(200);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(argb);
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.toolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
        textView.setVisibility(i3);
        ofObject.start();
    }

    private final void startPostActivity(Post post) {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        eventTracker2.logCustom("View Post", new CustomAttributes().put("from", "collection"));
        ActionLogUtil actionLogUtil2 = this.actionLogUtil;
        if (actionLogUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
        }
        actionLogUtil2.defineCurrentWindow("Collection", "", getIntent().getLongExtra("id", -1));
        Intent intent = new Intent(this, PostActivity.class);
        intent.putExtra("post_id", post.getId());
        Image coverImage = post.getCoverImage();
        intent.putExtra("post_cover", coverImage != null ? coverImage.getUrl() : null);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        startActivity(intent, makeCustomAnimation.toBundle());
    }

    /* access modifiers changed from: private */
    public final void profileHolderClicked(long j) {
        ShowRoomActivity.Companion.start(this, Long.valueOf(j), "collection");
    }

    /* access modifiers changed from: private */
    public final void handleError(Throwable th) {
        if (!(th instanceof HttpException)) {
            Snackbar.Companion.showMessage(this, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this, IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            startActivity(intent);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finishActivity();
    }

    /* access modifiers changed from: private */
    public final void finishActivity() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        String str = "recyclerView";
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        this.recyclerViewState = layoutManager != null ? layoutManager.onSaveInstanceState() : null;
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
        recyclerView2.setAdapter(null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel = this.viewModel;
        if (mixedCollectionViewModel$ViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mixedCollectionViewModel$ViewModel.onDestroy();
        this.disposables.dispose();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        super.onDestroy();
    }
}
