package kotlin;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UIntArray implements Collection<UInt>, KMappedMarker {
    @NotNull
    private final int[] storage;

    private static final class Iterator extends UIntIterator {
        private final int[] array;
        private int index;

        public Iterator(@NotNull int[] iArr) {
            Intrinsics.checkParameterIsNotNull(iArr, "array");
            this.array = iArr;
        }

        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public int nextUInt() {
            int i = this.index;
            int[] iArr = this.array;
            if (i < iArr.length) {
                this.index = i + 1;
                return UInt.m39constructorimpl(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(i));
        }
    }

    @NotNull
    /* renamed from: constructor-impl reason: not valid java name */
    public static int[] m47constructorimpl(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "storage");
        return iArr;
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m50equalsimpl(int[] iArr, @Nullable Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual((Object) iArr, (Object) ((UIntArray) obj).m61unboximpl());
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m51equalsimpl0(@NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkParameterIsNotNull(iArr, "p1");
        Intrinsics.checkParameterIsNotNull(iArr2, "p2");
        throw null;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m54hashCodeimpl(int[] iArr) {
        if (iArr != null) {
            return Arrays.hashCode(iArr);
        }
        return 0;
    }

    public static /* synthetic */ void storage$annotations() {
    }

    @NotNull
    /* renamed from: toString-impl reason: not valid java name */
    public static String m58toStringimpl(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("UIntArray(storage=");
        sb.append(Arrays.toString(iArr));
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-WZ4Q5Ns reason: not valid java name */
    public boolean m59addWZ4Q5Ns(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: contains-WZ4Q5Ns reason: not valid java name */
    public boolean m60containsWZ4Q5Ns(int i) {
        return m48containsWZ4Q5Ns(this.storage, i);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m49containsAllimpl(this.storage, collection);
    }

    public boolean equals(Object obj) {
        return m50equalsimpl(this.storage, obj);
    }

    public int getSize() {
        return m53getSizeimpl(this.storage);
    }

    public int hashCode() {
        return m54hashCodeimpl(this.storage);
    }

    public boolean isEmpty() {
        return m55isEmptyimpl(this.storage);
    }

    @NotNull
    public UIntIterator iterator() {
        return m56iteratorimpl(this.storage);
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
        return m58toStringimpl(this.storage);
    }

    @NotNull
    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ int[] m61unboximpl() {
        return this.storage;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m60containsWZ4Q5Ns(((UInt) obj).m44unboximpl());
        }
        return false;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    private /* synthetic */ UIntArray(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "storage");
        this.storage = iArr;
    }

    @NotNull
    /* renamed from: constructor-impl reason: not valid java name */
    public static int[] m46constructorimpl(int i) {
        return m47constructorimpl(new int[i]);
    }

    /* renamed from: get-impl reason: not valid java name */
    public static final int m52getimpl(int[] iArr, int i) {
        return UInt.m39constructorimpl(iArr[i]);
    }

    /* renamed from: set-VXSXFK8 reason: not valid java name */
    public static final void m57setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    /* renamed from: getSize-impl reason: not valid java name */
    public static int m53getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    @NotNull
    /* renamed from: iterator-impl reason: not valid java name */
    public static UIntIterator m56iteratorimpl(int[] iArr) {
        return new Iterator(iArr);
    }

    /* renamed from: contains-WZ4Q5Ns reason: not valid java name */
    public static boolean m48containsWZ4Q5Ns(int[] iArr, int i) {
        return ArraysKt___ArraysKt.contains(iArr, i);
    }

    /* renamed from: isEmpty-impl reason: not valid java name */
    public static boolean m55isEmptyimpl(int[] iArr) {
        return iArr.length == 0;
    }

    /* renamed from: containsAll-impl reason: not valid java name */
    public static boolean m49containsAllimpl(int[] iArr, @NotNull Collection<UInt> collection) {
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        if (collection.isEmpty()) {
            return true;
        }
        for (UInt r0 : collection) {
            if (!ArraysKt___ArraysKt.contains(iArr, r0.m44unboximpl())) {
                return false;
            }
        }
        return true;
    }
}
