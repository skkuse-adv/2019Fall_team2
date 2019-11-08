package kr.co.popone.fitts.feature.store.bridge;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import org.jetbrains.annotations.NotNull;

final class ShopBridgeActivity$onCreate$9 extends FunctionReference implements Function1<WishStateUpdateEvent, Unit> {
    ShopBridgeActivity$onCreate$9(ShopBridgeActivity shopBridgeActivity) {
        super(1, shopBridgeActivity);
    }

    public final String getName() {
        return "updateProductLikeState";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ShopBridgeActivity.class);
    }

    public final String getSignature() {
        return "updateProductLikeState(Lkr/co/popone/fitts/event/WishStateUpdateEvent;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WishStateUpdateEvent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull WishStateUpdateEvent wishStateUpdateEvent) {
        Intrinsics.checkParameterIsNotNull(wishStateUpdateEvent, "p1");
        ((ShopBridgeActivity) this.receiver).updateProductLikeState(wishStateUpdateEvent);
    }
}
