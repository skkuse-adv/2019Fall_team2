package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class CancelFutureOnCancel extends CancelHandler {
    private final Future<?> future;

    public CancelFutureOnCancel(@NotNull Future<?> future2) {
        Intrinsics.checkParameterIsNotNull(future2, "future");
        this.future = future2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void invoke(@Nullable Throwable th) {
        this.future.cancel(false);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CancelFutureOnCancel[");
        sb.append(this.future);
        sb.append(']');
        return sb.toString();
    }
}
