package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class DeferredCoroutine<T> extends AbstractCoroutine<T> implements Deferred<T>, SelectClause1<T> {
    @Nullable
    public Object await(@NotNull Continuation<? super T> continuation) {
        return await$suspendImpl(this, continuation);
    }

    /* access modifiers changed from: protected */
    public boolean getCancelsParent() {
        return true;
    }

    @NotNull
    public SelectClause1<T> getOnAwait() {
        return this;
    }

    public DeferredCoroutine(@NotNull CoroutineContext coroutineContext, boolean z) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        super(coroutineContext, z);
    }

    public T getCompleted() {
        return getCompletedInternal$kotlinx_coroutines_core();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object await$suspendImpl(kotlinx.coroutines.DeferredCoroutine r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.DeferredCoroutine$await$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.DeferredCoroutine$await$1 r0 = (kotlinx.coroutines.DeferredCoroutine$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.DeferredCoroutine$await$1 r0 = new kotlinx.coroutines.DeferredCoroutine$await$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.DeferredCoroutine r4 = (kotlinx.coroutines.DeferredCoroutine) r4
            boolean r4 = r5 instanceof kotlin.Result.Failure
            if (r4 != 0) goto L_0x002e
            goto L_0x004a
        L_0x002e:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            boolean r2 = r5 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x004b
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.awaitInternal$kotlinx_coroutines_core(r0)
            if (r5 != r1) goto L_0x004a
            return r1
        L_0x004a:
            return r5
        L_0x004b:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DeferredCoroutine.await$suspendImpl(kotlinx.coroutines.DeferredCoroutine, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        registerSelectClause1Internal$kotlinx_coroutines_core(selectInstance, function2);
    }
}
