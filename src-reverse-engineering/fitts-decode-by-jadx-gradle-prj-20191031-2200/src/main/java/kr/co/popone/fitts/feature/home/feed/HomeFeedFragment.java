package kr.co.popone.fitts.feature.home.feed;

import android.app.Activity;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.extension.BundleEnumExtensionKt;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.base.Scrollable;
import kr.co.popone.fitts.feature.feeds.CollectionFeedHolder;
import kr.co.popone.fitts.feature.feeds.TagFeedHolder;
import kr.co.popone.fitts.feature.home.feed.HomeFeedAdapter.Delegate;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.SlidingBanner$Type;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel.FeedType;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel.Navigation;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel.Navigation.PostActivity;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel.Navigation.ProductActivity;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel.Navigation.ShowRoom;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HomeFeedFragment extends Fragment implements Delegate, Scrollable {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_FEED_REQUEST_TYPE = "home_feed_type";
    private HashMap _$_findViewCache;
    private final HomeFeedAdapter homeFeedAdapter = new HomeFeedAdapter(this);
    @NotNull
    public HomeFeedViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HomeFeedFragment newInstance(@NotNull FeedType feedType) {
            Intrinsics.checkParameterIsNotNull(feedType, "feedType");
            HomeFeedFragment homeFeedFragment = new HomeFeedFragment();
            Bundle bundle = new Bundle();
            BundleEnumExtensionKt.putEnum(bundle, HomeFeedFragment.KEY_FEED_REQUEST_TYPE, feedType);
            homeFeedFragment.setArguments(bundle);
            return homeFeedFragment;
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
    public static final HomeFeedFragment newInstance(@NotNull FeedType feedType) {
        return Companion.newInstance(feedType);
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
    public final HomeFeedViewModel getViewModel() {
        HomeFeedViewModel homeFeedViewModel = this.viewModel;
        if (homeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return homeFeedViewModel;
    }

    public final void setViewModel(@NotNull HomeFeedViewModel homeFeedViewModel) {
        Intrinsics.checkParameterIsNotNull(homeFeedViewModel, "<set-?>");
        this.viewModel = homeFeedViewModel;
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
        HomeFeedViewModel homeFeedViewModel = this.viewModel;
        if (homeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return homeFeedViewModel.getSessionManager();
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_posts, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.homeFeedRecyclerView);
        recyclerView.setAdapter(this.homeFeedAdapter);
        recyclerView.addOnScrollListener(new HomeFeedFragment$onViewCreated$$inlined$apply$lambda$1(this));
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.homeFeedRefreshView)).setOnRefreshListener(new HomeFeedFragment$onViewCreated$2(this));
        HomeFeedViewModel homeFeedViewModel = this.viewModel;
        String str = "viewModel";
        if (homeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        homeFeedViewModel.updateFeeds().observe(this, new HomeFeedFragment$sam$androidx_lifecycle_Observer$0(new HomeFeedFragment$onViewCreated$3(this)));
        HomeFeedViewModel homeFeedViewModel2 = this.viewModel;
        if (homeFeedViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        homeFeedViewModel2.updateNetworkStates().observe(this, new HomeFeedFragment$sam$androidx_lifecycle_Observer$0(new HomeFeedFragment$onViewCreated$4(this)));
        HomeFeedViewModel homeFeedViewModel3 = this.viewModel;
        if (homeFeedViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        homeFeedViewModel3.updateScheme().observe(this, new HomeFeedFragment$sam$androidx_lifecycle_Observer$0(new HomeFeedFragment$onViewCreated$5(this)));
        HomeFeedViewModel homeFeedViewModel4 = this.viewModel;
        if (homeFeedViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        homeFeedViewModel4.navigateActivity().observe(this, new HomeFeedFragment$sam$androidx_lifecycle_Observer$0(new HomeFeedFragment$onViewCreated$6(this)));
    }

    /* access modifiers changed from: private */
    public final void handleHomeFeeds(PagedList<Feed> pagedList) {
        this.homeFeedAdapter.submitList(pagedList);
    }

    /* access modifiers changed from: private */
    public final void handleScheme(Function1<? super Activity, Unit> function1) {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        function1.invoke(requireActivity);
    }

    /* access modifiers changed from: private */
    public final void navigate(Navigation navigation) {
        if (navigation instanceof PostActivity) {
            kr.co.popone.fitts.feature.post.detail.PostActivity.Companion.start$default(kr.co.popone.fitts.feature.post.detail.PostActivity.Companion, getContext(), ((PostActivity) navigation).getId(), null, 4, null);
        } else if (navigation instanceof ProductActivity) {
            ProductActivity productActivity = (ProductActivity) navigation;
            kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, getContext(), productActivity.getUrl(), productActivity.getFrom(), null, null, 24, null);
        } else if (navigation instanceof ShowRoom) {
            ShowRoomActivity.Companion.start(getContext(), Long.valueOf(((ShowRoom) navigation).getId()), "home");
        }
    }

    /* access modifiers changed from: private */
    public final void handleNetworkStates(NetworkState networkState) {
        int i = WhenMappings.$EnumSwitchMapping$0[networkState.getStatus().ordinal()];
        String str = "homeFeedRefreshView";
        if (i == 1) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.homeFeedRefreshView);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
            swipeRefreshLayout.setRefreshing(true);
        } else if (i == 2) {
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.homeFeedRefreshView);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
            swipeRefreshLayout2.setRefreshing(false);
        } else if (i != 3) {
            SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.homeFeedRefreshView);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout3, str);
            swipeRefreshLayout3.setRefreshing(false);
            this.homeFeedAdapter.updateNetworkState(networkState);
        } else {
            SwipeRefreshLayout swipeRefreshLayout4 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.homeFeedRefreshView);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout4, str);
            swipeRefreshLayout4.setRefreshing(false);
            FragmentExtensionKt.handleError(this, networkState.getMsg());
        }
    }

    public void onPostClick(long j) {
        HomeFeedViewModel homeFeedViewModel = this.viewModel;
        if (homeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        homeFeedViewModel.postFeedClick(j);
    }

    public void onProductClick(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        HomeFeedViewModel homeFeedViewModel = this.viewModel;
        if (homeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        homeFeedViewModel.productFeedClick(str);
    }

    public void onFittieClick(long j) {
        HomeFeedViewModel homeFeedViewModel = this.viewModel;
        if (homeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        homeFeedViewModel.fittieFeedClick(j);
    }

    public void onSchemeClick(@NotNull ViewHolder viewHolder, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        String str2 = "viewModel";
        if (viewHolder instanceof TagFeedHolder) {
            HomeFeedViewModel homeFeedViewModel = this.viewModel;
            if (homeFeedViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
            }
            homeFeedViewModel.trendTagClick(str);
        } else if (viewHolder instanceof CollectionFeedHolder) {
            HomeFeedViewModel homeFeedViewModel2 = this.viewModel;
            if (homeFeedViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
            }
            homeFeedViewModel2.collectionSchemeClick(str);
        } else {
            HomeFeedViewModel homeFeedViewModel3 = this.viewModel;
            if (homeFeedViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
            }
            homeFeedViewModel3.schemeFeedClick(str);
        }
    }

    public void onSlidingBannerClick(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        HomeFeedViewModel homeFeedViewModel = this.viewModel;
        if (homeFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        homeFeedViewModel.schemeFeedClick(str);
    }

    public void scrollTop() {
        if (isResumed()) {
            ((RecyclerView) _$_findCachedViewById(C0010R$id.homeFeedRecyclerView)).scrollToPosition(0);
        }
    }

    public void onDestroy() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.homeFeedRecyclerView);
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        super.onDestroy();
    }
}
