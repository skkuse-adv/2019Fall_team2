package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ScalarColumnParser<R, T> implements RowParser<T> {
    @Nullable
    private final Function1<R, T> modifier;

    public ScalarColumnParser() {
        this(null, 1, null);
    }

    public ScalarColumnParser(@Nullable Function1<? super R, ? extends T> function1) {
        this.modifier = function1;
    }

    public /* synthetic */ ScalarColumnParser(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        this(function1);
    }

    @Nullable
    public final Function1<R, T> getModifier() {
        return this.modifier;
    }

    public T parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 1) {
            Function1<R, T> function1 = this.modifier;
            if (function1 == null) {
                return objArr[0];
            }
            if (function1 == null) {
                Intrinsics.throwNpe();
            }
            return function1.invoke(objArr[0]);
        }
        throw new SQLiteException("Invalid row: row for SingleColumnParser must contain exactly one column");
    }
}
