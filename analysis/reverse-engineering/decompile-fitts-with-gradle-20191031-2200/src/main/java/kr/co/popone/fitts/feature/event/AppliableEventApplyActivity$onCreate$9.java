package kr.co.popone.fitts.feature.event;

import android.content.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import kotlin.TypeCastException;
import kr.co.popone.fitts.C0010R$id;

final class AppliableEventApplyActivity$onCreate$9 implements OnClickListener {
    final /* synthetic */ AppliableEventApplyActivity this$0;

    AppliableEventApplyActivity$onCreate$9(AppliableEventApplyActivity appliableEventApplyActivity) {
        this.this$0 = appliableEventApplyActivity;
    }

    public final void onClick(View view) {
        Object systemService = this.this$0.getSystemService("clipboard");
        if (systemService != null) {
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager.hasPrimaryClip()) {
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.productDetailPageLinkEditText)).setText(clipboardManager.getPrimaryClip().getItemAt(0).coerceToText(this.this$0).toString());
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
}
