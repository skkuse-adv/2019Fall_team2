package io.reactivex.rxkotlin;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DisposableKt {
    public static final void plusAssign(@NotNull CompositeDisposable compositeDisposable, @NotNull Disposable disposable) {
        Intrinsics.checkParameterIsNotNull(compositeDisposable, "$receiver");
        Intrinsics.checkParameterIsNotNull(disposable, "disposable");
        compositeDisposable.add(disposable);
    }

    @NotNull
    public static final Disposable addTo(@NotNull Disposable disposable, @NotNull CompositeDisposable compositeDisposable) {
        Intrinsics.checkParameterIsNotNull(disposable, "$receiver");
        Intrinsics.checkParameterIsNotNull(compositeDisposable, "compositeDisposable");
        compositeDisposable.add(disposable);
        return disposable;
    }
}
