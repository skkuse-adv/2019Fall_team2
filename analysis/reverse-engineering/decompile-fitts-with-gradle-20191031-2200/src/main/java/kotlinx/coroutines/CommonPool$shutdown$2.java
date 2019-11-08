package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class CommonPool$shutdown$2 implements Executor {
    public static final CommonPool$shutdown$2 INSTANCE = new CommonPool$shutdown$2();

    CommonPool$shutdown$2() {
    }

    public final void execute(Runnable runnable) {
        throw new RejectedExecutionException("CommonPool was shutdown");
    }
}
