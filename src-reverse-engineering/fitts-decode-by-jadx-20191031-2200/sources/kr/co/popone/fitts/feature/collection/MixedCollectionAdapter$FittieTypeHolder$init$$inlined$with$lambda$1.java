package kr.co.popone.fitts.feature.collection;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.collection.MixedCollectionAdapter.FittieTypeHolder;

final class MixedCollectionAdapter$FittieTypeHolder$init$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ FittieTypeHolder this$0;

    MixedCollectionAdapter$FittieTypeHolder$init$$inlined$with$lambda$1(View view, FittieTypeHolder fittieTypeHolder, int i) {
        this.this$0 = fittieTypeHolder;
        this.$position$inlined = i;
    }

    public final void onClick(View view) {
        this.this$0.this$0.getDelegate().onProfileClicked(this.$position$inlined);
    }
}
