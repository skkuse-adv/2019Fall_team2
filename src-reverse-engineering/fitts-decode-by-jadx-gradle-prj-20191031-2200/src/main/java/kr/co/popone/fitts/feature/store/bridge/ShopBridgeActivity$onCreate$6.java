package kr.co.popone.fitts.feature.store.bridge;

import androidx.paging.PagedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import org.jetbrains.annotations.NotNull;

final class ShopBridgeActivity$onCreate$6 extends FunctionReference implements Function1<PagedList<FeedItem>, Unit> {
    ShopBridgeActivity$onCreate$6(ShopBridgeActivity shopBridgeActivity) {
        super(1, shopBridgeActivity);
    }

    public final String getName() {
        return "updateShopFeeds";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ShopBridgeActivity.class);
    }

    public final String getSignature() {
        return "updateShopFeeds(Landroidx/paging/PagedList;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PagedList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PagedList<FeedItem> pagedList) {
        Intrinsics.checkParameterIsNotNull(pagedList, "p1");
        ((ShopBridgeActivity) this.receiver).updateShopFeeds(pagedList);
    }
}
