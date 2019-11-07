package kr.co.popone.fitts.viewmodel.store.bridge;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource.Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.paging.store.bridge.StoreBridgeDataSouceFactory;
import org.jetbrains.annotations.NotNull;

final class ShopBridgeViewModel$$special$$inlined$run$lambda$1 extends Lambda implements Function0<LiveData<PagedList<FeedItem>>> {
    final /* synthetic */ StoreBridgeDataSouceFactory $this_run;
    final /* synthetic */ ShopBridgeViewModel this$0;

    ShopBridgeViewModel$$special$$inlined$run$lambda$1(StoreBridgeDataSouceFactory storeBridgeDataSouceFactory, ShopBridgeViewModel shopBridgeViewModel) {
        this.$this_run = storeBridgeDataSouceFactory;
        this.this$0 = shopBridgeViewModel;
        super(0);
    }

    @NotNull
    public final LiveData<PagedList<FeedItem>> invoke() {
        LiveData<PagedList<FeedItem>> build = new LivePagedListBuilder((Factory<Key, Value>) this.$this_run, this.this$0.getPageConfig()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "LivePagedListBuilder(thi… getPageConfig()).build()");
        return build;
    }
}
