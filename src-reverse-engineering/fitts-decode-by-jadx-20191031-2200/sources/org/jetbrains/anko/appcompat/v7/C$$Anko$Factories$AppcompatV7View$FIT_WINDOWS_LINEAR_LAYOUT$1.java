package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import androidx.appcompat.widget.FitWindowsLinearLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.appcompat.v7.$$Anko$Factories$AppcompatV7View$FIT_WINDOWS_LINEAR_LAYOUT$1 reason: invalid class name */
final class C$$Anko$Factories$AppcompatV7View$FIT_WINDOWS_LINEAR_LAYOUT$1 extends Lambda implements Function1<Context, FitWindowsLinearLayout> {
    public static final C$$Anko$Factories$AppcompatV7View$FIT_WINDOWS_LINEAR_LAYOUT$1 INSTANCE = new C$$Anko$Factories$AppcompatV7View$FIT_WINDOWS_LINEAR_LAYOUT$1();

    C$$Anko$Factories$AppcompatV7View$FIT_WINDOWS_LINEAR_LAYOUT$1() {
        super(1);
    }

    @NotNull
    public final FitWindowsLinearLayout invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new FitWindowsLinearLayout(context);
    }
}
