package kr.co.popone.fitts.feature.recommend.fittie;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

final class FittieRecommendActivity$onCreate$4 extends FunctionReference implements Function1<Boolean, Unit> {
    FittieRecommendActivity$onCreate$4(FittieRecommendActivity fittieRecommendActivity) {
        super(1, fittieRecommendActivity);
    }

    public final String getName() {
        return "updateButtonState";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FittieRecommendActivity.class);
    }

    public final String getSignature() {
        return "updateButtonState(Z)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ((FittieRecommendActivity) this.receiver).updateButtonState(z);
    }
}
