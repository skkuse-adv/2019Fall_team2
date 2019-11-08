package kr.co.popone.fitts.feature.appreview;

import android.view.View;
import android.view.View.OnClickListener;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;

final class AppReview$showAppReviewDialog$1 implements OnClickListener {
    final /* synthetic */ View $appReviewMainLayout;
    final /* synthetic */ View $positiveReviewLayout;

    AppReview$showAppReviewDialog$1(View view, View view2) {
        this.$appReviewMainLayout = view;
        this.$positiveReviewLayout = view2;
    }

    public final void onClick(View view) {
        Logger.d("mainPositiveButton clicked", new Object[0]);
        View view2 = this.$appReviewMainLayout;
        Intrinsics.checkExpressionValueIsNotNull(view2, "appReviewMainLayout");
        view2.setVisibility(8);
        View view3 = this.$positiveReviewLayout;
        Intrinsics.checkExpressionValueIsNotNull(view3, "positiveReviewLayout");
        view3.setVisibility(0);
    }
}
