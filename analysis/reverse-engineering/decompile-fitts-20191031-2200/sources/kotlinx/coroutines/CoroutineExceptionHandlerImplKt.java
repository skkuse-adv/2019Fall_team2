package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CoroutineExceptionHandlerImplKt {
    private static final List<CoroutineExceptionHandler> handlers;

    static {
        Class<CoroutineExceptionHandler> cls = CoroutineExceptionHandler.class;
        ServiceLoader load = ServiceLoader.load(cls, cls.getClassLoader());
        Intrinsics.checkExpressionValueIsNotNull(load, "ServiceLoader.load(servi…serviceClass.classLoader)");
        handlers = CollectionsKt___CollectionsKt.toList(load);
    }

    public static final void handleCoroutineExceptionImpl(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        Iterator it = handlers.iterator();
        while (true) {
            String str = "currentThread";
            if (it.hasNext()) {
                try {
                    ((CoroutineExceptionHandler) it.next()).handleException(coroutineContext, th);
                } catch (Throwable th2) {
                    Thread currentThread = Thread.currentThread();
                    Intrinsics.checkExpressionValueIsNotNull(currentThread, str);
                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, CoroutineExceptionHandlerKt.handlerException(th, th2));
                }
            } else {
                Thread currentThread2 = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread2, str);
                currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
                return;
            }
        }
    }
}
