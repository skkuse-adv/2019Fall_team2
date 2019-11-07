package kr.co.popone.fitts.paging.search;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.remote.search.KeywordSearchProductResult;
import kr.co.popone.fitts.model.search.SearchResult.ProductSearchResult;

final class ProductResultDataSource$loadAfter$1<T> implements Consumer<KeywordSearchProductResult> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ ProductResultDataSource this$0;

    ProductResultDataSource$loadAfter$1(ProductResultDataSource productResultDataSource, LoadCallback loadCallback) {
        this.this$0 = productResultDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(KeywordSearchProductResult keywordSearchProductResult) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        LoadCallback loadCallback = this.$callback;
        List<Product> products = keywordSearchProductResult.getProducts();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(products, 10));
        for (Product productSearchResult : products) {
            arrayList.add(new ProductSearchResult(productSearchResult));
        }
        loadCallback.onResult(arrayList);
    }
}
