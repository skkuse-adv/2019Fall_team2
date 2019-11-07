package kotlinx.coroutines.android;

import androidx.annotation.Keep;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

@Keep
public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MainCoroutineDispatcher getDispatcher() {
            return HandlerDispatcherKt.Main;
        }
    }

    @NotNull
    public static final MainCoroutineDispatcher getDispatcher() {
        return Companion.getDispatcher();
    }

    public int getLoadPriority() {
        return Integer.MAX_VALUE;
    }

    @NotNull
    public MainCoroutineDispatcher createDispatcher() {
        return HandlerDispatcherKt.Main;
    }
}
