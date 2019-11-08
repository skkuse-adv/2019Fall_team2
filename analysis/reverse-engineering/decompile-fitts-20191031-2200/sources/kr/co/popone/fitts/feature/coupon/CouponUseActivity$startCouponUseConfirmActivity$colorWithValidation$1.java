package kr.co.popone.fitts.feature.coupon;

import android.widget.EditText;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.jetbrains.annotations.Nullable;

final class CouponUseActivity$startCouponUseConfirmActivity$colorWithValidation$1 extends Lambda implements Function2<Boolean, EditText, Integer> {
    final /* synthetic */ int $colorGray6;
    final /* synthetic */ int $colorNeonRed;
    final /* synthetic */ Ref$BooleanRef $isFieldsValid;

    CouponUseActivity$startCouponUseConfirmActivity$colorWithValidation$1(int i, Ref$BooleanRef ref$BooleanRef, int i2) {
        this.$colorGray6 = i;
        this.$isFieldsValid = ref$BooleanRef;
        this.$colorNeonRed = i2;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(invoke(((Boolean) obj).booleanValue(), (EditText) obj2));
    }

    public final int invoke(boolean z, @Nullable EditText editText) {
        if (z) {
            return this.$colorGray6;
        }
        Ref$BooleanRef ref$BooleanRef = this.$isFieldsValid;
        if (ref$BooleanRef.element) {
            ref$BooleanRef.element = false;
            if (editText != null) {
                editText.clearFocus();
                editText.requestFocus();
            }
        }
        return this.$colorNeonRed;
    }
}
