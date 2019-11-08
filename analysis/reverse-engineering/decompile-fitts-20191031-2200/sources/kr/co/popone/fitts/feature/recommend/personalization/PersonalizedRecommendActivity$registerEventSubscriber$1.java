package kr.co.popone.fitts.feature.recommend.personalization;

import android.widget.LinearLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class PersonalizedRecommendActivity$registerEventSubscriber$1<T> implements Consumer<Boolean> {
    final /* synthetic */ PersonalizedRecommendActivity this$0;

    PersonalizedRecommendActivity$registerEventSubscriber$1(PersonalizedRecommendActivity personalizedRecommendActivity) {
        this.this$0 = personalizedRecommendActivity;
    }

    public final void accept(Boolean bool) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.personalizedRecommendLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "personalizedRecommendLayout");
        linearLayout.setVisibility(!bool.booleanValue() ? 0 : 4);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        swipeRefreshLayout.setRefreshing(bool.booleanValue());
    }
}
