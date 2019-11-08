package kr.co.popone.fitts.feature.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class ModifyUserInfoActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ ModifyUserInfoActivity this$0;

    ModifyUserInfoActivity$onCreate$4(ModifyUserInfoActivity modifyUserInfoActivity) {
        this.this$0 = modifyUserInfoActivity;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.userNameEditText);
        String str = "userNameEditText";
        Intrinsics.checkExpressionValueIsNotNull(editText, str);
        if (!editText.isCursorVisible()) {
            EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.userNameEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText2, str);
            editText2.setCursorVisible(true);
        }
    }
}
