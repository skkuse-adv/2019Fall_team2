package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

final class JoinActivity$sam$io_reactivex_functions_Consumer$0 implements Consumer {
    private final /* synthetic */ Function1 function;

    JoinActivity$sam$io_reactivex_functions_Consumer$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void accept(Object obj) {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(obj), "invoke(...)");
    }
}
