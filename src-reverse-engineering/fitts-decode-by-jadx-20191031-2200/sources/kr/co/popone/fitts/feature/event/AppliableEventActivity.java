package kr.co.popone.fitts.feature.event;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
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
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppliableEventActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_ID = "id";
    private HashMap _$_findViewCache;
    @NotNull
    public EventAPI eventAPI;
    /* access modifiers changed from: private */
    public Disposable eventAppliabilityCheckRequest;
    private Disposable eventDetailRequest;
    /* access modifiers changed from: private */
    public long eventID;
    /* access modifiers changed from: private */
    public AppliableEventResponse eventResponse;
    @NotNull
    public EventTracker eventTracker;
    private AppliableEventStatusAdapter statusAdapter;

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
        setContentView((int) C0013R$layout.activity_appliable_event);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(Color.parseColor("#ffffff"));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new AppliableEventActivity$onCreate$1(this));
        ((NestedScrollView) _$_findCachedViewById(C0010R$id.mainScrollView)).setOnScrollChangeListener(new AppliableEventActivity$onCreate$2(this));
        this.eventID = getIntent().getLongExtra("id", 0);
        if (this.eventID != 0) {
            this.statusAdapter = new AppliableEventStatusAdapter(this, new AppliableEventActivity$onCreate$3(this));
            ((Button) _$_findCachedViewById(C0010R$id.eventShareButton)).setOnClickListener(new AppliableEventActivity$onCreate$4(this));
            ((Button) _$_findCachedViewById(C0010R$id.eventApplyButton)).setOnClickListener(new AppliableEventActivity$onCreate$5(this));
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.applicationStatusRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "applicationStatusRecyclerView");
            AppliableEventStatusAdapter appliableEventStatusAdapter = this.statusAdapter;
            if (appliableEventStatusAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusAdapter");
            }
            recyclerView.setAdapter(appliableEventStatusAdapter);
            loadEventDetail();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("eventID ");
        sb.append(this.eventID);
        throw new IllegalArgumentException(sb.toString());
    }

    private final void loadEventDetail() {
        Disposable disposable = this.eventDetailRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        EventAPI eventAPI2 = this.eventAPI;
        if (eventAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventAPI");
        }
        this.eventDetailRequest = eventAPI2.requestAppliableEvent(this.eventID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new AppliableEventActivity$loadEventDetail$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateEventUI(kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse r5) {
        /*
            r4 = this;
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            java.lang.String r1 = "Resources.getSystem()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            float r0 = (float) r0
            java.util.List r2 = r5.getTopItems()
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r2)
            kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Item r2 = (kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Item) r2
            if (r2 == 0) goto L_0x0035
            java.util.List r2 = r2.getItems()
            if (r2 == 0) goto L_0x0035
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r2)
            kr.co.popone.fitts.model.event.EventAPI$TopImageItem r2 = (kr.co.popone.fitts.model.event.EventAPI.TopImageItem) r2
            if (r2 == 0) goto L_0x0035
            kr.co.popone.fitts.model.ImageUrlWithRatio r2 = r2.getImage()
            if (r2 == 0) goto L_0x0035
            float r2 = r2.getRatio()
            goto L_0x0037
        L_0x0035:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0037:
            float r0 = r0 / r2
            int r0 = kotlin.math.MathKt__MathJVMKt.roundToInt(r0)
            int r2 = kr.co.popone.fitts.C0010R$id.mainImageView
            android.view.View r2 = r4._$_findCachedViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            java.lang.String r3 = "mainImageView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            r2.height = r0
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r4)
            java.util.List r2 = r5.getTopItems()
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r2)
            kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Item r2 = (kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Item) r2
            if (r2 == 0) goto L_0x0078
            java.util.List r2 = r2.getItems()
            if (r2 == 0) goto L_0x0078
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r2)
            kr.co.popone.fitts.model.event.EventAPI$TopImageItem r2 = (kr.co.popone.fitts.model.event.EventAPI.TopImageItem) r2
            if (r2 == 0) goto L_0x0078
            kr.co.popone.fitts.model.ImageUrlWithRatio r2 = r2.getImage()
            if (r2 == 0) goto L_0x0078
            java.lang.String r2 = r2.getUrl()
            goto L_0x0079
        L_0x0078:
            r2 = 0
        L_0x0079:
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)
            int r2 = kr.co.popone.fitts.C0010R$id.mainImageView
            android.view.View r2 = r4._$_findCachedViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.into(r2)
            kr.co.popone.fitts.feature.event.AppliableEventStatusAdapter r0 = r4.statusAdapter
            if (r0 != 0) goto L_0x0091
            java.lang.String r2 = "statusAdapter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0091:
            java.util.List r2 = r5.getHistories()
            r0.setStatusItems(r2)
            kr.co.popone.fitts.model.ImageUrlWithRatio r0 = r5.getBottomImageUrl()
            java.lang.String r2 = "bottomImageView"
            if (r0 == 0) goto L_0x00ee
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            float r0 = (float) r0
            kr.co.popone.fitts.model.ImageUrlWithRatio r1 = r5.getBottomImageUrl()
            float r1 = r1.getRatio()
            float r0 = r0 / r1
            int r0 = kotlin.math.MathKt__MathJVMKt.roundToInt(r0)
            int r1 = kr.co.popone.fitts.C0010R$id.bottomImageView
            android.view.View r1 = r4._$_findCachedViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            r1.height = r0
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r4)
            kr.co.popone.fitts.model.ImageUrlWithRatio r1 = r5.getBottomImageUrl()
            java.lang.String r1 = r1.getUrl()
            com.bumptech.glide.RequestBuilder r0 = r0.load(r1)
            int r1 = kr.co.popone.fitts.C0010R$id.bottomImageView
            android.view.View r1 = r4._$_findCachedViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            com.bumptech.glide.request.target.ViewTarget r0 = r0.into(r1)
            java.lang.String r1 = "Glide.with(this@Appliabl…rl).into(bottomImageView)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            goto L_0x00fe
        L_0x00ee:
            int r0 = kr.co.popone.fitts.C0010R$id.bottomImageView
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r1 = 8
            r0.setVisibility(r1)
        L_0x00fe:
            int r0 = kr.co.popone.fitts.C0010R$id.eventApplyButton
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            java.lang.String r1 = "eventApplyButton"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.String r5 = r5.getStatus()
            java.lang.String r1 = "active"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
            r0.setEnabled(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.AppliableEventActivity.updateEventUI(kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse):void");
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.eventDetailRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.eventAppliabilityCheckRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != 100) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            loadEventDetail();
        }
    }
}
