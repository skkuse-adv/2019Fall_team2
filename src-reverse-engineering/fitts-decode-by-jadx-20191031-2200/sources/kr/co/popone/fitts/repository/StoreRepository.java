package kr.co.popone.fitts.repository;

import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.Singles;
import io.reactivex.rxkotlin.SinglesKt;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.ShopBridgeFeed;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo.State;
import kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct;
import kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeTitleFeed;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.store.StoreAPI;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreRepository {
    private final StoreAPI storeAPI;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[State.values().length];

        static {
            $EnumSwitchMapping$0[State.OPEN.ordinal()] = 1;
            $EnumSwitchMapping$0[State.COMING_SOON.ordinal()] = 2;
        }
    }

    public StoreRepository(@NotNull StoreAPI storeAPI2) {
        Intrinsics.checkParameterIsNotNull(storeAPI2, "storeAPI");
        this.storeAPI = storeAPI2;
    }

    @NotNull
    public final Single<StoreInfo> postStoreInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Single<StoreInfo> observeOn = this.storeAPI.postStoreInfo(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "storeAPI.postStoreInfo(u…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<StoreInfo> getStoreDetailInfo(long j) {
        Single<StoreInfo> subscribeOn = this.storeAPI.getShopInfo(j).subscribeOn(Schedulers.io());
        Intrinsics.checkExpressionValueIsNotNull(subscribeOn, "storeAPI.getShopInfo(sto…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    @NotNull
    public final Single<List<FeedItem>> getStoreProducts(long j, @Nullable Long l, @Nullable Integer num) {
        Single<List<FeedItem>> map = this.storeAPI.getStoreProducts(j, l, num).subscribeOn(Schedulers.io()).map(new StoreRepository$sam$io_reactivex_functions_Function$0(new StoreRepository$getStoreProducts$1(this)));
        Intrinsics.checkExpressionValueIsNotNull(map, "storeAPI.getStoreProduct…ductsToShopBridgeProduct)");
        return map;
    }

    @NotNull
    public final Single<List<FeedItem>> getShopBridgeInfo(long j, @Nullable Long l, @Nullable Integer num) {
        Single<List<FeedItem>> map = SinglesKt.zipWith(getStoreDetailInfo(j), getStoreProducts(j, l, num)).map(new StoreRepository$sam$io_reactivex_functions_Function$0(new StoreRepository$getShopBridgeInfo$1(this)));
        Intrinsics.checkExpressionValueIsNotNull(map, "getStoreDetailInfo(store…   .map(::pariToFeedItem)");
        return map;
    }

    /* access modifiers changed from: private */
    public final List<FeedItem> pariToFeedItem(Pair<StoreInfo, ? extends List<? extends FeedItem>> pair) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(pair.getFirst());
        List<Feed> items = ((StoreInfo) pair.getFirst()).getItems();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(items, 10));
        for (Feed feedToShopBridgeFeed : items) {
            arrayList2.add(feedToShopBridgeFeed(((StoreInfo) pair.getFirst()).getStoreName(), feedToShopBridgeFeed));
        }
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable<? extends T>) arrayList2);
        StringBuilder sb = new StringBuilder();
        sb.append(((StoreInfo) pair.getFirst()).getStoreName());
        sb.append(" 전체 상품");
        arrayList.add(new ShopBridgeTitleFeed(sb.toString()));
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) pair.getSecond());
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final List<FeedItem> productsToShopBridgeProduct(List<Product> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList2.add((Product) next);
            if (arrayList2.size() == 2 || i == CollectionsKt__CollectionsKt.getLastIndex(list)) {
                arrayList.add(new ShopBridgeProduct(CollectionsKt__IterablesKt.flatten(CollectionsKt__CollectionsJVMKt.listOf(arrayList2))));
                arrayList2.clear();
            }
            i = i2;
        }
        return arrayList;
    }

    private final ShopBridgeFeed feedToShopBridgeFeed(String str, Feed feed) {
        return new ShopBridgeFeed(str, feed);
    }

    @NotNull
    public final Single<List<StoreInfo>> getShopBookmarkList(@Nullable Long l, @Nullable Integer num) {
        Single<List<StoreInfo>> subscribeOn = this.storeAPI.getShopBookmarkList(l, num).subscribeOn(Schedulers.io());
        Intrinsics.checkExpressionValueIsNotNull(subscribeOn, "storeAPI.getShopBookmark…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    @NotNull
    public final Completable addShopBookmark(long j) {
        Completable observeOn = this.storeAPI.postShopBookmark(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "storeAPI.postShopBookmar…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Completable deleteShopBookmark(long j) {
        Completable observeOn = this.storeAPI.deleteShopBookmark(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "storeAPI.deleteShopBookm…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<FeedInfo> getStoreFeeds(@NotNull String str, @Nullable String str2, @Nullable Long l, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Single<FeedInfo> observeOn = this.storeAPI.getStoreHomeFeeds(str, str2, l, num).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "storeAPI.getStoreHomeFee…dSchedulers.mainThread())");
        return observeOn;
    }

    private final Single<SpecialDiscountInfo> getSpecialDiscountFeeds() {
        return this.storeAPI.getSpecialDiscountEvents();
    }

    @NotNull
    public final Single<Triple<String, SpecialDiscountInfo, List<FeedItem>>> getStoreNewFeeds(@Nullable Integer num) {
        Singles singles = Singles.INSTANCE;
        Single zip = Single.zip(getSpecialDiscountFeeds(), getStoreFeeds(AppSettingsData.STATUS_NEW, null, null, num), new StoreRepository$getStoreNewFeeds$$inlined$zip$1());
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, BiFun…-> zipper.invoke(t, u) })");
        Single<Triple<String, SpecialDiscountInfo, List<FeedItem>>> onErrorResumeNext = zip.onErrorResumeNext((Function<? super Throwable, ? extends SingleSource<? extends T>>) new StoreRepository$getStoreNewFeeds$2<Object,Object>(this, num));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "Singles.zip(getSpecialDi…ll, it.items) }\n        }");
        return onErrorResumeNext;
    }
}
