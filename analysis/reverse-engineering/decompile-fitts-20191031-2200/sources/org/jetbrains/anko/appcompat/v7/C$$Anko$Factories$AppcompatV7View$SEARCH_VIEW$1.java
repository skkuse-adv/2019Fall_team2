package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import androidx.appcompat.widget.SearchView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.appcompat.v7.$$Anko$Factories$AppcompatV7View$SEARCH_VIEW$1 reason: invalid class name */
final class C$$Anko$Factories$AppcompatV7View$SEARCH_VIEW$1 extends Lambda implements Function1<Context, SearchView> {
    public static final C$$Anko$Factories$AppcompatV7View$SEARCH_VIEW$1 INSTANCE = new C$$Anko$Factories$AppcompatV7View$SEARCH_VIEW$1();

    C$$Anko$Factories$AppcompatV7View$SEARCH_VIEW$1() {
        super(1);
    }

    @NotNull
    public final SearchView invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new SearchView(context);
    }
}
