package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Regex$findAll$2 extends FunctionReference implements Function1<MatchResult, MatchResult> {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2();

    Regex$findAll$2() {
        super(1);
    }

    public final String getName() {
        return "next";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(MatchResult.class);
    }

    public final String getSignature() {
        return "next()Lkotlin/text/MatchResult;";
    }

    @Nullable
    public final MatchResult invoke(@NotNull MatchResult matchResult) {
        Intrinsics.checkParameterIsNotNull(matchResult, "p1");
        return matchResult.next();
    }
}
