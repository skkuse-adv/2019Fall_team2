package kr.co.popone.fitts.repository;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;

final class StoreRepository$getStoreProducts$1 extends FunctionReference implements Function1<List<? extends Product>, List<? extends FeedItem>> {
    StoreRepository$getStoreProducts$1(StoreRepository storeRepository) {
        super(1, storeRepository);
    }

    public final String getName() {
        return "productsToShopBridgeProduct";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(StoreRepository.class);
    }

    public final String getSignature() {
        return "productsToShopBridgeProduct(Ljava/util/List;)Ljava/util/List;";
    }

    @NotNull
    public final List<FeedItem> invoke(@NotNull List<Product> list) {
        Intrinsics.checkParameterIsNotNull(list, "p1");
        return ((StoreRepository) this.receiver).productsToShopBridgeProduct(list);
    }
}
