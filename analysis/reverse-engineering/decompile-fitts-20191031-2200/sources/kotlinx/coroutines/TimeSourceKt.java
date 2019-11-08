package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class TimeSourceKt {
    @NotNull
    private static TimeSource timeSource = DefaultTimeSource.INSTANCE;

    @NotNull
    public static final TimeSource getTimeSource() {
        return timeSource;
    }

    public static final void setTimeSource(@NotNull TimeSource timeSource2) {
        Intrinsics.checkParameterIsNotNull(timeSource2, "<set-?>");
        timeSource = timeSource2;
    }
}
