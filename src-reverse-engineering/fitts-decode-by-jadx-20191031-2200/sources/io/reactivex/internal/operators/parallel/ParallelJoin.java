package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T> extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile SimplePlainQueue<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i) {
            this.parent = joinSubscriptionBase;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, (long) this.prefetch);
        }

        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        public void onComplete() {
            this.parent.onComplete();
        }

        public void requestOne() {
            long j = this.produced + 1;
            if (j == ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j);
                return;
            }
            this.produced = j;
        }

        public void request(long j) {
            long j2 = this.produced + j;
            if (j2 >= ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.produced = j2;
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        /* access modifiers changed from: 0000 */
        public SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }
    }

    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            String str = "Queue full?!";
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(t);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    cancelAll();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException(str);
                    if (this.errors.compareAndSet(null, missingBackpressureException)) {
                        this.downstream.onError(missingBackpressureException);
                    } else {
                        RxJavaPlugins.onError(missingBackpressureException);
                    }
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                cancelAll();
                onError(new MissingBackpressureException(str));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: 0000 */
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
            if (r13 == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
            if (r11 == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0066, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0067, code lost:
            if (r11 == false) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0069, code lost:
            r10 = r14;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drainLoop() {
            /*
                r17 = this;
                r0 = r17
                io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber<T>[] r1 = r0.subscribers
                int r2 = r1.length
                org.reactivestreams.Subscriber<? super T> r3 = r0.downstream
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.requested
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r13 == 0) goto L_0x006d
                boolean r13 = r0.cancelled
                if (r13 == 0) goto L_0x001d
                r17.cleanup()
                return
            L_0x001d:
                io.reactivex.internal.util.AtomicThrowable r13 = r0.errors
                java.lang.Object r13 = r13.get()
                java.lang.Throwable r13 = (java.lang.Throwable) r13
                if (r13 == 0) goto L_0x002e
                r17.cleanup()
                r3.onError(r13)
                return
            L_0x002e:
                java.util.concurrent.atomic.AtomicInteger r13 = r0.done
                int r13 = r13.get()
                if (r13 != 0) goto L_0x0038
                r13 = 1
                goto L_0x0039
            L_0x0038:
                r13 = 0
            L_0x0039:
                r14 = r10
                r10 = 0
                r11 = 1
            L_0x003c:
                int r4 = r1.length
                if (r10 >= r4) goto L_0x005f
                r4 = r1[r10]
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r12 = r4.queue
                if (r12 == 0) goto L_0x005c
                java.lang.Object r12 = r12.poll()
                if (r12 == 0) goto L_0x005c
                r3.onNext(r12)
                r4.requestOne()
                r11 = 1
                long r11 = r11 + r14
                int r4 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x005a
                r10 = r11
                goto L_0x006d
            L_0x005a:
                r14 = r11
                r11 = 0
            L_0x005c:
                int r10 = r10 + 1
                goto L_0x003c
            L_0x005f:
                if (r13 == 0) goto L_0x0067
                if (r11 == 0) goto L_0x0067
                r3.onComplete()
                return
            L_0x0067:
                if (r11 == 0) goto L_0x006b
                r10 = r14
                goto L_0x006d
            L_0x006b:
                r10 = r14
                goto L_0x0011
            L_0x006d:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x00b4
                boolean r4 = r0.cancelled
                if (r4 == 0) goto L_0x0079
                r17.cleanup()
                return
            L_0x0079:
                io.reactivex.internal.util.AtomicThrowable r4 = r0.errors
                java.lang.Object r4 = r4.get()
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                if (r4 == 0) goto L_0x008a
                r17.cleanup()
                r3.onError(r4)
                return
            L_0x008a:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.done
                int r4 = r4.get()
                if (r4 != 0) goto L_0x0094
                r4 = 1
                goto L_0x0095
            L_0x0094:
                r4 = 0
            L_0x0095:
                r12 = 0
            L_0x0096:
                if (r12 >= r2) goto L_0x00aa
                r13 = r1[r12]
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r13.queue
                if (r13 == 0) goto L_0x00a7
                boolean r13 = r13.isEmpty()
                if (r13 != 0) goto L_0x00a7
                r16 = 0
                goto L_0x00ac
            L_0x00a7:
                int r12 = r12 + 1
                goto L_0x0096
            L_0x00aa:
                r16 = 1
            L_0x00ac:
                if (r4 == 0) goto L_0x00b4
                if (r16 == 0) goto L_0x00b4
                r3.onComplete()
                return
            L_0x00b4:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00c7
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00c7
                java.util.concurrent.atomic.AtomicLong r4 = r0.requested
                long r6 = -r10
                r4.addAndGet(r6)
            L_0x00c7:
                int r4 = r17.get()
                if (r4 != r5) goto L_0x00d5
                int r4 = -r5
                int r4 = r0.addAndGet(r4)
                if (r4 != 0) goto L_0x00d5
                return
            L_0x00d5:
                r5 = r4
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscription.drainLoop():void");
        }
    }

    static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        volatile boolean cancelled;
        final AtomicInteger done = new AtomicInteger();
        final Subscriber<? super T> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final JoinInnerSubscriber<T>[] subscribers;

        /* access modifiers changed from: 0000 */
        public abstract void drain();

        /* access modifiers changed from: 0000 */
        public abstract void onComplete();

        /* access modifiers changed from: 0000 */
        public abstract void onError(Throwable th);

        /* access modifiers changed from: 0000 */
        public abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        JoinSubscriptionBase(Subscriber<? super T> subscriber, int i, int i2) {
            this.downstream = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                joinInnerSubscriberArr[i3] = new JoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(i);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    cleanup();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void cancelAll() {
            for (JoinInnerSubscriber<T> cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        /* access modifiers changed from: 0000 */
        public void cleanup() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.subscribers) {
                joinInnerSubscriber.queue = null;
            }
        }
    }

    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        /* access modifiers changed from: 0000 */
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            String str = "Queue full?!";
            if (get() != 0 || !compareAndSet(0, 1)) {
                if (!joinInnerSubscriber.getQueue().offer(t) && joinInnerSubscriber.cancel()) {
                    this.errors.addThrowable(new MissingBackpressureException(str));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(t);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    joinInnerSubscriber.cancel();
                    this.errors.addThrowable(new MissingBackpressureException(str));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }

        /* access modifiers changed from: 0000 */
        public void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: 0000 */
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: 0000 */
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            if (r13 == false) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
            if (r11 == false) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
            if (((java.lang.Throwable) r0.errors.get()) == null) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
            r3.onError(r0.errors.terminate());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
            if (r11 == false) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x006b, code lost:
            r10 = r14;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drainLoop() {
            /*
                r17 = this;
                r0 = r17
                io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber<T>[] r1 = r0.subscribers
                int r2 = r1.length
                org.reactivestreams.Subscriber<? super T> r3 = r0.downstream
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.requested
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r13 == 0) goto L_0x006f
                boolean r13 = r0.cancelled
                if (r13 == 0) goto L_0x001d
                r17.cleanup()
                return
            L_0x001d:
                java.util.concurrent.atomic.AtomicInteger r13 = r0.done
                int r13 = r13.get()
                if (r13 != 0) goto L_0x0027
                r13 = 1
                goto L_0x0028
            L_0x0027:
                r13 = 0
            L_0x0028:
                r14 = r10
                r10 = 0
                r11 = 1
            L_0x002b:
                if (r10 >= r2) goto L_0x004d
                r4 = r1[r10]
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r12 = r4.queue
                if (r12 == 0) goto L_0x004a
                java.lang.Object r12 = r12.poll()
                if (r12 == 0) goto L_0x004a
                r3.onNext(r12)
                r4.requestOne()
                r11 = 1
                long r11 = r11 + r14
                int r4 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0048
                r10 = r11
                goto L_0x006f
            L_0x0048:
                r14 = r11
                r11 = 0
            L_0x004a:
                int r10 = r10 + 1
                goto L_0x002b
            L_0x004d:
                if (r13 == 0) goto L_0x0069
                if (r11 == 0) goto L_0x0069
                io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0065
                io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
                java.lang.Throwable r1 = r1.terminate()
                r3.onError(r1)
                goto L_0x0068
            L_0x0065:
                r3.onComplete()
            L_0x0068:
                return
            L_0x0069:
                if (r11 == 0) goto L_0x006d
                r10 = r14
                goto L_0x006f
            L_0x006d:
                r10 = r14
                goto L_0x0011
            L_0x006f:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x00b9
                boolean r4 = r0.cancelled
                if (r4 == 0) goto L_0x007b
                r17.cleanup()
                return
            L_0x007b:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.done
                int r4 = r4.get()
                if (r4 != 0) goto L_0x0085
                r4 = 1
                goto L_0x0086
            L_0x0085:
                r4 = 0
            L_0x0086:
                r12 = 0
            L_0x0087:
                if (r12 >= r2) goto L_0x009b
                r13 = r1[r12]
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r13.queue
                if (r13 == 0) goto L_0x0098
                boolean r13 = r13.isEmpty()
                if (r13 != 0) goto L_0x0098
                r16 = 0
                goto L_0x009d
            L_0x0098:
                int r12 = r12 + 1
                goto L_0x0087
            L_0x009b:
                r16 = 1
            L_0x009d:
                if (r4 == 0) goto L_0x00b9
                if (r16 == 0) goto L_0x00b9
                io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x00b5
                io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
                java.lang.Throwable r1 = r1.terminate()
                r3.onError(r1)
                goto L_0x00b8
            L_0x00b5:
                r3.onComplete()
            L_0x00b8:
                return
            L_0x00b9:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00cc
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00cc
                java.util.concurrent.atomic.AtomicLong r4 = r0.requested
                long r6 = -r10
                r4.addAndGet(r6)
            L_0x00cc:
                int r4 = r17.get()
                if (r4 != r5) goto L_0x00da
                int r4 = -r5
                int r4 = r0.addAndGet(r4)
                if (r4 != 0) goto L_0x00da
                return
            L_0x00da:
                r5 = r4
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.drainLoop():void");
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i, boolean z) {
        this.source = parallelFlowable;
        this.prefetch = i;
        this.delayErrors = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscriptionBase;
        if (this.delayErrors) {
            joinSubscriptionBase = new JoinSubscriptionDelayError(subscriber, this.source.parallelism(), this.prefetch);
        } else {
            joinSubscriptionBase = new JoinSubscription(subscriber, this.source.parallelism(), this.prefetch);
        }
        subscriber.onSubscribe(joinSubscriptionBase);
        this.source.subscribe(joinSubscriptionBase.subscribers);
    }
}
