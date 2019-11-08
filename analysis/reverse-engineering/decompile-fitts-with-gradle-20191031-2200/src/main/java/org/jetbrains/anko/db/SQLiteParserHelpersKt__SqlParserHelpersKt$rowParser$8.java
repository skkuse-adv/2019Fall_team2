package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$8 implements RowParser<R> {
    final /* synthetic */ Function8 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$8(Function8 function8) {
        this.$parser = function8;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 8) {
            return this.$parser.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
        }
        throw new SQLiteException("Invalid row: 8 columns required");
    }
}
