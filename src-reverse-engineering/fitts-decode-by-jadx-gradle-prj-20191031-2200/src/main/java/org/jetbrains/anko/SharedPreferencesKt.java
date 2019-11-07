package org.jetbrains.anko;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SharedPreferencesKt {
    public static final void apply(@NotNull SharedPreferences sharedPreferences, @NotNull Function1<? super Editor, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "modifier");
        Editor edit = sharedPreferences.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        function1.invoke(edit);
        edit.apply();
    }

    public static final void commit(@NotNull SharedPreferences sharedPreferences, @NotNull Function1<? super Editor, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "modifier");
        Editor edit = sharedPreferences.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        function1.invoke(edit);
        edit.commit();
    }
}
