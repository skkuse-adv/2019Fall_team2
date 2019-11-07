package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

public interface CoroutineScope {
    @NotNull
    CoroutineContext getCoroutineContext();
}
