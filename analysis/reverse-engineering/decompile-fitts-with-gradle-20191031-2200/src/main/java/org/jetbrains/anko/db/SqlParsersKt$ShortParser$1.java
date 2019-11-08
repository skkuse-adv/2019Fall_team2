package org.jetbrains.anko.db;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

final class SqlParsersKt$ShortParser$1 extends FunctionReference implements Function1<Long, Short> {
    public static final SqlParsersKt$ShortParser$1 INSTANCE = new SqlParsersKt$ShortParser$1();

    SqlParsersKt$ShortParser$1() {
        super(1);
    }

    public final String getName() {
        return "toShort";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Long.TYPE);
    }

    public final String getSignature() {
        return "shortValue()S";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Short.valueOf(invoke(((Number) obj).longValue()));
    }

    public final short invoke(long j) {
        return (short) ((int) j);
    }
}
