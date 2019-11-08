package kr.co.popone.fitts.feature.store;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0009R$font;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.Nullable;

public final class StoreFragment$onViewCreated$$inlined$apply$lambda$2 implements OnTabSelectedListener {
    final /* synthetic */ StoreFragment this$0;

    public void onTabReselected(@Nullable Tab tab) {
    }

    StoreFragment$onViewCreated$$inlined$apply$lambda$2(StoreFragment storeFragment) {
        this.this$0 = storeFragment;
    }

    public void onTabUnselected(@Nullable Tab tab) {
        this.this$0.updateTabTextStyle(tab, C0009R$font.kopubdotum_pro_medium);
    }

    public void onTabSelected(@Nullable Tab tab) {
        ViewPager viewPager = (ViewPager) this.this$0._$_findCachedViewById(C0010R$id.storeViewPager);
        Intrinsics.checkExpressionValueIsNotNull(viewPager, "storeViewPager");
        viewPager.setCurrentItem(tab != null ? tab.getPosition() : 0);
        this.this$0.updateTabTextStyle(tab, C0009R$font.kopubdotum_pro_bold);
    }
}
