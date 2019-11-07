package org.jetbrains.anko.db;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class SqlTypesKt$FOREIGN_KEY$2 extends Lambda implements Function1<String, String> {
    public static final SqlTypesKt$FOREIGN_KEY$2 INSTANCE = new SqlTypesKt$FOREIGN_KEY$2();

    SqlTypesKt$FOREIGN_KEY$2() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        StringBuilder sb = new StringBuilder();
        sb.append(' ');
        sb.append(str);
        return sb.toString();
    }
}
