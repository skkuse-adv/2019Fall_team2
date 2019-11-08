package kr.co.popone.fitts.feature.collection;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.collection.MixedCollectionAdapter.ImageTypeHolder;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionImage;

final class MixedCollectionAdapter$ImageTypeHolder$init$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ ImageTypeHolder this$0;

    MixedCollectionAdapter$ImageTypeHolder$init$$inlined$with$lambda$1(CollectionImage collectionImage, View view, ImageTypeHolder imageTypeHolder, int i) {
        this.this$0 = imageTypeHolder;
        this.$position$inlined = i;
    }

    public final void onClick(View view) {
        this.this$0.this$0.getDelegate().bannerClicked(this.$position$inlined);
    }
}
