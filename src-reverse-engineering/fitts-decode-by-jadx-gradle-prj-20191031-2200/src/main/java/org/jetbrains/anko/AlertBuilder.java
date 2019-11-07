package org.jetbrains.anko;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@SuppressLint({"SupportAnnotationUsage"})
public interface AlertBuilder<D extends DialogInterface> {
    @NotNull
    D build();

    @NotNull
    Context getCtx();

    @NotNull
    View getCustomTitle();

    @NotNull
    View getCustomView();

    @NotNull
    Drawable getIcon();

    int getIconResource();

    @NotNull
    CharSequence getMessage();

    int getMessageResource();

    @NotNull
    CharSequence getTitle();

    int getTitleResource();

    boolean isCancelable();

    void items(@NotNull List<? extends CharSequence> list, @NotNull Function2<? super DialogInterface, ? super Integer, Unit> function2);

    <T> void items(@NotNull List<? extends T> list, @NotNull Function3<? super DialogInterface, ? super T, ? super Integer, Unit> function3);

    void negativeButton(@StringRes int i, @NotNull Function1<? super DialogInterface, Unit> function1);

    void negativeButton(@NotNull String str, @NotNull Function1<? super DialogInterface, Unit> function1);

    void neutralPressed(@StringRes int i, @NotNull Function1<? super DialogInterface, Unit> function1);

    void neutralPressed(@NotNull String str, @NotNull Function1<? super DialogInterface, Unit> function1);

    void onCancelled(@NotNull Function1<? super DialogInterface, Unit> function1);

    void onKeyPressed(@NotNull Function3<? super DialogInterface, ? super Integer, ? super KeyEvent, Boolean> function3);

    void positiveButton(@StringRes int i, @NotNull Function1<? super DialogInterface, Unit> function1);

    void positiveButton(@NotNull String str, @NotNull Function1<? super DialogInterface, Unit> function1);

    void setCancelable(boolean z);

    void setCustomTitle(@NotNull View view);

    void setCustomView(@NotNull View view);

    void setIcon(@NotNull Drawable drawable);

    void setIconResource(@DrawableRes int i);

    void setMessage(@NotNull CharSequence charSequence);

    void setMessageResource(int i);

    void setTitle(@NotNull CharSequence charSequence);

    void setTitleResource(int i);

    @NotNull
    D show();
}
