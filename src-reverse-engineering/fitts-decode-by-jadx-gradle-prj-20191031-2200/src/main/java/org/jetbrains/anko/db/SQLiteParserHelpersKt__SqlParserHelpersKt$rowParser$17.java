package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$17 implements RowParser<R> {
    final /* synthetic */ Function17 $parser;

    SQLiteParserHelpersKt__SqlParserHelpersKt$rowParser$17(Function17 function17) {
        this.$parser = function17;
    }

    public R parseRow(@NotNull Object[] objArr) {
        Object[] objArr2 = objArr;
        Intrinsics.checkParameterIsNotNull(objArr2, "columns");
        if (objArr2.length == 17) {
            return this.$parser.invoke(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6], objArr2[7], objArr2[8], objArr2[9], objArr2[10], objArr2[11], objArr2[12], objArr2[13], objArr2[14], objArr2[15], objArr2[16]);
        }
        throw new SQLiteException("Invalid row: 17 columns required");
    }
}
