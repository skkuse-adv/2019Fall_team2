package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AsyncKt {
    private static final Function1<Throwable, Unit> crashLogger = AsyncKt$crashLogger$1.INSTANCE;

    public static final void runOnUiThread(@NotNull Context context, @NotNull Function1<? super Context, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            function1.invoke(context);
        } else {
            ContextHelper.INSTANCE.getHandler().post(new AsyncKt$runOnUiThread$1(context, function1));
        }
    }

    public static final void runOnUiThread(@NotNull Fragment fragment, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Activity activity = fragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new AsyncKt$runOnUiThread$2(function0));
        }
    }

    public static final <T> void onComplete(@NotNull AnkoAsyncContext<T> ankoAsyncContext, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Object obj = ankoAsyncContext.getWeakRef().get();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            function1.invoke(obj);
        } else {
            ContextHelper.INSTANCE.getHandler().post(new AsyncKt$onComplete$1(function1, obj));
        }
    }

    public static final <T> boolean uiThread(@NotNull AnkoAsyncContext<T> ankoAsyncContext, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Object obj = ankoAsyncContext.getWeakRef().get();
        if (obj == null) {
            return false;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            function1.invoke(obj);
        } else {
            ContextHelper.INSTANCE.getHandler().post(new AsyncKt$uiThread$1(function1, obj));
        }
        return true;
    }

    public static final <T extends Activity> boolean activityUiThread(@NotNull AnkoAsyncContext<T> ankoAsyncContext, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Activity activity = (Activity) ankoAsyncContext.getWeakRef().get();
        if (activity == null) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "weakRef.get() ?: return false");
        if (activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new AsyncKt$activityUiThread$1(function1, activity));
        return true;
    }

    public static final <T extends Activity> boolean activityUiThreadWithContext(@NotNull AnkoAsyncContext<T> ankoAsyncContext, @NotNull Function2<? super Context, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        Activity activity = (Activity) ankoAsyncContext.getWeakRef().get();
        if (activity == null) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "weakRef.get() ?: return false");
        if (activity.isFinishing()) {
            return false;
        }
        activity.runOnUiThread(new AsyncKt$activityUiThreadWithContext$1(function2, activity));
        return true;
    }

    public static final <T extends Activity> boolean activityContextUiThread(@NotNull AnkoAsyncContext<AnkoContext<T>> ankoAsyncContext, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        AnkoContext ankoContext = (AnkoContext) ankoAsyncContext.getWeakRef().get();
        if (ankoContext != null) {
            Activity activity = (Activity) ankoContext.getOwner();
            if (activity == null || activity.isFinishing()) {
                return false;
            }
            activity.runOnUiThread(new AsyncKt$activityUiThread$2(function1, activity));
            return true;
        }
        return false;
    }

    public static final <T extends Activity> boolean activityContextUiThreadWithContext(@NotNull AnkoAsyncContext<AnkoContext<T>> ankoAsyncContext, @NotNull Function2<? super Context, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        AnkoContext ankoContext = (AnkoContext) ankoAsyncContext.getWeakRef().get();
        if (ankoContext != null) {
            Activity activity = (Activity) ankoContext.getOwner();
            if (activity == null || activity.isFinishing()) {
                return false;
            }
            activity.runOnUiThread(new AsyncKt$activityUiThreadWithContext$2(function2, activity));
            return true;
        }
        return false;
    }

    public static final <T extends Fragment> boolean fragmentUiThread(@NotNull AnkoAsyncContext<T> ankoAsyncContext, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Fragment fragment = (Fragment) ankoAsyncContext.getWeakRef().get();
        if (fragment != null) {
            Intrinsics.checkExpressionValueIsNotNull(fragment, "weakRef.get() ?: return false");
            if (fragment.isDetached()) {
                return false;
            }
            Activity activity = fragment.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new AsyncKt$fragmentUiThread$1(function1, fragment));
                return true;
            }
        }
        return false;
    }

    public static final <T extends Fragment> boolean fragmentUiThreadWithContext(@NotNull AnkoAsyncContext<T> ankoAsyncContext, @NotNull Function2<? super Context, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        Fragment fragment = (Fragment) ankoAsyncContext.getWeakRef().get();
        if (fragment != null) {
            Intrinsics.checkExpressionValueIsNotNull(fragment, "weakRef.get() ?: return false");
            if (fragment.isDetached()) {
                return false;
            }
            Activity activity = fragment.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new AsyncKt$fragmentUiThreadWithContext$1(function2, activity, fragment));
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.util.concurrent.Future doAsync$default(java.lang.Object r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, kotlin.jvm.functions.Function1 r2, int r3, java.lang.Object r4) {
        /*
            r3 = r3 & 1
            if (r3 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = crashLogger
        L_0x0006:
            java.util.concurrent.Future r0 = doAsync(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.AsyncKt.doAsync$default(java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, java.lang.Object):java.util.concurrent.Future");
    }

    @NotNull
    public static final <T> Future<Unit> doAsync(T t, @Nullable Function1<? super Throwable, Unit> function1, @NotNull Function1<? super AnkoAsyncContext<T>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(function12, "task");
        return BackgroundExecutor.INSTANCE.submit(new AsyncKt$doAsync$1(function12, new AnkoAsyncContext(new WeakReference(t)), function1));
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.util.concurrent.Future doAsync$default(java.lang.Object r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, java.util.concurrent.ExecutorService r2, kotlin.jvm.functions.Function1 r3, int r4, java.lang.Object r5) {
        /*
            r4 = r4 & 1
            if (r4 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = crashLogger
        L_0x0006:
            java.util.concurrent.Future r0 = doAsync(r0, r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.AsyncKt.doAsync$default(java.lang.Object, kotlin.jvm.functions.Function1, java.util.concurrent.ExecutorService, kotlin.jvm.functions.Function1, int, java.lang.Object):java.util.concurrent.Future");
    }

    @NotNull
    public static final <T> Future<Unit> doAsync(T t, @Nullable Function1<? super Throwable, Unit> function1, @NotNull ExecutorService executorService, @NotNull Function1<? super AnkoAsyncContext<T>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(executorService, "executorService");
        Intrinsics.checkParameterIsNotNull(function12, "task");
        Future<Unit> submit = executorService.submit(new AsyncKt$doAsync$2(function12, new AnkoAsyncContext(new WeakReference(t)), function1));
        Intrinsics.checkExpressionValueIsNotNull(submit, "executorService.submit<U…voke(thr)\n        }\n    }");
        return submit;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.util.concurrent.Future doAsyncResult$default(java.lang.Object r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, kotlin.jvm.functions.Function1 r2, int r3, java.lang.Object r4) {
        /*
            r3 = r3 & 1
            if (r3 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = crashLogger
        L_0x0006:
            java.util.concurrent.Future r0 = doAsyncResult(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.AsyncKt.doAsyncResult$default(java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, java.lang.Object):java.util.concurrent.Future");
    }

    @NotNull
    public static final <T, R> Future<R> doAsyncResult(T t, @Nullable Function1<? super Throwable, Unit> function1, @NotNull Function1<? super AnkoAsyncContext<T>, ? extends R> function12) {
        Intrinsics.checkParameterIsNotNull(function12, "task");
        return BackgroundExecutor.INSTANCE.submit(new AsyncKt$doAsyncResult$1(function12, new AnkoAsyncContext(new WeakReference(t)), function1));
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1, code=kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>, for r1v0, types: [kotlin.jvm.functions.Function1] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.util.concurrent.Future doAsyncResult$default(java.lang.Object r0, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1, java.util.concurrent.ExecutorService r2, kotlin.jvm.functions.Function1 r3, int r4, java.lang.Object r5) {
        /*
            r4 = r4 & 1
            if (r4 == 0) goto L_0x0006
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = crashLogger
        L_0x0006:
            java.util.concurrent.Future r0 = doAsyncResult(r0, r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.AsyncKt.doAsyncResult$default(java.lang.Object, kotlin.jvm.functions.Function1, java.util.concurrent.ExecutorService, kotlin.jvm.functions.Function1, int, java.lang.Object):java.util.concurrent.Future");
    }

    @NotNull
    public static final <T, R> Future<R> doAsyncResult(T t, @Nullable Function1<? super Throwable, Unit> function1, @NotNull ExecutorService executorService, @NotNull Function1<? super AnkoAsyncContext<T>, ? extends R> function12) {
        Intrinsics.checkParameterIsNotNull(executorService, "executorService");
        Intrinsics.checkParameterIsNotNull(function12, "task");
        Future<R> submit = executorService.submit(new AsyncKt$doAsyncResult$2(function12, new AnkoAsyncContext(new WeakReference(t)), function1));
        Intrinsics.checkExpressionValueIsNotNull(submit, "executorService.submit<R…throw thr\n        }\n    }");
        return submit;
    }
}
