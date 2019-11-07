package org.jetbrains.anko;

import android.view.View;
import org.jetbrains.annotations.NotNull;

public interface AnkoComponent<T> {
    @NotNull
    View createView(@NotNull AnkoContext<? extends T> ankoContext);
}
