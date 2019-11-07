package photopicker.view;

import android.graphics.Bitmap;

final class ImageCropActivity$saveOutput$1 implements Runnable {
    final /* synthetic */ Bitmap $croppedImage;

    ImageCropActivity$saveOutput$1(Bitmap bitmap) {
        this.$croppedImage = bitmap;
    }

    public final void run() {
        this.$croppedImage.recycle();
    }
}
