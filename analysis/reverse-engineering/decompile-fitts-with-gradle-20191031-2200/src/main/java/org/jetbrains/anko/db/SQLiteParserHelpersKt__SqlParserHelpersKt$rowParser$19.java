package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$19 implements RowParser<R> {
    final /* synthetic */ Function19 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$19(Function19 function19) {
        this.$parser = function19;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Object[] objArr2 = objArr;
        Intrinsics.checkParameterIsNotNull(objArr2, "columns");
        if (objArr2.length == 19) {
            return this.$parser.invoke(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6], objArr2[7], objArr2[8], objArr2[9], objArr2[10], objArr2[11], objArr2[12], objArr2[13], objArr2[14], objArr2[15], objArr2[16], objArr2[17], objArr2[18]);
        }
        throw new SQLiteException("Invalid row: 19 columns required");
    }
}
