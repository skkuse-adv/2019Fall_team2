package kr.co.popone.fitts.feature.search.adapter;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.BasePagedListAdapter;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.ProductRectangleFeedHolder;
import kr.co.popone.fitts.feature.search.holder.SearchHeaderHolder;
import kr.co.popone.fitts.model.search.SearchResult;
import kr.co.popone.fitts.model.search.SearchResult.ProductSearchResult;
import kr.co.popone.fitts.model.search.SearchResult.SearchResultCount;
import org.jetbrains.annotations.NotNull;

public final class ProductSearchResultAdapter extends BasePagedListAdapter<SearchResult, BaseViewHolder> {
    private static final ProductSearchResultAdapter$Companion$COMPARATOR$1 COMPARATOR = new ProductSearchResultAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.ProductRectangleFeedHolder.Delegate {
    }

    public ProductSearchResultAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public BaseViewHolder onCreateViewHolderWithoutLoading(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == ProductRectangleFeedHolder.Companion.getId()) {
            return ProductRectangleFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == SearchHeaderHolder.Companion.getId()) {
            return SearchHeaderHolder.Companion.create(viewGroup);
        }
        throw new IllegalAccessException("type not founded");
    }

    public void onBindViewHolderWithoutLoading(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        SearchResult searchResult = (SearchResult) getItem(i);
        if (baseViewHolder instanceof ProductRectangleFeedHolder) {
            if (searchResult instanceof ProductSearchResult) {
                BaseViewHolder.bind$default(baseViewHolder, ((ProductSearchResult) searchResult).getProduct(), null, 2, null);
            }
        } else if ((baseViewHolder instanceof SearchHeaderHolder) && (searchResult instanceof SearchResultCount)) {
            BaseViewHolder.bind$default(baseViewHolder, searchResult, null, 2, null);
        }
    }

    public int getItemViewTypeWithoutLoading(int i) {
        if (((SearchResult) getItem(i)) instanceof ProductSearchResult) {
            return ProductRectangleFeedHolder.Companion.getId();
        }
        return SearchHeaderHolder.Companion.getId();
    }

    public final int getSpanSize(int i) {
        return getItemViewType(i) == ProductRectangleFeedHolder.Companion.getId() ? 1 : 3;
    }
}
