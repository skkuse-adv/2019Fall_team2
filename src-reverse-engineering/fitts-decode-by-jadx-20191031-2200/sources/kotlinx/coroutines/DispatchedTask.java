package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DispatchedTask<T> extends Runnable {

    public static final class DefaultImpls {
        public static <T> int getResumeMode(DispatchedTask<? super T> dispatchedTask) {
            return 1;
        }

        public static <T_I1, T> T getSuccessfulResult(DispatchedTask<? super T_I1> dispatchedTask, @Nullable Object obj) {
            return obj;
        }

        @Nullable
        public static <T> Throwable getExceptionalResult(DispatchedTask<? super T> dispatchedTask, @Nullable Object obj) {
            if (!(obj instanceof CompletedExceptionally)) {
                obj = null;
            }
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            if (completedExceptionally != null) {
                return completedExceptionally.cause;
            }
            return null;
        }

        public static <T> void run(DispatchedTask<? super T> dispatchedTask) {
            CoroutineContext context;
            Object updateThreadContext;
            try {
                Continuation delegate = dispatchedTask.getDelegate();
                if (delegate != null) {
                    DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate;
                    Continuation<T> continuation = dispatchedContinuation.continuation;
                    context = continuation.getContext();
                    Job job = ResumeModeKt.isCancellableMode(dispatchedTask.getResumeMode()) ? (Job) context.get(Job.Key) : null;
                    Object takeState = dispatchedTask.takeState();
                    updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
                    if (job != null) {
                        if (!job.isActive()) {
                            CancellationException cancellationException = job.getCancellationException();
                            Companion companion = Result.Companion;
                            continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(cancellationException)));
                            Unit unit = Unit.INSTANCE;
                            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                            return;
                        }
                    }
                    Throwable exceptionalResult = dispatchedTask.getExceptionalResult(takeState);
                    if (exceptionalResult != null) {
                        Companion companion2 = Result.Companion;
                        continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(exceptionalResult)));
                    } else {
                        Object successfulResult = dispatchedTask.getSuccessfulResult(takeState);
                        Companion companion3 = Result.Companion;
                        continuation.resumeWith(Result.m1constructorimpl(successfulResult));
                    }
                    Unit unit2 = Unit.INSTANCE;
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected exception running ");
                sb.append(dispatchedTask);
                throw new DispatchException(sb.toString(), th);
            }
        }
    }

    @NotNull
    Continuation<T> getDelegate();

    @Nullable
    Throwable getExceptionalResult(@Nullable Object obj);

    int getResumeMode();

    <T> T getSuccessfulResult(@Nullable Object obj);

    void run();

    @Nullable
    Object takeState();
}
