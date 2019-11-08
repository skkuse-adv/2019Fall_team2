package org.jetbrains.anko.db;

import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoException;
import org.jetbrains.annotations.NotNull;

public final class ClassParserKt$classParser$1 implements RowParser<T> {
    final /* synthetic */ Constructor $preferredConstructor;
    private final Class<?>[] parameterTypes;

    ClassParserKt$classParser$1(Constructor constructor) {
        this.$preferredConstructor = constructor;
        Intrinsics.checkExpressionValueIsNotNull(constructor, "preferredConstructor");
        this.parameterTypes = constructor.getParameterTypes();
    }

    public T parseRow(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        Class<?>[] clsArr = this.parameterTypes;
        if (clsArr.length == objArr.length) {
            int i = 0;
            int length = clsArr.length - 1;
            if (length >= 0) {
                while (true) {
                    Class<?> cls = this.parameterTypes[i];
                    Object obj = objArr[i];
                    if (!cls.isInstance(obj)) {
                        Intrinsics.checkExpressionValueIsNotNull(cls, "type");
                        objArr[i] = ClassParserKt.castValue(obj, cls);
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            return JavaSqliteUtils.newInstance(this.$preferredConstructor, objArr);
        }
        String joinToString$default = ArraysKt___ArraysKt.joinToString$default(objArr, (CharSequence) null, (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 57, (Object) null);
        Class<?>[] clsArr2 = this.parameterTypes;
        Intrinsics.checkExpressionValueIsNotNull(clsArr2, "parameterTypes");
        String joinToString$default2 = ArraysKt___ArraysKt.joinToString$default((Object[]) clsArr2, (CharSequence) null, (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) ClassParserKt$classParser$1$parseRow$parameterTypesRendered$1.INSTANCE, 25, (Object) null);
        StringBuilder sb = new StringBuilder();
        sb.append("Class parser for ");
        Constructor constructor = this.$preferredConstructor;
        Intrinsics.checkExpressionValueIsNotNull(constructor, "preferredConstructor");
        sb.append(constructor.getName());
        sb.append(' ');
        sb.append("failed to parse the row: ");
        sb.append(joinToString$default);
        sb.append(" (constructor parameter types: ");
        sb.append(joinToString$default2);
        sb.append(')');
        throw new AnkoException(sb.toString());
    }
}
