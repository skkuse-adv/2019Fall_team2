package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement.DefaultImpls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement<String> {
    public static final Key Key = new Key(null);
    private final long id;

    public static final class Key implements kotlin.coroutines.CoroutineContext.Key<CoroutineId> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public static /* synthetic */ CoroutineId copy$default(CoroutineId coroutineId, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = coroutineId.id;
        }
        return coroutineId.copy(j);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final CoroutineId copy(long j) {
        return new CoroutineId(j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CoroutineId) {
                if (this.id == ((CoroutineId) obj).id) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    public <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        return DefaultImpls.fold(this, r, function2);
    }

    @Nullable
    public <E extends Element> E get(@NotNull kotlin.coroutines.CoroutineContext.Key<E> key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return DefaultImpls.get(this, key);
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull kotlin.coroutines.CoroutineContext.Key<?> key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return DefaultImpls.plus(this, coroutineContext);
    }

    public final long getId() {
        return this.id;
    }

    public CoroutineId(long j) {
        super(Key);
        this.id = j;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CoroutineId(");
        sb.append(this.id);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (r9 != null) goto L_0x0018;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String updateThreadContext(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext r9) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            kotlinx.coroutines.CoroutineName$Key r0 = kotlinx.coroutines.CoroutineName.Key
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r0)
            kotlinx.coroutines.CoroutineName r9 = (kotlinx.coroutines.CoroutineName) r9
            if (r9 == 0) goto L_0x0016
            java.lang.String r9 = r9.getName()
            if (r9 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            java.lang.String r9 = "coroutine"
        L_0x0018:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r1 = "currentThread"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.String r1 = r0.getName()
            java.lang.String r2 = "oldName"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            java.lang.String r3 = " @"
            r2 = r1
            int r2 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default(r2, r3, r4, r5, r6, r7)
            if (r2 >= 0) goto L_0x003b
            int r2 = r1.length()
        L_0x003b:
            int r3 = r9.length()
            int r3 = r3 + r2
            int r3 = r3 + 10
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r3 = 0
            java.lang.String r2 = r1.substring(r3, r2)
            java.lang.String r3 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            r4.append(r2)
            java.lang.String r2 = " @"
            r4.append(r2)
            r4.append(r9)
            r9 = 35
            r4.append(r9)
            long r2 = r8.id
            r4.append(r2)
            java.lang.String r9 = r4.toString()
            java.lang.String r2 = "StringBuilder(capacity).…builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r2)
            r0.setName(r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineId.updateThreadContext(kotlin.coroutines.CoroutineContext):java.lang.String");
    }

    public void restoreThreadContext(@NotNull CoroutineContext coroutineContext, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(str, "oldState");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        currentThread.setName(str);
    }
}
