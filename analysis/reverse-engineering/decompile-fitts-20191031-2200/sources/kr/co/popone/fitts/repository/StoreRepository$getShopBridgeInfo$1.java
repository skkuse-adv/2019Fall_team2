package kr.co.popone.fitts.repository;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;

final class StoreRepository$getShopBridgeInfo$1 extends FunctionReference implements Function1<Pair<? extends StoreInfo, ? extends List<? extends FeedItem>>, List<? extends FeedItem>> {
    StoreRepository$getShopBridgeInfo$1(StoreRepository storeRepository) {
        super(1, storeRepository);
    }

    public final String getName() {
        return "pariToFeedItem";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(StoreRepository.class);
    }

    public final String getSignature() {
        return "pariToFeedItem(Lkotlin/Pair;)Ljava/util/List;";
    }

    @NotNull
    public final List<FeedItem> invoke(@NotNull Pair<StoreInfo, ? extends List<? extends FeedItem>> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "p1");
        return ((StoreRepository) this.receiver).pariToFeedItem(pair);
    }
}
