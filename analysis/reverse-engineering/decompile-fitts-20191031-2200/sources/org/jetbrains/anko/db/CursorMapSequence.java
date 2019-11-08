package org.jetbrains.anko.db;

import android.database.Cursor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

final class CursorMapSequence implements Sequence<Map<String, ? extends Object>> {
    @NotNull
    private final Cursor cursor;

    public CursorMapSequence(@NotNull Cursor cursor2) {
        Intrinsics.checkParameterIsNotNull(cursor2, "cursor");
        this.cursor = cursor2;
    }

    @NotNull
    public final Cursor getCursor() {
        return this.cursor;
    }

    @NotNull
    public CursorMapIterator iterator() {
        return new CursorMapIterator(this.cursor);
    }
}
