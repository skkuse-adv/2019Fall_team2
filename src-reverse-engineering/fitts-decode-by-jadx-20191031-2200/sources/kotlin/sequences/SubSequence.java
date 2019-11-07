package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    /* access modifiers changed from: private */
    public final int endIndex;
    /* access modifiers changed from: private */
    public final Sequence<T> sequence;
    /* access modifiers changed from: private */
    public final int startIndex;

    public SubSequence(@NotNull Sequence<? extends T> sequence2, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(sequence2, "sequence");
        this.sequence = sequence2;
        this.startIndex = i;
        this.endIndex = i2;
        boolean z = true;
        if (this.startIndex >= 0) {
            if (this.endIndex >= 0) {
                if (this.endIndex < this.startIndex) {
                    z = false;
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("endIndex should be not less than startIndex, but was ");
                    sb.append(this.endIndex);
                    sb.append(" < ");
                    sb.append(this.startIndex);
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex should be non-negative, but is ");
            sb2.append(this.endIndex);
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("startIndex should be non-negative, but is ");
        sb3.append(this.startIndex);
        throw new IllegalArgumentException(sb3.toString().toString());
    }

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    @NotNull
    public Sequence<T> drop(int i) {
        return i >= getCount() ? SequencesKt__SequencesKt.emptySequence() : new SubSequence(this.sequence, this.startIndex + i, this.endIndex);
    }

    @NotNull
    public Sequence<T> take(int i) {
        if (i >= getCount()) {
            return this;
        }
        Sequence<T> sequence2 = this.sequence;
        int i2 = this.startIndex;
        return new SubSequence(sequence2, i2, i + i2);
    }

    @NotNull
    public Iterator<T> iterator() {
        return new SubSequence$iterator$1(this);
    }
}
