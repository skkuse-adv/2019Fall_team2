package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.search.IntergratedSearchViewData;
import kr.co.popone.fitts.model.search.SearchAPI.UnifiedSearch;
import kr.co.popone.fitts.model.search.SearchAPIKt;
import org.jetbrains.annotations.NotNull;

final class SearchRepository$getUnifiedSearchList$1<T, R> implements Function<T, R> {
    public static final SearchRepository$getUnifiedSearchList$1 INSTANCE = new SearchRepository$getUnifiedSearchList$1();

    SearchRepository$getUnifiedSearchList$1() {
    }

    @NotNull
    public final IntergratedSearchViewData apply(@NotNull UnifiedSearch unifiedSearch) {
        Intrinsics.checkParameterIsNotNull(unifiedSearch, "it");
        return SearchAPIKt.convetToDomain(unifiedSearch);
    }
}
