package kr.co.popone.fitts.feature.coupon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
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
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.feature.coupon.CouponUseActivity.Parameters;
import kr.co.popone.fitts.feature.identification.view.IdentificationActivity;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CouponListFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int availableCouponCount;
    /* access modifiers changed from: private */
    public Disposable availableCouponCountRequest;
    @NotNull
    public CouponAPI couponAPI;
    private CouponInfo couponInfo;
    /* access modifiers changed from: private */
    public List<CouponInfo> couponInfoList = CollectionsKt__CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public Disposable couponInfoListRequest;
    /* access modifiers changed from: private */
    public boolean hasMoreCouponList;
    private boolean initialDataLoaded;
    @NotNull
    public SessionManager sessionManager;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CouponListFragment newInstance() {
            return new CouponListFragment();
        }
    }

    public interface OnFragmentInteractionListener {
    }

    @NotNull
    public static final CouponListFragment newInstance() {
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
    public final CouponAPI getCouponAPI$app_productionFittsRelease() {
        CouponAPI couponAPI2 = this.couponAPI;
        if (couponAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponAPI");
        }
        return couponAPI2;
    }

    public final void setCouponAPI$app_productionFittsRelease(@NotNull CouponAPI couponAPI2) {
        Intrinsics.checkParameterIsNotNull(couponAPI2, "<set-?>");
        this.couponAPI = couponAPI2;
    }

    @NotNull
    public final SessionManager getSessionManager$app_productionFittsRelease() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager$app_productionFittsRelease(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_coupon_list, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout)).setOnRefreshListener(new CouponListFragment$onViewCreated$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        recyclerView.setAdapter(new CouponListAdapter(new CouponListFragment$onViewCreated$2(this), new CouponListFragment$onViewCreated$3(this)));
        ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView)).addOnScrollListener(new CouponListFragment$onViewCreated$4(this));
    }

    public void onStart() {
        super.onStart();
        if (!this.initialDataLoaded) {
            loadAvailableCouponCount();
            loadCouponList(false);
        }
    }

    /* access modifiers changed from: private */
    public final void loadCouponList(boolean z) {
        Disposable disposable = this.couponInfoListRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        String str = "recyclerView";
        if (!z) {
            this.couponInfoList = CollectionsKt__CollectionsKt.emptyList();
            this.hasMoreCouponList = false;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
            swipeRefreshLayout.setRefreshing(true);
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
            Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } else {
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
            Adapter adapter2 = recyclerView2.getAdapter();
            if (adapter2 != null) {
                ((CouponListAdapter) adapter2).setShowsLoading(true);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.coupon.CouponListAdapter");
            }
        }
        CouponAPI couponAPI2 = this.couponAPI;
        if (couponAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponAPI");
        }
        this.couponInfoListRequest = couponAPI2.requestCoupons(this.couponInfoList.isEmpty() ^ true ? Long.valueOf(((CouponInfo) CollectionsKt___CollectionsKt.last(this.couponInfoList)).getId()) : null, Integer.valueOf(20)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new CouponListFragment$loadCouponList$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final void updateUsedCouponHistoryViews() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C0010R$id.recyclerEmptyLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "recyclerEmptyLayout");
        constraintLayout.setVisibility(this.couponInfoList.size() < 1 ? 0 : 8);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void loadAvailableCouponCount() {
        if (this.availableCouponCountRequest == null) {
            CouponAPI couponAPI2 = this.couponAPI;
            if (couponAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("couponAPI");
            }
            this.availableCouponCountRequest = couponAPI2.requestAvailableCouponCount().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new CouponListFragment$loadAvailableCouponCount$1<Object,Object>(this));
        }
    }

    /* access modifiers changed from: private */
    public final void useFittsCoupon(CouponInfo couponInfo2) {
        this.couponInfo = couponInfo2;
        String str = "sessionManager";
        String str2 = "assigned";
        if (couponInfo2.getAgreement() == null) {
            if (Intrinsics.areEqual((Object) couponInfo2.getState(), (Object) str2)) {
                SessionManager sessionManager2 = this.sessionManager;
                if (sessionManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                }
                MyInfo userInfo = sessionManager2.getUserInfo();
                if (userInfo == null) {
                    return;
                }
                if (userInfo.getRequiredIdentityVerify()) {
                    startCouponPointInputUserInfoActivity(100, couponInfo2);
                } else {
                    startCouponUseActivity(couponInfo2);
                }
            }
        } else if (Intrinsics.areEqual((Object) couponInfo2.getState(), (Object) str2)) {
            SessionManager sessionManager3 = this.sessionManager;
            if (sessionManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            MyInfo userInfo2 = sessionManager3.getUserInfo();
            if (userInfo2 == null) {
                return;
            }
            if (userInfo2.getRequiredIdentityVerify()) {
                startCouponPointInputUserInfoActivity(102, couponInfo2);
            } else if (couponInfo2.getAgreement().booleanValue()) {
                startCouponUseActivity(couponInfo2);
            } else if (!couponInfo2.getAgreement().booleanValue()) {
                startTermsAgreeWebViewActivity(101, couponInfo2);
            } else {
                startCouponUseActivity(couponInfo2);
            }
        }
    }

    private final void startCouponUseActivity(CouponInfo couponInfo2) {
        Parameters parameters = new Parameters(couponInfo2.getId(), couponInfo2.getValue());
        Intent intent = new Intent(getContext(), CouponUseActivity.class);
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(context, C0001R$anim.slide_up, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
        intent.putExtra("parameters", parameters);
        startActivity(intent, makeCustomAnimation.toBundle());
    }

    /* access modifiers changed from: private */
    public final void startTermsAgreeWebViewActivity(int i, CouponInfo couponInfo2) {
        if (couponInfo2.getAgreementImage() != null) {
            long id = couponInfo2.getId();
            String url = couponInfo2.getAgreementImage().getUrl();
            if (url == null) {
                Intrinsics.throwNpe();
            }
            Boolean agreement = couponInfo2.getAgreement();
            if (agreement == null) {
                Intrinsics.throwNpe();
            }
            TermsAgreeWebViewActivity.Parameters parameters = new TermsAgreeWebViewActivity.Parameters(id, url, agreement.booleanValue());
            Intent intent = new Intent(getContext(), TermsAgreeWebViewActivity.class);
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(context, C0001R$anim.slide_up, C0001R$anim.fade_out);
            Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
            intent.putExtra("parameters", parameters);
            startActivityForResult(intent, i, makeCustomAnimation.toBundle());
        }
    }

    private final void startCouponPointInputUserInfoActivity(int i, CouponInfo couponInfo2) {
        Intent intent = new Intent(getContext(), IdentificationActivity.class);
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(context, ActivityAnimationType.SLIDE_UP.getEnter(), ActivityAnimationType.SLIDE_UP.getExit());
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…mationType.SLIDE_UP.exit)");
        startActivityForResult(intent, i, makeCustomAnimation.toBundle());
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str = "sessionManager";
        switch (i) {
            case 100:
                if (i2 == -1) {
                    CouponInfo couponInfo2 = this.couponInfo;
                    if (couponInfo2 != null) {
                        SessionManager sessionManager2 = this.sessionManager;
                        if (sessionManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(str);
                        }
                        sessionManager2.loadUserInfo();
                        startCouponUseActivity(couponInfo2);
                        return;
                    }
                    return;
                }
                return;
            case 101:
                if (i2 == -1) {
                    CouponInfo couponInfo3 = this.couponInfo;
                    if (couponInfo3 != null) {
                        startCouponUseActivity(couponInfo3);
                        return;
                    }
                    return;
                }
                return;
            case 102:
                if (i2 == -1) {
                    SessionManager sessionManager3 = this.sessionManager;
                    if (sessionManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    sessionManager3.loadUserInfo();
                    CouponInfo couponInfo4 = this.couponInfo;
                    if (couponInfo4 != null) {
                        Boolean agreement = couponInfo4.getAgreement();
                        if (agreement == null) {
                            Intrinsics.throwNpe();
                        }
                        if (!agreement.booleanValue()) {
                            startTermsAgreeWebViewActivity(101, couponInfo4);
                            return;
                        } else {
                            startCouponUseActivity(couponInfo4);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }

    public void onDestroyView() {
        Disposable disposable = this.availableCouponCountRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        this.availableCouponCountRequest = null;
        Disposable disposable2 = this.couponInfoListRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.couponInfoListRequest = null;
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            OnFragmentInteractionListener onFragmentInteractionListener = (OnFragmentInteractionListener) context;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.toString());
        sb.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(sb.toString());
    }

    public void onDetach() {
        super.onDetach();
    }
}
