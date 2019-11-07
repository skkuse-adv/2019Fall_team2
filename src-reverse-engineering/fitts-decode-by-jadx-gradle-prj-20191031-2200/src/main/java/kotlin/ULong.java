package kotlin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    /* renamed from: box-impl reason: not valid java name */
    public static final /* synthetic */ ULong m62boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: compareTo-VKZWuLQ reason: not valid java name */
    private int m63compareToVKZWuLQ(long j) {
        return m64compareToVKZWuLQ(this.data, j);
    }

    /* renamed from: constructor-impl reason: not valid java name */
    public static long m65constructorimpl(long j) {
        return j;
    }

    public static /* synthetic */ void data$annotations() {
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m66equalsimpl(long j, @Nullable Object obj) {
        if (obj instanceof ULong) {
            if (j == ((ULong) obj).m70unboximpl()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m67equalsimpl0(long j, long j2) {
        throw null;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m68hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public boolean equals(Object obj) {
        return m66equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m68hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m69toStringimpl(this.data);
    }

    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ long m70unboximpl() {
        return this.data;
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m63compareToVKZWuLQ(((ULong) obj).m70unboximpl());
    }

    /* renamed from: compareTo-VKZWuLQ reason: not valid java name */
    private static int m64compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    @NotNull
    /* renamed from: toString-impl reason: not valid java name */
    public static String m69toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }
}
