package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class ThreadContextKt$countAll$1 extends Lambda implements Function2<Object, Element, Object> {
    public static final ThreadContextKt$countAll$1 INSTANCE = new ThreadContextKt$countAll$1();

    ThreadContextKt$countAll$1() {
        super(2);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.coroutines.CoroutineContext$Element, code=java.lang.Object, for r3v0, types: [kotlin.coroutines.CoroutineContext$Element, java.lang.Object] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.Nullable java.lang.Object r2, @org.jetbrains.annotations.NotNull java.lang.Object r3) {
        /*
            r1 = this;
            java.lang.String r0 = "element"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            boolean r0 = r3 instanceof kotlinx.coroutines.ThreadContextElement
            if (r0 == 0) goto L_0x0022
            boolean r0 = r2 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x000e
            r2 = 0
        L_0x000e:
            java.lang.Integer r2 = (java.lang.Integer) r2
            r0 = 1
            if (r2 == 0) goto L_0x0018
            int r2 = r2.intValue()
            goto L_0x0019
        L_0x0018:
            r2 = 1
        L_0x0019:
            if (r2 != 0) goto L_0x001c
            goto L_0x0021
        L_0x001c:
            int r2 = r2 + r0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
        L_0x0021:
            return r3
        L_0x0022:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadContextKt$countAll$1.invoke(java.lang.Object, kotlin.coroutines.CoroutineContext$Element):java.lang.Object");
    }
}
