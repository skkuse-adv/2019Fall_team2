package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SelectAwaitOnCompletion<T, R> extends JobNode<JobSupport> {
    private final Function2<T, Continuation<? super R>, Object> block;
    private final SelectInstance<R> select;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public SelectAwaitOnCompletion(@NotNull JobSupport jobSupport, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(jobSupport, "job");
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        super(jobSupport);
        this.select = selectInstance;
        this.block = function2;
    }

    public void invoke(@Nullable Throwable th) {
        if (this.select.trySelect(null)) {
            ((JobSupport) this.job).selectAwaitCompletion$kotlinx_coroutines_core(this.select, this.block);
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SelectAwaitOnCompletion[");
        sb.append(this.select);
        sb.append(']');
        return sb.toString();
    }
}
