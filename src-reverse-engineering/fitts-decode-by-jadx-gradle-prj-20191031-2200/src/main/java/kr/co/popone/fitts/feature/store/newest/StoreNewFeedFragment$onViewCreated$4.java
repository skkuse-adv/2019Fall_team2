package kr.co.popone.fitts.feature.store.newest;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.base.type.NetworkState;
import org.jetbrains.annotations.Nullable;

final class StoreNewFeedFragment$onViewCreated$4 extends FunctionReference implements Function1<NetworkState, Unit> {
    StoreNewFeedFragment$onViewCreated$4(StoreNewFeedFragment storeNewFeedFragment) {
        super(1, storeNewFeedFragment);
    }

    public final String getName() {
        return "handleNetworkState";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(StoreNewFeedFragment.class);
    }

    public final String getSignature() {
        return "handleNetworkState(Lkr/co/popone/fitts/base/type/NetworkState;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NetworkState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable NetworkState networkState) {
        ((StoreNewFeedFragment) this.receiver).handleNetworkState(networkState);
    }
}
