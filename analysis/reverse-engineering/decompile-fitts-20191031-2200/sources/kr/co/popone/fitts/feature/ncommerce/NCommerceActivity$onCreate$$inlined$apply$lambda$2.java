package kr.co.popone.fitts.feature.ncommerce;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public final class NCommerceActivity$onCreate$$inlined$apply$lambda$2 implements OnPageChangeListener {
    final /* synthetic */ NCommerceActivity this$0;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    NCommerceActivity$onCreate$$inlined$apply$lambda$2(NCommerceActivity nCommerceActivity) {
        this.this$0 = nCommerceActivity;
    }

    public void onPageSelected(int i) {
        this.this$0.getViewModel().tabIndexChanged(i);
    }
}
