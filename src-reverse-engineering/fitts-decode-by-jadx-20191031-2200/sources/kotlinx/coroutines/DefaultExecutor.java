package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.EventLoopBase.DelayedRunnableTask;
import org.jetbrains.annotations.NotNull;

public final class DefaultExecutor extends EventLoopBase implements Runnable {
    public static final DefaultExecutor INSTANCE = new DefaultExecutor();
    private static final long KEEP_ALIVE_NANOS;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* access modifiers changed from: protected */
    public boolean isCompleted() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isCorrectThread() {
        return true;
    }

    static {
        Long l;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l = Long.valueOf(1000);
        }
        Intrinsics.checkExpressionValueIsNotNull(l, "try {\n            java.l…AULT_KEEP_ALIVE\n        }");
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    private DefaultExecutor() {
    }

    private final boolean isShutdownRequested() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(j, runnable);
        INSTANCE.schedule$kotlinx_coroutines_core(delayedRunnableTask);
        return delayedRunnableTask;
    }

    public void run() {
        TimeSourceKt.getTimeSource().registerTimeLoopThread();
        try {
            if (notifyStartup()) {
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long processNextEvent = processNextEvent();
                    if (processNextEvent == Long.MAX_VALUE) {
                        if (j == Long.MAX_VALUE) {
                            long nanoTime = TimeSourceKt.getTimeSource().nanoTime();
                            if (j == Long.MAX_VALUE) {
                                j = KEEP_ALIVE_NANOS + nanoTime;
                            }
                            long j2 = j - nanoTime;
                            if (j2 <= 0) {
                                _thread = null;
                                acknowledgeShutdownIfNeeded();
                                TimeSourceKt.getTimeSource().unregisterTimeLoopThread();
                                if (!isEmpty()) {
                                    thread();
                                }
                                return;
                            }
                            processNextEvent = RangesKt___RangesKt.coerceAtMost(processNextEvent, j2);
                        } else {
                            processNextEvent = RangesKt___RangesKt.coerceAtMost(processNextEvent, KEEP_ALIVE_NANOS);
                        }
                    }
                    if (processNextEvent > 0) {
                        if (isShutdownRequested()) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            TimeSourceKt.getTimeSource().unregisterTimeLoopThread();
                            if (!isEmpty()) {
                                thread();
                            }
                            return;
                        }
                        TimeSourceKt.getTimeSource().parkNanos(this, processNextEvent);
                    }
                }
            }
        } finally {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            TimeSourceKt.getTimeSource().unregisterTimeLoopThread();
            if (!isEmpty()) {
                thread();
            }
        }
    }

    private final Thread thread() {
        Thread thread = _thread;
        return thread != null ? thread : createThreadSync();
    }

    private final synchronized Thread createThreadSync() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* access modifiers changed from: protected */
    public void unpark() {
        TimeSourceKt.getTimeSource().unpark(thread());
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        boolean z = true;
        boolean z2 = _thread == null;
        if (_Assertions.ENABLED) {
            if (!z2) {
                throw new AssertionError("Assertion failed");
            }
        }
        if (debugStatus != 0) {
            if (debugStatus != 3) {
                z = false;
            }
        }
        if (_Assertions.ENABLED) {
            if (!z) {
                throw new AssertionError("Assertion failed");
            }
        }
        debugStatus = 0;
        createThreadSync();
        while (debugStatus == 0) {
            wait();
        }
    }

    private final synchronized boolean notifyStartup() {
        if (isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final synchronized void shutdown(long j) {
        long currentTimeMillis = System.currentTimeMillis() + j;
        if (!isShutdownRequested()) {
            debugStatus = 2;
        }
        while (true) {
            if (debugStatus == 3 || _thread == null) {
                break;
            }
            Thread thread = _thread;
            if (thread != null) {
                TimeSourceKt.getTimeSource().unpark(thread);
            }
            if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            }
            wait(j);
        }
        debugStatus = 0;
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (isShutdownRequested()) {
            debugStatus = 3;
            resetAll();
            notifyAll();
        }
    }
}
