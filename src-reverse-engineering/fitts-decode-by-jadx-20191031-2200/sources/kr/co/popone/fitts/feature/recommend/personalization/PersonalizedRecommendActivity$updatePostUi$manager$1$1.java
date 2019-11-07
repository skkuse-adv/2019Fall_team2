package kr.co.popone.fitts.feature.recommend.personalization;

import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;

public final class PersonalizedRecommendActivity$updatePostUi$manager$1$1 extends SpanSizeLookup {
    PersonalizedRecommendActivity$updatePostUi$manager$1$1() {
    }

    public int getSpanSize(int i) {
        return (i + 1) % 5 == 0 ? 2 : 1;
    }
}
