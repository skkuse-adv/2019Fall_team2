package kr.co.popone.fitts.feature.store.browser;

import android.app.Dialog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;

final class StoreBrowserActivity$duplicateDialog$2 extends Lambda implements Function0<Dialog> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$duplicateDialog$2(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
        super(0);
    }

    @NotNull
    public final Dialog invoke() {
        return DialogExtensions.INSTANCE.createMessageDialog(this.this$0, "", "이미 선택된 상품입니다.", null, "확인");
    }
}
