package org.jetbrains.anko.db;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface MapRowParser<T> {
    T parseRow(@NotNull Map<String, ? extends Object> map);
}
