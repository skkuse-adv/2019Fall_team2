package kr.co.popone.fitts.feature.event;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
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
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppliableEventResultActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_ID = "id";
    private HashMap _$_findViewCache;
    @NotNull
    public EventAPI eventAPI;
    private long eventID;
    /* access modifiers changed from: private */
    public Disposable eventResultRequest;
    /* access modifiers changed from: private */
    public AppliableEventResultResponse eventResultResponse;
    private AppliableEventResultAdapter resultAdapter;

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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_appliable_event_result);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(Color.parseColor("#ffffff"));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new AppliableEventResultActivity$onCreate$1(this));
        ((NestedScrollView) _$_findCachedViewById(C0010R$id.mainScrollView)).setOnScrollChangeListener(new AppliableEventResultActivity$onCreate$2(this));
        this.resultAdapter = new AppliableEventResultAdapter(this, new AppliableEventResultActivity$onCreate$3(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        AppliableEventResultAdapter appliableEventResultAdapter = this.resultAdapter;
        if (appliableEventResultAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultAdapter");
        }
        recyclerView.setAdapter(appliableEventResultAdapter);
        this.eventID = getIntent().getLongExtra("id", 0);
        if (this.eventID != 0) {
            loadEventResult();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("eventID ");
        sb.append(this.eventID);
        throw new IllegalArgumentException(sb.toString());
    }

    private final void loadEventResult() {
        Disposable disposable = this.eventResultRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        EventAPI eventAPI2 = this.eventAPI;
        if (eventAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventAPI");
        }
        this.eventResultRequest = eventAPI2.requestAppliableEventResult(this.eventID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new AppliableEventResultActivity$loadEventResult$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final void updateUI() {
        AppliableEventResultResponse appliableEventResultResponse = this.eventResultResponse;
        if (appliableEventResultResponse != null) {
            Resources system = Resources.getSystem();
            Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
            int roundToInt = MathKt__MathJVMKt.roundToInt(((float) system.getDisplayMetrics().widthPixels) / appliableEventResultResponse.getTopImage().getRatio());
            ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.mainImageView);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "mainImageView");
            imageView.getLayoutParams().height = roundToInt;
            Glide.with((FragmentActivity) this).load(appliableEventResultResponse.getTopImage().getUrl()).into((ImageView) _$_findCachedViewById(C0010R$id.mainImageView));
            AppliableEventResultAdapter appliableEventResultAdapter = this.resultAdapter;
            if (appliableEventResultAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultAdapter");
            }
            appliableEventResultAdapter.setResultItems(appliableEventResultResponse.getWinners());
        }
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.eventResultRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
