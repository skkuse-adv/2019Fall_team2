package kotlin.collections;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.kakao.message.template.MessageTemplateProtocol;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, KMappedMarker {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void checkElementIndex$kotlin_stdlib(int i, int i2) {
            if (i < 0 || i >= i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("index: ");
                sb.append(i);
                sb.append(", size: ");
                sb.append(i2);
                throw new IndexOutOfBoundsException(sb.toString());
            }
        }

        public final void checkPositionIndex$kotlin_stdlib(int i, int i2) {
            if (i < 0 || i > i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("index: ");
                sb.append(i);
                sb.append(", size: ");
                sb.append(i2);
                throw new IndexOutOfBoundsException(sb.toString());
            }
        }

        public final void checkRangeIndexes$kotlin_stdlib(int i, int i2, int i3) {
            String str = "fromIndex: ";
            if (i < 0 || i2 > i3) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(i);
                sb.append(", toIndex: ");
                sb.append(i2);
                sb.append(", size: ");
                sb.append(i3);
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (i > i2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(i);
                sb2.append(" > toIndex: ");
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        public final int orderedHashCode$kotlin_stdlib(@NotNull Collection<?> collection) {
            Intrinsics.checkParameterIsNotNull(collection, "c");
            int i = 1;
            for (Object next : collection) {
                i = (i * 31) + (next != null ? next.hashCode() : 0);
            }
            return i;
        }

        public final boolean orderedEquals$kotlin_stdlib(@NotNull Collection<?> collection, @NotNull Collection<?> collection2) {
            Intrinsics.checkParameterIsNotNull(collection, "c");
            Intrinsics.checkParameterIsNotNull(collection2, FacebookRequestErrorClassification.KEY_OTHER);
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            for (Object areEqual : collection) {
                if (!Intrinsics.areEqual(areEqual, it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    private class IteratorImpl implements Iterator<E>, KMappedMarker {
        private int index;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public IteratorImpl() {
        }

        /* access modifiers changed from: protected */
        public final int getIndex() {
            return this.index;
        }

        /* access modifiers changed from: protected */
        public final void setIndex(int i) {
            this.index = i;
        }

        public boolean hasNext() {
            return this.index < AbstractList.this.size();
        }

        public E next() {
            if (hasNext()) {
                AbstractList abstractList = AbstractList.this;
                int i = this.index;
                this.index = i + 1;
                return abstractList.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator<E>, KMappedMarker {
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public ListIteratorImpl(int i) {
            super();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, AbstractList.this.size());
            setIndex(i);
        }

        public boolean hasPrevious() {
            return getIndex() > 0;
        }

        public int nextIndex() {
            return getIndex();
        }

        public E previous() {
            if (hasPrevious()) {
                AbstractList abstractList = AbstractList.this;
                setIndex(getIndex() - 1);
                return abstractList.get(getIndex());
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return getIndex() - 1;
        }
    }

    private static final class SubList<E> extends AbstractList<E> implements RandomAccess {
        private int _size;
        private final int fromIndex;
        private final AbstractList<E> list;

        public SubList(@NotNull AbstractList<? extends E> abstractList, int i, int i2) {
            Intrinsics.checkParameterIsNotNull(abstractList, MessageTemplateProtocol.TYPE_LIST);
            this.list = abstractList;
            this.fromIndex = i;
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(this.fromIndex, i2, this.list.size());
            this._size = i2 - this.fromIndex;
        }

        public E get(int i) {
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this._size);
            return this.list.get(this.fromIndex + i);
        }

        public int getSize() {
            return this._size;
        }
    }

    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract E get(int i);

    public abstract int getSize();

    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected AbstractList() {
    }

    @NotNull
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(0);
    }

    @NotNull
    public ListIterator<E> listIterator(int i) {
        return new ListIteratorImpl(i);
    }

    @NotNull
    public List<E> subList(int i, int i2) {
        return new SubList(this, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return Companion.orderedEquals$kotlin_stdlib(this, (Collection) obj);
    }

    public int hashCode() {
        return Companion.orderedHashCode$kotlin_stdlib(this);
    }

    public int indexOf(Object obj) {
        int i = 0;
        for (Object areEqual : this) {
            if (Intrinsics.areEqual(areEqual, obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.areEqual(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
