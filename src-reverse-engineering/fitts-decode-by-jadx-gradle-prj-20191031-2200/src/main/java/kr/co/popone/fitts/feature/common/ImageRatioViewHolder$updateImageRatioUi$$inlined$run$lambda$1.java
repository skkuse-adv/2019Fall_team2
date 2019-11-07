package kr.co.popone.fitts.feature.common;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.ImageType;

final class ImageRatioViewHolder$updateImageRatioUi$$inlined$run$lambda$1 implements OnClickListener {
    final /* synthetic */ ImageType $this_run;
    final /* synthetic */ ImageRatioViewHolder this$0;

    ImageRatioViewHolder$updateImageRatioUi$$inlined$run$lambda$1(ImageType imageType, ImageRatioViewHolder imageRatioViewHolder, ImageType imageType2) {
        this.$this_run = imageType;
        this.this$0 = imageRatioViewHolder;
    }

    public final void onClick(View view) {
        String scheme = this.$this_run.getScheme();
        if (scheme != null) {
            this.this$0.delegate.onSchemeClick(this.this$0, scheme);
        }
    }
}
