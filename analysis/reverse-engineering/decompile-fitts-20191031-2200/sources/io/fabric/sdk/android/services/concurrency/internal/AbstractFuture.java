package io.fabric.sdk.android.services.concurrency.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public abstract class AbstractFuture<V> implements Future<V> {
    private final Sync<V> sync = new Sync<>();

    static final class Sync<V> extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 0;
        private Throwable exception;
        private V value;

        Sync() {
        }

        /* access modifiers changed from: protected */
        public int tryAcquireShared(int i) {
            return isDone() ? 1 : -1;
        }

        /* access modifiers changed from: protected */
        public boolean tryReleaseShared(int i) {
            setState(i);
            return true;
        }

        /* access modifiers changed from: 0000 */
        public V get(long j) throws TimeoutException, CancellationException, ExecutionException, InterruptedException {
            if (tryAcquireSharedNanos(-1, j)) {
                return getValue();
            }
            throw new TimeoutException("Timeout waiting for task.");
        }

        /* access modifiers changed from: 0000 */
        public V get() throws CancellationException, ExecutionException, InterruptedException {
            acquireSharedInterruptibly(-1);
            return getValue();
        }

        private V getValue() throws CancellationException, ExecutionException {
            int state = getState();
            if (state == 2) {
                Throwable th = this.exception;
                if (th == null) {
                    return this.value;
                }
                throw new ExecutionException(th);
            } else if (state == 4 || state == 8) {
                throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.exception);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Error, synchronizer in invalid state: ");
                sb.append(state);
                throw new IllegalStateException(sb.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean isDone() {
            return (getState() & 14) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isCancelled() {
            return (getState() & 12) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean set(V v) {
            return complete(v, null, 2);
        }

        /* access modifiers changed from: 0000 */
        public boolean setException(Throwable th) {
            return complete(null, th, 2);
        }

        /* access modifiers changed from: 0000 */
        public boolean cancel(boolean z) {
            return complete(null, null, z ? 8 : 4);
        }

        private boolean complete(V v, Throwable th, int i) {
            boolean compareAndSetState = compareAndSetState(0, 1);
            if (compareAndSetState) {
                this.value = v;
                if ((i & 12) != 0) {
                    th = new CancellationException("Future.cancel() was called.");
                }
                this.exception = th;
                releaseShared(i);
            } else if (getState() == 1) {
                acquireShared(-1);
            }
            return compareAndSetState;
        }
    }

    /* access modifiers changed from: protected */
    public void interruptTask() {
    }

    protected AbstractFuture() {
    }

    static final CancellationException cancellationExceptionWithCause(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        return this.sync.get(timeUnit.toNanos(j));
    }

    public V get() throws InterruptedException, ExecutionException {
        return this.sync.get();
    }

    public boolean isDone() {
        return this.sync.isDone();
    }

    public boolean isCancelled() {
        return this.sync.isCancelled();
    }

    public boolean cancel(boolean z) {
        if (!this.sync.cancel(z)) {
            return false;
        }
        if (z) {
            interruptTask();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean set(V v) {
        return this.sync.set(v);
    }

    /* access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (th != null) {
            return this.sync.setException(th);
        }
        throw new NullPointerException();
    }
}
