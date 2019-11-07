package kr.co.popone.fitts.feature.main;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.promotion.Promotion;

final class MainActivity$initMainUi$$inlined$let$lambda$1<T> implements Consumer<Promotion> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$initMainUi$$inlined$let$lambda$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(Promotion promotion) {
        MainActivity mainActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(promotion, "it");
        mainActivity.handlePromotion(promotion);
    }
}
