package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.search.SearchAPI.SearchRecommend;
import kr.co.popone.fitts.model.search.SearchAPIKt;
import kr.co.popone.fitts.model.search.SearchRecommendViewData;
import org.jetbrains.annotations.NotNull;

final class SearchRepository$getRecommendSearchList$1<T, R> implements Function<T, R> {
    public static final SearchRepository$getRecommendSearchList$1 INSTANCE = new SearchRepository$getRecommendSearchList$1();

    SearchRepository$getRecommendSearchList$1() {
    }

    @NotNull
    public final SearchRecommendViewData apply(@NotNull SearchRecommend searchRecommend) {
        Intrinsics.checkParameterIsNotNull(searchRecommend, "it");
        return SearchAPIKt.convertToDomain(searchRecommend);
    }
}
