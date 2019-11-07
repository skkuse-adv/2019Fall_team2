package kr.co.popone.fitts.feature.home;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HomeTypeAdapter extends FragmentPagerAdapter {
    @NotNull
    private final List<Fragment> fragments;

    public int getItemPosition(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "item");
        return -2;
    }

    @Nullable
    public CharSequence getPageTitle(int i) {
        if (i == 0) {
            return "내체형";
        }
        if (i != 1) {
            return null;
        }
        return "전체체형";
    }

    public HomeTypeAdapter(@NotNull FragmentManager fragmentManager, @NotNull List<? extends Fragment> list) {
        Intrinsics.checkParameterIsNotNull(fragmentManager, "fm");
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
