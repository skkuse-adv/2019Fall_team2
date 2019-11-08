package kotlin.text;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    @Nullable
    public static final Byte toByteOrNull(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        return toByteOrNull(str, 10);
    }

    @Nullable
    public static final Byte toByteOrNull(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Integer intOrNull = toIntOrNull(str, i);
        if (intOrNull != null) {
            int intValue = intOrNull.intValue();
            if (intValue >= -128 && intValue <= 127) {
                return Byte.valueOf((byte) intValue);
            }
        }
        return null;
    }

    @Nullable
    public static final Short toShortOrNull(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        return toShortOrNull(str, 10);
    }

    @Nullable
    public static final Short toShortOrNull(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Integer intOrNull = toIntOrNull(str, i);
        if (intOrNull != null) {
            int intValue = intOrNull.intValue();
            if (intValue >= -32768 && intValue <= 32767) {
                return Short.valueOf((short) intValue);
            }
        }
        return null;
    }

    @Nullable
    public static Integer toIntOrNull(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        return toIntOrNull(str, 10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A[LOOP:0: B:18:0x0037->B:28:0x004f, LOOP_START, PHI: r2 r3 
  PHI: (r2v2 int) = (r2v0 int), (r2v4 int) binds: [B:17:0x0035, B:28:0x004f] A[DONT_GENERATE, DONT_INLINE]
  PHI: (r3v2 int) = (r3v1 int), (r3v3 int) binds: [B:17:0x0035, B:28:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Integer toIntOrNull(@org.jetbrains.annotations.NotNull java.lang.String r9, int r10) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            kotlin.text.CharsKt__CharJVMKt.checkRadix(r10)
            int r0 = r9.length()
            r1 = 0
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            r2 = 0
            char r3 = r9.charAt(r2)
            r4 = 48
            r5 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r6 = 1
            if (r3 >= r4) goto L_0x0030
            if (r0 != r6) goto L_0x0020
            return r1
        L_0x0020:
            r4 = 45
            if (r3 != r4) goto L_0x0029
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1
            r4 = 1
            goto L_0x0032
        L_0x0029:
            r4 = 43
            if (r3 != r4) goto L_0x002f
            r3 = 1
            goto L_0x0031
        L_0x002f:
            return r1
        L_0x0030:
            r3 = 0
        L_0x0031:
            r4 = 0
        L_0x0032:
            int r7 = r5 / r10
            int r0 = r0 - r6
            if (r3 > r0) goto L_0x0052
        L_0x0037:
            char r6 = r9.charAt(r3)
            int r6 = kotlin.text.CharsKt__CharJVMKt.digitOf(r6, r10)
            if (r6 >= 0) goto L_0x0042
            return r1
        L_0x0042:
            if (r2 >= r7) goto L_0x0045
            return r1
        L_0x0045:
            int r2 = r2 * r10
            int r8 = r5 + r6
            if (r2 >= r8) goto L_0x004c
            return r1
        L_0x004c:
            int r2 = r2 - r6
            if (r3 == r0) goto L_0x0052
            int r3 = r3 + 1
            goto L_0x0037
        L_0x0052:
            if (r4 == 0) goto L_0x0059
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            goto L_0x005e
        L_0x0059:
            int r9 = -r2
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        L_0x005e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(java.lang.String, int):java.lang.Integer");
    }

    @Nullable
    public static Long toLongOrNull(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        return toLongOrNull(str, 10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f A[LOOP:0: B:17:0x003f->B:29:0x0062, LOOP_START, PHI: r3 r4 r14 
  PHI: (r3v1 java.lang.Long) = (r3v0 java.lang.Long), (r3v3 java.lang.Long) binds: [B:16:0x003d, B:29:0x0062] A[DONT_GENERATE, DONT_INLINE]
  PHI: (r4v2 int) = (r4v1 int), (r4v4 int) binds: [B:16:0x003d, B:29:0x0062] A[DONT_GENERATE, DONT_INLINE]
  PHI: (r14v2 long) = (r14v0 long), (r14v4 long) binds: [B:16:0x003d, B:29:0x0062] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Long toLongOrNull(@org.jetbrains.annotations.NotNull java.lang.String r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            java.lang.String r2 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r2)
            kotlin.text.CharsKt__CharJVMKt.checkRadix(r20)
            int r2 = r19.length()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            return r3
        L_0x0014:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 1
            if (r5 >= r6) goto L_0x0036
            if (r2 != r9) goto L_0x0026
            return r3
        L_0x0026:
            r6 = 45
            if (r5 != r6) goto L_0x002f
            r7 = -9223372036854775808
            r4 = 1
            r5 = 1
            goto L_0x0037
        L_0x002f:
            r6 = 43
            if (r5 != r6) goto L_0x0035
            r4 = 1
            goto L_0x0036
        L_0x0035:
            return r3
        L_0x0036:
            r5 = 0
        L_0x0037:
            long r10 = (long) r1
            long r12 = r7 / r10
            r14 = 0
            int r2 = r2 - r9
            if (r4 > r2) goto L_0x0066
        L_0x003f:
            char r6 = r0.charAt(r4)
            int r6 = kotlin.text.CharsKt__CharJVMKt.digitOf(r6, r1)
            if (r6 >= 0) goto L_0x004a
            return r3
        L_0x004a:
            int r9 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r9 >= 0) goto L_0x004f
            return r3
        L_0x004f:
            long r14 = r14 * r10
            r16 = r4
            long r3 = (long) r6
            long r17 = r7 + r3
            int r6 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r6 >= 0) goto L_0x005c
            r6 = 0
            return r6
        L_0x005c:
            r6 = 0
            long r14 = r14 - r3
            r4 = r16
            if (r4 == r2) goto L_0x0066
            int r4 = r4 + 1
            r3 = r6
            goto L_0x003f
        L_0x0066:
            if (r5 == 0) goto L_0x006d
            java.lang.Long r0 = java.lang.Long.valueOf(r14)
            goto L_0x0072
        L_0x006d:
            long r0 = -r14
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x0072:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(java.lang.String, int):java.lang.Long");
    }

    @NotNull
    public static final Void numberFormatError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "input");
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid number format: '");
        sb.append(str);
        sb.append('\'');
        throw new NumberFormatException(sb.toString());
    }
}
