package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.CheckBox;
import androidx.appcompat.widget.AppCompatCheckBox;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.appcompat.v7.$$Anko$Factories$AppcompatV7View$TINTED_CHECK_BOX$1 reason: invalid class name */
final class C$$Anko$Factories$AppcompatV7View$TINTED_CHECK_BOX$1 extends Lambda implements Function1<Context, CheckBox> {
    public static final C$$Anko$Factories$AppcompatV7View$TINTED_CHECK_BOX$1 INSTANCE = new C$$Anko$Factories$AppcompatV7View$TINTED_CHECK_BOX$1();

    C$$Anko$Factories$AppcompatV7View$TINTED_CHECK_BOX$1() {
        super(1);
    }

    @NotNull
    public final CheckBox invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return VERSION.SDK_INT < 21 ? new AppCompatCheckBox(context) : new CheckBox(context);
    }
}
