package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kr.co.popone.fitts.ui.ImageViewForList;

final class CollaborativeEventImageListView$_imageClickListener$1 implements OnClickListener {
    final /* synthetic */ CollaborativeEventImageListView this$0;

    CollaborativeEventImageListView$_imageClickListener$1(CollaborativeEventImageListView collaborativeEventImageListView) {
        this.this$0 = collaborativeEventImageListView;
    }

    public final void onClick(View view) {
        if (view != null) {
            Object extraData = ((ImageViewForList) view).getExtraData();
            if (extraData != null) {
                Pair pair = (Pair) extraData;
                Function2 itemClickListener = this.this$0.getItemClickListener();
                if (itemClickListener != null) {
                    Unit unit = (Unit) itemClickListener.invoke(pair.getFirst(), pair.getSecond());
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Pair<kotlin.Int, kotlin.Boolean>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.ui.ImageViewForList");
    }
}
