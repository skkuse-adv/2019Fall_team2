package kr.co.popone.fitts.feature.event;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.event.EventAPI.RemotePushContent;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MultiImageEventActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MultiImageEventActivity.class), "remotePushContentID", "getRemotePushContentID()J")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MultiImageEventActivity.class), "imagesAdapter", "getImagesAdapter()Lkr/co/popone/fitts/feature/event/ImagesAdapter;"))};
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_ID = "id";
    private HashMap _$_findViewCache;
    @NotNull
    public EventAPI eventAPI;
    @NotNull
    public EventTracker eventTracker;
    private final Lazy imagesAdapter$delegate = LazyKt__LazyJVMKt.lazy(new MultiImageEventActivity$imagesAdapter$2(this));
    private final Lazy remotePushContentID$delegate = LazyKt__LazyJVMKt.lazy(new MultiImageEventActivity$remotePushContentID$2(this));
    /* access modifiers changed from: private */
    public Disposable remotePushContentRequest;
    /* access modifiers changed from: private */
    public final PublishSubject<RemotePushContent> remotePushContentSubject;
    @NotNull
    public FittsSchemeHandler schemeHandler;
    /* access modifiers changed from: private */
    public final Point windowSize = new Point();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final ImagesAdapter getImagesAdapter() {
        Lazy lazy = this.imagesAdapter$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (ImagesAdapter) lazy.getValue();
    }

    private final long getRemotePushContentID() {
        Lazy lazy = this.remotePushContentID$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).longValue();
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

    public MultiImageEventActivity() {
        PublishSubject<RemotePushContent> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<Ev…tAPI.RemotePushContent>()");
        this.remotePushContentSubject = create;
    }

    @NotNull
    public final EventAPI getEventAPI$app_productionFittsRelease() {
        EventAPI eventAPI2 = this.eventAPI;
        if (eventAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventAPI");
        }
        return eventAPI2;
    }

    public final void setEventAPI$app_productionFittsRelease(@NotNull EventAPI eventAPI2) {
        Intrinsics.checkParameterIsNotNull(eventAPI2, "<set-?>");
        this.eventAPI = eventAPI2;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_multi_image_event);
        WindowManager windowManager = getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "windowManager");
        windowManager.getDefaultDisplay().getSize(this.windowSize);
        EventAPI eventAPI2 = this.eventAPI;
        if (eventAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventAPI");
        }
        this.remotePushContentRequest = eventAPI2.requestRemotePushContent(getRemotePushContentID()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new MultiImageEventActivity$onCreate$1<Object,Object>(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.imagesRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "imagesRecyclerView");
        recyclerView.setAdapter(getImagesAdapter());
        this.remotePushContentSubject.subscribe((Consumer<? super T>) new MultiImageEventActivity$onCreate$2<Object>(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(Color.parseColor("#ffffff"));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new MultiImageEventActivity$onCreate$3(this));
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        DefaultImpls.logCustom$default(eventTracker2, "Tap Remote Push Content", null, 2, null);
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.remotePushContentRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
