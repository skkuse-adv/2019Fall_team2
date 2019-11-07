package org.jetbrains.anko.db;

import org.jetbrains.annotations.NotNull;

public interface RowParser<T> {
    T parseRow(@NotNull Object[] objArr);
}
