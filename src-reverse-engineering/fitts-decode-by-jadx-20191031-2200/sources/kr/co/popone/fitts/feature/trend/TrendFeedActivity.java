package kr.co.popone.fitts.feature.trend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.feature.trend.TrendFeedAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.social.feed.SlidingBanner$Type;
import kr.co.popone.fitts.model.datamodel.social.feed.TrendTypeKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel.Navigation;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel.Navigation.PostActivity;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel.Navigation.ProductActivity;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel.Navigation.ShowRoom;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TrendFeedActivity extends AppCompatActivity implements Delegate {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_TREND_ID = "trend_id";
    @NotNull
    public static final String KEY_TREND_TYPE = "trend_type";
    private HashMap _$_findViewCache;
    @NotNull
    public TrendFeedViewModel vm;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, long j, @Nullable String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            if (str != null && TrendTypeKt.isTrendType(str)) {
                Intent intent = new Intent(context, TrendFeedActivity.class);
                intent.putExtra(TrendFeedActivity.KEY_TREND_ID, j);
                intent.putExtra(TrendFeedActivity.KEY_TREND_TYPE, str);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.SUCCESS.ordinal()] = 3;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 4;
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
    public final TrendFeedViewModel getVm() {
        TrendFeedViewModel trendFeedViewModel = this.vm;
        if (trendFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        return trendFeedViewModel;
    }

    public final void setVm(@NotNull TrendFeedViewModel trendFeedViewModel) {
        Intrinsics.checkParameterIsNotNull(trendFeedViewModel, "<set-?>");
        this.vm = trendFeedViewModel;
    }

    @NotNull
    public SlidingBanner$Type getSlidingBanner() {
        return SlidingBanner$Type.HOME;
    }

    @Nullable
    public Lifecycle getProvidedLifecycle() {
        return getLifecycle();
    }

    @Nullable
    public SessionManager getSessionManager() {
        TrendFeedViewModel trendFeedViewModel = this.vm;
        if (trendFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        return trendFeedViewModel.getSessionManager();
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_trend_detail);
        TrendFeedAdapter trendFeedAdapter = new TrendFeedAdapter(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        recyclerView.setAdapter(trendFeedAdapter);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshView);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "refreshView");
        swipeRefreshLayout.setEnabled(false);
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new TrendFeedActivity$onCreate$1(this));
        TrendFeedViewModel trendFeedViewModel = this.vm;
        String str = "vm";
        if (trendFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        trendFeedViewModel.updateTrendTitle().observe(this, new TrendFeedActivity$sam$androidx_lifecycle_Observer$0(new TrendFeedActivity$onCreate$2(this)));
        TrendFeedViewModel trendFeedViewModel2 = this.vm;
        if (trendFeedViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        trendFeedViewModel2.updateTrendFeeds().observe(this, new TrendFeedActivity$sam$androidx_lifecycle_Observer$0(new TrendFeedActivity$onCreate$3(trendFeedAdapter)));
        TrendFeedViewModel trendFeedViewModel3 = this.vm;
        if (trendFeedViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        trendFeedViewModel3.updateScheme().observe(this, new TrendFeedActivity$sam$androidx_lifecycle_Observer$0(new TrendFeedActivity$onCreate$4(this)));
        TrendFeedViewModel trendFeedViewModel4 = this.vm;
        if (trendFeedViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        trendFeedViewModel4.navigateActivity().observe(this, new TrendFeedActivity$sam$androidx_lifecycle_Observer$0(new TrendFeedActivity$onCreate$5(this)));
        TrendFeedViewModel trendFeedViewModel5 = this.vm;
        if (trendFeedViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        trendFeedViewModel5.updateNetworkState().observe(this, new TrendFeedActivity$sam$androidx_lifecycle_Observer$0(new TrendFeedActivity$onCreate$6(this)));
    }

    /* access modifiers changed from: private */
    public final void updateToolbarTitle(String str) {
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.tvToolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvToolbarTitle");
        textView.setText(str);
    }

    /* access modifiers changed from: private */
    public final void handleScheme(Function1<? super Activity, Unit> function1) {
        function1.invoke(this);
    }

    /* access modifiers changed from: private */
    public final void navigate(Navigation navigation) {
        if (navigation instanceof PostActivity) {
            kr.co.popone.fitts.feature.post.detail.PostActivity.Companion.start$default(kr.co.popone.fitts.feature.post.detail.PostActivity.Companion, this, ((PostActivity) navigation).getId(), null, 4, null);
        } else if (navigation instanceof ProductActivity) {
            ProductActivity productActivity = (ProductActivity) navigation;
            kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, this, productActivity.getUrl(), productActivity.getFrom(), null, null, 24, null);
        } else if (navigation instanceof ShowRoom) {
            ShowRoomActivity.Companion.start(this, Long.valueOf(((ShowRoom) navigation).getId()), "trend");
        }
    }

    /* access modifiers changed from: private */
    public final void handleNetworkState(NetworkState networkState) {
        int i = WhenMappings.$EnumSwitchMapping$0[networkState.getStatus().ordinal()];
        String str = "refreshView";
        if (i == 1 || i == 2) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshView);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
            swipeRefreshLayout.setRefreshing(true);
        } else if (i == 3 || i == 4) {
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshView);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
            swipeRefreshLayout2.setRefreshing(false);
        } else if (i == 5) {
            SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshView);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout3, str);
            swipeRefreshLayout3.setRefreshing(false);
            ActivityExtensionKt.handleError(this, networkState.getMsg());
        }
    }

    public void onSlidingBannerClick(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        TrendFeedViewModel trendFeedViewModel = this.vm;
        if (trendFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        trendFeedViewModel.schemeFeedClick(str);
    }

    public void onSchemeClick(@NotNull ViewHolder viewHolder, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        TrendFeedViewModel trendFeedViewModel = this.vm;
        if (trendFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        trendFeedViewModel.schemeFeedClick(str);
    }

    public void onPostClick(long j) {
        TrendFeedViewModel trendFeedViewModel = this.vm;
        if (trendFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        trendFeedViewModel.postFeedClick(j);
    }

    public void onProductClick(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        TrendFeedViewModel trendFeedViewModel = this.vm;
        if (trendFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        trendFeedViewModel.productFeedClick(str);
    }

    public void onFittieClick(long j) {
        TrendFeedViewModel trendFeedViewModel = this.vm;
        if (trendFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        trendFeedViewModel.fittieFeedClick(j);
    }

    public void onImageTagClick(long j) {
        TrendFeedViewModel trendFeedViewModel = this.vm;
        if (trendFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        trendFeedViewModel.imageTagFeedClick(j);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        super.onDestroy();
    }
}
