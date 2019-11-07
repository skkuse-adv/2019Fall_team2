package kotlin;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.UShortIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UShortArray implements Collection<UShort>, KMappedMarker {
    @NotNull
    private final short[] storage;

    private static final class Iterator extends UShortIterator {
        private final short[] array;
        private int index;

        public Iterator(@NotNull short[] sArr) {
            Intrinsics.checkParameterIsNotNull(sArr, "array");
            this.array = sArr;
        }

        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public short nextUShort() {
            int i = this.index;
            short[] sArr = this.array;
            if (i < sArr.length) {
                this.index = i + 1;
                return UShort.m91constructorimpl(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(i));
        }
    }

    @NotNull
    /* renamed from: constructor-impl reason: not valid java name */
    public static short[] m99constructorimpl(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "storage");
        return sArr;
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m102equalsimpl(short[] sArr, @Nullable Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.areEqual((Object) sArr, (Object) ((UShortArray) obj).m113unboximpl());
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m103equalsimpl0(@NotNull short[] sArr, @NotNull short[] sArr2) {
        Intrinsics.checkParameterIsNotNull(sArr, "p1");
        Intrinsics.checkParameterIsNotNull(sArr2, "p2");
        throw null;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m106hashCodeimpl(short[] sArr) {
        if (sArr != null) {
            return Arrays.hashCode(sArr);
        }
        return 0;
    }

    public static /* synthetic */ void storage$annotations() {
    }

    @NotNull
    /* renamed from: toString-impl reason: not valid java name */
    public static String m110toStringimpl(short[] sArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("UShortArray(storage=");
        sb.append(Arrays.toString(sArr));
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-xj2QHRw reason: not valid java name */
    public boolean m111addxj2QHRw(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: contains-xj2QHRw reason: not valid java name */
    public boolean m112containsxj2QHRw(short s) {
        return m100containsxj2QHRw(this.storage, s);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m101containsAllimpl(this.storage, collection);
    }

    public boolean equals(Object obj) {
        return m102equalsimpl(this.storage, obj);
    }

    public int getSize() {
        return m105getSizeimpl(this.storage);
    }

    public int hashCode() {
        return m106hashCodeimpl(this.storage);
    }

    public boolean isEmpty() {
        return m107isEmptyimpl(this.storage);
    }

    @NotNull
    public UShortIterator iterator() {
        return m108iteratorimpl(this.storage);
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
        return m110toStringimpl(this.storage);
    }

    @NotNull
    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ short[] m113unboximpl() {
        return this.storage;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return m112containsxj2QHRw(((UShort) obj).m96unboximpl());
        }
        return false;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    private /* synthetic */ UShortArray(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "storage");
        this.storage = sArr;
    }

    @NotNull
    /* renamed from: constructor-impl reason: not valid java name */
    public static short[] m98constructorimpl(int i) {
        return m99constructorimpl(new short[i]);
    }

    /* renamed from: get-impl reason: not valid java name */
    public static final short m104getimpl(short[] sArr, int i) {
        return UShort.m91constructorimpl(sArr[i]);
    }

    /* renamed from: set-01HTLdE reason: not valid java name */
    public static final void m109set01HTLdE(short[] sArr, int i, short s) {
        sArr[i] = s;
    }

    /* renamed from: getSize-impl reason: not valid java name */
    public static int m105getSizeimpl(short[] sArr) {
        return sArr.length;
    }

    @NotNull
    /* renamed from: iterator-impl reason: not valid java name */
    public static UShortIterator m108iteratorimpl(short[] sArr) {
        return new Iterator(sArr);
    }

    /* renamed from: contains-xj2QHRw reason: not valid java name */
    public static boolean m100containsxj2QHRw(short[] sArr, short s) {
        return ArraysKt___ArraysKt.contains(sArr, s);
    }

    /* renamed from: isEmpty-impl reason: not valid java name */
    public static boolean m107isEmptyimpl(short[] sArr) {
        return sArr.length == 0;
    }

    /* renamed from: containsAll-impl reason: not valid java name */
    public static boolean m101containsAllimpl(short[] sArr, @NotNull Collection<UShort> collection) {
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        if (collection.isEmpty()) {
            return true;
        }
        for (UShort r0 : collection) {
            if (!ArraysKt___ArraysKt.contains(sArr, r0.m96unboximpl())) {
                return false;
            }
        }
        return true;
    }
}
