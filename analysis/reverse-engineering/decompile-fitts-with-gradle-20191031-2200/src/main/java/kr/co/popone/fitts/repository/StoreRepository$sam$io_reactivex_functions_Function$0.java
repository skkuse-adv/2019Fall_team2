package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

final class StoreRepository$sam$io_reactivex_functions_Function$0 implements Function {
    private final /* synthetic */ Function1 function;

    StoreRepository$sam$io_reactivex_functions_Function$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ Object apply(Object obj) {
        return this.function.invoke(obj);
    }
}
