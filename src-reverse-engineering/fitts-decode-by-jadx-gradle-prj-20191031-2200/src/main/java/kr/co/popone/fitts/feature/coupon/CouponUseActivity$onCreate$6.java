package kr.co.popone.fitts.feature.coupon;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import kotlin.TypeCastException;
import kr.co.popone.fitts.C0010R$id;

final class CouponUseActivity$onCreate$6 implements OnClickListener {
    final /* synthetic */ CouponUseActivity this$0;

    CouponUseActivity$onCreate$6(CouponUseActivity couponUseActivity) {
        this.this$0 = couponUseActivity;
    }

    public final void onClick(View view) {
        CharSequence charSequence;
        Object systemService = this.this$0.getSystemService("clipboard");
        if (systemService != null) {
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager.hasPrimaryClip()) {
                ClipData primaryClip = clipboardManager.getPrimaryClip();
                if (primaryClip != null) {
                    Item itemAt = primaryClip.getItemAt(0);
                    if (itemAt != null) {
                        charSequence = itemAt.coerceToText(this.this$0);
                        ((EditText) this.this$0._$_findCachedViewById(C0010R$id.productDetailPageLinkEditText)).setText(String.valueOf(charSequence));
                        return;
                    }
                }
                charSequence = null;
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.productDetailPageLinkEditText)).setText(String.valueOf(charSequence));
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
}
