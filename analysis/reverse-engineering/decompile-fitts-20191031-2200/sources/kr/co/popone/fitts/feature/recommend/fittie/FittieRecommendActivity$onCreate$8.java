package kr.co.popone.fitts.feature.recommend.fittie;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.base.type.NetworkState;
import org.jetbrains.annotations.NotNull;

final class FittieRecommendActivity$onCreate$8 extends FunctionReference implements Function1<NetworkState, Unit> {
    FittieRecommendActivity$onCreate$8(FittieRecommendActivity fittieRecommendActivity) {
        super(1, fittieRecommendActivity);
    }

    public final String getName() {
        return "handleNetworkState";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FittieRecommendActivity.class);
    }

    public final String getSignature() {
        return "handleNetworkState(Lkr/co/popone/fitts/base/type/NetworkState;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NetworkState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NetworkState networkState) {
        Intrinsics.checkParameterIsNotNull(networkState, "p1");
        ((FittieRecommendActivity) this.receiver).handleNetworkState(networkState);
    }
}
