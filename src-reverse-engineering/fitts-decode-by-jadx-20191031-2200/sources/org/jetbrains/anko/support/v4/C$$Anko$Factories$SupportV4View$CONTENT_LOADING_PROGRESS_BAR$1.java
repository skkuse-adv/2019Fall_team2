package org.jetbrains.anko.support.v4;

import android.content.Context;
import androidx.core.widget.ContentLoadingProgressBar;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.support.v4.$$Anko$Factories$SupportV4View$CONTENT_LOADING_PROGRESS_BAR$1 reason: invalid class name */
final class C$$Anko$Factories$SupportV4View$CONTENT_LOADING_PROGRESS_BAR$1 extends Lambda implements Function1<Context, ContentLoadingProgressBar> {
    public static final C$$Anko$Factories$SupportV4View$CONTENT_LOADING_PROGRESS_BAR$1 INSTANCE = new C$$Anko$Factories$SupportV4View$CONTENT_LOADING_PROGRESS_BAR$1();

    C$$Anko$Factories$SupportV4View$CONTENT_LOADING_PROGRESS_BAR$1() {
        super(1);
    }

    @NotNull
    public final ContentLoadingProgressBar invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new ContentLoadingProgressBar(context);
    }
}
