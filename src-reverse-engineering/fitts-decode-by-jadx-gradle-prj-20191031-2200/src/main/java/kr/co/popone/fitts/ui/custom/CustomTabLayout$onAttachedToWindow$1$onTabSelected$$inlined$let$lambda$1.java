package kr.co.popone.fitts.ui.custom;

import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import kr.co.popone.fitts.C0009R$font;

final class CustomTabLayout$onAttachedToWindow$1$onTabSelected$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ TextView $this_run;
    final /* synthetic */ CustomTabLayout$onAttachedToWindow$1 this$0;

    CustomTabLayout$onAttachedToWindow$1$onTabSelected$$inlined$let$lambda$1(TextView textView, CustomTabLayout$onAttachedToWindow$1 customTabLayout$onAttachedToWindow$1) {
        this.$this_run = textView;
        this.this$0 = customTabLayout$onAttachedToWindow$1;
    }

    public final void run() {
        this.$this_run.setTypeface(ResourcesCompat.getFont(this.this$0.this$0.getContext(), C0009R$font.kopubdotum_pro_bold));
    }
}
