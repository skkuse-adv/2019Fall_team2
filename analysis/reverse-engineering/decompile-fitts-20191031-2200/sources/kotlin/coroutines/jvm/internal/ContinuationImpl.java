package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient Continuation<Object> intercepted;

    public ContinuationImpl(@Nullable Continuation<Object> continuation, @Nullable CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    public ContinuationImpl(@Nullable Continuation<Object> continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }

    @NotNull
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        if (coroutineContext == null) {
            Intrinsics.throwNpe();
        }
        return coroutineContext;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r0 != 0) goto L_0x001b;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.Continuation<java.lang.Object> intercepted() {
        /*
            r2 = this;
            kotlin.coroutines.Continuation<java.lang.Object> r0 = r2.intercepted
            if (r0 == 0) goto L_0x0005
            goto L_0x001d
        L_0x0005:
            kotlin.coroutines.CoroutineContext r0 = r2.getContext()
            kotlin.coroutines.ContinuationInterceptor$Key r1 = kotlin.coroutines.ContinuationInterceptor.Key
            kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r1)
            kotlin.coroutines.ContinuationInterceptor r0 = (kotlin.coroutines.ContinuationInterceptor) r0
            if (r0 == 0) goto L_0x001a
            kotlin.coroutines.Continuation r0 = r0.interceptContinuation(r2)
            if (r0 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r0 = r2
        L_0x001b:
            r2.intercepted = r0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.jvm.internal.ContinuationImpl.intercepted():kotlin.coroutines.Continuation");
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
        Continuation<Object> continuation = this.intercepted;
        if (!(continuation == null || continuation == this)) {
            Element element = getContext().get(ContinuationInterceptor.Key);
            if (element == null) {
                Intrinsics.throwNpe();
            }
            ((ContinuationInterceptor) element).releaseInterceptedContinuation(continuation);
        }
        this.intercepted = CompletedContinuation.INSTANCE;
    }
}
