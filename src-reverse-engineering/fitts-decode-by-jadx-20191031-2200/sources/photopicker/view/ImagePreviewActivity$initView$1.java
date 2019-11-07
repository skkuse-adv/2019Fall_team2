package photopicker.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import photopicker.model.LocalMedia;

final class ImagePreviewActivity$initView$1 implements OnClickListener {
    final /* synthetic */ ImagePreviewActivity this$0;

    ImagePreviewActivity$initView$1(ImagePreviewActivity imagePreviewActivity) {
        this.this$0 = imagePreviewActivity;
    }

    public final void onClick(View view) {
        ImagePreviewActivity imagePreviewActivity = this.this$0;
        if (imagePreviewActivity.isSelected((LocalMedia) imagePreviewActivity.getImages().get(this.this$0.getPosition()))) {
            ArrayList selectImages = this.this$0.getSelectImages();
            ArrayList<LocalMedia> arrayList = new ArrayList<>();
            for (Object next : selectImages) {
                if (Intrinsics.areEqual((Object) ((LocalMedia) next).getPath(), (Object) ((LocalMedia) this.this$0.getImages().get(this.this$0.getPosition())).getPath())) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (LocalMedia remove : arrayList) {
                arrayList2.add(Boolean.valueOf(this.this$0.getSelectImages().remove(remove)));
            }
            for (LocalMedia localMedia : this.this$0.getSelectImages()) {
                if (((LocalMedia) this.this$0.getImages().get(this.this$0.getPosition())).getNum() < localMedia.getNum()) {
                    localMedia.setNum(localMedia.getNum() - 1);
                }
            }
        } else {
            ((LocalMedia) this.this$0.getImages().get(this.this$0.getPosition())).setNum(this.this$0.getSelectImages().size() + 1);
            this.this$0.getSelectImages().add(this.this$0.getImages().get(this.this$0.getPosition()));
        }
        if (this.this$0.getSelectImages().size() > 0) {
            TextView selectedNumTitle = this.this$0.getSelectedNumTitle();
            if (selectedNumTitle == null) {
                Intrinsics.throwNpe();
            }
            selectedNumTitle.setVisibility(0);
            TextView selectedNumTitle2 = this.this$0.getSelectedNumTitle();
            if (selectedNumTitle2 == null) {
                Intrinsics.throwNpe();
            }
            selectedNumTitle2.setText(String.valueOf(this.this$0.getSelectImages().size()));
        } else {
            TextView selectedNumTitle3 = this.this$0.getSelectedNumTitle();
            if (selectedNumTitle3 == null) {
                Intrinsics.throwNpe();
            }
            selectedNumTitle3.setVisibility(8);
        }
        ImagePreviewActivity imagePreviewActivity2 = this.this$0;
        imagePreviewActivity2.onImageSwitch(imagePreviewActivity2.getPosition());
    }
}
