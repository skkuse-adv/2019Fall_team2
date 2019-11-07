package kr.co.popone.fitts.feature.search.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchResultAdapter extends FragmentPagerAdapter {
    @NotNull
    private final List<Fragment> fragments;

    @Nullable
    public CharSequence getPageTitle(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "" : "핏티" : "상품" : "포스트" : "통합";
    }

    public SearchResultAdapter(@NotNull List<? extends Fragment> list, @Nullable FragmentManager fragmentManager) {
        Intrinsics.checkParameterIsNotNull(list, "fragments");
        super(fragmentManager);
        this.fragments = list;
    }

    @NotNull
    public final List<Fragment> getFragments() {
        return this.fragments;
    }

    @NotNull
    public Fragment getItem(int i) {
        return (Fragment) this.fragments.get(i);
    }

    public int getCount() {
        return this.fragments.size();
    }
}
