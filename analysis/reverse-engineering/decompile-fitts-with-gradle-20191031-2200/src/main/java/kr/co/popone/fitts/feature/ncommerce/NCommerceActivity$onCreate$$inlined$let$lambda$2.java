package kr.co.popone.fitts.feature.ncommerce;

import androidx.viewpager.widget.ViewPager;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class NCommerceActivity$onCreate$$inlined$let$lambda$2 implements Runnable {
    final /* synthetic */ NCommerceActivity this$0;

    NCommerceActivity$onCreate$$inlined$let$lambda$2(NCommerceActivity nCommerceActivity) {
        this.this$0 = nCommerceActivity;
    }

    public final void run() {
        ViewPager viewPager = (ViewPager) this.this$0._$_findCachedViewById(C0010R$id.viewPager);
        Intrinsics.checkExpressionValueIsNotNull(viewPager, "viewPager");
        viewPager.setCurrentItem(1);
    }
}
