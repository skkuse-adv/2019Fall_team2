package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;

public final class CharProgressionIterator extends CharIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r3v0, types: [char, int] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CharProgressionIterator(int r3, char r4, int r5) {
        /*
            r2 = this;
            r2.<init>()
            r2.step = r5
            r2.finalElement = r4
            int r5 = r2.step
            r0 = 1
            r1 = 0
            if (r5 <= 0) goto L_0x0010
            if (r3 > r4) goto L_0x0013
            goto L_0x0014
        L_0x0010:
            if (r3 < r4) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            r2.hasNext = r0
            boolean r4 = r2.hasNext
            if (r4 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            int r3 = r2.finalElement
        L_0x001d:
            r2.next = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.CharProgressionIterator.<init>(char, char, int):void");
    }

    public final int getStep() {
        return this.step;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public char nextChar() {
        int i = this.next;
        if (i != this.finalElement) {
            this.next = this.step + i;
        } else if (this.hasNext) {
            this.hasNext = false;
        } else {
            throw new NoSuchElementException();
        }
        return (char) i;
    }
}
