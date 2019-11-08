package org.jetbrains.anko.db;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

final class SqlParsersKt$FloatParser$1 extends FunctionReference implements Function1<Double, Float> {
    public static final SqlParsersKt$FloatParser$1 INSTANCE = new SqlParsersKt$FloatParser$1();

    SqlParsersKt$FloatParser$1() {
        super(1);
    }

    public final String getName() {
        return "toFloat";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Double.TYPE);
    }

    public final String getSignature() {
        return "floatValue()F";
    }

    public final float invoke(double d) {
        return (float) d;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Float.valueOf(invoke(((Number) obj).doubleValue()));
    }
}
