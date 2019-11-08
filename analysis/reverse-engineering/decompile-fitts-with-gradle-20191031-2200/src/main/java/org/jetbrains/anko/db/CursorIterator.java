package org.jetbrains.anko.db;

import android.database.Cursor;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

final class CursorIterator implements Iterator<Object[]>, KMappedMarker {
    @NotNull
    private final Cursor cursor;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public CursorIterator(@NotNull Cursor cursor2) {
        Intrinsics.checkParameterIsNotNull(cursor2, "cursor");
        this.cursor = cursor2;
    }

    @NotNull
    public final Cursor getCursor() {
        return this.cursor;
    }

    public boolean hasNext() {
        return this.cursor.getPosition() < this.cursor.getCount() - 1;
    }

    @NotNull
    public Object[] next() {
        this.cursor.moveToNext();
        return SqlParsersKt.readColumnsArray(this.cursor);
    }
}
