package kotlinx.coroutines;

import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final /* synthetic */ class BuildersKt__BuildersKt {
    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.runBlocking(coroutineContext, function2);
    }

    public static final <T> T runBlocking(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        EventLoop eventLoop;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        boolean z = continuationInterceptor == null;
        String str = "currentThread";
        if (z) {
            Intrinsics.checkExpressionValueIsNotNull(currentThread, str);
            eventLoop = new BlockingEventLoop(currentThread);
        } else {
            if (!(continuationInterceptor instanceof EventLoop)) {
                continuationInterceptor = null;
            }
            eventLoop = (EventLoop) continuationInterceptor;
        }
        GlobalScope globalScope = GlobalScope.INSTANCE;
        if (z) {
            if (eventLoop != null) {
                coroutineContext = coroutineContext.plus(eventLoop);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.ContinuationInterceptor");
            }
        }
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(globalScope, coroutineContext);
        Intrinsics.checkExpressionValueIsNotNull(currentThread, str);
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(newCoroutineContext, currentThread, eventLoop, z);
        blockingCoroutine.start(CoroutineStart.DEFAULT, blockingCoroutine, function2);
        return blockingCoroutine.joinBlocking();
    }
}
