package kotlin.collections;

import com.kakao.message.template.MessageTemplateProtocol;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class MovingSubList<E> extends AbstractList<E> implements RandomAccess {
    private int _size;
    private int fromIndex;
    private final List<E> list;

    public MovingSubList(@NotNull List<? extends E> list2) {
        Intrinsics.checkParameterIsNotNull(list2, MessageTemplateProtocol.TYPE_LIST);
        this.list = list2;
    }

    public final void move(int i, int i2) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, this.list.size());
        this.fromIndex = i;
        this._size = i2 - i;
    }

    public E get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this._size);
        return this.list.get(this.fromIndex + i);
    }

    public int getSize() {
        return this._size;
    }
}
