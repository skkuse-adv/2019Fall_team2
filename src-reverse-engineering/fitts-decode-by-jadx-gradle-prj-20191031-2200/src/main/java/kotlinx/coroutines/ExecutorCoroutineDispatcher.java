package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {
    public abstract void close();

    @NotNull
    public abstract Executor getExecutor();
}
