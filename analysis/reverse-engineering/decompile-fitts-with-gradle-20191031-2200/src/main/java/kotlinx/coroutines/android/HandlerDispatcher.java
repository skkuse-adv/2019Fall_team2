package kotlinx.coroutines.android;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Delay.DefaultImpls;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    public static /* synthetic */ void immediate$annotations() {
    }

    @NotNull
    public abstract HandlerDispatcher getImmediate();

    private HandlerDispatcher() {
    }

    public /* synthetic */ HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        return DefaultImpls.delay(this, j, continuation);
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        return DefaultImpls.invokeOnTimeout(this, j, runnable);
    }
}
