package kotlin;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ULongIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ULongArray implements Collection<ULong>, KMappedMarker {
    @NotNull
    private final long[] storage;

    private static final class Iterator extends ULongIterator {
        private final long[] array;
        private int index;

        public Iterator(@NotNull long[] jArr) {
            Intrinsics.checkParameterIsNotNull(jArr, "array");
            this.array = jArr;
        }

        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public long nextULong() {
            int i = this.index;
            long[] jArr = this.array;
            if (i < jArr.length) {
                this.index = i + 1;
                return ULong.m65constructorimpl(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(i));
        }
    }

    @NotNull
    /* renamed from: constructor-impl reason: not valid java name */
    public static long[] m73constructorimpl(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "storage");
        return jArr;
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m76equalsimpl(long[] jArr, @Nullable Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.areEqual((Object) jArr, (Object) ((ULongArray) obj).m87unboximpl());
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m77equalsimpl0(@NotNull long[] jArr, @NotNull long[] jArr2) {
        Intrinsics.checkParameterIsNotNull(jArr, "p1");
        Intrinsics.checkParameterIsNotNull(jArr2, "p2");
        throw null;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m80hashCodeimpl(long[] jArr) {
        if (jArr != null) {
            return Arrays.hashCode(jArr);
        }
        return 0;
    }

    public static /* synthetic */ void storage$annotations() {
    }

    @NotNull
    /* renamed from: toString-impl reason: not valid java name */
    public static String m84toStringimpl(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("ULongArray(storage=");
        sb.append(Arrays.toString(jArr));
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-VKZWuLQ reason: not valid java name */
    public boolean m85addVKZWuLQ(long j) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: contains-VKZWuLQ reason: not valid java name */
    public boolean m86containsVKZWuLQ(long j) {
        return m74containsVKZWuLQ(this.storage, j);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m75containsAllimpl(this.storage, collection);
    }

    public boolean equals(Object obj) {
        return m76equalsimpl(this.storage, obj);
    }

    public int getSize() {
        return m79getSizeimpl(this.storage);
    }

    public int hashCode() {
        return m80hashCodeimpl(this.storage);
    }

    public boolean isEmpty() {
        return m81isEmptyimpl(this.storage);
    }

    @NotNull
    public ULongIterator iterator() {
        return m82iteratorimpl(this.storage);
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
        return m84toStringimpl(this.storage);
    }

    @NotNull
    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ long[] m87unboximpl() {
        return this.storage;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m86containsVKZWuLQ(((ULong) obj).m70unboximpl());
        }
        return false;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    private /* synthetic */ ULongArray(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "storage");
        this.storage = jArr;
    }

    @NotNull
    /* renamed from: constructor-impl reason: not valid java name */
    public static long[] m72constructorimpl(int i) {
        return m73constructorimpl(new long[i]);
    }

    /* renamed from: get-impl reason: not valid java name */
    public static final long m78getimpl(long[] jArr, int i) {
        return ULong.m65constructorimpl(jArr[i]);
    }

    /* renamed from: set-k8EXiF4 reason: not valid java name */
    public static final void m83setk8EXiF4(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    /* renamed from: getSize-impl reason: not valid java name */
    public static int m79getSizeimpl(long[] jArr) {
        return jArr.length;
    }

    @NotNull
    /* renamed from: iterator-impl reason: not valid java name */
    public static ULongIterator m82iteratorimpl(long[] jArr) {
        return new Iterator(jArr);
    }

    /* renamed from: contains-VKZWuLQ reason: not valid java name */
    public static boolean m74containsVKZWuLQ(long[] jArr, long j) {
        return ArraysKt___ArraysKt.contains(jArr, j);
    }

    /* renamed from: isEmpty-impl reason: not valid java name */
    public static boolean m81isEmptyimpl(long[] jArr) {
        return jArr.length == 0;
    }

    /* renamed from: containsAll-impl reason: not valid java name */
    public static boolean m75containsAllimpl(long[] jArr, @NotNull Collection<ULong> collection) {
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        if (collection.isEmpty()) {
            return true;
        }
        for (ULong r0 : collection) {
            if (!ArraysKt___ArraysKt.contains(jArr, r0.m70unboximpl())) {
                return false;
            }
        }
        return true;
    }
}
