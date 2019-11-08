package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$4 implements RowParser<R> {
    final /* synthetic */ Function4 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$4(Function4 function4) {
        this.$parser = function4;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 4) {
            return this.$parser.invoke(objArr[0], objArr[1], objArr[2], objArr[3]);
        }
        throw new SQLiteException("Invalid row: 4 columns required");
    }
}
