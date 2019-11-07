package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Result<T> implements Serializable {
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Object value;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Failure implements Serializable {
        @NotNull
        public final Throwable exception;

        public Failure(@NotNull Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "exception");
            this.exception = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Failure) && Intrinsics.areEqual((Object) this.exception, (Object) ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Failure(");
            sb.append(this.exception);
            sb.append(')');
            return sb.toString();
        }
    }

    @NotNull
    /* renamed from: box-impl reason: not valid java name */
    public static final /* synthetic */ Result m0boximpl(@Nullable Object obj) {
        return new Result(obj);
    }

    @NotNull
    /* renamed from: constructor-impl reason: not valid java name */
    public static Object m1constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m2equalsimpl(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.areEqual(obj, ((Result) obj2).m9unboximpl());
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m3equalsimpl0(@Nullable Object obj, @Nullable Object obj2) {
        throw null;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m5hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static /* synthetic */ void value$annotations() {
    }

    public boolean equals(Object obj) {
        return m2equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m8toStringimpl(this.value);
    }

    @Nullable
    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ Object m9unboximpl() {
        return this.value;
    }

    private /* synthetic */ Result(@Nullable Object obj) {
        this.value = obj;
    }

    /* renamed from: isSuccess-impl reason: not valid java name */
    public static final boolean m7isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: isFailure-impl reason: not valid java name */
    public static final boolean m6isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    @Nullable
    /* renamed from: exceptionOrNull-impl reason: not valid java name */
    public static final Throwable m4exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    @NotNull
    /* renamed from: toString-impl reason: not valid java name */
    public static String m8toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return obj.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Success(");
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }
}
