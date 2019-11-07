package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.Spinner;
import androidx.appcompat.widget.AppCompatSpinner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.appcompat.v7.$$Anko$Factories$AppcompatV7View$TINTED_SPINNER$1 reason: invalid class name */
final class C$$Anko$Factories$AppcompatV7View$TINTED_SPINNER$1 extends Lambda implements Function1<Context, Spinner> {
    public static final C$$Anko$Factories$AppcompatV7View$TINTED_SPINNER$1 INSTANCE = new C$$Anko$Factories$AppcompatV7View$TINTED_SPINNER$1();

    C$$Anko$Factories$AppcompatV7View$TINTED_SPINNER$1() {
        super(1);
    }

    @NotNull
    public final Spinner invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return VERSION.SDK_INT < 21 ? new AppCompatSpinner(context) : new Spinner(context);
    }
}
