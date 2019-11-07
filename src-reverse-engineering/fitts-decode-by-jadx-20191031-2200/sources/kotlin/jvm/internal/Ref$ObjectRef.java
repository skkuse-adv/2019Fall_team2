package kotlin.jvm.internal;

import java.io.Serializable;

public final class Ref$ObjectRef<T> implements Serializable {
    public T element;

    public String toString() {
        return String.valueOf(this.element);
    }
}
