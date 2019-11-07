package kr.co.popone.fitts.feature.store.bridge;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

final class ShopBridgeActivity$onCreate$4 extends FunctionReference implements Function1<String, Unit> {
    ShopBridgeActivity$onCreate$4(ShopBridgeActivity shopBridgeActivity) {
        super(1, shopBridgeActivity);
    }

    public final String getName() {
        return "updateShopTitle";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ShopBridgeActivity.class);
    }

    public final String getSignature() {
        return "updateShopTitle(Ljava/lang/String;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "p1");
        ((ShopBridgeActivity) this.receiver).updateShopTitle(str);
    }
}
