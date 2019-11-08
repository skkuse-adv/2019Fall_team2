package io.reactivex.rxkotlin;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SubscribersKt {
    private static final Function0<Unit> onCompleteStub = SubscribersKt$onCompleteStub$1.INSTANCE;
    private static final Function1<Throwable, Unit> onErrorStub = SubscribersKt$onErrorStub$1.INSTANCE;
    private static final Function1<Object, Unit> onNextStub = SubscribersKt$onNextStub$1.INSTANCE;

    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> io.reactivex.functions.Consumer<T> asConsumer(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r1) {
        /*
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r0 = onNextStub
            if (r1 != r0) goto L_0x000e
            io.reactivex.functions.Consumer r1 = io.reactivex.internal.functions.Functions.emptyConsumer()
            java.lang.String r0 = "Functions.emptyConsumer()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r0)
            goto L_0x0018
        L_0x000e:
            if (r1 == 0) goto L_0x0016
            io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Consumer$0 r0 = new io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Consumer$0
            r0.<init>(r1)
            r1 = r0
        L_0x0016:
            io.reactivex.functions.Consumer r1 = (io.reactivex.functions.Consumer) r1
        L_0x0018:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.asConsumer(kotlin.jvm.functions.Function1):io.reactivex.functions.Consumer");
    }

    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final io.reactivex.functions.Consumer<java.lang.Throwable> asOnErrorConsumer(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r1) {
        /*
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r0 = onErrorStub
            if (r1 != r0) goto L_0x000c
            io.reactivex.functions.Consumer<java.lang.Throwable> r1 = io.reactivex.internal.functions.Functions.ON_ERROR_MISSING
            java.lang.String r0 = "Functions.ON_ERROR_MISSING"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r0)
            goto L_0x0016
        L_0x000c:
            if (r1 == 0) goto L_0x0014
            io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Consumer$0 r0 = new io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Consumer$0
            r0.<init>(r1)
            r1 = r0
        L_0x0014:
            io.reactivex.functions.Consumer r1 = (io.reactivex.functions.Consumer) r1
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.asOnErrorConsumer(kotlin.jvm.functions.Function1):io.reactivex.functions.Consumer");
    }

    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Action$0] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final io.reactivex.functions.Action asOnCompleteAction(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r1) {
        /*
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = onCompleteStub
            if (r1 != r0) goto L_0x000c
            io.reactivex.functions.Action r1 = io.reactivex.internal.functions.Functions.EMPTY_ACTION
            java.lang.String r0 = "Functions.EMPTY_ACTION"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r0)
            goto L_0x0016
        L_0x000c:
            if (r1 == 0) goto L_0x0014
            io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Action$0 r0 = new io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Action$0
            r0.<init>(r1)
            r1 = r0
        L_0x0014:
            io.reactivex.functions.Action r1 = (io.reactivex.functions.Action) r1
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.asOnCompleteAction(kotlin.jvm.functions.Function0):io.reactivex.functions.Action");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function0, code=kotlin.jvm.functions.Function0<kotlin.Unit>, for r2v0, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>, for r3v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ io.reactivex.disposables.Disposable subscribeBy$default(io.reactivex.Observable r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, kotlin.jvm.functions.Function0<kotlin.Unit> r2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3, int r4, java.lang.Object r5) {
        /*
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = onErrorStub
        L_0x0006:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000c
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = onCompleteStub
        L_0x000c:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0012
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3 = onNextStub
        L_0x0012:
            io.reactivex.disposables.Disposable r0 = subscribeBy(r0, r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.subscribeBy$default(io.reactivex.Observable, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, java.lang.Object):io.reactivex.disposables.Disposable");
    }

    @NotNull
    public static final <T> Disposable subscribeBy(@NotNull Observable<T> observable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        Disposable subscribe = observable.subscribe(asConsumer(function12), asOnErrorConsumer(function1), asOnCompleteAction(function0));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return subscribe;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function0, code=kotlin.jvm.functions.Function0<kotlin.Unit>, for r2v0, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>, for r3v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ io.reactivex.disposables.Disposable subscribeBy$default(io.reactivex.Flowable r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, kotlin.jvm.functions.Function0<kotlin.Unit> r2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3, int r4, java.lang.Object r5) {
        /*
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = onErrorStub
        L_0x0006:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000c
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = onCompleteStub
        L_0x000c:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0012
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3 = onNextStub
        L_0x0012:
            io.reactivex.disposables.Disposable r0 = subscribeBy(r0, r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.subscribeBy$default(io.reactivex.Flowable, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, java.lang.Object):io.reactivex.disposables.Disposable");
    }

    @NotNull
    public static final <T> Disposable subscribeBy(@NotNull Flowable<T> flowable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        Disposable subscribe = flowable.subscribe(asConsumer(function12), asOnErrorConsumer(function1), asOnCompleteAction(function0));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return subscribe;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>, for r2v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ io.reactivex.disposables.Disposable subscribeBy$default(io.reactivex.Single r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = onErrorStub
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r2 = onNextStub
        L_0x000c:
            io.reactivex.disposables.Disposable r0 = subscribeBy(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.subscribeBy$default(io.reactivex.Single, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, java.lang.Object):io.reactivex.disposables.Disposable");
    }

    @NotNull
    public static final <T> Disposable subscribeBy(@NotNull Single<T> single, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(single, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function12, "onSuccess");
        Disposable subscribe = single.subscribe(asConsumer(function12), asOnErrorConsumer(function1));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onSuccess.asCo…rror.asOnErrorConsumer())");
        return subscribe;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function0, code=kotlin.jvm.functions.Function0<kotlin.Unit>, for r2v0, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>, for r3v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ io.reactivex.disposables.Disposable subscribeBy$default(io.reactivex.Maybe r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, kotlin.jvm.functions.Function0<kotlin.Unit> r2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3, int r4, java.lang.Object r5) {
        /*
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = onErrorStub
        L_0x0006:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000c
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = onCompleteStub
        L_0x000c:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0012
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3 = onNextStub
        L_0x0012:
            io.reactivex.disposables.Disposable r0 = subscribeBy(r0, r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.subscribeBy$default(io.reactivex.Maybe, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, java.lang.Object):io.reactivex.disposables.Disposable");
    }

    @NotNull
    public static final <T> Disposable subscribeBy(@NotNull Maybe<T> maybe, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(maybe, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onSuccess");
        Disposable subscribe = maybe.subscribe(asConsumer(function12), asOnErrorConsumer(function1), asOnCompleteAction(function0));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onSuccess.asCo…ete.asOnCompleteAction())");
        return subscribe;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function0, code=kotlin.jvm.functions.Function0<kotlin.Unit>, for r2v0, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ io.reactivex.disposables.Disposable subscribeBy$default(io.reactivex.Completable r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, kotlin.jvm.functions.Function0<kotlin.Unit> r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = onErrorStub
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = onCompleteStub
        L_0x000c:
            io.reactivex.disposables.Disposable r0 = subscribeBy(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.subscribeBy$default(io.reactivex.Completable, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, int, java.lang.Object):io.reactivex.disposables.Disposable");
    }

    @NotNull
    public static final Disposable subscribeBy(@NotNull Completable completable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(completable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        if (function1 == onErrorStub && function0 == onCompleteStub) {
            Disposable subscribe = completable.subscribe();
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe()");
            return subscribe;
        } else if (function1 == onErrorStub) {
            Disposable subscribe2 = completable.subscribe((Action) new SubscribersKt$sam$io_reactivex_functions_Action$0(function0));
            Intrinsics.checkExpressionValueIsNotNull(subscribe2, "subscribe(onComplete)");
            return subscribe2;
        } else {
            Disposable subscribe3 = completable.subscribe(asOnCompleteAction(function0), new SubscribersKt$sam$io_reactivex_functions_Consumer$0(function1));
            Intrinsics.checkExpressionValueIsNotNull(subscribe3, "subscribe(onComplete.asO…ion(), Consumer(onError))");
            return subscribe3;
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function0, code=kotlin.jvm.functions.Function0<kotlin.Unit>, for r2v0, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>, for r3v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ void blockingSubscribeBy$default(io.reactivex.Observable r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, kotlin.jvm.functions.Function0<kotlin.Unit> r2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3, int r4, java.lang.Object r5) {
        /*
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = onErrorStub
        L_0x0006:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000c
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = onCompleteStub
        L_0x000c:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0012
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3 = onNextStub
        L_0x0012:
            blockingSubscribeBy(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.blockingSubscribeBy$default(io.reactivex.Observable, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, java.lang.Object):void");
    }

    public static final <T> void blockingSubscribeBy(@NotNull Observable<T> observable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        observable.blockingSubscribe(asConsumer(function12), asOnErrorConsumer(function1), asOnCompleteAction(function0));
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function0, code=kotlin.jvm.functions.Function0<kotlin.Unit>, for r2v0, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>, for r3v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ void blockingSubscribeBy$default(io.reactivex.Flowable r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, kotlin.jvm.functions.Function0<kotlin.Unit> r2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3, int r4, java.lang.Object r5) {
        /*
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = onErrorStub
        L_0x0006:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000c
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = onCompleteStub
        L_0x000c:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0012
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3 = onNextStub
        L_0x0012:
            blockingSubscribeBy(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.blockingSubscribeBy$default(io.reactivex.Flowable, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, java.lang.Object):void");
    }

    public static final <T> void blockingSubscribeBy(@NotNull Flowable<T> flowable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        flowable.blockingSubscribe(asConsumer(function12), asOnErrorConsumer(function1), asOnCompleteAction(function0));
    }
}
