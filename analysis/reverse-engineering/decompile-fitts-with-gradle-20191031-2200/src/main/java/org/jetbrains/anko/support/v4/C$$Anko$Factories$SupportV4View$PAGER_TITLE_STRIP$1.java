package org.jetbrains.anko.support.v4;

import android.content.Context;
import androidx.viewpager.widget.PagerTitleStrip;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.support.v4.$$Anko$Factories$SupportV4View$PAGER_TITLE_STRIP$1 reason: invalid class name */
final class C$$Anko$Factories$SupportV4View$PAGER_TITLE_STRIP$1 extends Lambda implements Function1<Context, PagerTitleStrip> {
    public static final C$$Anko$Factories$SupportV4View$PAGER_TITLE_STRIP$1 INSTANCE = new C$$Anko$Factories$SupportV4View$PAGER_TITLE_STRIP$1();

    C$$Anko$Factories$SupportV4View$PAGER_TITLE_STRIP$1() {
        super(1);
    }

    @NotNull
    public final PagerTitleStrip invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new PagerTitleStrip(context);
    }
}