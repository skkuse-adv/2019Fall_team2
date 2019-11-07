package kr.co.popone.fitts.feature.trend;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.base.type.NetworkState;
import org.jetbrains.annotations.NotNull;

final class TrendFeedActivity$onCreate$6 extends FunctionReference implements Function1<NetworkState, Unit> {
    TrendFeedActivity$onCreate$6(TrendFeedActivity trendFeedActivity) {
        super(1, trendFeedActivity);
    }

    public final String getName() {
        return "handleNetworkState";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(TrendFeedActivity.class);
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
        ((TrendFeedActivity) this.receiver).handleNetworkState(networkState);
    }
}
