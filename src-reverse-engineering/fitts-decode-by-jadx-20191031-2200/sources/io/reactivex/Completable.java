package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAmb;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableCache;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDefer;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableDetach;
import io.reactivex.internal.operators.completable.CompletableDisposeOn;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableDoOnEvent;
import io.reactivex.internal.operators.completable.CompletableEmpty;
import io.reactivex.internal.operators.completable.CompletableError;
import io.reactivex.internal.operators.completable.CompletableErrorSupplier;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.internal.operators.completable.CompletableFromCallable;
import io.reactivex.internal.operators.completable.CompletableFromObservable;
import io.reactivex.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableFromUnsafeSource;
import io.reactivex.internal.operators.completable.CompletableHide;
import io.reactivex.internal.operators.completable.CompletableLift;
import io.reactivex.internal.operators.completable.CompletableMaterialize;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableNever;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.completable.CompletablePeek;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable;
import io.reactivex.internal.operators.completable.CompletableTimeout;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.completable.CompletableToObservable;
import io.reactivex.internal.operators.completable.CompletableToSingle;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.internal.operators.mixed.CompletableAndThenPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Completable implements CompletableSource {
    /* access modifiers changed from: protected */
    public abstract void subscribeActual(CompletableObserver completableObserver);

    public static Completable ambArray(CompletableSource... completableSourceArr) {
        ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return RxJavaPlugins.onAssembly((Completable) new CompletableAmb(completableSourceArr, null));
    }

    public static Completable amb(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableAmb(null, iterable));
    }

    public static Completable complete() {
        return RxJavaPlugins.onAssembly(CompletableEmpty.INSTANCE);
    }

    public static Completable concatArray(CompletableSource... completableSourceArr) {
        ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return RxJavaPlugins.onAssembly((Completable) new CompletableConcatArray(completableSourceArr));
    }

    public static Completable concat(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableConcatIterable(iterable));
    }

    public static Completable concat(Publisher<? extends CompletableSource> publisher) {
        return concat(publisher, 2);
    }

    public static Completable concat(Publisher<? extends CompletableSource> publisher, int i) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return RxJavaPlugins.onAssembly((Completable) new CompletableConcat(publisher, i));
    }

    public static Completable create(CompletableOnSubscribe completableOnSubscribe) {
        ObjectHelper.requireNonNull(completableOnSubscribe, "source is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableCreate(completableOnSubscribe));
    }

    public static Completable unsafeCreate(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "source is null");
        if (!(completableSource instanceof Completable)) {
            return RxJavaPlugins.onAssembly((Completable) new CompletableFromUnsafeSource(completableSource));
        }
        throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
    }

    public static Completable defer(Callable<? extends CompletableSource> callable) {
        ObjectHelper.requireNonNull(callable, "completableSupplier");
        return RxJavaPlugins.onAssembly((Completable) new CompletableDefer(callable));
    }

    public static Completable error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableErrorSupplier(callable));
    }

    public static Completable error(Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableError(th));
    }

    public static Completable fromAction(Action action) {
        ObjectHelper.requireNonNull(action, "run is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromAction(action));
    }

    public static Completable fromCallable(Callable<?> callable) {
        ObjectHelper.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromCallable(callable));
    }

    public static Completable fromFuture(Future<?> future) {
        ObjectHelper.requireNonNull(future, "future is null");
        return fromAction(Functions.futureAction(future));
    }

    public static <T> Completable fromMaybe(MaybeSource<T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "maybe is null");
        return RxJavaPlugins.onAssembly((Completable) new MaybeIgnoreElementCompletable(maybeSource));
    }

    public static Completable fromRunnable(Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "run is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromRunnable(runnable));
    }

    public static <T> Completable fromObservable(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "observable is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromObservable(observableSource));
    }

    public static <T> Completable fromPublisher(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromPublisher(publisher));
    }

    public static <T> Completable fromSingle(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "single is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromSingle(singleSource));
    }

    public static Completable mergeArray(CompletableSource... completableSourceArr) {
        ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return RxJavaPlugins.onAssembly((Completable) new CompletableMergeArray(completableSourceArr));
    }

    public static Completable merge(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableMergeIterable(iterable));
    }

    public static Completable merge(Publisher<? extends CompletableSource> publisher) {
        return merge0(publisher, Integer.MAX_VALUE, false);
    }

    public static Completable merge(Publisher<? extends CompletableSource> publisher, int i) {
        return merge0(publisher, i, false);
    }

    private static Completable merge0(Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return RxJavaPlugins.onAssembly((Completable) new CompletableMerge(publisher, i, z));
    }

    public static Completable mergeArrayDelayError(CompletableSource... completableSourceArr) {
        ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableMergeDelayErrorArray(completableSourceArr));
    }

    public static Completable mergeDelayError(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableMergeDelayErrorIterable(iterable));
    }

    public static Completable mergeDelayError(Publisher<? extends CompletableSource> publisher) {
        return merge0(publisher, Integer.MAX_VALUE, true);
    }

    public static Completable mergeDelayError(Publisher<? extends CompletableSource> publisher, int i) {
        return merge0(publisher, i, true);
    }

    public static Completable never() {
        return RxJavaPlugins.onAssembly(CompletableNever.INSTANCE);
    }

    public static Completable timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.computation());
    }

    public static Completable timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableTimer(j, timeUnit, scheduler));
    }

    private static NullPointerException toNpe(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static <R> Completable using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <R> Completable using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "completableFunction is null");
        ObjectHelper.requireNonNull(consumer, "disposer is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableUsing(callable, function, consumer, z));
    }

    public static Completable wrap(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "source is null");
        if (completableSource instanceof Completable) {
            return RxJavaPlugins.onAssembly((Completable) completableSource);
        }
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromUnsafeSource(completableSource));
    }

    public final Completable ambWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return ambArray(this, completableSource);
    }

    public final <T> Observable<T> andThen(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "next is null");
        return RxJavaPlugins.onAssembly((Observable<T>) new CompletableAndThenObservable<T>(this, observableSource));
    }

    public final <T> Flowable<T> andThen(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, "next is null");
        return RxJavaPlugins.onAssembly((Flowable<T>) new CompletableAndThenPublisher<T>(this, publisher));
    }

    public final <T> Single<T> andThen(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "next is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDelayWithCompletable<T>(singleSource, this));
    }

    public final <T> Maybe<T> andThen(MaybeSource<T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "next is null");
        return RxJavaPlugins.onAssembly((Maybe<T>) new MaybeDelayWithCompletable<T>(maybeSource, this));
    }

    public final Completable andThen(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "next is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableAndThenCompletable(this, completableSource));
    }

    public final <R> R as(CompletableConverter<? extends R> completableConverter) {
        return ((CompletableConverter) ObjectHelper.requireNonNull(completableConverter, "converter is null")).apply(this);
    }

    public final void blockingAwait() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe((CompletableObserver) blockingMultiObserver);
        blockingMultiObserver.blockingGet();
    }

    public final boolean blockingAwait(long j, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe((CompletableObserver) blockingMultiObserver);
        return blockingMultiObserver.blockingAwait(j, timeUnit);
    }

    public final Throwable blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe((CompletableObserver) blockingMultiObserver);
        return blockingMultiObserver.blockingGetError();
    }

    public final Throwable blockingGet(long j, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe((CompletableObserver) blockingMultiObserver);
        return blockingMultiObserver.blockingGetError(j, timeUnit);
    }

    public final Completable cache() {
        return RxJavaPlugins.onAssembly((Completable) new CompletableCache(this));
    }

    public final Completable compose(CompletableTransformer completableTransformer) {
        return wrap(((CompletableTransformer) ObjectHelper.requireNonNull(completableTransformer, "transformer is null")).apply(this));
    }

    public final Completable concatWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableAndThenCompletable(this, completableSource));
    }

    public final Completable delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation(), false);
    }

    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        CompletableDelay completableDelay = new CompletableDelay(this, j, timeUnit, scheduler, z);
        return RxJavaPlugins.onAssembly((Completable) completableDelay);
    }

    public final Completable delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.computation());
    }

    public final Completable delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timer(j, timeUnit, scheduler).andThen((CompletableSource) this);
    }

    public final Completable doOnComplete(Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action, action2, action2, action2);
    }

    public final Completable doOnDispose(Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action2, action2, action);
    }

    public final Completable doOnError(Consumer<? super Throwable> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, consumer, action, action, action, action);
    }

    public final Completable doOnEvent(Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onEvent is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableDoOnEvent(this, consumer));
    }

    private Completable doOnLifecycle(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(action2, "onTerminate is null");
        ObjectHelper.requireNonNull(action3, "onAfterTerminate is null");
        ObjectHelper.requireNonNull(action4, "onDispose is null");
        CompletablePeek completablePeek = new CompletablePeek(this, consumer, consumer2, action, action2, action3, action4);
        return RxJavaPlugins.onAssembly((Completable) completablePeek);
    }

    public final Completable doOnSubscribe(Consumer<? super Disposable> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnLifecycle(consumer, emptyConsumer, action, action, action, action);
    }

    public final Completable doOnTerminate(Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action, action2, action2);
    }

    public final Completable doAfterTerminate(Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action2, action, action2);
    }

    public final Completable doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableDoFinally(this, action));
    }

    public final Completable lift(CompletableOperator completableOperator) {
        ObjectHelper.requireNonNull(completableOperator, "onLift is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableLift(this, completableOperator));
    }

    public final <T> Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly((Single<T>) new CompletableMaterialize<T>(this));
    }

    public final Completable mergeWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return mergeArray(this, completableSource);
    }

    public final Completable observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableObserveOn(this, scheduler));
    }

    public final Completable onErrorComplete() {
        return onErrorComplete(Functions.alwaysTrue());
    }

    public final Completable onErrorComplete(Predicate<? super Throwable> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableOnErrorComplete(this, predicate));
    }

    public final Completable onErrorResumeNext(Function<? super Throwable, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, "errorMapper is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableResumeNext(this, function));
    }

    public final Completable onTerminateDetach() {
        return RxJavaPlugins.onAssembly((Completable) new CompletableDetach(this));
    }

    public final Completable repeat() {
        return fromPublisher(toFlowable().repeat());
    }

    public final Completable repeat(long j) {
        return fromPublisher(toFlowable().repeat(j));
    }

    public final Completable repeatUntil(BooleanSupplier booleanSupplier) {
        return fromPublisher(toFlowable().repeatUntil(booleanSupplier));
    }

    public final Completable repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return fromPublisher(toFlowable().repeatWhen(function));
    }

    public final Completable retry() {
        return fromPublisher(toFlowable().retry());
    }

    public final Completable retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return fromPublisher(toFlowable().retry(biPredicate));
    }

    public final Completable retry(long j) {
        return fromPublisher(toFlowable().retry(j));
    }

    public final Completable retry(long j, Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry(j, predicate));
    }

    public final Completable retry(Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry(predicate));
    }

    public final Completable retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return fromPublisher(toFlowable().retryWhen(function));
    }

    public final Completable startWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return concatArray(completableSource, this);
    }

    public final <T> Observable<T> startWith(Observable<T> observable) {
        ObjectHelper.requireNonNull(observable, "other is null");
        return observable.concatWith((ObservableSource<? extends T>) toObservable());
    }

    public final <T> Flowable<T> startWith(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return toFlowable().startWith(publisher);
    }

    public final Completable hide() {
        return RxJavaPlugins.onAssembly((Completable) new CompletableHide(this));
    }

    public final Disposable subscribe() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        subscribe((CompletableObserver) emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    public final void subscribe(CompletableObserver completableObserver) {
        ObjectHelper.requireNonNull(completableObserver, "observer is null");
        try {
            CompletableObserver onSubscribe = RxJavaPlugins.onSubscribe(this, completableObserver);
            ObjectHelper.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(onSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            throw toNpe(th);
        }
    }

    public final <E extends CompletableObserver> E subscribeWith(E e) {
        subscribe((CompletableObserver) e);
        return e;
    }

    public final Disposable subscribe(Action action, Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, action);
        subscribe((CompletableObserver) callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final Disposable subscribe(Action action) {
        ObjectHelper.requireNonNull(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(action);
        subscribe((CompletableObserver) callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final Completable subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableSubscribeOn(this, scheduler));
    }

    public final Completable takeUntil(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableTakeUntilCompletable(this, completableSource));
    }

    public final Completable timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, Schedulers.computation(), null);
    }

    public final Completable timeout(long j, TimeUnit timeUnit, CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return timeout0(j, timeUnit, Schedulers.computation(), completableSource);
    }

    public final Completable timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, scheduler, null);
    }

    public final Completable timeout(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return timeout0(j, timeUnit, scheduler, completableSource);
    }

    private Completable timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        CompletableTimeout completableTimeout = new CompletableTimeout(this, j, timeUnit, scheduler, completableSource);
        return RxJavaPlugins.onAssembly((Completable) completableTimeout);
    }

    public final <U> U to(Function<? super Completable, U> function) {
        try {
            return ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public final <T> Flowable<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).fuseToFlowable();
        }
        return RxJavaPlugins.onAssembly((Flowable<T>) new CompletableToFlowable<T>(this));
    }

    public final <T> Maybe<T> toMaybe() {
        if (this instanceof FuseToMaybe) {
            return ((FuseToMaybe) this).fuseToMaybe();
        }
        return RxJavaPlugins.onAssembly((Maybe<T>) new MaybeFromCompletable<T>(this));
    }

    public final <T> Observable<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).fuseToObservable();
        }
        return RxJavaPlugins.onAssembly((Observable<T>) new CompletableToObservable<T>(this));
    }

    public final <T> Single<T> toSingle(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, "completionValueSupplier is null");
        return RxJavaPlugins.onAssembly((Single<T>) new CompletableToSingle<T>(this, callable, null));
    }

    public final <T> Single<T> toSingleDefault(T t) {
        ObjectHelper.requireNonNull(t, "completionValue is null");
        return RxJavaPlugins.onAssembly((Single<T>) new CompletableToSingle<T>(this, null, t));
    }

    public final Completable unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Completable) new CompletableDisposeOn(this, scheduler));
    }

    public final TestObserver<Void> test() {
        TestObserver<Void> testObserver = new TestObserver<>();
        subscribe((CompletableObserver) testObserver);
        return testObserver;
    }

    public final TestObserver<Void> test(boolean z) {
        TestObserver<Void> testObserver = new TestObserver<>();
        if (z) {
            testObserver.cancel();
        }
        subscribe((CompletableObserver) testObserver);
        return testObserver;
    }
}
