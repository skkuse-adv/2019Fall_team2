package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.event.ProductTypeSelectFragment.ProductAdapter;
import kr.co.popone.fitts.feature.event.ProductTypeSelectFragment.ProductAdapter.Delegate;

final class ProductTypeSelectFragment$ProductAdapter$itemOnClickListener$1 implements OnClickListener {
    final /* synthetic */ ProductAdapter this$0;

    ProductTypeSelectFragment$ProductAdapter$itemOnClickListener$1(ProductAdapter productAdapter) {
        this.this$0 = productAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        List access$getItems$p = this.this$0.items;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        Object tag = view.getTag();
        if (tag != null) {
            access$getDelegate$p.onProductSelected((String) access$getItems$p.get(((Integer) tag).intValue()));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
