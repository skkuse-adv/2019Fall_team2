package kr.co.popone.fitts.feature.reward;

import android.content.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import kotlin.TypeCastException;
import kr.co.popone.fitts.C0010R$id;

final class RewardPointUseActivity$onCreate$7 implements OnClickListener {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$onCreate$7(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
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
