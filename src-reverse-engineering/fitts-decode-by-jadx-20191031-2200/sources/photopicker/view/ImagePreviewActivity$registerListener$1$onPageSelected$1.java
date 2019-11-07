package photopicker.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import photopicker.model.LocalMedia;

final class ImagePreviewActivity$registerListener$1$onPageSelected$1 implements OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ ImagePreviewActivity$registerListener$1 this$0;

    ImagePreviewActivity$registerListener$1$onPageSelected$1(ImagePreviewActivity$registerListener$1 imagePreviewActivity$registerListener$1, int i) {
        this.this$0 = imagePreviewActivity$registerListener$1;
        this.$position = i;
    }

    public final void onClick(View view) {
        ImagePreviewActivity imagePreviewActivity = this.this$0.this$0;
        if (imagePreviewActivity.isSelected((LocalMedia) imagePreviewActivity.getImages().get(this.$position))) {
            ArrayList selectImages = this.this$0.this$0.getSelectImages();
            ArrayList<LocalMedia> arrayList = new ArrayList<>();
            for (Object next : selectImages) {
                if (Intrinsics.areEqual((Object) ((LocalMedia) next).getPath(), (Object) ((LocalMedia) this.this$0.this$0.getImages().get(this.$position)).getPath())) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (LocalMedia remove : arrayList) {
                arrayList2.add(Boolean.valueOf(this.this$0.this$0.getSelectImages().remove(remove)));
            }
            for (LocalMedia localMedia : this.this$0.this$0.getSelectImages()) {
                if (((LocalMedia) this.this$0.this$0.getImages().get(this.$position)).getNum() < localMedia.getNum()) {
                    localMedia.setNum(localMedia.getNum() - 1);
                }
            }
        } else {
            ((LocalMedia) this.this$0.this$0.getImages().get(this.$position)).setNum(this.this$0.this$0.getSelectImages().size() + 1);
            this.this$0.this$0.getSelectImages().add(this.this$0.this$0.getImages().get(this.$position));
        }
        if (this.this$0.this$0.getSelectImages().size() > 0) {
            TextView selectedNumTitle = this.this$0.this$0.getSelectedNumTitle();
            if (selectedNumTitle == null) {
                Intrinsics.throwNpe();
            }
            selectedNumTitle.setVisibility(0);
            TextView selectedNumTitle2 = this.this$0.this$0.getSelectedNumTitle();
            if (selectedNumTitle2 == null) {
                Intrinsics.throwNpe();
            }
            selectedNumTitle2.setText(String.valueOf(this.this$0.this$0.getSelectImages().size()));
        } else {
            TextView selectedNumTitle3 = this.this$0.this$0.getSelectedNumTitle();
            if (selectedNumTitle3 == null) {
                Intrinsics.throwNpe();
            }
            selectedNumTitle3.setVisibility(8);
        }
        this.this$0.this$0.onImageSwitch(this.$position);
    }
}
