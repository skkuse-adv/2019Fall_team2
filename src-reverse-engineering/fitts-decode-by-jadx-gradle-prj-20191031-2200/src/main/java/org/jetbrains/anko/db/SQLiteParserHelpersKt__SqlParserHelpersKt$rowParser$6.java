package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$6 implements RowParser<R> {
    final /* synthetic */ Function6 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$6(Function6 function6) {
        this.$parser = function6;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 6) {
            return this.$parser.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
        }
        throw new SQLiteException("Invalid row: 6 columns required");
    }
}
