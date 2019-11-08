package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.Dependency;
import io.fabric.sdk.android.services.concurrency.PriorityProvider;
import io.fabric.sdk.android.services.concurrency.Task;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DependencyPriorityBlockingQueue<E extends Dependency & Task & PriorityProvider> extends PriorityBlockingQueue<E> {
    final Queue<E> blockedQueue = new LinkedList();
    private final ReentrantLock lock = new ReentrantLock();

    public E take() throws InterruptedException {
        return get(0, null, null);
    }

    public E peek() {
        try {
            return get(1, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return get(3, Long.valueOf(j), timeUnit);
    }

    public E poll() {
        try {
            return get(2, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public int size() {
        try {
            this.lock.lock();
            return this.blockedQueue.size() + super.size();
        } finally {
            this.lock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.lock.lock();
            return concatenate(super.toArray(tArr), this.blockedQueue.toArray(tArr));
        } finally {
            this.lock.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.lock.lock();
            return concatenate(super.toArray(), this.blockedQueue.toArray());
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.lock.lock();
            int drainTo = super.drainTo(collection) + this.blockedQueue.size();
            while (!this.blockedQueue.isEmpty()) {
                collection.add(this.blockedQueue.poll());
            }
            return drainTo;
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.lock.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.blockedQueue.isEmpty() && drainTo <= i) {
                collection.add(this.blockedQueue.poll());
                drainTo++;
            }
            return drainTo;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.lock.lock();
            return super.contains(obj) || this.blockedQueue.contains(obj);
        } finally {
            this.lock.unlock();
        }
    }

    public void clear() {
        try {
            this.lock.lock();
            this.blockedQueue.clear();
            super.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.lock.lock();
            return super.remove(obj) || this.blockedQueue.remove(obj);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.lock.lock();
            return this.blockedQueue.removeAll(collection) | super.removeAll(collection);
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public E performOperation(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        E e;
        if (i == 0) {
            e = (Dependency) super.take();
        } else if (i == 1) {
            e = (Dependency) super.peek();
        } else if (i == 2) {
            e = (Dependency) super.poll();
        } else if (i != 3) {
            return null;
        } else {
            e = (Dependency) super.poll(l.longValue(), timeUnit);
        }
        return e;
    }

    /* access modifiers changed from: 0000 */
    public boolean offerBlockedResult(int i, E e) {
        try {
            this.lock.lock();
            if (i == 1) {
                super.remove(e);
            }
            boolean offer = this.blockedQueue.offer(e);
            return offer;
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public E get(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        E performOperation;
        while (true) {
            performOperation = performOperation(i, l, timeUnit);
            if (performOperation == null || canProcess(performOperation)) {
                return performOperation;
            }
            offerBlockedResult(i, performOperation);
        }
        return performOperation;
    }

    /* access modifiers changed from: 0000 */
    public boolean canProcess(E e) {
        return e.areDependenciesMet();
    }

    public void recycleBlockedQueue() {
        try {
            this.lock.lock();
            Iterator it = this.blockedQueue.iterator();
            while (it.hasNext()) {
                Dependency dependency = (Dependency) it.next();
                if (canProcess(dependency)) {
                    super.offer(dependency);
                    it.remove();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public <T> T[] concatenate(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}
