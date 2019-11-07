package kr.co.popone.fitts.feature.home.feed;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.base.type.NetworkState;
import org.jetbrains.annotations.NotNull;

final class HomeFeedFragment$onViewCreated$4 extends FunctionReference implements Function1<NetworkState, Unit> {
    HomeFeedFragment$onViewCreated$4(HomeFeedFragment homeFeedFragment) {
        super(1, homeFeedFragment);
    }

    public final String getName() {
        return "handleNetworkStates";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(HomeFeedFragment.class);
    }

    public final String getSignature() {
        return "handleNetworkStates(Lkr/co/popone/fitts/base/type/NetworkState;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NetworkState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NetworkState networkState) {
        Intrinsics.checkParameterIsNotNull(networkState, "p1");
        ((HomeFeedFragment) this.receiver).handleNetworkStates(networkState);
    }
}
