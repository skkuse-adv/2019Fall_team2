package org.jetbrains.anko.support.v4;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.support.v4.$$Anko$Factories$SupportV4ViewGroup$NESTED_SCROLL_VIEW$1 reason: invalid class name */
final class C$$Anko$Factories$SupportV4ViewGroup$NESTED_SCROLL_VIEW$1 extends Lambda implements Function1<Context, _NestedScrollView> {
    public static final C$$Anko$Factories$SupportV4ViewGroup$NESTED_SCROLL_VIEW$1 INSTANCE = new C$$Anko$Factories$SupportV4ViewGroup$NESTED_SCROLL_VIEW$1();

    C$$Anko$Factories$SupportV4ViewGroup$NESTED_SCROLL_VIEW$1() {
        super(1);
    }

    @NotNull
    public final _NestedScrollView invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new _NestedScrollView(context);
    }
}
