package kr.co.popone.fitts.model.search;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPIKt;
import kr.co.popone.fitts.model.product.ProductEntityExtensionKt;
import kr.co.popone.fitts.model.search.SearchAPI.RecommendStyle;
import kr.co.popone.fitts.model.search.SearchAPI.SearchRecommend;
import kr.co.popone.fitts.model.search.SearchAPI.UnifiedSearch;
import kr.co.popone.fitts.model.user.UserAPIKt;
import org.jetbrains.annotations.NotNull;

public final class SearchAPIKt {
    @NotNull
    public static final SearchRecommendViewData convertToDomain(@NotNull SearchRecommend searchRecommend) {
        Intrinsics.checkParameterIsNotNull(searchRecommend, "receiver$0");
        return new SearchRecommendViewData(searchRecommend.getSearchKeywords(), convertToDomain(searchRecommend.getRecommendStyles()));
    }

    @NotNull
    public static final StyleRecommendViewData convertToDomain(@NotNull RecommendStyle recommendStyle) {
        Intrinsics.checkParameterIsNotNull(recommendStyle, "receiver$0");
        return new StyleRecommendViewData(recommendStyle.getStyle(), recommendStyle.getImageUrl());
    }

    @NotNull
    public static final IntergratedSearchViewData convetToDomain(@NotNull UnifiedSearch unifiedSearch) {
        Intrinsics.checkParameterIsNotNull(unifiedSearch, "receiver$0");
        IntergratedSearchViewData intergratedSearchViewData = new IntergratedSearchViewData(PostAPIKt.mapToDomain(unifiedSearch.getPosts()), UserAPIKt.mapToFittieFollowViewDataList(unifiedSearch.getUsers()), ProductEntityExtensionKt.mapToDomain(unifiedSearch.getProducts()), unifiedSearch.getStore(), new HasMoreInfo(unifiedSearch.getHasMore().getHasMorePost(), unifiedSearch.getHasMore().getHasMoreProduct(), unifiedSearch.getHasMore().getHasMoreUser()));
        return intergratedSearchViewData;
    }

    @NotNull
    public static final List<StyleRecommendViewData> convertToDomain(@NotNull List<RecommendStyle> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (RecommendStyle convertToDomain : list) {
            arrayList.add(convertToDomain(convertToDomain));
        }
        return arrayList;
    }
}
