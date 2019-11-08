package kr.co.popone.fitts.feature.collection;

import android.widget.ProgressBar;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class MixedCollectionActivity$outputs$$inlined$with$lambda$9<T> implements Consumer<Boolean> {
    final /* synthetic */ MixedCollectionActivity this$0;

    MixedCollectionActivity$outputs$$inlined$with$lambda$9(MixedCollectionActivity mixedCollectionActivity) {
        this.this$0 = mixedCollectionActivity;
    }

    public final void accept(Boolean bool) {
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C0010R$id.loading_progress);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "loading_progress");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        progressBar.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}
