package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DiscountChoiceSelector$selectTextColor$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ Context $context;

    DiscountChoiceSelector$selectTextColor$2(Context context) {
        this.$context = context;
        super(0);
    }

    public final int invoke() {
        return ContextCompat.getColor(this.$context, 17170443);
    }
}
