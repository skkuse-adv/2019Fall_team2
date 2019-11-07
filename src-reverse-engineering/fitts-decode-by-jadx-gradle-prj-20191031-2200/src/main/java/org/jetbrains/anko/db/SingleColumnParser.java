package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class SingleColumnParser<T> implements RowParser<T> {
    public T parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 1) {
            return objArr[0];
        }
        throw new SQLiteException("Invalid row: row for SingleColumnParser must contain exactly one column");
    }
}
