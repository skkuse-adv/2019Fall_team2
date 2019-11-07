package kr.co.popone.fitts.feature.main;

import android.widget.TextView;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.service.banner.NewBannerCount;

final class MainActivity$checkBannerBadges$1<T1, T2> implements BiConsumer<NewBannerCount, Throwable> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$checkBannerBadges$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(NewBannerCount newBannerCount, Throwable th) {
        if (newBannerCount != null) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.newRecommendBannerBadge);
            Intrinsics.checkExpressionValueIsNotNull(textView, "newRecommendBannerBadge");
            textView.setVisibility(newBannerCount.getBadgeCount() > 0 ? 0 : 8);
        }
    }
}
