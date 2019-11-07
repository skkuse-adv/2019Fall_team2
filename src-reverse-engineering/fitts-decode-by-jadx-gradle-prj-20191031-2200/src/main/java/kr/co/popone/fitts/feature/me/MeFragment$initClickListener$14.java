package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.services.FittsSchemeHandler;

final class MeFragment$initClickListener$14 implements OnClickListener {
    final /* synthetic */ MeFragment this$0;

    MeFragment$initClickListener$14(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            FittsSchemeHandler schemeHandler$app_productionFittsRelease = this.this$0.getSchemeHandler$app_productionFittsRelease();
            Intrinsics.checkExpressionValueIsNotNull(activity, "it");
            schemeHandler$app_productionFittsRelease.handleScheme(activity, "fitts://collection/277?type=mixed");
        }
    }
}
