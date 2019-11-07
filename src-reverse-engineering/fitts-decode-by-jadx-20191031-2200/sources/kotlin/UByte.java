package kotlin;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    /* renamed from: box-impl reason: not valid java name */
    public static final /* synthetic */ UByte m10boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: compareTo-7apg3OU reason: not valid java name */
    private int m11compareTo7apg3OU(byte b) {
        return m12compareTo7apg3OU(this.data, b);
    }

    /* renamed from: constructor-impl reason: not valid java name */
    public static byte m13constructorimpl(byte b) {
        return b;
    }

    public static /* synthetic */ void data$annotations() {
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m14equalsimpl(byte b, @Nullable Object obj) {
        if (obj instanceof UByte) {
            if (b == ((UByte) obj).m18unboximpl()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m15equalsimpl0(byte b, byte b2) {
        throw null;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m16hashCodeimpl(byte b) {
        return b;
    }

    public boolean equals(Object obj) {
        return m14equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m16hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m17toStringimpl(this.data);
    }

    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ byte m18unboximpl() {
        return this.data;
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m11compareTo7apg3OU(((UByte) obj).m18unboximpl());
    }

    /* renamed from: compareTo-7apg3OU reason: not valid java name */
    private static int m12compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare((int) b & MAX_VALUE, (int) b2 & MAX_VALUE);
    }

    @NotNull
    /* renamed from: toString-impl reason: not valid java name */
    public static String m17toStringimpl(byte b) {
        return String.valueOf(b & MAX_VALUE);
    }
}
