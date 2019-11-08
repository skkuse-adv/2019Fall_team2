package kr.co.popone.fitts.feature.collection;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.viewmodel.MixedCollectionViewModel$Input;

final class MixedCollectionActivity$inputs$1$1 implements OnClickListener {
    final /* synthetic */ MixedCollectionViewModel$Input $this_with;

    MixedCollectionActivity$inputs$1$1(MixedCollectionViewModel$Input mixedCollectionViewModel$Input) {
        this.$this_with = mixedCollectionViewModel$Input;
    }

    public final void onClick(View view) {
        this.$this_with.backButtonClicked();
    }
}
