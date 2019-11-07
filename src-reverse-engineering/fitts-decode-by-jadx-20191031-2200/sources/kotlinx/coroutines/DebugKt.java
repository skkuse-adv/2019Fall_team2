package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DebugKt {
    private static final boolean DEBUG;
    @NotNull
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r0.equals(DEBUG_PROPERTY_VALUE_AUTO) != false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r0.equals(DEBUG_PROPERTY_VALUE_ON) != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r0.equals("") != false) goto L_0x0047;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.systemProp(r0)
            if (r0 != 0) goto L_0x0009
            goto L_0x0025
        L_0x0009:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L_0x003f
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L_0x0036
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 == r2) goto L_0x002c
            r2 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r1 != r2) goto L_0x004b
            java.lang.String r1 = "auto"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004b
        L_0x0025:
            java.lang.Class<kotlinx.coroutines.CoroutineId> r0 = kotlinx.coroutines.CoroutineId.class
            boolean r0 = r0.desiredAssertionStatus()
            goto L_0x0048
        L_0x002c:
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004b
            r0 = 0
            goto L_0x0048
        L_0x0036:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004b
            goto L_0x0047
        L_0x003f:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004b
        L_0x0047:
            r0 = 1
        L_0x0048:
            DEBUG = r0
            return
        L_0x004b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DebugKt.<clinit>():void");
    }

    public static final boolean getDEBUG() {
        return DEBUG;
    }

    @NotNull
    public static final String getHexAddress(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "receiver$0");
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        Intrinsics.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(System.identityHashCode(this))");
        return hexString;
    }

    @NotNull
    public static final String toDebugString(@NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "receiver$0");
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(continuation);
        sb.append('@');
        sb.append(getHexAddress(continuation));
        return sb.toString();
    }

    @NotNull
    public static final String getClassSimpleName(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "receiver$0");
        String simpleName = obj.getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        return simpleName;
    }
}
