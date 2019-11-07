package kotlinx.coroutines.internal;

import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

public interface MainDispatcherFactory {
    @NotNull
    MainCoroutineDispatcher createDispatcher();

    int getLoadPriority();
}
