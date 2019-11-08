package kr.co.popone.fitts.feature.event;

import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.ImageUrlWithRatio;

final class AppliableEventWinnerInputActivity$loadAgreementImage$1<T1, T2> implements BiConsumer<ImageUrlWithRatio, Throwable> {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$loadAgreementImage$1(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
    }

    public final void accept(ImageUrlWithRatio imageUrlWithRatio, Throwable th) {
        this.this$0.agreementImageRequest = null;
        StringBuilder sb = new StringBuilder();
        sb.append("agreementImageResponse ");
        sb.append(imageUrlWithRatio);
        sb.append(' ');
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (imageUrlWithRatio != null) {
            ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C0010R$id.termsImageView);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "termsImageView");
            LayoutParams layoutParams = imageView.getLayoutParams();
            Resources system = Resources.getSystem();
            Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
            layoutParams.height = MathKt__MathJVMKt.roundToInt(((float) system.getDisplayMetrics().widthPixels) / imageUrlWithRatio.getRatio());
            Glide.with((FragmentActivity) this.this$0).load(imageUrlWithRatio.getUrl()).into((ImageView) this.this$0._$_findCachedViewById(C0010R$id.termsImageView));
        }
    }
}
