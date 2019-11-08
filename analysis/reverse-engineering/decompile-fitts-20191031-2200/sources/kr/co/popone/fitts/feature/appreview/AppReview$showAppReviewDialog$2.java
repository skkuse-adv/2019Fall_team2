package kr.co.popone.fitts.feature.appreview;

import android.view.View;
import android.view.View.OnClickListener;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;

final class AppReview$showAppReviewDialog$2 implements OnClickListener {
    final /* synthetic */ View $appReviewMainLayout;
    final /* synthetic */ View $negativeReviewLayout;

    AppReview$showAppReviewDialog$2(View view, View view2) {
        this.$appReviewMainLayout = view;
        this.$negativeReviewLayout = view2;
    }

    public final void onClick(View view) {
        Logger.d("mainNegativeButton clicked", new Object[0]);
        View view2 = this.$appReviewMainLayout;
        Intrinsics.checkExpressionValueIsNotNull(view2, "appReviewMainLayout");
        view2.setVisibility(8);
        View view3 = this.$negativeReviewLayout;
        Intrinsics.checkExpressionValueIsNotNull(view3, "negativeReviewLayout");
        view3.setVisibility(0);
    }
}
