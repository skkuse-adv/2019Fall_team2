package kr.co.popone.fitts.feature.intro.join;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

final class JoinActivity$onCreate$38 extends FunctionReference implements Function1<Object, String> {
    public static final JoinActivity$onCreate$38 INSTANCE = new JoinActivity$onCreate$38();

    JoinActivity$onCreate$38() {
        super(1);
    }

    public final String getName() {
        return "toString";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(CharSequence.class);
    }

    public final String getSignature() {
        return "toString()Ljava/lang/String;";
    }

    @NotNull
    public final String invoke(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "p1");
        return charSequence.toString();
    }
}
