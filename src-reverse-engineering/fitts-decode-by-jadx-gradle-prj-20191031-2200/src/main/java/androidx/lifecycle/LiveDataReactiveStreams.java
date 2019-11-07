package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class LiveDataReactiveStreams {

    private static final class LiveDataPublisher<T> implements Publisher<T> {
        final LifecycleOwner mLifecycle;
        final LiveData<T> mLiveData;

        static final class LiveDataSubscription<T> implements Subscription, Observer<T> {
            volatile boolean mCanceled;
            @Nullable
            T mLatest;
            final LifecycleOwner mLifecycle;
            final LiveData<T> mLiveData;
            boolean mObserving;
            long mRequested;
            final Subscriber<? super T> mSubscriber;

            LiveDataSubscription(Subscriber<? super T> subscriber, LifecycleOwner lifecycleOwner, LiveData<T> liveData) {
                this.mSubscriber = subscriber;
                this.mLifecycle = lifecycleOwner;
                this.mLiveData = liveData;
            }

            public void onChanged(@Nullable T t) {
                if (!this.mCanceled) {
                    if (this.mRequested > 0) {
                        this.mLatest = null;
                        this.mSubscriber.onNext(t);
                        long j = this.mRequested;
                        if (j != Long.MAX_VALUE) {
                            this.mRequested = j - 1;
                        }
                    } else {
                        this.mLatest = t;
                    }
                }
            }

            public void request(final long j) {
                if (!this.mCanceled) {
                    ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable() {
                        public void run() {
                            if (!LiveDataSubscription.this.mCanceled) {
                                long j = j;
                                if (j <= 0) {
                                    LiveDataSubscription liveDataSubscription = LiveDataSubscription.this;
                                    liveDataSubscription.mCanceled = true;
                                    if (liveDataSubscription.mObserving) {
                                        liveDataSubscription.mLiveData.removeObserver(liveDataSubscription);
                                        LiveDataSubscription.this.mObserving = false;
                                    }
                                    LiveDataSubscription liveDataSubscription2 = LiveDataSubscription.this;
                                    liveDataSubscription2.mLatest = null;
                                    liveDataSubscription2.mSubscriber.onError(new IllegalArgumentException("Non-positive request"));
                                    return;
                                }
                                LiveDataSubscription liveDataSubscription3 = LiveDataSubscription.this;
                                long j2 = liveDataSubscription3.mRequested;
                                liveDataSubscription3.mRequested = j2 + j >= j2 ? j2 + j : Long.MAX_VALUE;
                                LiveDataSubscription liveDataSubscription4 = LiveDataSubscription.this;
                                if (!liveDataSubscription4.mObserving) {
                                    liveDataSubscription4.mObserving = true;
                                    liveDataSubscription4.mLiveData.observe(liveDataSubscription4.mLifecycle, liveDataSubscription4);
                                } else {
                                    T t = liveDataSubscription4.mLatest;
                                    if (t != null) {
                                        liveDataSubscription4.onChanged(t);
                                        LiveDataSubscription.this.mLatest = null;
                                    }
                                }
                            }
                        }
                    });
                }
            }

            public void cancel() {
                if (!this.mCanceled) {
                    this.mCanceled = true;
                    ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable() {
                        public void run() {
                            LiveDataSubscription liveDataSubscription = LiveDataSubscription.this;
                            if (liveDataSubscription.mObserving) {
                                liveDataSubscription.mLiveData.removeObserver(liveDataSubscription);
                                LiveDataSubscription.this.mObserving = false;
                            }
                            LiveDataSubscription.this.mLatest = null;
                        }
                    });
                }
            }
        }

        LiveDataPublisher(LifecycleOwner lifecycleOwner, LiveData<T> liveData) {
            this.mLifecycle = lifecycleOwner;
            this.mLiveData = liveData;
        }

        public void subscribe(Subscriber<? super T> subscriber) {
            subscriber.onSubscribe(new LiveDataSubscription(subscriber, this.mLifecycle, this.mLiveData));
        }
    }

    private static class PublisherLiveData<T> extends LiveData<T> {
        private final Publisher<T> mPublisher;
        final AtomicReference<LiveDataSubscriber> mSubscriber = new AtomicReference<>();

        final class LiveDataSubscriber extends AtomicReference<Subscription> implements Subscriber<T> {
            LiveDataSubscriber() {
            }

            public void onSubscribe(Subscription subscription) {
                if (compareAndSet(null, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.cancel();
                }
            }

            public void onNext(T t) {
                PublisherLiveData.this.postValue(t);
            }

            public void onError(final Throwable th) {
                PublisherLiveData.this.mSubscriber.compareAndSet(this, null);
                ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable() {
                    public void run() {
                        throw new RuntimeException("LiveData does not handle errors. Errors from publishers should be handled upstream and propagated as state", th);
                    }
                });
            }

            public void onComplete() {
                PublisherLiveData.this.mSubscriber.compareAndSet(this, null);
            }

            public void cancelSubscription() {
                Subscription subscription = (Subscription) get();
                if (subscription != null) {
                    subscription.cancel();
                }
            }
        }

        PublisherLiveData(@NonNull Publisher<T> publisher) {
            this.mPublisher = publisher;
        }

        /* access modifiers changed from: protected */
        public void onActive() {
            super.onActive();
            LiveDataSubscriber liveDataSubscriber = new LiveDataSubscriber();
            this.mSubscriber.set(liveDataSubscriber);
            this.mPublisher.subscribe(liveDataSubscriber);
        }

        /* access modifiers changed from: protected */
        public void onInactive() {
            super.onInactive();
            LiveDataSubscriber liveDataSubscriber = (LiveDataSubscriber) this.mSubscriber.getAndSet(null);
            if (liveDataSubscriber != null) {
                liveDataSubscriber.cancelSubscription();
            }
        }
    }

    private LiveDataReactiveStreams() {
    }

    @NonNull
    public static <T> Publisher<T> toPublisher(@NonNull LifecycleOwner lifecycleOwner, @NonNull LiveData<T> liveData) {
        return new LiveDataPublisher(lifecycleOwner, liveData);
    }

    @NonNull
    public static <T> LiveData<T> fromPublisher(@NonNull Publisher<T> publisher) {
        return new PublisherLiveData(publisher);
    }
}
