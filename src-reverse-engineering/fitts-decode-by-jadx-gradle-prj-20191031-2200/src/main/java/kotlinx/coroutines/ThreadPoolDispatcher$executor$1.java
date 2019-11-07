package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ThreadPoolDispatcher$executor$1 implements ThreadFactory {
    final /* synthetic */ ThreadPoolDispatcher this$0;

    ThreadPoolDispatcher$executor$1(ThreadPoolDispatcher threadPoolDispatcher) {
        this.this$0 = threadPoolDispatcher;
    }

    @NotNull
    public final PoolThread newThread(Runnable runnable) {
        String str;
        ThreadPoolDispatcher threadPoolDispatcher = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(runnable, "target");
        if (this.this$0.nThreads == 1) {
            str = this.this$0.name;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.this$0.name);
            sb.append("-");
            sb.append(this.this$0.threadNo.incrementAndGet());
            str = sb.toString();
        }
        return new PoolThread(threadPoolDispatcher, runnable, str);
    }
}
