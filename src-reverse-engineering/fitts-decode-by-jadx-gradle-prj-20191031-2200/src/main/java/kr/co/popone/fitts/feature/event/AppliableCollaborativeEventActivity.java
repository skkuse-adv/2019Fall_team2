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
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppliableCollaborativeEventActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AppliableCollaborativeEventActivity.class), AppliableEventWinnerInputActivity.PARAMETER_EVENT_ID, "getEventID()J"))};
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_ID = "id";
    private HashMap _$_findViewCache;
    @NotNull
    public EventAPI eventAPI;
    /* access modifiers changed from: private */
    public Disposable eventAppliabilityCheckRequest;
    private Disposable eventDetailRequest;
    private final Lazy eventID$delegate = LazyKt__LazyJVMKt.lazy(new AppliableCollaborativeEventActivity$eventID$2(this));
    /* access modifiers changed from: private */
    public AppliableEventResponse eventResponse;
    @NotNull
    public EventTracker eventTracker;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.COLLABORATION.ordinal()] = 1;
            $EnumSwitchMapping$1[Type.COLLABORATION.ordinal()] = 1;
        }
    }

    /* access modifiers changed from: private */
    public final long getEventID() {
        Lazy lazy = this.eventID$delegate;
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
        setContentView((int) C0013R$layout.activity_appliable_collaborative_event);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(Color.parseColor("#ffffff"));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new AppliableCollaborativeEventActivity$onCreate$1(this));
        ((NestedScrollView) _$_findCachedViewById(C0010R$id.mainScrollView)).setOnScrollChangeListener(new AppliableCollaborativeEventActivity$onCreate$2(this));
        ((CollaborativeEventImageListView) _$_findCachedViewById(C0010R$id.topImagesListView)).setItemClickListener(new AppliableCollaborativeEventActivity$onCreate$3(this));
        ((CollaborativeEventStatusBoardView) _$_findCachedViewById(C0010R$id.eventStatusBoardView)).setItemClickListener(new AppliableCollaborativeEventActivity$onCreate$4(this));
        ((Button) _$_findCachedViewById(C0010R$id.eventApplyButton)).setOnClickListener(new AppliableCollaborativeEventActivity$onCreate$5(this));
        ((Button) _$_findCachedViewById(C0010R$id.eventShareButton)).setOnClickListener(new AppliableCollaborativeEventActivity$onCreate$6(this));
        loadEventDetail();
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
        this.eventDetailRequest = eventAPI2.requestAppliableEvent(getEventID()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new AppliableCollaborativeEventActivity$loadEventDetail$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003c, code lost:
        if (r8 != null) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateEventUI(kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse r15) {
        /*
            r14 = this;
            int r0 = kr.co.popone.fitts.C0010R$id.topImagesListView
            android.view.View r0 = r14._$_findCachedViewById(r0)
            kr.co.popone.fitts.feature.event.CollaborativeEventImageListView r0 = (kr.co.popone.fitts.feature.event.CollaborativeEventImageListView) r0
            java.util.List r1 = r15.getTopItems()
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r3)
            r2.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
        L_0x001b:
            boolean r4 = r1.hasNext()
            java.lang.String r5 = ""
            r6 = 1
            if (r4 == 0) goto L_0x0068
            java.lang.Object r4 = r1.next()
            kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Item r4 = (kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Item) r4
            kr.co.popone.fitts.feature.event.CollaborativeEventImageListView$SingleOrMultiImage r7 = new kr.co.popone.fitts.feature.event.CollaborativeEventImageListView$SingleOrMultiImage
            java.util.List r8 = r4.getItems()
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r8)
            kr.co.popone.fitts.model.event.EventAPI$TopImageItem r8 = (kr.co.popone.fitts.model.event.EventAPI.TopImageItem) r8
            if (r8 == 0) goto L_0x003f
            kr.co.popone.fitts.model.ImageUrlWithRatio r8 = r8.getImage()
            if (r8 == 0) goto L_0x003f
            goto L_0x0046
        L_0x003f:
            kr.co.popone.fitts.model.ImageUrlWithRatio r8 = new kr.co.popone.fitts.model.ImageUrlWithRatio
            r9 = 1065353216(0x3f800000, float:1.0)
            r8.<init>(r5, r9)
        L_0x0046:
            java.util.List r5 = r4.getItems()
            int r5 = r5.size()
            r9 = 2
            if (r5 < r9) goto L_0x0060
            java.util.List r4 = r4.getItems()
            java.lang.Object r4 = r4.get(r6)
            kr.co.popone.fitts.model.event.EventAPI$TopImageItem r4 = (kr.co.popone.fitts.model.event.EventAPI.TopImageItem) r4
            kr.co.popone.fitts.model.ImageUrlWithRatio r4 = r4.getImage()
            goto L_0x0061
        L_0x0060:
            r4 = 0
        L_0x0061:
            r7.<init>(r8, r4)
            r2.add(r7)
            goto L_0x001b
        L_0x0068:
            r0.setEventImages(r2)
            kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Type r0 = r15.getType()
            int[] r1 = kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r6) goto L_0x0087
            int r0 = kr.co.popone.fitts.C0010R$id.eventStatusBoardView
            android.view.View r0 = r14._$_findCachedViewById(r0)
            kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView r0 = (kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView) r0
            java.lang.String r1 = "상품종류"
            r0.setHeadeDescription(r1)
            goto L_0x0094
        L_0x0087:
            int r0 = kr.co.popone.fitts.C0010R$id.eventStatusBoardView
            android.view.View r0 = r14._$_findCachedViewById(r0)
            kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView r0 = (kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView) r0
            java.lang.String r1 = "쇼핑몰"
            r0.setHeadeDescription(r1)
        L_0x0094:
            int r0 = kr.co.popone.fitts.C0010R$id.eventStatusBoardView
            android.view.View r0 = r14._$_findCachedViewById(r0)
            kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView r0 = (kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView) r0
            java.util.List r1 = r15.getHistories()
            java.util.ArrayList r2 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r3)
            r2.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
        L_0x00ad:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x013d
            java.lang.Object r4 = r1.next()
            kr.co.popone.fitts.model.event.EventAPI$EventHistory r4 = (kr.co.popone.fitts.model.event.EventAPI.EventHistory) r4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r8 = r4.getDay()
            r7.append(r8)
            java.lang.String r8 = "일차"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.util.List r4 = r4.getTickets()
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r4, r3)
            r8.<init>(r9)
            java.util.Iterator r4 = r4.iterator()
        L_0x00df:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x0133
            java.lang.Object r9 = r4.next()
            kr.co.popone.fitts.model.event.EventAPI$Ticket r9 = (kr.co.popone.fitts.model.event.EventAPI.Ticket) r9
            kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Type r10 = r15.getType()
            int[] r11 = kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity.WhenMappings.$EnumSwitchMapping$1
            int r10 = r10.ordinal()
            r10 = r11[r10]
            if (r10 == r6) goto L_0x0102
            java.lang.String r10 = r9.getItem()
            if (r10 == 0) goto L_0x0100
            goto L_0x010e
        L_0x0100:
            r10 = r5
            goto L_0x010e
        L_0x0102:
            kr.co.popone.fitts.model.datamodel.commerce.Shop r10 = r9.getShop()
            if (r10 == 0) goto L_0x0100
            java.lang.String r10 = r10.getName()
            if (r10 == 0) goto L_0x0100
        L_0x010e:
            kr.co.popone.fitts.feature.event.DailyEventStatusView$Item r11 = new kr.co.popone.fitts.feature.event.DailyEventStatusView$Item
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = r9.getColor()
            r12.append(r13)
            r13 = 32
            r12.append(r13)
            java.lang.String r9 = r9.getSize()
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            r11.<init>(r10, r9)
            r8.add(r11)
            goto L_0x00df
        L_0x0133:
            kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView$DayItem r4 = new kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView$DayItem
            r4.<init>(r7, r8)
            r2.add(r4)
            goto L_0x00ad
        L_0x013d:
            r0.setItems(r2)
            int r0 = kr.co.popone.fitts.C0010R$id.eventApplyButton
            android.view.View r0 = r14._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            java.lang.String r1 = "eventApplyButton"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Type r1 = r15.getType()
            kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Type r2 = kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Type.COLLABORATION
            r3 = 8
            if (r1 != r2) goto L_0x015a
            r1 = 8
            goto L_0x015b
        L_0x015a:
            r1 = 0
        L_0x015b:
            r0.setVisibility(r1)
            kr.co.popone.fitts.model.ImageUrlWithRatio r0 = r15.getBottomImageUrl()
            java.lang.String r1 = "bottomImageView"
            if (r0 == 0) goto L_0x01b6
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            java.lang.String r2 = "Resources.getSystem()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            float r0 = (float) r0
            kr.co.popone.fitts.model.ImageUrlWithRatio r2 = r15.getBottomImageUrl()
            float r2 = r2.getRatio()
            float r0 = r0 / r2
            int r0 = kotlin.math.MathKt__MathJVMKt.roundToInt(r0)
            int r2 = kr.co.popone.fitts.C0010R$id.bottomImageView
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r1)
            android.view.ViewGroup$LayoutParams r1 = r2.getLayoutParams()
            r1.height = r0
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r14)
            kr.co.popone.fitts.model.ImageUrlWithRatio r15 = r15.getBottomImageUrl()
            java.lang.String r15 = r15.getUrl()
            com.bumptech.glide.RequestBuilder r15 = r0.load(r15)
            int r0 = kr.co.popone.fitts.C0010R$id.bottomImageView
            android.view.View r0 = r14._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            com.bumptech.glide.request.target.ViewTarget r15 = r15.into(r0)
            java.lang.String r0 = "Glide.with(this@Appliabl…rl).into(bottomImageView)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r15, r0)
            goto L_0x01c4
        L_0x01b6:
            int r15 = kr.co.popone.fitts.C0010R$id.bottomImageView
            android.view.View r15 = r14._$_findCachedViewById(r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r15, r1)
            r15.setVisibility(r3)
        L_0x01c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity.updateEventUI(kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse):void");
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
