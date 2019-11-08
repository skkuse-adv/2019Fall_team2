package kr.co.popone.fitts.feature.store.recommend;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.event.ShopBookmarkEvent;
import org.jetbrains.annotations.NotNull;

final class StoreFeedFragment$onViewCreated$8 extends FunctionReference implements Function1<ShopBookmarkEvent, Unit> {
    StoreFeedFragment$onViewCreated$8(StoreFeedFragment storeFeedFragment) {
        super(1, storeFeedFragment);
    }

    public final String getName() {
        return "updateShopBookmarkState";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(StoreFeedFragment.class);
    }

    public final String getSignature() {
        return "updateShopBookmarkState(Lkr/co/popone/fitts/event/ShopBookmarkEvent;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ShopBookmarkEvent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ShopBookmarkEvent shopBookmarkEvent) {
        Intrinsics.checkParameterIsNotNull(shopBookmarkEvent, "p1");
        ((StoreFeedFragment) this.receiver).updateShopBookmarkState(shopBookmarkEvent);
    }
}
