package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class InvokeOnCancelling extends JobCancellingNode<Job> {
    private static final AtomicIntegerFieldUpdater _invoked$FU = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked");
    private volatile int _invoked = 0;
    private final Function1<Throwable, Unit> handler;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public InvokeOnCancelling(@NotNull Job job, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(job, "job");
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        super(job);
        this.handler = function1;
    }

    public void invoke(@Nullable Throwable th) {
        if (_invoked$FU.compareAndSet(this, 0, 1)) {
            this.handler.invoke(th);
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InvokeOnCancelling[");
        sb.append(DebugKt.getClassSimpleName(this));
        sb.append('@');
        sb.append(DebugKt.getHexAddress(this));
        sb.append(']');
        return sb.toString();
    }
}
