package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.services.FittsSchemeHandler;

final class MeFragment$initClickListener$15 implements OnClickListener {
    final /* synthetic */ MeFragment this$0;

    MeFragment$initClickListener$15(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void onClick(View view) {
        FittsSchemeHandler schemeHandler$app_productionFittsRelease = this.this$0.getSchemeHandler$app_productionFittsRelease();
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        schemeHandler$app_productionFittsRelease.handleScheme(requireActivity, this.this$0.getInvitationScheme());
    }
}
