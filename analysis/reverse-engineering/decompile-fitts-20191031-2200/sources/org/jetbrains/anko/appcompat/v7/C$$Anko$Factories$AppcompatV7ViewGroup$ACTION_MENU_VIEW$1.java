package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.appcompat.v7.$$Anko$Factories$AppcompatV7ViewGroup$ACTION_MENU_VIEW$1 reason: invalid class name */
final class C$$Anko$Factories$AppcompatV7ViewGroup$ACTION_MENU_VIEW$1 extends Lambda implements Function1<Context, _ActionMenuView> {
    public static final C$$Anko$Factories$AppcompatV7ViewGroup$ACTION_MENU_VIEW$1 INSTANCE = new C$$Anko$Factories$AppcompatV7ViewGroup$ACTION_MENU_VIEW$1();

    C$$Anko$Factories$AppcompatV7ViewGroup$ACTION_MENU_VIEW$1() {
        super(1);
    }

    @NotNull
    public final _ActionMenuView invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new _ActionMenuView(context);
    }
}
