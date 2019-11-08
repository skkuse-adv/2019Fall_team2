package org.jetbrains.anko;

import android.content.Context;
import android.widget.TwoLineListItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.$$Anko$Factories$Sdk27View$TWO_LINE_LIST_ITEM$1 reason: invalid class name */
final class C$$Anko$Factories$Sdk27View$TWO_LINE_LIST_ITEM$1 extends Lambda implements Function1<Context, TwoLineListItem> {
    public static final C$$Anko$Factories$Sdk27View$TWO_LINE_LIST_ITEM$1 INSTANCE = new C$$Anko$Factories$Sdk27View$TWO_LINE_LIST_ITEM$1();

    C$$Anko$Factories$Sdk27View$TWO_LINE_LIST_ITEM$1() {
        super(1);
    }

    @NotNull
    public final TwoLineListItem invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new TwoLineListItem(context);
    }
}
