package kotlin.coroutines.jvm.internal;

import org.jetbrains.annotations.Nullable;

public interface CoroutineStackFrame {
    @Nullable
    CoroutineStackFrame getCallerFrame();

    @Nullable
    StackTraceElement getStackTraceElement();
}
