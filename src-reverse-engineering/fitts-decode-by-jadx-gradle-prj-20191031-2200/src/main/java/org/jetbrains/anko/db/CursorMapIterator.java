package org.jetbrains.anko.db;

import android.database.Cursor;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

final class CursorMapIterator implements Iterator<Map<String, ? extends Object>>, KMappedMarker {
    @NotNull
    private final Cursor cursor;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public CursorMapIterator(@NotNull Cursor cursor2) {
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
    public Map<String, Object> next() {
        this.cursor.moveToNext();
        return SqlParsersKt.readColumnsMap(this.cursor);
    }
}
