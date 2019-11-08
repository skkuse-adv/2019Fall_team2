package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractCollection<E> implements Collection<E>, KMappedMarker {
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int getSize();

    @NotNull
    public abstract Iterator<E> iterator();

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected AbstractCollection() {
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @NotNull
    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(this, ", ", "[", "]", 0, null, new AbstractCollection$toString$1(this), 24, null);
    }

    @NotNull
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "array");
        T[] array = CollectionToArray.toArray(this, tArr);
        if (array != null) {
            return array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        for (Object areEqual : this) {
            if (Intrinsics.areEqual(areEqual, obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        if (collection.isEmpty()) {
            return true;
        }
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }
}
