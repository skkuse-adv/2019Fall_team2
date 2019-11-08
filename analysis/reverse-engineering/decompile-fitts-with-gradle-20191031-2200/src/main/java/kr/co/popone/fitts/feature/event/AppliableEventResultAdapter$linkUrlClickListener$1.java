package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.event.AppliableEventResultAdapter.Delegate;

final class AppliableEventResultAdapter$linkUrlClickListener$1 implements OnClickListener {
    final /* synthetic */ AppliableEventResultAdapter this$0;

    AppliableEventResultAdapter$linkUrlClickListener$1(AppliableEventResultAdapter appliableEventResultAdapter) {
        this.this$0 = appliableEventResultAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        Object tag = view.getTag();
        if (tag != null) {
            access$getDelegate$p.onLinkUrlClicked(((Integer) tag).intValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
