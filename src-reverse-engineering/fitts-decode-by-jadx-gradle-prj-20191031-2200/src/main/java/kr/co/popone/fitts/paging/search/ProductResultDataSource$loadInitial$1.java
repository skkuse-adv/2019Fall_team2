package kr.co.popone.fitts.paging.search;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.remote.search.KeywordSearchProductResult;
import kr.co.popone.fitts.model.search.SearchResult.ProductSearchResult;
import kr.co.popone.fitts.model.search.SearchResult.SearchResultCount;

final class ProductResultDataSource$loadInitial$1<T> implements Consumer<KeywordSearchProductResult> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ ProductResultDataSource this$0;

    ProductResultDataSource$loadInitial$1(ProductResultDataSource productResultDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = productResultDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(KeywordSearchProductResult keywordSearchProductResult) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        this.this$0.isEmptyProducts().postValue(Boolean.valueOf(keywordSearchProductResult.getCount() < 1));
        List[] listArr = new List[2];
        listArr[0] = CollectionsKt__CollectionsJVMKt.listOf(new SearchResultCount(keywordSearchProductResult.getCount(), "개의 상품"));
        List<Product> products = keywordSearchProductResult.getProducts();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(products, 10));
        for (Product productSearchResult : products) {
            arrayList.add(new ProductSearchResult(productSearchResult));
        }
        listArr[1] = arrayList;
        this.$callback.onResult(CollectionsKt__IterablesKt.flatten(CollectionsKt__CollectionsKt.listOf(listArr)));
    }
}
