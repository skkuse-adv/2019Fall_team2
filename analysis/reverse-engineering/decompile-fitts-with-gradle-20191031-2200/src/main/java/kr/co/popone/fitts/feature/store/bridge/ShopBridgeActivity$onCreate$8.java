package kr.co.popone.fitts.feature.store.bridge;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.event.ShopBookmarkEvent;
import org.jetbrains.annotations.NotNull;

final class ShopBridgeActivity$onCreate$8 extends FunctionReference implements Function1<ShopBookmarkEvent, Unit> {
    ShopBridgeActivity$onCreate$8(ShopBridgeActivity shopBridgeActivity) {
        super(1, shopBridgeActivity);
    }

    public final String getName() {
        return "updateShopBookmarkHeader";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ShopBridgeActivity.class);
    }

    public final String getSignature() {
        return "updateShopBookmarkHeader(Lkr/co/popone/fitts/event/ShopBookmarkEvent;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ShopBookmarkEvent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ShopBookmarkEvent shopBookmarkEvent) {
        Intrinsics.checkParameterIsNotNull(shopBookmarkEvent, "p1");
        ((ShopBridgeActivity) this.receiver).updateShopBookmarkHeader(shopBookmarkEvent);
    }
}
