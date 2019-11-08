package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;

public final class CsContactDialog extends BottomSheetDialog {
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public interface Delegate {
        void onCsContactClicked();

        void onKakaoContactClicked();
    }

    public CsContactDialog(@NotNull Context context, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(context);
        this.delegate = delegate2;
        setContentView((int) C0013R$layout.dialog_product_service_center);
        initializeDialog();
    }

    private final void initializeDialog() {
        ((TextView) findViewById(C0010R$id.buttonKakao)).setOnClickListener(new CsContactDialog$initializeDialog$1(this));
        ((TextView) findViewById(C0010R$id.buttonContact)).setOnClickListener(new CsContactDialog$initializeDialog$2(this));
    }
}
