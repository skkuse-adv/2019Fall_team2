package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$10 implements RowParser<R> {
    final /* synthetic */ Function10 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$10(Function10 function10) {
        this.$parser = function10;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 10) {
            return this.$parser.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8], objArr[9]);
        }
        throw new SQLiteException("Invalid row: 10 columns required");
    }
}
