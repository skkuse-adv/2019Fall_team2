package org.jetbrains.anko;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AttemptResult<T> {
    @Nullable
    private final Throwable error;
    @Nullable
    private final T value;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=T, for r1v0, types: [java.lang.Object] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ org.jetbrains.anko.AttemptResult copy$default(org.jetbrains.anko.AttemptResult r0, T r1, java.lang.Throwable r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            T r1 = r0.value
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            java.lang.Throwable r2 = r0.error
        L_0x000c:
            org.jetbrains.anko.AttemptResult r0 = r0.copy(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.AttemptResult.copy$default(org.jetbrains.anko.AttemptResult, java.lang.Object, java.lang.Throwable, int, java.lang.Object):org.jetbrains.anko.AttemptResult");
    }

    @Nullable
    public final T component1() {
        return this.value;
    }

    @Nullable
    public final Throwable component2() {
        return this.error;
    }

    @NotNull
    public final AttemptResult<T> copy(@Nullable T t, @Nullable Throwable th) {
        return new AttemptResult<>(t, th);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.error, (java.lang.Object) r3.error) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof org.jetbrains.anko.AttemptResult
            if (r0 == 0) goto L_0x001d
            org.jetbrains.anko.AttemptResult r3 = (org.jetbrains.anko.AttemptResult) r3
            T r0 = r2.value
            T r1 = r3.value
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.Throwable r0 = r2.error
            java.lang.Throwable r3 = r3.error
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.AttemptResult.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        T t = this.value;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        Throwable th = this.error;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttemptResult(value=");
        sb.append(this.value);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(")");
        return sb.toString();
    }

    public AttemptResult(@Nullable T t, @Nullable Throwable th) {
        this.value = t;
        this.error = th;
    }

    @Nullable
    public final Throwable getError() {
        return this.error;
    }

    @Nullable
    public final T getValue() {
        return this.value;
    }

    public final boolean isError() {
        return getError() != null;
    }

    public final boolean getHasValue() {
        return getError() == null;
    }

    @NotNull
    public final <R> AttemptResult<R> then(@NotNull Function1<? super T, ? extends R> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (getError() != null) {
            return this;
        }
        Throwable th = null;
        try {
            obj = function1.invoke(getValue());
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        return new AttemptResult<>(obj, th);
    }
}
