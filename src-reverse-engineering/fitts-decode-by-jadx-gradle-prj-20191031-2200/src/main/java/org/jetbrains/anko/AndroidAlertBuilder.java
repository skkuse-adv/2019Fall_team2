package org.jetbrains.anko;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

public final class AndroidAlertBuilder implements AlertBuilder<AlertDialog> {
    private final Builder builder = new Builder(getCtx());
    @NotNull
    private final Context ctx;

    public AndroidAlertBuilder(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        this.ctx = context;
    }

    @NotNull
    public Context getCtx() {
        return this.ctx;
    }

    @NotNull
    public CharSequence getTitle() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "value");
        this.builder.setTitle(charSequence);
    }

    public int getTitleResource() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public void setTitleResource(int i) {
        this.builder.setTitle(i);
    }

    @NotNull
    public CharSequence getMessage() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public void setMessage(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "value");
        this.builder.setMessage(charSequence);
    }

    public int getMessageResource() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public void setMessageResource(int i) {
        this.builder.setMessage(i);
    }

    @NotNull
    public Drawable getIcon() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public void setIcon(@NotNull Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "value");
        this.builder.setIcon(drawable);
    }

    public int getIconResource() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public void setIconResource(int i) {
        this.builder.setIcon(i);
    }

    @NotNull
    public View getCustomTitle() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public void setCustomTitle(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "value");
        this.builder.setCustomTitle(view);
    }

    @NotNull
    public View getCustomView() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public void setCustomView(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "value");
        this.builder.setView(view);
    }

    public boolean isCancelable() {
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public void setCancelable(boolean z) {
        this.builder.setCancelable(z);
    }

    public void onCancelled(@NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        this.builder.setOnCancelListener(new AndroidAlertBuilderKt$sam$android_content_DialogInterface_OnCancelListener$0(function1));
    }

    public void onKeyPressed(@NotNull Function3<? super DialogInterface, ? super Integer, ? super KeyEvent, Boolean> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        this.builder.setOnKeyListener(new AndroidAlertBuilderKt$sam$android_content_DialogInterface_OnKeyListener$0(function3));
    }

    public void positiveButton(@NotNull String str, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "buttonText");
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setPositiveButton(str, new AndroidAlertBuilder$positiveButton$1(function1));
    }

    public void positiveButton(int i, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setPositiveButton(i, new AndroidAlertBuilder$positiveButton$2(function1));
    }

    public void negativeButton(@NotNull String str, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "buttonText");
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setNegativeButton(str, new AndroidAlertBuilder$negativeButton$1(function1));
    }

    public void negativeButton(int i, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setNegativeButton(i, new AndroidAlertBuilder$negativeButton$2(function1));
    }

    public void neutralPressed(@NotNull String str, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "buttonText");
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setNeutralButton(str, new AndroidAlertBuilder$neutralPressed$1(function1));
    }

    public void neutralPressed(int i, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "onClicked");
        this.builder.setNeutralButton(i, new AndroidAlertBuilder$neutralPressed$2(function1));
    }

    public void items(@NotNull List<? extends CharSequence> list, @NotNull Function2<? super DialogInterface, ? super Integer, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function2, "onItemSelected");
        Builder builder2 = this.builder;
        String[] strArr = new String[list.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = list.get(i).toString();
        }
        builder2.setItems(strArr, new AndroidAlertBuilder$items$2(function2));
    }

    public <T> void items(@NotNull List<? extends T> list, @NotNull Function3<? super DialogInterface, ? super T, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onItemSelected");
        Builder builder2 = this.builder;
        String[] strArr = new String[list.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = String.valueOf(list.get(i));
        }
        builder2.setItems(strArr, new AndroidAlertBuilder$items$4(function3, list));
    }

    @NotNull
    public AlertDialog build() {
        AlertDialog create = this.builder.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "builder.create()");
        return create;
    }

    @NotNull
    public AlertDialog show() {
        AlertDialog show = this.builder.show();
        Intrinsics.checkExpressionValueIsNotNull(show, "builder.show()");
        return show;
    }
}
