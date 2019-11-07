package photopicker.view;

import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import kotlin.jvm.internal.Intrinsics;

public final class ImagePreviewActivity$registerListener$1 implements OnPageChangeListener {
    final /* synthetic */ ImagePreviewActivity this$0;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    ImagePreviewActivity$registerListener$1(ImagePreviewActivity imagePreviewActivity) {
        this.this$0 = imagePreviewActivity;
    }

    public void onPageSelected(int i) {
        this.this$0.onImageSwitch(i);
        FrameLayout selectNot = this.this$0.getSelectNot();
        if (selectNot == null) {
            Intrinsics.throwNpe();
        }
        selectNot.setOnClickListener(new ImagePreviewActivity$registerListener$1$onPageSelected$1(this, i));
    }
}
