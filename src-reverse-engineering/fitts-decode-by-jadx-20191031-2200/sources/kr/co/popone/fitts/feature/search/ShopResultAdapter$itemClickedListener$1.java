package kr.co.popone.fitts.feature.search;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.ShopResultAdapter.Delegate;

final class ShopResultAdapter$itemClickedListener$1 implements OnClickListener {
    final /* synthetic */ ShopResultAdapter this$0;

    ShopResultAdapter$itemClickedListener$1(ShopResultAdapter shopResultAdapter) {
        this.this$0 = shopResultAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        Object tag = view.getTag();
        if (tag != null) {
            access$getDelegate$p.onItemClick(((Integer) tag).intValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
