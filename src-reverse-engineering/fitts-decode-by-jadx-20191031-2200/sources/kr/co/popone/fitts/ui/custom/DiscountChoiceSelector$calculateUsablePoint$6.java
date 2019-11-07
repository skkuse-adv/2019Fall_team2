package kr.co.popone.fitts.ui.custom;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView.BufferType;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.view.adjustment.AdjustmentViewData;
import kr.co.popone.fitts.ui.ToastExtensionKt;
import kr.co.popone.fitts.utils.IntExtensionsKt;

final class DiscountChoiceSelector$calculateUsablePoint$6<T> implements Consumer<Integer> {
    final /* synthetic */ AdjustmentViewData $adjustmentViewData;
    final /* synthetic */ EditText $editText;
    final /* synthetic */ DiscountChoiceSelector this$0;

    DiscountChoiceSelector$calculateUsablePoint$6(DiscountChoiceSelector discountChoiceSelector, EditText editText, AdjustmentViewData adjustmentViewData) {
        this.this$0 = discountChoiceSelector;
        this.$editText = editText;
        this.$adjustmentViewData = adjustmentViewData;
    }

    public final void accept(Integer num) {
        this.$editText.setText(String.valueOf(num), BufferType.EDITABLE);
        DiscountChoiceSelector discountChoiceSelector = this.this$0;
        StringBuilder sb = new StringBuilder();
        sb.append(IntExtensionsKt.commaString(this.$adjustmentViewData.getUsageValueUnit()));
        sb.append("원 단위로 입력해주세요");
        ToastExtensionKt.showToast((View) discountChoiceSelector, sb.toString());
    }
}
