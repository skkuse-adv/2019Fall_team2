package kr.co.popone.fitts.feature.refund;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.KeyboardExtensionKt;

final class RefundApplyActivity$onCreate$6 implements OnTouchListener {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$6(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        RefundApplyActivity refundApplyActivity = this.this$0;
        EditText editText = (EditText) refundApplyActivity._$_findCachedViewById(C0010R$id.editDetailReason);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editDetailReason");
        KeyboardExtensionKt.hideKeyboard((Activity) refundApplyActivity, (View) editText);
        return true;
    }
}
