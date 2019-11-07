package org.jetbrains.anko.custom;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoAsyncContext;
import org.jetbrains.anko.AsyncKt;
import org.jetbrains.anko.AsyncKt$runOnUiThread$2;
import org.jetbrains.anko.BackgroundExecutor;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

public final class DeprecatedKt {
    public static final void onUiThread(@NotNull Context context, @NotNull Function1<? super Context, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        AsyncKt.runOnUiThread(context, function1);
    }

    @NotNull
    public static final <T> Future<Unit> async(T t, @NotNull Function1<? super AnkoAsyncContext<T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "task");
        return BackgroundExecutor.INSTANCE.submit(new DeprecatedKt$async$1(function1, new AnkoAsyncContext(new WeakReference(t))));
    }

    @NotNull
    public static final <T> Future<Unit> async(T t, @NotNull ExecutorService executorService, @NotNull Function1<? super AnkoAsyncContext<T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(executorService, "executorService");
        Intrinsics.checkParameterIsNotNull(function1, "task");
        Future<Unit> submit = executorService.submit(new DeprecatedKt$async$2(function1, new AnkoAsyncContext(new WeakReference(t))));
        Intrinsics.checkExpressionValueIsNotNull(submit, "executorService.submit<Unit> { context.task() }");
        return submit;
    }

    @NotNull
    public static final <T, R> Future<R> asyncResult(T t, @NotNull Function1<? super AnkoAsyncContext<T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "task");
        return BackgroundExecutor.INSTANCE.submit(new DeprecatedKt$asyncResult$1(function1, new AnkoAsyncContext(new WeakReference(t))));
    }

    @NotNull
    public static final <T, R> Future<R> asyncResult(T t, @NotNull ExecutorService executorService, @NotNull Function1<? super AnkoAsyncContext<T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(executorService, "executorService");
        Intrinsics.checkParameterIsNotNull(function1, "task");
        Future<R> submit = executorService.submit(new DeprecatedKt$asyncResult$2(function1, new AnkoAsyncContext(new WeakReference(t))));
        Intrinsics.checkExpressionValueIsNotNull(submit, "executorService.submit<R> { context.task() }");
        return submit;
    }

    public static final <T> void forEachReversed(@NotNull T[] tArr, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        for (int length = tArr.length - 1; length >= 0; length--) {
            function1.invoke(tArr[length]);
        }
    }

    public static final <T> void forEachReversed(@NotNull List<? extends T> list, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        for (int size = list.size() - 1; size >= 0; size--) {
            function1.invoke(list.get(size));
        }
    }

    public static final void onUiThread(@NotNull Fragment fragment, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Activity activity = fragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new AsyncKt$runOnUiThread$2(function0));
        }
    }

    @NotNull
    public static final <T extends View> T style(@NotNull T t, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "style");
        AnkoInternals.INSTANCE.applyRecursively(t, function1);
        return t;
    }
}
