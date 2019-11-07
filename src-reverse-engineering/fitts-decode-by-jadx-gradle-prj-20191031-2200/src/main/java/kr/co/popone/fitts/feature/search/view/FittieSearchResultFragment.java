package kr.co.popone.fitts.feature.search.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.search.adapter.FittieResultAdapter;
import kr.co.popone.fitts.feature.search.adapter.FittieResultAdapter.Delegate;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.decorator.FittieSearchResultDecorator;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

public final class FittieSearchResultFragment extends Fragment implements Delegate {
    private HashMap _$_findViewCache;
    @NotNull
    public SearchResultViewModel viewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 3;
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

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_fittie_search_result, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        EventBus.getDefault().register(this);
        FittieResultAdapter fittieResultAdapter = new FittieResultAdapter(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerFittieSearchResult);
        recyclerView.setAdapter(fittieResultAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new FittieSearchResultDecorator());
        }
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout)).setOnRefreshListener(new FittieSearchResultFragment$onViewCreated$2(this));
        SearchResultViewModel searchResultViewModel = this.viewModel;
        String str = "viewModel";
        if (searchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchResultViewModel.getFittieResult().observe(new FittieSearchResultFragment$onViewCreated$3(this), new FittieSearchResultFragment$onViewCreated$4(fittieResultAdapter));
        SearchResultViewModel searchResultViewModel2 = this.viewModel;
        if (searchResultViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchResultViewModel2.isEmptyFitties().observe(new FittieSearchResultFragment$onViewCreated$5(this), new FittieSearchResultFragment$onViewCreated$6(this));
        SearchResultViewModel searchResultViewModel3 = this.viewModel;
        if (searchResultViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchResultViewModel3.getFittieNetworkState().observe(new FittieSearchResultFragment$onViewCreated$7(this), new FittieSearchResultFragment$onViewCreated$8(this, fittieResultAdapter));
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "follow_message")
    private final void onReceive(Message message) {
        if (message.what == 2) {
            updateFollowState(message.getData().getLong("userId"), message.getData().getBoolean("isFollowed"));
        }
    }

    private final void updateFollowState(long j, boolean z) {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerFittieSearchResult);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerFittieSearchResult");
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            ((FittieResultAdapter) adapter).updateItemFollowState(j, z);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.search.adapter.FittieResultAdapter");
    }

    /* access modifiers changed from: private */
    public final void updateEmptyList(boolean z) {
        String str = "emptyResultView";
        String str2 = "recyclerFittieSearchResult";
        if (z) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerFittieSearchResult);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, str2);
            ViewExtensionsKt.invisible(recyclerView);
            View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.emptyResultView);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, str);
            ViewExtensionsKt.visible(_$_findCachedViewById);
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerFittieSearchResult);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str2);
        ViewExtensionsKt.visible(recyclerView2);
        View _$_findCachedViewById2 = _$_findCachedViewById(C0010R$id.emptyResultView);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, str);
        ViewExtensionsKt.invisible(_$_findCachedViewById2);
    }

    public void onProfileClick(long j) {
        ShowRoomActivity.Companion.start(getContext(), Long.valueOf(j), "search");
    }

    public void onFollowClick(long j, boolean z) {
        SearchResultViewModel searchResultViewModel = this.viewModel;
        if (searchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        searchResultViewModel.updateFollowState(j, z);
    }

    public void onDestroyView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerFittieSearchResult);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerFittieSearchResult");
        recyclerView.setAdapter(null);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
