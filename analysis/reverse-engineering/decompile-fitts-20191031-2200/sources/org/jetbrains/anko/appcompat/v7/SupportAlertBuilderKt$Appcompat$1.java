package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

final class SupportAlertBuilderKt$Appcompat$1 extends FunctionReference implements Function1<Context, AppcompatAlertBuilder> {
    public static final SupportAlertBuilderKt$Appcompat$1 INSTANCE = new SupportAlertBuilderKt$Appcompat$1();

    SupportAlertBuilderKt$Appcompat$1() {
        super(1);
    }

    public final String getName() {
        return "<init>";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AppcompatAlertBuilder.class);
    }

    public final String getSignature() {
        return "<init>(Landroid/content/Context;)V";
    }

    @NotNull
    public final AppcompatAlertBuilder invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "p1");
        return new AppcompatAlertBuilder(context);
    }
}
