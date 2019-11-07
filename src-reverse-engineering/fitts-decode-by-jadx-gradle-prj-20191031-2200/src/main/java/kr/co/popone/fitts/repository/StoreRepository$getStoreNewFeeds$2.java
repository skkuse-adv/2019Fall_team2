package kr.co.popone.fitts.repository;

import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import org.jetbrains.annotations.NotNull;

final class StoreRepository$getStoreNewFeeds$2<T, R> implements Function<Throwable, SingleSource<? extends Triple<? extends String, ? extends SpecialDiscountInfo, ? extends List<? extends FeedItem>>>> {
    final /* synthetic */ Integer $limit;
    final /* synthetic */ StoreRepository this$0;

    StoreRepository$getStoreNewFeeds$2(StoreRepository storeRepository, Integer num) {
        this.this$0 = storeRepository;
        this.$limit = num;
    }

    @NotNull
    public final Single<Triple> apply(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
        return this.this$0.getStoreFeeds(AppSettingsData.STATUS_NEW, null, null, this.$limit).map(AnonymousClass1.INSTANCE);
    }
}
