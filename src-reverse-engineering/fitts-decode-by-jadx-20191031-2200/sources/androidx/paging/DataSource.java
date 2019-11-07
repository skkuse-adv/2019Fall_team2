package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class DataSource<Key, Value> {
    private AtomicBoolean mInvalid = new AtomicBoolean(false);
    private CopyOnWriteArrayList<InvalidatedCallback> mOnInvalidatedCallbacks = new CopyOnWriteArrayList<>();

    public static abstract class Factory<Key, Value> {
        public abstract DataSource<Key, Value> create();

        @NonNull
        public <ToValue> Factory<Key, ToValue> map(@NonNull Function<Value, ToValue> function) {
            return mapByPage(DataSource.createListFunction(function));
        }

        @NonNull
        public <ToValue> Factory<Key, ToValue> mapByPage(@NonNull final Function<List<Value>, List<ToValue>> function) {
            return new Factory<Key, ToValue>() {
                public DataSource<Key, ToValue> create() {
                    return Factory.this.create().mapByPage(function);
                }
            };
        }
    }

    public interface InvalidatedCallback {
        @AnyThread
        void onInvalidated();
    }

    static class LoadCallbackHelper<T> {
        private final DataSource mDataSource;
        private boolean mHasSignalled = false;
        private Executor mPostExecutor = null;
        /* access modifiers changed from: private */
        public final Receiver<T> mReceiver;
        final int mResultType;
        private final Object mSignalLock = new Object();

        static void validateInitialLoadParams(@NonNull List<?> list, int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Position must be non-negative");
            } else if (list.size() + i > i2) {
                throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            } else if (list.size() == 0 && i2 > 0) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            }
        }

        LoadCallbackHelper(@NonNull DataSource dataSource, int i, @Nullable Executor executor, @NonNull Receiver<T> receiver) {
            this.mDataSource = dataSource;
            this.mResultType = i;
            this.mPostExecutor = executor;
            this.mReceiver = receiver;
        }

        /* access modifiers changed from: 0000 */
        public void setPostExecutor(Executor executor) {
            synchronized (this.mSignalLock) {
                this.mPostExecutor = executor;
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean dispatchInvalidResultIfInvalid() {
            if (!this.mDataSource.isInvalid()) {
                return false;
            }
            dispatchResultToReceiver(PageResult.getInvalidResult());
            return true;
        }

        /* access modifiers changed from: 0000 */
        public void dispatchResultToReceiver(@NonNull final PageResult<T> pageResult) {
            Executor executor;
            synchronized (this.mSignalLock) {
                if (!this.mHasSignalled) {
                    this.mHasSignalled = true;
                    executor = this.mPostExecutor;
                } else {
                    throw new IllegalStateException("callback.onResult already called, cannot call again.");
                }
            }
            if (executor != null) {
                executor.execute(new Runnable() {
                    public void run() {
                        LoadCallbackHelper.this.mReceiver.onPageResult(LoadCallbackHelper.this.mResultType, pageResult);
                    }
                });
            } else {
                this.mReceiver.onPageResult(this.mResultType, pageResult);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract boolean isContiguous();

    @NonNull
    public abstract <ToValue> DataSource<Key, ToValue> map(@NonNull Function<Value, ToValue> function);

    @NonNull
    public abstract <ToValue> DataSource<Key, ToValue> mapByPage(@NonNull Function<List<Value>, List<ToValue>> function);

    @NonNull
    static <X, Y> Function<List<X>, List<Y>> createListFunction(@NonNull final Function<X, Y> function) {
        return new Function<List<X>, List<Y>>() {
            public List<Y> apply(@NonNull List<X> list) {
                ArrayList arrayList = new ArrayList(list.size());
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(function.apply(list.get(i)));
                }
                return arrayList;
            }
        };
    }

    static <A, B> List<B> convert(Function<List<A>, List<B>> function, List<A> list) {
        List<B> list2 = (List) function.apply(list);
        if (list2.size() == list.size()) {
            return list2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid Function ");
        sb.append(function);
        sb.append(" changed return size. This is not supported.");
        throw new IllegalStateException(sb.toString());
    }

    DataSource() {
    }

    @AnyThread
    public void addInvalidatedCallback(@NonNull InvalidatedCallback invalidatedCallback) {
        this.mOnInvalidatedCallbacks.add(invalidatedCallback);
    }

    @AnyThread
    public void removeInvalidatedCallback(@NonNull InvalidatedCallback invalidatedCallback) {
        this.mOnInvalidatedCallbacks.remove(invalidatedCallback);
    }

    @AnyThread
    public void invalidate() {
        if (this.mInvalid.compareAndSet(false, true)) {
            Iterator it = this.mOnInvalidatedCallbacks.iterator();
            while (it.hasNext()) {
                ((InvalidatedCallback) it.next()).onInvalidated();
            }
        }
    }

    @WorkerThread
    public boolean isInvalid() {
        return this.mInvalid.get();
    }
}
