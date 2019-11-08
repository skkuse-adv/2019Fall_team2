package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CoroutineName extends AbstractCoroutineContextElement {
    public static final Key Key = new Key(null);
    @NotNull
    private final String name;

    public static final class Key implements kotlin.coroutines.CoroutineContext.Key<CoroutineName> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public static /* synthetic */ CoroutineName copy$default(CoroutineName coroutineName, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coroutineName.name;
        }
        return coroutineName.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final CoroutineName copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        return new CoroutineName(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.name, (java.lang.Object) ((kotlinx.coroutines.CoroutineName) r2).name) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kotlinx.coroutines.CoroutineName
            if (r0 == 0) goto L_0x0013
            kotlinx.coroutines.CoroutineName r2 = (kotlinx.coroutines.CoroutineName) r2
            java.lang.String r0 = r1.name
            java.lang.String r2 = r2.name
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            return r2
        L_0x0015:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineName.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public CoroutineName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        super(Key);
        this.name = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CoroutineName(");
        sb.append(this.name);
        sb.append(')');
        return sb.toString();
    }
}
