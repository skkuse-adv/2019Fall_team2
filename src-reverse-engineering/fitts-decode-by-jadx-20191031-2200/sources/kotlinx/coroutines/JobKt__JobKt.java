package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final /* synthetic */ class JobKt__JobKt {
    @NotNull
    public static final Job Job(@Nullable Job job) {
        return new JobImpl(job);
    }

    @NotNull
    public static /* synthetic */ Job Job$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    @NotNull
    public static final DisposableHandle DisposableHandle(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "block");
        return new JobKt__JobKt$DisposableHandle$1(function0);
    }

    @NotNull
    public static final DisposableHandle disposeOnCompletion(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        Intrinsics.checkParameterIsNotNull(job, "receiver$0");
        Intrinsics.checkParameterIsNotNull(disposableHandle, "handle");
        return job.invokeOnCompletion(new DisposeOnCompletion(job, disposableHandle));
    }

    @Nullable
    public static final Object cancelAndJoin(@NotNull Job job, @NotNull Continuation<? super Unit> continuation) {
        job.cancel();
        return job.join(continuation);
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        JobKt.cancelChildren(job, th);
    }

    public static final void cancelChildren(@NotNull Job job, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(job, "receiver$0");
        for (Job cancel : job.getChildren()) {
            cancel.cancel(th);
        }
    }

    public static final void cancelChildren(@NotNull Job job) {
        Intrinsics.checkParameterIsNotNull(job, "receiver$0");
        for (Job cancel : job.getChildren()) {
            cancel.cancel();
        }
    }

    public static final boolean isActive(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "receiver$0");
        Job job = (Job) coroutineContext.get(Job.Key);
        return job != null && job.isActive();
    }

    public static final void cancel(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "receiver$0");
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            job.cancel();
        }
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        return JobKt.cancel(coroutineContext, th);
    }

    public static final boolean cancel(@NotNull CoroutineContext coroutineContext, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "receiver$0");
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            return job.cancel(th);
        }
        return false;
    }

    public static final void cancelChildren(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "receiver$0");
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            Sequence<Job> children = job.getChildren();
            if (children != null) {
                for (Job cancel : children) {
                    cancel.cancel();
                }
            }
        }
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        JobKt.cancelChildren(coroutineContext, th);
    }

    public static final void cancelChildren(@NotNull CoroutineContext coroutineContext, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "receiver$0");
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            Sequence<Job> children = job.getChildren();
            if (children != null) {
                for (Job cancel : children) {
                    cancel.cancel(th);
                }
            }
        }
    }
}
