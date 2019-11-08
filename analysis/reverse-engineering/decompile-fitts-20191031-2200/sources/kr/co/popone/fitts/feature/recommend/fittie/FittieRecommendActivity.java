package kr.co.popone.fitts.feature.recommend.fittie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.event.MainEvent$AppFinishEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.common.fittie.FittieRecommendViewHolder.Delegate;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.recommend.fittie.FittieRecommendViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

public final class FittieRecommendActivity extends AppCompatActivity implements LifecycleObserver, Delegate {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(FittieRecommendActivity.class), "decorator", "getDecorator()Lkr/co/popone/fitts/ui/decorator/RecyclerDecorator;"))};
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private final Lazy decorator$delegate = LazyKt__LazyJVMKt.lazy(FittieRecommendActivity$decorator$2.INSTANCE);
    private final FittieRecommendAdapter fittieRecommendAdapter = new FittieRecommendAdapter(this);
    @NotNull
    public FittieRecommendViewModel vm;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull AppCompatActivity appCompatActivity, int i) {
            Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
            ActivityExtensionKt.activityStartForResult(appCompatActivity, new Intent(appCompatActivity, FittieRecommendActivity.class), ActivityAnimationType.SLIDE_UP, i);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 3;
        }
    }

    private final RecyclerDecorator getDecorator() {
        Lazy lazy = this.decorator$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (RecyclerDecorator) lazy.getValue();
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
    public final FittieRecommendViewModel getVm() {
        FittieRecommendViewModel fittieRecommendViewModel = this.vm;
        if (fittieRecommendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        return fittieRecommendViewModel;
    }

    public final void setVm(@NotNull FittieRecommendViewModel fittieRecommendViewModel) {
        Intrinsics.checkParameterIsNotNull(fittieRecommendViewModel, "<set-?>");
        this.vm = fittieRecommendViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_fittie_recommend);
        EventBus.getDefault().register(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.fittieRecyclerView);
        recyclerView.setAdapter(this.fittieRecommendAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(getDecorator());
        }
        ((Button) _$_findCachedViewById(C0010R$id.buttonStartFitts)).setOnClickListener(new FittieRecommendActivity$onCreate$2(this));
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout)).setOnRefreshListener(new FittieRecommendActivity$onCreate$3(this));
        FittieRecommendViewModel fittieRecommendViewModel = this.vm;
        String str = "vm";
        if (fittieRecommendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        fittieRecommendViewModel.updateButtonsState().observe(this, new FittieRecommendActivity$sam$androidx_lifecycle_Observer$0(new FittieRecommendActivity$onCreate$4(this)));
        FittieRecommendViewModel fittieRecommendViewModel2 = this.vm;
        if (fittieRecommendViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        fittieRecommendViewModel2.updateButtonText().observe(this, new FittieRecommendActivity$sam$androidx_lifecycle_Observer$0(new FittieRecommendActivity$onCreate$5(this)));
        FittieRecommendViewModel fittieRecommendViewModel3 = this.vm;
        if (fittieRecommendViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        fittieRecommendViewModel3.startFitts().observe(this, new FittieRecommendActivity$onCreate$6(this));
        FittieRecommendViewModel fittieRecommendViewModel4 = this.vm;
        if (fittieRecommendViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        fittieRecommendViewModel4.updateFitties().observe(this, new FittieRecommendActivity$sam$androidx_lifecycle_Observer$0(new FittieRecommendActivity$onCreate$7(this)));
        FittieRecommendViewModel fittieRecommendViewModel5 = this.vm;
        if (fittieRecommendViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        fittieRecommendViewModel5.updateNetworkState().observe(this, new FittieRecommendActivity$sam$androidx_lifecycle_Observer$0(new FittieRecommendActivity$onCreate$8(this)));
        FittieRecommendViewModel fittieRecommendViewModel6 = this.vm;
        if (fittieRecommendViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        fittieRecommendViewModel6.errorOccured().observe(this, new FittieRecommendActivity$sam$androidx_lifecycle_Observer$0(new FittieRecommendActivity$onCreate$9(this)));
    }

    /* access modifiers changed from: private */
    public final void updateButtonState(boolean z) {
        Button button = (Button) _$_findCachedViewById(C0010R$id.buttonStartFitts);
        Intrinsics.checkExpressionValueIsNotNull(button, "buttonStartFitts");
        button.setEnabled(z);
    }

    /* access modifiers changed from: private */
    public final void updateButtonText(String str) {
        Button button = (Button) _$_findCachedViewById(C0010R$id.buttonStartFitts);
        Intrinsics.checkExpressionValueIsNotNull(button, "buttonStartFitts");
        button.setText(str);
    }

    /* access modifiers changed from: private */
    public final void startFitts() {
        setResult(-1);
        ActivityExtensionKt.finishWithAnimation(this, ActivityAnimationType.SLIDE_DOWN);
    }

    /* access modifiers changed from: private */
    public final void updateRecommendFitties(PagedList<RecommendFittieInfo> pagedList) {
        this.fittieRecommendAdapter.submitList(pagedList);
    }

    /* access modifiers changed from: private */
    public final void handleNetworkState(NetworkState networkState) {
        int i = WhenMappings.$EnumSwitchMapping$0[networkState.getStatus().ordinal()];
        String str = "refreshLayout";
        if (i == 1) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
            swipeRefreshLayout.setRefreshing(true);
        } else if (i == 2) {
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
            swipeRefreshLayout2.setRefreshing(false);
        } else if (i != 3) {
            this.fittieRecommendAdapter.updateNetworkState(networkState);
        } else {
            this.fittieRecommendAdapter.updateNetworkState(networkState);
            SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout3, str);
            swipeRefreshLayout3.setRefreshing(false);
            ActivityExtensionKt.handleError(this, networkState.getMsg());
        }
    }

    public void onBackPressed() {
        RxBus.INSTANCE.post(new MainEvent$AppFinishEvent());
        finish();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "post_message")
    public final void onReceive(@NotNull Message message) {
        Intrinsics.checkParameterIsNotNull(message, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if (message.what == 2) {
            Logger.d("CHANGED_FOLLOW called at IntergratedSearchResultFragment", new Object[0]);
            this.fittieRecommendAdapter.updateFittieFollowing(message.getData().getLong("userId"), message.getData().getBoolean("isFollowed"));
        }
    }

    public void onFollowButtonClicked(long j) {
        FittieRecommendViewModel fittieRecommendViewModel = this.vm;
        if (fittieRecommendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        fittieRecommendViewModel.followButtonClick(j);
    }

    public void onUnFollowButtonClicked(long j) {
        FittieRecommendViewModel fittieRecommendViewModel = this.vm;
        if (fittieRecommendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        fittieRecommendViewModel.unfollowButtonClick(j);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
