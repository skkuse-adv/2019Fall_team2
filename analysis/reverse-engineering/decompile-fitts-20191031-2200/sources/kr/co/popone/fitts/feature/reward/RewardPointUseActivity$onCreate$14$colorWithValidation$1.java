package kr.co.popone.fitts.feature.reward;

import android.widget.EditText;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.jetbrains.annotations.Nullable;

final class RewardPointUseActivity$onCreate$14$colorWithValidation$1 extends Lambda implements Function2<Boolean, EditText, Integer> {
    final /* synthetic */ int $grayColor;
    final /* synthetic */ Ref$BooleanRef $isFieldsValid;
    final /* synthetic */ int $redColor;

    RewardPointUseActivity$onCreate$14$colorWithValidation$1(int i, Ref$BooleanRef ref$BooleanRef, int i2) {
        this.$grayColor = i;
        this.$isFieldsValid = ref$BooleanRef;
        this.$redColor = i2;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(invoke(((Boolean) obj).booleanValue(), (EditText) obj2));
    }

    public final int invoke(boolean z, @Nullable EditText editText) {
        if (z) {
            return this.$grayColor;
        }
        Ref$BooleanRef ref$BooleanRef = this.$isFieldsValid;
        if (ref$BooleanRef.element) {
            ref$BooleanRef.element = false;
            if (editText != null) {
                editText.clearFocus();
                editText.requestFocus();
            }
        }
        return this.$redColor;
    }
}
