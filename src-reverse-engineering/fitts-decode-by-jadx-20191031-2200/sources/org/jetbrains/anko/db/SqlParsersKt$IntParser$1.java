package org.jetbrains.anko.db;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

final class SqlParsersKt$IntParser$1 extends FunctionReference implements Function1<Long, Integer> {
    public static final SqlParsersKt$IntParser$1 INSTANCE = new SqlParsersKt$IntParser$1();

    SqlParsersKt$IntParser$1() {
        super(1);
    }

    public final String getName() {
        return "toInt";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Long.TYPE);
    }

    public final String getSignature() {
        return "intValue()I";
    }

    public final int invoke(long j) {
        return (int) j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(invoke(((Number) obj).longValue()));
    }
}
