package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0006R$color;

final class DiscountChoiceSelector$unselectTextColor$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ Context $context;

    DiscountChoiceSelector$unselectTextColor$2(Context context) {
        this.$context = context;
        super(0);
    }

    public final int invoke() {
        return ContextCompat.getColor(this.$context, C0006R$color.gray6);
    }
}
