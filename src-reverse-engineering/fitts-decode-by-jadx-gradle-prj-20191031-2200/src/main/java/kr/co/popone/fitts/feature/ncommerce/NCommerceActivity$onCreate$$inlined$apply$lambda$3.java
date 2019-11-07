package kr.co.popone.fitts.feature.ncommerce;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout.Tab;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.custom.CustomTabLayout;

final class NCommerceActivity$onCreate$$inlined$apply$lambda$3 implements Runnable {
    final /* synthetic */ CustomTabLayout $this_apply;
    final /* synthetic */ NCommerceActivity this$0;

    NCommerceActivity$onCreate$$inlined$apply$lambda$3(CustomTabLayout customTabLayout, NCommerceActivity nCommerceActivity) {
        this.$this_apply = customTabLayout;
        this.this$0 = nCommerceActivity;
    }

    public final void run() {
        this.$this_apply.setupWithViewPager((ViewPager) this.this$0._$_findCachedViewById(C0010R$id.viewPager));
        Tab tabAt = this.$this_apply.getTabAt(0);
        if (tabAt != null) {
            tabAt.select();
        }
    }
}
