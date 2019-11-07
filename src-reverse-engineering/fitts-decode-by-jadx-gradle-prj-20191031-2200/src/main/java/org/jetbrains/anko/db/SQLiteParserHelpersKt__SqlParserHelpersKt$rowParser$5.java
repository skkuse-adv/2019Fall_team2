package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$5 implements RowParser<R> {
    final /* synthetic */ Function5 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$5(Function5 function5) {
        this.$parser = function5;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 5) {
            return this.$parser.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
        }
        throw new SQLiteException("Invalid row: 5 columns required");
    }
}
