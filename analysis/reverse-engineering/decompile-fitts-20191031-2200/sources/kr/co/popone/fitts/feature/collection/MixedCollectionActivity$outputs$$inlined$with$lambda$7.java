package kr.co.popone.fitts.feature.collection;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.services.FittsSchemeHandler;

final class MixedCollectionActivity$outputs$$inlined$with$lambda$7<T> implements Consumer<String> {
    final /* synthetic */ MixedCollectionActivity this$0;

    MixedCollectionActivity$outputs$$inlined$with$lambda$7(MixedCollectionActivity mixedCollectionActivity) {
        this.this$0 = mixedCollectionActivity;
    }

    public final void accept(String str) {
        this.this$0.handleCustomScheme(str);
        FittsSchemeHandler schemeHandler$app_productionFittsRelease = this.this$0.getSchemeHandler$app_productionFittsRelease();
        MixedCollectionActivity mixedCollectionActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(str, "it");
        schemeHandler$app_productionFittsRelease.handleScheme(mixedCollectionActivity, str);
    }
}
