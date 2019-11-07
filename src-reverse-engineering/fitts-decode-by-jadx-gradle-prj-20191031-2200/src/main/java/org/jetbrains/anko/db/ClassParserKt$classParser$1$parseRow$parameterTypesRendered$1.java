package org.jetbrains.anko.db;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class ClassParserKt$classParser$1$parseRow$parameterTypesRendered$1 extends Lambda implements Function1<Class<?>, String> {
    public static final ClassParserKt$classParser$1$parseRow$parameterTypesRendered$1 INSTANCE = new ClassParserKt$classParser$1$parseRow$parameterTypesRendered$1();

    ClassParserKt$classParser$1$parseRow$parameterTypesRendered$1() {
        super(1);
    }

    public final String invoke(Class<?> cls) {
        Intrinsics.checkExpressionValueIsNotNull(cls, "it");
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkExpressionValueIsNotNull(canonicalName, "it.canonicalName");
        return canonicalName;
    }
}
