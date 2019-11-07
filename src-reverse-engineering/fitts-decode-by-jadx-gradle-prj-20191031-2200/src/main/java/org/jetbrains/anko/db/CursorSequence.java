package org.jetbrains.anko.db;

import android.database.Cursor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

final class CursorSequence implements Sequence<Object[]> {
    @NotNull
    private final Cursor cursor;

    public CursorSequence(@NotNull Cursor cursor2) {
        Intrinsics.checkParameterIsNotNull(cursor2, "cursor");
        this.cursor = cursor2;
    }

    @NotNull
    public final Cursor getCursor() {
        return this.cursor;
    }

    @NotNull
    public CursorIterator iterator() {
        return new CursorIterator(this.cursor);
    }
}
