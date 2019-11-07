package kotlin;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    /* renamed from: box-impl reason: not valid java name */
    public static final /* synthetic */ UShort m88boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: compareTo-xj2QHRw reason: not valid java name */
    private int m89compareToxj2QHRw(short s) {
        return m90compareToxj2QHRw(this.data, s);
    }

    /* renamed from: constructor-impl reason: not valid java name */
    public static short m91constructorimpl(short s) {
        return s;
    }

    public static /* synthetic */ void data$annotations() {
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m92equalsimpl(short s, @Nullable Object obj) {
        if (obj instanceof UShort) {
            if (s == ((UShort) obj).m96unboximpl()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m93equalsimpl0(short s, short s2) {
        throw null;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m94hashCodeimpl(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return m92equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m94hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m95toStringimpl(this.data);
    }

    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ short m96unboximpl() {
        return this.data;
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m89compareToxj2QHRw(((UShort) obj).m96unboximpl());
    }

    /* renamed from: compareTo-xj2QHRw reason: not valid java name */
    private static int m90compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare((int) s & MAX_VALUE, (int) s2 & MAX_VALUE);
    }

    @NotNull
    /* renamed from: toString-impl reason: not valid java name */
    public static String m95toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }
}
