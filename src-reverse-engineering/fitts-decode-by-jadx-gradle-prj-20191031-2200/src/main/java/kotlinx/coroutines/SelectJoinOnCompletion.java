package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SelectJoinOnCompletion<R> extends JobNode<JobSupport> {
    private final Function1<Continuation<? super R>, Object> block;
    private final SelectInstance<R> select;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public SelectJoinOnCompletion(@NotNull JobSupport jobSupport, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(jobSupport, "job");
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        super(jobSupport);
        this.select = selectInstance;
        this.block = function1;
    }

    public void invoke(@Nullable Throwable th) {
        if (this.select.trySelect(null)) {
            CancellableKt.startCoroutineCancellable(this.block, this.select.getCompletion());
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SelectJoinOnCompletion[");
        sb.append(this.select);
        sb.append(']');
        return sb.toString();
    }
}
