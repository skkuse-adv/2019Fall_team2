package kr.co.popone.fitts.feature.collection;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.collection.MixedCollectionAdapter.FittieTypeHolder;

final class MixedCollectionAdapter$FittieTypeHolder$init$$inlined$with$lambda$3 implements OnClickListener {
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ View $this_with$inlined;
    final /* synthetic */ FittieTypeHolder this$0;

    MixedCollectionAdapter$FittieTypeHolder$init$$inlined$with$lambda$3(View view, FittieTypeHolder fittieTypeHolder, int i) {
        this.$this_with$inlined = view;
        this.this$0 = fittieTypeHolder;
        this.$position$inlined = i;
    }

    public final void onClick(View view) {
        TextView textView = (TextView) this.$this_with$inlined.findViewById(C0010R$id.followButton);
        Intrinsics.checkExpressionValueIsNotNull(textView, "followButton");
        textView.setEnabled(false);
        this.this$0.this$0.getDelegate().onFollowClicked(this.$position$inlined);
    }
}
