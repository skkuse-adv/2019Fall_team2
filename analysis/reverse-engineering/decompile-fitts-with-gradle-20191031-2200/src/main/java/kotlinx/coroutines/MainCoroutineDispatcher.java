package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public static /* synthetic */ void immediate$annotations() {
    }

    @NotNull
    public abstract MainCoroutineDispatcher getImmediate();
}
