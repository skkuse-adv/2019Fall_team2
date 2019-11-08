package kr.co.popone.fitts.feature.banner;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.banner.BannerItemHolder.Delegate;
import kr.co.popone.fitts.model.datamodel.service.banner.BannerType;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.banner.BannerViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BannerActivity extends AppCompatActivity implements Delegate {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_BANNER_TYPE = StringKeyGenerator.Companion.generate(BannerActivity.class, "banner_type");
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final BannerAdapter bannerAdapter = new BannerAdapter(this);
    @NotNull
    public BannerViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int getCurrentTimeStamp() {
            return (int) (System.currentTimeMillis() / ((long) 1000));
        }

        public final void start(@NotNull Activity activity, @NotNull BannerType bannerType, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intrinsics.checkParameterIsNotNull(bannerType, "type");
            Intrinsics.checkParameterIsNotNull(str, "timeStampKey");
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
            Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…ltSharedPreferences(this)");
            defaultSharedPreferences.edit().putInt(str, BannerActivity.Companion.getCurrentTimeStamp()).apply();
            Intent intent = new Intent(activity, BannerActivity.class);
            intent.putExtra(BannerActivity.KEY_BANNER_TYPE, bannerType.name());
            ContextExtensionKt.activityStart(activity, intent, ActivityAnimationType.SLIDE_RTOL);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.RUNNING.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 3;
            $EnumSwitchMapping$0[Status.SUCCESS.ordinal()] = 4;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 5;
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
    public final BannerViewModel getViewModel() {
        BannerViewModel bannerViewModel = this.viewModel;
        if (bannerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return bannerViewModel;
    }

    public final void setViewModel(@NotNull BannerViewModel bannerViewModel) {
        Intrinsics.checkParameterIsNotNull(bannerViewModel, "<set-?>");
        this.viewModel = bannerViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_banner);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.bannerRecyclerView);
        recyclerView.setAdapter(this.bannerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new BannerActivity$onCreate$2(this));
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout)).setOnRefreshListener(new BannerActivity$onCreate$3(this));
        BannerViewModel bannerViewModel = this.viewModel;
        String str = "viewModel";
        if (bannerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        bannerViewModel.initBannerType(new BannerActivity$onCreate$4(this));
        BannerViewModel bannerViewModel2 = this.viewModel;
        if (bannerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        bannerViewModel2.getTitleLiveData().observe(new BannerActivity$onCreate$5(this), new BannerActivity$onCreate$6(this));
        BannerViewModel bannerViewModel3 = this.viewModel;
        if (bannerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        bannerViewModel3.getBannerListLiveData().observe(new BannerActivity$onCreate$7(this), new BannerActivity$onCreate$8(this));
        BannerViewModel bannerViewModel4 = this.viewModel;
        if (bannerViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        bannerViewModel4.getNetworkState().observe(new BannerActivity$onCreate$9(this), new BannerActivity$onCreate$10(this));
    }

    public void onBannerClicked(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        BannerViewModel bannerViewModel = this.viewModel;
        if (bannerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bannerViewModel.handleBannerScheme(this, str);
    }

    public void onBackPressed() {
        ActivityExtensionKt.finishWithAnimation(this, ActivityAnimationType.SLIDE_LTOR);
    }
}
