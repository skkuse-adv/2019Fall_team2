package org.jetbrains.anko.support.v4;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SupportContextUtilsKt {
    public static /* synthetic */ void act$annotations(Fragment fragment) {
    }

    public static /* synthetic */ void ctx$annotations(Fragment fragment) {
    }

    @NotNull
    public static final SharedPreferences getDefaultSharedPreferences(@NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(fragment.getActivity());
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…aredPreferences(activity)");
        return defaultSharedPreferences;
    }

    @NotNull
    public static final FragmentActivity getAct(@NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return requireActivity;
    }

    @NotNull
    public static final Context getCtx(@NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return requireActivity;
    }
}
