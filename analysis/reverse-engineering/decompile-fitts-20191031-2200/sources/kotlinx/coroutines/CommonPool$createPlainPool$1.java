package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

final class CommonPool$createPlainPool$1 implements ThreadFactory {
    final /* synthetic */ AtomicInteger $threadId;

    CommonPool$createPlainPool$1(AtomicInteger atomicInteger) {
        this.$threadId = atomicInteger;
    }

    @NotNull
    public final Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder();
        sb.append("CommonPool-worker-");
        sb.append(this.$threadId.incrementAndGet());
        Thread thread = new Thread(runnable, sb.toString());
        thread.setDaemon(true);
        return thread;
    }
}
