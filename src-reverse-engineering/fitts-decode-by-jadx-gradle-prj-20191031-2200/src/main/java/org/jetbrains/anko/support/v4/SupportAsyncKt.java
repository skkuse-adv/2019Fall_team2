package org.jetbrains.anko.support.v4;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoAsyncContext;
import org.jetbrains.annotations.NotNull;

public final class SupportAsyncKt {
    public static final <T extends Fragment> boolean supportFragmentUiThread(@NotNull AnkoAsyncContext<T> ankoAsyncContext, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoAsyncContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Fragment fragment = (Fragment) ankoAsyncContext.getWeakRef().get();
        if (fragment != null) {
            Intrinsics.checkExpressionValueIsNotNull(fragment, "weakRef.get() ?: return true");
            if (fragment.isDetached()) {
                return true;
            }
            FragmentActivity activity = fragment.getActivity();
            if (activity != null) {
                Intrinsics.checkExpressionValueIsNotNull(activity, "fragment.activity ?: return true");
                activity.runOnUiThread(new SupportAsyncKt$supportFragmentUiThread$1(function1, fragment));
            }
        }
        return true;
    }

    public static final void uiThread(@NotNull Fragment fragment, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        fragment.requireActivity().runOnUiThread(new SupportAsyncKt$uiThread$1(function0));
    }

    public static final void onUiThread(@NotNull Fragment fragment, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        fragment.requireActivity().runOnUiThread(new SupportAsyncKt$onUiThread$1(function0));
    }

    public static final void runOnUiThread(@NotNull Fragment fragment, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        fragment.requireActivity().runOnUiThread(new SupportAsyncKt$runOnUiThread$1(function0));
    }
}
