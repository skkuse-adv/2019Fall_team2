package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CoroutineExceptionHandlerKt {
    public static /* synthetic */ void handleCoroutineException$default(CoroutineContext coroutineContext, Throwable th, Job job, int i, Object obj) {
        if ((i & 4) != 0) {
            job = null;
        }
        handleCoroutineException(coroutineContext, th, job);
    }

    public static final void handleCoroutineException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th, @Nullable Job job) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (!(th instanceof CancellationException)) {
            Job job2 = (Job) coroutineContext.get(Job.Key);
            if (job2 == null || job2 == job || !job2.cancel(th)) {
                handleExceptionViaHandler(coroutineContext, th);
            }
        }
    }

    public static final void handleExceptionViaHandler(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, th);
            }
        } catch (Throwable th2) {
            CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, handlerException(th, th2));
        }
    }

    @NotNull
    public static final Throwable handlerException(@NotNull Throwable th, @NotNull Throwable th2) {
        Intrinsics.checkParameterIsNotNull(th, "originalException");
        Intrinsics.checkParameterIsNotNull(th2, "thrownException");
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        ExceptionsKt__ExceptionsKt.addSuppressed(runtimeException, th);
        return runtimeException;
    }

    @NotNull
    public static final CoroutineExceptionHandler CoroutineExceptionHandler(@NotNull Function2<? super CoroutineContext, ? super Throwable, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "handler");
        return new CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1(function2, CoroutineExceptionHandler.Key);
    }
}
