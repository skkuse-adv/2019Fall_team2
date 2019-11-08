package kr.co.popone.fitts.model.datamodel.commerce.shop.bridge;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;

public final class ShopBridgeProduct implements FeedItem {
    @NotNull
    private final List<Product> products;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.product.Product>, for r1v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct copy$default(kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct r0, java.util.List<kr.co.popone.fitts.model.product.Product> r1, int r2, java.lang.Object r3) {
        /*
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0006
            java.util.List<kr.co.popone.fitts.model.product.Product> r1 = r0.products
        L_0x0006:
            kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct r0 = r0.copy(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct.copy$default(kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct");
    }

    @NotNull
    public final List<Product> component1() {
        return this.products;
    }

    @NotNull
    public final ShopBridgeProduct copy(@NotNull List<Product> list) {
        Intrinsics.checkParameterIsNotNull(list, "products");
        return new ShopBridgeProduct(list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.products, (java.lang.Object) ((kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct) r2).products) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct r2 = (kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct) r2
            java.util.List<kr.co.popone.fitts.model.product.Product> r0 = r1.products
            java.util.List<kr.co.popone.fitts.model.product.Product> r2 = r2.products
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            return r2
        L_0x0015:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List<Product> list = this.products;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShopBridgeProduct(products=");
        sb.append(this.products);
        sb.append(")");
        return sb.toString();
    }

    public ShopBridgeProduct(@NotNull List<Product> list) {
        Intrinsics.checkParameterIsNotNull(list, "products");
        this.products = list;
    }

    @NotNull
    public final List<Product> getProducts() {
        return this.products;
    }

    public final boolean hasItemAndUpdate(@NotNull WishStateUpdateEvent wishStateUpdateEvent) {
        Intrinsics.checkParameterIsNotNull(wishStateUpdateEvent, NotificationCompat.CATEGORY_EVENT);
        List<Product> list = this.products;
        ArrayList<Product> arrayList = new ArrayList<>();
        Iterator it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Product) next).getId() != wishStateUpdateEvent.getProductId()) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (Product inWishList : arrayList) {
            inWishList.setInWishList(wishStateUpdateEvent.isInWishList());
        }
        return true;
    }
}
