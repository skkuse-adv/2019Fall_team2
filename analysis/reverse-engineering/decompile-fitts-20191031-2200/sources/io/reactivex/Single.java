package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.observers.FutureSingleObserver;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.maybe.MaybeFilterSingle;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.single.SingleAmb;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleContains;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDefer;
import io.reactivex.internal.operators.single.SingleDelay;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.internal.operators.single.SingleDematerialize;
import io.reactivex.internal.operators.single.SingleDetach;
import io.reactivex.internal.operators.single.SingleDoAfterSuccess;
import io.reactivex.internal.operators.single.SingleDoAfterTerminate;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleDoOnEvent;
import io.reactivex.internal.operators.single.SingleDoOnSubscribe;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleDoOnTerminate;
import io.reactivex.internal.operators.single.SingleEquals;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleFlatMapPublisher;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleFromPublisher;
import io.reactivex.internal.operators.single.SingleFromUnsafeSource;
import io.reactivex.internal.operators.single.SingleHide;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleLift;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleMaterialize;
import io.reactivex.internal.operators.single.SingleNever;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.SingleZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Single<T> implements SingleSource<T> {
    /* access modifiers changed from: protected */
    public abstract void subscribeActual(SingleObserver<? super T> singleObserver);

    public static <T> Single<T> amb(Iterable<? extends SingleSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleAmb<T>(null, iterable));
    }

    public static <T> Single<T> ambArray(SingleSource<? extends T>... singleSourceArr) {
        if (singleSourceArr.length == 0) {
            return error(SingleInternalHelper.emptyThrower());
        }
        if (singleSourceArr.length == 1) {
            return wrap(singleSourceArr[0]);
        }
        return RxJavaPlugins.onAssembly((Single<T>) new SingleAmb<T>(singleSourceArr, null));
    }

    public static <T> Flowable<T> concat(Iterable<? extends SingleSource<? extends T>> iterable) {
        return concat((Publisher<? extends SingleSource<? extends T>>) Flowable.fromIterable(iterable));
    }

    public static <T> Observable<T> concat(ObservableSource<? extends SingleSource<? extends T>> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return RxJavaPlugins.onAssembly((Observable<T>) new ObservableConcatMap<T>(observableSource, SingleInternalHelper.toObservable(), 2, ErrorMode.IMMEDIATE));
    }

    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> publisher) {
        return concat(publisher, 2);
    }

    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> publisher, int i) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return RxJavaPlugins.onAssembly((Flowable<T>) new FlowableConcatMapPublisher<T>(publisher, SingleInternalHelper.toFlowable(), i, ErrorMode.IMMEDIATE));
    }

    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return concat((Publisher<? extends SingleSource<? extends T>>) Flowable.fromArray(singleSource, singleSource2));
    }

    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return concat((Publisher<? extends SingleSource<? extends T>>) Flowable.fromArray(singleSource, singleSource2, singleSource3));
    }

    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return concat((Publisher<? extends SingleSource<? extends T>>) Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    public static <T> Flowable<T> concatArray(SingleSource<? extends T>... singleSourceArr) {
        return RxJavaPlugins.onAssembly((Flowable<T>) new FlowableConcatMap<T>(Flowable.fromArray(singleSourceArr), SingleInternalHelper.toFlowable(), 2, ErrorMode.BOUNDARY));
    }

    public static <T> Flowable<T> concatArrayEager(SingleSource<? extends T>... singleSourceArr) {
        return Flowable.fromArray(singleSourceArr).concatMapEager(SingleInternalHelper.toFlowable());
    }

    public static <T> Flowable<T> concatEager(Publisher<? extends SingleSource<? extends T>> publisher) {
        return Flowable.fromPublisher(publisher).concatMapEager(SingleInternalHelper.toFlowable());
    }

    public static <T> Flowable<T> concatEager(Iterable<? extends SingleSource<? extends T>> iterable) {
        return Flowable.fromIterable(iterable).concatMapEager(SingleInternalHelper.toFlowable());
    }

    public static <T> Single<T> create(SingleOnSubscribe<T> singleOnSubscribe) {
        ObjectHelper.requireNonNull(singleOnSubscribe, "source is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleCreate<T>(singleOnSubscribe));
    }

    public static <T> Single<T> defer(Callable<? extends SingleSource<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, "singleSupplier is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDefer<T>(callable));
    }

    public static <T> Single<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleError<T>(callable));
    }

    public static <T> Single<T> error(Throwable th) {
        ObjectHelper.requireNonNull(th, "exception is null");
        return error(Functions.justCallable(th));
    }

    public static <T> Single<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleFromCallable<T>(callable));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future) {
        return toSingle(Flowable.fromFuture(future));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return toSingle(Flowable.fromFuture(future, j, timeUnit));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return toSingle(Flowable.fromFuture(future, j, timeUnit, scheduler));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        return toSingle(Flowable.fromFuture(future, scheduler));
    }

    public static <T> Single<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleFromPublisher<T>(publisher));
    }

    public static <T> Single<T> fromObservable(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "observableSource is null");
        return RxJavaPlugins.onAssembly((Single<T>) new ObservableSingleSingle<T>(observableSource, null));
    }

    public static <T> Single<T> just(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleJust<T>(t));
    }

    public static <T> Flowable<T> merge(Iterable<? extends SingleSource<? extends T>> iterable) {
        return merge((Publisher<? extends SingleSource<? extends T>>) Flowable.fromIterable(iterable));
    }

    public static <T> Flowable<T> merge(Publisher<? extends SingleSource<? extends T>> publisher) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        FlowableFlatMapPublisher flowableFlatMapPublisher = new FlowableFlatMapPublisher(publisher, SingleInternalHelper.toFlowable(), false, Integer.MAX_VALUE, Flowable.bufferSize());
        return RxJavaPlugins.onAssembly((Flowable<T>) flowableFlatMapPublisher);
    }

    public static <T> Single<T> merge(SingleSource<? extends SingleSource<? extends T>> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "source is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleFlatMap<T>(singleSource, Functions.identity()));
    }

    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return merge((Publisher<? extends SingleSource<? extends T>>) Flowable.fromArray(singleSource, singleSource2));
    }

    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return merge((Publisher<? extends SingleSource<? extends T>>) Flowable.fromArray(singleSource, singleSource2, singleSource3));
    }

    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return merge((Publisher<? extends SingleSource<? extends T>>) Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends SingleSource<? extends T>> iterable) {
        return mergeDelayError((Publisher<? extends SingleSource<? extends T>>) Flowable.fromIterable(iterable));
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends SingleSource<? extends T>> publisher) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        FlowableFlatMapPublisher flowableFlatMapPublisher = new FlowableFlatMapPublisher(publisher, SingleInternalHelper.toFlowable(), true, Integer.MAX_VALUE, Flowable.bufferSize());
        return RxJavaPlugins.onAssembly((Flowable<T>) flowableFlatMapPublisher);
    }

    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return mergeDelayError((Publisher<? extends SingleSource<? extends T>>) Flowable.fromArray(singleSource, singleSource2));
    }

    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return mergeDelayError((Publisher<? extends SingleSource<? extends T>>) Flowable.fromArray(singleSource, singleSource2, singleSource3));
    }

    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return mergeDelayError((Publisher<? extends SingleSource<? extends T>>) Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    public static <T> Single<T> never() {
        return RxJavaPlugins.onAssembly(SingleNever.INSTANCE);
    }

    public static Single<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.computation());
    }

    public static Single<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleTimer<T>(j, timeUnit, scheduler));
    }

    public static <T> Single<Boolean> equals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, "first is null");
        ObjectHelper.requireNonNull(singleSource2, "second is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleEquals<T>(singleSource, singleSource2));
    }

    public static <T> Single<T> unsafeCreate(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "onSubscribe is null");
        if (!(singleSource instanceof Single)) {
            return RxJavaPlugins.onAssembly((Single<T>) new SingleFromUnsafeSource<T>(singleSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
    }

    public static <T, U> Single<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T, U> Single<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "singleFunction is null");
        ObjectHelper.requireNonNull(consumer, "disposer is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleUsing<T>(callable, function, consumer, z));
    }

    public static <T> Single<T> wrap(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "source is null");
        if (singleSource instanceof Single) {
            return RxJavaPlugins.onAssembly((Single) singleSource);
        }
        return RxJavaPlugins.onAssembly((Single<T>) new SingleFromUnsafeSource<T>(singleSource));
    }

    public static <T, R> Single<R> zip(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleZipIterable<T>(iterable, function));
    }

    public static <T1, T2, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), singleSource, singleSource2);
    }

    public static <T1, T2, T3, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return zipArray(Functions.toFunction(function3), singleSource, singleSource2, singleSource3);
    }

    public static <T1, T2, T3, T4, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return zipArray(Functions.toFunction(function4), singleSource, singleSource2, singleSource3, singleSource4);
    }

    public static <T1, T2, T3, T4, T5, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        return zipArray(Functions.toFunction(function5), singleSource, singleSource2, singleSource3, singleSource4, singleSource5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        return zipArray(Functions.toFunction(function6), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        ObjectHelper.requireNonNull(singleSource7, "source7 is null");
        return zipArray(Functions.toFunction(function7), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        ObjectHelper.requireNonNull(singleSource7, "source7 is null");
        ObjectHelper.requireNonNull(singleSource8, "source8 is null");
        return zipArray(Functions.toFunction(function8), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, SingleSource<? extends T9> singleSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(singleSource, "source1 is null");
        ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        ObjectHelper.requireNonNull(singleSource7, "source7 is null");
        ObjectHelper.requireNonNull(singleSource8, "source8 is null");
        ObjectHelper.requireNonNull(singleSource9, "source9 is null");
        return zipArray(Functions.toFunction(function9), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9);
    }

    public static <T, R> Single<R> zipArray(Function<? super Object[], ? extends R> function, SingleSource<? extends T>... singleSourceArr) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(singleSourceArr, "sources is null");
        if (singleSourceArr.length == 0) {
            return error((Throwable) new NoSuchElementException());
        }
        return RxJavaPlugins.onAssembly((Single<T>) new SingleZipArray<T>(singleSourceArr, function));
    }

    public final Single<T> ambWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return ambArray(this, singleSource);
    }

    public final <R> R as(SingleConverter<T, ? extends R> singleConverter) {
        return ((SingleConverter) ObjectHelper.requireNonNull(singleConverter, "converter is null")).apply(this);
    }

    public final Single<T> hide() {
        return RxJavaPlugins.onAssembly((Single<T>) new SingleHide<T>(this));
    }

    public final <R> Single<R> compose(SingleTransformer<? super T, ? extends R> singleTransformer) {
        return wrap(((SingleTransformer) ObjectHelper.requireNonNull(singleTransformer, "transformer is null")).apply(this));
    }

    public final Single<T> cache() {
        return RxJavaPlugins.onAssembly((Single<T>) new SingleCache<T>(this));
    }

    public final <U> Single<U> cast(Class<? extends U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return map(Functions.castFunction(cls));
    }

    public final Flowable<T> concatWith(SingleSource<? extends T> singleSource) {
        return concat((SingleSource<? extends T>) this, singleSource);
    }

    public final Single<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation(), false);
    }

    public final Single<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, Schedulers.computation(), z);
    }

    public final Single<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    public final Single<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        SingleDelay singleDelay = new SingleDelay(this, j, timeUnit, scheduler, z);
        return RxJavaPlugins.onAssembly((Single<T>) singleDelay);
    }

    public final Single<T> delaySubscription(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDelayWithCompletable<T>(this, completableSource));
    }

    public final <U> Single<T> delaySubscription(SingleSource<U> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDelayWithSingle<T>(this, singleSource));
    }

    public final <U> Single<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDelayWithObservable<T>(this, observableSource));
    }

    public final <U> Single<T> delaySubscription(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDelayWithPublisher<T>(this, publisher));
    }

    public final Single<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.computation());
    }

    public final Single<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription((ObservableSource<U>) Observable.timer(j, timeUnit, scheduler));
    }

    public final <R> Maybe<R> dematerialize(Function<? super T, Notification<R>> function) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return RxJavaPlugins.onAssembly((Maybe<T>) new SingleDematerialize<T>(this, function));
    }

    public final Single<T> doAfterSuccess(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onAfterSuccess is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDoAfterSuccess<T>(this, consumer));
    }

    public final Single<T> doAfterTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDoAfterTerminate<T>(this, action));
    }

    public final Single<T> doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDoFinally<T>(this, action));
    }

    public final Single<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDoOnSubscribe<T>(this, consumer));
    }

    public final Single<T> doOnTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onTerminate is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDoOnTerminate<T>(this, action));
    }

    public final Single<T> doOnSuccess(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDoOnSuccess<T>(this, consumer));
    }

    public final Single<T> doOnEvent(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "onEvent is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDoOnEvent<T>(this, biConsumer));
    }

    public final Single<T> doOnError(Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onError is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDoOnError<T>(this, consumer));
    }

    public final Single<T> doOnDispose(Action action) {
        ObjectHelper.requireNonNull(action, "onDispose is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDoOnDispose<T>(this, action));
    }

    public final Maybe<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly((Maybe<T>) new MaybeFilterSingle<T>(this, predicate));
    }

    public final <R> Single<R> flatMap(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleFlatMap<T>(this, function));
    }

    public final <R> Maybe<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Maybe<T>) new SingleFlatMapMaybe<T>(this, function));
    }

    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Flowable<T>) new SingleFlatMapPublisher<T>(this, function));
    }

    public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Flowable<T>) new SingleFlatMapIterableFlowable<T>(this, function));
    }

    public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Observable<T>) new SingleFlatMapIterableObservable<T>(this, function));
    }

    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Observable<T>) new SingleFlatMapObservable<T>(this, function));
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Completable) new SingleFlatMapCompletable(this, function));
    }

    public final T blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe((SingleObserver<? super T>) blockingMultiObserver);
        return blockingMultiObserver.blockingGet();
    }

    public final <R> Single<R> lift(SingleOperator<? extends R, ? super T> singleOperator) {
        ObjectHelper.requireNonNull(singleOperator, "lift is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleLift<T>(this, singleOperator));
    }

    public final <R> Single<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleMap<T>(this, function));
    }

    public final Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly((Single<T>) new SingleMaterialize<T>(this));
    }

    public final Single<Boolean> contains(Object obj) {
        return contains(obj, ObjectHelper.equalsPredicate());
    }

    public final Single<Boolean> contains(Object obj, BiPredicate<Object, Object> biPredicate) {
        ObjectHelper.requireNonNull(obj, "value is null");
        ObjectHelper.requireNonNull(biPredicate, "comparer is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleContains<T>(this, obj, biPredicate));
    }

    public final Flowable<T> mergeWith(SingleSource<? extends T> singleSource) {
        return merge(this, singleSource);
    }

    public final Single<T> observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleObserveOn<T>(this, scheduler));
    }

    public final Single<T> onErrorReturn(Function<Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleOnErrorReturn<T>(this, function, null));
    }

    public final Single<T> onErrorReturnItem(T t) {
        ObjectHelper.requireNonNull(t, "value is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleOnErrorReturn<T>(this, null, t));
    }

    public final Single<T> onErrorResumeNext(Single<? extends T> single) {
        ObjectHelper.requireNonNull(single, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(Functions.justFunction(single));
    }

    public final Single<T> onErrorResumeNext(Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, "resumeFunctionInCaseOfError is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleResumeNext<T>(this, function));
    }

    public final Single<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly((Single<T>) new SingleDetach<T>(this));
    }

    public final Flowable<T> repeat() {
        return toFlowable().repeat();
    }

    public final Flowable<T> repeat(long j) {
        return toFlowable().repeat(j);
    }

    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return toFlowable().repeatWhen(function);
    }

    public final Flowable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        return toFlowable().repeatUntil(booleanSupplier);
    }

    public final Single<T> retry() {
        return toSingle(toFlowable().retry());
    }

    public final Single<T> retry(long j) {
        return toSingle(toFlowable().retry(j));
    }

    public final Single<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return toSingle(toFlowable().retry(biPredicate));
    }

    public final Single<T> retry(long j, Predicate<? super Throwable> predicate) {
        return toSingle(toFlowable().retry(j, predicate));
    }

    public final Single<T> retry(Predicate<? super Throwable> predicate) {
        return toSingle(toFlowable().retry(predicate));
    }

    public final Single<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return toSingle(toFlowable().retryWhen(function));
    }

    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING);
    }

    public final Disposable subscribe(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "onCallback is null");
        BiConsumerSingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(biConsumer);
        subscribe((SingleObserver<? super T>) biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.ON_ERROR_MISSING);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(consumer, consumer2);
        subscribe((SingleObserver<? super T>) consumerSingleObserver);
        return consumerSingleObserver;
    }

    public final void subscribe(SingleObserver<? super T> singleObserver) {
        ObjectHelper.requireNonNull(singleObserver, "observer is null");
        SingleObserver onSubscribe = RxJavaPlugins.onSubscribe(this, singleObserver);
        ObjectHelper.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(onSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final <E extends SingleObserver<? super T>> E subscribeWith(E e) {
        subscribe((SingleObserver<? super T>) e);
        return e;
    }

    public final Single<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleSubscribeOn<T>(this, scheduler));
    }

    public final Single<T> takeUntil(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return takeUntil((Publisher<E>) new CompletableToFlowable<E>(completableSource));
    }

    public final <E> Single<T> takeUntil(Publisher<E> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleTakeUntil<T>(this, publisher));
    }

    public final <E> Single<T> takeUntil(SingleSource<? extends E> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return takeUntil((Publisher<E>) new SingleToFlowable<E>(singleSource));
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, Schedulers.computation(), null);
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, scheduler, null);
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return timeout0(j, timeUnit, scheduler, singleSource);
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit, SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return timeout0(j, timeUnit, Schedulers.computation(), singleSource);
    }

    private Single<T> timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        SingleTimeout singleTimeout = new SingleTimeout(this, j, timeUnit, scheduler, singleSource);
        return RxJavaPlugins.onAssembly((Single<T>) singleTimeout);
    }

    public final <R> R to(Function<? super Single<T>, R> function) {
        try {
            return ((Function) ObjectHelper.requireNonNull(function, "convert is null")).apply(this);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Deprecated
    public final Completable toCompletable() {
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromSingle(this));
    }

    public final Completable ignoreElement() {
        return RxJavaPlugins.onAssembly((Completable) new CompletableFromSingle(this));
    }

    public final Flowable<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).fuseToFlowable();
        }
        return RxJavaPlugins.onAssembly((Flowable<T>) new SingleToFlowable<T>(this));
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureSingleObserver());
    }

    public final Maybe<T> toMaybe() {
        if (this instanceof FuseToMaybe) {
            return ((FuseToMaybe) this).fuseToMaybe();
        }
        return RxJavaPlugins.onAssembly((Maybe<T>) new MaybeFromSingle<T>(this));
    }

    public final Observable<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).fuseToObservable();
        }
        return RxJavaPlugins.onAssembly((Observable<T>) new SingleToObservable<T>(this));
    }

    public final Single<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly((Single<T>) new SingleUnsubscribeOn<T>(this, scheduler));
    }

    public final <U, R> Single<R> zipWith(SingleSource<U> singleSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return zip(this, singleSource, biFunction);
    }

    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe((SingleObserver<? super T>) testObserver);
        return testObserver;
    }

    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.cancel();
        }
        subscribe((SingleObserver<? super T>) testObserver);
        return testObserver;
    }

    private static <T> Single<T> toSingle(Flowable<T> flowable) {
        return RxJavaPlugins.onAssembly((Single<T>) new FlowableSingleSingle<T>(flowable, null));
    }
}
