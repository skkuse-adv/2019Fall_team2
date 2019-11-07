package kr.co.popone.fitts.feature.recommend.personalization;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation;

final class PersonalizedRecommendActivity$getPersonalizedrecommendListRequest$1<T1, T2> implements BiConsumer<PersonalRecommendation, Throwable> {
    final /* synthetic */ PersonalizedRecommendActivity this$0;

    PersonalizedRecommendActivity$getPersonalizedrecommendListRequest$1(PersonalizedRecommendActivity personalizedRecommendActivity) {
        this.this$0 = personalizedRecommendActivity;
    }

    public final void accept(PersonalRecommendation personalRecommendation, Throwable th) {
        this.this$0.updatePersonalizedRecommendUi(personalRecommendation, th);
    }
}
