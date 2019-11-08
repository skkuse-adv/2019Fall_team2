package org.jetbrains.anko;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewManager;
import android.widget.ListAdapter;
import com.kakao.auth.StringSet;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AlertDialogBuilder {
    private Builder builder;
    @NotNull
    private final Context ctx;
    @Nullable
    private AlertDialog dialog;

    public AlertDialogBuilder(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        this.ctx = context;
        this.builder = new Builder(this.ctx);
    }

    @NotNull
    public final Context getCtx() {
        return this.ctx;
    }

    private final void setDialog(AlertDialog alertDialog) {
        this.dialog = alertDialog;
    }

    @Nullable
    public final AlertDialog getDialog() {
        return this.dialog;
    }

    public AlertDialogBuilder(@NotNull AnkoContext<?> ankoContext) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "ankoContext");
        this(ankoContext.getCtx());
    }

    public final void dismiss() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private final void checkBuilder() {
        if (this.builder == null) {
            throw new IllegalStateException("show() was already called for this AlertDialogBuilder");
        }
    }

    @NotNull
    public final AlertDialogBuilder show() {
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        this.dialog = builder2.create();
        this.builder = null;
        AlertDialog alertDialog = this.dialog;
        if (alertDialog == null) {
            Intrinsics.throwNpe();
        }
        alertDialog.show();
        return this;
    }

    public final void title(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "title");
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setTitle(charSequence);
    }

    public final void title(int i) {
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setTitle(i);
    }

    public final void message(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setMessage(charSequence);
    }

    public final void message(int i) {
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setMessage(i);
    }

    public final void icon(int i) {
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setIcon(i);
    }

    public final void icon(@NotNull Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, SettingsJsonConstants.APP_ICON_KEY);
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setIcon(drawable);
    }

    public final void customTitle(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setCustomTitle(view);
    }

    public final void customTitle(@NotNull Function1<? super ViewManager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "dsl");
        checkBuilder();
        Context context = this.ctx;
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, context, false);
        function1.invoke(ankoContextImpl);
        View view = ankoContextImpl.getView();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setCustomTitle(view);
    }

    public final void customView(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setView(view);
    }

    public final void customView(@NotNull Function1<? super ViewManager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "dsl");
        checkBuilder();
        Context context = this.ctx;
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, context, false);
        function1.invoke(ankoContextImpl);
        View view = ankoContextImpl.getView();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setView(view);
    }

    public static /* synthetic */ void cancellable$default(AlertDialogBuilder alertDialogBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        alertDialogBuilder.cancellable(z);
    }

    public final void cancellable(boolean z) {
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setCancelable(z);
    }

    public final void onCancel(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, StringSet.PARAM_CALLBACK);
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setOnCancelListener(new AlertDialogBuilder$onCancel$1(function0));
    }

    public final void onKey(@NotNull Function2<? super Integer, ? super KeyEvent, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(function2, StringSet.PARAM_CALLBACK);
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setOnKeyListener(new AlertDialogBuilder$onKey$1(function2));
    }

    public static /* synthetic */ void neutralButton$default(AlertDialogBuilder alertDialogBuilder, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 17039370;
        }
        if ((i2 & 2) != 0) {
            function1 = AlertDialogBuilder$neutralButton$1.INSTANCE;
        }
        alertDialogBuilder.neutralButton(i, function1);
    }

    public final void neutralButton(int i, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        String string = this.ctx.getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(neutralText)");
        neutralButton((CharSequence) string, function1);
    }

    public static /* synthetic */ void neutralButton$default(AlertDialogBuilder alertDialogBuilder, CharSequence charSequence, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = AlertDialogBuilder$neutralButton$2.INSTANCE;
        }
        alertDialogBuilder.neutralButton(charSequence, function1);
    }

    public final void neutralButton(@NotNull CharSequence charSequence, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "neutralText");
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setNeutralButton(charSequence, new AlertDialogBuilder$neutralButton$3(function1));
    }

    public final void positiveButton(int i, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        String string = this.ctx.getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(positiveText)");
        positiveButton((CharSequence) string, function1);
    }

    public final void okButton(@NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        String string = this.ctx.getString(17039370);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(R.string.ok)");
        positiveButton((CharSequence) string, function1);
    }

    public final void yesButton(@NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        String string = this.ctx.getString(17039379);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(R.string.yes)");
        positiveButton((CharSequence) string, function1);
    }

    public final void positiveButton(@NotNull CharSequence charSequence, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "positiveText");
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setPositiveButton(charSequence, new AlertDialogBuilder$positiveButton$1(function1));
    }

    public static /* synthetic */ void negativeButton$default(AlertDialogBuilder alertDialogBuilder, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = AlertDialogBuilder$negativeButton$1.INSTANCE;
        }
        alertDialogBuilder.negativeButton(i, function1);
    }

    public final void negativeButton(int i, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        String string = this.ctx.getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(negativeText)");
        negativeButton((CharSequence) string, function1);
    }

    public static /* synthetic */ void cancelButton$default(AlertDialogBuilder alertDialogBuilder, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlertDialogBuilder$cancelButton$1.INSTANCE;
        }
        alertDialogBuilder.cancelButton(function1);
    }

    public final void cancelButton(@NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        String string = this.ctx.getString(17039360);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(R.string.cancel)");
        negativeButton((CharSequence) string, function1);
    }

    public static /* synthetic */ void noButton$default(AlertDialogBuilder alertDialogBuilder, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlertDialogBuilder$noButton$1.INSTANCE;
        }
        alertDialogBuilder.noButton(function1);
    }

    public final void noButton(@NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        String string = this.ctx.getString(17039369);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(R.string.no)");
        negativeButton((CharSequence) string, function1);
    }

    public static /* synthetic */ void negativeButton$default(AlertDialogBuilder alertDialogBuilder, CharSequence charSequence, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = AlertDialogBuilder$negativeButton$2.INSTANCE;
        }
        alertDialogBuilder.negativeButton(charSequence, function1);
    }

    public final void negativeButton(@NotNull CharSequence charSequence, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "negativeText");
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setNegativeButton(charSequence, new AlertDialogBuilder$negativeButton$3(function1));
    }

    public final void items(int i, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        Resources resources = this.ctx.getResources();
        if (resources == null) {
            Intrinsics.throwNpe();
        }
        CharSequence[] textArray = resources.getTextArray(i);
        Intrinsics.checkExpressionValueIsNotNull(textArray, "ctx.resources!!.getTextArray(itemsId)");
        items(textArray, function1);
    }

    public final void items(@NotNull CharSequence[] charSequenceArr, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(charSequenceArr, "items");
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setItems(charSequenceArr, new AlertDialogBuilder$items$1(function1));
    }

    public final void adapter(@NotNull ListAdapter listAdapter, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(listAdapter, "adapter");
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setAdapter(listAdapter, new AlertDialogBuilder$adapter$1(function1));
    }

    public final void adapter(@NotNull Cursor cursor, @NotNull String str, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(cursor, "cursor");
        Intrinsics.checkParameterIsNotNull(str, "labelColumn");
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        checkBuilder();
        Builder builder2 = this.builder;
        if (builder2 == null) {
            Intrinsics.throwNpe();
        }
        builder2.setCursor(cursor, new AlertDialogBuilder$adapter$2(function1), str);
    }

    public final void items(@NotNull List<? extends CharSequence> list, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function1, StringSet.PARAM_CALLBACK);
        Object[] array = list.toArray(new CharSequence[0]);
        if (array != null) {
            items((CharSequence[]) array, function1);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
