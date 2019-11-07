package photopicker.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.theartofdev.edmodo.cropper.CropImageView;
import kotlin.jvm.internal.Intrinsics;
import photopicker.utils.FileUtils;

final class ImageCropActivity$registerListener$2 implements OnClickListener {
    final /* synthetic */ ImageCropActivity this$0;

    ImageCropActivity$registerListener$2(ImageCropActivity imageCropActivity) {
        this.this$0 = imageCropActivity;
    }

    public final void onClick(View view) {
        ImageCropActivity imageCropActivity = this.this$0;
        imageCropActivity.saveUri = Uri.fromFile(FileUtils.INSTANCE.createCropFile(imageCropActivity));
        ImageCropActivity imageCropActivity2 = this.this$0;
        CropImageView access$getCropImageView$p = imageCropActivity2.cropImageView;
        if (access$getCropImageView$p == null) {
            Intrinsics.throwNpe();
        }
        Bitmap croppedImage = access$getCropImageView$p.getCroppedImage();
        Intrinsics.checkExpressionValueIsNotNull(croppedImage, "cropImageView!!.croppedImage");
        imageCropActivity2.saveOutput(croppedImage);
    }
}
