package kr.co.popone.fitts.viewmodel.store.newest;

import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class NewestProductViewModel$calculateRemainTime$1<T, R> implements Function<T, R> {
    final /* synthetic */ NewestProductViewModel this$0;

    NewestProductViewModel$calculateRemainTime$1(NewestProductViewModel newestProductViewModel) {
        this.this$0 = newestProductViewModel;
    }

    @NotNull
    public final Pair<String, Integer> apply(@NotNull Long l) {
        Intrinsics.checkParameterIsNotNull(l, "it");
        return this.this$0.startTimer();
    }
}
