package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class CompletedIdempotentResult {
    @Nullable
    public final Object idempotentResume;
    @Nullable
    public final Object result;
    @NotNull
    public final NotCompleted token;

    public CompletedIdempotentResult(@Nullable Object obj, @Nullable Object obj2, @NotNull NotCompleted notCompleted) {
        Intrinsics.checkParameterIsNotNull(notCompleted, "token");
        this.idempotentResume = obj;
        this.result = obj2;
        this.token = notCompleted;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompletedIdempotentResult[");
        sb.append(this.result);
        sb.append(']');
        return sb.toString();
    }
}
