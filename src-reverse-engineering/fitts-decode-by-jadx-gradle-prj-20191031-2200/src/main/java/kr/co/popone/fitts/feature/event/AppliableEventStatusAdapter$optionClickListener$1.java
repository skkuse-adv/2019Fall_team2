package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.event.AppliableEventStatusAdapter.Delegate;

final class AppliableEventStatusAdapter$optionClickListener$1 implements OnClickListener {
    final /* synthetic */ AppliableEventStatusAdapter this$0;

    AppliableEventStatusAdapter$optionClickListener$1(AppliableEventStatusAdapter appliableEventStatusAdapter) {
        this.this$0 = appliableEventStatusAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        Object tag = view.getTag();
        if (tag != null) {
            access$getDelegate$p.onOptionClicked(((Integer) tag).intValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
