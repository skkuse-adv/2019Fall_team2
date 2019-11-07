package kr.co.popone.fitts.feature.store.browser;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0017R$style;
import kr.co.popone.fitts.ui.custom.StoreOptionSelectDialog;
import org.jetbrains.annotations.NotNull;

final class StoreBrowserActivity$optionSelectDialog$2 extends Lambda implements Function0<StoreOptionSelectDialog> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$optionSelectDialog$2(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
        super(0);
    }

    @NotNull
    public final StoreOptionSelectDialog invoke() {
        StoreBrowserActivity storeBrowserActivity = this.this$0;
        return new StoreOptionSelectDialog(storeBrowserActivity, C0017R$style.AppBottomSheetDialogTheme, storeBrowserActivity);
    }
}
