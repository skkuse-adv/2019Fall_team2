package kr.co.popone.fitts.feature.store;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreViewAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragments;

    public StoreViewAdapter(@NotNull List<? extends Fragment> list, @Nullable FragmentManager fragmentManager) {
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
