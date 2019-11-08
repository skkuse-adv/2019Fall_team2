package kr.co.popone.fitts.feature.comment;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CalloutLink extends ClickableSpan {
    private final Long UserId;
    @NotNull
    private Context context;

    public CalloutLink(@NotNull Context context2, @Nullable Long l) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        this.UserId = l;
    }

    @NotNull
    public final Context getContext$app_productionFittsRelease() {
        return this.context;
    }

    public final void setContext$app_productionFittsRelease(@NotNull Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "<set-?>");
        this.context = context2;
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkParameterIsNotNull(textPaint, "ds");
        textPaint.setARGB(255, 21, 122, 209);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "widget");
        Object systemService = this.context.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
            ShowRoomActivity.Companion.startWithNewTask(this.context, this.UserId, "comment");
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
