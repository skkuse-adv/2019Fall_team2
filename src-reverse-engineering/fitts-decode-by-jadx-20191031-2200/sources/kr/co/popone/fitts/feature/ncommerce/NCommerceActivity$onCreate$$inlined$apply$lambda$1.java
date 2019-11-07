package kr.co.popone.fitts.feature.ncommerce;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NCommerceActivity$onCreate$$inlined$apply$lambda$1 extends FragmentPagerAdapter {
    final /* synthetic */ NCommerceActivity this$0;

    public int getItemPosition(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "item");
        return -2;
    }

    NCommerceActivity$onCreate$$inlined$apply$lambda$1(FragmentManager fragmentManager, NCommerceActivity nCommerceActivity) {
        this.this$0 = nCommerceActivity;
        super(fragmentManager);
    }

    @NotNull
    public Fragment getItem(int i) {
        return (Fragment) ((Pair) this.this$0.getFragments().get(i)).getSecond();
    }

    public int getCount() {
        return this.this$0.getFragments().size();
    }

    @Nullable
    public CharSequence getPageTitle(int i) {
        return (CharSequence) ((Pair) this.this$0.getFragments().get(i)).getFirst();
    }
}
