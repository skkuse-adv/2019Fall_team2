package kr.co.popone.fitts.feature.search.adapter;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.search.SearchResult;
import org.jetbrains.annotations.NotNull;

public final class PostResultAdapter$Companion$COMPARATOR$1 extends ItemCallback<SearchResult> {
    public boolean areContentsTheSame(@NotNull SearchResult searchResult, @NotNull SearchResult searchResult2) {
        Intrinsics.checkParameterIsNotNull(searchResult, "oldItem");
        Intrinsics.checkParameterIsNotNull(searchResult2, "newItem");
        return false;
    }

    public boolean areItemsTheSame(@NotNull SearchResult searchResult, @NotNull SearchResult searchResult2) {
        Intrinsics.checkParameterIsNotNull(searchResult, "oldItem");
        Intrinsics.checkParameterIsNotNull(searchResult2, "newItem");
        return false;
    }

    PostResultAdapter$Companion$COMPARATOR$1() {
    }
}
