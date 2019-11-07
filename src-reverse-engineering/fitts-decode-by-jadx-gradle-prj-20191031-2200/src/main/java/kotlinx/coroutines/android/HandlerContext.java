package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HandlerContext extends HandlerDispatcher implements Delay {
    private volatile HandlerContext _immediate;
    /* access modifiers changed from: private */
    public final Handler handler;
    @NotNull
    private final HandlerContext immediate;
    private final boolean invokeImmediately;
    private final String name;

    private HandlerContext(Handler handler2, String str, boolean z) {
        HandlerContext handlerContext = null;
        super(null);
        this.handler = handler2;
        this.name = str;
        this.invokeImmediately = z;
        if (this.invokeImmediately) {
            handlerContext = this;
        }
        this._immediate = handlerContext;
        HandlerContext handlerContext2 = this._immediate;
        if (handlerContext2 == null) {
            handlerContext2 = new HandlerContext(this.handler, this.name, true);
            this._immediate = handlerContext2;
        }
        this.immediate = handlerContext2;
    }

    public /* synthetic */ HandlerContext(Handler handler2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            str = null;
        }
        this(handler2, str);
    }

    public HandlerContext(@NotNull Handler handler2, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(handler2, "handler");
        this(handler2, str, false);
    }

    @NotNull
    public HandlerContext getImmediate() {
        return this.immediate;
    }

    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return !this.invokeImmediately || (Intrinsics.areEqual((Object) Looper.myLooper(), (Object) this.handler.getLooper()) ^ true);
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        this.handler.post(runnable);
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        this.handler.postDelayed(runnable, RangesKt___RangesKt.coerceAtMost(j, 4611686018427387903L));
        return new HandlerContext$invokeOnTimeout$1(this, runnable);
    }

    @NotNull
    public String toString() {
        String str = this.name;
        if (str == null) {
            String handler2 = this.handler.toString();
            Intrinsics.checkExpressionValueIsNotNull(handler2, "handler.toString()");
            return handler2;
        } else if (!this.invokeImmediately) {
            return str;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.name);
            sb.append(" [immediate]");
            return sb.toString();
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).handler == this.handler;
    }

    public int hashCode() {
        return System.identityHashCode(this.handler);
    }

    public void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
        HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 = new HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(this, cancellableContinuation);
        this.handler.postDelayed(handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1, RangesKt___RangesKt.coerceAtMost(j, 4611686018427387903L));
        cancellableContinuation.invokeOnCancellation(new HandlerContext$scheduleResumeAfterDelay$1(this, handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1));
    }
}
