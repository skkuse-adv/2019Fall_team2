package kr.co.popone.fitts.feature.search.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.feature.search.adapter.IntergratedSearchResultAdapter;
import kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.model.search.IntergratedSearchViewData;
import kr.co.popone.fitts.ui.decorator.IntergratedSearchDecorator;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

public final class IntergratedSearchResultFragment extends Fragment implements kr.co.popone.fitts.feature.search.adapter.IntergratedSearchResultAdapter.Delegate {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    @Nullable
    private Delegate delegate;
    private final IntergratedSearchResultAdapter intergratedSearchResultAdapter = new IntergratedSearchResultAdapter(this);
    @NotNull
    public SearchResultViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IntergratedSearchResultFragment newInstance() {
            return new IntergratedSearchResultFragment();
        }
    }

    public interface Delegate {
        void onSearchTabSwitch(int i);
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

    @NotNull
    public static final IntergratedSearchResultFragment newInstance() {
        return Companion.newInstance();
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
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final SearchResultViewModel getViewModel() {
        SearchResultViewModel searchResultViewModel = this.viewModel;
        if (searchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return searchResultViewModel;
    }

    public final void setViewModel(@NotNull SearchResultViewModel searchResultViewModel) {
        Intrinsics.checkParameterIsNotNull(searchResultViewModel, "<set-?>");
        this.viewModel = searchResultViewModel;
    }

    @Nullable
    public final Delegate getDelegate$app_productionFittsRelease() {
        return this.delegate;
    }

    public final void setDelegate$app_productionFittsRelease(@Nullable Delegate delegate2) {
        this.delegate = delegate2;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        if (context instanceof SearchActivity) {
            this.delegate = (Delegate) context;
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_integrated_result, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        EventBus.getDefault().register(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.searchRecyclerView);
        recyclerView.setAdapter(this.intergratedSearchResultAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            Context context = recyclerView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            recyclerView.addItemDecoration(new IntergratedSearchDecorator(context, C0008R$drawable.divider_line_gray));
        }
        SearchResultViewModel searchResultViewModel = this.viewModel;
        String str = "viewModel";
        if (searchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchResultViewModel.getUnifiedResult().observe(new IntergratedSearchResultFragment$onViewCreated$2(this), new IntergratedSearchResultFragment$onViewCreated$3(this));
        SearchResultViewModel searchResultViewModel2 = this.viewModel;
        if (searchResultViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchResultViewModel2.getUnifiedNetworkState().observe(new IntergratedSearchResultFragment$onViewCreated$4(this), new IntergratedSearchResultFragment$onViewCreated$5(this));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "refreshLayout");
        swipeRefreshLayout.setEnabled(false);
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "follow_message")
    private final void onReceive(Message message) {
        if (message.what == 2) {
            updateFollowState(message.getData().getLong("userId"), message.getData().getBoolean("isFollowed"));
        }
    }

    private final void updateFollowState(long j, boolean z) {
        this.intergratedSearchResultAdapter.updateFittieFollowing(j, z);
    }

    /* access modifiers changed from: private */
    public final void updateSearchResult(IntergratedSearchViewData intergratedSearchViewData) {
        String str = "searchRecyclerView";
        String str2 = "emptyResultView";
        if (!intergratedSearchViewData.getPosts().isEmpty() || !intergratedSearchViewData.getUsers().isEmpty() || !intergratedSearchViewData.getProducts().isEmpty() || !intergratedSearchViewData.getStore().isEmpty()) {
            this.intergratedSearchResultAdapter.updateIntergratedSearchResult(intergratedSearchViewData);
            View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.emptyResultView);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, str2);
            _$_findCachedViewById.setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.searchRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
            recyclerView.setVisibility(0);
            return;
        }
        View _$_findCachedViewById2 = _$_findCachedViewById(C0010R$id.emptyResultView);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, str2);
        _$_findCachedViewById2.setVisibility(0);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.searchRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
        recyclerView2.setVisibility(8);
    }

    public void onProductClicked(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, getContext(), str, "search", null, null, 24, null);
        SearchResultViewModel searchResultViewModel = this.viewModel;
        if (searchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        searchResultViewModel.leaveActionLog("Product");
    }

    public void onPostClick(long j) {
        kr.co.popone.fitts.feature.post.detail.PostActivity.Companion.start$default(PostActivity.Companion, getContext(), j, null, 4, null);
        SearchResultViewModel searchResultViewModel = this.viewModel;
        if (searchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        searchResultViewModel.leaveActionLog("Post");
    }

    public void onStoreClicked(long j) {
        SearchResultViewModel searchResultViewModel = this.viewModel;
        if (searchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        searchResultViewModel.logTapShopList();
        ShopBridgeActivity.Companion.start(getContext(), j);
    }

    public void onFollowClick(long j, boolean z) {
        SearchResultViewModel searchResultViewModel = this.viewModel;
        if (searchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        searchResultViewModel.updateFollowState(j, z);
    }

    public void switchPostTab() {
        Delegate delegate2 = this.delegate;
        if (delegate2 != null) {
            delegate2.onSearchTabSwitch(1);
        }
    }

    public void switchProductTab() {
        Delegate delegate2 = this.delegate;
        if (delegate2 != null) {
            delegate2.onSearchTabSwitch(2);
        }
    }

    public void switchFittieTab() {
        Delegate delegate2 = this.delegate;
        if (delegate2 != null) {
            delegate2.onSearchTabSwitch(3);
        }
    }

    public void onDestroy() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.searchRecyclerView);
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        super.onDestroy();
    }
}
