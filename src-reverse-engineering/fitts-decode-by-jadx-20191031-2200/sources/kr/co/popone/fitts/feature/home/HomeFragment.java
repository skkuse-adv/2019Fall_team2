package kr.co.popone.fitts.feature.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout.Tab;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.base.Scrollable;
import kr.co.popone.fitts.feature.home.feed.HomeFeedFragment;
import kr.co.popone.fitts.feature.main.DrawerMenuListner;
import kr.co.popone.fitts.ui.custom.CustomTabLayout;
import kr.co.popone.fitts.viewmodel.home.HomeViewModel;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel.FeedType;
import org.jetbrains.anko.support.v4.SupportV4ListenersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HomeFragment extends Fragment implements Scrollable {
    private HashMap _$_findViewCache;
    @Nullable
    private DrawerMenuListner drawerMenuListner;
    private final List<HomeFeedFragment> fragments = CollectionsKt__CollectionsKt.listOf(HomeFeedFragment.Companion.newInstance(FeedType.MY), HomeFeedFragment.Companion.newInstance(FeedType.ALL));
    @NotNull
    public HomeViewModel viewModel;

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
    public final HomeViewModel getViewModel() {
        HomeViewModel homeViewModel = this.viewModel;
        if (homeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return homeViewModel;
    }

    public final void setViewModel(@NotNull HomeViewModel homeViewModel) {
        Intrinsics.checkParameterIsNotNull(homeViewModel, "<set-?>");
        this.viewModel = homeViewModel;
    }

    @Nullable
    public final DrawerMenuListner getDrawerMenuListner() {
        return this.drawerMenuListner;
    }

    public final void setDrawerMenuListner(@Nullable DrawerMenuListner drawerMenuListner2) {
        this.drawerMenuListner = drawerMenuListner2;
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
        return layoutInflater.inflate(C0013R$layout.fragment_home, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.homeFeedViewPager);
        viewPager.setOffscreenPageLimit(2);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "childFragmentManager");
        viewPager.setAdapter(new HomeTypeAdapter(childFragmentManager, this.fragments));
        SupportV4ListenersKt.onPageChangeListener(viewPager, new HomeFragment$onViewCreated$$inlined$apply$lambda$1(this));
        ((CustomTabLayout) _$_findCachedViewById(C0010R$id.type_tab)).setupWithViewPager((ViewPager) _$_findCachedViewById(C0010R$id.homeFeedViewPager));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.iconCart)).setOnClickListener(new HomeFragment$onViewCreated$2(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.iconMenu)).setOnClickListener(new HomeFragment$onViewCreated$3(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.iconSearch)).setOnClickListener(new HomeFragment$onViewCreated$4(this));
        HomeViewModel homeViewModel = this.viewModel;
        String str = "viewModel";
        if (homeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        homeViewModel.getCartVariantCountLiveData().observe(new HomeFragment$onViewCreated$5(this), new HomeFragment$onViewCreated$6(this));
        HomeViewModel homeViewModel2 = this.viewModel;
        if (homeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        homeViewModel2.getErrorLiveData().observe(new HomeFragment$onViewCreated$7(this), new HomeFragment$onViewCreated$8(this));
        selectTab(0);
    }

    private final void selectTab(int i) {
        Tab tabAt = ((CustomTabLayout) _$_findCachedViewById(C0010R$id.type_tab)).getTabAt(i);
        if (tabAt != null) {
            tabAt.select();
        }
    }

    public void scrollTop() {
        if (isAdded()) {
            ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.homeFeedViewPager);
            Intrinsics.checkExpressionValueIsNotNull(viewPager, "homeFeedViewPager");
            ((HomeFeedFragment) this.fragments.get(viewPager.getCurrentItem())).scrollTop();
        }
    }

    public void onResume() {
        super.onResume();
        HomeViewModel homeViewModel = this.viewModel;
        if (homeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        homeViewModel.getBadgeCount();
    }
}
