package org.jetbrains.anko;

import android.view.Menu;
import android.view.MenuItem;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class MenuItemsSequencesKt {
    @NotNull
    public static final Sequence<MenuItem> itemsSequence(@NotNull Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "receiver$0");
        return new MenuItemsSequence(menu);
    }
}
