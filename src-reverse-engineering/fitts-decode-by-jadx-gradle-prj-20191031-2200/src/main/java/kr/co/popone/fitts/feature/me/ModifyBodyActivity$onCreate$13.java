package kr.co.popone.fitts.feature.me;

import android.text.Editable;
import android.text.TextWatcher;
import com.kakao.message.template.MessageTemplateProtocol;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ModifyBodyActivity$onCreate$13 implements TextWatcher {
    final /* synthetic */ ModifyBodyActivity this$0;

    public void afterTextChanged(@NotNull Editable editable) {
        Intrinsics.checkParameterIsNotNull(editable, "arg0");
    }

    public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(charSequence, "s");
    }

    ModifyBodyActivity$onCreate$13(ModifyBodyActivity modifyBodyActivity) {
        this.this$0 = modifyBodyActivity;
    }

    public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(charSequence, MessageTemplateProtocol.DESCRIPTION);
        this.this$0.getBodyInfo().setDescription(charSequence.toString());
    }
}
