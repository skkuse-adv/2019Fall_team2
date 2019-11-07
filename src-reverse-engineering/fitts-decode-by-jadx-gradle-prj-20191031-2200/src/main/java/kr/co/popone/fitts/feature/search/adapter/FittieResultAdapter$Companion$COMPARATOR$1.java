package kr.co.popone.fitts.feature.search.adapter;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.search.SearchResult;
import kr.co.popone.fitts.model.search.SearchResult.FittieSearchResult;
import org.jetbrains.annotations.NotNull;

public final class FittieResultAdapter$Companion$COMPARATOR$1 extends ItemCallback<SearchResult> {
    FittieResultAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull SearchResult searchResult, @NotNull SearchResult searchResult2) {
        Intrinsics.checkParameterIsNotNull(searchResult, "oldItem");
        Intrinsics.checkParameterIsNotNull(searchResult2, "newItem");
        if (!(searchResult instanceof FittieSearchResult) || !(searchResult2 instanceof FittieSearchResult) || ((FittieSearchResult) searchResult).getUser().getId() != ((FittieSearchResult) searchResult2).getUser().getId()) {
            return false;
        }
        return true;
    }

    public boolean areContentsTheSame(@NotNull SearchResult searchResult, @NotNull SearchResult searchResult2) {
        Intrinsics.checkParameterIsNotNull(searchResult, "oldItem");
        Intrinsics.checkParameterIsNotNull(searchResult2, "newItem");
        if (!(searchResult instanceof FittieSearchResult) || !(searchResult2 instanceof FittieSearchResult) || ((FittieSearchResult) searchResult).getUser().getId() != ((FittieSearchResult) searchResult2).getUser().getId()) {
            return false;
        }
        return true;
    }
}
