package kr.co.popone.fitts.feature.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class MainAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragments;

    public MainAdapter(@NotNull FragmentManager fragmentManager, @NotNull List<? extends Fragment> list) {
        Intrinsics.checkParameterIsNotNull(fragmentManager, "manager");
        Intrinsics.checkParameterIsNotNull(list, "fragments");
        super(fragmentManager);
        this.fragments = list;
    }

    @NotNull
    public Fragment getItem(int i) {
        return (Fragment) this.fragments.get(i);
    }

    public int getCount() {
        return this.fragments.size();
    }
}
