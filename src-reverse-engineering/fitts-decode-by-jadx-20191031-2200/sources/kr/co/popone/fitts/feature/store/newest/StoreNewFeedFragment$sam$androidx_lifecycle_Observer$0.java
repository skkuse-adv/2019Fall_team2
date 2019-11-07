package kr.co.popone.fitts.feature.store.newest;

import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

final class StoreNewFeedFragment$sam$androidx_lifecycle_Observer$0 implements Observer {
    private final /* synthetic */ Function1 function;

    StoreNewFeedFragment$sam$androidx_lifecycle_Observer$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void onChanged(Object obj) {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(obj), "invoke(...)");
    }
}
