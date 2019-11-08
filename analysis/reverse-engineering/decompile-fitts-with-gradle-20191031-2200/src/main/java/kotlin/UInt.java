package kotlin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UInt implements Comparable<UInt> {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    /* renamed from: box-impl reason: not valid java name */
    public static final /* synthetic */ UInt m36boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: compareTo-WZ4Q5Ns reason: not valid java name */
    private int m37compareToWZ4Q5Ns(int i) {
        return m38compareToWZ4Q5Ns(this.data, i);
    }

    /* renamed from: constructor-impl reason: not valid java name */
    public static int m39constructorimpl(int i) {
        return i;
    }

    public static /* synthetic */ void data$annotations() {
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m40equalsimpl(int i, @Nullable Object obj) {
        if (obj instanceof UInt) {
            if (i == ((UInt) obj).m44unboximpl()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m41equalsimpl0(int i, int i2) {
        throw null;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m42hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m40equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m42hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m43toStringimpl(this.data);
    }

    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ int m44unboximpl() {
        return this.data;
    }

    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m37compareToWZ4Q5Ns(((UInt) obj).m44unboximpl());
    }

    /* renamed from: compareTo-WZ4Q5Ns reason: not valid java name */
    private static int m38compareToWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }

    @NotNull
    /* renamed from: toString-impl reason: not valid java name */
    public static String m43toStringimpl(int i) {
        return String.valueOf(((long) i) & 4294967295L);
    }
}
