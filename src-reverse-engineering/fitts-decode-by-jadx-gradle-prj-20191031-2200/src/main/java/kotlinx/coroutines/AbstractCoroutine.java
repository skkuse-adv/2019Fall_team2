package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {
    @NotNull
    private final CoroutineContext context;
    @NotNull
    protected final CoroutineContext parentContext;

    public static /* synthetic */ void context$annotations() {
    }

    public int getDefaultResumeMode$kotlinx_coroutines_core() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onCancellation(@Nullable Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void onCompleted(T t) {
    }

    /* access modifiers changed from: protected */
    public void onCompletedExceptionally(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public /* synthetic */ AbstractCoroutine(CoroutineContext coroutineContext, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            z = true;
        }
        this(coroutineContext, z);
    }

    public AbstractCoroutine(@NotNull CoroutineContext coroutineContext, boolean z) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        super(z);
        this.parentContext = coroutineContext;
        this.context = this.parentContext.plus(this);
    }

    @NotNull
    public final CoroutineContext getContext() {
        return this.context;
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    public boolean isActive() {
        return super.isActive();
    }

    public final void initParentJob$kotlinx_coroutines_core() {
        initParentJobInternal$kotlinx_coroutines_core((Job) this.parentContext.get(Job.Key));
    }

    public final void onStartInternal$kotlinx_coroutines_core() {
        onStart();
    }

    public void onCompletionInternal$kotlinx_coroutines_core(@Nullable Object obj, int i, boolean z) {
        if (obj instanceof CompletedExceptionally) {
            onCompletedExceptionally(((CompletedExceptionally) obj).cause);
        } else {
            onCompleted(obj);
        }
    }

    public final void resumeWith(@NotNull Object obj) {
        makeCompletingOnce$kotlinx_coroutines_core(CompletedExceptionallyKt.toState(obj), getDefaultResumeMode$kotlinx_coroutines_core());
    }

    public final void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        CoroutineExceptionHandlerKt.handleCoroutineException(this.parentContext, th, this);
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.context);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(coroutineName);
        sb.append("\":");
        sb.append(super.nameString$kotlinx_coroutines_core());
        return sb.toString();
    }

    public final void start(@NotNull CoroutineStart coroutineStart, @NotNull Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(function1, this);
    }

    public final <R> void start(@NotNull CoroutineStart coroutineStart, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(function2, r, this);
    }
}
