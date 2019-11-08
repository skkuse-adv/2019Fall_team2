package org.jetbrains.anko.support.v4;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.annotations.NotNull;

public final class SupportDimensionsKt {
    public static final int dip(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.dip((Context) requireActivity, i);
    }

    public static final int dip(@NotNull Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.dip((Context) requireActivity, f);
    }

    public static final int sp(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.sp((Context) requireActivity, i);
    }

    public static final int sp(@NotNull Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.sp((Context) requireActivity, f);
    }

    public static final float px2dip(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.px2dip((Context) requireActivity, i);
    }

    public static final float px2sp(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.px2sp((Context) requireActivity, i);
    }

    public static final int dimen(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.dimen((Context) requireActivity, i);
    }
}
