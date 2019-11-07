package org.jetbrains.anko;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

final class AndroidAlertBuilderKt$Android$1 extends FunctionReference implements Function1<Context, AndroidAlertBuilder> {
    public static final AndroidAlertBuilderKt$Android$1 INSTANCE = new AndroidAlertBuilderKt$Android$1();

    AndroidAlertBuilderKt$Android$1() {
        super(1);
    }

    public final String getName() {
        return "<init>";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AndroidAlertBuilder.class);
    }

    public final String getSignature() {
        return "<init>(Landroid/content/Context;)V";
    }

    @NotNull
    public final AndroidAlertBuilder invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "p1");
        return new AndroidAlertBuilder(context);
    }
}
