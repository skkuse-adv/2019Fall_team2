package kr.co.popone.fitts.feature.collection;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.collection.PromotionCollectionAdapter.Delegate;

final class PromotionCollectionAdapter$showPostClickListener$1 implements OnClickListener {
    final /* synthetic */ PromotionCollectionAdapter this$0;

    PromotionCollectionAdapter$showPostClickListener$1(PromotionCollectionAdapter promotionCollectionAdapter) {
        this.this$0 = promotionCollectionAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        Object tag = view.getTag();
        if (tag != null) {
            access$getDelegate$p.showPost(((Integer) tag).intValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
