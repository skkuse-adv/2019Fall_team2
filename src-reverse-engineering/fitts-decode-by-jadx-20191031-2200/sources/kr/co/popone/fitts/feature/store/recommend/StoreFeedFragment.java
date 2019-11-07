package kr.co.popone.fitts.feature.store.recommend;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.extension.BundleEnumExtensionKt;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.event.ShopBookmarkEvent;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.feature.base.Scrollable;
import kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.feature.store.recommend.StoreFeedAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.SlidingBanner$Type;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModel;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModel.StoreFeedType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreFeedFragment extends Fragment implements Scrollable, Delegate {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_STORE_FEED_TYPE = "store_feed_type";
    private HashMap _$_findViewCache;
    private final StoreFeedAdapter storeFeedAdapter = new StoreFeedAdapter(this);
    @NotNull
    public StoreFeedViewModel vm;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StoreFeedFragment newInstance(@NotNull StoreFeedType storeFeedType) {
            Intrinsics.checkParameterIsNotNull(storeFeedType, "type");
            StoreFeedFragment storeFeedFragment = new StoreFeedFragment();
            Bundle bundle = new Bundle();
            BundleEnumExtensionKt.putEnum(bundle, StoreFeedFragment.KEY_STORE_FEED_TYPE, storeFeedType);
            storeFeedFragment.setArguments(bundle);
            return storeFeedFragment;
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

    @NotNull
    public static final StoreFeedFragment newInstance(@NotNull StoreFeedType storeFeedType) {
        return Companion.newInstance(storeFeedType);
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
    public final StoreFeedViewModel getVm() {
        StoreFeedViewModel storeFeedViewModel = this.vm;
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        return storeFeedViewModel;
    }

    public final void setVm(@NotNull StoreFeedViewModel storeFeedViewModel) {
        Intrinsics.checkParameterIsNotNull(storeFeedViewModel, "<set-?>");
        this.vm = storeFeedViewModel;
    }

    @NotNull
    public SlidingBanner$Type getSlidingBanner() {
        return SlidingBanner$Type.SHOP;
    }

    @Nullable
    public Lifecycle getProvidedLifecycle() {
        return getLifecycle();
    }

    @Nullable
    public SessionManager getSessionManager() {
        StoreFeedViewModel storeFeedViewModel = this.vm;
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        return storeFeedViewModel.getSession();
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_store_new, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.storeRecommendRecyclerView);
        recyclerView.setAdapter(this.storeFeedAdapter);
        recyclerView.addOnScrollListener(new StoreFeedFragment$onViewCreated$$inlined$apply$lambda$1(this));
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout)).setOnRefreshListener(new StoreFeedFragment$onViewCreated$2(this));
        StoreFeedViewModel storeFeedViewModel = this.vm;
        String str = "vm";
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeFeedViewModel.updateStoreFeeds().observe(this, new StoreFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreFeedFragment$onViewCreated$3(this)));
        StoreFeedViewModel storeFeedViewModel2 = this.vm;
        if (storeFeedViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeFeedViewModel2.routeStoreBridge().observe(this, new StoreFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreFeedFragment$onViewCreated$4(this)));
        StoreFeedViewModel storeFeedViewModel3 = this.vm;
        if (storeFeedViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeFeedViewModel3.routeStoreBrowser().observe(this, new StoreFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreFeedFragment$onViewCreated$5(this)));
        StoreFeedViewModel storeFeedViewModel4 = this.vm;
        if (storeFeedViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeFeedViewModel4.updateNetworkState().observe(this, new StoreFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreFeedFragment$onViewCreated$6(this)));
        StoreFeedViewModel storeFeedViewModel5 = this.vm;
        if (storeFeedViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeFeedViewModel5.updateProductLikeState().observeForever(new StoreFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreFeedFragment$onViewCreated$7(this)));
        StoreFeedViewModel storeFeedViewModel6 = this.vm;
        if (storeFeedViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeFeedViewModel6.bookmarkStateUpdated().observeForever(new StoreFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreFeedFragment$onViewCreated$8(this)));
    }

    /* access modifiers changed from: private */
    public final void updateStoreFeeds(PagedList<Feed> pagedList) {
        this.storeFeedAdapter.submitList(pagedList);
    }

    /* access modifiers changed from: private */
    public final void updateProductLikeState(WishStateUpdateEvent wishStateUpdateEvent) {
        this.storeFeedAdapter.updateProductLikeState(wishStateUpdateEvent);
    }

    /* access modifiers changed from: private */
    public final void updateShopBookmarkState(ShopBookmarkEvent shopBookmarkEvent) {
        this.storeFeedAdapter.updateShopBookmarkState(shopBookmarkEvent);
    }

    /* access modifiers changed from: private */
    public final void startStoreBridgeActivity(long j) {
        ShopBridgeActivity.Companion.start(getContext(), j);
    }

    /* access modifiers changed from: private */
    public final void startStoreBrowserActivity(Pair<String, String> pair) {
        kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, getContext(), (String) pair.getFirst(), (String) pair.getSecond(), null, null, 24, null);
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
            this.storeFeedAdapter.updateNetworkState(networkState);
        } else {
            SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout3, str);
            swipeRefreshLayout3.setRefreshing(false);
            FragmentExtensionKt.handleError(this, networkState.getMsg());
        }
    }

    public void onSlidingBannerClick(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        StoreFeedViewModel storeFeedViewModel = this.vm;
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        storeFeedViewModel.storeBannerClicked(requireActivity, str);
    }

    public void onSchemeClick(@NotNull ViewHolder viewHolder, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        StoreFeedViewModel storeFeedViewModel = this.vm;
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        storeFeedViewModel.storeViewSchemeClick(requireActivity, str);
    }

    public void onProductClick(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        StoreFeedViewModel storeFeedViewModel = this.vm;
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        storeFeedViewModel.productFeedClick(j, str);
    }

    public void onAddLikeProduct(long j) {
        StoreFeedViewModel storeFeedViewModel = this.vm;
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        storeFeedViewModel.addLikeProductClick(j);
    }

    public void onRemoveLikeProduct(long j) {
        StoreFeedViewModel storeFeedViewModel = this.vm;
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        storeFeedViewModel.removeLikeProductClick(j);
    }

    public void onAddShopBookmark(long j) {
        StoreFeedViewModel storeFeedViewModel = this.vm;
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        storeFeedViewModel.addShopBookmarkClick(j);
    }

    public void onRemoveShopBookmark(long j) {
        StoreFeedViewModel storeFeedViewModel = this.vm;
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        storeFeedViewModel.removeShopBookmarkClick(j);
    }

    public void onShopClick(long j) {
        StoreFeedViewModel storeFeedViewModel = this.vm;
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        storeFeedViewModel.shopFeedClick(j);
    }

    public void scrollTop() {
        if (isAdded()) {
            ((RecyclerView) _$_findCachedViewById(C0010R$id.storeRecommendRecyclerView)).scrollToPosition(0);
        }
    }

    public void onDestroy() {
        StoreFeedViewModel storeFeedViewModel = this.vm;
        String str = "vm";
        if (storeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeFeedViewModel.updateProductLikeState().removeObservers(this);
        StoreFeedViewModel storeFeedViewModel2 = this.vm;
        if (storeFeedViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        storeFeedViewModel2.bookmarkStateUpdated().removeObservers(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.storeRecommendRecyclerView);
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        super.onDestroy();
    }
}
