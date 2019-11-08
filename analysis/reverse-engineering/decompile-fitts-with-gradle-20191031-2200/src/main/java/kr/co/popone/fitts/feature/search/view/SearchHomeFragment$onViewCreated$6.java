package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.HotStyleDetailAdapter;
import kr.co.popone.fitts.model.search.StyleRecommendViewData;

final class SearchHomeFragment$onViewCreated$6<T> implements Observer<List<? extends StyleRecommendViewData>> {
    final /* synthetic */ HotStyleDetailAdapter $hotStyleAdapter;

    SearchHomeFragment$onViewCreated$6(HotStyleDetailAdapter hotStyleDetailAdapter) {
        this.$hotStyleAdapter = hotStyleDetailAdapter;
    }

    public final void onChanged(List<StyleRecommendViewData> list) {
        HotStyleDetailAdapter hotStyleDetailAdapter = this.$hotStyleAdapter;
        Intrinsics.checkExpressionValueIsNotNull(list, "it");
        hotStyleDetailAdapter.setItems(list);
    }
}
