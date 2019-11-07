package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class GeneratorSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    @Nullable
    private T nextItem;
    private int nextState = -2;
    final /* synthetic */ GeneratorSequence this$0;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    GeneratorSequence$iterator$1(GeneratorSequence generatorSequence) {
        this.this$0 = generatorSequence;
    }

    @Nullable
    public final T getNextItem() {
        return this.nextItem;
    }

    public final void setNextItem(@Nullable T t) {
        this.nextItem = t;
    }

    public final int getNextState() {
        return this.nextState;
    }

    public final void setNextState(int i) {
        this.nextState = i;
    }

    private final void calcNext() {
        T t;
        if (this.nextState == -2) {
            t = this.this$0.getInitialValue.invoke();
        } else {
            Function1 access$getGetNextValue$p = this.this$0.getNextValue;
            T t2 = this.nextItem;
            if (t2 == null) {
                Intrinsics.throwNpe();
            }
            t = access$getGetNextValue$p.invoke(t2);
        }
        this.nextItem = t;
        this.nextState = this.nextItem == null ? 0 : 1;
    }

    @NotNull
    public T next() {
        if (this.nextState < 0) {
            calcNext();
        }
        if (this.nextState != 0) {
            T t = this.nextItem;
            if (t != null) {
                this.nextState = -1;
                return t;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        if (this.nextState < 0) {
            calcNext();
        }
        return this.nextState == 1;
    }
}
