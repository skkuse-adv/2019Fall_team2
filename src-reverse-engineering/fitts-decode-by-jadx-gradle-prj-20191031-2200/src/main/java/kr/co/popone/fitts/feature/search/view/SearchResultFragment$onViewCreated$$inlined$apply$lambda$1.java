package kr.co.popone.fitts.feature.search.view;

import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchResultFragment$onViewCreated$$inlined$apply$lambda$1 implements OnTabSelectedListener {
    final /* synthetic */ SearchResultFragment this$0;

    public void onTabReselected(@Nullable Tab tab) {
    }

    public void onTabUnselected(@Nullable Tab tab) {
    }

    SearchResultFragment$onViewCreated$$inlined$apply$lambda$1(SearchResultFragment searchResultFragment) {
        this.this$0 = searchResultFragment;
    }

    public void onTabSelected(@NotNull Tab tab) {
        Intrinsics.checkParameterIsNotNull(tab, "tab");
        this.this$0.getViewModel().logTapSearchTab(Integer.valueOf(tab.getPosition()));
    }
}
