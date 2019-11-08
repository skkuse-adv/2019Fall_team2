package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState;
import kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState.InvalidState;
import org.jetbrains.annotations.NotNull;

final class JoinActivity$checkValidInvitationCode$2<T, R> implements Function<Throwable, RecommenderCheckState> {
    public static final JoinActivity$checkValidInvitationCode$2 INSTANCE = new JoinActivity$checkValidInvitationCode$2();

    JoinActivity$checkValidInvitationCode$2() {
    }

    @NotNull
    public final InvalidState apply(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
        return InvalidState.INSTANCE;
    }
}
