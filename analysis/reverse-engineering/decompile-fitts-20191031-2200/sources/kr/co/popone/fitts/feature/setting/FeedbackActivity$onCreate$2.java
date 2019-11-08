package kr.co.popone.fitts.feature.setting;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class FeedbackActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ FeedbackActivity this$0;

    FeedbackActivity$onCreate$2(FeedbackActivity feedbackActivity) {
        this.this$0 = feedbackActivity;
    }

    public final void onClick(View view) {
        Logger.d("send button clicked", new Object[0]);
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.feedbackEditText);
        String str = "feedbackEditText";
        Intrinsics.checkExpressionValueIsNotNull(editText, str);
        Editable text = editText.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "feedbackEditText.text");
        if (!StringsKt__StringsJVMKt.isBlank(text)) {
            FeedbackActivity feedbackActivity = this.this$0;
            EditText editText2 = (EditText) feedbackActivity._$_findCachedViewById(C0010R$id.feedbackEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText2, str);
            feedbackActivity.requestFeedback(editText2.getText().toString());
        }
    }
}
