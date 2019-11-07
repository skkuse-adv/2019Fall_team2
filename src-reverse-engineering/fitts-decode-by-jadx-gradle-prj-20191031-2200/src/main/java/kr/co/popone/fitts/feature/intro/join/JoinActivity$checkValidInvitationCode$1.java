package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState;
import kr.co.popone.fitts.model.datamodel.service.user.Recommender;
import org.jetbrains.annotations.NotNull;

final class JoinActivity$checkValidInvitationCode$1<T, R> implements Function<T, R> {
    final /* synthetic */ String $fittsId;
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$checkValidInvitationCode$1(JoinActivity joinActivity, String str) {
        this.this$0 = joinActivity;
        this.$fittsId = str;
    }

    @NotNull
    public final RecommenderCheckState apply(@NotNull Recommender recommender) {
        Intrinsics.checkParameterIsNotNull(recommender, "it");
        return this.this$0.handleRecommenderResult(this.$fittsId, recommender.isRecommender());
    }
}
