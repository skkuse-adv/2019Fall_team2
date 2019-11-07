package kr.co.popone.fitts.feature.collection;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import java.util.Collection;
import java.util.List;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;

final class PromotionCollectionActivity$loadListData$1<T1, T2> implements BiConsumer<List<? extends CollectionEntry>, Throwable> {
    final /* synthetic */ PromotionCollectionActivity this$0;

    PromotionCollectionActivity$loadListData$1(PromotionCollectionActivity promotionCollectionActivity) {
        this.this$0 = promotionCollectionActivity;
    }

    public final void accept(List<CollectionEntry> list, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("list {list: ");
        sb.append(list);
        sb.append(", error: ");
        sb.append(th);
        sb.append('}');
        String sb2 = sb.toString();
        boolean z = false;
        Logger.d(sb2, new Object[0]);
        this.this$0.collectionItemsRequest = null;
        PromotionCollectionActivity.access$getCollectionAdapter$p(this.this$0).setShowsLoading(false);
        if (list != null) {
            PromotionCollectionAdapter access$getCollectionAdapter$p = PromotionCollectionActivity.access$getCollectionAdapter$p(this.this$0);
            access$getCollectionAdapter$p.setCollectionItems(CollectionsKt___CollectionsKt.plus((Collection<? extends T>) access$getCollectionAdapter$p.getCollectionItems(), (Iterable<? extends T>) list));
            PromotionCollectionActivity promotionCollectionActivity = this.this$0;
            if (list.size() >= 20) {
                z = true;
            }
            promotionCollectionActivity.canLoadMore = z;
        }
    }
}
