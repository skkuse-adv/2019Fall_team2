package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.services.FittsSchemeHandler;

final class MeFragment$updateMeBannerUi$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ Banner $bn;
    final /* synthetic */ MeFragment this$0;

    MeFragment$updateMeBannerUi$$inlined$apply$lambda$1(Banner banner, ImageView imageView, MeFragment meFragment, Banner banner2) {
        this.$bn = banner;
        this.this$0 = meFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            FittsSchemeHandler schemeHandler$app_productionFittsRelease = this.this$0.getSchemeHandler$app_productionFittsRelease();
            Intrinsics.checkExpressionValueIsNotNull(activity, "it");
            schemeHandler$app_productionFittsRelease.handleScheme(activity, this.$bn.getScheme());
        }
    }
}
