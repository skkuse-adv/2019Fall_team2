package kr.co.popone.fitts.ui.custom;

import android.view.View;
import android.view.View.OnClickListener;

final class CsContactDialog$initializeDialog$1 implements OnClickListener {
    final /* synthetic */ CsContactDialog this$0;

    CsContactDialog$initializeDialog$1(CsContactDialog csContactDialog) {
        this.this$0 = csContactDialog;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onKakaoContactClicked();
    }
}
