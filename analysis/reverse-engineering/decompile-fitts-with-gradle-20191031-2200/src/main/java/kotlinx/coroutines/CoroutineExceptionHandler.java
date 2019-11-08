package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import org.jetbrains.annotations.NotNull;

public interface CoroutineExceptionHandler extends Element {
    public static final Key Key = Key.$$INSTANCE;

    public static final class Key implements kotlin.coroutines.CoroutineContext.Key<CoroutineExceptionHandler> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th);
}
