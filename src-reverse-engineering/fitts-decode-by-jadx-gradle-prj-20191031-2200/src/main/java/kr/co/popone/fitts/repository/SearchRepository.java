package kr.co.popone.fitts.repository;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.model.remote.search.KeywordSearchFittieResult;
import kr.co.popone.fitts.model.remote.search.KeywordSearchPostResult;
import kr.co.popone.fitts.model.remote.search.KeywordSearchProductResult;
import kr.co.popone.fitts.model.search.IntergratedSearchViewData;
import kr.co.popone.fitts.model.search.SearchAPI;
import kr.co.popone.fitts.model.search.SearchRecommendViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchRepository {
    private final SearchAPI searchAPI;

    public SearchRepository(@NotNull SearchAPI searchAPI2) {
        Intrinsics.checkParameterIsNotNull(searchAPI2, "searchAPI");
        this.searchAPI = searchAPI2;
    }

    @NotNull
    public final Single<KeywordSearchPostResult> getKeywordPostSearchList(@NotNull String str, @Nullable Long l, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        Single<KeywordSearchPostResult> observeOn = this.searchAPI.getPostSearchList(str, "post", l, num).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "searchAPI.getPostSearchL…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<KeywordSearchProductResult> getKeywordProductSearchList(@NotNull String str, @Nullable Long l, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        Single<KeywordSearchProductResult> observeOn = this.searchAPI.getProductSearchList(str, "product", l, num).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "searchAPI.getProductSear…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<KeywordSearchFittieResult> getKeywordFittieSearchList(@NotNull String str, @Nullable Long l, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        Single<KeywordSearchFittieResult> observeOn = this.searchAPI.getFittieSearchList(str, "user", l, num).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "searchAPI.getFittieSearc…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<SearchRecommendViewData> getRecommendSearchList() {
        Single<SearchRecommendViewData> map = this.searchAPI.getRecommendSearchList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(SearchRepository$getRecommendSearchList$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "searchAPI.getRecommendSe…n()\n                    }");
        return map;
    }

    @NotNull
    public final Single<IntergratedSearchViewData> getUnifiedSearchList(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        Single<IntergratedSearchViewData> observeOn = this.searchAPI.getUnifiedSearchList(str).subscribeOn(Schedulers.io()).map(SearchRepository$getUnifiedSearchList$1.INSTANCE).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "searchAPI.getUnifiedSear…dSchedulers.mainThread())");
        return observeOn;
    }
}
