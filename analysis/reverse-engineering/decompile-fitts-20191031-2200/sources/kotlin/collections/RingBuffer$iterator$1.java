package kotlin.collections;

public final class RingBuffer$iterator$1 extends AbstractIterator<T> {
    private int count;
    private int index;
    final /* synthetic */ RingBuffer this$0;

    RingBuffer$iterator$1(RingBuffer ringBuffer) {
        this.this$0 = ringBuffer;
        this.count = ringBuffer.size();
        this.index = ringBuffer.startIndex;
    }

    /* access modifiers changed from: protected */
    public void computeNext() {
        if (this.count == 0) {
            done();
            return;
        }
        setNext(this.this$0.buffer[this.index]);
        this.index = (this.index + 1) % this.this$0.getCapacity();
        this.count--;
    }
}
