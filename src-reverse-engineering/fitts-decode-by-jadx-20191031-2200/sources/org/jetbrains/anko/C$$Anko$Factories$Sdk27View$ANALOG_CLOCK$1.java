package org.jetbrains.anko;

import android.content.Context;
import android.widget.AnalogClock;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.$$Anko$Factories$Sdk27View$ANALOG_CLOCK$1 reason: invalid class name */
final class C$$Anko$Factories$Sdk27View$ANALOG_CLOCK$1 extends Lambda implements Function1<Context, AnalogClock> {
    public static final C$$Anko$Factories$Sdk27View$ANALOG_CLOCK$1 INSTANCE = new C$$Anko$Factories$Sdk27View$ANALOG_CLOCK$1();

    C$$Anko$Factories$Sdk27View$ANALOG_CLOCK$1() {
        super(1);
    }

    @NotNull
    public final AnalogClock invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new AnalogClock(context);
    }
}
