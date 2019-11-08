package kr.co.popone.fitts.feature.store.newest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.feature.base.Scrollable;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.feature.store.newest.NewestProductAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.viewmodel.store.newest.NewestProductViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreNewFeedFragment extends Fragment implements Delegate, Scrollable {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final NewestProductAdapter feedsAdapter = new NewestProductAdapter(this);
    @NotNull
    public NewestProductViewModel vm;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StoreNewFeedFragment newInstance() {
            return new StoreNewFeedFragment();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.RUNNING.ordinal()] = 3;
            $EnumSwitchMapping$0[Status.SUCCESS.ordinal()] = 4;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 5;
        }
    }

    @NotNull
    public static final StoreNewFeedFragment newInstance() {
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
    public final NewestProductViewModel getVm() {
        NewestProductViewModel newestProductViewModel = this.vm;
        if (newestProductViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        return newestProductViewModel;
    }

    public final void setVm(@NotNull NewestProductViewModel newestProductViewModel) {
        Intrinsics.checkParameterIsNotNull(newestProductViewModel, "<set-?>");
        this.vm = newestProductViewModel;
    }

    @Nullable
    public SessionManager getSessionManager() {
        NewestProductViewModel newestProductViewModel = this.vm;
        if (newestProductViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        return newestProductViewModel.getSessionManager();
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_newest_product, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.newestProductRecyclerView);
        recyclerView.setAdapter(this.feedsAdapter);
        recyclerView.addOnScrollListener(new StoreNewFeedFragment$onViewCreated$$inlined$apply$lambda$1(this));
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout)).setOnRefreshListener(new StoreNewFeedFragment$onViewCreated$2(this));
        NewestProductViewModel newestProductViewModel = this.vm;
        String str = "vm";
        if (newestProductViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        newestProductViewModel.updateStoreNewFeeds().observe(this, new StoreNewFeedFragment$onViewCreated$3(this));
        NewestProductViewModel newestProductViewModel2 = this.vm;
        if (newestProductViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        newestProductViewModel2.updateNetworkState().observe(this, new StoreNewFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreNewFeedFragment$onViewCreated$4(this)));
        NewestProductViewModel newestProductViewModel3 = this.vm;
        if (newestProductViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        newestProductViewModel3.updateRemainTimeText().observe(this, new StoreNewFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreNewFeedFragment$onViewCreated$5(this)));
        NewestProductViewModel newestProductViewModel4 = this.vm;
        if (newestProductViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        newestProductViewModel4.updateRemainPercentage().observe(this, new StoreNewFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreNewFeedFragment$onViewCreated$6(this)));
        NewestProductViewModel newestProductViewModel5 = this.vm;
        if (newestProductViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        newestProductViewModel5.updateSpecialDiscountView().observe(this, new StoreNewFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreNewFeedFragment$onViewCreated$7(this)));
        NewestProductViewModel newestProductViewModel6 = this.vm;
        if (newestProductViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        newestProductViewModel6.updateSpecialDiscountEvent().observe(this, new StoreNewFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreNewFeedFragment$onViewCreated$8(this)));
        NewestProductViewModel newestProductViewModel7 = this.vm;
        if (newestProductViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        newestProductViewModel7.updateProductLikeState().observeForever(new StoreNewFeedFragment$sam$androidx_lifecycle_Observer$0(new StoreNewFeedFragment$onViewCreated$9(this)));
    }

    /* access modifiers changed from: private */
    public final void handleNetworkState(NetworkState networkState) {
        Status status;
        if (networkState != null) {
            status = networkState.getStatus();
        } else {
            status = null;
        }
        if (status != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            String str = "refreshLayout";
            if (i == 1) {
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
                swipeRefreshLayout.setRefreshing(true);
            } else if (i == 2) {
                SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
                swipeRefreshLayout2.setRefreshing(false);
            } else if (i == 3 || i == 4) {
                this.feedsAdapter.updateNetworkState(networkState);
            } else if (i == 5) {
                SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout3, str);
                swipeRefreshLayout3.setRefreshing(false);
                this.feedsAdapter.updateNetworkState(networkState);
                FragmentExtensionKt.handleError(this, networkState.getMsg());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateSpecialDiscountText(String str) {
        if (str != null) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textRemainTime);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textRemainTime");
            textView.setText(str);
            return;
        }
        View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.viewTimeRemain);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "viewTimeRemain");
        ViewExtensionsKt.gone(_$_findCachedViewById);
    }

    /* access modifiers changed from: private */
    public final void updateRemainPercentage(Integer num) {
        ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.imageRemainProgress);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageRemainProgress");
        Drawable drawable = imageView.getDrawable();
        Intrinsics.checkExpressionValueIsNotNull(drawable, "imageRemainProgress.drawable");
        drawable.setLevel(num != null ? num.intValue() : 0);
    }

    /* access modifiers changed from: private */
    public final void updateSpecialDiscountView(boolean z) {
        String str = "viewTimeRemain";
        if (z) {
            View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.viewTimeRemain);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, str);
            ViewExtensionsKt.visible(_$_findCachedViewById);
            return;
        }
        View _$_findCachedViewById2 = _$_findCachedViewById(C0010R$id.viewTimeRemain);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, str);
        ViewExtensionsKt.gone(_$_findCachedViewById2);
    }

    /* access modifiers changed from: private */
    public final void updateProductLikeState(WishStateUpdateEvent wishStateUpdateEvent) {
        this.feedsAdapter.updateProductLikeState(wishStateUpdateEvent);
    }

    /* access modifiers changed from: private */
    public final void updateSpecialDiscountEvent(SpecialDiscountInfo specialDiscountInfo) {
        NewestProductViewModel newestProductViewModel = this.vm;
        if (newestProductViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        newestProductViewModel.handleSpecialDiscountInfo(specialDiscountInfo);
    }

    public void onSchemeClick(@NotNull ViewHolder viewHolder, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        NewestProductViewModel newestProductViewModel = this.vm;
        if (newestProductViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        newestProductViewModel.handleScheme(requireActivity, str);
    }

    public void onAddLikeProduct(long j) {
        NewestProductViewModel newestProductViewModel = this.vm;
        if (newestProductViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        newestProductViewModel.addLikeProductClick(j);
    }

    public void onRemoveLikeProduct(long j) {
        NewestProductViewModel newestProductViewModel = this.vm;
        if (newestProductViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        newestProductViewModel.removeLikeProductClick(j);
    }

    public void onProductClick(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, getContext(), str, "store new", null, null, 24, null);
        NewestProductViewModel newestProductViewModel = this.vm;
        if (newestProductViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        newestProductViewModel.onProductClicked(j);
    }

    public void onSpecialDiscountClick(long j, long j2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        String str2 = str;
        kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, getContext(), str2, "store new", Long.valueOf(j2), null, 16, null);
        NewestProductViewModel newestProductViewModel = this.vm;
        if (newestProductViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        newestProductViewModel.onProductClicked(j);
    }

    public void scrollTop() {
        if (isAdded()) {
            ((RecyclerView) _$_findCachedViewById(C0010R$id.newestProductRecyclerView)).scrollToPosition(0);
        }
    }

    public void onDestroy() {
        NewestProductViewModel newestProductViewModel = this.vm;
        if (newestProductViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        newestProductViewModel.updateProductLikeState().removeObservers(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.newestProductRecyclerView);
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        super.onDestroy();
    }
}
