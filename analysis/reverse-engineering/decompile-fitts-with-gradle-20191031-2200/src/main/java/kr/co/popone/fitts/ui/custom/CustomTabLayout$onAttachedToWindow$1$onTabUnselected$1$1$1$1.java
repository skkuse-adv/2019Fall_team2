package kr.co.popone.fitts.ui.custom;

import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import kr.co.popone.fitts.C0009R$font;

final class CustomTabLayout$onAttachedToWindow$1$onTabUnselected$1$1$1$1 implements Runnable {
    final /* synthetic */ TextView $this_run;

    CustomTabLayout$onAttachedToWindow$1$onTabUnselected$1$1$1$1(TextView textView) {
        this.$this_run = textView;
    }

    public final void run() {
        TextView textView = this.$this_run;
        textView.setTypeface(ResourcesCompat.getFont(textView.getContext(), C0009R$font.kopubdotum_pro_medium));
    }
}
