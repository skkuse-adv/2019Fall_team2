package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$3 implements RowParser<R> {
    final /* synthetic */ Function3 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$3(Function3 function3) {
        this.$parser = function3;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 3) {
            return this.$parser.invoke(objArr[0], objArr[1], objArr[2]);
        }
        throw new SQLiteException("Invalid row: 3 columns required");
    }
}
