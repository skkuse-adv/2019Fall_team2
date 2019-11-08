package kotlin.coroutines.intrinsics;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r7v1, types: [kotlin.coroutines.Continuation<kotlin.Unit>] */
    /* JADX WARNING: type inference failed for: r8v5, types: [kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> kotlin.coroutines.Continuation<kotlin.Unit> createCoroutineUnintercepted(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r8) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.String r0 = "completion"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineCreated(r8)
            boolean r8 = r7 instanceof kotlin.coroutines.jvm.internal.BaseContinuationImpl
            if (r8 == 0) goto L_0x0019
            kotlin.coroutines.jvm.internal.BaseContinuationImpl r7 = (kotlin.coroutines.jvm.internal.BaseContinuationImpl) r7
            kotlin.coroutines.Continuation r7 = r7.create(r4)
            goto L_0x003d
        L_0x0019:
            kotlin.coroutines.CoroutineContext r5 = r4.getContext()
            kotlin.coroutines.EmptyCoroutineContext r8 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>"
            if (r5 != r8) goto L_0x0031
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1 r8 = new kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
            if (r4 == 0) goto L_0x002b
            r8.<init>(r4, r4, r7)
            goto L_0x003c
        L_0x002b:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            r7.<init>(r0)
            throw r7
        L_0x0031:
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2 r8 = new kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            if (r4 == 0) goto L_0x003e
            r1 = r8
            r2 = r4
            r3 = r5
            r6 = r7
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x003c:
            r7 = r8
        L_0x003d:
            return r7
        L_0x003e:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):kotlin.coroutines.Continuation");
    }

    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r8v1, types: [kotlin.coroutines.Continuation<kotlin.Unit>] */
    /* JADX WARNING: type inference failed for: r10v5, types: [kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <R, T> kotlin.coroutines.Continuation<kotlin.Unit> createCoroutineUnintercepted(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r8, R r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r10) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.lang.String r0 = "completion"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineCreated(r10)
            boolean r10 = r8 instanceof kotlin.coroutines.jvm.internal.BaseContinuationImpl
            if (r10 == 0) goto L_0x0019
            kotlin.coroutines.jvm.internal.BaseContinuationImpl r8 = (kotlin.coroutines.jvm.internal.BaseContinuationImpl) r8
            kotlin.coroutines.Continuation r8 = r8.create(r9, r4)
            goto L_0x003e
        L_0x0019:
            kotlin.coroutines.CoroutineContext r5 = r4.getContext()
            kotlin.coroutines.EmptyCoroutineContext r10 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>"
            if (r5 != r10) goto L_0x0031
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3 r10 = new kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
            if (r4 == 0) goto L_0x002b
            r10.<init>(r4, r4, r8, r9)
            goto L_0x003d
        L_0x002b:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            r8.<init>(r0)
            throw r8
        L_0x0031:
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4 r10 = new kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            if (r4 == 0) goto L_0x003f
            r1 = r10
            r2 = r4
            r3 = r5
            r6 = r8
            r7 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
        L_0x003d:
            r8 = r10
        L_0x003e:
            return r8
        L_0x003f:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(kotlin.jvm.functions.Function2, java.lang.Object, kotlin.coroutines.Continuation):kotlin.coroutines.Continuation");
    }

    @NotNull
    public static <T> Continuation<T> intercepted(@NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "receiver$0");
        ContinuationImpl continuationImpl = (ContinuationImpl) (!(continuation instanceof ContinuationImpl) ? null : continuation);
        if (continuationImpl == null) {
            return continuation;
        }
        Continuation intercepted = continuationImpl.intercepted();
        return intercepted != null ? intercepted : continuation;
    }
}
