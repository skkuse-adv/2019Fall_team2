package kr.co.popone.fitts.feature.comment;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CalloutLinkNormal extends ClickableSpan {
    @Nullable
    private final Long UserId;
    @NotNull
    private Context context;

    public void onClick(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "widget");
    }

    public CalloutLinkNormal(@NotNull Context context2, @Nullable Long l) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        this.UserId = l;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final Long getUserId() {
        return this.UserId;
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "<set-?>");
        this.context = context2;
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkParameterIsNotNull(textPaint, "ds");
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
