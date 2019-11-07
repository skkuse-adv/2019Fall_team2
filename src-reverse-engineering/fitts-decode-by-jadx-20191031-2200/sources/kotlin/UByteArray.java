package kotlin;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.UByteIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UByteArray implements Collection<UByte>, KMappedMarker {
    @NotNull
    private final byte[] storage;

    private static final class Iterator extends UByteIterator {
        private final byte[] array;
        private int index;

        public Iterator(@NotNull byte[] bArr) {
            Intrinsics.checkParameterIsNotNull(bArr, "array");
            this.array = bArr;
        }

        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public byte nextUByte() {
            int i = this.index;
            byte[] bArr = this.array;
            if (i < bArr.length) {
                this.index = i + 1;
                return UByte.m13constructorimpl(bArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(i));
        }
    }

    @NotNull
    /* renamed from: constructor-impl reason: not valid java name */
    public static byte[] m21constructorimpl(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "storage");
        return bArr;
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m24equalsimpl(byte[] bArr, @Nullable Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.areEqual((Object) bArr, (Object) ((UByteArray) obj).m35unboximpl());
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m25equalsimpl0(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkParameterIsNotNull(bArr, "p1");
        Intrinsics.checkParameterIsNotNull(bArr2, "p2");
        throw null;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m28hashCodeimpl(byte[] bArr) {
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    public static /* synthetic */ void storage$annotations() {
    }

    @NotNull
    /* renamed from: toString-impl reason: not valid java name */
    public static String m32toStringimpl(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("UByteArray(storage=");
        sb.append(Arrays.toString(bArr));
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-7apg3OU reason: not valid java name */
    public boolean m33add7apg3OU(byte b) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: contains-7apg3OU reason: not valid java name */
    public boolean m34contains7apg3OU(byte b) {
        return m22contains7apg3OU(this.storage, b);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m23containsAllimpl(this.storage, collection);
    }

    public boolean equals(Object obj) {
        return m24equalsimpl(this.storage, obj);
    }

    public int getSize() {
        return m27getSizeimpl(this.storage);
    }

    public int hashCode() {
        return m28hashCodeimpl(this.storage);
    }

    public boolean isEmpty() {
        return m29isEmptyimpl(this.storage);
    }

    @NotNull
    public UByteIterator iterator() {
        return m30iteratorimpl(this.storage);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return m32toStringimpl(this.storage);
    }

    @NotNull
    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ byte[] m35unboximpl() {
        return this.storage;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return m34contains7apg3OU(((UByte) obj).m18unboximpl());
        }
        return false;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    private /* synthetic */ UByteArray(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "storage");
        this.storage = bArr;
    }

    @NotNull
    /* renamed from: constructor-impl reason: not valid java name */
    public static byte[] m20constructorimpl(int i) {
        return m21constructorimpl(new byte[i]);
    }

    /* renamed from: get-impl reason: not valid java name */
    public static final byte m26getimpl(byte[] bArr, int i) {
        return UByte.m13constructorimpl(bArr[i]);
    }

    /* renamed from: set-VurrAj0 reason: not valid java name */
    public static final void m31setVurrAj0(byte[] bArr, int i, byte b) {
        bArr[i] = b;
    }

    /* renamed from: getSize-impl reason: not valid java name */
    public static int m27getSizeimpl(byte[] bArr) {
        return bArr.length;
    }

    @NotNull
    /* renamed from: iterator-impl reason: not valid java name */
    public static UByteIterator m30iteratorimpl(byte[] bArr) {
        return new Iterator(bArr);
    }

    /* renamed from: contains-7apg3OU reason: not valid java name */
    public static boolean m22contains7apg3OU(byte[] bArr, byte b) {
        return ArraysKt___ArraysKt.contains(bArr, b);
    }

    /* renamed from: isEmpty-impl reason: not valid java name */
    public static boolean m29isEmptyimpl(byte[] bArr) {
        return bArr.length == 0;
    }

    /* renamed from: containsAll-impl reason: not valid java name */
    public static boolean m23containsAllimpl(byte[] bArr, @NotNull Collection<UByte> collection) {
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        if (collection.isEmpty()) {
            return true;
        }
        for (UByte r0 : collection) {
            if (!ArraysKt___ArraysKt.contains(bArr, r0.m18unboximpl())) {
                return false;
            }
        }
        return true;
    }
}
