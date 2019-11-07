package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$2 implements RowParser<R> {
    final /* synthetic */ Function2 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$2(Function2 function2) {
        this.$parser = function2;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 2) {
            return this.$parser.invoke(objArr[0], objArr[1]);
        }
        throw new SQLiteException("Invalid row: 2 columns required");
    }
}
