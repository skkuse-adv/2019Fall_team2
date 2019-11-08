package kr.co.popone.fitts.feature.collection;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.collection.PostCollectionAdapter.Delegate;

final class PostCollectionAdapter$showShowroomClickListener$1 implements OnClickListener {
    final /* synthetic */ PostCollectionAdapter this$0;

    PostCollectionAdapter$showShowroomClickListener$1(PostCollectionAdapter postCollectionAdapter) {
        this.this$0 = postCollectionAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        Object tag = view.getTag();
        if (tag != null) {
            access$getDelegate$p.showShowroom(((Integer) tag).intValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
