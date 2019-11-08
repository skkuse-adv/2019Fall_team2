package kr.co.popone.fitts.feature.recommend.fittie;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

final class FittieRecommendActivity$onCreate$5 extends FunctionReference implements Function1<String, Unit> {
    FittieRecommendActivity$onCreate$5(FittieRecommendActivity fittieRecommendActivity) {
        super(1, fittieRecommendActivity);
    }

    public final String getName() {
        return "updateButtonText";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FittieRecommendActivity.class);
    }

    public final String getSignature() {
        return "updateButtonText(Ljava/lang/String;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "p1");
        ((FittieRecommendActivity) this.receiver).updateButtonText(str);
    }
}
