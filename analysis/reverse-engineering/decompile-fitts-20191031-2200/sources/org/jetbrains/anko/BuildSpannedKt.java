package org.jetbrains.anko;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class BuildSpannedKt {
    @NotNull
    public static final Spanned buildSpanned(@NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        function1.invoke(spannableStringBuilder);
        return spannableStringBuilder;
    }

    @NotNull
    public static final StyleSpan getBold(@NotNull SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        return new StyleSpan(1);
    }

    @NotNull
    public static final StyleSpan getItalic(@NotNull SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        return new StyleSpan(2);
    }

    @NotNull
    public static final UnderlineSpan getUnderline(@NotNull SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        return new UnderlineSpan();
    }

    @NotNull
    public static final StrikethroughSpan getStrikethrough(@NotNull SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        return new StrikethroughSpan();
    }

    @NotNull
    public static final ForegroundColorSpan foregroundColor(@NotNull SpannableStringBuilder spannableStringBuilder, int i) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        return new ForegroundColorSpan(i);
    }

    @NotNull
    public static final BackgroundColorSpan backgroundColor(@NotNull SpannableStringBuilder spannableStringBuilder, int i) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        return new BackgroundColorSpan(i);
    }

    @NotNull
    public static final ClickableSpan clickable(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "onClick");
        return new BuildSpannedKt$clickable$1(function1);
    }

    @NotNull
    public static final URLSpan link(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "url");
        return new URLSpan(str);
    }

    public static final void append(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull CharSequence charSequence, @NotNull Object... objArr) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Intrinsics.checkParameterIsNotNull(objArr, "spans");
        int length = charSequence.length();
        spannableStringBuilder.append(charSequence);
        for (Object span : objArr) {
            spannableStringBuilder.setSpan(span, spannableStringBuilder.length() - length, spannableStringBuilder.length(), 17);
        }
    }

    public static final void append(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull CharSequence charSequence, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Intrinsics.checkParameterIsNotNull(obj, "span");
        int length = charSequence.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, spannableStringBuilder.length() - length, spannableStringBuilder.length(), 17);
    }

    @NotNull
    public static final SpannableStringBuilder append(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Object obj, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(obj, "span");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final void appendln(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull CharSequence charSequence, @NotNull Object... objArr) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Intrinsics.checkParameterIsNotNull(objArr, "spans");
        append(spannableStringBuilder, charSequence, Arrays.copyOf(objArr, objArr.length));
        StringsKt__StringBuilderJVMKt.appendln((Appendable) spannableStringBuilder);
    }

    public static final void appendln(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull CharSequence charSequence, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Intrinsics.checkParameterIsNotNull(obj, "span");
        append(spannableStringBuilder, charSequence, obj);
        StringsKt__StringBuilderJVMKt.appendln((Appendable) spannableStringBuilder);
    }
}
