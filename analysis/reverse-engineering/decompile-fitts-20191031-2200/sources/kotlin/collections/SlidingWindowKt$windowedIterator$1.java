package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "kotlin/collections/SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4}, l = {33, 39, 46, 52, 55}, m = "invokeSuspend", n = {"gap", "buffer", "skip", "e", "gap", "buffer", "skip", "gap", "buffer", "e", "gap", "buffer", "gap", "buffer"}, s = {"I$0", "L$1", "I$1", "L$2", "I$0", "L$0", "I$1", "I$0", "L$1", "L$2", "I$0", "L$1", "I$0", "L$0"})
final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private SequenceScope p$;

    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
        this.$step = i;
        this.$size = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$step, this.$size, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.p$ = (SequenceScope) obj;
        return slidingWindowKt$windowedIterator$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SlidingWindowKt$windowedIterator$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
        */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0103 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x00e2 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x0088
            if (r1 == r6) goto L_0x006d
            if (r1 == r5) goto L_0x005e
            if (r1 == r4) goto L_0x0044
            if (r1 == r3) goto L_0x002e
            if (r1 != r2) goto L_0x0026
            java.lang.Object r0 = r12.L$0
            kotlin.collections.RingBuffer r0 = (kotlin.collections.RingBuffer) r0
            boolean r0 = r13 instanceof kotlin.Result.Failure
            if (r0 != 0) goto L_0x0021
            goto L_0x018a
        L_0x0021:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x0026:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x002e:
            java.lang.Object r1 = r12.L$1
            kotlin.collections.RingBuffer r1 = (kotlin.collections.RingBuffer) r1
            int r4 = r12.I$0
            java.lang.Object r5 = r12.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x003f
            r13 = r12
            goto L_0x0170
        L_0x003f:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x0044:
            java.lang.Object r1 = r12.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r12.L$1
            kotlin.collections.RingBuffer r5 = (kotlin.collections.RingBuffer) r5
            int r7 = r12.I$0
            java.lang.Object r8 = r12.L$0
            kotlin.sequences.SequenceScope r8 = (kotlin.sequences.SequenceScope) r8
            boolean r9 = r13 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L_0x0059
            r13 = r12
            goto L_0x0141
        L_0x0059:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x005e:
            java.lang.Object r0 = r12.L$0
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            boolean r0 = r13 instanceof kotlin.Result.Failure
            if (r0 != 0) goto L_0x0068
            goto L_0x018a
        L_0x0068:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x006d:
            java.lang.Object r1 = r12.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r2 = r12.L$1
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r3 = r12.I$0
            java.lang.Object r4 = r12.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x0083
            r13 = r12
            r7 = r0
            r0 = r3
            goto L_0x00d1
        L_0x0083:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x0088:
            boolean r1 = r13 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x018d
            kotlin.sequences.SequenceScope r13 = r12.p$
            int r1 = r12.$step
            int r7 = r12.$size
            int r1 = r1 - r7
            if (r1 < 0) goto L_0x0104
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r7)
            r3 = 0
            java.util.Iterator r4 = r12.$iterator
            r7 = r0
            r0 = r1
            r1 = r4
            r4 = r13
            r13 = r12
        L_0x00a2:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x00e2
            java.lang.Object r8 = r1.next()
            if (r3 <= 0) goto L_0x00b1
            int r3 = r3 + -1
            goto L_0x00a2
        L_0x00b1:
            r2.add(r8)
            int r9 = r2.size()
            int r10 = r13.$size
            if (r9 != r10) goto L_0x00a2
            r13.L$0 = r4
            r13.I$0 = r0
            r13.L$1 = r2
            r13.I$1 = r3
            r13.L$2 = r8
            r13.L$3 = r1
            r13.label = r6
            java.lang.Object r3 = r4.yield(r2, r13)
            if (r3 != r7) goto L_0x00d1
            return r7
        L_0x00d1:
            boolean r3 = r13.$reuseBuffer
            if (r3 == 0) goto L_0x00d9
            r2.clear()
            goto L_0x00e0
        L_0x00d9:
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r13.$size
            r2.<init>(r3)
        L_0x00e0:
            r3 = r0
            goto L_0x00a2
        L_0x00e2:
            boolean r1 = r2.isEmpty()
            r1 = r1 ^ r6
            if (r1 == 0) goto L_0x018a
            boolean r1 = r13.$partialWindows
            if (r1 != 0) goto L_0x00f5
            int r1 = r2.size()
            int r6 = r13.$size
            if (r1 != r6) goto L_0x018a
        L_0x00f5:
            r13.I$0 = r0
            r13.L$0 = r2
            r13.I$1 = r3
            r13.label = r5
            java.lang.Object r13 = r4.yield(r2, r13)
            if (r13 != r7) goto L_0x018a
            return r7
        L_0x0104:
            kotlin.collections.RingBuffer r5 = new kotlin.collections.RingBuffer
            r5.<init>(r7)
            java.util.Iterator r7 = r12.$iterator
            r8 = r13
            r13 = r12
            r11 = r7
            r7 = r1
            r1 = r11
        L_0x0110:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L_0x0147
            java.lang.Object r9 = r1.next()
            r5.add(r9)
            boolean r10 = r5.isFull()
            if (r10 == 0) goto L_0x0110
            boolean r10 = r13.$reuseBuffer
            if (r10 == 0) goto L_0x0129
            r10 = r5
            goto L_0x012e
        L_0x0129:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>(r5)
        L_0x012e:
            r13.L$0 = r8
            r13.I$0 = r7
            r13.L$1 = r5
            r13.L$2 = r9
            r13.L$3 = r1
            r13.label = r4
            java.lang.Object r9 = r8.yield(r10, r13)
            if (r9 != r0) goto L_0x0141
            return r0
        L_0x0141:
            int r9 = r13.$step
            r5.removeFirst(r9)
            goto L_0x0110
        L_0x0147:
            boolean r1 = r13.$partialWindows
            if (r1 == 0) goto L_0x018a
            r1 = r5
            r4 = r7
            r5 = r8
        L_0x014e:
            int r7 = r1.size()
            int r8 = r13.$step
            if (r7 <= r8) goto L_0x0176
            boolean r7 = r13.$reuseBuffer
            if (r7 == 0) goto L_0x015c
            r7 = r1
            goto L_0x0161
        L_0x015c:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>(r1)
        L_0x0161:
            r13.L$0 = r5
            r13.I$0 = r4
            r13.L$1 = r1
            r13.label = r3
            java.lang.Object r7 = r5.yield(r7, r13)
            if (r7 != r0) goto L_0x0170
            return r0
        L_0x0170:
            int r7 = r13.$step
            r1.removeFirst(r7)
            goto L_0x014e
        L_0x0176:
            boolean r3 = r1.isEmpty()
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x018a
            r13.I$0 = r4
            r13.L$0 = r1
            r13.label = r2
            java.lang.Object r13 = r5.yield(r1, r13)
            if (r13 != r0) goto L_0x018a
            return r0
        L_0x018a:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x018d:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            goto L_0x0193
        L_0x0192:
            throw r13
        L_0x0193:
            goto L_0x0192
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
