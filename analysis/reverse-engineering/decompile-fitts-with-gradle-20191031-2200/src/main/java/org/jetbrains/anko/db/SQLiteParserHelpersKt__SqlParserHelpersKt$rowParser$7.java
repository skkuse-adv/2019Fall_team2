package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$7 implements RowParser<R> {
    final /* synthetic */ Function7 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$7(Function7 function7) {
        this.$parser = function7;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 7) {
            return this.$parser.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
        }
        throw new SQLiteException("Invalid row: 7 columns required");
    }
}
