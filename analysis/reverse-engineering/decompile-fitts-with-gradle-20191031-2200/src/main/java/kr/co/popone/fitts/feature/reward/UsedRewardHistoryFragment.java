package kr.co.popone.fitts.feature.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.appreview.AppReview;
import kr.co.popone.fitts.model.datamodel.commerce.PaymentInvoiceResult;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.model.payment.PaymentAPI.DefaultImpls;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UsedRewardHistoryFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    @Nullable
    private Function0<Unit> dataReloadListener;
    /* access modifiers changed from: private */
    public boolean hasMoreUsedRewardHistory;
    @NotNull
    public PaymentAPI paymentAPI;
    /* access modifiers changed from: private */
    public List<PaymentUsage> usedRewardHistoryList = CollectionsKt__CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public Disposable usedRewardHistoryRequest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UsedRewardHistoryFragment newInstance() {
            UsedRewardHistoryFragment usedRewardHistoryFragment = new UsedRewardHistoryFragment();
            usedRewardHistoryFragment.setArguments(new Bundle());
            return usedRewardHistoryFragment;
        }
    }

    @NotNull
    public static final UsedRewardHistoryFragment newInstance() {
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

    @NotNull
    public final PaymentAPI getPaymentAPI$app_productionFittsRelease() {
        PaymentAPI paymentAPI2 = this.paymentAPI;
        if (paymentAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentAPI");
        }
        return paymentAPI2;
    }

    public final void setPaymentAPI$app_productionFittsRelease(@NotNull PaymentAPI paymentAPI2) {
        Intrinsics.checkParameterIsNotNull(paymentAPI2, "<set-?>");
        this.paymentAPI = paymentAPI2;
    }

    @Nullable
    public final Function0<Unit> getDataReloadListener() {
        return this.dataReloadListener;
    }

    public final void setDataReloadListener(@Nullable Function0<Unit> function0) {
        this.dataReloadListener = function0;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_used_reward_history, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.usedRewardHistoryRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "usedRewardHistoryRecyclerView");
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        String str = "context!!";
        Intrinsics.checkExpressionValueIsNotNull(context, str);
        recyclerView.setAdapter(new UsedRewardHistoryAdapter(context, new UsedRewardHistoryFragment$onViewCreated$1(this)));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.usedRewardHistoryRecyclerView);
        Context context2 = getContext();
        if (context2 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context2, str);
        recyclerView2.addItemDecoration(new RewardItemDecoration(context2, 24, 24));
        ((RecyclerView) _$_findCachedViewById(C0010R$id.usedRewardHistoryRecyclerView)).addOnScrollListener(new UsedRewardHistoryFragment$onViewCreated$2(this));
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout)).setOnRefreshListener(new UsedRewardHistoryFragment$onViewCreated$3(this));
        loadUsedRewardHistory(true);
    }

    public void onDestroyView() {
        Disposable disposable = this.usedRewardHistoryRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        this.usedRewardHistoryRequest = null;
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 100) {
            if (i2 == 100) {
                loadUsedRewardHistory(true);
                Function0<Unit> function0 = this.dataReloadListener;
                if (!(function0 == null || function0 == null)) {
                    Unit unit = (Unit) function0.invoke();
                }
            } else if (i2 == -1 && intent != null && ((PaymentInvoiceResult) intent.getParcelableExtra("result")).getCompletedInvoice()) {
                AppReview appReview = AppReview.INSTANCE;
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
                appReview.showFirstReviewDialog(activity);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: private */
    public final void loadUsedRewardHistory(boolean z) {
        Disposable disposable = this.usedRewardHistoryRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        if (z) {
            this.usedRewardHistoryList = CollectionsKt__CollectionsKt.emptyList();
            this.hasMoreUsedRewardHistory = false;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
            swipeRefreshLayout.setRefreshing(true);
        }
        PaymentAPI paymentAPI2 = this.paymentAPI;
        if (paymentAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentAPI");
        }
        this.usedRewardHistoryRequest = DefaultImpls.requestPaymentInvoiceList$default(paymentAPI2, this.usedRewardHistoryList.isEmpty() ^ true ? Long.valueOf(((PaymentUsage) CollectionsKt___CollectionsKt.last(this.usedRewardHistoryList)).getId()) : null, Integer.valueOf(20), null, 4, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new UsedRewardHistoryFragment$loadUsedRewardHistory$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final void updateUsedRewardHistoryViews() {
        String str = "recyclerEmptyLayout";
        String str2 = "usedRewardHistoryRecyclerView";
        if (this.usedRewardHistoryList.size() < 1) {
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C0010R$id.recyclerEmptyLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, str);
            constraintLayout.setVisibility(0);
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.usedRewardHistoryRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, str2);
            recyclerView.setVisibility(8);
        } else {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C0010R$id.recyclerEmptyLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, str);
            constraintLayout2.setVisibility(8);
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.usedRewardHistoryRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str2);
            recyclerView2.setVisibility(0);
        }
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C0010R$id.usedRewardHistoryRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView3, str2);
        Adapter adapter = recyclerView3.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void reloadData() {
        loadUsedRewardHistory(true);
    }
}
