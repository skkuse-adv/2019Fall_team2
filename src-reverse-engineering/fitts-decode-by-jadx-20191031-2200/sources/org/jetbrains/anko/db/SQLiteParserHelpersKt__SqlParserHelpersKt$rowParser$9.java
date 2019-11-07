package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$9 implements RowParser<R> {
    final /* synthetic */ Function9 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$9(Function9 function9) {
        this.$parser = function9;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 9) {
            return this.$parser.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
        }
        throw new SQLiteException("Invalid row: 9 columns required");
    }
}
