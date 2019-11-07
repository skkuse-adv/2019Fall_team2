package kotlinx.coroutines;

import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;

public final class Dispatchers {
    @NotNull
    private static final CoroutineDispatcher Default = CoroutineContextKt.createDefaultDispatcher();
    public static final Dispatchers INSTANCE = new Dispatchers();
    @NotNull
    private static final CoroutineDispatcher IO = DefaultScheduler.INSTANCE.getIO();
    @NotNull
    private static final CoroutineDispatcher Unconfined = Unconfined.INSTANCE;

    public static /* synthetic */ void Default$annotations() {
    }

    public static /* synthetic */ void IO$annotations() {
    }

    public static /* synthetic */ void Main$annotations() {
    }

    public static /* synthetic */ void Unconfined$annotations() {
    }

    private Dispatchers() {
    }

    @NotNull
    public static final CoroutineDispatcher getDefault() {
        return Default;
    }

    @NotNull
    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }

    @NotNull
    public static final CoroutineDispatcher getUnconfined() {
        return Unconfined;
    }

    @NotNull
    public static final CoroutineDispatcher getIO() {
        return IO;
    }
}
