package kr.co.popone.fitts.feature.collection;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kr.co.popone.fitts.feature.collection.PromotionCollectionAdapter.Delegate;
import kr.co.popone.fitts.ui.FittsCircleImageView;

final class PromotionCollectionAdapter$showShowroomClickListener$1 implements OnClickListener {
    final /* synthetic */ PromotionCollectionAdapter this$0;

    PromotionCollectionAdapter$showShowroomClickListener$1(PromotionCollectionAdapter promotionCollectionAdapter) {
        this.this$0 = promotionCollectionAdapter;
    }

    public final void onClick(View view) {
        if (view != null) {
            FittsCircleImageView fittsCircleImageView = (FittsCircleImageView) view;
            Delegate access$getDelegate$p = this.this$0.delegate;
            Object extraData = fittsCircleImageView.getExtraData();
            if (extraData != null) {
                access$getDelegate$p.showShowroom(((Integer) extraData).intValue());
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.ui.FittsCircleImageView");
    }
}
