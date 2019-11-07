package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.jvm.internal.markers.KMutableList;

public abstract class AbstractMutableList<E> extends AbstractList<E> implements List<E>, KMutableList {
    public abstract void add(int i, E e);

    public abstract int getSize();

    public abstract E removeAt(int i);

    public abstract E set(int i, E e);

    protected AbstractMutableList() {
    }

    public final /* bridge */ E remove(int i) {
        return removeAt(i);
    }

    public final /* bridge */ int size() {
        return getSize();
    }
}
