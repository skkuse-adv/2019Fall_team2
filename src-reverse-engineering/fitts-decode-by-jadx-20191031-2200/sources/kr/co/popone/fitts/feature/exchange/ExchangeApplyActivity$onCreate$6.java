package kr.co.popone.fitts.feature.exchange;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.KeyboardExtensionKt;

final class ExchangeApplyActivity$onCreate$6 implements OnTouchListener {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$6(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        ExchangeApplyActivity exchangeApplyActivity = this.this$0;
        EditText editText = (EditText) exchangeApplyActivity._$_findCachedViewById(C0010R$id.editOption);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editOption");
        KeyboardExtensionKt.hideKeyboard((Activity) exchangeApplyActivity, (View) editText);
        return true;
    }
}
