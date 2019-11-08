package kotlinx.coroutines.internal;

import com.facebook.internal.NativeProtocol;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ConcurrentKt {
    private static final Method REMOVE_FUTURE_ON_CANCEL;

    public static /* synthetic */ void ReentrantLock$annotations() {
    }

    @NotNull
    public static final <E> List<E> subscriberList() {
        return new CopyOnWriteArrayList();
    }

    public static final <T> T withLock(@NotNull ReentrantLock reentrantLock, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(reentrantLock, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, NativeProtocol.WEB_DIALOG_ACTION);
        reentrantLock.lock();
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            reentrantLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final <E> Set<E> identitySet(int i) {
        Set<E> newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(i));
        Intrinsics.checkExpressionValueIsNotNull(newSetFromMap, "Collections.newSetFromMa…ityHashMap(expectedSize))");
        return newSetFromMap;
    }

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", new Class[]{Boolean.TYPE});
        } catch (Throwable unused) {
            method = null;
        }
        REMOVE_FUTURE_ON_CANCEL = method;
    }

    public static final boolean removeFutureOnCancel(@NotNull Executor executor) {
        Intrinsics.checkParameterIsNotNull(executor, "executor");
        try {
            if (!(executor instanceof ScheduledExecutorService)) {
                executor = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executor;
            if (scheduledExecutorService != null) {
                Method method = REMOVE_FUTURE_ON_CANCEL;
                if (method != null) {
                    method.invoke(scheduledExecutorService, new Object[]{Boolean.valueOf(true)});
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }
}
