package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;

final class ImagesAdapter$actionButtonCLickListener$1 implements OnClickListener {
    final /* synthetic */ ImagesAdapter this$0;

    ImagesAdapter$actionButtonCLickListener$1(ImagesAdapter imagesAdapter) {
        this.this$0 = imagesAdapter;
    }

    public final void onClick(View view) {
        this.this$0.delegate.actionButtonClicked();
    }
}
