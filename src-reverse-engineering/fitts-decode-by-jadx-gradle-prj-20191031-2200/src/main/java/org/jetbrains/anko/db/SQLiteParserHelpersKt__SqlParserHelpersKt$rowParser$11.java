package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$11 implements RowParser<R> {
    final /* synthetic */ Function11 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$11(Function11 function11) {
        this.$parser = function11;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 11) {
            return this.$parser.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8], objArr[9], objArr[10]);
        }
        throw new SQLiteException("Invalid row: 11 columns required");
    }
}
