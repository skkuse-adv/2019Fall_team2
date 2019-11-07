package kr.co.popone.fitts.feature.collection;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import java.util.Collection;
import java.util.List;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;

final class PostCollectionActivity$loadListData$1<T1, T2> implements BiConsumer<List<? extends CollectionEntry>, Throwable> {
    final /* synthetic */ PostCollectionActivity this$0;

    PostCollectionActivity$loadListData$1(PostCollectionActivity postCollectionActivity) {
        this.this$0 = postCollectionActivity;
    }

    public final void accept(List<CollectionEntry> list, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("{list: ");
        sb.append(list);
        sb.append(", error: ");
        sb.append(th);
        sb.append('}');
        String sb2 = sb.toString();
        boolean z = false;
        Logger.d(sb2, new Object[0]);
        PostCollectionActivity.access$getCollectionAdapter$p(this.this$0).setShowsLoading(false);
        this.this$0.collectionItemsRequest = null;
        if (list != null) {
            PostCollectionAdapter access$getCollectionAdapter$p = PostCollectionActivity.access$getCollectionAdapter$p(this.this$0);
            access$getCollectionAdapter$p.setCollectionItems(CollectionsKt___CollectionsKt.plus((Collection<? extends T>) access$getCollectionAdapter$p.getCollectionItems(), (Iterable<? extends T>) list));
            PostCollectionActivity postCollectionActivity = this.this$0;
            if (list.size() >= 20) {
                z = true;
            }
            postCollectionActivity.canLoadMore = z;
        }
    }
}
