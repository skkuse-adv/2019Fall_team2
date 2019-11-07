package kotlin.coroutines;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext.DefaultImpls;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CombinedContext implements CoroutineContext, Serializable {
    private final Element element;
    private final CoroutineContext left;

    private static final class Serialized implements Serializable {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 0;
        @NotNull
        private final CoroutineContext[] elements;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(@NotNull CoroutineContext[] coroutineContextArr) {
            Intrinsics.checkParameterIsNotNull(coroutineContextArr, MessengerShareContentUtility.ELEMENTS);
            this.elements = coroutineContextArr;
        }

        @NotNull
        public final CoroutineContext[] getElements() {
            return this.elements;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
            for (CoroutineContext plus : coroutineContextArr) {
                coroutineContext = coroutineContext.plus(plus);
            }
            return coroutineContext;
        }
    }

    public CombinedContext(@NotNull CoroutineContext coroutineContext, @NotNull Element element2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "left");
        Intrinsics.checkParameterIsNotNull(element2, "element");
        this.left = coroutineContext;
        this.element = element2;
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return DefaultImpls.plus(this, coroutineContext);
    }

    @Nullable
    public <E extends Element> E get(@NotNull Key<E> key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = combinedContext.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return coroutineContext.get(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        return function2.invoke(this.left.fold(r, function2), this.element);
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull Key<?> key) {
        CoroutineContext coroutineContext;
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext minusKey = this.left.minusKey(key);
        if (minusKey == this.left) {
            coroutineContext = this;
        } else if (minusKey == EmptyCoroutineContext.INSTANCE) {
            coroutineContext = this.element;
        } else {
            coroutineContext = new CombinedContext(minusKey, this.element);
        }
        return coroutineContext;
    }

    private final int size() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                coroutineContext = null;
            }
            combinedContext = (CombinedContext) coroutineContext;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    private final boolean contains(Element element2) {
        return Intrinsics.areEqual((Object) get(element2.getKey()), (Object) element2);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else if (coroutineContext != null) {
                return contains((Element) coroutineContext);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r3.containsAll(r2) != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001b
            boolean r0 = r3 instanceof kotlin.coroutines.CombinedContext
            if (r0 == 0) goto L_0x0019
            kotlin.coroutines.CombinedContext r3 = (kotlin.coroutines.CombinedContext) r3
            int r0 = r3.size()
            int r1 = r2.size()
            if (r0 != r1) goto L_0x0019
            boolean r3 = r3.containsAll(r2)
            if (r3 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r3 = 0
            goto L_0x001c
        L_0x001b:
            r3 = 1
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.CombinedContext.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append((String) fold("", CombinedContext$toString$1.INSTANCE));
        sb.append("]");
        return sb.toString();
    }

    private final Object writeReplace() {
        int size = size();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[size];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        boolean z = false;
        ref$IntRef.element = 0;
        fold(Unit.INSTANCE, new CombinedContext$writeReplace$1(coroutineContextArr, ref$IntRef));
        if (ref$IntRef.element == size) {
            z = true;
        }
        if (z) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
