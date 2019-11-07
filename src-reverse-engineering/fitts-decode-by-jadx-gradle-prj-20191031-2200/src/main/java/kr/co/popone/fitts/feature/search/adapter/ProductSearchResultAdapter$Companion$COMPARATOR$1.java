package kr.co.popone.fitts.feature.search.adapter;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.search.SearchResult;
import kr.co.popone.fitts.model.search.SearchResult.ProductSearchResult;
import org.jetbrains.annotations.NotNull;

public final class ProductSearchResultAdapter$Companion$COMPARATOR$1 extends ItemCallback<SearchResult> {
    ProductSearchResultAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull SearchResult searchResult, @NotNull SearchResult searchResult2) {
        Intrinsics.checkParameterIsNotNull(searchResult, "oldItem");
        Intrinsics.checkParameterIsNotNull(searchResult2, "newItem");
        if (!(searchResult instanceof ProductSearchResult) || !(searchResult2 instanceof ProductSearchResult) || ((ProductSearchResult) searchResult).getProduct().getId() != ((ProductSearchResult) searchResult2).getProduct().getId()) {
            return false;
        }
        return true;
    }

    public boolean areContentsTheSame(@NotNull SearchResult searchResult, @NotNull SearchResult searchResult2) {
        Intrinsics.checkParameterIsNotNull(searchResult, "oldItem");
        Intrinsics.checkParameterIsNotNull(searchResult2, "newItem");
        if (!(searchResult instanceof ProductSearchResult) || !(searchResult2 instanceof ProductSearchResult) || ((ProductSearchResult) searchResult).getProduct().getId() != ((ProductSearchResult) searchResult2).getProduct().getId()) {
            return false;
        }
        return true;
    }
}
