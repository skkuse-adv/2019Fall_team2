package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$1 implements RowParser<R> {
    final /* synthetic */ Function1 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$1(Function1 function1) {
        this.$parser = function1;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 1) {
            return this.$parser.invoke(objArr[0]);
        }
        throw new SQLiteException("Invalid row: 1 column required");
    }
}
