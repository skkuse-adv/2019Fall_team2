package kr.co.popone.fitts.feature.store;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.Tab;
import com.jakewharton.rxbinding2.internal.VoidToUnit;
import com.jakewharton.rxbinding2.view.RxView;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0009R$font;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.base.Scrollable;
import kr.co.popone.fitts.feature.main.DrawerMenuListner;
import kr.co.popone.fitts.feature.store.newest.StoreNewFeedFragment;
import kr.co.popone.fitts.feature.store.recommend.StoreFeedFragment;
import kr.co.popone.fitts.ui.TextViewExtensionKt;
import kr.co.popone.fitts.ui.custom.StoreTab;
import kr.co.popone.fitts.viewmodel.store.StoreViewModel;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModel.StoreFeedType;
import org.jetbrains.anko.support.v4.SupportV4ListenersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreFragment extends Fragment implements Scrollable {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposable = new CompositeDisposable();
    /* access modifiers changed from: private */
    public DrawerMenuListner drawerMenuListner;
    @NotNull
    private final List<Fragment> fragments = CollectionsKt__CollectionsKt.listOf(StoreFeedFragment.Companion.newInstance(StoreFeedType.TODAY), StoreFeedFragment.Companion.newInstance(StoreFeedType.BEST), StoreNewFeedFragment.Companion.newInstance(), StoreFeedFragment.Companion.newInstance(StoreFeedType.SHOP));
    @NotNull
    public StoreViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StoreFragment newInstance() {
            return new StoreFragment();
        }
    }

    @NotNull
    public static final StoreFragment newInstance() {
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
    public final StoreViewModel getViewModel() {
        StoreViewModel storeViewModel = this.viewModel;
        if (storeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return storeViewModel;
    }

    public final void setViewModel(@NotNull StoreViewModel storeViewModel) {
        Intrinsics.checkParameterIsNotNull(storeViewModel, "<set-?>");
        this.viewModel = storeViewModel;
    }

    @NotNull
    public final List<Fragment> getFragments() {
        return this.fragments;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        if (context instanceof DrawerMenuListner) {
            this.drawerMenuListner = (DrawerMenuListner) context;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(context));
        sb.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(sb.toString());
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_store, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.storeViewPager);
        viewPager.setAdapter(new StoreViewAdapter(this.fragments, getChildFragmentManager()));
        SupportV4ListenersKt.onPageChangeListener(viewPager, new StoreFragment$onViewCreated$$inlined$apply$lambda$1(this));
        viewPager.setOffscreenPageLimit(4);
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(C0010R$id.storeTab);
        tabLayout.addOnTabSelectedListener(new StoreFragment$onViewCreated$$inlined$apply$lambda$2(this));
        Tab newTab = tabLayout.newTab();
        StoreTab storeTab = new StoreTab(tabLayout.getContext(), "투데이", false, 4, null);
        tabLayout.addTab(newTab.setCustomView((View) storeTab));
        Tab newTab2 = tabLayout.newTab();
        StoreTab storeTab2 = new StoreTab(tabLayout.getContext(), "BEST", false, 4, null);
        tabLayout.addTab(newTab2.setCustomView((View) storeTab2));
        tabLayout.addTab(tabLayout.newTab().setCustomView((View) new StoreTab(tabLayout.getContext(), "신상", true)));
        Tab newTab3 = tabLayout.newTab();
        StoreTab storeTab3 = new StoreTab(tabLayout.getContext(), "SHOP", false, 4, null);
        tabLayout.addTab(newTab3.setCustomView((View) storeTab3));
        updateTabTextStyle(tabLayout.getTabAt(0), C0009R$font.kopubdotum_pro_bold);
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textShopTooltip);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textShopTooltip");
        Context requireContext = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(requireContext, "requireContext()");
        TextViewExtensionKt.setTextColorPartially$default(textView, requireContext, "내 체형 인기 SHOP을\n확인해보세요!", 4, 14, 0, 16, null);
        CompositeDisposable compositeDisposable = this.disposable;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C0010R$id.iconMenu);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "iconMenu");
        Observable map = RxView.clicks(frameLayout).map(VoidToUnit.INSTANCE);
        String str = "RxView.clicks(this).map(VoidToUnit)";
        Intrinsics.checkExpressionValueIsNotNull(map, str);
        Disposable subscribe = map.subscribe((Consumer<? super T>) new StoreFragment$onViewCreated$3<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "iconMenu.clicks()\n      …eMenu()\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.disposable;
        FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C0010R$id.iconCart);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "iconCart");
        Observable map2 = RxView.clicks(frameLayout2).map(VoidToUnit.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map2, str);
        Disposable subscribe2 = map2.subscribe((Consumer<? super T>) new StoreFragment$onViewCreated$4<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "iconCart.clicks()\n      …store\")\n                }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.disposable;
        FrameLayout frameLayout3 = (FrameLayout) _$_findCachedViewById(C0010R$id.iconSearch);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout3, "iconSearch");
        Observable map3 = RxView.clicks(frameLayout3).map(VoidToUnit.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map3, str);
        Disposable subscribe3 = map3.subscribe((Consumer<? super T>) new StoreFragment$onViewCreated$5<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe3, "iconSearch.clicks()\n    …ontext)\n                }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.disposable;
        Disposable subscribe4 = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).filter(StoreFragment$onViewCreated$6.INSTANCE).map(StoreFragment$onViewCreated$7.INSTANCE).filter(StoreFragment$onViewCreated$8.INSTANCE).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new StoreFragment$onViewCreated$9<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe4, "RxBus.toObservable()\n   …tem = 0\n                }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        StoreViewModel storeViewModel = this.viewModel;
        String str2 = "viewModel";
        if (storeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
        }
        storeViewModel.getCartVariantCountLiveData().observe(new StoreFragment$onViewCreated$10(this), new StoreFragment$onViewCreated$11(this));
        StoreViewModel storeViewModel2 = this.viewModel;
        if (storeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
        }
        storeViewModel2.getErrorLiveData().observe(new StoreFragment$onViewCreated$12(this), new StoreFragment$onViewCreated$13(this));
    }

    public void scrollTop() {
        if (isAdded()) {
            List<Fragment> list = this.fragments;
            ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.storeViewPager);
            Intrinsics.checkExpressionValueIsNotNull(viewPager, "storeViewPager");
            Fragment fragment = (Fragment) list.get(viewPager.getCurrentItem());
            if (fragment instanceof Scrollable) {
                ((Scrollable) fragment).scrollTop();
            }
        }
    }

    public void onResume() {
        super.onResume();
        StoreViewModel storeViewModel = this.viewModel;
        if (storeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        storeViewModel.getBadgeCount();
    }

    public void onDestroy() {
        this.disposable.dispose();
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public final void updateTabTextStyle(Tab tab, int i) {
        View customView = tab != null ? tab.getCustomView() : null;
        if (customView instanceof StoreTab) {
            TextView textView = (TextView) customView.findViewById(C0010R$id.tvTabTitle);
            if (textView != null) {
                textView.setTypeface(ResourcesCompat.getFont(requireContext(), i));
            }
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void switchStoreFragment(@org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "tab"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            r0 = 0
            int r1 = r4.hashCode()     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            switch(r1) {
                case 108960: goto L_0x0037;
                case 3208415: goto L_0x002a;
                case 3522631: goto L_0x001c;
                case 3529462: goto L_0x000e;
                default: goto L_0x000d;
            }     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
        L_0x000d:
            goto L_0x0045
        L_0x000e:
            java.lang.String r1 = "shop"
            boolean r4 = r4.equals(r1)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            if (r4 == 0) goto L_0x0045
            r4 = 3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            goto L_0x0046
        L_0x001c:
            java.lang.String r1 = "sale"
            boolean r4 = r4.equals(r1)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            if (r4 == 0) goto L_0x0045
            r4 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            goto L_0x0046
        L_0x002a:
            java.lang.String r1 = "home"
            boolean r4 = r4.equals(r1)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            if (r4 == 0) goto L_0x0045
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            goto L_0x0046
        L_0x0037:
            java.lang.String r1 = "new"
            boolean r4 = r4.equals(r1)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            if (r4 == 0) goto L_0x0045
            r4 = 2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            goto L_0x0046
        L_0x0045:
            r4 = 0
        L_0x0046:
            if (r4 == 0) goto L_0x0077
            int r4 = r4.intValue()     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            int r1 = kr.co.popone.fitts.C0010R$id.storeViewPager     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            android.view.View r1 = r3._$_findCachedViewById(r1)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            androidx.viewpager.widget.ViewPager r1 = (androidx.viewpager.widget.ViewPager) r1     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            if (r1 == 0) goto L_0x0059
            r1.setCurrentItem(r4)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
        L_0x0059:
            kr.co.popone.fitts.viewmodel.store.StoreViewModel r1 = r3.viewModel     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            if (r1 != 0) goto L_0x0062
            java.lang.String r2 = "viewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
        L_0x0062:
            java.lang.String r2 = "scheme"
            r1.onStoreTabSelected(r4, r2)     // Catch:{ UninitializedPropertyAccessException -> 0x0070, Exception -> 0x0068 }
            goto L_0x0077
        L_0x0068:
            java.lang.Object[] r4 = new java.lang.Object[r0]
            java.lang.String r0 = "unknown exception"
            com.orhanobut.logger.Logger.d(r0, r4)
            goto L_0x0077
        L_0x0070:
            java.lang.Object[] r4 = new java.lang.Object[r0]
            java.lang.String r0 = "ViewModel not initialized"
            com.orhanobut.logger.Logger.d(r0, r4)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.store.StoreFragment.switchStoreFragment(java.lang.String):void");
    }

    public final void onBackkeyPressed(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        if (isAdded()) {
            ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.storeViewPager);
            if (viewPager.getCurrentItem() != 0) {
                viewPager.setCurrentItem(0);
            } else {
                function0.invoke();
            }
        }
    }
}
